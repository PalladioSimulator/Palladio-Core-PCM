package de.uka.ipd.sdq.pcm.gmf.toolbar.actions;

import org.eclipse.ui.INewWizard;

import de.uka.ipd.sdq.pcm.gmf.toolbar.BaseNewDiagramAction;
import de.uka.ipd.sdq.pcm.gmf.resource.part.PalladioComponentModelCreationWizard;

public class NewResourceDiagramAction
	extends BaseNewDiagramAction {

	protected INewWizard getNewWizard() {
//		throw new RuntimeException("not running with eclipse 3.4 / gmf 2.1");
		return new PalladioComponentModelCreationWizard(); //FIXME: re-enable
	}
}