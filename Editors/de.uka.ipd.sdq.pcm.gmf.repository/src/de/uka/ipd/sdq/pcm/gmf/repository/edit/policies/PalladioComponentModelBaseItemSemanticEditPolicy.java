/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.SemanticEditPolicy;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.helpers.GeneratedEditHelperBase;

import org.palladiosimulator.pcm.core.entity.InterfaceProvidingEntity;
import org.palladiosimulator.pcm.core.entity.InterfaceRequiringEntity;
import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelRepositoryDiagramEditorPlugin;
import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.repository.providers.PalladioComponentModelElementTypes;
import org.palladiosimulator.pcm.repository.CompleteComponentType;
import org.palladiosimulator.pcm.repository.EventGroup;
import org.palladiosimulator.pcm.repository.ImplementationComponentType;
import org.palladiosimulator.pcm.repository.InfrastructureInterface;
import org.palladiosimulator.pcm.repository.InfrastructureProvidedRole;
import org.palladiosimulator.pcm.repository.InfrastructureRequiredRole;
import org.palladiosimulator.pcm.repository.Interface;
import org.palladiosimulator.pcm.repository.OperationInterface;
import org.palladiosimulator.pcm.repository.OperationProvidedRole;
import org.palladiosimulator.pcm.repository.OperationRequiredRole;
import org.palladiosimulator.pcm.repository.ProvidesComponentType;
import org.palladiosimulator.pcm.repository.SinkRole;
import org.palladiosimulator.pcm.repository.SourceRole;

/**
 * @generated
 */
public class PalladioComponentModelBaseItemSemanticEditPolicy extends SemanticEditPolicy {

    /**
     * @generated
     */
    public static final String VISUAL_ID_KEY = "visual_id"; //$NON-NLS-1$

    /**
     * @generated
     */
    private final IElementType myElementType;

    /**
     * @generated
     */
    protected PalladioComponentModelBaseItemSemanticEditPolicy(IElementType elementType) {
        myElementType = elementType;
    }

    /**
     * @generated
     */
    public Command getCommand(Request request) {
        if (request instanceof ReconnectRequest) {
            Object view = ((ReconnectRequest) request).getConnectionEditPart().getModel();
            if (view instanceof View) {
                Integer id = new Integer(PalladioComponentModelVisualIDRegistry.getVisualID((View) view));
                request.getExtendedData().put(VISUAL_ID_KEY, id);
            }
        }
        return super.getCommand(request);
    }

    /**
     * @generated
     */
    protected int getVisualID(IEditCommandRequest request) {
        Object id = request.getParameter(VISUAL_ID_KEY);
        return id instanceof Integer ? ((Integer) id).intValue() : -1;
    }

    /**
     * @generated
     */
    protected Command getSemanticCommand(IEditCommandRequest request) {
        IEditCommandRequest completedRequest = completeRequest(request);
        Command semanticCommand = getSemanticCommandSwitch(completedRequest);
        semanticCommand = getEditHelperCommand(completedRequest, semanticCommand);
        if (completedRequest instanceof DestroyRequest) {
            DestroyRequest destroyRequest = (DestroyRequest) completedRequest;
            return shouldProceed(destroyRequest) ? addDeleteViewCommand(semanticCommand, destroyRequest) : null;
        }
        return semanticCommand;
    }

    /**
     * @generated
     */
    protected Command addDeleteViewCommand(Command mainCommand, DestroyRequest completedRequest) {
        Command deleteViewCommand = getGEFWrapper(new DeleteCommand(getEditingDomain(), (View) getHost().getModel()));
        return mainCommand == null ? deleteViewCommand : mainCommand.chain(deleteViewCommand);
    }

    /**
     * @generated
     */
    private Command getEditHelperCommand(IEditCommandRequest request, Command editPolicyCommand) {
        if (editPolicyCommand != null) {
            ICommand command = editPolicyCommand instanceof ICommandProxy ? ((ICommandProxy) editPolicyCommand)
                    .getICommand() : new CommandProxy(editPolicyCommand);
            request.setParameter(GeneratedEditHelperBase.EDIT_POLICY_COMMAND, command);
        }
        IElementType requestContextElementType = getContextElementType(request);
        request.setParameter(GeneratedEditHelperBase.CONTEXT_ELEMENT_TYPE, requestContextElementType);
        ICommand command = requestContextElementType.getEditCommand(request);
        request.setParameter(GeneratedEditHelperBase.EDIT_POLICY_COMMAND, null);
        request.setParameter(GeneratedEditHelperBase.CONTEXT_ELEMENT_TYPE, null);
        if (command != null) {
            if (!(command instanceof CompositeTransactionalCommand)) {
                command = new CompositeTransactionalCommand(getEditingDomain(), command.getLabel()).compose(command);
            }
            return new ICommandProxy(command);
        }
        return editPolicyCommand;
    }

    /**
     * @generated
     */
    private IElementType getContextElementType(IEditCommandRequest request) {
        IElementType requestContextElementType = PalladioComponentModelElementTypes
                .getElementType(getVisualID(request));
        return requestContextElementType != null ? requestContextElementType : myElementType;
    }

    /**
     * @generated
     */
    protected Command getSemanticCommandSwitch(IEditCommandRequest req) {
        if (req instanceof CreateRelationshipRequest) {
            return getCreateRelationshipCommand((CreateRelationshipRequest) req);
        } else if (req instanceof CreateElementRequest) {
            return getCreateCommand((CreateElementRequest) req);
        } else if (req instanceof ConfigureRequest) {
            return getConfigureCommand((ConfigureRequest) req);
        } else if (req instanceof DestroyElementRequest) {
            return getDestroyElementCommand((DestroyElementRequest) req);
        } else if (req instanceof DestroyReferenceRequest) {
            return getDestroyReferenceCommand((DestroyReferenceRequest) req);
        } else if (req instanceof DuplicateElementsRequest) {
            return getDuplicateCommand((DuplicateElementsRequest) req);
        } else if (req instanceof GetEditContextRequest) {
            return getEditContextCommand((GetEditContextRequest) req);
        } else if (req instanceof MoveRequest) {
            return getMoveCommand((MoveRequest) req);
        } else if (req instanceof ReorientReferenceRelationshipRequest) {
            return getReorientReferenceRelationshipCommand((ReorientReferenceRelationshipRequest) req);
        } else if (req instanceof ReorientRelationshipRequest) {
            return getReorientRelationshipCommand((ReorientRelationshipRequest) req);
        } else if (req instanceof SetRequest) {
            return getSetCommand((SetRequest) req);
        }
        return null;
    }

    /**
     * @generated
     */
    protected Command getConfigureCommand(ConfigureRequest req) {
        return null;
    }

    /**
     * @generated
     */
    protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
        return null;
    }

    /**
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        return null;
    }

    /**
     * @generated
     */
    protected Command getSetCommand(SetRequest req) {
        return null;
    }

    /**
     * @generated
     */
    protected Command getEditContextCommand(GetEditContextRequest req) {
        return null;
    }

    /**
     * @generated
     */
    protected Command getDestroyElementCommand(DestroyElementRequest req) {
        return null;
    }

    /**
     * @generated
     */
    protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
        return null;
    }

    /**
     * @generated
     */
    protected Command getDuplicateCommand(DuplicateElementsRequest req) {
        return null;
    }

    /**
     * @generated
     */
    protected Command getMoveCommand(MoveRequest req) {
        return null;
    }

    /**
     * @generated
     */
    protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
        return UnexecutableCommand.INSTANCE;
    }

    /**
     * @generated
     */
    protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
        return UnexecutableCommand.INSTANCE;
    }

    /**
     * @generated
     */
    protected final Command getGEFWrapper(ICommand cmd) {
        return new ICommandProxy(cmd);
    }

    /**
     * @generated
     */
    protected TransactionalEditingDomain getEditingDomain() {
        return ((IGraphicalEditPart) getHost()).getEditingDomain();
    }

    /**
     * @generated
     */
    protected void addDestroyShortcutsCommand(ICompositeCommand cmd, View view) {
        assert view.getEAnnotation("Shortcut") == null; //$NON-NLS-1$
        for (Iterator it = view.getDiagram().getChildren().iterator(); it.hasNext();) {
            View nextView = (View) it.next();
            if (nextView.getEAnnotation("Shortcut") == null || !nextView.isSetElement() || nextView.getElement() != view.getElement()) { //$NON-NLS-1$
                continue;
            }
            cmd.add(new DeleteCommand(getEditingDomain(), nextView));
        }
    }

    /**
     * @generated
     */
    public static LinkConstraints getLinkConstraints() {
        LinkConstraints cached = PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance().getLinkConstraints();
        if (cached == null) {
            PalladioComponentModelRepositoryDiagramEditorPlugin.getInstance().setLinkConstraints(
                    cached = new LinkConstraints());
        }
        return cached;
    }

    /**
     * @generated
     */
    public static class LinkConstraints {

        /**
         * @generated
         */
        LinkConstraints() {
            // use static method #getLinkConstraints() to access instance
        }

        /**
         * @generated
         */
        public boolean canCreateOperationProvidedRole_4105(InterfaceProvidingEntity source, OperationInterface target) {
            return canExistOperationProvidedRole_4105(null, source, target);
        }

        /**
         * @generated
         */
        public boolean canCreateInfrastructureProvidedRole_4111(InterfaceProvidingEntity source,
                InfrastructureInterface target) {
            return canExistInfrastructureProvidedRole_4111(null, source, target);
        }

        /**
         * @generated
         */
        public boolean canCreateInfrastructureRequiredRole_4112(InterfaceRequiringEntity source,
                InfrastructureInterface target) {
            return canExistInfrastructureRequiredRole_4112(null, source, target);
        }

        /**
         * @generated
         */
        public boolean canCreateSinkRole_4109(InterfaceProvidingEntity source, EventGroup target) {
            return canExistSinkRole_4109(null, source, target);
        }

        /**
         * @generated
         */
        public boolean canCreateOperationRequiredRole_4106(InterfaceRequiringEntity source, OperationInterface target) {
            return canExistOperationRequiredRole_4106(null, source, target);
        }

        /**
         * @generated
         */
        public boolean canCreateImplementationComponentTypeParentCompleteComponentTypes_4103(
                ImplementationComponentType source, CompleteComponentType target) {
            if (source != null) {
                if (source.getParentCompleteComponentTypes().contains(target)) {
                    return false;
                }
            }

            return canExistImplementationComponentTypeParentCompleteComponentTypes_4103(source, target);
        }

        /**
         * @generated
         */
        public boolean canCreateCompleteComponentTypeParentProvidesComponentTypes_4104(CompleteComponentType source,
                ProvidesComponentType target) {
            if (source != null) {
                if (source.getParentProvidesComponentTypes().contains(target)) {
                    return false;
                }
            }

            return canExistCompleteComponentTypeParentProvidesComponentTypes_4104(source, target);
        }

        /**
         * @generated
         */
        public boolean canCreateSourceRole_4110(InterfaceRequiringEntity source, EventGroup target) {
            return canExistSourceRole_4110(null, source, target);
        }

        /**
         * @generated
         */
        public boolean canCreateInterfaceParentInterfaces__Interface_4113(Interface source, Interface target) {
            if (source != null) {
                if (source.getParentInterfaces__Interface().contains(target)) {
                    return false;
                }
            }

            return canExistInterfaceParentInterfaces__Interface_4113(source, target);
        }

        /**
         * @generated
         */
        public boolean canExistOperationProvidedRole_4105(OperationProvidedRole linkInstance,
                InterfaceProvidingEntity source, OperationInterface target) {
            return true;
        }

        /**
         * @generated
         */
        public boolean canExistInfrastructureProvidedRole_4111(InfrastructureProvidedRole linkInstance,
                InterfaceProvidingEntity source, InfrastructureInterface target) {
            return true;
        }

        /**
         * @generated
         */
        public boolean canExistInfrastructureRequiredRole_4112(InfrastructureRequiredRole linkInstance,
                InterfaceRequiringEntity source, InfrastructureInterface target) {
            return true;
        }

        /**
         * @generated
         */
        public boolean canExistSinkRole_4109(SinkRole linkInstance, InterfaceProvidingEntity source, EventGroup target) {
            return true;
        }

        /**
         * @generated
         */
        public boolean canExistOperationRequiredRole_4106(OperationRequiredRole linkInstance,
                InterfaceRequiringEntity source, OperationInterface target) {
            return true;
        }

        /**
         * @generated
         */
        public boolean canExistImplementationComponentTypeParentCompleteComponentTypes_4103(
                ImplementationComponentType source, CompleteComponentType target) {
            return true;
        }

        /**
         * @generated
         */
        public boolean canExistCompleteComponentTypeParentProvidesComponentTypes_4104(CompleteComponentType source,
                ProvidesComponentType target) {
            return true;
        }

        /**
         * @generated
         */
        public boolean canExistSourceRole_4110(SourceRole linkInstance, InterfaceRequiringEntity source,
                EventGroup target) {
            return true;
        }

        /**
         * @generated
         */
        public boolean canExistInterfaceParentInterfaces__Interface_4113(Interface source, Interface target) {
            return true;
        }

    }

}
