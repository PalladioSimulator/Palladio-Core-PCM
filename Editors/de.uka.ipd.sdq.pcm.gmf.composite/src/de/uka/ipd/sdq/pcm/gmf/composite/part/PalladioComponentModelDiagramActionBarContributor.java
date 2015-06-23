/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.part;

import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramActionBarContributor;
import org.eclipse.gmf.runtime.diagram.ui.printing.render.actions.EnhancedPrintActionHelper;
import org.eclipse.gmf.runtime.diagram.ui.printing.render.actions.RenderedPrintPreviewAction;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPage;

/**
 * @generated
 */
public class PalladioComponentModelDiagramActionBarContributor extends DiagramActionBarContributor {

    /**
     * @generated
     */
    protected Class getEditorClass() {
        return PalladioComponentModelDiagramEditor.class;
    }

    /**
     * @generated
     */
    protected String getEditorId() {
        return PalladioComponentModelDiagramEditor.ID;
    }

    /**
     * @generated not Manual change in this Method: Changed lines remove hideConnectorLabels and
     *            showConnectorLabels Contribution Items from the Editor's tool bar. These two
     *            actions where severely bugged and added unnecessary features to begin with.
     */
    public void init(IActionBars bars, IWorkbenchPage page) {
        super.init(bars, page);

        // begin: custom code
        IToolBarManager tbm = bars.getToolBarManager();
        tbm.remove("hideConnectorLabels");
        tbm.remove("showConnectorLabels");
        // end: custom code

        // print preview
        IMenuManager fileMenu = bars.getMenuManager().findMenuUsingPath(IWorkbenchActionConstants.M_FILE);
        assert fileMenu != null;
        IAction printPreviewAction = new RenderedPrintPreviewAction(new EnhancedPrintActionHelper());
        fileMenu.insertBefore("print", printPreviewAction); //$NON-NLS-1$
        IMenuManager editMenu = bars.getMenuManager().findMenuUsingPath(IWorkbenchActionConstants.M_EDIT);
        assert editMenu != null;
        if (editMenu.find("validationGroup") == null) { //$NON-NLS-1$
            editMenu.add(new GroupMarker("validationGroup")); //$NON-NLS-1$
        }
        IAction validateAction = new ValidateAction(page);
        editMenu.appendToGroup("validationGroup", validateAction); //$NON-NLS-1$
    }
}
