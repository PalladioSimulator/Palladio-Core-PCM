package de.uka.ipd.sdq.capra.simulator.resources;


public class OnThresholdBalancer extends AbstractLoadBalancer {

	/**
	 * If the number of tasks differs more than this value, tasks are moved.
	 * @uml.property  name="threshold"
	 */
	private double threshold;

	/**
	 * Getter of the property <tt>threshold</tt>
	 * @return  Returns the threshold.
	 * @uml.property  name="threshold"
	 */
	public double getThreshold() {
		return threshold;
	}

	/**
	 * Setter of the property <tt>threshold</tt>
	 * @param threshold  The threshold to set.
	 * @uml.property  name="threshold"
	 */
	public void setThreshold(double threshold) {
		this.threshold = threshold;
	}

	@Override
	public void balance() {
		// TODO Auto-generated method stub
		
	}

}
