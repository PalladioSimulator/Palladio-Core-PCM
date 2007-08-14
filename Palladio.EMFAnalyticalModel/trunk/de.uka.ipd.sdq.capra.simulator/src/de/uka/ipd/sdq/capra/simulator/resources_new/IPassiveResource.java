package de.uka.ipd.sdq.capra.simulator.resources_new;

import de.uka.ipd.sdq.capra.simulator.schedinterface.ISchedulableProcess;


public interface IPassiveResource {

		
		/**
		 */
		public abstract void acquire(ISchedulableProcess process, int num);

			
			/**
			 */
			public abstract void release(ISchedulableProcess process, int num);
			
		

}
