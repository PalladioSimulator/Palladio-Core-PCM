/*
 * Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.part;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.ContributionItemService;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.providers.DiagramContextMenuProvider;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IWorkbenchPart;

/**
 * The Class DiagramEditorContextMenuProvider.
 *
 * @generated
 */
public class DiagramEditorContextMenuProvider extends DiagramContextMenuProvider {

    /** The part. @generated */
    private IWorkbenchPart part;

    /** The delete action. @generated */
    private DeleteElementAction deleteAction;

    /**
     * Instantiates a new diagram editor context menu provider.
     *
     * @param part the part
     * @param viewer the viewer
     * @generated
     */
    public DiagramEditorContextMenuProvider(IWorkbenchPart part, EditPartViewer viewer) {
        super(part, viewer);
        this.part = part;
        deleteAction = new DeleteElementAction(part);
        deleteAction.init();
    }

    /**
     * Dispose.
     *
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
     * Builds the context menu.
     *
     * @param menu the menu
     * @generated
     */
    public void buildContextMenu(final IMenuManager menu) {
        getViewer().flush();
        try {
            TransactionUtil.getEditingDomain((EObject) getViewer().getContents().getModel()).runExclusive(
                    new Runnable() {

                        public void run() {
                            ContributionItemService.getInstance().contributeToPopupMenu(
                                    DiagramEditorContextMenuProvider.this, part);
                            menu.remove(ActionIds.ACTION_DELETE_FROM_MODEL);
                            menu.appendToGroup("editGroup", deleteAction);
                        }
                    });
        } catch (Exception e) {
            PalladioComponentModelUsageDiagramEditorPlugin.getInstance().logError("Error building context menu", e);
        }
    }
}
