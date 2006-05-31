package de.uka.ipd.sdq.simucom.usage;

import java.util.ArrayList;

import UsageModelPackage.ClosedWorkload;
import UsageModelPackage.UsageModelPackagePackage;
import UsageModelPackage.UsageScenario;
import UsageModelPackage.Workload;
import de.uka.ipd.sdq.simucom.SimuComModel;
import de.uka.ipd.sdq.simucom.threads.history.HistoryElement;
import desmoj.core.exception.SimFinishedException;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;
import desmoj.core.statistic.Histogram;
import desmoj.core.statistic.ValueSupplier;

public class SimulatedUsageScenario
extends SimProcess
{
	protected UsageScenario myScenario = null;
	
	protected Histogram responseTimeDistribution = null;
	protected ResponseTimeValueSupplier supplier = new ResponseTimeValueSupplier("ResponseTimeSupplier");
	
	public SimulatedUsageScenario(UsageScenario myScenario, SimuComModel model, boolean hasTrace) {
		super(model, "A scenario"/*TODO: myScenario.getName()*/, hasTrace);

		this.myScenario = myScenario;

		// TODO: Fix hardcoded bounds
		responseTimeDistribution = new Histogram(model, "UserResponseTime", supplier, 0, 1500, 150, true, false);
		responseTimeDistribution.reset();
	}
	
	public ValueSupplier getResponseTimeSensor()
	{
		return supplier;
	}
	
	@Override
	public void lifeCycle() {
		ArrayList<HistoryElement> history = new ArrayList<HistoryElement>();
		Workload load = myScenario.getWorkload_UsageScenario(); 

		try
		{
			while (true) {
				double activityStart = this.currentTime().getTimeValue();
				WorkloadVisitor visitor = new WorkloadVisitor(this);
				visitor.visitScenarioBehaviour(myScenario.getScenarioBehaviour_UsageScenario());
				responseTimeDistribution.update(this.currentTime().getTimeValue()-activityStart);
				supplier.newResponseTimeMeassurment(this.currentTime().getTimeValue()-activityStart);
				
				if (load.eClass() == UsageModelPackagePackage.eINSTANCE.getClosedWorkload())
				{
					ClosedWorkload closedLoad = (ClosedWorkload)load;
					this.hold(new SimTime(closedLoad.getThinkTime()));
				}
			}
		} catch (SimFinishedException ex) {
			System.out.println("UsageScenario "+getName()+" aborted due to SimTime limit");
		} catch (Exception ex) {
			System.out.println("Simulated User caused exception: "
					+ ex.getMessage());
			// System.exit(-1);
		}
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