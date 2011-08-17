/*
 *by SDQ, IPD, U Karlrsuhe (TH), 2006
 */
package de.uka.ipd.sdq.pcm.gmf.system.part;

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
		setWindowTitle("New system Diagram"); //$NON-NLS-1$
		setDefaultPageImageDescriptor(SystemDiagramEditorPlugin
				.getBundledImageDescriptor("icons/wizban/NewSystemWizard.gif")); //$NON-NLS-1$
		setNeedsProgressMonitor(true);
	}
}
