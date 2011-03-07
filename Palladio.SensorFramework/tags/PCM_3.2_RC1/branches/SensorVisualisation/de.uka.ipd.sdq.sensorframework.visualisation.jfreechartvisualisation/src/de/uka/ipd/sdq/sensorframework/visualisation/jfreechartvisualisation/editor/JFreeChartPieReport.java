package de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation.editor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.swt.widgets.Composite;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Pie;
import de.uka.ipd.sdq.sensorframework.adapter.DataAdapter;
import de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.AbstractReportView;
import de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation.JFreeChartPieViewer;

public class JFreeChartPieReport extends AbstractReportView implements
		IVisualisation<Pie> {

	public static String JFREECHART_PIE_EDITOR_ID = "de.uka.ipd.sdq.simucomframework.visualisation.JFreeChartPieReport";

	private JFreeChartPieViewer viewer;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		viewer.setFocus();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.sensorframework.visualisation.editor.AbstractReportView
	 * #createReportControls(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createReportControls(Composite parent) {
		viewer = new JFreeChartPieViewer(parent, 0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation#setInput(
	 * java.util.Collection)
	 */
	public void setInput(Collection<Pie> c) {
		if (!c.isEmpty()) {
			viewer.setData(c);
		} else
			viewer.setData(new Pie("Empty Datasource"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.sensorframework.visualisation.editor.AbstractReportView
	 * #setInput(java.util.List)
	 */
	@Override
	protected void generateVisualization(List<DataAdapter> list) {
		ArrayList<Pie> viewerInput = new ArrayList<Pie>();
		for (DataAdapter a : list)
			viewerInput.add((Pie) a.getAdaptedObject());
		this.setInput(viewerInput);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation#addInput(
	 * java.util.Collection)
	 */
	public void addInput(Collection<Pie> c) {
		// The implementation is not necessary.

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation#deleteInput
	 * (java.util.Collection)
	 */
	public void deleteInput(Collection<Pie> c) {
		// The implementation is not necessary.
	}
}
