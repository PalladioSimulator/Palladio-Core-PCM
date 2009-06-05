package de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.HistogramBucketInformation;

public class LoadCSVHistogram extends Action {
	private Histogram histogram = null;
	private IHistogramAccepter viewer;
	
	public Histogram getHistogram() {
		return histogram;
	}

	public LoadCSVHistogram(IHistogramAccepter freeChartHistogramViewer) {
		super();
		setText("Load CSV...");
		this.viewer = freeChartHistogramViewer;
	}
	
	@Override
	public void run() {
		FileDialog dialog = new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
		dialog.open();
		if (dialog.getFileName() != null){
			this.histogram = importHistogram(dialog.getFilterPath()+File.separator+dialog.getFileName());
		}
		viewer.addHistogram(histogram);
	}

	private Histogram importHistogram(String fileName) {
		Histogram h = new Histogram("Measurements");
		FileReader fileReader;
		BufferedReader bufferedReader;
		try {
			String row;
			fileReader = new FileReader(fileName);
			bufferedReader = new BufferedReader(fileReader);
			while((row=bufferedReader.readLine()) != null)
			{
				String[] parts = row.split(";");
				double x = Double.parseDouble(parts[0].replace(',','.'));
				double y = Double.parseDouble(parts[1].replace(',','.'));
				h.addEntity(new HistogramBucketInformation(y, x));
			}
		} catch(Exception e) {
			return null;
			// TODO: Error Message Box
		}
		for (HistogramBucketInformation e:h.getBucketInformation())
			System.out.print("runif("+Math.round(e.getProbability()*100000)+","+(e.getValue()-5)+","+(e.getValue()+5)+"),");
		return h;
	}
}
