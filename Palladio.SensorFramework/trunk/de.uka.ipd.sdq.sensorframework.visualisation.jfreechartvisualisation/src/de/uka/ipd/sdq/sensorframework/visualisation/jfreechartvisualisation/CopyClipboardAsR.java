package de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.PlatformUI;
import org.jfree.chart.entity.XYItemEntity;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYSeries;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.HistogramEntity;

public class CopyClipboardAsR extends Action {

	private ISeriesExporter viewer;

	public CopyClipboardAsR(ISeriesExporter freeChartHistogramViewer) {
		super();
		setText("Copy Values to Clipboard using R format...");
		this.viewer = freeChartHistogramViewer;
	}

	@Override
	public void run() {
		exportValues(viewer.getSeries());
	}

	private void exportValues(XYSeries series) {
		Clipboard clipboard = new Clipboard(PlatformUI.getWorkbench().getDisplay());
		StringBuffer plainText = new StringBuffer("c(");
		for(Object item : series.getItems()){
			XYDataItem data = (XYDataItem) item;
			plainText.append(data.getY()+",");
		}
		TextTransfer textTransfer = TextTransfer.getInstance();
		clipboard.setContents(new String[] { plainText.substring(0, plainText.length()-1)+")" },
				new Transfer[] { textTransfer });
		clipboard.dispose();
	}
}
