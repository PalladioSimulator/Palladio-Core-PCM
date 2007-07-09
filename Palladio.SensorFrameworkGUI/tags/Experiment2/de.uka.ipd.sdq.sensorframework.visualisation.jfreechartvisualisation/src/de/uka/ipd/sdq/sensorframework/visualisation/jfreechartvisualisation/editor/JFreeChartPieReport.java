package de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation.editor;


import java.util.Collection;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Pie;
import de.uka.ipd.sdq.sensorframework.adapter.AdapterRegistry;
import de.uka.ipd.sdq.sensorframework.adapter.IAdapter;
import de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.AbstractReportView;
import de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation.JFreeChartPieViewer;

public class JFreeChartPieReport extends AbstractReportView implements
		ITabbedPropertySheetPageContributor,
		IVisualisation {

	public static String JFREECHART_PIE_EDITOR_ID = "de.uka.ipd.sdq.simucomframework.visualisation.JFreeChartPieReport";
	
	JFreeChartPieViewer myViewer;
	
	public void createReportControls(Composite parent){
		myViewer = new JFreeChartPieViewer(parent,0);
	}
	
	public void addInput(Collection c) {
	}

	public void deleteInput(Collection c) {
	}

	public void setInput(Collection c) {
		if (!c.isEmpty()) {
			IAdapter adapter = AdapterRegistry.singleton().getAdapter(
					c.iterator().next(), Pie.class);
			if (adapter != null)
				myViewer.setPie((Pie) adapter.getAdaptedObject());
		} else
			myViewer.setPie(new Pie("Empty Datasource"));
	}
}
