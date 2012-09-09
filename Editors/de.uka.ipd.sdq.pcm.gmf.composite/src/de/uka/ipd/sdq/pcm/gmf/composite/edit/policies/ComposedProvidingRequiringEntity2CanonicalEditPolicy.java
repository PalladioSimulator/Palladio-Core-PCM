/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationProvidedRole2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationRequiredRole2EditPart;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelDiagramUpdater;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelNodeDescriptor;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;

/**
 * @generated
 */
public class ComposedProvidingRequiringEntity2CanonicalEditPolicy extends CanonicalEditPolicy {

    /**
     * @generated
     */
    Set myFeaturesToSynchronize;

    /**
     * @generated
     */
    protected List getSemanticChildrenList() {
        View viewObject = (View) getHost().getModel();
        List result = new LinkedList();
        for (Iterator it = PalladioComponentModelDiagramUpdater
                .getComposedProvidingRequiringEntity_2002SemanticChildren(viewObject).iterator(); it.hasNext();) {
            result.add(((PalladioComponentModelNodeDescriptor) it.next()).getModelElement());
        }
        return result;
    }

    /**
     * @generated
     */
    protected boolean isOrphaned(Collection semanticChildren, final View view) {
        int visualID = PalladioComponentModelVisualIDRegistry.getVisualID(view);
        switch (visualID) {
        case OperationProvidedRole2EditPart.VISUAL_ID:
        case OperationRequiredRole2EditPart.VISUAL_ID:
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

}
