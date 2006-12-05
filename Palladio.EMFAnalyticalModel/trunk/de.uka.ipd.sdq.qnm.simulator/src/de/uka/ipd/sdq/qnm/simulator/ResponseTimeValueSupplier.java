package de.uka.ipd.sdq.qnm.simulator;

import desmoj.core.statistic.ValueSupplier;

public class ResponseTimeValueSupplier
extends ValueSupplier
{
	protected double lastValue;
	
	public ResponseTimeValueSupplier(String arg0) {
		super(arg0);
	}

	@Override
	public double value() {
		return lastValue;
	}

	public void newResponseTimeMeasurement(double responseTime)
	{
		lastValue = responseTime;
		notifyStatistics(new Double(responseTime));
	}
}