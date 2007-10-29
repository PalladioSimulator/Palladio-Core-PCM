package de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation.editor;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Pie;
import de.uka.ipd.sdq.sensorframework.adapter.IAdapter;
import de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.AbstractReportView;
import de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation.JFreeChartPieViewer;

public class JFreeChartPieReport extends AbstractReportView implements
		ITabbedPropertySheetPageContributor,
		IVisualisation<Pie> {

	public static String JFREECHART_PIE_EDITOR_ID = "de.uka.ipd.sdq.simucomframework.visualisation.JFreeChartPieReport";
	
	JFreeChartPieViewer myViewer;
	
	public void createReportControls(Composite parent){
		myViewer = new JFreeChartPieViewer(parent,0);
	}
	
	public void addInput(Collection<Pie> c) {
	}

	public void deleteInput(Collection<Pie> c) {
	}

	public void setInput(Collection<Pie> c) {
		if (!c.isEmpty()) {
			myViewer.setData(c);
		} else
			myViewer.setData(new Pie("Empty Datasource"));
	}
	
	@Override
	protected void setInput(List<IAdapter> list) {
		ArrayList<Pie> viewerInput = new ArrayList<Pie>();
		for (IAdapter a : list)
			viewerInput.add((Pie) a.getAdaptedObject());
		this.setInput(viewerInput);
	}	
}
