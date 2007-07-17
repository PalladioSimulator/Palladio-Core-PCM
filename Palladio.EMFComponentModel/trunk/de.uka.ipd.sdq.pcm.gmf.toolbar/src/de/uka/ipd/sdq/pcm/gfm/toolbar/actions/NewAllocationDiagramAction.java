package de.uka.ipd.sdq.pcm.gfm.toolbar.actions;

import org.eclipse.ui.INewWizard;

import de.uka.ipd.sdq.pcm.gfm.toolbar.BaseNewDiagramAction;
import de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelCreationWizard;

public class NewAllocationDiagramAction 
	extends BaseNewDiagramAction {

	protected INewWizard getNewWizard() {
		return new PalladioComponentModelCreationWizard();
	}
}