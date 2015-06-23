/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.custom.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;

import org.palladiosimulator.pcm.core.composition.ComposedStructure;
import org.palladiosimulator.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.gmf.composite.custom.commands.CustomAssemblyInfrastructureConnectorCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.InfrastructureProvidedRoleItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class CustomInfrastructureProvidedRoleItemSemanticEditPolicy extends
        InfrastructureProvidedRoleItemSemanticEditPolicy {
    /**
     * Adapted to transfer information on containing component and assembly context of target.
     * 
     * @param req
     *            the req
     * @return the complete create relationship command
     * @generated not
     */
    protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
        if (PalladioComponentModelElementTypes.AssemblyInfrastructureConnector_4008 == req.getElementType()) {

            // set the container
            ComposedStructure container = (ComposedStructure) getRelationshipContainer(req.getSource(),
                    CompositionPackage.eINSTANCE.getComposedStructure(), req.getElementType());
            if (container == null) {
                return UnexecutableCommand.INSTANCE;
            }
            req.setParameter("CONTAINER", container);

            // set assembly context
            req.setParameter("TARGET_ASSEMBLY_CONTEXT", ((View) getHost().getParent().getModel()).getElement());
            return getGEFWrapper(new CustomAssemblyInfrastructureConnectorCreateCommand(req, req.getSource(),
                    req.getTarget()));
        }
        return null;
    }
}
