package de.uka.ipd.sdq.capra.simulator.measurement.recorders;

import cern.colt.list.DoubleArrayList;
import de.uka.ipd.sdq.sensorframework.util.ExperimentManager;
import umontreal.iro.lecuyer.stat.Tally;
import umontreal.iro.lecuyer.stat.TallyStore;

public class SimFullTimeSpanRecorder implements SimTimeSpanRecorder {
	
	private TallyStore store;
	
	public SimFullTimeSpanRecorder(String name) {
		super();
		store = new TallyStore();
		store.setName(name);
	}

	@Override
	public void addTimeSpan(double timeSpan) {
		store.add(timeSpan);
	}
	
	public Tally getTally(){
		return store;
	}

	@Override
	public void storeData(ExperimentManager expManager) {
		
		expManager.storeTimeSpans(store.getName(), store.getArray().elements(),store.getArray().size());		
		System.out.println(store.reportAndConfidenceIntervalStudent(0.9,3));
	}
	
	public SimFullTimeSpanRecorder clone(){
		return new SimFullTimeSpanRecorder(store.getName());
	}
}
