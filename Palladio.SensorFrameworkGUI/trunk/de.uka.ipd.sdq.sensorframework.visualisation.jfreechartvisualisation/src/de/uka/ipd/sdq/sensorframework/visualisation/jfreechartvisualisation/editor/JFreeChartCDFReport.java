package de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation.editor;


import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.sensorfactory.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.adapter.AdapterRegistry;
import de.uka.ipd.sdq.sensorframework.adapter.IAdapter;
import de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.AbstractReportView;
import de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation.JFreeChartCDFViewer;
import de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation.JFreeChartHistogramViewer;

public class JFreeChartCDFReport extends AbstractReportView implements
		ITabbedPropertySheetPageContributor,
		IVisualisation {

	public static String EDITOR_ID = "de.uka.ipd.sdq.simucomframework.visualisation.JFreeChartCDFReport";
	
	JFreeChartCDFViewer myViewer;
	
	public void createReportControls(Composite parent){
		myViewer = new JFreeChartCDFViewer(parent,0);
	}
	
	public void addInput(Collection c) {
	}

	public void deleteInput(Collection c) {
	}

	public void setInput(Collection c) {
		ArrayList result = new ArrayList();
		for (Object o : c) {
			if (true || !(o instanceof SensorAndMeasurements)){
				IAdapter adapter = AdapterRegistry.singleton().getAdapter(o,
						Histogram.class);
				if (adapter != null)
					result.add(adapter);
			} else {
				result.add(o);
			}
		}
		myViewer.setCDFs(result);
	}

}
