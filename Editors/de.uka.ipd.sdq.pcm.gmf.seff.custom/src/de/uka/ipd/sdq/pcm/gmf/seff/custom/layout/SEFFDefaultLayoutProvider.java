package de.uka.ipd.sdq.pcm.gmf.seff.custom.layout;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.util.ObjectAdapter;
import org.eclipse.gmf.runtime.diagram.ui.providers.TopDownProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.ILayoutNodeOperation;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingSEFFEditPart;

/**
 * Enable topdown layout for SEFFs.
 * 
 * @author joerg henss
 */
public class SEFFDefaultLayoutProvider extends TopDownProvider {

    /**
     * Check if we have a SEFF.
     * 
     * @param operation
     *            The layout operation to support
     * @return true if we are in a SEFF diagram
     */
    @Override
    public final boolean provides(final IOperation operation) {

        if (operation instanceof ILayoutNodeOperation) {
            ILayoutNodeOperation op = (ILayoutNodeOperation) operation;
            IAdaptable hint = op.getLayoutHint();

            if (hint instanceof ObjectAdapter) {
                GraphicalEditPart part = (GraphicalEditPart) hint.getAdapter(GraphicalEditPart.class);
                if (part != null) {
                    EditPart root = part.getRoot().getContents();
                    if (part instanceof ResourceDemandingSEFFEditPart || root instanceof ResourceDemandingSEFFEditPart) {
                        return true;
                    }
                }
            }

        }

        return false;

    }

}
