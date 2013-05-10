package de.uka.ipd.sdq.pcm.gmf.composite.custom.policies;

import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProviderPolicy;
import org.eclipse.gmf.runtime.common.ui.services.action.global.GlobalActionHandlerOperation;

import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.InfrastructureProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.InfrastructureRequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationRequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.SinkRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.SourceRoleEditPart;

/**
 * Only disable "Edit -> Duplicate" menu item for ports and parameters, leave decision for other
 * elements to others.
 * 
 * @author Andreas Rentschler
 */
public class DuplicateActionFilterProviderPolicy implements IProviderPolicy {

    public boolean provides(IOperation operation) {
        if (operation instanceof GlobalActionHandlerOperation) {
            Class elementType = ((GlobalActionHandlerOperation) operation).getContext().getElementType();
            // System.out.println(elementType);
            if (elementType == OperationProvidedRoleEditPart.class
                    || elementType == OperationRequiredRoleEditPart.class
                    || elementType == InfrastructureProvidedRoleEditPart.class
                    || elementType == InfrastructureRequiredRoleEditPart.class
                    || elementType == SourceRoleEditPart.class || elementType == SinkRoleEditPart.class)
                return true;
        }
        return false;
    }

}
