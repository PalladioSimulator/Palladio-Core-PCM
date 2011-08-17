package de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems;

/**Report item that displays cumulative distribution functions.
 * @author groenda
 */
public class CdfReportItem extends AbstractPlotReportItem {
	/** Default label for the x axis. */
	public static final String DEFAULT_X_AXIS_LABEL = "";
	
	/** Label of the x axis. */
	private String xAxisLabel = DEFAULT_X_AXIS_LABEL;

	/**Constructs a new report item containing a plotted cdf graphic.
	 * The graphic is stored in a temporary file. This is accessible via the 
	 * getFilename method.
	 * @param title Title of the plotted graphic.
	 * @param xAxisLabel Label for the x axis.
	 */
	public CdfReportItem(final String title, final String xAxisLabel) {
		super(title);
		this.xAxisLabel = xAxisLabel;
	}

	/**Constructs a new report item containing a plotted cdf graphic.
	 * The graphic is stored in a temporary file. This is accessible via the 
	 * getFilename method.
	 * @param title Title of the plotted graphic.
	 * @param height height of the plotted graphic.
	 * @param width width of the plotted graphics.
	 * @param fontSize the default pointsize of plotted text, interpreted at 
	 *        72 dpi, so one point is approximately one pixel.
	 * @param xAxisLabel Label for the x axis.
	 */
	public CdfReportItem(final String title, final int height, 
			final int width, final int fontSize, final String xAxisLabel) {
		super(title, height, width, fontSize);
		this.xAxisLabel = DEFAULT_X_AXIS_LABEL;
	}

	/** {@inheritDoc}
	 */
	@Override
	protected String generatePlotCommand() {

		int pos = 0;
		String sort = "";
		String range = "r = range(";
		String plot = "";

		for (String id : getDataSeries()) {
			String data = getDataCommand(id);
			String sdata = "s_" + data;
			String sep = (pos == 0 ? "" : ", ");

			range += sep + data;
			sort += sdata + " = sort(" + data + ")\n";

			if (pos == 0) {
				plot += "plot(ecdf(" + sdata + "), xlim=r, "
						+ "do.points=FALSE, " + "verticals=TRUE, "
						+ "main=\"" + getDescription() + "\", "
						+ "xlab=\"" + xAxisLabel + "\", " + "ylab=\"Cumulated Density\")\n";
			} else {
				plot += "lines(" + sdata + ", (1:length(" + sdata + "))/length("
						+ sdata + " ),type=\"s\", lty=" + (pos + 1) + ")\n";
			}

			pos++;
		}
		range += ")\n";

		String rCommand = sort + range + plot;
		rCommand += generateLinesLegend();
		return rCommand;
	}
}
