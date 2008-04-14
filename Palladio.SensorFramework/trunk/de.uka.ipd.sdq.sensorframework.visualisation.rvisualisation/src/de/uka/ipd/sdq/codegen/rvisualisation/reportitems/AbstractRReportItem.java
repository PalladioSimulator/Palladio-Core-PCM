package de.uka.ipd.sdq.codegen.rvisualisation.reportitems;

public abstract class AbstractRReportItem implements IReportItem {

	/** The default upper quantile used to cut outliners. */
	public static final double DEFAULT_UPPER_BOUND = 0.95;
	/** The default lower quantile used to cut outliners. */
	public static final double DEFAULT_LOWER_BOUND = 0.05;
	
	/** Upper bound for the quantile used to cut outliners. */
	private double upperBound;
	/** Lower bound for the quantile used to cut outliners. */
	private double lowerBound;

	/**Initializes a new R report item.
	 * Sets default lower and upper bounds.
	 */
	public AbstractRReportItem() {
		upperBound = DEFAULT_UPPER_BOUND;
		lowerBound = DEFAULT_LOWER_BOUND;
	}

	protected String outlierRemovalCommands(final String inputRVariable, 
			final String outputRVariable) {
		String rCommand = "q = quantile(" + inputRVariable + ",c("
				+ lowerBound + ", " + upperBound
				+ "), type=2, names=FALSE)\n";
		rCommand += outputRVariable + " = " + inputRVariable + "[" 
				+ inputRVariable + " >= q[1]]\n";
		rCommand += outputRVariable + " = " + outputRVariable + "[" 
				+ outputRVariable + " <= q[2]]\n";
		return rCommand;
	}

	/**Gets the current upper quantile used to cut outliners.
	 * @return The quantile used as upper bound.
	 */
	public double getUpperBound() {
		return upperBound;
	}

	/**Sets the upper quantile used to cut outliners.
	 * @param upperBound The quantile to use as a bound.
	 */
	public void setUpperBound(final double upperBound) {
		this.upperBound = upperBound;
	}

	/**Gets the current lower quantile used to cut outliners.
	 * @return The quantile used as lower bound.
	 */
	public double getLowerBound() {
		return lowerBound;
	}

	/**Sets the lower quantile used to cut outliners.
	 * @param lowerBound The quantile to use as a bound.
	 */
	public void setLowerBound(final double lowerBound) {
		this.lowerBound = lowerBound;
	}
}
