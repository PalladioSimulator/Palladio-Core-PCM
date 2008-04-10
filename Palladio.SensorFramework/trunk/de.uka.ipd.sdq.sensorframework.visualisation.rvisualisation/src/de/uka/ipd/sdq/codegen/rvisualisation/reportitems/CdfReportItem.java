package de.uka.ipd.sdq.codegen.rvisualisation.reportitems;

public class CdfReportItem extends AbstractPlotReportItem implements
		IReportItem {

	public CdfReportItem(boolean genPDF, String description) {
		super(genPDF, description);
		pdfFileName = "cdf.pdf";
	}

	@Override
	protected String generatePlotCommand() {

		int pos = 0;
		String outlier = "";
		String sort = "";
		String range = "r = range(";
		String plot = "";

		for (String id : getDataList()) {
			String data = getDataCommand(id);
			String odata = data + "_";
			String sdata = "s_" + data;
			String sep = (pos == 0 ? "" : ", ");

			outlier += outlierRemovalCommands(data, odata);
			range += sep + odata;
			sort += sdata + " = sort(" + odata + ")\n";

			if (pos == 0) {
				plot += "plot(ecdf(" + sdata + "), xlim=r, "
						+ "do.points=FALSE, " + "verticals=TRUE, "
						+ "main=\"Cumulative Distribution Function\", "
						+ "xlab=\""+ xlabel + "\", " + "ylab=\"F(t)\")\n";
			} else {
				plot += "lines(" + sdata + ", (1:length(" + sdata + "))/length("
						+ sdata + " ),type=\"s\", lty=" + (pos+1) +")\n";
			}

			pos++;
		}
		range += ")\n";

		String rCommand = outlier + sort + range + plot;
		rCommand += generateLinesLegend();
		return rCommand;
	}
}
