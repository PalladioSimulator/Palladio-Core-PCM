/**
 * 
 */
package de.uka.ipd.sdq.edp2.visualization.editors;

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
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.experimental.chart.swt.ChartComposite;

import de.uka.ipd.sdq.edp2.visualization.IVisualization;

/**
 * EditorPart showing PieChart. FIXME not up-to-date
 * 
 * @author Dominik Ernst
 */
public class PieChartEditor extends EditorPart implements IVisualization {

	private final static String EDITOR_ID = "de.uka.ipd.sdq.edp2.visualization.editors.PieChart";
	/**
	 * The editors input.
	 */
	private TabbedPropertySheetPage propertySheetPage;

	private PieChartEditorInput input;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.IPersistableEditor#restoreState(org.eclipse.ui.IMemento)
	 */
	@Override
	public void restoreState(IMemento memento) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IPersistable#saveState(org.eclipse.ui.IMemento)
	 */
	@Override
	public void saveState(IMemento memento) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor
	 * #getContributorId()
	 */
	@Override
	public String getContributorId() {
		return EDITOR_ID;
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		setSite(site);
		if (input instanceof PieChartEditorInput) {
			this.input = (PieChartEditorInput) input;
		}
		setInput(input);
		setPartName("PieChartTest");
	}

	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createPartControl(Composite parent) {
		JFreeChart chart = createChart(input);
		new ChartComposite(parent, SWT.NONE, chart, true);
		getSite().setSelectionProvider(new ISelectionProvider() {

			public void addSelectionChangedListener(
					ISelectionChangedListener listener) {
			}

			public ISelection getSelection() {
				return new StructuredSelection(this);
			}

			public void removeSelectionChangedListener(
					ISelectionChangedListener listener) {
			}

			public void setSelection(ISelection selection) {
			}
		});
	}

	private JFreeChart createChart(IEditorInput input) {
		if (input instanceof PieChartEditorInput) {
			JFreeChart chart = ChartFactory.createPieChart("PieChartTest",
					((PieChartEditorInput) input).getDataset(), true, false,
					false);
			return chart;
		}
		return null;
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	public Object getAdapter(Class adapter) {
		if (adapter == IPropertySheetPage.class)
			return new TabbedPropertySheetPage(this);
		return super.getAdapter(adapter);
	}

	public IPropertySheetPage getPropertySheetPage() {
		if (propertySheetPage == null
				|| propertySheetPage.getControl().isDisposed()) {
			propertySheetPage = new TabbedPropertySheetPage(this);
		}
		return propertySheetPage;
	}
}
