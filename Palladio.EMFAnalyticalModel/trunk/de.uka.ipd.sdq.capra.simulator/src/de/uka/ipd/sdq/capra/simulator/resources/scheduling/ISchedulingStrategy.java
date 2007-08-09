package de.uka.ipd.sdq.capra.simulator.resources.scheduling;

import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraProcess;



public interface ISchedulingStrategy {
	
	void addJob(SimCapraProcess process, double demand);
	
	void progressInTime();

}
