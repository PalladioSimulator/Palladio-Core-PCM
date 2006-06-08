package de.uka.ipd.sdq.simucom;

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

	public void newResponseTimeMeassurment(double responseTime)
	{
		lastValue = responseTime;
		notifyStatistics(new Double(responseTime));
	}
}