package de.uka.ipd.sdq.benchmarks.concurrency.workload;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import de.uka.ipd.sdq.benchmarks.concurrency.behaviours.BehaviourWrapper;
import de.uka.ipd.sdq.benchmarks.concurrency.behaviours.IBehaviourStrategy;
import de.uka.ipd.sdq.benchmarks.concurrency.workload.ILoadDriver;
import de.uka.ipd.sdq.benchmarks.measurements.MeasurementHolder;
import de.uka.ipd.sdq.sensorframework.util.ExperimentManager;

public abstract class AbstractLoadDriver implements ILoadDriver {

	protected ScheduledThreadPoolExecutor executor;
	protected ThreadPoolExecutor threadPool;
	protected List<BehaviourWrapper> behaviourList;

	public AbstractLoadDriver(int poolsize) {
		super();
		this.behaviourList = new ArrayList<BehaviourWrapper>();
		executor = new ScheduledThreadPoolExecutor(1);
		threadPool = new ThreadPoolExecutor(poolsize, poolsize, Long.MAX_VALUE,
				TimeUnit.NANOSECONDS, new LinkedBlockingQueue<Runnable>());

	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.benchmarks.concurrency.workload.ILoadDriver#addBehaviour(de.uka.ipd.sdq.benchmarks.concurrency.behaviours.IBehaviourStrategy)
	 */
	public void addBehaviour(IBehaviourStrategy behaviour){
		behaviourList.add(new BehaviourWrapper(behaviour));
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.benchmarks.concurrency.workload.ILoadDriver#stop()
	 */
	public void stop() {
		executor.shutdownNow();
		threadPool.shutdown();
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.benchmarks.concurrency.workload.ILoadDriver#start(long, long)
	 */
	public abstract void start();

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.benchmarks.concurrency.workload.ILoadDriver#store(de.uka.ipd.sdq.sensorframework.util.ExperimentManager)
	 */
	public void store(ExperimentManager manager) {
		for (BehaviourWrapper behaviourWrapper : behaviourList) {
			List<MeasurementHolder> mhList = behaviourWrapper.getResults();
			for (MeasurementHolder mh : mhList) {
				int max = mh.pos.get();
				for (int i = 0; i < max; i++) {
					manager.storeTimeSpan(behaviourWrapper.getName() + " " + mh.name, mh.startTimes[i],
							mh.stopTimes[i]);
				}
			}
		}
	}
	

}