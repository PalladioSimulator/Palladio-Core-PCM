package de.uka.ipd.sdq.benchmarks.concurrency.workload;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import simulation.WebserverModel;
import umontreal.iro.lecuyer.randvar.RandomVariateGen;
import de.uka.ipd.sdq.benchmarks.concurrency.behaviours.AbstractBehaviour;
import de.uka.ipd.sdq.benchmarks.concurrency.behaviours.BehaviourWrapper;
import de.uka.ipd.sdq.benchmarks.concurrency.behaviours.IBehaviourStrategy;
import de.uka.ipd.sdq.benchmarks.concurrency.server.RmiHelper;
import de.uka.ipd.sdq.benchmarks.concurrency.workload.ILoadDriver;
import de.uka.ipd.sdq.benchmarks.measurements.MeasurementHolder;
import de.uka.ipd.sdq.sensorframework.util.ExperimentManager;

public class OpenLoadDriverZeroThinkTime implements ILoadDriver {

	private volatile boolean isRunning = true;
	private WebserverModel model;

	private class ContinuousBehaviourWrapper extends BehaviourWrapper {

		private int priority;
		private ThreadPoolExecutor pool;
		private BehaviourWrapper wrapped;
		private MeasurementHolder arrivalTimeHolder;

		public ContinuousBehaviourWrapper(IBehaviourStrategy behaviour) {
			super(behaviour);
			try {

				priority = behaviour.getPriority();
				BlockingQueue<Runnable> runQueue = new LinkedBlockingQueue<Runnable>();
				pool = new ThreadPoolExecutor(1000, 10000, Long.MAX_VALUE,
						TimeUnit.DAYS, runQueue);
				wrapped = new BehaviourWrapper(behaviour);
				arrivalTimeHolder = getWTHolder();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}

		private MeasurementHolder getWTHolder() {
			return this.arrivalTimeHolder = new MeasurementHolder(AbstractBehaviour.MAX_MEASUREMENTS, "Arrival");
		}

		public ContinuousBehaviourWrapper(IBehaviourStrategy behaviour,
				int priority) {
			this(behaviour);
			this.priority = priority;
		}

		@Override
		public void run() {
			try {
				long initial_delay = behaviour.getInitialDelay();
				Thread.sleep(initial_delay, 0);

				long start = System.nanoTime();

				while (isRunning) {
					wrapped.setStart(start);
					pool.execute(wrapped);
					long arrival = (long)(arrivalGen.nextDouble() * model.getArrivalScale());
					Thread.sleep(arrival, 0);
					long now = System.nanoTime();
					arrivalTimeHolder.addNanoTime(start, now);
					start = now;
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
		
		@Override
		public List<MeasurementHolder> getResults() {
			List<MeasurementHolder> results = super.getResults();
			results.add(arrivalTimeHolder);
			return results;
		}
		
		

	}
	
	public OpenLoadDriverZeroThinkTime(String directory, WebserverModel model) {
		this.directory = directory;
		this.arrivalGen = model.getArrivalGen();
		this.model = model;
	}

	List<ContinuousBehaviourWrapper> behaviourList = new ArrayList<ContinuousBehaviourWrapper>();
	List<Thread> behaviourExecutor = new ArrayList<Thread>();
	private String directory;
	private RandomVariateGen arrivalGen;

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
			RmiHelper.store(directory, b, manager);
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
