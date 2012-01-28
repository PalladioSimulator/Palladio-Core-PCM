package de.uka.ipd.sdq.edp2.visualization.properties.sections;

import java.util.logging.Logger;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.ISection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import de.uka.ipd.sdq.edp2.visualization.Activator;
import de.uka.ipd.sdq.edp2.visualization.IDataSink;
import de.uka.ipd.sdq.edp2.visualization.IVisualizationInput;
import de.uka.ipd.sdq.edp2.visualization.IVisualizationInputHandle;
import de.uka.ipd.sdq.edp2.visualization.editors.AbstractEditor;
import de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditor;
import de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditorInput;
import de.uka.ipd.sdq.edp2.visualization.editors.JFreeChartEditorInputHandle;

/**
 * GUI controls for displaying options of {@link AbstractEditor}s. Shows and
 * allows to edit visual settings of the current Editor in the Eclipse
 * Properties View if an {@link AbstractEditor} is the currently active editor.
 * 
 * @author Roland Richter, Dominik Ernst
 * 
 */
public class DisplayPropertySection implements ISelectionChangedListener,
		ISection {
	/** Logger */
	private static Logger logger = Logger
			.getLogger(DisplayPropertySection.class.getCanonicalName());

	/**
	 * Key, which must be the same as the key under which the ID's / names of
	 * {@link IDataSink}s are stored.
	 */
	private final static String NAME_KEY = "elementName";
	/**
	 * Composite for all properties of all JFreeCharts
	 */
	private Composite commonPropertiesComposite;
	/**
	 * Composite for the properties of the currently displayed chart.
	 */
	private Composite specificPropertiesComposite;
	/**
	 * The last active editor;
	 */
	private AbstractEditor editor;
	/**
	 * A tree, which contains the editor's inputs and their transformations (as
	 * children)
	 */
	private ListViewer listViewer;

	private Composite composite;

	private IVisualizationInput lastSelectedInput;

	private ISelection selection;

	private IWorkbenchPart part;

	private TabbedPropertySheetPage tabbedPropertySheetPage;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#createControls
	 * (org.eclipse.swt.widgets.Composite,
	 * org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 */
	public void createControls(Composite parent,
			TabbedPropertySheetPage aTabbedPropertySheetPage) {
		this.tabbedPropertySheetPage = aTabbedPropertySheetPage;
		composite = getWidgetFactory().createFlatFormComposite(parent);
		composite.setBackground(parent.getDisplay().getSystemColor(
				SWT.COLOR_WIDGET_BACKGROUND));
		composite.setSize(200, 250);
		createLayout(composite);
		// create empty input list
		listViewer = new InputElementList(composite, SWT.EMBEDDED, null)
				.getListViewer();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#setInput
	 * (org.eclipse.ui.IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		this.part = part;
		this.selection = selection;
	}

	/**
	 * Retrieves the input of the last active editor. <code>null</code> if no
	 * editor was active during the current session.
	 * 
	 * @return
	 */
	private IVisualizationInputHandle getInput() {
		return (IVisualizationInputHandle) editor.getEditorInput();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#refresh()
	 */
	public void refresh() {
		if (editorExists() && listViewer.getInput() == null) {
			listViewer.setInput(getInput());
			listViewer.addSelectionChangedListener(this);
		}
		if (editorExists()) {
			// the common composite is identical for all IVisualizationInputs
			if (commonPropertiesComposite == null) {
				createCommonChartComposite();
			}
		}
		listViewer.refresh();
		composite.layout();
	}

	private void createSpecificChartComposite() {
		if (specificPropertiesComposite != null) {
			specificPropertiesComposite.dispose();
		}
		if (lastSelectedInput != null) {
			specificPropertiesComposite = lastSelectedInput
					.getSpecificPropertiesComposite(composite);
		}
	}

	private void createCommonChartComposite() {
		if (commonPropertiesComposite != null) {
			commonPropertiesComposite.dispose();
		}
		commonPropertiesComposite = getInput().getCommonPropertiesComposite(
				composite);
	}

	private void createLayout(Composite composite) {
		GridLayout layout = new GridLayout(2, false);
		layout.marginWidth = 2;
		layout.marginHeight = 2;
		composite.setLayout(layout);
	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		IStructuredSelection selection = (IStructuredSelection) listViewer
				.getSelection();
		lastSelectedInput = (IVisualizationInput) selection.getFirstElement();
		createSpecificChartComposite();
		refresh();
	}

	@Override
	public void aboutToBeHidden() {
		// TODO Auto-generated method stub

	}

	@Override
	public void aboutToBeShown() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getMinimumHeight() {
		return SWT.DEFAULT;
	}

	private boolean editorExists() {
		IWorkbenchWindow window = Activator.getDefault().getWorkbench()
				.getActiveWorkbenchWindow();
		if (window == null) {
			editor = null;
			return false;
		} else if (window.getActivePage() == null) {
			editor = null;
			return false;
		} else if (window.getActivePage().getActiveEditor() == null) {
			editor = null;
			return false;
		} else {
			editor = (JFreeChartEditor) window.getActivePage()
					.getActiveEditor();
			return true;
		}
	}

	@Override
	public boolean shouldUseExtraSpace() {
		return false;
	}

	/**
	 * Get the widget factory for the property sheet page.
	 * 
	 * @return the widget factory.
	 */
	public TabbedPropertySheetWidgetFactory getWidgetFactory() {
		return tabbedPropertySheetPage.getWidgetFactory();
	}

}
