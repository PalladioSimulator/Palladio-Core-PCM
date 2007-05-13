package de.uka.ipd.sdq.sensorframework.visualisation.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorInputTransfer;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import de.uka.ipd.sdq.sensorframework.visualisation.views.ViewDropTargetListener;

public abstract class AbstractReportView extends EditorPart implements
		ITabbedPropertySheetPageContributor {

	public static String ABSTRACT_EDITOR_ID = "de.uka.ipd.sdq.codegen.simudatavisualization.views.ReportView";
	
	public AbstractReportView() {
		super();
	}

	public void createPartControl(Composite parent) {
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
				// TODO Auto-generated method stub

			}
		});

		addDropSupport(parent);

		createReportControls(parent);
	}

	protected abstract void createReportControls(Composite parent);

	private void addDropSupport(Control control) {

		int operations = DND.DROP_COPY | DND.DROP_DEFAULT;
		DropTarget target = new DropTarget(control, operations);

		Transfer[] transferTypes = new Transfer[] { EditorInputTransfer
				.getInstance() };
		target.setTransfer(transferTypes);
		target.addDropListener(new ViewDropTargetListener());
	}

	public Object getAdapter(Class adapter) {
		if (adapter == IPropertySheetPage.class)
			return new TabbedPropertySheetPage(this);
		return super.getAdapter(adapter);
	}

	public String getContributorId() {
		return ABSTRACT_EDITOR_ID;
	}

	public void setFocus() {
		// TODO !!
	}

	public void doSave(IProgressMonitor monitor) {
	}

	public void doSaveAs() {
	}

	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		setSite(site);
		setInput(input);
	}

	public boolean isDirty() {
		return false;
	}

	public boolean isSaveAsAllowed() {
		return false;
	}

}