package de.uka.ipd.sdq.pcm.gmf.toolbar.actions;

import org.eclipse.ui.INewWizard;

import de.uka.ipd.sdq.pcm.gmf.toolbar.BaseNewDiagramAction;
import de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelCreationWizard;

public class NewUsageDiagramAction
	extends BaseNewDiagramAction {

	protected INewWizard getNewWizard() {
		return new PalladioComponentModelCreationWizard();
	}
}