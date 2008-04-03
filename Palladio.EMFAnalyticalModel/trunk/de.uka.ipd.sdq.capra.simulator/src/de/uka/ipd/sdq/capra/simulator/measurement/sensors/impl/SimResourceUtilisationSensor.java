package de.uka.ipd.sdq.capra.simulator.measurement.sensors.impl;

import de.uka.ipd.sdq.capra.simulator.measurement.recorders.SimRecorder;
import de.uka.ipd.sdq.capra.simulator.measurement.recorders.SimStateRecorder;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimStateSensor;
import de.uka.ipd.sdq.scheduler.resources.active.SimResourceInstance;
import de.uka.ipd.sdq.scheduler.sensors.IActiveResourceStateSensor;

public class SimResourceUtilisationSensor extends AbstractSensor implements SimStateSensor, IActiveResourceStateSensor {

	private boolean last_state;
	private double last_update_time;
	
	public SimResourceUtilisationSensor(String name) {
		super(name);
		last_state = false; // idle
		last_update_time = 0;
	}

	@Override
	public void finishMeasurements() {
	}

	@Override
	public void update(SimResourceInstance instance) {
		boolean new_state = instance.processAssigned();
		update(new_state);
	}

	private void update(boolean new_state) {
		double current_time = simulator.time();
		double passed_time = current_time - last_update_time;
		addStateTime(last_state, last_update_time, passed_time);
		last_update_time = current_time;
		last_state = new_state;
	}

	private void addStateTime(boolean state, double start_time,
			double duration) {
		for (SimRecorder recorder : recorderList) {
			((SimStateRecorder) recorder).addStateTime(state ? "Busy" : "Idle",start_time,duration);
		}
	}

	@Override
	public void start() {
		for (SimRecorder recorder : recorderList) {
			recorder.start();
		}
	}

	@Override
	public void toNow() {
		update(last_state);
	}


}
