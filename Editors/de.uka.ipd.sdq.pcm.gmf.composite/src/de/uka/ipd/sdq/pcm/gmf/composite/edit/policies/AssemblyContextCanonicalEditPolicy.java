/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.InfrastructureProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.InfrastructureRequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationProvidedRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationRequiredRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.SinkRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.SourceRoleEditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;

/**
 * @generated
 */
public class AssemblyContextCanonicalEditPolicy extends CanonicalEditPolicy {

    /**
     * @generated
     */
    Set myFeaturesToSynchronize;

    /**
     * @generated
     */
    protected boolean isOrphaned(Collection semanticChildren, final View view) {
        int visualID = PalladioComponentModelVisualIDRegistry.getVisualID(view);
        switch (visualID) {
        case OperationProvidedRoleEditPart.VISUAL_ID:
        case OperationRequiredRoleEditPart.VISUAL_ID:
        case SourceRoleEditPart.VISUAL_ID:
        case SinkRoleEditPart.VISUAL_ID:
        case InfrastructureProvidedRoleEditPart.VISUAL_ID:
        case InfrastructureRequiredRoleEditPart.VISUAL_ID:
            if (!semanticChildren.contains(view.getElement())) {
                return true;
            }
        }
        return false;
    }

    /**
     * @generated
     */
    protected String getDefaultFactoryHint() {
        return null;
    }

    /**
     * @generated
     */
    protected Set getFeaturesToSynchronize() {
        if (myFeaturesToSynchronize == null) {
            myFeaturesToSynchronize = new HashSet();
            myFeaturesToSynchronize.add(EntityPackage.eINSTANCE
                    .getInterfaceProvidingEntity_ProvidedRoles_InterfaceProvidingEntity());
            myFeaturesToSynchronize.add(EntityPackage.eINSTANCE
                    .getInterfaceRequiringEntity_RequiredRoles_InterfaceRequiringEntity());
        }
        return myFeaturesToSynchronize;
    }

    /**
     * @generated
     */
	protected List getSemanticChildrenList() {
		// FIXME regenerate
		return null;
	}

}
