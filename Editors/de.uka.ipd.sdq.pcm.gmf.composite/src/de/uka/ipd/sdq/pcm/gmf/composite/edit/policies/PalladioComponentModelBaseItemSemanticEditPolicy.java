/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
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

import org.palladiosimulator.pcm.core.composition.AssemblyConnector;
import org.palladiosimulator.pcm.core.composition.AssemblyEventConnector;
import org.palladiosimulator.pcm.core.composition.AssemblyInfrastructureConnector;
import org.palladiosimulator.pcm.core.composition.ComposedStructure;
import org.palladiosimulator.pcm.core.composition.EventChannel;
import org.palladiosimulator.pcm.core.composition.EventChannelSinkConnector;
import org.palladiosimulator.pcm.core.composition.EventChannelSourceConnector;
import org.palladiosimulator.pcm.core.composition.ProvidedDelegationConnector;
import org.palladiosimulator.pcm.core.composition.RequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelComposedStructureDiagramEditorPlugin;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes;
import org.palladiosimulator.pcm.repository.InfrastructureProvidedRole;
import org.palladiosimulator.pcm.repository.InfrastructureRequiredRole;
import org.palladiosimulator.pcm.repository.OperationProvidedRole;
import org.palladiosimulator.pcm.repository.OperationRequiredRole;
import org.palladiosimulator.pcm.repository.SinkRole;
import org.palladiosimulator.pcm.repository.SourceRole;

/**
 * @generated
 */
public class PalladioComponentModelBaseItemSemanticEditPolicy extends SemanticEditPolicy {

    /**
     * Extended request data key to hold editpart visual id.
     * 
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
     * Extended request data key to hold editpart visual id. Add visual id of edited editpart to
     * extended data of the request so command switch can decide what kind of diagram element is
     * being edited. It is done in those cases when it's not possible to deduce diagram element kind
     * from domain element.
     * 
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
     * Returns visual id from request parameters.
     * 
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
     * Returns editing domain from the host edit part.
     * 
     * @generated
     */
    protected TransactionalEditingDomain getEditingDomain() {
        return ((IGraphicalEditPart) getHost()).getEditingDomain();
    }

    /**
     * Clean all shortcuts to the host element from the same diagram
     * 
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
     * This method is newly added to be used from plugin de.uka.ipd.sdq.pcm.gmf.composite.custom.
     * 
     * Finds container element for the new relationship of the specified type. Default
     * implementation goes up by containment hierarchy starting from the specified element and
     * returns the first element that is instance of the specified container class.
     * 
     * Cannot be moved to custom plugin. It is used from many different customized subtypes.
     * 
     * @param uelement
     *            the uelement
     * @param containerClass
     *            the container class
     * @param relationshipType
     *            the relationship type
     * @return the relationship container
     * @generated not
     */
    protected EObject getRelationshipContainer(Object uelement, EClass containerClass, IElementType relationshipType) {
        if (uelement instanceof EObject) {
            if (uelement instanceof OperationProvidedRole || uelement instanceof OperationRequiredRole
                    || uelement instanceof InfrastructureProvidedRole || uelement instanceof InfrastructureRequiredRole
                    || uelement instanceof SinkRole || uelement instanceof SourceRole) {
                uelement = ((View) getHost().getParent().getModel()).getElement();
            }
            EObject element = (EObject) uelement;
            for (; element != null; element = element.eContainer()) {
                if (containerClass.isSuperTypeOf(element.eClass())) {
                    return element;
                }
            }
        }
        return null;
    }

    /**
     * @generated
     */
    public static LinkConstraints getLinkConstraints() {
        LinkConstraints cached = PalladioComponentModelComposedStructureDiagramEditorPlugin.getInstance()
                .getLinkConstraints();
        if (cached == null) {
            PalladioComponentModelComposedStructureDiagramEditorPlugin.getInstance().setLinkConstraints(
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
        public boolean canCreateEventChannelSinkConnector_4010(ComposedStructure container, SinkRole source,
                EventChannel target) {
            return canExistEventChannelSinkConnector_4010(container, null, source, target);
        }

        /**
         * @generated
         */
        public boolean canCreateEventChannelSourceConnector_4009(ComposedStructure container, SourceRole source,
                EventChannel target) {
            return canExistEventChannelSourceConnector_4009(container, null, source, target);
        }

        /**
         * @generated
         */
        public boolean canCreateAssemblyConnector_4004(ComposedStructure container, OperationRequiredRole source,
                OperationProvidedRole target) {
            return canExistAssemblyConnector_4004(container, null, source, target);
        }

        /**
         * @generated
         */
        public boolean canCreateAssemblyEventConnector_4007(ComposedStructure container, SourceRole source,
                SinkRole target) {
            return canExistAssemblyEventConnector_4007(container, null, source, target);
        }

        /**
         * @generated
         */
        public boolean canCreateRequiredDelegationConnector_4005(ComposedStructure container,
                OperationRequiredRole source, OperationRequiredRole target) {
            return canExistRequiredDelegationConnector_4005(container, null, source, target);
        }

        /**
         * @generated
         */
        public boolean canCreateProvidedDelegationConnector_4006(ComposedStructure container,
                OperationProvidedRole source, OperationProvidedRole target) {
            return canExistProvidedDelegationConnector_4006(container, null, source, target);
        }

        /**
         * @generated
         */
        public boolean canCreateAssemblyInfrastructureConnector_4008(ComposedStructure container,
                InfrastructureRequiredRole source, InfrastructureProvidedRole target) {
            return canExistAssemblyInfrastructureConnector_4008(container, null, source, target);
        }

        /**
         * @generated
         */
        public boolean canExistEventChannelSinkConnector_4010(ComposedStructure container,
                EventChannelSinkConnector linkInstance, SinkRole source, EventChannel target) {
            return true;
        }

        /**
         * @generated
         */
        public boolean canExistEventChannelSourceConnector_4009(ComposedStructure container,
                EventChannelSourceConnector linkInstance, SourceRole source, EventChannel target) {
            return true;
        }

        /**
         * @generated
         */
        public boolean canExistAssemblyConnector_4004(ComposedStructure container, AssemblyConnector linkInstance,
                OperationRequiredRole source, OperationProvidedRole target) {
            return true;
        }

        /**
         * @generated
         */
        public boolean canExistAssemblyEventConnector_4007(ComposedStructure container,
                AssemblyEventConnector linkInstance, SourceRole source, SinkRole target) {
            return true;
        }

        /**
         * @generated
         */
        public boolean canExistRequiredDelegationConnector_4005(ComposedStructure container,
                RequiredDelegationConnector linkInstance, OperationRequiredRole source, OperationRequiredRole target) {
            return true;
        }

        /**
         * @generated
         */
        public boolean canExistProvidedDelegationConnector_4006(ComposedStructure container,
                ProvidedDelegationConnector linkInstance, OperationProvidedRole source, OperationProvidedRole target) {
            return true;
        }

        /**
         * @generated
         */
        public boolean canExistAssemblyInfrastructureConnector_4008(ComposedStructure container,
                AssemblyInfrastructureConnector linkInstance, InfrastructureRequiredRole source,
                InfrastructureProvidedRole target) {
            return true;
        }
    }

}
