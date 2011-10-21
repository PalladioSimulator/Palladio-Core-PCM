package de.uka.ipd.sdq.edp2.visualization.editors;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistableEditor;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.internal.presentations.UpdatingActionContributionItem;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.experimental.chart.swt.ChartComposite;

import de.uka.ipd.sdq.edp2.visualization.IDataSink;
import de.uka.ipd.sdq.edp2.visualization.IVisualization;
import de.uka.ipd.sdq.edp2.visualization.datasource.EDP2Source;

/**
 * Implementation of an {@link EditorPart}, which is responsible for showing
 * different subclasses of {@link JFreeChart}.
 * 
 * @author Dominik Ernst
 */
public class JFreeChartEditor extends AbstractEditor {
	
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
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		this.parent = parent;
		setPartName(EDITOR_NAME);
		JFreeChart chart = ((JFreeChartEditorInput) getEditorInput()).createChart();
		chartContainer = new ChartComposite(parent, SWT.NONE, chart, true);
		getSite().setSelectionProvider(createSelectionProvider());
	}
	
	/**
	 * Method, which describes the default updating process of the current chart.
	 */
	public void updateChart() {
		JFreeChart chart =  ((JFreeChartEditorInput)getEditorInput()).createChart();
		chartContainer.setChart(chart);
		chartContainer.forceRedraw();
	}

	/*
	 * (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.visualization.editors.AbstractEditor#changeInput(org.eclipse.ui.IEditorInput)
	 */
	public void changeInput(IDataSink newInput) {
		setInput(input);
		updateChart();
	}

}
