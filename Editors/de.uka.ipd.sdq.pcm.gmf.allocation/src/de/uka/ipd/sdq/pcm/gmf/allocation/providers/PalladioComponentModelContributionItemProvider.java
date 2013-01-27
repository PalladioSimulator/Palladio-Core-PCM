/*
 *Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.providers;

import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.printing.actions.PrintPreviewAction;
import org.eclipse.gmf.runtime.diagram.ui.printing.render.actions.EnhancedPrintActionHelper;
import org.eclipse.gmf.runtime.diagram.ui.printing.render.actions.RenderedPrintPreviewAction;
import org.eclipse.jface.action.IAction;

/**
 * @generated
 */
public class PalladioComponentModelContributionItemProvider extends AbstractContributionItemProvider {

    /**
     * @generated
     */
    protected IAction createAction(String actionId, IWorkbenchPartDescriptor partDescriptor) {
        if (actionId.equals(PrintPreviewAction.ID)) {
            return new RenderedPrintPreviewAction(new EnhancedPrintActionHelper());
        }
        return super.createAction(actionId, partDescriptor);
    }

}
