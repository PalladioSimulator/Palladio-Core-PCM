package de.uka.ipd.sdq.pcm.gfm.toolbar.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelInitDiagramFileAction;

public class InitializeCompositeDiagramAction 
		implements IWorkbenchWindowActionDelegate {
	private IWorkbenchWindow myWindow;
	private PalladioComponentModelInitDiagramFileAction myAction;
	
	public InitializeCompositeDiagramAction() {
		myWindow = null;
		myAction = new PalladioComponentModelInitDiagramFileAction();
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