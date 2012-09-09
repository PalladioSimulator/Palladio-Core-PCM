package de.uka.ipd.sdq.pcm.gmf.toolbar.actions;

import org.eclipse.ui.IObjectActionDelegate;

import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelInitDiagramFileAction;
import de.uka.ipd.sdq.pcm.gmf.toolbar.BaseInitializeDiagramAction;

public class InitializeSeffDiagramAction extends BaseInitializeDiagramAction {

    protected IObjectActionDelegate getInitAction() {
        return new PalladioComponentModelInitDiagramFileAction();
    }
}
