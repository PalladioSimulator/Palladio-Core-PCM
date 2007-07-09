package de.uka.ipd.sdq.capra.simulator.resources.scheduling;


import umontreal.iro.lecuyer.simevents.Sim;
import de.uka.ipd.sdq.capra.simulator.resources.Job;
import de.uka.ipd.sdq.probfunction.math.util.MathTools;

public class DelayStrategy extends AbstractSchedulingStrategy {

	public void progressInTime() {
		double currentTime = Sim.time();
		double passedTime = currentTime - lastVisitTime;
		lastVisitTime = currentTime;
		if(passedTime > MathTools.EPSILON_ERROR){
			for (Job j : jobList){
				j.subtractFromDemand(passedTime);
			}
		}
	}
}
