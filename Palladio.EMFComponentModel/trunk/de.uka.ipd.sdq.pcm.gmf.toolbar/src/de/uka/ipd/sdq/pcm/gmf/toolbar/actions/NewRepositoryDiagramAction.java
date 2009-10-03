package de.uka.ipd.sdq.pcm.gmf.toolbar.actions;

import org.eclipse.ui.INewWizard;

// import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelCreationWizard; //TODO: re-enable
import de.uka.ipd.sdq.pcm.gmf.toolbar.BaseNewDiagramAction;

public class NewRepositoryDiagramAction
	extends BaseNewDiagramAction {

	protected INewWizard getNewWizard() {
		throw new RuntimeException("not running with eclipse 3.4 / gmf 2.1");
		//return new PalladioComponentModelCreationWizard(); //TODO: re-enable
	}
}