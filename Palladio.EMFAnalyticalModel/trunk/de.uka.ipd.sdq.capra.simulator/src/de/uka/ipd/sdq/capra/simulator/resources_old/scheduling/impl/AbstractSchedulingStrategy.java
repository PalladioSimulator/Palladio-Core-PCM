package de.uka.ipd.sdq.capra.simulator.resources_old.scheduling.impl;

import umontreal.iro.lecuyer.simevents.Sim;
import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraProcess;
import de.uka.ipd.sdq.capra.simulator.resources.scheduling.ProcessRegistry;
import de.uka.ipd.sdq.capra.simulator.resources_old.scheduling.IJobManager;
import de.uka.ipd.sdq.capra.simulator.resources_old.scheduling.IPreemptiveSchedulingStrategy;
import de.uka.ipd.sdq.capra.simulator.resources_old.scheduling.IScheduledJob;
import de.uka.ipd.sdq.probfunction.math.util.MathTools;

/**
 * @author     jens.happe
 */
public abstract class AbstractSchedulingStrategy implements IPreemptiveSchedulingStrategy {

	protected IJobManager jobManager;
	
	protected double lastVisitTime = 0;
	
	protected ProcessRegistry registry;
	
	public AbstractSchedulingStrategy(IJobManager jobManager) {
		super();
		this.jobManager = jobManager;
		this.registry = new ProcessRegistry();
	}

	@Override
	public void addJob(SimCapraProcess process, double demand) {
		assert(MathTools.equalsDouble(Sim.time(), lastVisitTime));
		IScheduledJob job = createJob(process, demand);
		jobManager.addJob(job);
	}	

	protected abstract IScheduledJob createJob(SimCapraProcess process, double demand);

	@Override
	public void progressInTime() {
		double currentTime = Sim.time();
		double passedTime = currentTime - lastVisitTime;
		lastVisitTime = currentTime;
		if(passedTime > MathTools.EPSILON_ERROR){
			progressTimeBy(passedTime);
		}
	}

	protected abstract void progressTimeBy(double passedTime);

	/**
	 * @return
	 * @uml.property  name="registry"
	 */
	public ProcessRegistry getRegistry() {
		return registry;
	}

}