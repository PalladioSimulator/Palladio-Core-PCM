package de.uka.ipd.sdq.pcm.gfm.toolbar.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

import de.uka.ipd.sdq.pcm.gmf.allocation.part.PcmInitDiagramFileAction;

public class InitializeAllocationDiagramAction 
		implements IWorkbenchWindowActionDelegate {
	private IWorkbenchWindow myWindow;
	private PcmInitDiagramFileAction myAction;
	
	public InitializeAllocationDiagramAction() {
		myWindow = null;
		myAction = new PcmInitDiagramFileAction();
	}

	public void run(IAction action) {
		myAction.selectionChanged(action, 
				myWindow.getSelectionService().getSelection());
		myAction.setActivePart(action, 
				myWindow.getPartService().getActivePart());
		myAction.run(action);
	}

	public void selectionChanged(IAction action, ISelection selection) {
	}

	public void dispose() {
	}

	public void init(IWorkbenchWindow window) {
		myWindow = window;
		
	}
}