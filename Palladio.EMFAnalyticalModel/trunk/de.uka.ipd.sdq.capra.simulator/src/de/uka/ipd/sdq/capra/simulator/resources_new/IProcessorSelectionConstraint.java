package de.uka.ipd.sdq.capra.simulator.resources_new;


public interface IProcessorSelectionConstraint {

		
		/**
		 * Checks whether this process can run on the specified CPU. It returns the penalty for executing the specified CPU. 
		 * penalty < 0 - the process cannot be executed on the cpu
		 * penalty = 0 - the execution does not impose any additional cost
		 * penalty < 0 - the process can be executed, but at a certain cost. 
		 */
		public abstract double check(int cpu_id);
			
		

}
