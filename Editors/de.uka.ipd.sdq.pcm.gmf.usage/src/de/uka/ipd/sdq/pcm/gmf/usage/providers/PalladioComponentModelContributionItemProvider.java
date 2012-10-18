/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.providers;

import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.printing.actions.PrintPreviewAction;
import org.eclipse.gmf.runtime.diagram.ui.printing.render.actions.EnhancedPrintActionHelper;
import org.eclipse.gmf.runtime.diagram.ui.printing.render.actions.RenderedPrintPreviewAction;
import org.eclipse.jface.action.IAction;

/**
 * The Class PalladioComponentModelContributionItemProvider.
 *
 * @generated
 */
public class PalladioComponentModelContributionItemProvider extends AbstractContributionItemProvider {

    /**
     * Creates the action.
     *
     * @param actionId the action id
     * @param partDescriptor the part descriptor
     * @return the i action
     * @generated
     */
    protected IAction createAction(String actionId, IWorkbenchPartDescriptor partDescriptor) {
        if (actionId.equals(PrintPreviewAction.ID)) {
            return new RenderedPrintPreviewAction(new EnhancedPrintActionHelper());
        }
        return super.createAction(actionId, partDescriptor);
    }

}
