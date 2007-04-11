package de.uka.ipd.sdq.pcm.gmf.allocation.part;

import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.wizards.EditorCreationWizard;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;

/**
 * @generated
 */
public class PcmCreationWizard extends EditorCreationWizard {

	private ResourceEnvironmentSelectorPage myResourceEnvironmentSelectorPage;
	private SystemSelectorPage mySystemSelectorPage;
	private PcmCreationWizardPage myCreationPage;

	public PcmCreationWizard() {
		myResourceEnvironmentSelectorPage = new ResourceEnvironmentSelectorPage(null);
		mySystemSelectorPage = new SystemSelectorPage(null);
		myCreationPage = null;
	}

	/**
	 * @generated not
	 */
	public void addPages() {
		super.addPages();
		if (page == null) {
			myCreationPage = new PcmCreationWizardPage(getWorkbench(), getSelection());
			page = myCreationPage;
		}
	
		addPage(myCreationPage);
		addPage(myResourceEnvironmentSelectorPage);
		addPage(mySystemSelectorPage);
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

	@Override
	public boolean performFinish() {
		if (myCreationPage != null) {
			myCreationPage.setResourceEnvironment(myResourceEnvironmentSelectorPage.getSelectedResourceEnvironment());
			myCreationPage.setSystem(mySystemSelectorPage.getSelectedSystem());
		} else {
			PcmDiagramEditorPlugin
			.getInstance()
			.logError(
					"No PcmCreationWizardPage created. Possibly page was already initialized with a CreationWizardPage."); //$NON-NLS-1$
		}
		return super.performFinish();		
	}
}
