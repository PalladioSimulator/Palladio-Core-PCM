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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import de.uka.ipd.sdq.edp2.visualization.Activator;
import de.uka.ipd.sdq.edp2.visualization.IDataSink;
import de.uka.ipd.sdq.edp2.visualization.IVisualizationInput;
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
public class DisplayPropertySection extends AbstractPropertySection implements
		ISelectionChangedListener {
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
	private CommonChartPropertiesComposite commonComposite;
	/**
	 * Composite for the properties of the currently displayed chart.
	 */
	private Composite specificComposite;
	/**
	 * The last active editor;
	 */
	private JFreeChartEditor editor;
	/**
	 * The parent composite.
	 */
	private Composite parent;
	/**
	 * A tree, which contains the editor's inputs and their transformations (as
	 * children)
	 */
	private ListViewer listViewer;

	private JFreeChartEditorInput lastSelectedInput;

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
		super.createControls(parent, aTabbedPropertySheetPage);
		this.parent = parent;
		if (getInput() != null) {
			// the common composite is for all JFreeCharts identical, so get the
			// first input and display it
			commonComposite = getInput().getInputs().get(0)
					.getCommonChartProperties().retrieveComposite(parent);
			// create a list viewer containing all editor inputs
			listViewer = new InputElementList(parent, SWT.EMBEDDED, getInput())
					.getListViewer();
			listViewer.addSelectionChangedListener(this);
		}
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
		super.setInput(part, selection);
	}

	/**
	 * Retrieves the input of the last active editor. <code>null</code> if no
	 * editor was active during the current session.
	 * 
	 * @return
	 */
	private JFreeChartEditorInputHandle getInput() {
		if (Activator.getDefault().getWorkbench().getActiveWorkbenchWindow() == null) {
			editor = null;
			return null;
		} else if (Activator.getDefault().getWorkbench()
				.getActiveWorkbenchWindow().getActivePage() == null) {
			editor = null;
			return null;
		} else if (Activator.getDefault().getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor() == null) {
			editor = null;
			return null;
		} else {
			editor = (JFreeChartEditor) Activator.getDefault().getWorkbench()
					.getActiveWorkbenchWindow().getActivePage()
					.getActiveEditor();
			return (JFreeChartEditorInputHandle) editor.getEditorInput();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
	 */
	public void refresh() {
		if (getInput() != null && listViewer == null) {
			listViewer = new InputElementList(parent, SWT.EMBEDDED, getInput())
					.getListViewer();
			listViewer.addSelectionChangedListener(this);
		}
		if (listViewer != null) {
			listViewer.refresh();
		}
		createSpecificChartComposite();
	}

	private void createSpecificChartComposite() {
		if (specificComposite != null) {
			specificComposite.dispose();
		}
		if (lastSelectedInput != null)
			specificComposite = lastSelectedInput.getChartProperties()
					.retrieveComposite(parent);
	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		IStructuredSelection selection = (IStructuredSelection) listViewer
				.getSelection();
		lastSelectedInput = (JFreeChartEditorInput) selection.getFirstElement();
		refresh();
		parent.redraw();
	}

}
