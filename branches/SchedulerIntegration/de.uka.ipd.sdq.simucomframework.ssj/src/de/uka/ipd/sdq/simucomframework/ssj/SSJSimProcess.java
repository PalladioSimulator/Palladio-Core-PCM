/**
 * 
 */
package de.uka.ipd.sdq.simucomframework.ssj;

import java.util.concurrent.Semaphore;

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

	de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimProcess myAbstractProcess = null;
//	Semaphore waitingSemaphore = new Semaphore(0,true);
//	Semaphore waitingForSuspendSemaphore = new Semaphore(0,true);
	Lock waitingSemaphore = new Lock(false);
	Lock waitingForSuspendSemaphore = new Lock(false);
	private ProcessState myProcessState = ProcessState.READY;
	private Simulator sim;
	private Thread myThread;
	
	public SSJSimProcess(de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimProcess myProcess, String name) {
		// super(((SSJExperiment)myProcess.getModel().getSimulationControl()).getSimulator());		
		this.sim = ((SSJExperiment)myProcess.getModel().getSimulationControl()).getSimulator();
		this.myAbstractProcess = myProcess;
		this.myThread = new Thread(new Runnable(){

			public void run() {
				SSJSimProcess.this.actions();
				SSJSimProcess.this.myThread = null;
				// Jens: fireTerminated has to be called before 
				// the process is removed from the simulation. 
				// Otherwise, the race condition remains 
				// --> now called in method "lifeCycle". 
				waitingForSuspendSemaphore.release();
			}
			
		});
		this.myThread.start();
		waitingForSuspendSemaphore.takeUninteruppted();
		//this.waitingForSuspendSemaphore.acquireUninterruptibly();
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimProcessDelegate#hold(double)
	 */
	public void hold(double d) {
		if (this.myProcessState != ProcessState.RUNNING)
			throw new IllegalStateException("Tried to hold non-running process");
		
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
			throw new IllegalStateException("Tried to schedule thread which was not suspended");
		
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
		this.waitingForSuspendSemaphore.release();
		this.myProcessState = ProcessState.TERMINATED;
	}

	public boolean isTerminated() {
		return this.myProcessState == ProcessState.TERMINATED;
	}

	public void passivate() {
		if (this.myProcessState != ProcessState.RUNNING)
			throw new IllegalStateException("Tried to passivate non-running process");
		suspend();
	}
	
	private void suspend() {
		if (this.myProcessState != ProcessState.RUNNING)
			throw new IllegalStateException("Tried to suspend non-running process");
		this.myProcessState = ProcessState.SUSPENDED;
		waitingForSuspendSemaphore.release();
		// SSJSimProcess.this.waitingForSuspendSemaphore.release();
		waitingSemaphore.takeUninteruppted();
		// SSJSimProcess.this.waitingSemaphore.acquireUninterruptibly();
		this.myProcessState = ProcessState.RUNNING;
	}

	private void resume() {
		if (this.myProcessState != ProcessState.SUSPENDED)
			throw new IllegalStateException("Tried to resume thread which was not suspended");
		this.myProcessState = ProcessState.RUNNING;
		//SSJSimProcess.this.waitingSemaphore.release();
		//SSJSimProcess.this.waitingForSuspendSemaphore.acquireUninterruptibly();

		waitingSemaphore.release();
		// SSJSimProcess.this.waitingSemaphore.acquireUninterruptibly();

		waitingForSuspendSemaphore.takeUninteruppted();
		// SSJSimProcess.this.waitingForSuspendSemaphore.release();

		// In case of in-between termination, do not set the state back to suspended
		if (this.myProcessState == ProcessState.RUNNING) {
			this.myProcessState = ProcessState.SUSPENDED;
		}
	}

}
