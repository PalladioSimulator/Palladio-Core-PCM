package de.uka.ipd.sdq.capra.simulator.measurement.recorders;

public interface SimStateRecorder extends SimRecorder {

	void addStateTime(String state, double start_time, double duration);

}
