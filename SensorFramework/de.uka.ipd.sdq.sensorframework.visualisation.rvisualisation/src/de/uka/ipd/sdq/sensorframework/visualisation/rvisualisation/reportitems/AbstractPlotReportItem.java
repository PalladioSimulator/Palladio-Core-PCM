package de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;

import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.RVisualisationPlugin;
import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.utils.RConnection;

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
	private File temporaryRasterGraphicFile = null;
	/** The temporary graphic file. */
	private File temporaryVectorGraphicFile = null;
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
	@Override
	public void visit(final IReportRenderingVisitor v) {
		v.visitGraphicReportItem(this);
	}

	/**Returns the complete path to the temporary file containing the 
	 * raster graphic.
	 * @return The complete path.
	 */
	public String getTemporaryRasterGraphicFilename() {
		if (dataCommandTable.size() == 0) {
			return null;
		} else {
			return temporaryRasterGraphicFile.getAbsolutePath();
		}
	}

	/**Returns the complete path to the temporary file containing the 
	 * vector graphic.
	 * @return The complete path.
	 */
	public String getTemporaryVectorGraphicFilename() {
		if (dataCommandTable.size() == 0) {
			return null;
		} else {
			return temporaryVectorGraphicFile.getAbsolutePath();
		}
	}
	
	/**Overwrite this method to generate custom graphics.
	 * @return The R command which execution leads to the creation of the plot.
	 */
	protected abstract String generatePlotCommand();

	/**Exports the plot as vector graphic in the PDF format.
	 * @param pdfFile The file to which the graphic is saved.
	 * @param rConnection The connection to the R engine.
	 */
	public void generateVectorGraphic(final File pdfFile, 
			final RConnection rConnection) {
		String rCommand = "";
		try {
			rCommand += "pdf(\""
					+ pdfFile.getAbsolutePath().replace("\\",
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

	/**Exports the plot as raster graphic in the PNG format.
	 * @param pngFile The file to which the graphic is saved.
	 * @param rConnection The connection to the R engine.
	 */
	public void generateRasterGraphic(final File pngFile, 
			final RConnection rConnection) {
		String rCommand = "";
		try {
			rCommand += "png(\""
					+ pngFile.getAbsolutePath().replace("\\",
							"\\\\") + "\",height=" + graphicsHeight + ",width="
					+ graphicsWidth + ",pointsize=" + fontSize + ")\n";
			rCommand += generatePlotCommand();
			rCommand += "dev.off()\n";
		} catch (Exception e) {
			RVisualisationPlugin.log(IStatus.ERROR,
					"Could not create temporary graphic file. "
							+ e.getClass().getCanonicalName());
		}
		rConnection.execute(rCommand);
	}

	/** {@inheritDoc}
	 */
	public void generateData(final RConnection connection) {
		// generate raster image
		try {
			temporaryRasterGraphicFile = 
				File.createTempFile("pcm_pic", ".png");
			temporaryRasterGraphicFile.deleteOnExit();
			generateRasterGraphic(temporaryRasterGraphicFile, connection);
		} catch (IOException e) {
			RVisualisationPlugin.log(IStatus.ERROR,
					"Could not create temporary raster graphic file. "
							+ e.getClass().getCanonicalName());
		}
		
		// generate vector image
		try {
			temporaryVectorGraphicFile = 
				File.createTempFile("pcm_pic", ".pdf");
			temporaryVectorGraphicFile.deleteOnExit();
			generateVectorGraphic(temporaryVectorGraphicFile, connection);
		} catch (IOException e) {
			RVisualisationPlugin.log(IStatus.ERROR,
					"Could not create temporary vector graphic file. "
							+ e.getClass().getCanonicalName());
		}
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
			fill += sep + "\"" + colors[pos % colors.length] + "\"";
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
