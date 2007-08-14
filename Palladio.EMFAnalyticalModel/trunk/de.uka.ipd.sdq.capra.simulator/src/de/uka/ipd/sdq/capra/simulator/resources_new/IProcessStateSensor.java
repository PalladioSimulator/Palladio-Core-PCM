package de.uka.ipd.sdq.capra.simulator.resources_new;


/** 
 * Observer of the process' states.
 */
public interface IProcessStateSensor {

		
		/**
		 */
		public abstract void update(PROCESS_STATE newState);
		

}
