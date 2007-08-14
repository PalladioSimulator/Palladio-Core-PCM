package de.uka.ipd.sdq.capra.simulator.resources_new;


public class PreemptiveProcess extends ActiveProcess {

	/**
	 * @uml.property   name="timeSlice"
	 * @uml.associationEnd   aggregation="composite" inverse="preemptiveProcess:de.uka.ipd.sdq.capra.simulator.resources_new.ITimeSlice"
	 */
	private ITimeSlice timeSlice;

	/**
	 * Getter of the property <tt>timeSlice</tt>
	 * @return  Returns the timeSlice.
	 * @uml.property  name="timeSlice"
	 */
	public ITimeSlice getTimeSlice() {
		return timeSlice;
	}

	/**
	 * Setter of the property <tt>timeSlice</tt>
	 * @param timeSlice  The timeSlice to set.
	 * @uml.property  name="timeSlice"
	 */
	public void setTimeSlice(ITimeSlice timeSlice) {
		this.timeSlice = timeSlice;
	}

		
		/**
		 * Process changes back to READY state
		 */
		public void notifyPreemption(){
		}

			
			/**
			 * Process changes to RUNNING state
			 */
			public void notifyActivation(){
			}

}
