package de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation.editor;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.swt.widgets.Composite;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.AbstractPie;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.TimeDeltaPie;
import de.uka.ipd.sdq.sensorframework.adapter.DataAdapter;
import de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.AbstractReportView;
import de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation.JFreeChartPieViewer;

public class JFreeChartPieReport extends AbstractReportView implements
		IVisualisation<AbstractPie> {

	public static String JFREECHART_PIE_EDITOR_ID = "de.uka.ipd.sdq.simucomframework.visualisation.JFreeChartPieReport";
	
	private JFreeChartPieViewer viewer;
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		viewer.setFocus();
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.visualisation.editor.AbstractReportView#createReportControls(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createReportControls(Composite parent) {
		viewer = new JFreeChartPieViewer(parent,0);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation#setInput(java.util.Collection)
	 */
	public void setInput(Collection<AbstractPie> c) {
		if (!c.isEmpty()) {
			viewer.setData(c);
		} else
			viewer.setData(new TimeDeltaPie("Empty Datasource"));
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.visualisation.editor.AbstractReportView#setInput(java.util.List)
	 */
	@Override
	protected void generateVisualization(List<DataAdapter> list) {
		ArrayList<AbstractPie> viewerInput = new ArrayList<AbstractPie>();
		for (DataAdapter a : list)
			viewerInput.add((AbstractPie) a.getAdaptedObject());
		this.setInput(viewerInput);
	}	
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation#addInput(java.util.Collection)
	 */
	public void addInput(Collection<AbstractPie> c) {
		// The implementation is not necessary.
		
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation#deleteInput(java.util.Collection)
	 */
	public void deleteInput(Collection<AbstractPie> c) {
		// The implementation is not necessary.
	}
}
