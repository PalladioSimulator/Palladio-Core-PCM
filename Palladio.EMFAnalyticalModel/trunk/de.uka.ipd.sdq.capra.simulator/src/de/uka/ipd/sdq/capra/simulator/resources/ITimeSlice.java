package de.uka.ipd.sdq.capra.simulator.resources;


public interface ITimeSlice {

		
		/**
		 */
		public abstract void getTimeUntilNextInterruption();

			
			/**
			 * Resets the timeslice to full. The value can depend on the current status of the process.
			 */
			public abstract void reset();


				
				/**
				 */
				public abstract void passTime(double time);


					
					/**
					 * Returns true if the timeslice is finished, false otherwise.
					 */
					public abstract boolean isFinished();
					
				
			
		

}
