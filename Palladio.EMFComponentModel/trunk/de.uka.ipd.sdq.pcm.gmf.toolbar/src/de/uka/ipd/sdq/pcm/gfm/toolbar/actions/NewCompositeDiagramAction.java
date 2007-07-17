package de.uka.ipd.sdq.pcm.gfm.toolbar.actions;

import org.eclipse.ui.INewWizard;

import de.uka.ipd.sdq.pcm.gfm.toolbar.BaseNewDiagramAction;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelCreationWizard;

public class NewCompositeDiagramAction 
	extends BaseNewDiagramAction {

	protected INewWizard getNewWizard() {
		return new PalladioComponentModelCreationWizard();
	}
}