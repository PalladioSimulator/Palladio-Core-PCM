package de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.ui.PlatformUI;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;

public class ExportDoublePDF extends Action {

	private IHistSeriesExporter viewer;

	public ExportDoublePDF(IHistSeriesExporter freeChartHistogramViewer) {
		super();
		setText("Copy to Clipboard as DoublePDF...");
		this.viewer = freeChartHistogramViewer;
	}
	
	@Override
	public void run() {
		String pdf = exportCSV(viewer.getSeries());
		Clipboard clipboard = new Clipboard(PlatformUI.getWorkbench().getDisplay());
		TextTransfer textTransfer = TextTransfer.getInstance();
		clipboard.setContents(new String[] { pdf },
				new Transfer[] { textTransfer });
		clipboard.dispose();
	}

	private String exportCSV(XYSeries series) {
		String result = "DoublePDF["; 
		double lastProb = 0;
		double lastX = 0;
		for(Object item : series.getItems()){
			XYDataItem data = (XYDataItem) item;
			result += "(" + (data.getX().doubleValue() - viewer.getHistogramWidth() / 2) + ";" + lastProb + ")";
			lastProb = data.getY().doubleValue();
			lastX = data.getX().doubleValue();
		}		
		return result + "("+(lastX+viewer.getHistogramWidth()/2)+";"+lastProb+")]";
	}
}
