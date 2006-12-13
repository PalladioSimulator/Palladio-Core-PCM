package de.uka.ipd.sdq.simucomframework.sensors;

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

	public void newMeasurement(double responseTime)
	{
		lastValue = responseTime;
		notifyStatistics(new Double(responseTime));
	}
}