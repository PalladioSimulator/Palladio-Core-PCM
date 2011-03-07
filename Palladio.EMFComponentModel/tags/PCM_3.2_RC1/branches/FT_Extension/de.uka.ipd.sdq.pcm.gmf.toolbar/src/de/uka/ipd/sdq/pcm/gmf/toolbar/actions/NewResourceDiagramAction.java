package de.uka.ipd.sdq.pcm.gmf.toolbar.actions;

import org.eclipse.ui.INewWizard;

import de.uka.ipd.sdq.pcm.gmf.resource.part.PalladioComponentModelCreationWizard;
import de.uka.ipd.sdq.pcm.gmf.toolbar.BaseNewDiagramAction;

public class NewResourceDiagramAction
	extends BaseNewDiagramAction {

	protected INewWizard getNewWizard() {
		return new PalladioComponentModelCreationWizard();
	}
}