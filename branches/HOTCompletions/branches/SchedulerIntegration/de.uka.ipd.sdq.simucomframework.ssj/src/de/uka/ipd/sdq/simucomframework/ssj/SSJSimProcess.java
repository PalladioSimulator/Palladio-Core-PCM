/**
 * 
 */
package de.uka.ipd.sdq.simucomframework.ssj;

import org.apache.commons.javaflow.Continuation;
import org.apache.log4j.Logger;

import umontreal.iro.lecuyer.simevents.Event;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimProcessDelegate;
import umontreal.iro.lecuyer.simevents.Simulator;

class Lock {
	boolean available;
	
	public Lock(boolean initiallyAvailable){
		this.available = initiallyAvailable;
	}
	
	public synchronized void take() throws InterruptedException {
		if (available) {
			available = false;
			return;
		}
		synchronized(this){
			this.wait();
		}
		available = false;
	}
	
	public synchronized void release() {
		available = true;
		this.notifyAll();
	}

	public void takeUninteruppted() {
		try{
			take();
		} catch (InterruptedException e){
			throw new RuntimeException("Failed taking lock",e);
		}
	}
}

enum ProcessState {
	READY,
	SUSPENDED,
	RUNNING,
	TERMINATED
}

/**
 * @author Snowball
 *
 */
public class SSJSimProcess implements ISimProcessDelegate {

	private static Logger logger = 
		Logger.getLogger(SSJSimProcess.class.getName());

	de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimProcess myAbstractProcess = null;

	Lock waitingSemaphore = new Lock(false);
	Lock waitingForSuspendSemaphore = new Lock(false);

	private ProcessState myProcessState = ProcessState.READY;
	private Simulator sim;
	private Runnable myRunnable = null;
	private Thread myThread = null;
	private Continuation thisThreadsContinuation = null;
	
	private static final boolean IS_USING_THREADS = true;

	
	public SSJSimProcess(de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimProcess myProcess, String name) {
		this.sim = ((SSJExperiment)myProcess.getModel().getSimulationControl()).getSimulator();
		this.myAbstractProcess = myProcess;
		this.myRunnable = new Runnable(){

			public void run() {
				logger.debug("Starting sim process [ID: "+SSJSimProcess.this.myAbstractProcess.getId()+"]");
				SSJSimProcess.this.actions();
				SSJSimProcess.this.myThread = null;
				// Jens: fireTerminated has to be called before 
				// the process is removed from the simulation. 
				// Otherwise, the race condition remains 
				// --> now called in method "lifeCycle". 
			}
			
		};
		if (IS_USING_THREADS) {
			this.myThread = new Thread(this.myRunnable);
			this.myThread.start();
			waitingForSuspendSemaphore.takeUninteruppted();
		} else {
			// This lets the thread run until it suspends or terminates and stores its state in thisThreadsContinuation
			thisThreadsContinuation = Continuation.startWith(this.myRunnable);
		}
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimProcessDelegate#hold(double)
	 */
	public void hold(double d) {
		if (this.myProcessState != ProcessState.RUNNING)
			throw new IllegalStateException("Tried to hold non-running process ["+this.myAbstractProcess.getId()+"]");
		
		logger.debug("Holding running process (ID: "+this.myAbstractProcess.getId()+") for "+d);
		
		new Event(sim) {

			@Override
			public void actions() {
				resume();
			}
			
		}.schedule(d);
		suspend();
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimProcessDelegate#scheduleAt(double)
	 */
	public void scheduleAt(double d) {
		if (this.myProcessState != ProcessState.SUSPENDED)
			throw new IllegalStateException("Tried to schedule thread which was not suspended ["+this.myAbstractProcess.getId()+"]");
		
		new Event(sim) {

			@Override
			public void actions() {
				if (myProcessState != ProcessState.TERMINATED){
					resume();
				}
			}
			
		}.schedule(d);
	}

	public void actions() {
		this.myProcessState = ProcessState.RUNNING;

		// start suspended
		suspend();
		myAbstractProcess.lifeCycle();
		
		// This process is done and will not suspend any more...
		// Hence, release its wait for suspend semaphore
		this.myProcessState = ProcessState.TERMINATED;
		if (IS_USING_THREADS) {
			this.waitingForSuspendSemaphore.release();
		} else {
			Continuation.suspend();
		}
	}

	public boolean isTerminated() {
		return this.myProcessState == ProcessState.TERMINATED;
	}

	public void passivate() {
		if (this.myProcessState != ProcessState.RUNNING)
			throw new IllegalStateException("Tried to passivate non-running process ["+this.myAbstractProcess.getId()+"]");
		suspend();
	}
	
	private void suspend() {
		if (this.myProcessState != ProcessState.RUNNING)
			throw new IllegalStateException("Tried to suspend non-running process ["+this.myAbstractProcess.getId()+"]");
		
		logger.debug("Suspending thread ["+this.myAbstractProcess.getId()+"]");
		this.myProcessState = ProcessState.SUSPENDED;
		if (IS_USING_THREADS){
			waitingForSuspendSemaphore.release();
			waitingSemaphore.takeUninteruppted();
		} else {
			logger.debug("Before Continuation.suspend()");
			Continuation.suspend();
			logger.debug("After Continuation.suspend()");
		}
		this.myProcessState = ProcessState.RUNNING;
	}

	private void resume() {
		if (this.myProcessState != ProcessState.SUSPENDED)
			throw new IllegalStateException("Tried to resume thread which was not suspended ["+this.myAbstractProcess.getId()+"]");

		logger.debug("Resuming thread ["+this.myAbstractProcess.getId()+"]");
		this.myProcessState = ProcessState.RUNNING;
		if (IS_USING_THREADS) {
			waitingSemaphore.release();
			waitingForSuspendSemaphore.takeUninteruppted();
		} else {
			thisThreadsContinuation = Continuation.continueWith(thisThreadsContinuation);
		}

		// In case of in-between termination, do not set the state back to suspended
		if (this.myProcessState == ProcessState.RUNNING) {
			this.myProcessState = ProcessState.SUSPENDED;
		}
	}

}
