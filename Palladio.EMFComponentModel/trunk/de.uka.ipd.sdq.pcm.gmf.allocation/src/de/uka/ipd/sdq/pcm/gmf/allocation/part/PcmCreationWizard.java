package de.uka.ipd.sdq.pcm.gmf.allocation.part;

import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.wizards.EditorCreationWizard;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;

/**
 * @generated
 */
public class PcmCreationWizard extends EditorCreationWizard {

	/**
	 * @generated
	 */
	public void addPages() {
		super.addPages();
		if (page == null) {
			page = new PcmCreationWizardPage(getWorkbench(), getSelection());
		}
		addPage(page);
	}

	/**
	 * @generated
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		super.init(workbench, selection);
		setWindowTitle("New allocation Diagram"); //$NON-NLS-1$
		setDefaultPageImageDescriptor(PcmDiagramEditorPlugin
				.getBundledImageDescriptor("icons/wizban/NewAllocationWizard.gif")); //$NON-NLS-1$
		setNeedsProgressMonitor(true);
	}
}
