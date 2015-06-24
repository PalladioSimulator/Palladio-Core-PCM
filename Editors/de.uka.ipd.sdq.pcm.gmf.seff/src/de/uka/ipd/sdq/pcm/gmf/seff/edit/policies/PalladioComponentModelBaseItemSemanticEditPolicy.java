/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
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
import org.palladiosimulator.pcm.seff.AbstractAction;
import org.palladiosimulator.pcm.seff.SeffPackage;

import de.uka.ipd.sdq.pcm.gmf.seff.expressions.PalladioComponentModelOCLFactory;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelSeffDiagramEditorPlugin;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

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
    protected PalladioComponentModelBaseItemSemanticEditPolicy(final IElementType elementType) {
        this.myElementType = elementType;
    }

    /**
     * @generated
     */
    @Override
    public Command getCommand(final Request request) {
        if (request instanceof ReconnectRequest) {
            final Object view = ((ReconnectRequest) request).getConnectionEditPart().getModel();
            if (view instanceof View) {
                final Integer id = new Integer(PalladioComponentModelVisualIDRegistry.getVisualID((View) view));
                request.getExtendedData().put(VISUAL_ID_KEY, id);
            }
        }
        return super.getCommand(request);
    }

    /**
     * @generated
     */
    protected int getVisualID(final IEditCommandRequest request) {
        final Object id = request.getParameter(VISUAL_ID_KEY);
        return id instanceof Integer ? ((Integer) id).intValue() : -1;
    }

    /**
     * @generated
     */
    @Override
    protected Command getSemanticCommand(final IEditCommandRequest request) {
        final IEditCommandRequest completedRequest = completeRequest(request);
        Command semanticCommand = getSemanticCommandSwitch(completedRequest);
        semanticCommand = getEditHelperCommand(completedRequest, semanticCommand);
        if (completedRequest instanceof DestroyRequest) {
            final DestroyRequest destroyRequest = (DestroyRequest) completedRequest;
            return shouldProceed(destroyRequest) ? addDeleteViewCommand(semanticCommand, destroyRequest) : null;
        }
        return semanticCommand;
    }

    /**
     * @generated
     */
    protected Command addDeleteViewCommand(final Command mainCommand, final DestroyRequest completedRequest) {
        final Command deleteViewCommand = getGEFWrapper(
                new DeleteCommand(getEditingDomain(), (View) getHost().getModel()));
        return mainCommand == null ? deleteViewCommand : mainCommand.chain(deleteViewCommand);
    }

    /**
     * @generated
     */
    private Command getEditHelperCommand(final IEditCommandRequest request, final Command editPolicyCommand) {
        if (editPolicyCommand != null) {
            final ICommand command = editPolicyCommand instanceof ICommandProxy
                    ? ((ICommandProxy) editPolicyCommand).getICommand() : new CommandProxy(editPolicyCommand);
            request.setParameter(GeneratedEditHelperBase.EDIT_POLICY_COMMAND, command);
        }
        final IElementType requestContextElementType = getContextElementType(request);
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
    private IElementType getContextElementType(final IEditCommandRequest request) {
        final IElementType requestContextElementType = PalladioComponentModelElementTypes
                .getElementType(getVisualID(request));
        return requestContextElementType != null ? requestContextElementType : this.myElementType;
    }

    /**
     * @generated
     */
    protected Command getSemanticCommandSwitch(final IEditCommandRequest req) {
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
    protected Command getConfigureCommand(final ConfigureRequest req) {
        return null;
    }

    /**
     * @generated
     */
    protected Command getCreateRelationshipCommand(final CreateRelationshipRequest req) {
        return null;
    }

    /**
     * @generated
     */
    protected Command getCreateCommand(final CreateElementRequest req) {
        return null;
    }

    /**
     * @generated
     */
    protected Command getSetCommand(final SetRequest req) {
        return null;
    }

    /**
     * @generated
     */
    protected Command getEditContextCommand(final GetEditContextRequest req) {
        return null;
    }

    /**
     * @generated
     */
    protected Command getDestroyElementCommand(final DestroyElementRequest req) {
        return null;
    }

    /**
     * @generated
     */
    protected Command getDestroyReferenceCommand(final DestroyReferenceRequest req) {
        return null;
    }

    /**
     * @generated
     */
    protected Command getDuplicateCommand(final DuplicateElementsRequest req) {
        return null;
    }

    /**
     * @generated
     */
    protected Command getMoveCommand(final MoveRequest req) {
        return null;
    }

    /**
     * @generated
     */
    protected Command getReorientReferenceRelationshipCommand(final ReorientReferenceRelationshipRequest req) {
        return UnexecutableCommand.INSTANCE;
    }

    /**
     * @generated
     */
    protected Command getReorientRelationshipCommand(final ReorientRelationshipRequest req) {
        return UnexecutableCommand.INSTANCE;
    }

    /**
     * @generated
     */
    protected final Command getGEFWrapper(final ICommand cmd) {
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
    protected void addDestroyShortcutsCommand(final ICompositeCommand cmd, final View view) {
        assert view.getEAnnotation("Shortcut") == null; //$NON-NLS-1$
        for (final Iterator it = view.getDiagram().getChildren().iterator(); it.hasNext();) {
            final View nextView = (View) it.next();
            if (nextView.getEAnnotation("Shortcut") == null || !nextView.isSetElement() //$NON-NLS-1$
                    || nextView.getElement() != view.getElement()) {
                continue;
            }
            cmd.add(new DeleteCommand(getEditingDomain(), nextView));
        }
    }

    /**
     * @generated
     */
    public static LinkConstraints getLinkConstraints() {
        LinkConstraints cached = PalladioComponentModelSeffDiagramEditorPlugin.getInstance().getLinkConstraints();
        if (cached == null) {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance()
                    .setLinkConstraints(cached = new LinkConstraints());
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
        public boolean canCreateAbstractActionSuccessor_AbstractAction_4001(final AbstractAction source,
                final AbstractAction target) {
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
         * @generated
         */
        public boolean canCreateRecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviour_4004(
                final org.palladiosimulator.pcm.seff.seff_reliability.RecoveryActionBehaviour source,
                final org.palladiosimulator.pcm.seff.seff_reliability.RecoveryActionBehaviour target) {
            if (source != null) {
                if (source.getFailureHandlingAlternatives__RecoveryActionBehaviour().contains(target)) {
                    return false;
                }
            }

            return canExistRecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviour_4004(source,
                    target);
        }

        /**
         * @generated
         */
        public boolean canExistAbstractActionSuccessor_AbstractAction_4001(final AbstractAction source,
                final AbstractAction target) {
            try {
                if (source == null) {
                    return true;
                } else {
                    final Map<String, EClassifier> env = Collections.<String, EClassifier> singletonMap("oppositeEnd", //$NON-NLS-1$
                            SeffPackage.eINSTANCE.getAbstractAction());
                    final Object sourceVal = PalladioComponentModelOCLFactory
                            .getExpression(0, SeffPackage.eINSTANCE.getAbstractAction(), env)
                            .evaluate(source, Collections.singletonMap("oppositeEnd", target)); //$NON-NLS-1$
                    if (false == sourceVal instanceof Boolean || !((Boolean) sourceVal).booleanValue()) {
                        return false;
                    } // else fall-through
                }
                if (target == null) {
                    return true;
                } else {
                    final Map<String, EClassifier> env = Collections.<String, EClassifier> singletonMap("oppositeEnd", //$NON-NLS-1$
                            SeffPackage.eINSTANCE.getAbstractAction());
                    final Object targetVal = PalladioComponentModelOCLFactory
                            .getExpression(1, SeffPackage.eINSTANCE.getAbstractAction(), env)
                            .evaluate(target, Collections.singletonMap("oppositeEnd", source)); //$NON-NLS-1$
                    if (false == targetVal instanceof Boolean || !((Boolean) targetVal).booleanValue()) {
                        return false;
                    } // else fall-through
                }
                return true;
            } catch (final Exception e) {
                PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError("Link constraint evaluation error", //$NON-NLS-1$
                        e);
                return false;
            }
        }

        /**
         * @generated
         */
        public boolean canExistRecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviour_4004(
                final org.palladiosimulator.pcm.seff.seff_reliability.RecoveryActionBehaviour source,
                final org.palladiosimulator.pcm.seff.seff_reliability.RecoveryActionBehaviour target) {
            try {
                if (source == null) {
                    return true;
                } else {
                    final Map<String, EClassifier> env = Collections.<String, EClassifier> singletonMap("oppositeEnd", //$NON-NLS-1$
                            org.palladiosimulator.pcm.seff.seff_reliability.SeffReliabilityPackage.eINSTANCE
                                    .getRecoveryActionBehaviour());
                    final Object sourceVal = PalladioComponentModelOCLFactory
                            .getExpression(2,
                                    org.palladiosimulator.pcm.seff.seff_reliability.SeffReliabilityPackage.eINSTANCE
                                            .getRecoveryActionBehaviour(),
                                    env)
                            .evaluate(source, Collections.singletonMap("oppositeEnd", target)); //$NON-NLS-1$
                    if (false == sourceVal instanceof Boolean || !((Boolean) sourceVal).booleanValue()) {
                        return false;
                    } // else fall-through
                }
                if (target == null) {
                    return true;
                } else {
                    final Map<String, EClassifier> env = Collections.<String, EClassifier> singletonMap("oppositeEnd", //$NON-NLS-1$
                            org.palladiosimulator.pcm.seff.seff_reliability.SeffReliabilityPackage.eINSTANCE
                                    .getRecoveryActionBehaviour());
                    final Object targetVal = PalladioComponentModelOCLFactory
                            .getExpression(3,
                                    org.palladiosimulator.pcm.seff.seff_reliability.SeffReliabilityPackage.eINSTANCE
                                            .getRecoveryActionBehaviour(),
                                    env)
                            .evaluate(target, Collections.singletonMap("oppositeEnd", source)); //$NON-NLS-1$
                    if (false == targetVal instanceof Boolean || !((Boolean) targetVal).booleanValue()) {
                        return false;
                    } // else fall-through
                }
                return true;
            } catch (final Exception e) {
                PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError("Link constraint evaluation error", //$NON-NLS-1$
                        e);
                return false;
            }
        }

    }

}
