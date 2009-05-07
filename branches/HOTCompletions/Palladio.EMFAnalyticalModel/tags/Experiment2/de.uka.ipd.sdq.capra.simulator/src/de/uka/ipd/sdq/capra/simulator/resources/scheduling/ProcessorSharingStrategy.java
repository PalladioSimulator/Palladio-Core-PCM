package de.uka.ipd.sdq.capra.simulator.resources.scheduling;

import umontreal.iro.lecuyer.simevents.Sim;
import de.uka.ipd.sdq.capra.simulator.resources.Job;
import de.uka.ipd.sdq.probfunction.math.util.MathTools;




public class ProcessorSharingStrategy extends AbstractSchedulingStrategy {

	public ProcessorSharingStrategy() {
		super();
	}
	
	public void progressInTime() {
		double currentTime = Sim.time();
		double passedTime = currentTime - lastVisitTime;
		lastVisitTime = currentTime;
		if(passedTime > MathTools.EPSILON_ERROR){
			double processedDemand = passedTime / jobList.size();
			for (Job j : jobList){
				j.subtractFromDemand(processedDemand);
			}
		}
	}
}
