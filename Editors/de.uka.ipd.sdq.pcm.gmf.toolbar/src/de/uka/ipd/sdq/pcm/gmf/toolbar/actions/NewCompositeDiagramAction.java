package de.uka.ipd.sdq.pcm.gmf.toolbar.actions;

import org.eclipse.ui.INewWizard;

import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelCreationWizard;
import de.uka.ipd.sdq.pcm.gmf.toolbar.BaseNewDiagramAction;

/**
 * The Class NewCompositeDiagramAction.
 */
public class NewCompositeDiagramAction extends BaseNewDiagramAction {

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