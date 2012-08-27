package de.uka.ipd.sdq.edp2.visualization.editors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import de.uka.ipd.sdq.edp2.visualization.IVisualization;
import de.uka.ipd.sdq.edp2.visualization.IVisualizationInputHandle;
import de.uka.ipd.sdq.edp2.visualization.datasource.DatasourceDropTargetAdapter;

/**
 * Default implementation of an {@link EditorPart}. Provides common
 * functionality, which all editors that want to display experiment data must
 * have. Also enables the tabbed properties view.
 * 
 * @author Dominik Ernst
 */
public abstract class AbstractEditor extends EditorPart implements
		IVisualization, ITabbedPropertySheetPageContributor {

	/** This editor's ID, e.g. for Referencing in extension points. */
	public static final String EDITOR_ID = "de.uka.ipd.sdq.edp2.visualization.editors.AbstractEditor";

	/** The input for this Editor. */
	protected IVisualizationInputHandle input;
	
	/** Reference on the current {@link TabbedPropertySheetPage}. */
	protected TabbedPropertySheetPage propertySheetPage;
	
	/** The composite of the parent element, for reference if a new chart is added.*/
	protected Composite parent;

	/** Default constructor. */
	public AbstractEditor() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.ui.part.EditorPart#doSave(org.eclipse.core.runtime.
	 * IProgressMonitor)
	 */
	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.EditorPart#doSaveAs()
	 */
	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub

	}
	@Override
	protected void setInput(IEditorInput input) {
		this.input = (IVisualizationInputHandle)input;
		this.input.addObserver(this);
		super.setInput(input);
    }

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.EditorPart#init(org.eclipse.ui.IEditorSite,
	 * org.eclipse.ui.IEditorInput)
	 */
	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		setSite(site);
		setInput(input);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.part.EditorPart#isDirty()
	 */
	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.part.EditorPart#isSaveAsAllowed()
	 */
	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.IPersistable#saveState(org.eclipse.ui.IMemento)
	 */
	public void saveState(IMemento memento) {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		parent.setFocus();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.IPersistableEditor#restoreState(org.eclipse.ui.IMemento)
	 */
	public void restoreState(IMemento memento) {
		
	}

	/**
	 * Creates a simple selection provider, which always returns just the input.
	 * This selectionProvider is needed for displaying of the properties view
	 * for this editor.
	 * 
	 * @return a selection provider which selection is always the the editor
	 *         input in the attribute {@link #input}
	 */
	protected ISelectionProvider createSelectionProvider() {
		return new ISelectionProvider() {

			public void addSelectionChangedListener(
					ISelectionChangedListener listener) {
			}

			public ISelection getSelection() {
				return (ISelection) input;
			}

			public void removeSelectionChangedListener(
					ISelectionChangedListener listener) {
			}

			public void setSelection(ISelection selection) {
			}
		};
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#getAdapter(java.lang.Class)
	 */
	@SuppressWarnings("rawtypes")
    public Object getAdapter(Class adapter) {
		if (adapter == IPropertySheetPage.class)
			return new TabbedPropertySheetPage(this);
		return super.getAdapter(adapter);
	}

	/**
	 * Creates a new tabbed property sheet page if no page exits, otherwise it
	 * returns the old one.
	 * 
	 * @return a property sheet, saved in {@link #propertySheetPage}
	 */
	public IPropertySheetPage getPropertySheetPage() {
		if (propertySheetPage == null
				|| propertySheetPage.getControl().isDisposed()) {
			propertySheetPage = new TabbedPropertySheetPage(
					AbstractEditor.this, false);
		}
		return propertySheetPage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor
	 * #getContributorId()
	 */
	public String getContributorId() {
		return EDITOR_ID;
	}
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.part.EditorPart#getEditorInput()
	 */
	public IEditorInput getEditorInput(){
		return getEditorInputHandle();
	}
	protected void addDropSupport(Control control) {

		int operations = DND.DROP_LINK | DND.DROP_COPY;
		DropTarget target = new DropTarget(control, operations);

		Transfer[] transferTypes = new Transfer[] { 
			LocalSelectionTransfer.getTransfer()
		};
		target.setTransfer(transferTypes);
		target.addDropListener(new DatasourceDropTargetAdapter(
				getEditorInputHandle()));
	}

}
