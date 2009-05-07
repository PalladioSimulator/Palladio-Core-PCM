package de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation.editor;



import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation;
import de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation.AbstractJFreeChartWidthViewer;
import de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation.JFreeChartCDFViewer;

public class JFreeChartCDFReport extends AbstractJFreeChartWidthReport implements
		ITabbedPropertySheetPageContributor,
		IVisualisation<Histogram> {

	public static String EDITOR_ID = "de.uka.ipd.sdq.simucomframework.visualisation.JFreeChartCDFReport";

	@Override
	protected AbstractJFreeChartWidthViewer createViewer(Composite parent,
			int flags) {
		return new JFreeChartCDFViewer(parent, flags);
	}
}
