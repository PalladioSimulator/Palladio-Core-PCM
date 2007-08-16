package de.uka.ipd.sdq.scheduler;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;


public interface IPassiveResource {

		
		/**
		 */
		public abstract void acquire(ISchedulableProcess process, int num);

			
			/**
			 */
			public abstract void release(ISchedulableProcess process, int num);
			
		

}
