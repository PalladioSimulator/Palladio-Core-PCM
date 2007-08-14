package de.uka.ipd.sdq.sensorframework.visualisation.birt.editor;


import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.birt.chart.device.IDeviceRenderer;
import org.eclipse.birt.chart.exception.ChartException;
import org.eclipse.birt.chart.internal.log.DefaultLoggerImpl;
import org.eclipse.birt.chart.util.PluginSettings;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.sensorframework.adapter.AdapterRegistry;
import de.uka.ipd.sdq.sensorframework.adapter.IAdapter;
import de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation;
import de.uka.ipd.sdq.sensorframework.visualisation.birt.ChartSwtViewer;
import de.uka.ipd.sdq.sensorframework.visualisation.birt.HistogramChartVisualization;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.AbstractReportView;

public class BirtHistogramReport extends AbstractReportView implements
		ITabbedPropertySheetPageContributor,
		IVisualisation {

	public static String EDITOR_ID = "de.uka.ipd.sdq.sensorframework.visualisation.birt.editor.BirtHistogramReport";
	
	HistogramChartVisualization visualization;
	
	public void createReportControls(Composite parent){
		visualization = new HistogramChartVisualization(parent);
	}

	/**
	 * @return the visualization
	 */
	public HistogramChartVisualization getVisualization() {
		return visualization;
	}
	
	@Override
	public void addInput(Collection c) {
	}

	@Override
	public void deleteInput(Collection c) {
	}

	@Override
	public void setInput(Collection c) {
		ArrayList<IAdapter> adapters = new ArrayList<IAdapter>();
		for (Object o : c) {
			IAdapter adapter = AdapterRegistry.singleton().getAdapter(o,
					Histogram.class);
			if (adapter != null)
				adapters.add(adapter);
		}
		visualization.initChart(adapters);
	}

}
