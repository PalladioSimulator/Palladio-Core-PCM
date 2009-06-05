package de.uka.ipd.sdq.benchmarks.concurrency.workload;

import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import de.uka.ipd.sdq.benchmarks.concurrency.behaviours.BehaviourWrapper;
import de.uka.ipd.sdq.benchmarks.concurrency.behaviours.IBehaviourStrategy;
import de.uka.ipd.sdq.benchmarks.measurements.MeasurementHolder;
import de.uka.ipd.sdq.sensorframework.util.ExperimentManager;

public class ClosedLoadFixedThreads implements ILoadDriver {
	private Hashtable<BehaviourWrapper, ScheduledThreadPoolExecutor> behaviourExecutor;

	public ClosedLoadFixedThreads() {
		this.behaviourExecutor = new Hashtable<BehaviourWrapper, ScheduledThreadPoolExecutor>();
	}

	@Override
	public void start() {
		for (Entry<BehaviourWrapper, ScheduledThreadPoolExecutor> e : behaviourExecutor.entrySet()){
			BehaviourWrapper b = e.getKey();
			e.getValue().scheduleWithFixedDelay(b, b.getInitialDelay(), b.getDelay(), TimeUnit.MILLISECONDS);
		}
	}

	@Override
	public void stop() {
		for (Entry<BehaviourWrapper, ScheduledThreadPoolExecutor> e : behaviourExecutor.entrySet()){
			e.getValue().shutdown();
		}
	}


	@Override
	public void addBehaviour(IBehaviourStrategy behaviour) {
		BehaviourWrapper b = new BehaviourWrapper(behaviour);
		ScheduledThreadPoolExecutor e = new ScheduledThreadPoolExecutor(1,
				new PriorityThreadFactory(b.getPriority()));
		behaviourExecutor.put(b, e);
	}

	@Override
	public void store(ExperimentManager manager) {
		for (BehaviourWrapper behaviour : behaviourExecutor.keySet()) {
			List<MeasurementHolder> mhList = behaviour.getResults();
			for (MeasurementHolder mh : mhList) {
				int max = mh.pos.get();
				for (int i = 0; i < max; i++) {
					manager.storeTimeSpan(behaviour.getName() + " " + mh.name,
							mh.startTimes[i], mh.stopTimes[i]);
				}
			}
		}
	}

	@Override
	public void addBehaviour(BehaviourWrapper behaviourWrapper) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addBehaviour(BehaviourWrapper behaviour, int priority) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addBehaviour(IBehaviourStrategy behaviour, int priority) {
		// TODO Auto-generated method stub
		
	}
}
