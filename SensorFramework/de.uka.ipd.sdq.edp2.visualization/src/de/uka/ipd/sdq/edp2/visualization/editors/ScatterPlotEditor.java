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
 * @author Dominik Ernst, Roland Richter
 */
public class ScatterPlotEditor extends JFreeChartEditor {
	/** Logger */
	private static Logger logger = Logger.getLogger(ScatterPlotEditor.class
			.getCanonicalName());
	
	/**
	 * This editor's title.
	 */
	private final static String EDITOR_NAME = "Scatterplot Editor";
	
	/**
	 * creates the components in this editor. It is called if a new Scatter Plot
	 * Editor is created. It sets the selected site of himself.
	 */
	@Override
	public void createPartControl(Composite parent) {
		this.parent = parent;
		setPartName(EDITOR_NAME);
		JFreeChart chart = createChart(input);
		chartContainer = new ChartComposite(parent, SWT.NONE, chart, true);
		getSite().setSelectionProvider(createSelectionProvider());
	}

	/*
	 * (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditor#createChart(org.eclipse.ui.IEditorInput)
	 */
	protected JFreeChart createChart(IDataSink input) {
		if (input instanceof ScatterPlotInput) {
			ScatterPlotInput scatterPlotInput = (ScatterPlotInput) input;
			scatterPlotInput.updateDataset();
			JFreeChart chart = ChartFactory.createScatterPlot(
					scatterPlotInput.getName(),
					"x-Label",
					"y-Label",
					scatterPlotInput.getDataset(),
					PlotOrientation.VERTICAL, true, true, false);

			return chart;
		}
		return null;
	}

}
