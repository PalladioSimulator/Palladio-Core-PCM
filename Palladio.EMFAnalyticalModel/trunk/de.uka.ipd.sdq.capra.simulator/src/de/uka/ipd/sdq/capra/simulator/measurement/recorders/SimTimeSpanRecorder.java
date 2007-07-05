package de.uka.ipd.sdq.capra.simulator.measurement.recorders;

public interface SimTimeSpanRecorder extends SimRecorder {
	
	void addTimeSpan(double timeSpan);

	SimTimeSpanRecorder clone();
}
