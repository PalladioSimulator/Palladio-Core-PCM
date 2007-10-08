package de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;
import org.jfree.chart.entity.XYItemEntity;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.HistogramEntity;

public class ExportCSV extends Action {

	private ISeriesExporter viewer;

	public ExportCSV(ISeriesExporter freeChartHistogramViewer) {
		super();
		setText("Export CSV...");
		this.viewer = freeChartHistogramViewer;
	}
	
	@Override
	public void run() {
		FileDialog dialog = new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
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
		}catch(Exception e){
			e.printStackTrace();
			// TODO: Error Message Box
		}
	}
}
