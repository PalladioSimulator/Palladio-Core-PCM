/**
 * 
 */
package de.uka.ipd.sdq.simucom.usage;

import de.uka.ipd.sdq.pcm.usagemodel.ClosedWorkload;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.simucom.Context;
import de.uka.ipd.sdq.simucom.ResponseTimeValueSupplier;
import de.uka.ipd.sdq.simucom.SimuComModel;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;

/**
 * @author Snowball
 *
 */
public class ClosedWorkloadDriver extends SimProcess {

	protected ResponseTimeValueSupplier supplier = new ResponseTimeValueSupplier("ResponseTimeSupplier");
	private ClosedWorkload myLoad;
	private ScenarioBehaviour myBehaviour;

	/**
	 * @param owner
	 * @param name
	 * @param showInTrace
	 */
	public ClosedWorkloadDriver(Model owner, String name, boolean showInTrace) {
		super(owner, name, showInTrace);

		((SimuComModel)owner).getSensorFactory().createHistogramSensor(this.getName(), supplier);
		//workloadExecutionTimeDistribution = new Histogram(owner, name, supplier, 0, 1500, 1500, true, false);
		//workloadExecutionTimeDistribution.reset();
		
		//this.getResponseTimeSensor().addObserver(new UsageScenarioResponseTimeMonitor(name));
	}

	public void init(ClosedWorkload load, ScenarioBehaviour behaviour)
	{
		this.myLoad = load;
		this.myBehaviour = behaviour;
	}
	
	public void activateNow()
	{
		this.activate(SimTime.NOW);
	}

	/* (non-Javadoc)
	 * @see desmoj.core.simulator.SimProcess#lifeCycle()
	 */
	@Override
	public void lifeCycle() {
		try
		{
			while (true)
			{
				playScenario();
				think();			
			}
		} catch (Exception e) {
			System.out.println("Lifetime ended!");
			e.printStackTrace();
		}
	}

	private void think() {
		if (myLoad.getThinkTime()>0)
			hold(new SimTime(myLoad.getThinkTime()));
	}

	/**
	 * @throws Exception 
	 * 
	 */
	private void playScenario() throws Exception {
		double activityStart = this.currentTime().getTimeValue();
		de.uka.ipd.sdq.pcm.system.System system = ((SimuComModel)getModel()).getSystem();

		Context callContext = new Context();
		callContext.setSystem(system);

		WorkloadVisitor visitor = new WorkloadVisitor(this,callContext);
		try {
			visitor.visitScenarioBehaviour(myBehaviour);
			//workloadExecutionTimeDistribution.update(this.currentTime().getTimeValue()-activityStart);
			supplier.newResponseTimeMeassurment(this.currentTime().getTimeValue()-activityStart);
		} catch (Exception e) {
			System.out.println("Scenario behaviour caused exception!");
			e.printStackTrace();
			throw e;
		}
		think();
	}
}
