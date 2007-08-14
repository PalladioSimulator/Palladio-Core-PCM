package de.uka.ipd.sdq.capra.simulator.resources_new;


public interface IProcessorSelectionConstraints {

		
		/**
		 */
		public abstract boolean check(int cpu_id);

			
			/**
			 * Returns the time penality if the constraint is violated.
			 */
			public abstract double penality();
			
		

}
