package de.uka.ipd.sdq.codegen.rvisualisation.reportitems;

public abstract class AbstractRReportItem implements IReportItem {

	private double upperBound = 0.95;
	private double lowerBound = 0.05;

	public AbstractRReportItem() {
		super();
	}

	protected String outlierRemovalCommands(String input_data, String output_data) {
		String rCommand = "q = quantile(" + input_data + ",c("
				+ lowerBound + ", " + upperBound
				+ "), type=2, names=FALSE)\n";
		rCommand += output_data + " = " + input_data + "[" + input_data
				+ " >= q[1]]\n";
		rCommand += output_data + " = " + output_data + "[" + output_data
				+ " <= q[2]]\n";
		return rCommand;
	}

	public double getUpperBound() {
		return upperBound;
	}

	public void setUpperBound(double upper_bound) {
		this.upperBound = upper_bound;
	}

	public double getLowerBound() {
		return lowerBound;
	}

	public void setLowerBound(double lower_bound) {
		this.lowerBound = lower_bound;
	}

}