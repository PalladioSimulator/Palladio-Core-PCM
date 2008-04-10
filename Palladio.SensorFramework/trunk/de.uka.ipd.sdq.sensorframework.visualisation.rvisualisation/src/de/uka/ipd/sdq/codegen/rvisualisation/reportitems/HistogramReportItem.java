package de.uka.ipd.sdq.codegen.rvisualisation.reportitems;



public class HistogramReportItem extends AbstractPlotReportItem implements IReportItem {

	private int columns;

	public HistogramReportItem(boolean genPDF, String description) {
		super(genPDF, description);
		pdfFileName = "hist.pdf";
	}

	
	@Override
	protected String generatePlotCommand() {

		String rCommand = "require(plotrix)\n";

		String list = "l = list(";
		int pos = 0;
		for (String id : getDataList()) {
			String data = getDataCommand(id);
			String odata = data + "_";
			rCommand += outlierRemovalCommands(data, odata);
			String sep = (pos == 0 ? "" : ", ");
			list += sep + odata;
			pos++;
		}
		list += ")\n";

		rCommand += list;
		rCommand += "multhist(l, breaks=" + columns + ", freq=FALSE, "
				+ "main=\"Histogram\", " + "title=\"Hist\", "
				+ "xlab=\"" + xlabel + "\", " + "ylab=\"Density\")\n";
		rCommand += generateColorsLegend();
		return rCommand;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

}
