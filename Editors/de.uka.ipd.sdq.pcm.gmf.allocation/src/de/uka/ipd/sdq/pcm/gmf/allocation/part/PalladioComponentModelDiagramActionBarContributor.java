/*
 *Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.part;

import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramActionBarContributor;
import org.eclipse.gmf.runtime.diagram.ui.printing.render.actions.EnhancedPrintActionHelper;
import org.eclipse.gmf.runtime.diagram.ui.printing.render.actions.RenderedPrintPreviewAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
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
        return PalladioComponentModelAllocationDiagramEditor.class;
    }

    /**
     * @generated
     */
    protected String getEditorId() {
        return PalladioComponentModelAllocationDiagramEditor.ID;
    }

    /**
     * @generated
     */
    public void init(IActionBars bars, IWorkbenchPage page) {
        super.init(bars, page);
        // print preview
        IMenuManager fileMenu = bars.getMenuManager().findMenuUsingPath(IWorkbenchActionConstants.M_FILE);
        assert fileMenu != null;
        IAction printPreviewAction = new RenderedPrintPreviewAction(new EnhancedPrintActionHelper());
        fileMenu.insertBefore("print", printPreviewAction); //$NON-NLS-1$
    }
}
