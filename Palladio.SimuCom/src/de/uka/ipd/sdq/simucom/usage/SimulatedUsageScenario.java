package de.uka.ipd.sdq.simucom.usage;

import java.util.ArrayList;

import UsageModelPackage.UsageScenario;
import de.uka.ipd.sdq.simucom.threads.history.HistoryElement;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.SimProcess;
import desmoj.core.statistic.Histogram;
import desmoj.core.statistic.ValueSupplier;

public class SimulatedUsageScenario
extends SimProcess
{
	protected UsageScenario myScenario = null;
	
	protected Histogram responseTimeDistribution = null;
	protected ResponseTimeValueSupplier supplier = new ResponseTimeValueSupplier("ResponseTimeSupplier");
	
	public SimulatedUsageScenario(UsageScenario myScenario, Model model, boolean hasTrace) {
		super(model, "A scenario"/*TODO: myScenario.getName()*/, hasTrace);

		this.myScenario = myScenario;

		// TODO: Fix hardcoded bounds
		responseTimeDistribution = new Histogram(model, "UserResponseTime", supplier, 0, 1500, 150, true, false);
	}
	
	public ValueSupplier getResponseTimeSensor()
	{
		return supplier;
	}
	
	@Override
	public void lifeCycle() {
		ArrayList<HistoryElement> history = new ArrayList<HistoryElement>();
		WorkloadVisitor visitor = new WorkloadVisitor(this, history,
				interactionComponent);
//
//		try {
//			if (thinkFirst)
//				this.hold(new SimTime(thinkTime));
//			while (true) {
//				double activityStart = this.currentTime().getTimeValue();
//				// visitor.visitActivity(activity);
//				// responseTimeDistribution.update(this.currentTime().getTimeValue()-activityStart);
//				supplier.newResponseTimeMeassurment(this.currentTime().getTimeValue()-activityStart);
//				
//				this.hold(new SimTime(thinkTime));
//			}
//		} catch (Exception ex) {
//			System.out.println("Simulated User caused exception: "
//					+ ex.getMessage());
//			// System.exit(-1);
//		}
	}
}

class ResponseTimeValueSupplier
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