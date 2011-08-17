package de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems;



/**This report item displays a histogram.
 * @author groenda
 */
public class HistogramReportItem extends AbstractPlotReportItem {
	/** Default label for the x axis. */
	public static final String DEFAULT_X_AXIS_LABEL = "";
	/** Default number of classes. */
	public static final int DEFAULT_NUMBER_CLASSES = 10;
	
	/** Label of the x axis. */
	private String xAxisLabel = DEFAULT_X_AXIS_LABEL;
	/** Number of classes of the histogram. */
	private int columns = DEFAULT_NUMBER_CLASSES;

	/**Constructs a new report item containing a histogram graphic.
	 * The graphic is stored in a temporary file. This is accessible via the 
	 * getFilename method.
	 * @param title Title of the plotted graphic.
	 * @param xAxisLabel Label for the x axis.
	 */
	public HistogramReportItem(final String title, final String xAxisLabel) {
		super(title);
		this.xAxisLabel = xAxisLabel;
	}

	/**Constructs a new report item containing a histogram graphic.
	 * The graphic is stored in a temporary file. This is accessible via the 
	 * getFilename method.
	 * @param title Title of the plotted graphic.
	 * @param height height of the plotted graphic.
	 * @param width width of the plotted graphics.
	 * @param fontSize the default pointsize of plotted text, interpreted at 
	 *        72 dpi, so one point is approximately one pixel.
	 * @param xAxisLabel Label for the x axis.
	 */
	public HistogramReportItem(final String title, final int height, 
			final int width, final int fontSize, final String xAxisLabel) {
		super(title, height, width, fontSize);
		this.xAxisLabel = DEFAULT_X_AXIS_LABEL;
	}

	/** {@inheritDoc}
	 */
	@Override
	protected String generatePlotCommand() {

		String rCommand = "require(plotrix)\n";

		String list = "l = list(";
		String legend= "leg = list(";
		int pos = 0;
		for (String id : getDataSeries()) {
			String data = getDataCommand(id);
			String sep = (pos == 0 ? "" : ", ");
			list += sep + data;
			legend += sep + "\""+getName(id)+"\"";
			pos++;
		}
		list += ")\n";
		legend += ")\n";
		rCommand += list;
		rCommand += legend;
		rCommand += "multhist(l, breaks=" + columns + ", freq=FALSE, probability=TRUE,"
				+ "main=\"" + getDescription() + "\", " 
				+ "title=\"Histogram\", "
				+ "xlab=\"" + xAxisLabel + "\", " + "ylab=\"Probability\"";
		if (getDataSeries().length>=2){
			rCommand+=", legend.text=leg";
		}
		rCommand+=")\n";
		return rCommand;
	}

	/**Returns the number of classes of the histogram.
	 * @return The number of classes.
	 */
	public int getColumns() {
		return columns;
	}

	/**Set s the number of classes of the histogram.
	 * @param columns The number of classes.
	 */
	public void setColumns(final int columns) {
		this.columns = columns;
	}

}
