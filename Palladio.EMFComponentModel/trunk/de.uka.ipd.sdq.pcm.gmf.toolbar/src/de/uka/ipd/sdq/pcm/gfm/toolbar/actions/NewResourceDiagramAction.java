package de.uka.ipd.sdq.pcm.gfm.toolbar.actions;

import org.eclipse.ui.INewWizard;

import de.uka.ipd.sdq.pcm.gfm.toolbar.BaseNewDiagramAction;
import de.uka.ipd.sdq.pcm.resourceenvironment.presentation.ResourceenvironmentModelWizard;

public class NewResourceDiagramAction 
	extends BaseNewDiagramAction {

	protected INewWizard getNewWizard() {
		return new ResourceenvironmentModelWizard();
	}
}