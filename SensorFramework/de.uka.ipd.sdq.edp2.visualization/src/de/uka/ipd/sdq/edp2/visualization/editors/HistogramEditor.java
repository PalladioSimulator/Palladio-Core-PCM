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
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.experimental.chart.swt.ChartComposite;

import de.uka.ipd.sdq.edp2.visualization.IVisualization;

/**
 * Implementation of an {@link EditorPart}.
 * 
 * @author Dominik Ernst
 * 
 */
public class HistogramEditor extends JFreeChartEditor {
	/** Logger */
	private final static Logger logger = Logger.getLogger(HistogramEditor.class
			.getCanonicalName());
	
	/**
	 * Title of this Editor.
	 */
	private final static String EDITOR_NAME = "Histogram Editor";

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
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
	protected JFreeChart createChart(IEditorInput input) {
		if (input instanceof HistogramEditorInput) {
			JFreeChart chart = ChartFactory.createHistogram("Histogram Test",
					input.getToolTipText(), "Frequency",
					(IntervalXYDataset) ((HistogramEditorInput) input)
							.getDataset(), PlotOrientation.VERTICAL, true,
					true, false);
			return chart;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.visualization.editors.AbstractEditor#changeInput(org.eclipse.ui.IEditorInput)
	 */
	@Override
	public void changeInput(IEditorInput input) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditor#updateChart()
	 */
	@Override
	public void updateChart() {
		// TODO Auto-generated method stub
		
	}
}
