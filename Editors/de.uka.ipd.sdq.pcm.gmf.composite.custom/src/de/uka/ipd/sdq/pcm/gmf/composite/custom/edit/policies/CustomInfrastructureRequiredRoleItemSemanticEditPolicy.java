/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.custom.edit.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.InfrastructureRequiredRoleItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.PalladioComponentModelBaseItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole;

/**
 * The Class CustomInfrastructureRequiredRoleItemSemanticEditPolicy.
 */
public class CustomInfrastructureRequiredRoleItemSemanticEditPolicy extends
        InfrastructureRequiredRoleItemSemanticEditPolicy {
    /**
     * Gets the start create relationship command.
     * 
     * @param req
     *            the req
     * @return the start create relationship command
     * @generated not
     */
    protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
        if (PalladioComponentModelElementTypes.AssemblyInfrastructureConnector_4008 == req.getElementType()) {
            EObject sourceEObject = req.getSource();
            if (!(sourceEObject instanceof InfrastructureRequiredRole)) {
                return UnexecutableCommand.INSTANCE;
            }
            InfrastructureRequiredRole source = (InfrastructureRequiredRole) sourceEObject;
            ComposedStructure container = (ComposedStructure) getRelationshipContainer(source,
                    CompositionPackage.eINSTANCE.getComposedStructure(), req.getElementType());
            if (container == null) {
                return UnexecutableCommand.INSTANCE;
            }
            if (!getLinkConstraints().canCreateAssemblyInfrastructureConnector_4008(container, source, null)) {
                return UnexecutableCommand.INSTANCE;
            }
            // added to provide assembly context in addition to source and target role
            req.setParameter("SOURCE_ASSEMBLY_CONTEXT", ((View) getHost().getParent().getModel()).getElement());

            return new Command() {
            };
        }
        return null;
    }
}
