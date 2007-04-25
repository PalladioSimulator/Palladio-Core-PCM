package de.uka.ipd.sdq.codegen.simudatavisualization.views;


import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.birt.chart.device.IDeviceRenderer;
import org.eclipse.birt.chart.exception.ChartException;
import org.eclipse.birt.chart.internal.log.DefaultLoggerImpl;
import org.eclipse.birt.chart.util.PluginSettings;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Pie;
import de.uka.ipd.sdq.codegen.simudatavisualization.birt.ChartVisualization;
import de.uka.ipd.sdq.codegen.simudatavisualization.editor.AbstractReportView;
import de.uka.ipd.sdq.codegen.simudatavisualization.jfreechart.JFreeChartHistogramViewer;
import de.uka.ipd.sdq.codegen.simudatavisualization.jfreechart.JFreeChartPieViewer;
import de.uka.ipd.sdq.sensorframework.adapter.AdapterRegistry;
import de.uka.ipd.sdq.sensorframework.adapter.IAdapter;
import de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation;

public class JFreeChartPieReport extends AbstractReportView implements
		ITabbedPropertySheetPageContributor,
		IVisualisation {

	public static String JFREECHART_PIE_EDITOR_ID = "de.uka.ipd.sdq.codegen.simudatavisualization.views.JFreeChartPieReport";
	
	JFreeChartPieViewer myViewer;
	
	public void createReportControls(Composite parent){
		myViewer = new JFreeChartPieViewer(parent,0);
	}
	
	@Override
	public void addInput(Collection c) {
	}

	@Override
	public void deleteInput(Collection c) {
	}

	@Override
	public void setInput(Collection c) {
		IAdapter adapter = AdapterRegistry.singleton().getAdapter(c.iterator().next(),
					Pie.class);
		if (adapter != null){
			myViewer.setPie((Pie)adapter.getAdaptedObject());
		}
	}

}
