package de.uka.ipd.sdq.pcm.gmf.toolbar.actions;

import org.eclipse.ui.INewWizard;

import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelCreationWizard;
import de.uka.ipd.sdq.pcm.gmf.toolbar.BaseNewDiagramAction;

/**
 * The Class NewRepositoryDiagramAction.
 */
public class NewRepositoryDiagramAction extends BaseNewDiagramAction {

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