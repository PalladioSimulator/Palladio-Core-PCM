/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.custom.edit.policies;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceRequiringEntity;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.AssemblyContextCanonicalEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;

/**
 * The Class CustomAssemblyContextCanonicalEditPolicy.
 */
public class CustomAssemblyContextCanonicalEditPolicy extends AssemblyContextCanonicalEditPolicy {
    /**
     * Get the semantic children of an assembly context.
     * 
     * This has been adopted manually for the composite editor diagram. The direct semantic child of
     * an assembly context is the encapsulated component. In case of the composite diagram we
     * present the provided and required roles of the component to the user instead. For this, the
     * getSemanticChildrenList method collects all roles from the encapsulated component.
     * 
     * @return The list of prov. and req. roles of the encapsulated component
     * 
     * @generated not
     */
    protected List getSemanticChildrenList() {
        List result = new LinkedList();
        EObject modelObject = ((View) getHost().getModel()).getElement();
        AssemblyContext ctx = (AssemblyContext) modelObject;
        modelObject = ctx.getEncapsulatedComponent__AssemblyContext();
        View viewObject = (View) getHost().getModel();
        EObject nextValue;
        int nodeVID;
        if (modelObject != null) {
            for (Iterator values = ((InterfaceProvidingEntity) modelObject).getProvidedRoles_InterfaceProvidingEntity()
                    .iterator(); values.hasNext();) {
                nextValue = (EObject) values.next();
                nodeVID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
                // if (OperationProvidedRoleEditPart.VISUAL_ID == nodeVID) {
                result.add(nextValue);
                // }
            }
            for (Iterator values = ((InterfaceRequiringEntity) modelObject).getRequiredRoles_InterfaceRequiringEntity()
                    .iterator(); values.hasNext();) {
                nextValue = (EObject) values.next();
                nodeVID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(viewObject, nextValue);
                // if (OperationRequiredRoleEditPart.VISUAL_ID == nodeVID) {
                result.add(nextValue);
                // }
            }
        }
        return result;
    }

}
