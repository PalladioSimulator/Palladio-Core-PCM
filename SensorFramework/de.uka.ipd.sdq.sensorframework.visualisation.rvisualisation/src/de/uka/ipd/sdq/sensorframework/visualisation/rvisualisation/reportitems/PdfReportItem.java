package de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems;


/**Report item that displays probability distribution functions.
 * @author groenda
 */
public class PdfReportItem extends AbstractPlotReportItem {
	/** Default label for the x axis. */
	public static final String DEFAULT_X_AXIS_LABEL = "";
	
	/** Label of the x axis. */
	private String xAxisLabel = DEFAULT_X_AXIS_LABEL;

	/**Constructs a new report item containing a plotted pdf graphic.
	 * The graphic is stored in a temporary file. This is accessible via the 
	 * getFilename method.
	 * @param title Title of the plotted graphic.
	 * @param xAxisLabel Label for the x axis.
	 */
	public PdfReportItem(final String title, final String xAxisLabel) {
		super(title);
		this.xAxisLabel = xAxisLabel;
	}

	/**Constructs a new report item containing a plotted pdf graphic.
	 * The graphic is stored in a temporary file. This is accessible via the 
	 * getFilename method.
	 * @param title Title of the plotted graphic.
	 * @param height height of the plotted graphic.
	 * @param width width of the plotted graphics.
	 * @param fontSize the default pointsize of plotted text, interpreted at 
	 *        72 dpi, so one point is approximately one pixel.
	 * @param xAxisLabel Label for the x axis.
	 */
	public PdfReportItem(final String title, final int height, 
			final int width, final int fontSize, final String xAxisLabel) {
		super(title, height, width, fontSize);
		this.xAxisLabel = DEFAULT_X_AXIS_LABEL;
	}

	/** {@inheritDoc}
	 */
	@Override
	protected String generatePlotCommand() {
		int pos = 0;
		String rCommand = "";

		for (String id : getDataSeries()) {
			String data = getDataCommand(id);
			if (pos == 0) {
				rCommand += "plot(density(" + data + "), "
						+ "do.points=FALSE, " + "verticals=TRUE, "
						+ "main=\"" + getDescription() + "\", "
						+ "xlab=\"" + xAxisLabel + "\")\n"; //, " + "ylab=\"f(t)\")\n";
			} else {
				rCommand += "lines(density(" + data + "),type=\"s\", lty=" 
						+ (pos + 1) + ")\n";
			}
			pos++;
		}
		rCommand += generateLinesLegend();
		return rCommand;
	}

}
