/**
 * 
 */
package de.uka.ipd.sdq.simucom.usage;

import java.util.Observable;

import DerivedContext.Context;
import DerivedContext.DerivedContextFactory;
import UsageModelPackage.ClosedWorkload;
import UsageModelPackage.ScenarioBehaviour;
import de.uka.ipd.sdq.simucom.ResponseTimeValueSupplier;
import de.uka.ipd.sdq.simucom.SimuComModel;
import de.uka.ipd.sdq.simucom.ui.UsageScenarioResponseTimeMonitor;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;
import desmoj.core.statistic.Histogram;

/**
 * @author Snowball
 *
 */
public class ClosedWorkloadDriver extends SimProcess {

	protected Histogram workloadExecutionTimeDistribution = null;
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

		workloadExecutionTimeDistribution = new Histogram(owner, name, supplier, 0, 1500, 1500, true, false);
		workloadExecutionTimeDistribution.reset();
		
		this.getResponseTimeSensor().addObserver(new UsageScenarioResponseTimeMonitor(name));
	}

	public Observable getResponseTimeSensor() {
		// TODO Auto-generated method stub
		return supplier;
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
		while (true)
		{
			playScenario();
			think();			
		}
	}

	private void think() {
		hold(new SimTime(myLoad.getThinkTime()));
	}

	/**
	 * 
	 */
	private void playScenario() {
		double activityStart = this.currentTime().getTimeValue();
		SystemPackage.System system = ((SimuComModel)getModel()).getSystem();

		Context callContext = DerivedContextFactory.eINSTANCE.createContext();
		callContext.setSystem(system);

		WorkloadVisitor visitor = new WorkloadVisitor(this,callContext);
		try {
			visitor.visitScenarioBehaviour(myBehaviour);
			workloadExecutionTimeDistribution.update(this.currentTime().getTimeValue()-activityStart);
			supplier.newResponseTimeMeassurment(this.currentTime().getTimeValue()-activityStart);
		} catch (Exception e) {
			System.out.println("Scenario behaviour caused exception!");
			e.printStackTrace();
		}
	}
}
