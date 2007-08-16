package de.uka.ipd.sdq.capra.simulator.resources_old.scheduling;

import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraProcess;



public interface ISchedulingStrategy {
	
	void addJob(SimCapraProcess process, double demand);
	
	void progressInTime();

}
