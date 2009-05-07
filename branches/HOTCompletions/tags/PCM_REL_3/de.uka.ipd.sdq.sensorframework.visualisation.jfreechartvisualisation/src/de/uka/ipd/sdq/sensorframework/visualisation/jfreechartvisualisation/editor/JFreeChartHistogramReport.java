package de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation.editor;


import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.sensorframework.visualisation.IVisualisation;
import de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation.AbstractJFreeChartWidthViewer;
import de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation.JFreeChartHistogramViewer;

public class JFreeChartHistogramReport extends AbstractJFreeChartWidthReport implements
		ITabbedPropertySheetPageContributor,
		IVisualisation<Histogram> {

	public static String EDITOR_ID = "de.uka.ipd.sdq.simucomframework.visualisation.JFreeChartHistogramReport";

	@Override
	protected AbstractJFreeChartWidthViewer createViewer(Composite parent,
			int flags) {
		return new JFreeChartHistogramViewer(parent, flags);
	}
}
