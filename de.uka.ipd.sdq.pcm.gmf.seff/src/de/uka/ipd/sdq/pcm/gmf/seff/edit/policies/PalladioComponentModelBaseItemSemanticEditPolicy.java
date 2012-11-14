/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

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

import de.uka.ipd.sdq.pcm.gmf.seff.edit.helpers.PalladioComponentModelBaseEditHelper;
import de.uka.ipd.sdq.pcm.gmf.seff.expressions.PalladioComponentModelAbstractExpression;
import de.uka.ipd.sdq.pcm.gmf.seff.expressions.PalladioComponentModelOCLFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelSeffDiagramEditorPlugin;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

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
     * @param elementType the element type
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
     * @param request the request
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
     * @param request the request
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
     * @param request the request
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
     * @param mainCommand the main command
     * @param completedRequest the completed request
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
     * @param request the request
     * @param editPolicyCommand the edit policy command
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
     * @param request the request
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
     * @param req the req
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
     * @param req the req
     * @return the configure command
     * @generated
     */
    protected Command getConfigureCommand(ConfigureRequest req) {
        return null;
    }

    /**
     * Gets the creates the relationship command.
     *
     * @param req the req
     * @return the creates the relationship command
     * @generated
     */
    protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
        return null;
    }

    /**
     * Gets the creates the command.
     *
     * @param req the req
     * @return the creates the command
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        return null;
    }

    /**
     * Gets the sets the command.
     *
     * @param req the req
     * @return the sets the command
     * @generated
     */
    protected Command getSetCommand(SetRequest req) {
        return null;
    }

    /**
     * Gets the edits the context command.
     *
     * @param req the req
     * @return the edits the context command
     * @generated
     */
    protected Command getEditContextCommand(GetEditContextRequest req) {
        return null;
    }

    /**
     * Gets the destroy element command.
     *
     * @param req the req
     * @return the destroy element command
     * @generated
     */
    protected Command getDestroyElementCommand(DestroyElementRequest req) {
        return null;
    }

    /**
     * Gets the destroy reference command.
     *
     * @param req the req
     * @return the destroy reference command
     * @generated
     */
    protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
        return null;
    }

    /**
     * Gets the duplicate command.
     *
     * @param req the req
     * @return the duplicate command
     * @generated
     */
    protected Command getDuplicateCommand(DuplicateElementsRequest req) {
        return null;
    }

    /**
     * Gets the move command.
     *
     * @param req the req
     * @return the move command
     * @generated
     */
    protected Command getMoveCommand(MoveRequest req) {
        return null;
    }

    /**
     * Gets the reorient reference relationship command.
     *
     * @param req the req
     * @return the reorient reference relationship command
     * @generated
     */
    protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
        return UnexecutableCommand.INSTANCE;
    }

    /**
     * Gets the reorient relationship command.
     *
     * @param req the req
     * @return the reorient relationship command
     * @generated
     */
    protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
        return UnexecutableCommand.INSTANCE;
    }

    /**
     * Gets the gEF wrapper.
     *
     * @param cmd the cmd
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
     * @param cmd the cmd
     * @param view the view
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
     * The Class LinkConstraints.
     *
     * @generated
     */
    public static class LinkConstraints {

        /** The Constant OPPOSITE_END_VAR. @generated */
        private static final String OPPOSITE_END_VAR = "oppositeEnd"; //$NON-NLS-1$
        
        /** The Abstract action successor_ abstract action_4001_ source expression. @generated */
        private static PalladioComponentModelAbstractExpression AbstractActionSuccessor_AbstractAction_4001_SourceExpression;
        
        /** The Abstract action successor_ abstract action_4001_ target expression. @generated */
        private static PalladioComponentModelAbstractExpression AbstractActionSuccessor_AbstractAction_4001_TargetExpression;

        /** The Recovery action behaviour failure handling alternatives__ recovery action behaviour_4004_ source expression. @generated */
        private static PalladioComponentModelAbstractExpression RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviour_4004_SourceExpression;
        
        /** The Recovery action behaviour failure handling alternatives__ recovery action behaviour_4004_ target expression. @generated */
        private static PalladioComponentModelAbstractExpression RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviour_4004_TargetExpression;

        /**
         * Can create abstract action successor_ abstract action_4001.
         *
         * @param source the source
         * @param target the target
         * @return true, if successful
         * @generated
         */
        public static boolean canCreateAbstractActionSuccessor_AbstractAction_4001(AbstractAction source,
                AbstractAction target) {
            if (source != null) {
                if (source.getSuccessor_AbstractAction() != null) {
                    return false;
                }
            }
            if (target != null && (target.getPredecessor_AbstractAction() != null)) {
                return false;
            }

            return canExistAbstractActionSuccessor_AbstractAction_4001(source, target);
        }

        /**
         * Can create recovery action behaviour failure handling alternatives__ recovery action behaviour_4004.
         *
         * @param source the source
         * @param target the target
         * @return true, if successful
         * @generated
         */
        public static boolean canCreateRecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviour_4004(
                de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour source,
                de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour target) {
            if (source != null) {
                if (source.getFailureHandlingAlternatives__RecoveryActionBehaviour().contains(target)) {
                    return false;
                }
            }

            return canExistRecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviour_4004(source,
                    target);
        }

        /**
         * Can exist abstract action successor_ abstract action_4001.
         *
         * @param source the source
         * @param target the target
         * @return true, if successful
         * @generated
         */
        public static boolean canExistAbstractActionSuccessor_AbstractAction_4001(AbstractAction source,
                AbstractAction target) {
            try {
                if (source == null) {
                    return true;
                }
                if (AbstractActionSuccessor_AbstractAction_4001_SourceExpression == null) {
                    Map env = Collections.singletonMap(OPPOSITE_END_VAR, SeffPackage.eINSTANCE.getAbstractAction());
                    AbstractActionSuccessor_AbstractAction_4001_SourceExpression = PalladioComponentModelOCLFactory
                            .getExpression(
                                    "not self.oclIsTypeOf(StopAction)", SeffPackage.eINSTANCE.getAbstractAction(), env); //$NON-NLS-1$
                }
                Object sourceVal = AbstractActionSuccessor_AbstractAction_4001_SourceExpression.evaluate(source,
                        Collections.singletonMap(OPPOSITE_END_VAR, target));
                if (false == sourceVal instanceof Boolean || !((Boolean) sourceVal).booleanValue()) {
                    return false;
                } // else fall-through
                if (target == null) {
                    return true;
                }
                if (AbstractActionSuccessor_AbstractAction_4001_TargetExpression == null) {
                    Map env = Collections.singletonMap(OPPOSITE_END_VAR, SeffPackage.eINSTANCE.getAbstractAction());
                    AbstractActionSuccessor_AbstractAction_4001_TargetExpression = PalladioComponentModelOCLFactory
                            .getExpression(
                                    "self.predecessor_AbstractAction = null and not self.oclIsTypeOf(StartAction)", SeffPackage.eINSTANCE.getAbstractAction(), env); //$NON-NLS-1$
                }
                Object targetVal = AbstractActionSuccessor_AbstractAction_4001_TargetExpression.evaluate(target,
                        Collections.singletonMap(OPPOSITE_END_VAR, source));
                if (false == targetVal instanceof Boolean || !((Boolean) targetVal).booleanValue()) {
                    return false;
                } // else fall-through
                return true;
            } catch (Exception e) {
                PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                        "Link constraint evaluation error", e); //$NON-NLS-1$
                return false;
            }
        }

        /**
         * Can exist recovery action behaviour failure handling alternatives__ recovery action behaviour_4004.
         *
         * @param source the source
         * @param target the target
         * @return true, if successful
         * @generated
         */
        public static boolean canExistRecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviour_4004(
                de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour source,
                de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour target) {
            try {
                if (source == null) {
                    return true;
                }
                if (RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviour_4004_SourceExpression == null) {
                    Map env = Collections.singletonMap(OPPOSITE_END_VAR,
                            de.uka.ipd.sdq.pcm.seff.seff_reliability.SeffReliabilityPackage.eINSTANCE
                                    .getRecoveryActionBehaviour());
                    RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviour_4004_SourceExpression = PalladioComponentModelOCLFactory
                            .getExpression(
                                    "not self.failureHandlingAlternatives__RecoveryActionBehaviour->exists(x,y:RecoveryActionBehaviour | x<>y and not x.failureTypes_FailureHandlingEntity->intersection(y.failureTypes_FailureHandlingEntity)->isEmpty())", de.uka.ipd.sdq.pcm.seff.seff_reliability.SeffReliabilityPackage.eINSTANCE.getRecoveryActionBehaviour(), env); //$NON-NLS-1$
                }
                Object sourceVal = RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviour_4004_SourceExpression
                        .evaluate(source, Collections.singletonMap(OPPOSITE_END_VAR, target));
                if (false == sourceVal instanceof Boolean || !((Boolean) sourceVal).booleanValue()) {
                    return false;
                } // else fall-through
                if (target == null) {
                    return true;
                }
                if (RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviour_4004_TargetExpression == null) {
                    Map env = Collections.singletonMap(OPPOSITE_END_VAR,
                            de.uka.ipd.sdq.pcm.seff.seff_reliability.SeffReliabilityPackage.eINSTANCE
                                    .getRecoveryActionBehaviour());
                    RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviour_4004_TargetExpression = PalladioComponentModelOCLFactory
                            .getExpression(
                                    "(not self.recoveryAction__RecoveryActionBehaviour.recoveryActionBehaviours__RecoveryAction->exists(x,y:RecoveryActionBehaviour | x<>y and x.failureHandlingAlternatives__RecoveryActionBehaviour->includes(self) and y.failureHandlingAlternatives__RecoveryActionBehaviour->includes(self))) and (self.recoveryAction__RecoveryActionBehaviour = oppositeEnd.recoveryAction__RecoveryActionBehaviour)", de.uka.ipd.sdq.pcm.seff.seff_reliability.SeffReliabilityPackage.eINSTANCE.getRecoveryActionBehaviour(), env); //$NON-NLS-1$
                }
                Object targetVal = RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviour_4004_TargetExpression
                        .evaluate(target, Collections.singletonMap(OPPOSITE_END_VAR, source));
                if (false == targetVal instanceof Boolean || !((Boolean) targetVal).booleanValue()) {
                    return false;
                } // else fall-through
                return true;
            } catch (Exception e) {
                PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                        "Link constraint evaluation error", e); //$NON-NLS-1$
                return false;
            }
        }

    }

}
