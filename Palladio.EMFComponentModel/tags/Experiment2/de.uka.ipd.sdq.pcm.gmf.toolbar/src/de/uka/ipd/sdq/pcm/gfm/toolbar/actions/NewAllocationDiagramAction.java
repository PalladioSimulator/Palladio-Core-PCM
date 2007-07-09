package de.uka.ipd.sdq.pcm.gfm.toolbar.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

import de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelCreationWizard;

public class NewAllocationDiagramAction implements IWorkbenchWindowActionDelegate {
	private IWorkbenchWindow window;
	
	public NewAllocationDiagramAction() {
	}

	public void run(IAction action) {
		PalladioComponentModelCreationWizard wizard = new PalladioComponentModelCreationWizard();
		wizard.init(window.getWorkbench(),new StructuredSelection());
		
		WizardDialog dialog = new WizardDialog(window.getShell(),
				wizard);
		dialog.create();
		dialog.open();
	}

	public void selectionChanged(IAction action, ISelection selection) {
	}

	public void dispose() {
	}

	public void init(IWorkbenchWindow window) {
		this.window = window;
	}
}