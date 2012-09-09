package de.uka.ipd.sdq.pcm.gmf.toolbar.actions;

import org.eclipse.ui.INewWizard;

import de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelCreationWizard;
import de.uka.ipd.sdq.pcm.gmf.toolbar.BaseNewDiagramAction;

public class NewAllocationDiagramAction extends BaseNewDiagramAction {

    protected INewWizard getNewWizard() {
        return new PalladioComponentModelCreationWizard();
    }
}
