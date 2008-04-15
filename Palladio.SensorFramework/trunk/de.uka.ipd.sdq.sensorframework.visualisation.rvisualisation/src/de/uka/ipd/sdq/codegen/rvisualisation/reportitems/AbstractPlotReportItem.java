package de.uka.ipd.sdq.codegen.rvisualisation.reportitems;

import java.io.File;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;

import de.uka.ipd.sdq.codegen.rvisualisation.RVisualisationPlugin;
import de.uka.ipd.sdq.codegen.rvisualisation.actions.RConnection;

/**Report item to display generated graphics.
 * @author groenda
 */
public abstract class AbstractPlotReportItem extends AbstractRReportItem {
	/** Default position of the legend. */
	public static final LegendPosition DEFAULT_LEGEND_POSITION = 
		LegendPosition.none;
	/** Default size of the graphic. */
	public static final int DEFAULT_GRAPHIC_SIZE = 500;
	/** Default font size for the graphic. */
	public static final int DEFAULT_FONT_SIZE = 12;
	
	/** Table of the R commands for ids. */
	private Map<String, String> dataCommandTable = new Hashtable<String, String>();
	/** Table of the displayed names. */
	private Map<String, String> nameTable = new Hashtable<String, String>();
	
	/** The temporary graphic file. */
	private File temporaryFile = null;
	/** Position of the legend relative to the graphic. */
	private LegendPosition legendPosition = DEFAULT_LEGEND_POSITION;
	/** The colors to use in the graphic. */
	private String[] colors = new String[] { "black", "lightgray", "darkgray", "gray" };
	/** Default height of the graphic. */
	private int graphicsHeight = DEFAULT_GRAPHIC_SIZE;
	/** Default width of the graphic. */
	private int graphicsWidth = DEFAULT_GRAPHIC_SIZE;
	/** Default font size for graphics. */
	private int fontSize = DEFAULT_FONT_SIZE;

	/**Position of the legend relative to the plot.
	 * @author happe
	 * @author groenda
	 */
	public enum LegendPosition {
		/**The different legend positions. */
		none, top, topright, right, bottomright, bottom, bottomleft, left, 
		/**The different legend positions. */
		topleft, center
	}

	/**Constructs a new report item containing a plotted density graphic.
	 * The graphic is stored in a temporary file. This is accessible via the 
	 * getFilename method.
	 * @param title Title of the plotted graphic.
	 */
	public AbstractPlotReportItem(final String title) {
		super(title);
	}

	/**Constructs a new report item containing a plotted density graphic.
	 * The graphic is stored in a temporary file. This is accessible via the 
	 * getFilename method.
	 * @param title Title of the plotted graphic.
	 * @param height height of the plotted graphic.
	 * @param width width of the plotted graphics.
	 * @param fontSize the default pointsize of plotted text, interpreted at 
	 *        72 dpi, so one point is approximately one pixel.
	 */
	public AbstractPlotReportItem(final String title, final int height, 
			final int width, final int fontSize) {
		super(title);
		this.graphicsWidth = width;
		this.graphicsHeight = height;
		this.fontSize = fontSize;
	}

	/**Exports the plot as vector graphic in the PDF format.
	 * @param pdfFile The file to which the graphic is saved.
	 * @param rConnection The connection to the R engine.
	 */
	public void exportVectorGraphic(final File pdfFile, 
			final RConnection rConnection) {
		String rCommand = "";
		try {
			rCommand += "pdf(\""
					+ pdfFile.getAbsolutePath().replace(File.separator,
							"\\\\") + "\")\n";
			rCommand += generatePlotCommand();
			rCommand += "dev.off()\n";
		} catch (Exception e) {
			RVisualisationPlugin.log(IStatus.ERROR,
					"Could not create PDF file. "
							+ e.getClass().getCanonicalName());
		}
		rConnection.execute(rCommand);
	}
	
	/**Adds a new data set to the plot.
	 * @param id Identifier for the data series.
	 * @param displayName The display name for the data series. 
	 * @param rVariable The name of the R variable.
	 */
	public void addData(final String id, final String displayName, 
			final String rVariable) {
		dataCommandTable.put(id, rVariable);
		nameTable.put(id, displayName);
	}
	
	/**Remove the data series from the plot.
	 * @param id Identifier of the data series.
	 */
	public void removeData(final String id) {
		dataCommandTable.remove(id);
		nameTable.remove(id);
	}

	/**Returns the identifiers for the data series.
	 * @return the identifiers.
	 */
	protected String[] getDataSeries() {
		String[] identifiers = new String[dataCommandTable.keySet().size()];
		dataCommandTable.keySet().toArray(identifiers);
		Arrays.sort(identifiers);
		return identifiers;
	}

	/**Get the name for the data series.
	 * @param id The identifier of the data series.
	 * @return The name of the data series.
	 */
	protected String getName(final String id) {
		return nameTable.get(id);
	}

	/**Get the R variable for the data series.
	 * @param id The identifier of the data series.
	 * @return The name of the data series.
	 */
	protected String getDataCommand(final String id) {
		return dataCommandTable.get(id);
	}

	/** {@inheritDoc}
	 */
	public void visit(final IReportRenderingVisitor v) {
		v.visitGraphicReportItem(this);
	}

	/**Returns the complete path to the temporary file containing the graphic.
	 * @return The complete path.
	 */
	public String getTemporaryFilename() {
		if (dataCommandTable.size() == 0) {
			return null;
		} else {
			return temporaryFile.getAbsolutePath();
		}
	}

	/**Overwrite this method to generate custom graphics.
	 * @return The R command which execution leads to the creation of the plot.
	 */
	protected abstract String generatePlotCommand();

	/** {@inheritDoc}
	 */
	@Override
	public void generateData(final RConnection connection) {
		String rCommand = "";
		try {
			temporaryFile = File.createTempFile("pcm_pic", ".png");
			temporaryFile.deleteOnExit();

			rCommand += "png(\""
					+ temporaryFile.getAbsolutePath().replace(File.separator,
							"\\\\") + "\",height=" + graphicsHeight + ",width="
					+ graphicsWidth + ",pointsize=" + fontSize + ")\n";
			rCommand += generatePlotCommand();
			rCommand += "dev.off()\n";
		} catch (Exception e) {
			RVisualisationPlugin.log(IStatus.ERROR,
					"Could not create temporary graphic file. "
							+ e.getClass().getCanonicalName());
		}
		connection.execute(rCommand);
	}

	/**Returns the R commands which generate a line legend in R.
	 * @return The necessary R commands.
	 */
	protected String generateLinesLegend() {
		if (legendPosition == LegendPosition.none) {
			return "";
		}
		
		int pos = 0;
		String lines = "c(";
		String legend = "c(";

		for (String id : getDataSeries()) {
			String name = getName(id);
			String sep = (pos == 0 ? "" : ", ");
			lines += sep + (pos + 1);
			legend += sep + "\"" + name + "\"";
			pos++;
		}
		lines += ")";
		legend += ")";
		return "legend(\"" + legendPosition + "\", " + legend + ", lty="
				+ lines + ", bg='white')\n";
	}

	/**Returns the R commands which generate a color legend in R.
	 * @return The necessary R commads.
	 */
	protected String generateColorsLegend() {
		if (legendPosition == LegendPosition.none) {
			return "";
		}

		int pos = 0;
		String fill = "c(";
		String legend = "c(";

		for (String id : getDataSeries()) {
			String name = getName(id);
			String sep = (pos == 0 ? "" : ", ");
			fill += sep + "\"" + colors[pos] + "\"";
			legend += sep + "\"" + name + "\"";
			pos++;
		}
		fill += ")";
		legend += ")";
		return "legend(\"" + legendPosition + "\", " + legend + ", fill="
				+ fill + ", bg='white')\n";
	}

	/**Sets the legend position.
	 * @param newLegendPosition New position to set.
	 */
	public void setLegendPos(final LegendPosition newLegendPosition) {
		this.legendPosition = newLegendPosition;
	}
}
