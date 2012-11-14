package de.uka.ipd.sdq.pcm.gmf.toolbar.actions;

import org.eclipse.ui.IObjectActionDelegate;

import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelInitDiagramFileAction;
import de.uka.ipd.sdq.pcm.gmf.toolbar.BaseInitializeDiagramAction;

/**
 * The Class InitializeSeffDiagramAction.
 */
public class InitializeSeffDiagramAction extends BaseInitializeDiagramAction {

    /**
     * Gets the inits the action.
     *
     * @return the inits the action
     * @see de.uka.ipd.sdq.pcm.gmf.toolbar.BaseInitializeDiagramAction#getInitAction()
     */
    @Override
    protected IObjectActionDelegate getInitAction() {
        return new PalladioComponentModelInitDiagramFileAction();
    }
}
