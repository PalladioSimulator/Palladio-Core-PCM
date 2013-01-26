/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.policies;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.AssemblyConnectorTypeLinkCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.ProvidedDelegationConnectorTypeLinkCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;

/**
 * The Class ProvidedRoleItemSemanticEditPolicy.
 * 
 * @generated
 */
public class ProvidedRoleItemSemanticEditPolicy extends PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * Instantiates a new provided role item semantic edit policy.
     * 
     * @generated
     */
    public ProvidedRoleItemSemanticEditPolicy() {
        // TODO: model changed
        // super(PalladioComponentModelElementTypes.ProvidedRole_3009);
        super(PalladioComponentModelElementTypes.OperationProvidedRole_3011);
    }

    /**
     * Gets the destroy element command.
     * 
     * @param req
     *            the req
     * @return the destroy element command
     * @generated
     */
    @Override
    protected Command getDestroyElementCommand(DestroyElementRequest req) {
        View view = (View) getHost().getModel();
        CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
        cmd.setTransactionNestingEnabled(false);
        EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
        if (annotation == null) {
            // there are indirectly referenced children, need extra commands: false
            addDestroyShortcutsCommand(cmd, view);
            // delete host element
            cmd.add(new DestroyElementCommand(req));
        } else {
            cmd.add(new DeleteCommand(getEditingDomain(), view));
        }
        return getGEFWrapper(cmd.reduce());
    }

    // TODO: write javadoc and annotations
    /**
     * Gets the creates the relationship command.
     * 
     * @param req
     *            the req
     * @return the creates the relationship command
     * @generated not
     */
    @Override
    protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
        if (PalladioComponentModelElementTypes.AssemblyConnector_4004 == req.getElementType()) {
            return req.getTarget() == null ? null : getCreateCompleteIncomingAssemblyConnector_4001Command(req);
        }
        if (PalladioComponentModelElementTypes.ProvidedDelegationConnector_4006 == req.getElementType()) {
            return req.getTarget() == null ? null
                    : getCreateCompleteIncomingProvidedDelegationConnector_4003Command(req);
        }
        return super.getCreateRelationshipCommand(req);
    }

    // TODO: write javadoc and annotations
    /**
     * Gets the creates the complete incoming assembly connector_4001 command.
     * 
     * @param req
     *            the req
     * @return the creates the complete incoming assembly connector_4001 command
     * @generated not
     */
    protected Command getCreateCompleteIncomingAssemblyConnector_4001Command(CreateRelationshipRequest req) {
        EObject sourceEObject = req.getSource();
        EObject targetEObject = req.getTarget();
        if (!(sourceEObject instanceof OperationRequiredRole) || !(targetEObject instanceof OperationProvidedRole)) {
            return UnexecutableCommand.INSTANCE;
        }
        OperationRequiredRole source = (OperationRequiredRole) sourceEObject;
        OperationProvidedRole target = (OperationProvidedRole) targetEObject;
        ComposedStructure container = (ComposedStructure) getRelationshipContainer(source,
                CompositionPackage.eINSTANCE.getComposedStructure(), req.getElementType());
        if (container == null) {
            return UnexecutableCommand.INSTANCE;
        }
        if (!PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints.canCreateAssemblyConnector_4004(
                container, source, target)) {
            return UnexecutableCommand.INSTANCE;
        }
        if (req.getContainmentFeature() == null) {
            req.setContainmentFeature(CompositionPackage.eINSTANCE.getComposedStructure_Connectors__ComposedStructure());
        }
        req.setParameter("PROV_CHILD_CONTEXT", ((View) getHost().getParent().getModel()).getElement());
        return getGEFWrapper(new AssemblyConnectorTypeLinkCreateCommand(req, container, source, target));
    }

    // TODO: write javadoc and annotations
    /**
     * Gets the creates the complete incoming provided delegation connector_4003 command.
     * 
     * @param req
     *            the req
     * @return the creates the complete incoming provided delegation connector_4003 command
     * @generated not
     */
    protected Command getCreateCompleteIncomingProvidedDelegationConnector_4003Command(CreateRelationshipRequest req) {
        EObject sourceEObject = req.getSource();
        EObject targetEObject = req.getTarget();
        if (!(sourceEObject instanceof OperationProvidedRole) || !(targetEObject instanceof OperationProvidedRole)) {
            return UnexecutableCommand.INSTANCE;
        }
        OperationProvidedRole source = (OperationProvidedRole) sourceEObject;
        OperationProvidedRole target = (OperationProvidedRole) targetEObject;
        ComposedStructure container = (ComposedStructure) getRelationshipContainer(source,
                CompositionPackage.eINSTANCE.getComposedStructure(), req.getElementType());
        if (container == null) {
            return UnexecutableCommand.INSTANCE;
        }
        if (!PalladioComponentModelBaseItemSemanticEditPolicy.LinkConstraints
                .canCreateProvidedDelegationConnector_4006(container, source, target)) {
            return UnexecutableCommand.INSTANCE;
        }
        if (req.getContainmentFeature() == null) {
            req.setContainmentFeature(CompositionPackage.eINSTANCE.getComposedStructure_Connectors__ComposedStructure());
        }
        req.setParameter("CHILD_CONTEXT", ((View) getHost().getParent().getModel()).getElement());
        return getGEFWrapper(new ProvidedDelegationConnectorTypeLinkCreateCommand(req, container, source, target));
    }

}
