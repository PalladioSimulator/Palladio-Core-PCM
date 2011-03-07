package de.uka.ipd.sdq.probespec.framework.concurrency;

import java.util.ArrayList;

/**
 * Maintains a list of threads that has been spawned by the ProbeSpecification.
 * This allows for stopping all running threads at once by using
 * {@link #stopThreads()}.
 * <p>
 * The ThreadManager gets aware of new threads only when threads are spawned
 * using {@link #startThread(StoppableRunnable, String)}, which is the
 * recommended approach.
 * 
 * @author Philipp Merkle
 * 
 */
public class ThreadManager {

	private ArrayList<RunnableThreadPair> runnableThreadList;

	public ThreadManager() {
		runnableThreadList = new ArrayList<RunnableThreadPair>();
	}

	/**
	 * Creates a thread using the specified runnable and starts execution.
	 * All threads started that way can be stopped at once by using
	 * {@link #stopThreads()}.
	 * 
	 * @param runnable
	 * @param threadName
	 */
	public void startThread(StoppableRunnable runnable, String threadName) {
		Thread thread = new Thread(runnable);
		runnableThreadList.add(new RunnableThreadPair(runnable, thread));
		thread.setName(threadName);
		thread.start();
	}

	/**
	 * Stops all threads that has been started using
	 * {@link #startThread(StoppableRunnable, String)} and waits for their
	 * termination.
	 */
	public void stopThreads() {
		for (RunnableThreadPair p : runnableThreadList) {
			p.getRunnable().stop();
		}

		for (RunnableThreadPair p : runnableThreadList) {
			// Wait for the thread to finish
			try {
				// TODO: maybe use join with parameter in order to avoid waiting
				// forever
				p.getThread().join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// all threads have stopped, we don't need the thread list anymore
		runnableThreadList.clear();
	}

	/**
	 * (StoppableRunnable, Thread)-Pair
	 */
	private class RunnableThreadPair {

		private StoppableRunnable runnable;

		private Thread thread;

		public RunnableThreadPair(StoppableRunnable runnable, Thread thread) {
			this.runnable = runnable;
			this.thread = thread;
		}

		public StoppableRunnable getRunnable() {
			return runnable;
		}

		public Thread getThread() {
			return thread;
		}

	}
	
}
