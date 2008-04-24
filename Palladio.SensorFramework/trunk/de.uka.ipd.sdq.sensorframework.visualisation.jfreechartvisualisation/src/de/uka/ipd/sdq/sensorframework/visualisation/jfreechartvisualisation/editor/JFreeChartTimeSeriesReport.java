package de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation.editor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.TimeSeries;
import de.uka.ipd.sdq.sensorframework.adapter.DataAdapter;
import de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.AbstractReportView;
import de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation.JFreeChartTimeSeriesViewer;

public class JFreeChartTimeSeriesReport extends AbstractReportView implements
		ITabbedPropertySheetPageContributor, IVisualisation<TimeSeries> {

	public static String EDITOR_ID = "de.uka.ipd.sdq.simucomframework.visualisation.JFreeChartTimeSeriesReport";
	JFreeChartTimeSeriesViewer viewer;
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.visualisation.editor.AbstractReportView#createReportControls(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createReportControls(Composite parent) {
		viewer = new JFreeChartTimeSeriesViewer(parent, 0);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.visualisation.editor.AbstractReportView#setInput(java.util.List)
	 */
	@Override
	protected void generateVisualization(List<DataAdapter> list) {
		ArrayList<TimeSeries> viewerInput = new ArrayList<TimeSeries>();
		for (DataAdapter a : list)
			viewerInput.add((TimeSeries) a.getAdaptedObject());
		this.setInput(viewerInput);
	}


	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation#addInput(java.util.Collection)
	 */
	public void addInput(Collection<TimeSeries> c) {
		// The implementation is not necessary.
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation#deleteInput(java.util.Collection)
	 */
	public void deleteInput(Collection<TimeSeries> c) {
		// The implementation is not necessary.
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation#setInput(java.util.Collection)
	 */
	public void setInput(Collection<TimeSeries> c) {
		viewer.setData(c);
	}


	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		viewer.setFocus();
	}

}
