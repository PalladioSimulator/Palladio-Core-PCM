package de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.apache.log4j.Logger;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;

public class ExportCSV extends Action {
	/** Logger for this class. */
	private static final Logger logger = Logger.getLogger(ExportCSV.class);

	private ISeriesExporter viewer;

	public ExportCSV(ISeriesExporter freeChartHistogramViewer) {
		super();
		setText("Export CSV...");
		this.viewer = freeChartHistogramViewer;
	}

	@Override
	public void run() {
		FileDialog dialog = new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.SAVE);
		dialog.open();
		if (dialog.getFileName() != null){
			exportCSV(dialog.getFilterPath() + File.separatorChar + dialog.getFileName(), viewer.getSeries());
		}
	}

	private void exportCSV(String filename, XYSeries series) {
		FileWriter fileWriter;
		BufferedWriter bufferedWriter;
		try{
			fileWriter = new FileWriter(filename);
			bufferedWriter = new BufferedWriter(fileWriter);
			for(Object item : series.getItems()){
				XYDataItem data = (XYDataItem) item;
				bufferedWriter.append((data.getX()+";"+data.getY()+"\n").replace(".", ","));
			}
			bufferedWriter.close();
			fileWriter.close();
		} catch(Exception e) {
			logger.error("Error writing CSV file.", e);
		}
	}
}
