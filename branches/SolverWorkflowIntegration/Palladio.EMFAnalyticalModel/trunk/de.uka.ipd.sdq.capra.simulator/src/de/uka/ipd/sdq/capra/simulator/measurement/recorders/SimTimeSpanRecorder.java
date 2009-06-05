package de.uka.ipd.sdq.capra.simulator.measurement.recorders;

public interface SimTimeSpanRecorder extends SimRecorder {
	
	void addTimeSpan(double timeSpan, double time);

	SimTimeSpanRecorder clone();
}
