package de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation.editor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.TimeSeries;
import de.uka.ipd.sdq.sensorframework.adapter.IAdapter;
import de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.AbstractReportView;
import de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation.JFreeChartTimeSeriesViewer;

public class JFreeChartTimeSeriesReport extends AbstractReportView implements
		ITabbedPropertySheetPageContributor, IVisualisation<TimeSeries> {

	public static String EDITOR_ID = "de.uka.ipd.sdq.simucomframework.visualisation.JFreeChartTimeSeriesReport";
	JFreeChartTimeSeriesViewer viewer;
	

	@Override
	protected void createReportControls(Composite parent) {
		viewer = new JFreeChartTimeSeriesViewer(parent, 0);
	}

	public void addInput(Collection<TimeSeries> c) {
		
	}

	public void deleteInput(Collection<TimeSeries> c) {
		
	}

	public void setInput(Collection<TimeSeries> c) {
		viewer.setData(c);
	}
	
	@Override
	protected void setInput(List<IAdapter> list) {
		ArrayList<TimeSeries> viewerInput = new ArrayList<TimeSeries>();
		for (IAdapter a : list)
			viewerInput.add((TimeSeries) a.getAdaptedObject());
		this.setInput(viewerInput);
	}	
}
