package de.uka.ipd.sdq.codegen.rvisualisation.reportitems;

import java.io.File;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;

import de.uka.ipd.sdq.codegen.rvisualisation.RVisualisationPlugin;
import de.uka.ipd.sdq.codegen.rvisualisation.actions.RConnection;

public abstract class AbstractPlotReportItem extends AbstractRReportItem {

	private int bmpSize = 500;
	private String outputDir = "";
	private Map<String, String> dataCommandTable = new Hashtable<String, String>();
	private Map<String, String> nameTable = new Hashtable<String, String>();
	private File tempFile = null;
	private File pdfFile = null;
	protected String pdfFileName;
	private LegendPosition legendPosition = LegendPosition.topright;
	private String[] colors = new String[] { "black", "lightgray", "darkgray", "gray" };
	protected String xlabel = "Time [ms]";
	private boolean genPDF = true;
	private String description;

	public enum LegendPosition {
		top, topright, right, bottomright, bottom, bottomleft, left, topleft, center
	}

	protected abstract String generatePlotCommand();

	public AbstractPlotReportItem(boolean genPDF, String description) {
		super();
		this.genPDF = genPDF;
		this.description = description;
	}
	
	@Override
	public String getDescription() {
		return description;
	}

	public void addData(String id, String name, String dataCommand) {
		dataCommandTable.put(id, dataCommand);
		nameTable.put(id, name);
	}

	protected String[] getDataList() {
		String[] array = new String[dataCommandTable.keySet().size()];
		dataCommandTable.keySet().toArray(array);
		Arrays.sort(array);
		return array;
	}

	protected String getName(String id) {
		return nameTable.get(id);
	}

	protected String getDataCommand(String id) {
		return dataCommandTable.get(id);
	}

	public void visit(IReportRenderingVisitor v) {
		v.visitAbstractPlotItem(this);
	}

	public String getFilename() {
		if (dataCommandTable.size() == 0)
			return null;
		else
			return tempFile.getAbsolutePath();
	}

	@Override
	public void generateData(RConnection connection) {
		String rCommand = "";
		try {
			tempFile = File.createTempFile("pic", ".bmp");
			tempFile.deleteOnExit();

			if (genPDF) {
				pdfFile = new File(outputDir + pdfFileName);
				rCommand += "pdf(\""
						+ pdfFile.getAbsolutePath().replace(File.separator,
								"\\\\") + "\")\n";
				rCommand += generatePlotCommand();
				rCommand += "dev.off()\n";
			} else {
				rCommand += "bmp(\""
						+ tempFile.getAbsolutePath().replace(File.separator,
								"\\\\") + "\",height=" + bmpSize + ",width="
						+ bmpSize + ")\n";
				rCommand += generatePlotCommand();
				rCommand += "dev.off()\n";
			}

		} catch (Exception e) {
			RVisualisationPlugin.log(IStatus.ERROR,
					"Could not create temp file. "
							+ e.getClass().getCanonicalName());
		}
		System.out.println(rCommand);
		connection.execute(rCommand);
	}

	protected String generateLinesLegend() {
		int pos = 0;
		String lines = "c(";
		String legend = "c(";

		for (String id : getDataList()) {
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

	protected String generateColorsLegend() {
		int pos = 0;
		String fill = "c(";
		String legend = "c(";

		for (String id : getDataList()) {
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

	public String getOutputDir() {
		return outputDir;
	}

	public void setOutputDir(String outputDir) {
		this.outputDir = outputDir;
	}

	public void setLegendPos(LegendPosition legend_pos) {
		this.legendPosition = legend_pos;
	}

	public String getPdfFileName() {
		return pdfFileName;
	}

	public void setPdfFileName(String pdfFileName) {
		this.pdfFileName = pdfFileName;
	}

	public String getXlabel() {
		return xlabel;
	}

	public void setXlabel(String xlabel) {
		this.xlabel = xlabel;
	}

}