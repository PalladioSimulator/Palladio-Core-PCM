package de.uka.ipd.sdq.edp2.visualization.editors;

import java.util.logging.Logger;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.EditorPart;
import org.jfree.chart.JFreeChart;
import org.jfree.experimental.chart.swt.ChartComposite;

/**
 * Implementation of an {@link EditorPart}, which is responsible for showing
 * different subclasses of {@link JFreeChart}.
 * 
 * @author Dominik Ernst, Roland Richter
 */
public class ScatterPlotEditor extends JFreeChartEditor {
	/** Logger */
	private static Logger logger = Logger.getLogger(ScatterPlotEditor.class
			.getCanonicalName());
	
	/**
	 * This editor's title.
	 */
	private final static String EDITOR_NAME = "Scatterplot";
	
	/**
	 * creates the components in this editor. It is called if a new Scatter Plot
	 * Editor is created. It sets the selected site of himself.
	 */
	@Override
	public void createPartControl(Composite parent) {
		this.parent = parent;
		setPartName(EDITOR_NAME);
		JFreeChart chart = ((JFreeChartEditorInput)getEditorInput()).createChart();
		chartContainer = new ChartComposite(parent, SWT.NONE, chart, true);
		getSite().setSelectionProvider(createSelectionProvider());
	}

}
