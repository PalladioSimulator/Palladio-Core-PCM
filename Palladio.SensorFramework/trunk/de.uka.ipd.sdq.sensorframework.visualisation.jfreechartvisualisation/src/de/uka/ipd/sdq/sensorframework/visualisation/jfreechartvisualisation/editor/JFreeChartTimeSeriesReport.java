package de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation.editor;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.TimeSeries;
import de.uka.ipd.sdq.sensorframework.adapter.AdapterRegistry;
import de.uka.ipd.sdq.sensorframework.adapter.IAdapter;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.AbstractReportView;
import de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation.JFreeChartTimeSeriesViewer;

public class JFreeChartTimeSeriesReport extends AbstractReportView implements
		ITabbedPropertySheetPageContributor, IVisualisation {

	public static String EDITOR_ID = "de.uka.ipd.sdq.simucomframework.visualisation.JFreeChartTimeSeriesReport";
	JFreeChartTimeSeriesViewer viewer;
	

	@Override
	protected void createReportControls(Composite parent) {
		viewer = new JFreeChartTimeSeriesViewer(parent, 0);
	}

	@Override
	public void addInput(Collection<?> c) {
		
	}

	@Override
	public void deleteInput(Collection<?> c) {
		
	}

	@Override
	public void setInput(Collection<?> c) {
		
		ArrayList<Object> result = new ArrayList<Object>();
		for (Object o : c) {
			if (o instanceof SensorAndMeasurements){
				IAdapter adapter = AdapterRegistry.singleton().getAdapter(o, TimeSeries.class);
				if (adapter != null)
					result.add(adapter);
			} 
		}
		viewer.setData(result);
	}
}
