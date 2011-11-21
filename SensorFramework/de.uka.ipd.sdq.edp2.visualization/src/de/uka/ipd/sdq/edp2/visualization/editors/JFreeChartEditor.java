package de.uka.ipd.sdq.edp2.visualization.editors;

import java.util.logging.Logger;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.EditorPart;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.event.ChartChangeEvent;
import org.jfree.chart.event.ChartChangeListener;
import org.jfree.experimental.chart.swt.ChartComposite;

import de.uka.ipd.sdq.edp2.visualization.IDataSink;
import de.uka.ipd.sdq.edp2.visualization.IEditorInputHandle;

/**
 * Implementation of an {@link EditorPart}, which is responsible for showing
 * different subclasses of {@link JFreeChart}.
 * 
 * @author Dominik Ernst
 */
public class JFreeChartEditor extends AbstractEditor implements ChartChangeListener {
	
	/** This editor's ID, e.g. for Referencing in extension points. */
	public static final String EDITOR_ID = "de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditor";
	/**
	 * Title of this Editor.
	 */
	private final static String EDITOR_NAME = "JFreeChartEditor";
	
	private static final String TITLE_KEY = "chartTitle";

	/** Logger for this class */
	private static Logger logger = Logger.getLogger(JFreeChartEditor.class
			.getCanonicalName());
	
	/** The composite of the parent element, for reference if a new chart is added.*/
	protected Composite parent;
	/** The container in which a {@link JFreeChart} is contained. */
	protected ChartComposite chartContainer;
	/**
	 * The current chart.
	 */
	JFreeChart chart;
	
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		this.parent = parent;
		setPartName(EDITOR_NAME);
		setTitleToolTip(EDITOR_NAME);
		chart = getEditorInputHandle().createChart();
		chartContainer = new ChartComposite(parent, SWT.NONE, chart, true);
		getSite().setSelectionProvider(createSelectionProvider());
	}
	
	/**
	 * Method, which describes the default updating process of the current chart.
	 */
	public void updateChart() {
		chart.removeChangeListener(this);
		chart = ((JFreeChartEditorInputHandle)getEditorInput()).createChart();
		chart.addChangeListener(this);
		chartContainer.setChart(chart);
		chartContainer.forceRedraw();
	}

	@Override
	public void chartChanged(ChartChangeEvent event) {
		updateChart();
	}

	@Override
	public JFreeChartEditorInputHandle getEditorInputHandle() {
		return (JFreeChartEditorInputHandle)input;
	}
}
