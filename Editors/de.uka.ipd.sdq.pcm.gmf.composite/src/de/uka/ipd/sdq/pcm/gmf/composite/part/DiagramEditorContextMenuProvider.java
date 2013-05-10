/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.part;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.ContributionItemService;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.providers.DiagramContextMenuProvider;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IWorkbenchPart;

/**
 * @generated
 */
public class DiagramEditorContextMenuProvider extends DiagramContextMenuProvider {

    /**
     * @generated
     */
    private IWorkbenchPart part;

    /**
     * @generated
     */
    private DeleteElementAction deleteAction;

    /**
     * @generated
     */
    public DiagramEditorContextMenuProvider(IWorkbenchPart part, EditPartViewer viewer) {
        super(part, viewer);
        this.part = part;
        deleteAction = new DeleteElementAction(part);
        deleteAction.init();
    }

    /**
     * @generated
     */
    public void dispose() {
        if (deleteAction != null) {
            deleteAction.dispose();
            deleteAction = null;
        }
        super.dispose();
    }

    /**
     * The hard-wired context menu "Delete From Model" needs to be removed here, so we can add a
     * variant where we are able to disable it for certain diagram element types (here: roles
     * attached to an assembly context). The variant is added via extension point
     * org.eclipse.gmf.runtime.diagram.ui.providers.DiagramContextMenuProvider
     * 
     * @param menu
     *            the menu manager to configure
     * 
     * @author Andreas Rentschler
     * @generated not
     */
    public void buildContextMenu(final IMenuManager menu) {
        getViewer().flush();
        try {
            TransactionUtil.getEditingDomain((EObject) getViewer().getContents().getModel()).runExclusive(
                    new Runnable() {

                        public void run() {
                            ContributionItemService.getInstance().contributeToPopupMenu(
                                    DiagramEditorContextMenuProvider.this, part);
                            /* > */
                            // don't add delete action to context menu, it can't be disabled for
                            // ports and parameters
                            // menu.remove(ActionIds.ACTION_DELETE_FROM_MODEL);
                            // menu.appendToGroup("editGroup", deleteAction);
                            /* < */
                        }
                    });
        } catch (Exception e) {
            PalladioComponentModelComposedStructureDiagramEditorPlugin.getInstance().logError(
                    "Error building context menu", e);
        }
    }
}
