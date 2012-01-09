package de.uka.ipd.sdq.probespec.framework.concurrency;

import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.probespec.framework.ProbeSetAndRequestContext;
import de.uka.ipd.sdq.probespec.framework.ProbeSetSample;
import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probespec.framework.RequestContext;
import de.uka.ipd.sdq.probespec.framework.SampleBlackboard;

/**
 * Extends the sample blackboard by concurrency. By using this blackboard the
 * thread adding samples to the blackboard gets decoupled from the processing of
 * that samples within the blackboard. This is reached by means of a queue. When
 * adding a sample it is enqueued and the adding thread can immediately proceed
 * without waiting for the sample to be processed. The processing of the sample
 * is conducted within a (single) other thread, whose only purpose is to process
 * these samples.
 * 
 * @author Philipp Merkle
 * 
 */
public class ConcurrentSampleBlackboard extends SampleBlackboard {

	private static Logger logger = Logger.getLogger(ConcurrentSampleBlackboard.class.getName());
	
	private LinkedBlockingQueue<QueuedAction> sampleQueue;
	private ThreadManager threadManager;
	private boolean running;

    public ConcurrentSampleBlackboard(ThreadManager threadManager) {
        this.sampleQueue = new LinkedBlockingQueue<QueuedAction>();
        this.threadManager = threadManager;
    }

	private void delegateAddSample(ProbeSetSample pss) {
		super.addSample(pss);
	}

	private void delegateDeleteSamplesInRequestContext(
			RequestContext requestContext) {
		super.deleteSamplesInRequestContext(requestContext);
	}

	private void delegateDeleteSample(ProbeSetAndRequestContext pss) {
		super.deleteSample(pss);
	}

	/**
	 * Adds a sample to the blackboard. The sample is enqueued as long as the
	 * queue does not overrun. Then the calling thread can proceed immediately.
	 * However when the queue overruns, the calling thread gets blocked until
	 * the queue is ready to carry the sample.
	 * <p>
	 * Notice: The sample will be not available at the blackboard until it is
	 * processed.
	 * 
	 * @param pss
	 *            the sample
	 */
	@Override
	public void addSample(ProbeSetSample pss) {
	    checkRunning();	    	    
		try {
			sampleQueue.put(new AddSampleAction(pss));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Deletes all samples taken within the specified {@link RequestContext}.
	 * The deletion request is enqueued as long as the queue does not overrun.
	 * Then the calling thread can proceed immediately. However when the queue
	 * overruns, the calling thread gets blocked until the queue is ready to
	 * carry the request.
	 * 
	 * @param requestContext
	 *            the RequestContext whose samples are to be deleted
	 */
	@Override
	public void deleteSamplesInRequestContext(RequestContext requestContext) {
	    checkRunning();
		try {
			sampleQueue.put(new DeleteSamplesInRequestContextAction(
					requestContext));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Deletes the specified sample. The deletion request is enqueued as long as
	 * the queue does not overrun. Then the calling thread can proceed
	 * immediately. However when the queue overruns, the calling thread gets
	 * blocked until the queue is ready to carry the request.
	 * 
	 * @param requestContext
	 *            the samples
	 */
	@Override
	public void deleteSample(ProbeSetAndRequestContext pss) {
	    checkRunning();
		try {
			sampleQueue.put(new DeleteSampleAction(pss));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private synchronized void checkRunning() {
        if (!running) {
            running = true;
            threadManager.startThread(new ProcessQueuedActions(), "ProbeSpec Concurrent Blackboard");
        }
	}

	/**
	 * This runnable will be used for the thread processing the samples and
	 * requests in the queue.
	 */
	private class ProcessQueuedActions implements StoppableRunnable {

		private boolean keepRunning = true;

		@Override
		public void run() {
			while (keepRunning || !sampleQueue.isEmpty()) {
				try {
					sampleQueue.take().execute();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			logger.debug("Runnable " + this.getClass().getSimpleName()
					+ " stopped running");
		}

		@Override
		public void stop() {
			keepRunning = false;
			if (sampleQueue.isEmpty()) {
				try {
					sampleQueue.put(new ShutdownQueueAction());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * A queued action encapsulates some actions that can be added to a queue.
	 */
	private interface QueuedAction {

		public void execute();

	}

	/**
	 * This action does nothing and can be used to shutdown the thread
	 * processing queue entries.
	 */
	private class ShutdownQueueAction implements QueuedAction {

		@Override
		public void execute() {
			// Nothing to do
		}

	}

	/**
	 * Adds a sample to the blackboard.
	 */
	private class AddSampleAction implements QueuedAction {

		private ProbeSetSample pss;

		public AddSampleAction(ProbeSetSample pss) {
			this.pss = pss;
		}

		@Override
		public void execute() {
			delegateAddSample(pss);
		}

	}

	private class DeleteSamplesInRequestContextAction implements QueuedAction {

		private RequestContext requestContext;

		public DeleteSamplesInRequestContextAction(RequestContext requestContext) {
			this.requestContext = requestContext;
		}

		@Override
		public void execute() {
			delegateDeleteSamplesInRequestContext(requestContext);
		}

	}

	private class DeleteSampleAction implements QueuedAction {

		private ProbeSetAndRequestContext pss;

		public DeleteSampleAction(ProbeSetAndRequestContext pss) {
			this.pss = pss;
		}

		@Override
		public void execute() {
			delegateDeleteSample(pss);
        }

    }

}
