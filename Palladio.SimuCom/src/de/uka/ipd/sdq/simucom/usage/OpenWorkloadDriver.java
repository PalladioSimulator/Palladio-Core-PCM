package de.uka.ipd.sdq.simucom.usage;

import UsageModelPackage.OpenWorkload;
import de.uka.ipd.sdq.simucom.ResponseTimeValueSupplier;
import desmoj.core.dist.RealDistExponential;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;
import desmoj.core.statistic.Histogram;

public class OpenWorkloadDriver extends SimProcess
implements OpenWorkloadPlayerObserver {
	
	protected Histogram responseTimeDistribution = null;
	protected ResponseTimeValueSupplier supplier = new ResponseTimeValueSupplier("ResponseTimeSupplier");
	protected RealDistExponential waitTimeDistribution = null;
	
	public OpenWorkloadDriver(OpenWorkload load, Model owner, String name, boolean showInTrace) {
		super(owner, name, showInTrace);
		responseTimeDistribution = new Histogram(owner, "UserResponseTime", supplier, 0, 1500, 1500, true, false);
		responseTimeDistribution.reset();
		waitTimeDistribution = new RealDistExponential(owner, 
				"Inter arrival time distribution", 
				/*TODO:Heiko fragen, ob das hier stimmt*/load.getArrivalRate(), true, true);
	}

	@Override
	public void lifeCycle() {
		while (true)
		{
			OpenWorkloadPlayer player = new OpenWorkloadPlayer(getModel(), "OpenWorkloadPlayer", true);
			player.addPlayerFinishedObserver(this);
			player.activate(SimTime.NOW);
			this.hold(new SimTime(waitTimeDistribution.sample()));
		}
	}

	public synchronized void playFinished(double timeConsumed) {
		supplier.newResponseTimeMeassurment(timeConsumed);
	}
}
