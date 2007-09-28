package de.uka.ipd.sdq.capra.simulator.measurement.recorders;

import umontreal.iro.lecuyer.stat.Tally;
import umontreal.iro.lecuyer.stat.TallyStore;
import de.uka.ipd.sdq.sensorframework.util.ExperimentManager;

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
	}
	
	public SimFullTimeSpanRecorder clone(){
		return new SimFullTimeSpanRecorder(store.getName());
	}
}
