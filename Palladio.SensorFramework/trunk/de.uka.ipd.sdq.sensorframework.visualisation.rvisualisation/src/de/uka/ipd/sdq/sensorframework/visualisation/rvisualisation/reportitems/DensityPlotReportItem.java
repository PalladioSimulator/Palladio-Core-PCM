package de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems;

/**Represents a report item containing a density plot graphic.
 * @author groenda (comments, refactoring)
 */
public class DensityPlotReportItem extends AbstractPlotReportItem {
	/** The default size for the text. */
	public static final int DEFAULT_TEXT_SIZE = 12;

	/** Label of the x axis. */
	private String xAxisLabel;

	/**Constructs a new report item containing a plotted density graphic.
	 * The graphic is stored in a temporary file. This is accessible via the 
	 * getFilename method.
	 * @param title Title of the plotted graphic.
	 * @param height height of the plotted graphic.
	 * @param width width of the plotted graphics.
	 * @param xAxisLabel label of the x axis.
	 * @param textSize the default pointsize of plotted text, interpreted at 
	 *        72 dpi, so one point is approximately one pixel.
	 */
	public DensityPlotReportItem(final String title, final int height, 
			final int width, final String xAxisLabel, final int textSize) {
		super(title, height, width, textSize);
		this.xAxisLabel = xAxisLabel;
	}
	
	/**Constructs a new report item containing a plotted density graphic 
	 * of the default size.
	 * @param title Title of the plotted graphic.
	 * @param xAxisLabel label of the x axis.
	 */
	public DensityPlotReportItem(final String title, final String xAxisLabel) {
		super(title);
		this.xAxisLabel = xAxisLabel;
	}

	/** {@inheritDoc}
	 */
	@Override
	protected String generatePlotCommand() {
		String rCommand = "";
		int seriesNumber = 0;
		for (String id : getDataSeries()) {
			if (seriesNumber == 0) {
				rCommand += "plot(" + getDataCommand(id) + ",xlab=\"" 
							+ xAxisLabel + "\",main=\"" + getDescription() 
							+ "\")\n";
			} else {
				rCommand += "lines(" + getDataCommand(id) + ")\n";
			}
			seriesNumber++;
		}
		return rCommand;
	}

}
