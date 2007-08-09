package de.uka.ipd.sdq.capra.simulator.resources;

import umontreal.iro.lecuyer.simevents.Sim;
import de.uka.ipd.sdq.capra.simulator.CapraSim;
import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraProcess;
import de.uka.ipd.sdq.capra.simulator.resources.scheduling.IPreemptiveSchedulingStrategy;
import de.uka.ipd.sdq.capra.simulator.resources.scheduling.IScheduledJob;
import de.uka.ipd.sdq.capra.simulator.resources.scheduling.impl.ProcessRegistry;

public class SimActiveResource extends AbstractSimResource {

	private IPreemptiveSchedulingStrategy strategy;
	
	private ProcessRegistry registry;

	public SimActiveResource(IPreemptiveSchedulingStrategy strategy, String name) {
		super(name, 1);
		this.strategy = strategy;
		this.registry = strategy.getRegistry();
	}

	public void process(SimCapraProcess capraProcess, double demand) {
		strategy.progressInTime();		
		strategy.addJob(capraProcess, demand);
		capraProcess.setReady(true);
		strategy.reschedule();
	}
	
	public void schedulingCallback(IScheduledJob job){
		strategy.progressInTime();
		if (strategy.finishSchedulingCycle(job)) {
			CapraSim.logger.info(Sim.time() + "\t  " + job.getProcess().getProcess().getName() + " demands fulfilled.");
			job.getProcess().getProcess().setReady(false);
			job.getProcess().proceed();
			strategy.reschedule();
		} else {
			CapraSim.logger.info(Sim.time() + "\t  " + job.getProcess().getProcess().getName() + " timeslice finished.");
			strategy.reschedule();
		}
	}

	public ProcessRegistry getRegistry() {
		return registry;
	}

}
