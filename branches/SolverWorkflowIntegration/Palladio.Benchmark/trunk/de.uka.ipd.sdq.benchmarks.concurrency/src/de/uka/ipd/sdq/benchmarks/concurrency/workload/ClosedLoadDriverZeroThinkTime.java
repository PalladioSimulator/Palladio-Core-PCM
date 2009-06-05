package de.uka.ipd.sdq.benchmarks.concurrency.workload;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.benchmarks.concurrency.behaviours.BehaviourWrapper;
import de.uka.ipd.sdq.benchmarks.concurrency.behaviours.IBehaviourStrategy;
import de.uka.ipd.sdq.benchmarks.concurrency.server.RmiHelper;
import de.uka.ipd.sdq.sensorframework.util.ExperimentManager;


public class ClosedLoadDriverZeroThinkTime implements ILoadDriver {

	private volatile boolean isRunning = true;

	private class ContinuousBehaviourWrapper extends BehaviourWrapper {

		private int priority;

		public ContinuousBehaviourWrapper(IBehaviourStrategy behaviour) {
			super(behaviour);
			try {
				priority = behaviour.getPriority();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}

		public ContinuousBehaviourWrapper(IBehaviourStrategy behaviour,
				int priority) {
			super(behaviour);
			this.priority = priority;
		}

		@Override
		public void run() {
			try {
				long delay = behaviour.getDelay();
				long initial_delay = behaviour.getInitialDelay();
				Thread.sleep(initial_delay, 0);

				while (isRunning) {
					try{
						behaviour.execute(System.nanoTime());
					} catch (RemoteException e) {
						e.printStackTrace();
					}
					if (delay > 0) {
						Thread.sleep(delay, 0);
					} 
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(-1);
			}
		}
		
		@Override
		public int getPriority() {
			return priority;
		}

	}

	List<ContinuousBehaviourWrapper> behaviourList = new ArrayList<ContinuousBehaviourWrapper>();
	List<Thread> behaviourExecutor = new ArrayList<Thread>();

	@Override
	public void addBehaviour(IBehaviourStrategy behaviour) {
		behaviourList.add(new ContinuousBehaviourWrapper(behaviour));
	}

	@Override
	public void addBehaviour(IBehaviourStrategy behaviour, int priority) {
		behaviourList.add(new ContinuousBehaviourWrapper(behaviour, priority));
	}

	@Override
	public void start() {
		isRunning = true;
		
		for (ContinuousBehaviourWrapper b : behaviourList) {
			Thread t = new Thread(b);
			t.setPriority(b.getPriority());
			behaviourExecutor.add(t);
		}
		for (Thread t : behaviourExecutor) {
			t.start();
		}
	}

	@Override
	public void stop() {
		isRunning = false;
		for (Thread t : behaviourExecutor) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void store(ExperimentManager manager) {
		for (BehaviourWrapper b : behaviourList) {
			RmiHelper.store(b, manager);
		}
	}

	@Override
	public void addBehaviour(BehaviourWrapper behaviourWrapper) {
		addBehaviour(behaviourWrapper.getBehaviourStrategy());
		
	}

	@Override
	public void addBehaviour(BehaviourWrapper behaviourWrapper, int priority) {
		addBehaviour(behaviourWrapper.getBehaviourStrategy(), priority);
		
	}
}
