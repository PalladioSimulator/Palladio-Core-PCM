/*
 *Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.BasicComponentCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.CompleteComponentTypeCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.CompositeComponentCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.EventGroupCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.InfrastructureInterfaceCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.OperationInterfaceCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.ProvidesComponentTypeCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.commands.SubSystemCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.repository.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class RepositoryItemSemanticEditPolicy extends PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * @generated
     */
    public RepositoryItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.Repository_1000);
    }

    /**
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.OperationInterface_2107 == req.getElementType()) {
            return getGEFWrapper(new OperationInterfaceCreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.EventGroup_2108 == req.getElementType()) {
            return getGEFWrapper(new EventGroupCreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.BasicComponent_2102 == req.getElementType()) {
            return getGEFWrapper(new BasicComponentCreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.CompositeComponent_2103 == req.getElementType()) {
            return getGEFWrapper(new CompositeComponentCreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.CompleteComponentType_2104 == req.getElementType()) {
            return getGEFWrapper(new CompleteComponentTypeCreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.ProvidesComponentType_2105 == req.getElementType()) {
            return getGEFWrapper(new ProvidesComponentTypeCreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.SubSystem_2106 == req.getElementType()) {
            return getGEFWrapper(new SubSystemCreateCommand(req));
        }
        if (PalladioComponentModelElementTypes.InfrastructureInterface_2109 == req.getElementType()) {
            return getGEFWrapper(new InfrastructureInterfaceCreateCommand(req));
        }
        return super.getCreateCommand(req);
    }

    /**
     * @generated
     */
    protected Command getDuplicateCommand(DuplicateElementsRequest req) {
        TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
        return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
    }

    /**
     * @generated
     */
    private static class DuplicateAnythingCommand extends DuplicateEObjectsCommand {

        /**
         * @generated
         */
        public DuplicateAnythingCommand(TransactionalEditingDomain editingDomain, DuplicateElementsRequest req) {
            super(editingDomain, req.getLabel(), req.getElementsToBeDuplicated(), req.getAllDuplicatedElementsMap());
        }
    }
}
