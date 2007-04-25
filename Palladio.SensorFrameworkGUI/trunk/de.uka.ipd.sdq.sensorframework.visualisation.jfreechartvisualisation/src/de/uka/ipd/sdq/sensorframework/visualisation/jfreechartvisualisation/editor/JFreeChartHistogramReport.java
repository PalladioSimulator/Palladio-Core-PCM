package de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation.editor;


import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.sensorframework.adapter.AdapterRegistry;
import de.uka.ipd.sdq.sensorframework.adapter.IAdapter;
import de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.AbstractReportView;
import de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation.JFreeChartHistogramViewer;

public class JFreeChartHistogramReport extends AbstractReportView implements
		ITabbedPropertySheetPageContributor,
		IVisualisation {

	public static String EDITOR_ID = "de.uka.ipd.sdq.simucomframework.visualisation.JFreeChartHistogramReport";
	
	JFreeChartHistogramViewer myViewer;
	
	public void createReportControls(Composite parent){
		myViewer = new JFreeChartHistogramViewer(parent,0);
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
		myViewer.setHistograms(adapters);
	}

}
