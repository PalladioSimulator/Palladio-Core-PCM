package de.uka.ipd.sdq.pcm.gfm.toolbar.actions;

import org.eclipse.ui.IObjectActionDelegate;

import de.uka.ipd.sdq.pcm.gfm.toolbar.BaseInitializeDiagramAction;
import de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelInitDiagramFileAction;

public class InitializeAllocationDiagramAction 
		extends BaseInitializeDiagramAction {

	protected IObjectActionDelegate getInitAction() {
		return new PalladioComponentModelInitDiagramFileAction();
	}
}