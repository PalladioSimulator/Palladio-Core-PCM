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

import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.EventChannel;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.helpers.PalladioComponentModelBaseEditHelper;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.repository.InfrastructureProvidedRole;
import de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.SinkRole;
import de.uka.ipd.sdq.pcm.repository.SourceRole;

/**
 * The Class PalladioComponentModelBaseItemSemanticEditPolicy.
 * 
 * @generated
 */
public class PalladioComponentModelBaseItemSemanticEditPolicy extends SemanticEditPolicy {

    /**
     * Extended request data key to hold editpart visual id.
     * 
     * @generated
     */
    public static final String VISUAL_ID_KEY = "visual_id"; //$NON-NLS-1$

    /** The my element type. @generated */
    private final IElementType myElementType;

    /**
     * Instantiates a new palladio component model base item semantic edit policy.
     * 
     * @param elementType
     *            the element type
     * @generated
     */
    protected PalladioComponentModelBaseItemSemanticEditPolicy(IElementType elementType) {
        myElementType = elementType;
    }

    /**
     * Add visual id of edited editpart to extended data of the request so command switch can decide
     * what kind of diagram element is being edited. It is done in those cases when it's not
     * possible to deduce diagram element kind from domain element.
     * 
     * @param request
     *            the request
     * @return the command
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
     * @param request
     *            the request
     * @return the visual id
     * @generated
     */
    protected int getVisualID(IEditCommandRequest request) {
        Object id = request.getParameter(VISUAL_ID_KEY);
        return id instanceof Integer ? ((Integer) id).intValue() : -1;
    }

    /**
     * Gets the semantic command.
     * 
     * @param request
     *            the request
     * @return the semantic command
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
     * Adds the delete view command.
     * 
     * @param mainCommand
     *            the main command
     * @param completedRequest
     *            the completed request
     * @return the command
     * @generated
     */
    protected Command addDeleteViewCommand(Command mainCommand, DestroyRequest completedRequest) {
        Command deleteViewCommand = getGEFWrapper(new DeleteCommand(getEditingDomain(), (View) getHost().getModel()));
        return mainCommand == null ? deleteViewCommand : mainCommand.chain(deleteViewCommand);
    }

    /**
     * Gets the edits the helper command.
     * 
     * @param request
     *            the request
     * @param editPolicyCommand
     *            the edit policy command
     * @return the edits the helper command
     * @generated
     */
    private Command getEditHelperCommand(IEditCommandRequest request, Command editPolicyCommand) {
        if (editPolicyCommand != null) {
            ICommand command = editPolicyCommand instanceof ICommandProxy ? ((ICommandProxy) editPolicyCommand)
                    .getICommand() : new CommandProxy(editPolicyCommand);
            request.setParameter(PalladioComponentModelBaseEditHelper.EDIT_POLICY_COMMAND, command);
        }
        IElementType requestContextElementType = getContextElementType(request);
        request.setParameter(PalladioComponentModelBaseEditHelper.CONTEXT_ELEMENT_TYPE, requestContextElementType);
        ICommand command = requestContextElementType.getEditCommand(request);
        request.setParameter(PalladioComponentModelBaseEditHelper.EDIT_POLICY_COMMAND, null);
        request.setParameter(PalladioComponentModelBaseEditHelper.CONTEXT_ELEMENT_TYPE, null);
        if (command != null) {
            if (!(command instanceof CompositeTransactionalCommand)) {
                command = new CompositeTransactionalCommand(getEditingDomain(), command.getLabel()).compose(command);
            }
            return new ICommandProxy(command);
        }
        return editPolicyCommand;
    }

    /**
     * Gets the context element type.
     * 
     * @param request
     *            the request
     * @return the context element type
     * @generated
     */
    private IElementType getContextElementType(IEditCommandRequest request) {
        IElementType requestContextElementType = PalladioComponentModelElementTypes
                .getElementType(getVisualID(request));
        return requestContextElementType != null ? requestContextElementType : myElementType;
    }

    /**
     * Gets the semantic command switch.
     * 
     * @param req
     *            the req
     * @return the semantic command switch
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
     * Gets the configure command.
     * 
     * @param req
     *            the req
     * @return the configure command
     * @generated
     */
    protected Command getConfigureCommand(ConfigureRequest req) {
        return null;
    }

    /**
     * Gets the creates the relationship command.
     * 
     * @param req
     *            the req
     * @return the creates the relationship command
     * @generated
     */
    protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
        return null;
    }

    /**
     * Gets the creates the command.
     * 
     * @param req
     *            the req
     * @return the creates the command
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        return null;
    }

    /**
     * Gets the sets the command.
     * 
     * @param req
     *            the req
     * @return the sets the command
     * @generated
     */
    protected Command getSetCommand(SetRequest req) {
        return null;
    }

    /**
     * Gets the edits the context command.
     * 
     * @param req
     *            the req
     * @return the edits the context command
     * @generated
     */
    protected Command getEditContextCommand(GetEditContextRequest req) {
        return null;
    }

    /**
     * Gets the destroy element command.
     * 
     * @param req
     *            the req
     * @return the destroy element command
     * @generated
     */
    protected Command getDestroyElementCommand(DestroyElementRequest req) {
        return null;
    }

    /**
     * Gets the destroy reference command.
     * 
     * @param req
     *            the req
     * @return the destroy reference command
     * @generated
     */
    protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
        return null;
    }

    /**
     * Gets the duplicate command.
     * 
     * @param req
     *            the req
     * @return the duplicate command
     * @generated
     */
    protected Command getDuplicateCommand(DuplicateElementsRequest req) {
        return null;
    }

    /**
     * Gets the move command.
     * 
     * @param req
     *            the req
     * @return the move command
     * @generated
     */
    protected Command getMoveCommand(MoveRequest req) {
        return null;
    }

    /**
     * Gets the reorient reference relationship command.
     * 
     * @param req
     *            the req
     * @return the reorient reference relationship command
     * @generated
     */
    protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
        return UnexecutableCommand.INSTANCE;
    }

    /**
     * Gets the reorient relationship command.
     * 
     * @param req
     *            the req
     * @return the reorient relationship command
     * @generated
     */
    protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
        return UnexecutableCommand.INSTANCE;
    }

    /**
     * Gets the gEF wrapper.
     * 
     * @param cmd
     *            the cmd
     * @return the gEF wrapper
     * @generated
     */
    protected final Command getGEFWrapper(ICommand cmd) {
        return new ICommandProxy(cmd);
    }

    /**
     * Returns editing domain from the host edit part.
     * 
     * @return the editing domain
     * @generated
     */
    protected TransactionalEditingDomain getEditingDomain() {
        return ((IGraphicalEditPart) getHost()).getEditingDomain();
    }

    /**
     * Clean all shortcuts to the host element from the same diagram.
     * 
     * @param cmd
     *            the cmd
     * @param view
     *            the view
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
     * Finds container element for the new relationship of the specified type. Default
     * implementation goes up by containment hierarchy starting from the specified element and
     * returns the first element that is instance of the specified container class.
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
     * The Class LinkConstraints.
     * 
     * @generated
     */
    public static class LinkConstraints {

        /**
         * Can create EventChannelSinkConnector_4010.
         * 
         * @param container
         *            the container
         * @param source
         *            the source
         * @param target
         *            the target
         * @return true, if successful
         * @generated
         */
        public static boolean canCreateEventChannelSinkConnector_4010(ComposedStructure container, SinkRole source,
                EventChannel target) {
            return canExistEventChannelSinkConnector_4010(container, source, target);
        }

        /**
         * @generated
         */
        public static boolean canCreateEventChannelSourceConnector_4009(ComposedStructure container, SourceRole source,
                EventChannel target) {
            return canExistEventChannelSourceConnector_4009(container, source, target);
        }

        /**
         * Can create assembly connector_4004.
         * 
         * @param container
         *            the container
         * @param source
         *            the source
         * @param target
         *            the target
         * @return true, if successful
         * @generated
         */
        public static boolean canCreateAssemblyConnector_4004(ComposedStructure container,
                OperationRequiredRole source, OperationProvidedRole target) {
            return canExistAssemblyConnector_4004(container, source, target);
        }

        /**
         * Can create assembly event connector_4007.
         * 
         * @param container
         *            the container
         * @param source
         *            the source
         * @param target
         *            the target
         * @return true, if successful
         * @generated
         */
        public static boolean canCreateAssemblyEventConnector_4007(ComposedStructure container, SourceRole source,
                SinkRole target) {
            return canExistAssemblyEventConnector_4007(container, source, target);
        }

        /**
         * Can create required delegation connector_4005.
         * 
         * @param container
         *            the container
         * @param source
         *            the source
         * @param target
         *            the target
         * @return true, if successful
         * @generated
         */
        public static boolean canCreateRequiredDelegationConnector_4005(ComposedStructure container,
                OperationRequiredRole source, OperationRequiredRole target) {
            return canExistRequiredDelegationConnector_4005(container, source, target);
        }

        /**
         * Can create provided delegation connector_4006.
         * 
         * @param container
         *            the container
         * @param source
         *            the source
         * @param target
         *            the target
         * @return true, if successful
         * @generated
         */
        public static boolean canCreateProvidedDelegationConnector_4006(ComposedStructure container,
                OperationProvidedRole source, OperationProvidedRole target) {
            return canExistProvidedDelegationConnector_4006(container, source, target);
        }

        /**
         * Can create assembly infrastructure connector_4008.
         * 
         * @param container
         *            the container
         * @param source
         *            the source
         * @param target
         *            the target
         * @return true, if successful
         * @generated
         */
        public static boolean canCreateAssemblyInfrastructureConnector_4008(ComposedStructure container,
                InfrastructureRequiredRole source, InfrastructureProvidedRole target) {
            return canExistAssemblyInfrastructureConnector_4008(container, source, target);
        }

        /**
         * <<<<<<< .mine Can exist assembly connector_4004.
         * 
         * @param container
         *            the container
         * @param source
         *            the source
         * @param target
         *            the target
         * @return true, if successful
         * @generated
         */
        public static boolean canExistEventChannelSinkConnector_4010(ComposedStructure container, SinkRole source,
                EventChannel target) {
            return true;
        }

        /**
         * @generated
         */
        public static boolean canExistEventChannelSourceConnector_4009(ComposedStructure container, SourceRole source,
                EventChannel target) {
            return true;
        }

        /**
         * ======= Can exist assembly connector_4004.
         * 
         * @param container
         *            the container
         * @param source
         *            the source
         * @param target
         *            the target
         * @return true, if successful >>>>>>> .r16773
         * @generated
         */
        public static boolean canExistAssemblyConnector_4004(ComposedStructure container, OperationRequiredRole source,
                OperationProvidedRole target) {
            return true;
        }

        /**
         * Can exist assembly event connector_4007.
         * 
         * @param container
         *            the container
         * @param source
         *            the source
         * @param target
         *            the target
         * @return true, if successful
         * @generated
         */
        public static boolean canExistAssemblyEventConnector_4007(ComposedStructure container, SourceRole source,
                SinkRole target) {
            return true;
        }

        /**
         * Can exist required delegation connector_4005.
         * 
         * @param container
         *            the container
         * @param source
         *            the source
         * @param target
         *            the target
         * @return true, if successful
         * @generated
         */
        public static boolean canExistRequiredDelegationConnector_4005(ComposedStructure container,
                OperationRequiredRole source, OperationRequiredRole target) {
            return true;
        }

        /**
         * Can exist provided delegation connector_4006.
         * 
         * @param container
         *            the container
         * @param source
         *            the source
         * @param target
         *            the target
         * @return true, if successful
         * @generated
         */
        public static boolean canExistProvidedDelegationConnector_4006(ComposedStructure container,
                OperationProvidedRole source, OperationProvidedRole target) {
            return true;
        }

        /**
         * Can exist assembly infrastructure connector_4008.
         * 
         * @param container
         *            the container
         * @param source
         *            the source
         * @param target
         *            the target
         * @return true, if successful
         * @generated
         */
        public static boolean canExistAssemblyInfrastructureConnector_4008(ComposedStructure container,
                InfrastructureRequiredRole source, InfrastructureProvidedRole target) {
            return true;
        }

    }

}
