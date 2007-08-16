package de.uka.ipd.sdq.scheduler.processes;


/** 
 * Observer of the process' states.
 */
public interface IProcessStateSensor {

		
		/**
		 */
		public abstract void update(PROCESS_STATE newState);
		

}
