package de.uka.ipd.sdq.pcm.gmf.toolbar.actions;

import org.eclipse.ui.INewWizard;

import de.uka.ipd.sdq.pcm.gmf.toolbar.BaseNewDiagramAction;
import de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelCreationWizard;

/**
 * The Class NewUsageDiagramAction.
 */
public class NewUsageDiagramAction extends BaseNewDiagramAction {

    /**
     * Gets the new wizard.
     * 
     * @return the new wizard
     * @see de.uka.ipd.sdq.pcm.gmf.toolbar.BaseNewDiagramAction#getNewWizard()
     */
    @Override
    protected INewWizard getNewWizard() {
        return new PalladioComponentModelCreationWizard();
    }
}