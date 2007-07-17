package de.uka.ipd.sdq.pcm.gfm.toolbar.actions;

import org.eclipse.ui.INewWizard;

import de.uka.ipd.sdq.pcm.gfm.toolbar.BaseNewDiagramAction;
import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelCreationWizard;

public class NewRepositoryDiagramAction 
	extends BaseNewDiagramAction {

	protected INewWizard getNewWizard() {
		return new PalladioComponentModelCreationWizard();
	}
}