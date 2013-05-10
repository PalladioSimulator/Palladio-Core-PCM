/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.custom.actions;

import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.action.filter.AbstractActionFilterProvider;

import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.InfrastructureProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.InfrastructureRequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationRequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.SinkRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.SourceRoleEditPart;

/**
 * Disable "Edit -> Duplicate" menu item when component roles attached to assembly contexts are
 * selected.
 * 
 * @author Andreas Rentschler
 */
public class DuplicateActionFilterProvider extends AbstractActionFilterProvider {

    // defined in org.eclipse.gmf.runtime.diagram.ui.actions plugin
    private static final String CAN_DUPLICATE = "canDuplicate";

    public boolean testAttribute(Object target, String name, String value) {
        // System.out.println(target + " " + name + " " + value);
        if (CAN_DUPLICATE.equals(name) && ENABLEMENT_VALUE.equals(value)) {
            return (target instanceof OperationProvidedRoleEditPart || target instanceof OperationRequiredRoleEditPart
                    || target instanceof InfrastructureProvidedRoleEditPart
                    || target instanceof InfrastructureRequiredRoleEditPart || target instanceof SourceRoleEditPart || target instanceof SinkRoleEditPart) ? false
                    : true;
        }
        return false;
    }

    public boolean provides(IOperation operation) {
        // System.out.println(operation);
        return true;
    }

}
