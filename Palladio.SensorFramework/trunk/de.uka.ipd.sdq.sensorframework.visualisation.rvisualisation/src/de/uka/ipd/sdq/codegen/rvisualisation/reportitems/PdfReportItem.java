package de.uka.ipd.sdq.codegen.rvisualisation.reportitems;


public class PdfReportItem extends AbstractPlotReportItem implements IReportItem {

	private boolean outlierRemoval;

	public PdfReportItem(boolean genPDF, boolean outlierRemoval, String description) {
		super(genPDF, description);
		pdfFileName = "pdf.pdf";
		this.outlierRemoval = outlierRemoval;
	}

	@Override
	protected String generatePlotCommand() {

		int pos = 0;
		String outlier = "";
		String plot = "";

		for (String id : getDataList()) {
			String data = getDataCommand(id);
			
			String odata = outlierRemoval ? data + "_" : data;
			outlier += outlierRemoval ? outlierRemovalCommands(data, odata) : "";

			if (pos == 0) {
				plot += "plot(density(" + odata + "), "
						+ "do.points=FALSE, " + "verticals=TRUE, "
						+ "main=\"Probability Density Function\", "
						+ "xlab=\"" + xlabel + "\", " + "ylab=\"f(t)\")\n";
			} else {
				plot += "lines(density(" + odata + "),type=\"s\", lty=" + (pos+1) +")\n";
			}

			pos++;
		}

		String rCommand = outlier + plot;
		rCommand += generateLinesLegend();
		return rCommand;
	}

}
