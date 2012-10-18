/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.AbstractActionSuccessor_AbstractActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.AcquireAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.AcquireActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionBranchTransitionCompartment2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionBranchTransitionCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.CollectionIteratorAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.CollectionIteratorActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.EmitEventAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.EmitEventActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.EmitEventActionInputVariableUsageEvent2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.EmitEventActionInputVariableUsageEventEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionInputVariableUsage2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionInputVariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionOutputVariableUsage2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionOutputVariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkActionForkedBehaviours2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkActionForkedBehavioursEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkedBehaviour2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkedBehaviourBehaviourCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkedBehaviourEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkedBehaviourSynchronisationPointForkedBehavioursEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.GuardedBranchTransitionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InfrastructureCallEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InfrastructureCallInfrastructureCallInputVariableUsagesEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionFailureOccurrenceDescriptions2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionFailureOccurrenceDescriptionsEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionInfrastructureCallsCompartment2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionInfrastructureCallsCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionResourceDemand2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionResourceDemandEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalFailureOccurrenceDescriptionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ParametricResourceDemandEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ProbabilisticBranchTransitionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.RecoveryAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.RecoveryActionBehaviourAlternativeBehaviourCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.RecoveryActionBehaviourEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviourEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.RecoveryActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.RecoveryActionRecoveryBlockCompartment2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.RecoveryActionRecoveryBlockCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ReleaseAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ReleaseActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviour2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviour3EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviour4EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourBehaviourCompartment2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourBehaviourCompartment3EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourBehaviourCompartment4EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourBehaviourCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingSEFFEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SetVariableAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SetVariableActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SetVariableActionVariableSetter2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SetVariableActionVariableSetterEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StartAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StartActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StopAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StopActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SynchronisationPointEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SynchronisationPointSynchronisationPointEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisation2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisation3EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisation4EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisation5EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsage2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsage3EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsage4EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsage5EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageVariableCharacterisation2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageVariableCharacterisation3EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageVariableCharacterisation4EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageVariableCharacterisation5EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageVariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.reliability.InternalFailureOccurrenceDescription;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition;
import de.uka.ipd.sdq.pcm.seff.AcquireAction;
import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction;
import de.uka.ipd.sdq.pcm.seff.EmitEventAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.ForkAction;
import de.uka.ipd.sdq.pcm.seff.ForkedBehaviour;
import de.uka.ipd.sdq.pcm.seff.GuardedBranchTransition;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.ProbabilisticBranchTransition;
import de.uka.ipd.sdq.pcm.seff.ReleaseAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.SetVariableAction;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.seff.StopAction;
import de.uka.ipd.sdq.pcm.seff.SynchronisationPoint;

/**
 * The Class PalladioComponentModelDiagramUpdater.
 *
 * @generated
 */
public class PalladioComponentModelDiagramUpdater {

    /**
     * Gets the semantic children.
     *
     * @param view the view
     * @return the semantic children
     * @generated
     */
    public static List getSemanticChildren(View view) {
        switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
        case LoopActionEditPart.VISUAL_ID:
            return getLoopAction_2004SemanticChildren(view);
        case CollectionIteratorActionEditPart.VISUAL_ID:
            return getCollectionIteratorAction_2007SemanticChildren(view);
        case LoopAction2EditPart.VISUAL_ID:
            return getLoopAction_3006SemanticChildren(view);
        case ProbabilisticBranchTransitionEditPart.VISUAL_ID:
            return getProbabilisticBranchTransition_3010SemanticChildren(view);
        case CollectionIteratorAction2EditPart.VISUAL_ID:
            return getCollectionIteratorAction_3013SemanticChildren(view);
        case GuardedBranchTransitionEditPart.VISUAL_ID:
            return getGuardedBranchTransition_3017SemanticChildren(view);
        case ExternalCallActionInputVariableUsageEditPart.VISUAL_ID:
            return getExternalCallActionInputVariableUsage_7001SemanticChildren(view);
        case ExternalCallActionOutputVariableUsageEditPart.VISUAL_ID:
            return getExternalCallActionOutputVariableUsage_7021SemanticChildren(view);
        case VariableUsageVariableCharacterisationEditPart.VISUAL_ID:
            return getVariableUsageVariableCharacterisation_7037SemanticChildren(view);
        case VariableUsageVariableCharacterisation2EditPart.VISUAL_ID:
            return getVariableUsageVariableCharacterisation_7044SemanticChildren(view);
        case EmitEventActionInputVariableUsageEventEditPart.VISUAL_ID:
            return getEmitEventActionInputVariableUsageEvent_7042SemanticChildren(view);
        case VariableUsageVariableCharacterisation4EditPart.VISUAL_ID:
            return getVariableUsageVariableCharacterisation_7043SemanticChildren(view);
        case ResourceDemandingBehaviourBehaviourCompartmentEditPart.VISUAL_ID:
            return getResourceDemandingBehaviourBehaviourCompartment_7004SemanticChildren(view);
        case InternalActionResourceDemandEditPart.VISUAL_ID:
            return getInternalActionResourceDemands_7006SemanticChildren(view);
        case InternalActionFailureOccurrenceDescriptionsEditPart.VISUAL_ID:
            return getInternalActionFailureOccurrenceDescriptions_7045SemanticChildren(view);
        case InternalActionInfrastructureCallsCompartmentEditPart.VISUAL_ID:
            return getInternalActionInfrastructureCallsCompartment_7048SemanticChildren(view);
        case InfrastructureCallInfrastructureCallInputVariableUsagesEditPart.VISUAL_ID:
            return getInfrastructureCallInfrastructureCallInputVariableUsages_7049SemanticChildren(view);
        case VariableUsageVariableCharacterisation5EditPart.VISUAL_ID:
            return getVariableUsageVariableCharacterisation_7050SemanticChildren(view);
        case BranchActionBranchTransitionCompartmentEditPart.VISUAL_ID:
            return getBranchActionBranchTransitionCompartment_7007SemanticChildren(view);
        case ResourceDemandingBehaviourBehaviourCompartment2EditPart.VISUAL_ID:
            return getResourceDemandingBehaviourBehaviourCompartment_7009SemanticChildren(view);
        case ExternalCallActionInputVariableUsage2EditPart.VISUAL_ID:
            return getExternalCallActionInputVariableUsage_7010SemanticChildren(view);
        case ExternalCallActionOutputVariableUsage2EditPart.VISUAL_ID:
            return getExternalCallActionOutputVariableUsage_7023SemanticChildren(view);
        case EmitEventActionInputVariableUsageEvent2EditPart.VISUAL_ID:
            return getEmitEventActionInputVariableUsageEvent_7041SemanticChildren(view);
        case ForkActionForkedBehavioursEditPart.VISUAL_ID:
            return getForkActionForkedBehaviours_7024SemanticChildren(view);
        case ForkedBehaviourBehaviourCompartmentEditPart.VISUAL_ID:
            return getForkedBehaviourBehaviourCompartment_7026SemanticChildren(view);
        case ResourceDemandingBehaviourBehaviourCompartment3EditPart.VISUAL_ID:
            return getResourceDemandingBehaviourBehaviourCompartment_7014SemanticChildren(view);
        case RecoveryActionRecoveryBlockCompartmentEditPart.VISUAL_ID:
            return getRecoveryActionRecoveryBlockCompartment_7054SemanticChildren(view);
        case RecoveryActionBehaviourAlternativeBehaviourCompartmentEditPart.VISUAL_ID:
            return getRecoveryActionBehaviourAlternativeBehaviourCompartment_7055SemanticChildren(view);
        case SetVariableActionVariableSetterEditPart.VISUAL_ID:
            return getSetVariableActionVariableSetter_7025SemanticChildren(view);
        case VariableUsageVariableCharacterisation3EditPart.VISUAL_ID:
            return getVariableUsageVariableCharacterisation_7032SemanticChildren(view);
        case SynchronisationPointSynchronisationPointEditPart.VISUAL_ID:
            return getSynchronisationPointSynchronisationPoint_7034SemanticChildren(view);
        case ForkedBehaviourSynchronisationPointForkedBehavioursEditPart.VISUAL_ID:
            return getForkedBehaviourBehaviourCompartment_7033SemanticChildren(view);
        case ResourceDemandingBehaviourBehaviourCompartment4EditPart.VISUAL_ID:
            return getResourceDemandingBehaviourBehaviourCompartment_7018SemanticChildren(view);
        case BranchActionBranchTransitionCompartment2EditPart.VISUAL_ID:
            return getBranchActionBranchTransitionCompartment_7011SemanticChildren(view);
        case InternalActionResourceDemand2EditPart.VISUAL_ID:
            return getInternalActionResourceDemands_7012SemanticChildren(view);
        case InternalActionFailureOccurrenceDescriptions2EditPart.VISUAL_ID:
            return getInternalActionFailureOccurrenceDescriptions_7046SemanticChildren(view);
        case InternalActionInfrastructureCallsCompartment2EditPart.VISUAL_ID:
            return getInternalActionInfrastructureCallsCompartment_7051SemanticChildren(view);
        case SetVariableActionVariableSetter2EditPart.VISUAL_ID:
            return getSetVariableActionVariableSetter_7016SemanticChildren(view);
        case ForkActionForkedBehaviours2EditPart.VISUAL_ID:
            return getForkActionForkedBehaviours_7019SemanticChildren(view);
        case RecoveryActionRecoveryBlockCompartment2EditPart.VISUAL_ID:
            return getRecoveryActionRecoveryBlockCompartment_7056SemanticChildren(view);
        case ResourceDemandingSEFFEditPart.VISUAL_ID:
            return getResourceDemandingSEFF_1000SemanticChildren(view);
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the loop action_2004 semantic children.
     *
     * @param view the view
     * @return the loop action_2004 semantic children
     * @generated
     */
    public static List getLoopAction_2004SemanticChildren(View view) {
        if (!view.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        LoopAction modelElement = (LoopAction) view.getElement();
        List result = new LinkedList();
        {
            ResourceDemandingBehaviour childElement = modelElement.getBodyBehaviour_Loop();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == ResourceDemandingBehaviourEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
            }
        }
        return result;
    }

    /**
     * Gets the collection iterator action_2007 semantic children.
     *
     * @param view the view
     * @return the collection iterator action_2007 semantic children
     * @generated
     */
    public static List getCollectionIteratorAction_2007SemanticChildren(View view) {
        if (!view.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        CollectionIteratorAction modelElement = (CollectionIteratorAction) view.getElement();
        List result = new LinkedList();
        {
            ResourceDemandingBehaviour childElement = modelElement.getBodyBehaviour_Loop();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == ResourceDemandingBehaviour3EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
            }
        }
        return result;
    }

    /**
     * Gets the loop action_3006 semantic children.
     *
     * @param view the view
     * @return the loop action_3006 semantic children
     * @generated
     */
    public static List getLoopAction_3006SemanticChildren(View view) {
        if (!view.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        LoopAction modelElement = (LoopAction) view.getElement();
        List result = new LinkedList();
        {
            ResourceDemandingBehaviour childElement = modelElement.getBodyBehaviour_Loop();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == ResourceDemandingBehaviourEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
            }
        }
        return result;
    }

    /**
     * Gets the probabilistic branch transition_3010 semantic children.
     *
     * @param view the view
     * @return the probabilistic branch transition_3010 semantic children
     * @generated
     */
    public static List getProbabilisticBranchTransition_3010SemanticChildren(View view) {
        if (!view.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        ProbabilisticBranchTransition modelElement = (ProbabilisticBranchTransition) view.getElement();
        List result = new LinkedList();
        {
            ResourceDemandingBehaviour childElement = modelElement.getBranchBehaviour_BranchTransition();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == ResourceDemandingBehaviour2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
            }
        }
        return result;
    }

    /**
     * Gets the collection iterator action_3013 semantic children.
     *
     * @param view the view
     * @return the collection iterator action_3013 semantic children
     * @generated
     */
    public static List getCollectionIteratorAction_3013SemanticChildren(View view) {
        if (!view.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        CollectionIteratorAction modelElement = (CollectionIteratorAction) view.getElement();
        List result = new LinkedList();
        {
            ResourceDemandingBehaviour childElement = modelElement.getBodyBehaviour_Loop();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == ResourceDemandingBehaviour3EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
            }
        }
        return result;
    }

    /**
     * Gets the guarded branch transition_3017 semantic children.
     *
     * @param view the view
     * @return the guarded branch transition_3017 semantic children
     * @generated
     */
    public static List getGuardedBranchTransition_3017SemanticChildren(View view) {
        if (!view.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        GuardedBranchTransition modelElement = (GuardedBranchTransition) view.getElement();
        List result = new LinkedList();
        {
            ResourceDemandingBehaviour childElement = modelElement.getBranchBehaviour_BranchTransition();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == ResourceDemandingBehaviour4EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
            }
        }
        return result;
    }

    /**
     * Gets the external call action input variable usage_7001 semantic children.
     *
     * @param view the view
     * @return the external call action input variable usage_7001 semantic children
     * @generated
     */
    public static List getExternalCallActionInputVariableUsage_7001SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        ExternalCallAction modelElement = (ExternalCallAction) containerView.getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getInputVariableUsages__CallAction().iterator(); it.hasNext();) {
            VariableUsage childElement = (VariableUsage) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == VariableUsageEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * Gets the external call action output variable usage_7021 semantic children.
     *
     * @param view the view
     * @return the external call action output variable usage_7021 semantic children
     * @generated
     */
    public static List getExternalCallActionOutputVariableUsage_7021SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        ExternalCallAction modelElement = (ExternalCallAction) containerView.getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getReturnVariableUsage__CallReturnAction().iterator(); it.hasNext();) {
            VariableUsage childElement = (VariableUsage) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == VariableUsage2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * Gets the variable usage variable characterisation_7037 semantic children.
     *
     * @param view the view
     * @return the variable usage variable characterisation_7037 semantic children
     * @generated
     */
    public static List getVariableUsageVariableCharacterisation_7037SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        VariableUsage modelElement = (VariableUsage) containerView.getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getVariableCharacterisation_VariableUsage().iterator(); it.hasNext();) {
            VariableCharacterisation childElement = (VariableCharacterisation) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == VariableCharacterisationEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * Gets the variable usage variable characterisation_7044 semantic children.
     *
     * @param view the view
     * @return the variable usage variable characterisation_7044 semantic children
     * @generated
     */
    public static List getVariableUsageVariableCharacterisation_7044SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        VariableUsage modelElement = (VariableUsage) containerView.getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getVariableCharacterisation_VariableUsage().iterator(); it.hasNext();) {
            VariableCharacterisation childElement = (VariableCharacterisation) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == VariableCharacterisation2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * Gets the emit event action input variable usage event_7042 semantic children.
     *
     * @param view the view
     * @return the emit event action input variable usage event_7042 semantic children
     * @generated
     */
    public static List getEmitEventActionInputVariableUsageEvent_7042SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        EmitEventAction modelElement = (EmitEventAction) containerView.getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getInputVariableUsages__CallAction().iterator(); it.hasNext();) {
            VariableUsage childElement = (VariableUsage) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == VariableUsage4EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * Gets the variable usage variable characterisation_7043 semantic children.
     *
     * @param view the view
     * @return the variable usage variable characterisation_7043 semantic children
     * @generated
     */
    public static List getVariableUsageVariableCharacterisation_7043SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        VariableUsage modelElement = (VariableUsage) containerView.getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getVariableCharacterisation_VariableUsage().iterator(); it.hasNext();) {
            VariableCharacterisation childElement = (VariableCharacterisation) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == VariableCharacterisation3EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * Gets the resource demanding behaviour behaviour compartment_7004 semantic children.
     *
     * @param view the view
     * @return the resource demanding behaviour behaviour compartment_7004 semantic children
     * @generated
     */
    public static List getResourceDemandingBehaviourBehaviourCompartment_7004SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        ResourceDemandingBehaviour modelElement = (ResourceDemandingBehaviour) containerView.getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getSteps_Behaviour().iterator(); it.hasNext();) {
            AbstractAction childElement = (AbstractAction) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == StartAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == StopAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == LoopAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == InternalAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == BranchAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == ExternalCallAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == EmitEventAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == CollectionIteratorAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == AcquireAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == ReleaseAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == ForkAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == SetVariableAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == RecoveryAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * Gets the internal action resource demands_7006 semantic children.
     *
     * @param view the view
     * @return the internal action resource demands_7006 semantic children
     * @generated
     */
    public static List getInternalActionResourceDemands_7006SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        InternalAction modelElement = (InternalAction) containerView.getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getResourceDemand_Action().iterator(); it.hasNext();) {
            de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand childElement = (de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand) it
                    .next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == ParametricResourceDemandEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * Gets the internal action failure occurrence descriptions_7045 semantic children.
     *
     * @param view the view
     * @return the internal action failure occurrence descriptions_7045 semantic children
     * @generated
     */
    public static List getInternalActionFailureOccurrenceDescriptions_7045SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        InternalAction modelElement = (InternalAction) containerView.getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getInternalFailureOccurrenceDescriptions__InternalAction().iterator(); it
                .hasNext();) {
            InternalFailureOccurrenceDescription childElement = (InternalFailureOccurrenceDescription) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == InternalFailureOccurrenceDescriptionEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * Gets the internal action infrastructure calls compartment_7048 semantic children.
     *
     * @param view the view
     * @return the internal action infrastructure calls compartment_7048 semantic children
     * @generated
     */
    public static List getInternalActionInfrastructureCallsCompartment_7048SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        InternalAction modelElement = (InternalAction) containerView.getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getInfrastructureCall__Action().iterator(); it.hasNext();) {
            de.uka.ipd.sdq.pcm.seff.seff_performance.InfrastructureCall childElement = (de.uka.ipd.sdq.pcm.seff.seff_performance.InfrastructureCall) it
                    .next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == InfrastructureCallEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * Gets the infrastructure call infrastructure call input variable usages_7049 semantic children.
     *
     * @param view the view
     * @return the infrastructure call infrastructure call input variable usages_7049 semantic children
     * @generated
     */
    public static List getInfrastructureCallInfrastructureCallInputVariableUsages_7049SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        de.uka.ipd.sdq.pcm.seff.seff_performance.InfrastructureCall modelElement = (de.uka.ipd.sdq.pcm.seff.seff_performance.InfrastructureCall) containerView
                .getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getInputVariableUsages__CallAction().iterator(); it.hasNext();) {
            VariableUsage childElement = (VariableUsage) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == VariableUsage5EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * Gets the variable usage variable characterisation_7050 semantic children.
     *
     * @param view the view
     * @return the variable usage variable characterisation_7050 semantic children
     * @generated
     */
    public static List getVariableUsageVariableCharacterisation_7050SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        VariableUsage modelElement = (VariableUsage) containerView.getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getVariableCharacterisation_VariableUsage().iterator(); it.hasNext();) {
            VariableCharacterisation childElement = (VariableCharacterisation) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == VariableCharacterisation4EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * Gets the branch action branch transition compartment_7007 semantic children.
     *
     * @param view the view
     * @return the branch action branch transition compartment_7007 semantic children
     * @generated
     */
    public static List getBranchActionBranchTransitionCompartment_7007SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        BranchAction modelElement = (BranchAction) containerView.getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getBranches_Branch().iterator(); it.hasNext();) {
            AbstractBranchTransition childElement = (AbstractBranchTransition) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == ProbabilisticBranchTransitionEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == GuardedBranchTransitionEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * Gets the resource demanding behaviour behaviour compartment_7009 semantic children.
     *
     * @param view the view
     * @return the resource demanding behaviour behaviour compartment_7009 semantic children
     * @generated
     */
    public static List getResourceDemandingBehaviourBehaviourCompartment_7009SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        ResourceDemandingBehaviour modelElement = (ResourceDemandingBehaviour) containerView.getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getSteps_Behaviour().iterator(); it.hasNext();) {
            AbstractAction childElement = (AbstractAction) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == StartAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == StopAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == LoopAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == InternalAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == BranchAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == ExternalCallAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == EmitEventAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == AcquireAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == ReleaseAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == ForkAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == CollectionIteratorAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == SetVariableAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == RecoveryAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * Gets the external call action input variable usage_7010 semantic children.
     *
     * @param view the view
     * @return the external call action input variable usage_7010 semantic children
     * @generated
     */
    public static List getExternalCallActionInputVariableUsage_7010SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        ExternalCallAction modelElement = (ExternalCallAction) containerView.getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getInputVariableUsages__CallAction().iterator(); it.hasNext();) {
            VariableUsage childElement = (VariableUsage) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == VariableUsageEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * Gets the external call action output variable usage_7023 semantic children.
     *
     * @param view the view
     * @return the external call action output variable usage_7023 semantic children
     * @generated
     */
    public static List getExternalCallActionOutputVariableUsage_7023SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        ExternalCallAction modelElement = (ExternalCallAction) containerView.getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getReturnVariableUsage__CallReturnAction().iterator(); it.hasNext();) {
            VariableUsage childElement = (VariableUsage) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == VariableUsage2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * Gets the emit event action input variable usage event_7041 semantic children.
     *
     * @param view the view
     * @return the emit event action input variable usage event_7041 semantic children
     * @generated
     */
    public static List getEmitEventActionInputVariableUsageEvent_7041SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        EmitEventAction modelElement = (EmitEventAction) containerView.getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getInputVariableUsages__CallAction().iterator(); it.hasNext();) {
            VariableUsage childElement = (VariableUsage) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == VariableUsage4EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * Gets the fork action forked behaviours_7024 semantic children.
     *
     * @param view the view
     * @return the fork action forked behaviours_7024 semantic children
     * @generated
     */
    public static List getForkActionForkedBehaviours_7024SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        ForkAction modelElement = (ForkAction) containerView.getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getAsynchronousForkedBehaviours_ForkAction().iterator(); it.hasNext();) {
            ForkedBehaviour childElement = (ForkedBehaviour) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == ForkedBehaviourEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        {
            SynchronisationPoint childElement = modelElement.getSynchronisingBehaviours_ForkAction();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == SynchronisationPointEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
            }
        }
        return result;
    }

    /**
     * Gets the forked behaviour behaviour compartment_7026 semantic children.
     *
     * @param view the view
     * @return the forked behaviour behaviour compartment_7026 semantic children
     * @generated
     */
    public static List getForkedBehaviourBehaviourCompartment_7026SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        ForkedBehaviour modelElement = (ForkedBehaviour) containerView.getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getSteps_Behaviour().iterator(); it.hasNext();) {
            AbstractAction childElement = (AbstractAction) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == StartAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == StopAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == LoopAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == InternalAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == BranchAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == ExternalCallAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == EmitEventAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == CollectionIteratorAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == AcquireAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == ReleaseAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == ForkAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == RecoveryAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * Gets the resource demanding behaviour behaviour compartment_7014 semantic children.
     *
     * @param view the view
     * @return the resource demanding behaviour behaviour compartment_7014 semantic children
     * @generated
     */
    public static List getResourceDemandingBehaviourBehaviourCompartment_7014SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        ResourceDemandingBehaviour modelElement = (ResourceDemandingBehaviour) containerView.getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getSteps_Behaviour().iterator(); it.hasNext();) {
            AbstractAction childElement = (AbstractAction) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == StartAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == StopAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == LoopAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == InternalAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == BranchAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == ExternalCallAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == EmitEventAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == CollectionIteratorAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == AcquireAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == ReleaseAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == ForkAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == RecoveryAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * Gets the recovery action recovery block compartment_7054 semantic children.
     *
     * @param view the view
     * @return the recovery action recovery block compartment_7054 semantic children
     * @generated
     */
    public static List getRecoveryActionRecoveryBlockCompartment_7054SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction modelElement = (de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction) containerView
                .getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getRecoveryActionBehaviours__RecoveryAction().iterator(); it.hasNext();) {
            de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour childElement = (de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour) it
                    .next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == RecoveryActionBehaviourEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * Gets the recovery action behaviour alternative behaviour compartment_7055 semantic children.
     *
     * @param view the view
     * @return the recovery action behaviour alternative behaviour compartment_7055 semantic children
     * @generated
     */
    public static List getRecoveryActionBehaviourAlternativeBehaviourCompartment_7055SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour modelElement = (de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour) containerView
                .getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getSteps_Behaviour().iterator(); it.hasNext();) {
            AbstractAction childElement = (AbstractAction) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == StartAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == StopAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == LoopAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == InternalAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == BranchAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == ExternalCallAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == EmitEventAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == CollectionIteratorAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == AcquireAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == ReleaseAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == ForkAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == SetVariableAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == RecoveryAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * Gets the synchronisation point synchronisation point_7034 semantic children.
     *
     * @param view the view
     * @return the synchronisation point synchronisation point_7034 semantic children
     * @generated
     */
    public static List getSynchronisationPointSynchronisationPoint_7034SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        SynchronisationPoint modelElement = (SynchronisationPoint) containerView.getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getSynchronousForkedBehaviours_SynchronisationPoint().iterator(); it.hasNext();) {
            ForkedBehaviour childElement = (ForkedBehaviour) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == ForkedBehaviour2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * Gets the forked behaviour behaviour compartment_7033 semantic children.
     *
     * @param view the view
     * @return the forked behaviour behaviour compartment_7033 semantic children
     * @generated
     */
    public static List getForkedBehaviourBehaviourCompartment_7033SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        ForkedBehaviour modelElement = (ForkedBehaviour) containerView.getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getSteps_Behaviour().iterator(); it.hasNext();) {
            AbstractAction childElement = (AbstractAction) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == StartAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == StopAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == LoopAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == InternalAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == BranchAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == ExternalCallAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == EmitEventAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == CollectionIteratorAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == AcquireAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == ReleaseAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == ForkAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == RecoveryAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * Gets the sets the variable action variable setter_7025 semantic children.
     *
     * @param view the view
     * @return the sets the variable action variable setter_7025 semantic children
     * @generated
     */
    public static List getSetVariableActionVariableSetter_7025SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        SetVariableAction modelElement = (SetVariableAction) containerView.getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getLocalVariableUsages_SetVariableAction().iterator(); it.hasNext();) {
            VariableUsage childElement = (VariableUsage) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == VariableUsage3EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * Gets the variable usage variable characterisation_7032 semantic children.
     *
     * @param view the view
     * @return the variable usage variable characterisation_7032 semantic children
     * @generated
     */
    public static List getVariableUsageVariableCharacterisation_7032SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        VariableUsage modelElement = (VariableUsage) containerView.getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getVariableCharacterisation_VariableUsage().iterator(); it.hasNext();) {
            VariableCharacterisation childElement = (VariableCharacterisation) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == VariableCharacterisation5EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * Gets the resource demanding behaviour behaviour compartment_7018 semantic children.
     *
     * @param view the view
     * @return the resource demanding behaviour behaviour compartment_7018 semantic children
     * @generated
     */
    public static List getResourceDemandingBehaviourBehaviourCompartment_7018SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        ResourceDemandingBehaviour modelElement = (ResourceDemandingBehaviour) containerView.getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getSteps_Behaviour().iterator(); it.hasNext();) {
            AbstractAction childElement = (AbstractAction) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == StartAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == StopAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == LoopAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == InternalAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == BranchAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == ExternalCallAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == EmitEventAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == AcquireAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == ReleaseAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == ForkAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == CollectionIteratorAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == SetVariableAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == RecoveryAction2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * Gets the branch action branch transition compartment_7011 semantic children.
     *
     * @param view the view
     * @return the branch action branch transition compartment_7011 semantic children
     * @generated
     */
    public static List getBranchActionBranchTransitionCompartment_7011SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        BranchAction modelElement = (BranchAction) containerView.getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getBranches_Branch().iterator(); it.hasNext();) {
            AbstractBranchTransition childElement = (AbstractBranchTransition) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == ProbabilisticBranchTransitionEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == GuardedBranchTransitionEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * Gets the internal action resource demands_7012 semantic children.
     *
     * @param view the view
     * @return the internal action resource demands_7012 semantic children
     * @generated
     */
    public static List getInternalActionResourceDemands_7012SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        InternalAction modelElement = (InternalAction) containerView.getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getResourceDemand_Action().iterator(); it.hasNext();) {
            de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand childElement = (de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand) it
                    .next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == ParametricResourceDemandEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * Gets the internal action failure occurrence descriptions_7046 semantic children.
     *
     * @param view the view
     * @return the internal action failure occurrence descriptions_7046 semantic children
     * @generated
     */
    public static List getInternalActionFailureOccurrenceDescriptions_7046SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        InternalAction modelElement = (InternalAction) containerView.getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getInternalFailureOccurrenceDescriptions__InternalAction().iterator(); it
                .hasNext();) {
            InternalFailureOccurrenceDescription childElement = (InternalFailureOccurrenceDescription) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == InternalFailureOccurrenceDescriptionEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * Gets the internal action infrastructure calls compartment_7051 semantic children.
     *
     * @param view the view
     * @return the internal action infrastructure calls compartment_7051 semantic children
     * @generated
     */
    public static List getInternalActionInfrastructureCallsCompartment_7051SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        InternalAction modelElement = (InternalAction) containerView.getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getInfrastructureCall__Action().iterator(); it.hasNext();) {
            de.uka.ipd.sdq.pcm.seff.seff_performance.InfrastructureCall childElement = (de.uka.ipd.sdq.pcm.seff.seff_performance.InfrastructureCall) it
                    .next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == InfrastructureCallEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * Gets the sets the variable action variable setter_7016 semantic children.
     *
     * @param view the view
     * @return the sets the variable action variable setter_7016 semantic children
     * @generated
     */
    public static List getSetVariableActionVariableSetter_7016SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        SetVariableAction modelElement = (SetVariableAction) containerView.getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getLocalVariableUsages_SetVariableAction().iterator(); it.hasNext();) {
            VariableUsage childElement = (VariableUsage) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == VariableUsage3EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * Gets the fork action forked behaviours_7019 semantic children.
     *
     * @param view the view
     * @return the fork action forked behaviours_7019 semantic children
     * @generated
     */
    public static List getForkActionForkedBehaviours_7019SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        ForkAction modelElement = (ForkAction) containerView.getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getAsynchronousForkedBehaviours_ForkAction().iterator(); it.hasNext();) {
            ForkedBehaviour childElement = (ForkedBehaviour) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == ForkedBehaviourEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        {
            SynchronisationPoint childElement = modelElement.getSynchronisingBehaviours_ForkAction();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == SynchronisationPointEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
            }
        }
        return result;
    }

    /**
     * Gets the recovery action recovery block compartment_7056 semantic children.
     *
     * @param view the view
     * @return the recovery action recovery block compartment_7056 semantic children
     * @generated
     */
    public static List getRecoveryActionRecoveryBlockCompartment_7056SemanticChildren(View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.EMPTY_LIST;
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction modelElement = (de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction) containerView
                .getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getRecoveryActionBehaviours__RecoveryAction().iterator(); it.hasNext();) {
            de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour childElement = (de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour) it
                    .next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == RecoveryActionBehaviourEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * Gets the resource demanding sef f_1000 semantic children.
     *
     * @param view the view
     * @return the resource demanding sef f_1000 semantic children
     * @generated
     */
    public static List getResourceDemandingSEFF_1000SemanticChildren(View view) {
        if (!view.isSetElement()) {
            return Collections.EMPTY_LIST;
        }
        ResourceDemandingSEFF modelElement = (ResourceDemandingSEFF) view.getElement();
        List result = new LinkedList();
        for (Iterator it = modelElement.getSteps_Behaviour().iterator(); it.hasNext();) {
            AbstractAction childElement = (AbstractAction) it.next();
            int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == StartActionEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == StopActionEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == ExternalCallActionEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == EmitEventActionEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == LoopActionEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == BranchActionEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == InternalActionEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == CollectionIteratorActionEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == SetVariableActionEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == AcquireActionEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == ReleaseActionEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == ForkActionEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
            if (visualID == RecoveryActionEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        return result;
    }

    /**
     * Gets the contained links.
     *
     * @param view the view
     * @return the contained links
     * @generated
     */
    public static List getContainedLinks(View view) {
        switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
        case ResourceDemandingSEFFEditPart.VISUAL_ID:
            return getResourceDemandingSEFF_1000ContainedLinks(view);
        case StartActionEditPart.VISUAL_ID:
            return getStartAction_2001ContainedLinks(view);
        case StopActionEditPart.VISUAL_ID:
            return getStopAction_2002ContainedLinks(view);
        case ExternalCallActionEditPart.VISUAL_ID:
            return getExternalCallAction_2003ContainedLinks(view);
        case EmitEventActionEditPart.VISUAL_ID:
            return getEmitEventAction_2013ContainedLinks(view);
        case LoopActionEditPart.VISUAL_ID:
            return getLoopAction_2004ContainedLinks(view);
        case BranchActionEditPart.VISUAL_ID:
            return getBranchAction_2005ContainedLinks(view);
        case InternalActionEditPart.VISUAL_ID:
            return getInternalAction_2006ContainedLinks(view);
        case CollectionIteratorActionEditPart.VISUAL_ID:
            return getCollectionIteratorAction_2007ContainedLinks(view);
        case SetVariableActionEditPart.VISUAL_ID:
            return getSetVariableAction_2008ContainedLinks(view);
        case AcquireActionEditPart.VISUAL_ID:
            return getAcquireAction_2012ContainedLinks(view);
        case ReleaseActionEditPart.VISUAL_ID:
            return getReleaseAction_2010ContainedLinks(view);
        case ForkActionEditPart.VISUAL_ID:
            return getForkAction_2011ContainedLinks(view);
        case RecoveryActionEditPart.VISUAL_ID:
            return getRecoveryAction_2016ContainedLinks(view);
        case VariableUsageEditPart.VISUAL_ID:
            return getVariableUsage_3042ContainedLinks(view);
        case VariableCharacterisationEditPart.VISUAL_ID:
            return getVariableCharacterisation_3033ContainedLinks(view);
        case VariableUsage2EditPart.VISUAL_ID:
            return getVariableUsage_3049ContainedLinks(view);
        case VariableCharacterisation2EditPart.VISUAL_ID:
            return getVariableCharacterisation_3035ContainedLinks(view);
        case VariableUsage4EditPart.VISUAL_ID:
            return getVariableUsage_3047ContainedLinks(view);
        case VariableCharacterisation3EditPart.VISUAL_ID:
            return getVariableCharacterisation_3037ContainedLinks(view);
        case ResourceDemandingBehaviourEditPart.VISUAL_ID:
            return getResourceDemandingBehaviour_3003ContainedLinks(view);
        case StartAction2EditPart.VISUAL_ID:
            return getStartAction_3004ContainedLinks(view);
        case StopAction2EditPart.VISUAL_ID:
            return getStopAction_3005ContainedLinks(view);
        case LoopAction2EditPart.VISUAL_ID:
            return getLoopAction_3006ContainedLinks(view);
        case InternalAction2EditPart.VISUAL_ID:
            return getInternalAction_3007ContainedLinks(view);
        case ParametricResourceDemandEditPart.VISUAL_ID:
            return getParametricResourceDemand_3051ContainedLinks(view);
        case InternalFailureOccurrenceDescriptionEditPart.VISUAL_ID:
            return getInternalFailureOccurrenceDescription_3050ContainedLinks(view);
        case InfrastructureCallEditPart.VISUAL_ID:
            return getInfrastructureCall_3053ContainedLinks(view);
        case VariableUsage5EditPart.VISUAL_ID:
            return getVariableUsage_3054ContainedLinks(view);
        case VariableCharacterisation4EditPart.VISUAL_ID:
            return getVariableCharacterisation_3048ContainedLinks(view);
        case BranchAction2EditPart.VISUAL_ID:
            return getBranchAction_3009ContainedLinks(view);
        case ProbabilisticBranchTransitionEditPart.VISUAL_ID:
            return getProbabilisticBranchTransition_3010ContainedLinks(view);
        case ResourceDemandingBehaviour2EditPart.VISUAL_ID:
            return getResourceDemandingBehaviour_3011ContainedLinks(view);
        case ExternalCallAction2EditPart.VISUAL_ID:
            return getExternalCallAction_3012ContainedLinks(view);
        case EmitEventAction2EditPart.VISUAL_ID:
            return getEmitEventAction_3046ContainedLinks(view);
        case AcquireAction2EditPart.VISUAL_ID:
            return getAcquireAction_3026ContainedLinks(view);
        case ReleaseAction2EditPart.VISUAL_ID:
            return getReleaseAction_3020ContainedLinks(view);
        case ForkAction2EditPart.VISUAL_ID:
            return getForkAction_3023ContainedLinks(view);
        case ForkedBehaviourEditPart.VISUAL_ID:
            return getForkedBehaviour_3027ContainedLinks(view);
        case CollectionIteratorAction2EditPart.VISUAL_ID:
            return getCollectionIteratorAction_3013ContainedLinks(view);
        case ResourceDemandingBehaviour3EditPart.VISUAL_ID:
            return getResourceDemandingBehaviour_3014ContainedLinks(view);
        case RecoveryAction2EditPart.VISUAL_ID:
            return getRecoveryAction_3057ContainedLinks(view);
        case RecoveryActionBehaviourEditPart.VISUAL_ID:
            return getRecoveryActionBehaviour_3058ContainedLinks(view);
        case SetVariableAction2EditPart.VISUAL_ID:
            return getSetVariableAction_3024ContainedLinks(view);
        case VariableUsage3EditPart.VISUAL_ID:
            return getVariableUsage_3036ContainedLinks(view);
        case VariableCharacterisation5EditPart.VISUAL_ID:
            return getVariableCharacterisation_3055ContainedLinks(view);
        case SynchronisationPointEditPart.VISUAL_ID:
            return getSynchronisationPoint_3038ContainedLinks(view);
        case ForkedBehaviour2EditPart.VISUAL_ID:
            return getForkedBehaviour_3039ContainedLinks(view);
        case GuardedBranchTransitionEditPart.VISUAL_ID:
            return getGuardedBranchTransition_3017ContainedLinks(view);
        case ResourceDemandingBehaviour4EditPart.VISUAL_ID:
            return getResourceDemandingBehaviour_3018ContainedLinks(view);
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the incoming links.
     *
     * @param view the view
     * @return the incoming links
     * @generated
     */
    public static List getIncomingLinks(View view) {
        switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
        case StartActionEditPart.VISUAL_ID:
            return getStartAction_2001IncomingLinks(view);
        case StopActionEditPart.VISUAL_ID:
            return getStopAction_2002IncomingLinks(view);
        case ExternalCallActionEditPart.VISUAL_ID:
            return getExternalCallAction_2003IncomingLinks(view);
        case EmitEventActionEditPart.VISUAL_ID:
            return getEmitEventAction_2013IncomingLinks(view);
        case LoopActionEditPart.VISUAL_ID:
            return getLoopAction_2004IncomingLinks(view);
        case BranchActionEditPart.VISUAL_ID:
            return getBranchAction_2005IncomingLinks(view);
        case InternalActionEditPart.VISUAL_ID:
            return getInternalAction_2006IncomingLinks(view);
        case CollectionIteratorActionEditPart.VISUAL_ID:
            return getCollectionIteratorAction_2007IncomingLinks(view);
        case SetVariableActionEditPart.VISUAL_ID:
            return getSetVariableAction_2008IncomingLinks(view);
        case AcquireActionEditPart.VISUAL_ID:
            return getAcquireAction_2012IncomingLinks(view);
        case ReleaseActionEditPart.VISUAL_ID:
            return getReleaseAction_2010IncomingLinks(view);
        case ForkActionEditPart.VISUAL_ID:
            return getForkAction_2011IncomingLinks(view);
        case RecoveryActionEditPart.VISUAL_ID:
            return getRecoveryAction_2016IncomingLinks(view);
        case VariableUsageEditPart.VISUAL_ID:
            return getVariableUsage_3042IncomingLinks(view);
        case VariableCharacterisationEditPart.VISUAL_ID:
            return getVariableCharacterisation_3033IncomingLinks(view);
        case VariableUsage2EditPart.VISUAL_ID:
            return getVariableUsage_3049IncomingLinks(view);
        case VariableCharacterisation2EditPart.VISUAL_ID:
            return getVariableCharacterisation_3035IncomingLinks(view);
        case VariableUsage4EditPart.VISUAL_ID:
            return getVariableUsage_3047IncomingLinks(view);
        case VariableCharacterisation3EditPart.VISUAL_ID:
            return getVariableCharacterisation_3037IncomingLinks(view);
        case ResourceDemandingBehaviourEditPart.VISUAL_ID:
            return getResourceDemandingBehaviour_3003IncomingLinks(view);
        case StartAction2EditPart.VISUAL_ID:
            return getStartAction_3004IncomingLinks(view);
        case StopAction2EditPart.VISUAL_ID:
            return getStopAction_3005IncomingLinks(view);
        case LoopAction2EditPart.VISUAL_ID:
            return getLoopAction_3006IncomingLinks(view);
        case InternalAction2EditPart.VISUAL_ID:
            return getInternalAction_3007IncomingLinks(view);
        case ParametricResourceDemandEditPart.VISUAL_ID:
            return getParametricResourceDemand_3051IncomingLinks(view);
        case InternalFailureOccurrenceDescriptionEditPart.VISUAL_ID:
            return getInternalFailureOccurrenceDescription_3050IncomingLinks(view);
        case InfrastructureCallEditPart.VISUAL_ID:
            return getInfrastructureCall_3053IncomingLinks(view);
        case VariableUsage5EditPart.VISUAL_ID:
            return getVariableUsage_3054IncomingLinks(view);
        case VariableCharacterisation4EditPart.VISUAL_ID:
            return getVariableCharacterisation_3048IncomingLinks(view);
        case BranchAction2EditPart.VISUAL_ID:
            return getBranchAction_3009IncomingLinks(view);
        case ProbabilisticBranchTransitionEditPart.VISUAL_ID:
            return getProbabilisticBranchTransition_3010IncomingLinks(view);
        case ResourceDemandingBehaviour2EditPart.VISUAL_ID:
            return getResourceDemandingBehaviour_3011IncomingLinks(view);
        case ExternalCallAction2EditPart.VISUAL_ID:
            return getExternalCallAction_3012IncomingLinks(view);
        case EmitEventAction2EditPart.VISUAL_ID:
            return getEmitEventAction_3046IncomingLinks(view);
        case AcquireAction2EditPart.VISUAL_ID:
            return getAcquireAction_3026IncomingLinks(view);
        case ReleaseAction2EditPart.VISUAL_ID:
            return getReleaseAction_3020IncomingLinks(view);
        case ForkAction2EditPart.VISUAL_ID:
            return getForkAction_3023IncomingLinks(view);
        case ForkedBehaviourEditPart.VISUAL_ID:
            return getForkedBehaviour_3027IncomingLinks(view);
        case CollectionIteratorAction2EditPart.VISUAL_ID:
            return getCollectionIteratorAction_3013IncomingLinks(view);
        case ResourceDemandingBehaviour3EditPart.VISUAL_ID:
            return getResourceDemandingBehaviour_3014IncomingLinks(view);
        case RecoveryAction2EditPart.VISUAL_ID:
            return getRecoveryAction_3057IncomingLinks(view);
        case RecoveryActionBehaviourEditPart.VISUAL_ID:
            return getRecoveryActionBehaviour_3058IncomingLinks(view);
        case SetVariableAction2EditPart.VISUAL_ID:
            return getSetVariableAction_3024IncomingLinks(view);
        case VariableUsage3EditPart.VISUAL_ID:
            return getVariableUsage_3036IncomingLinks(view);
        case VariableCharacterisation5EditPart.VISUAL_ID:
            return getVariableCharacterisation_3055IncomingLinks(view);
        case SynchronisationPointEditPart.VISUAL_ID:
            return getSynchronisationPoint_3038IncomingLinks(view);
        case ForkedBehaviour2EditPart.VISUAL_ID:
            return getForkedBehaviour_3039IncomingLinks(view);
        case GuardedBranchTransitionEditPart.VISUAL_ID:
            return getGuardedBranchTransition_3017IncomingLinks(view);
        case ResourceDemandingBehaviour4EditPart.VISUAL_ID:
            return getResourceDemandingBehaviour_3018IncomingLinks(view);
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the outgoing links.
     *
     * @param view the view
     * @return the outgoing links
     * @generated
     */
    public static List getOutgoingLinks(View view) {
        switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
        case StartActionEditPart.VISUAL_ID:
            return getStartAction_2001OutgoingLinks(view);
        case StopActionEditPart.VISUAL_ID:
            return getStopAction_2002OutgoingLinks(view);
        case ExternalCallActionEditPart.VISUAL_ID:
            return getExternalCallAction_2003OutgoingLinks(view);
        case EmitEventActionEditPart.VISUAL_ID:
            return getEmitEventAction_2013OutgoingLinks(view);
        case LoopActionEditPart.VISUAL_ID:
            return getLoopAction_2004OutgoingLinks(view);
        case BranchActionEditPart.VISUAL_ID:
            return getBranchAction_2005OutgoingLinks(view);
        case InternalActionEditPart.VISUAL_ID:
            return getInternalAction_2006OutgoingLinks(view);
        case CollectionIteratorActionEditPart.VISUAL_ID:
            return getCollectionIteratorAction_2007OutgoingLinks(view);
        case SetVariableActionEditPart.VISUAL_ID:
            return getSetVariableAction_2008OutgoingLinks(view);
        case AcquireActionEditPart.VISUAL_ID:
            return getAcquireAction_2012OutgoingLinks(view);
        case ReleaseActionEditPart.VISUAL_ID:
            return getReleaseAction_2010OutgoingLinks(view);
        case ForkActionEditPart.VISUAL_ID:
            return getForkAction_2011OutgoingLinks(view);
        case RecoveryActionEditPart.VISUAL_ID:
            return getRecoveryAction_2016OutgoingLinks(view);
        case VariableUsageEditPart.VISUAL_ID:
            return getVariableUsage_3042OutgoingLinks(view);
        case VariableCharacterisationEditPart.VISUAL_ID:
            return getVariableCharacterisation_3033OutgoingLinks(view);
        case VariableUsage2EditPart.VISUAL_ID:
            return getVariableUsage_3049OutgoingLinks(view);
        case VariableCharacterisation2EditPart.VISUAL_ID:
            return getVariableCharacterisation_3035OutgoingLinks(view);
        case VariableUsage4EditPart.VISUAL_ID:
            return getVariableUsage_3047OutgoingLinks(view);
        case VariableCharacterisation3EditPart.VISUAL_ID:
            return getVariableCharacterisation_3037OutgoingLinks(view);
        case ResourceDemandingBehaviourEditPart.VISUAL_ID:
            return getResourceDemandingBehaviour_3003OutgoingLinks(view);
        case StartAction2EditPart.VISUAL_ID:
            return getStartAction_3004OutgoingLinks(view);
        case StopAction2EditPart.VISUAL_ID:
            return getStopAction_3005OutgoingLinks(view);
        case LoopAction2EditPart.VISUAL_ID:
            return getLoopAction_3006OutgoingLinks(view);
        case InternalAction2EditPart.VISUAL_ID:
            return getInternalAction_3007OutgoingLinks(view);
        case ParametricResourceDemandEditPart.VISUAL_ID:
            return getParametricResourceDemand_3051OutgoingLinks(view);
        case InternalFailureOccurrenceDescriptionEditPart.VISUAL_ID:
            return getInternalFailureOccurrenceDescription_3050OutgoingLinks(view);
        case InfrastructureCallEditPart.VISUAL_ID:
            return getInfrastructureCall_3053OutgoingLinks(view);
        case VariableUsage5EditPart.VISUAL_ID:
            return getVariableUsage_3054OutgoingLinks(view);
        case VariableCharacterisation4EditPart.VISUAL_ID:
            return getVariableCharacterisation_3048OutgoingLinks(view);
        case BranchAction2EditPart.VISUAL_ID:
            return getBranchAction_3009OutgoingLinks(view);
        case ProbabilisticBranchTransitionEditPart.VISUAL_ID:
            return getProbabilisticBranchTransition_3010OutgoingLinks(view);
        case ResourceDemandingBehaviour2EditPart.VISUAL_ID:
            return getResourceDemandingBehaviour_3011OutgoingLinks(view);
        case ExternalCallAction2EditPart.VISUAL_ID:
            return getExternalCallAction_3012OutgoingLinks(view);
        case EmitEventAction2EditPart.VISUAL_ID:
            return getEmitEventAction_3046OutgoingLinks(view);
        case AcquireAction2EditPart.VISUAL_ID:
            return getAcquireAction_3026OutgoingLinks(view);
        case ReleaseAction2EditPart.VISUAL_ID:
            return getReleaseAction_3020OutgoingLinks(view);
        case ForkAction2EditPart.VISUAL_ID:
            return getForkAction_3023OutgoingLinks(view);
        case ForkedBehaviourEditPart.VISUAL_ID:
            return getForkedBehaviour_3027OutgoingLinks(view);
        case CollectionIteratorAction2EditPart.VISUAL_ID:
            return getCollectionIteratorAction_3013OutgoingLinks(view);
        case ResourceDemandingBehaviour3EditPart.VISUAL_ID:
            return getResourceDemandingBehaviour_3014OutgoingLinks(view);
        case RecoveryAction2EditPart.VISUAL_ID:
            return getRecoveryAction_3057OutgoingLinks(view);
        case RecoveryActionBehaviourEditPart.VISUAL_ID:
            return getRecoveryActionBehaviour_3058OutgoingLinks(view);
        case SetVariableAction2EditPart.VISUAL_ID:
            return getSetVariableAction_3024OutgoingLinks(view);
        case VariableUsage3EditPart.VISUAL_ID:
            return getVariableUsage_3036OutgoingLinks(view);
        case VariableCharacterisation5EditPart.VISUAL_ID:
            return getVariableCharacterisation_3055OutgoingLinks(view);
        case SynchronisationPointEditPart.VISUAL_ID:
            return getSynchronisationPoint_3038OutgoingLinks(view);
        case ForkedBehaviour2EditPart.VISUAL_ID:
            return getForkedBehaviour_3039OutgoingLinks(view);
        case GuardedBranchTransitionEditPart.VISUAL_ID:
            return getGuardedBranchTransition_3017OutgoingLinks(view);
        case ResourceDemandingBehaviour4EditPart.VISUAL_ID:
            return getResourceDemandingBehaviour_3018OutgoingLinks(view);
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the resource demanding sef f_1000 contained links.
     *
     * @param view the view
     * @return the resource demanding sef f_1000 contained links
     * @generated
     */
    public static List getResourceDemandingSEFF_1000ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the start action_2001 contained links.
     *
     * @param view the view
     * @return the start action_2001 contained links
     * @generated
     */
    public static List getStartAction_2001ContainedLinks(View view) {
        StartAction modelElement = (StartAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the stop action_2002 contained links.
     *
     * @param view the view
     * @return the stop action_2002 contained links
     * @generated
     */
    public static List getStopAction_2002ContainedLinks(View view) {
        StopAction modelElement = (StopAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the external call action_2003 contained links.
     *
     * @param view the view
     * @return the external call action_2003 contained links
     * @generated
     */
    public static List getExternalCallAction_2003ContainedLinks(View view) {
        ExternalCallAction modelElement = (ExternalCallAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the emit event action_2013 contained links.
     *
     * @param view the view
     * @return the emit event action_2013 contained links
     * @generated
     */
    public static List getEmitEventAction_2013ContainedLinks(View view) {
        EmitEventAction modelElement = (EmitEventAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the loop action_2004 contained links.
     *
     * @param view the view
     * @return the loop action_2004 contained links
     * @generated
     */
    public static List getLoopAction_2004ContainedLinks(View view) {
        LoopAction modelElement = (LoopAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the branch action_2005 contained links.
     *
     * @param view the view
     * @return the branch action_2005 contained links
     * @generated
     */
    public static List getBranchAction_2005ContainedLinks(View view) {
        BranchAction modelElement = (BranchAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the internal action_2006 contained links.
     *
     * @param view the view
     * @return the internal action_2006 contained links
     * @generated
     */
    public static List getInternalAction_2006ContainedLinks(View view) {
        InternalAction modelElement = (InternalAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the collection iterator action_2007 contained links.
     *
     * @param view the view
     * @return the collection iterator action_2007 contained links
     * @generated
     */
    public static List getCollectionIteratorAction_2007ContainedLinks(View view) {
        CollectionIteratorAction modelElement = (CollectionIteratorAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the sets the variable action_2008 contained links.
     *
     * @param view the view
     * @return the sets the variable action_2008 contained links
     * @generated
     */
    public static List getSetVariableAction_2008ContainedLinks(View view) {
        SetVariableAction modelElement = (SetVariableAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the acquire action_2012 contained links.
     *
     * @param view the view
     * @return the acquire action_2012 contained links
     * @generated
     */
    public static List getAcquireAction_2012ContainedLinks(View view) {
        AcquireAction modelElement = (AcquireAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the release action_2010 contained links.
     *
     * @param view the view
     * @return the release action_2010 contained links
     * @generated
     */
    public static List getReleaseAction_2010ContainedLinks(View view) {
        ReleaseAction modelElement = (ReleaseAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the fork action_2011 contained links.
     *
     * @param view the view
     * @return the fork action_2011 contained links
     * @generated
     */
    public static List getForkAction_2011ContainedLinks(View view) {
        ForkAction modelElement = (ForkAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the recovery action_2016 contained links.
     *
     * @param view the view
     * @return the recovery action_2016 contained links
     * @generated
     */
    public static List getRecoveryAction_2016ContainedLinks(View view) {
        de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction modelElement = (de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction) view
                .getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the variable usage_3042 contained links.
     *
     * @param view the view
     * @return the variable usage_3042 contained links
     * @generated
     */
    public static List getVariableUsage_3042ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the variable characterisation_3033 contained links.
     *
     * @param view the view
     * @return the variable characterisation_3033 contained links
     * @generated
     */
    public static List getVariableCharacterisation_3033ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the variable usage_3049 contained links.
     *
     * @param view the view
     * @return the variable usage_3049 contained links
     * @generated
     */
    public static List getVariableUsage_3049ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the variable characterisation_3035 contained links.
     *
     * @param view the view
     * @return the variable characterisation_3035 contained links
     * @generated
     */
    public static List getVariableCharacterisation_3035ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the variable usage_3047 contained links.
     *
     * @param view the view
     * @return the variable usage_3047 contained links
     * @generated
     */
    public static List getVariableUsage_3047ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the resource demanding behaviour_3003 contained links.
     *
     * @param view the view
     * @return the resource demanding behaviour_3003 contained links
     * @generated
     */
    public static List getResourceDemandingBehaviour_3003ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the start action_3004 contained links.
     *
     * @param view the view
     * @return the start action_3004 contained links
     * @generated
     */
    public static List getStartAction_3004ContainedLinks(View view) {
        StartAction modelElement = (StartAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the stop action_3005 contained links.
     *
     * @param view the view
     * @return the stop action_3005 contained links
     * @generated
     */
    public static List getStopAction_3005ContainedLinks(View view) {
        StopAction modelElement = (StopAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the loop action_3006 contained links.
     *
     * @param view the view
     * @return the loop action_3006 contained links
     * @generated
     */
    public static List getLoopAction_3006ContainedLinks(View view) {
        LoopAction modelElement = (LoopAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the internal action_3007 contained links.
     *
     * @param view the view
     * @return the internal action_3007 contained links
     * @generated
     */
    public static List getInternalAction_3007ContainedLinks(View view) {
        InternalAction modelElement = (InternalAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the parametric resource demand_3051 contained links.
     *
     * @param view the view
     * @return the parametric resource demand_3051 contained links
     * @generated
     */
    public static List getParametricResourceDemand_3051ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the internal failure occurrence description_3050 contained links.
     *
     * @param view the view
     * @return the internal failure occurrence description_3050 contained links
     * @generated
     */
    public static List getInternalFailureOccurrenceDescription_3050ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the infrastructure call_3053 contained links.
     *
     * @param view the view
     * @return the infrastructure call_3053 contained links
     * @generated
     */
    public static List getInfrastructureCall_3053ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the variable usage_3054 contained links.
     *
     * @param view the view
     * @return the variable usage_3054 contained links
     * @generated
     */
    public static List getVariableUsage_3054ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the branch action_3009 contained links.
     *
     * @param view the view
     * @return the branch action_3009 contained links
     * @generated
     */
    public static List getBranchAction_3009ContainedLinks(View view) {
        BranchAction modelElement = (BranchAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the probabilistic branch transition_3010 contained links.
     *
     * @param view the view
     * @return the probabilistic branch transition_3010 contained links
     * @generated
     */
    public static List getProbabilisticBranchTransition_3010ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the resource demanding behaviour_3011 contained links.
     *
     * @param view the view
     * @return the resource demanding behaviour_3011 contained links
     * @generated
     */
    public static List getResourceDemandingBehaviour_3011ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the external call action_3012 contained links.
     *
     * @param view the view
     * @return the external call action_3012 contained links
     * @generated
     */
    public static List getExternalCallAction_3012ContainedLinks(View view) {
        ExternalCallAction modelElement = (ExternalCallAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the emit event action_3046 contained links.
     *
     * @param view the view
     * @return the emit event action_3046 contained links
     * @generated
     */
    public static List getEmitEventAction_3046ContainedLinks(View view) {
        EmitEventAction modelElement = (EmitEventAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the acquire action_3026 contained links.
     *
     * @param view the view
     * @return the acquire action_3026 contained links
     * @generated
     */
    public static List getAcquireAction_3026ContainedLinks(View view) {
        AcquireAction modelElement = (AcquireAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the release action_3020 contained links.
     *
     * @param view the view
     * @return the release action_3020 contained links
     * @generated
     */
    public static List getReleaseAction_3020ContainedLinks(View view) {
        ReleaseAction modelElement = (ReleaseAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the fork action_3023 contained links.
     *
     * @param view the view
     * @return the fork action_3023 contained links
     * @generated
     */
    public static List getForkAction_3023ContainedLinks(View view) {
        ForkAction modelElement = (ForkAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the forked behaviour_3027 contained links.
     *
     * @param view the view
     * @return the forked behaviour_3027 contained links
     * @generated
     */
    public static List getForkedBehaviour_3027ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the collection iterator action_3013 contained links.
     *
     * @param view the view
     * @return the collection iterator action_3013 contained links
     * @generated
     */
    public static List getCollectionIteratorAction_3013ContainedLinks(View view) {
        CollectionIteratorAction modelElement = (CollectionIteratorAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the resource demanding behaviour_3014 contained links.
     *
     * @param view the view
     * @return the resource demanding behaviour_3014 contained links
     * @generated
     */
    public static List getResourceDemandingBehaviour_3014ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the recovery action_3057 contained links.
     *
     * @param view the view
     * @return the recovery action_3057 contained links
     * @generated
     */
    public static List getRecoveryAction_3057ContainedLinks(View view) {
        de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction modelElement = (de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction) view
                .getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the recovery action behaviour_3058 contained links.
     *
     * @param view the view
     * @return the recovery action behaviour_3058 contained links
     * @generated
     */
    public static List getRecoveryActionBehaviour_3058ContainedLinks(View view) {
        de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour modelElement = (de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour) view
                .getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_RecoveryActionBehaviour_FailureHandlingAlternatives__RecoveryActionBehaviour_4004(modelElement));
        return result;
    }

    /**
     * Gets the synchronisation point_3038 contained links.
     *
     * @param view the view
     * @return the synchronisation point_3038 contained links
     * @generated
     */
    public static List getSynchronisationPoint_3038ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the forked behaviour_3039 contained links.
     *
     * @param view the view
     * @return the forked behaviour_3039 contained links
     * @generated
     */
    public static List getForkedBehaviour_3039ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the sets the variable action_3024 contained links.
     *
     * @param view the view
     * @return the sets the variable action_3024 contained links
     * @generated
     */
    public static List getSetVariableAction_3024ContainedLinks(View view) {
        SetVariableAction modelElement = (SetVariableAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the variable usage_3036 contained links.
     *
     * @param view the view
     * @return the variable usage_3036 contained links
     * @generated
     */
    public static List getVariableUsage_3036ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the variable characterisation_3055 contained links.
     *
     * @param view the view
     * @return the variable characterisation_3055 contained links
     * @generated
     */
    public static List getVariableCharacterisation_3055ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the variable characterisation_3048 contained links.
     *
     * @param view the view
     * @return the variable characterisation_3048 contained links
     * @generated
     */
    public static List getVariableCharacterisation_3048ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the variable characterisation_3037 contained links.
     *
     * @param view the view
     * @return the variable characterisation_3037 contained links
     * @generated
     */
    public static List getVariableCharacterisation_3037ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the guarded branch transition_3017 contained links.
     *
     * @param view the view
     * @return the guarded branch transition_3017 contained links
     * @generated
     */
    public static List getGuardedBranchTransition_3017ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the resource demanding behaviour_3018 contained links.
     *
     * @param view the view
     * @return the resource demanding behaviour_3018 contained links
     * @generated
     */
    public static List getResourceDemandingBehaviour_3018ContainedLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the start action_2001 incoming links.
     *
     * @param view the view
     * @return the start action_2001 incoming links
     * @generated
     */
    public static List getStartAction_2001IncomingLinks(View view) {
        StartAction modelElement = (StartAction) view.getElement();
        Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
        List result = new LinkedList();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * Gets the stop action_2002 incoming links.
     *
     * @param view the view
     * @return the stop action_2002 incoming links
     * @generated
     */
    public static List getStopAction_2002IncomingLinks(View view) {
        StopAction modelElement = (StopAction) view.getElement();
        Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
        List result = new LinkedList();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * Gets the external call action_2003 incoming links.
     *
     * @param view the view
     * @return the external call action_2003 incoming links
     * @generated
     */
    public static List getExternalCallAction_2003IncomingLinks(View view) {
        ExternalCallAction modelElement = (ExternalCallAction) view.getElement();
        Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
        List result = new LinkedList();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * Gets the emit event action_2013 incoming links.
     *
     * @param view the view
     * @return the emit event action_2013 incoming links
     * @generated
     */
    public static List getEmitEventAction_2013IncomingLinks(View view) {
        EmitEventAction modelElement = (EmitEventAction) view.getElement();
        Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
        List result = new LinkedList();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * Gets the loop action_2004 incoming links.
     *
     * @param view the view
     * @return the loop action_2004 incoming links
     * @generated
     */
    public static List getLoopAction_2004IncomingLinks(View view) {
        LoopAction modelElement = (LoopAction) view.getElement();
        Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
        List result = new LinkedList();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * Gets the branch action_2005 incoming links.
     *
     * @param view the view
     * @return the branch action_2005 incoming links
     * @generated
     */
    public static List getBranchAction_2005IncomingLinks(View view) {
        BranchAction modelElement = (BranchAction) view.getElement();
        Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
        List result = new LinkedList();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * Gets the internal action_2006 incoming links.
     *
     * @param view the view
     * @return the internal action_2006 incoming links
     * @generated
     */
    public static List getInternalAction_2006IncomingLinks(View view) {
        InternalAction modelElement = (InternalAction) view.getElement();
        Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
        List result = new LinkedList();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * Gets the collection iterator action_2007 incoming links.
     *
     * @param view the view
     * @return the collection iterator action_2007 incoming links
     * @generated
     */
    public static List getCollectionIteratorAction_2007IncomingLinks(View view) {
        CollectionIteratorAction modelElement = (CollectionIteratorAction) view.getElement();
        Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
        List result = new LinkedList();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * Gets the sets the variable action_2008 incoming links.
     *
     * @param view the view
     * @return the sets the variable action_2008 incoming links
     * @generated
     */
    public static List getSetVariableAction_2008IncomingLinks(View view) {
        SetVariableAction modelElement = (SetVariableAction) view.getElement();
        Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
        List result = new LinkedList();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * Gets the acquire action_2012 incoming links.
     *
     * @param view the view
     * @return the acquire action_2012 incoming links
     * @generated
     */
    public static List getAcquireAction_2012IncomingLinks(View view) {
        AcquireAction modelElement = (AcquireAction) view.getElement();
        Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
        List result = new LinkedList();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * Gets the release action_2010 incoming links.
     *
     * @param view the view
     * @return the release action_2010 incoming links
     * @generated
     */
    public static List getReleaseAction_2010IncomingLinks(View view) {
        ReleaseAction modelElement = (ReleaseAction) view.getElement();
        Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
        List result = new LinkedList();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * Gets the fork action_2011 incoming links.
     *
     * @param view the view
     * @return the fork action_2011 incoming links
     * @generated
     */
    public static List getForkAction_2011IncomingLinks(View view) {
        ForkAction modelElement = (ForkAction) view.getElement();
        Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
        List result = new LinkedList();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * Gets the recovery action_2016 incoming links.
     *
     * @param view the view
     * @return the recovery action_2016 incoming links
     * @generated
     */
    public static List getRecoveryAction_2016IncomingLinks(View view) {
        de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction modelElement = (de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction) view
                .getElement();
        Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
        List result = new LinkedList();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * Gets the variable usage_3042 incoming links.
     *
     * @param view the view
     * @return the variable usage_3042 incoming links
     * @generated
     */
    public static List getVariableUsage_3042IncomingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the variable characterisation_3033 incoming links.
     *
     * @param view the view
     * @return the variable characterisation_3033 incoming links
     * @generated
     */
    public static List getVariableCharacterisation_3033IncomingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the variable usage_3049 incoming links.
     *
     * @param view the view
     * @return the variable usage_3049 incoming links
     * @generated
     */
    public static List getVariableUsage_3049IncomingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the variable characterisation_3035 incoming links.
     *
     * @param view the view
     * @return the variable characterisation_3035 incoming links
     * @generated
     */
    public static List getVariableCharacterisation_3035IncomingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the variable usage_3047 incoming links.
     *
     * @param view the view
     * @return the variable usage_3047 incoming links
     * @generated
     */
    public static List getVariableUsage_3047IncomingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the resource demanding behaviour_3003 incoming links.
     *
     * @param view the view
     * @return the resource demanding behaviour_3003 incoming links
     * @generated
     */
    public static List getResourceDemandingBehaviour_3003IncomingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the start action_3004 incoming links.
     *
     * @param view the view
     * @return the start action_3004 incoming links
     * @generated
     */
    public static List getStartAction_3004IncomingLinks(View view) {
        StartAction modelElement = (StartAction) view.getElement();
        Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
        List result = new LinkedList();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * Gets the stop action_3005 incoming links.
     *
     * @param view the view
     * @return the stop action_3005 incoming links
     * @generated
     */
    public static List getStopAction_3005IncomingLinks(View view) {
        StopAction modelElement = (StopAction) view.getElement();
        Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
        List result = new LinkedList();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * Gets the loop action_3006 incoming links.
     *
     * @param view the view
     * @return the loop action_3006 incoming links
     * @generated
     */
    public static List getLoopAction_3006IncomingLinks(View view) {
        LoopAction modelElement = (LoopAction) view.getElement();
        Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
        List result = new LinkedList();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * Gets the internal action_3007 incoming links.
     *
     * @param view the view
     * @return the internal action_3007 incoming links
     * @generated
     */
    public static List getInternalAction_3007IncomingLinks(View view) {
        InternalAction modelElement = (InternalAction) view.getElement();
        Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
        List result = new LinkedList();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * Gets the parametric resource demand_3051 incoming links.
     *
     * @param view the view
     * @return the parametric resource demand_3051 incoming links
     * @generated
     */
    public static List getParametricResourceDemand_3051IncomingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the internal failure occurrence description_3050 incoming links.
     *
     * @param view the view
     * @return the internal failure occurrence description_3050 incoming links
     * @generated
     */
    public static List getInternalFailureOccurrenceDescription_3050IncomingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the infrastructure call_3053 incoming links.
     *
     * @param view the view
     * @return the infrastructure call_3053 incoming links
     * @generated
     */
    public static List getInfrastructureCall_3053IncomingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the variable usage_3054 incoming links.
     *
     * @param view the view
     * @return the variable usage_3054 incoming links
     * @generated
     */
    public static List getVariableUsage_3054IncomingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the branch action_3009 incoming links.
     *
     * @param view the view
     * @return the branch action_3009 incoming links
     * @generated
     */
    public static List getBranchAction_3009IncomingLinks(View view) {
        BranchAction modelElement = (BranchAction) view.getElement();
        Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
        List result = new LinkedList();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * Gets the probabilistic branch transition_3010 incoming links.
     *
     * @param view the view
     * @return the probabilistic branch transition_3010 incoming links
     * @generated
     */
    public static List getProbabilisticBranchTransition_3010IncomingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the resource demanding behaviour_3011 incoming links.
     *
     * @param view the view
     * @return the resource demanding behaviour_3011 incoming links
     * @generated
     */
    public static List getResourceDemandingBehaviour_3011IncomingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the external call action_3012 incoming links.
     *
     * @param view the view
     * @return the external call action_3012 incoming links
     * @generated
     */
    public static List getExternalCallAction_3012IncomingLinks(View view) {
        ExternalCallAction modelElement = (ExternalCallAction) view.getElement();
        Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
        List result = new LinkedList();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * Gets the emit event action_3046 incoming links.
     *
     * @param view the view
     * @return the emit event action_3046 incoming links
     * @generated
     */
    public static List getEmitEventAction_3046IncomingLinks(View view) {
        EmitEventAction modelElement = (EmitEventAction) view.getElement();
        Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
        List result = new LinkedList();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * Gets the acquire action_3026 incoming links.
     *
     * @param view the view
     * @return the acquire action_3026 incoming links
     * @generated
     */
    public static List getAcquireAction_3026IncomingLinks(View view) {
        AcquireAction modelElement = (AcquireAction) view.getElement();
        Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
        List result = new LinkedList();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * Gets the release action_3020 incoming links.
     *
     * @param view the view
     * @return the release action_3020 incoming links
     * @generated
     */
    public static List getReleaseAction_3020IncomingLinks(View view) {
        ReleaseAction modelElement = (ReleaseAction) view.getElement();
        Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
        List result = new LinkedList();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * Gets the fork action_3023 incoming links.
     *
     * @param view the view
     * @return the fork action_3023 incoming links
     * @generated
     */
    public static List getForkAction_3023IncomingLinks(View view) {
        ForkAction modelElement = (ForkAction) view.getElement();
        Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
        List result = new LinkedList();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * Gets the forked behaviour_3027 incoming links.
     *
     * @param view the view
     * @return the forked behaviour_3027 incoming links
     * @generated
     */
    public static List getForkedBehaviour_3027IncomingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the collection iterator action_3013 incoming links.
     *
     * @param view the view
     * @return the collection iterator action_3013 incoming links
     * @generated
     */
    public static List getCollectionIteratorAction_3013IncomingLinks(View view) {
        CollectionIteratorAction modelElement = (CollectionIteratorAction) view.getElement();
        Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
        List result = new LinkedList();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * Gets the resource demanding behaviour_3014 incoming links.
     *
     * @param view the view
     * @return the resource demanding behaviour_3014 incoming links
     * @generated
     */
    public static List getResourceDemandingBehaviour_3014IncomingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the recovery action_3057 incoming links.
     *
     * @param view the view
     * @return the recovery action_3057 incoming links
     * @generated
     */
    public static List getRecoveryAction_3057IncomingLinks(View view) {
        de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction modelElement = (de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction) view
                .getElement();
        Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
        List result = new LinkedList();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * Gets the recovery action behaviour_3058 incoming links.
     *
     * @param view the view
     * @return the recovery action behaviour_3058 incoming links
     * @generated
     */
    public static List getRecoveryActionBehaviour_3058IncomingLinks(View view) {
        de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour modelElement = (de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour) view
                .getElement();
        Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
        List result = new LinkedList();
        result.addAll(getIncomingFeatureModelFacetLinks_RecoveryActionBehaviour_FailureHandlingAlternatives__RecoveryActionBehaviour_4004(
                modelElement, crossReferences));
        return result;
    }

    /**
     * Gets the synchronisation point_3038 incoming links.
     *
     * @param view the view
     * @return the synchronisation point_3038 incoming links
     * @generated
     */
    public static List getSynchronisationPoint_3038IncomingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the forked behaviour_3039 incoming links.
     *
     * @param view the view
     * @return the forked behaviour_3039 incoming links
     * @generated
     */
    public static List getForkedBehaviour_3039IncomingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the sets the variable action_3024 incoming links.
     *
     * @param view the view
     * @return the sets the variable action_3024 incoming links
     * @generated
     */
    public static List getSetVariableAction_3024IncomingLinks(View view) {
        SetVariableAction modelElement = (SetVariableAction) view.getElement();
        Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet().getResources());
        List result = new LinkedList();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * Gets the variable usage_3036 incoming links.
     *
     * @param view the view
     * @return the variable usage_3036 incoming links
     * @generated
     */
    public static List getVariableUsage_3036IncomingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the variable characterisation_3055 incoming links.
     *
     * @param view the view
     * @return the variable characterisation_3055 incoming links
     * @generated
     */
    public static List getVariableCharacterisation_3055IncomingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the variable characterisation_3048 incoming links.
     *
     * @param view the view
     * @return the variable characterisation_3048 incoming links
     * @generated
     */
    public static List getVariableCharacterisation_3048IncomingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the variable characterisation_3037 incoming links.
     *
     * @param view the view
     * @return the variable characterisation_3037 incoming links
     * @generated
     */
    public static List getVariableCharacterisation_3037IncomingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the guarded branch transition_3017 incoming links.
     *
     * @param view the view
     * @return the guarded branch transition_3017 incoming links
     * @generated
     */
    public static List getGuardedBranchTransition_3017IncomingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the resource demanding behaviour_3018 incoming links.
     *
     * @param view the view
     * @return the resource demanding behaviour_3018 incoming links
     * @generated
     */
    public static List getResourceDemandingBehaviour_3018IncomingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the start action_2001 outgoing links.
     *
     * @param view the view
     * @return the start action_2001 outgoing links
     * @generated
     */
    public static List getStartAction_2001OutgoingLinks(View view) {
        StartAction modelElement = (StartAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the stop action_2002 outgoing links.
     *
     * @param view the view
     * @return the stop action_2002 outgoing links
     * @generated
     */
    public static List getStopAction_2002OutgoingLinks(View view) {
        StopAction modelElement = (StopAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the external call action_2003 outgoing links.
     *
     * @param view the view
     * @return the external call action_2003 outgoing links
     * @generated
     */
    public static List getExternalCallAction_2003OutgoingLinks(View view) {
        ExternalCallAction modelElement = (ExternalCallAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the emit event action_2013 outgoing links.
     *
     * @param view the view
     * @return the emit event action_2013 outgoing links
     * @generated
     */
    public static List getEmitEventAction_2013OutgoingLinks(View view) {
        EmitEventAction modelElement = (EmitEventAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the loop action_2004 outgoing links.
     *
     * @param view the view
     * @return the loop action_2004 outgoing links
     * @generated
     */
    public static List getLoopAction_2004OutgoingLinks(View view) {
        LoopAction modelElement = (LoopAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the branch action_2005 outgoing links.
     *
     * @param view the view
     * @return the branch action_2005 outgoing links
     * @generated
     */
    public static List getBranchAction_2005OutgoingLinks(View view) {
        BranchAction modelElement = (BranchAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the internal action_2006 outgoing links.
     *
     * @param view the view
     * @return the internal action_2006 outgoing links
     * @generated
     */
    public static List getInternalAction_2006OutgoingLinks(View view) {
        InternalAction modelElement = (InternalAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the collection iterator action_2007 outgoing links.
     *
     * @param view the view
     * @return the collection iterator action_2007 outgoing links
     * @generated
     */
    public static List getCollectionIteratorAction_2007OutgoingLinks(View view) {
        CollectionIteratorAction modelElement = (CollectionIteratorAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the sets the variable action_2008 outgoing links.
     *
     * @param view the view
     * @return the sets the variable action_2008 outgoing links
     * @generated
     */
    public static List getSetVariableAction_2008OutgoingLinks(View view) {
        SetVariableAction modelElement = (SetVariableAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the acquire action_2012 outgoing links.
     *
     * @param view the view
     * @return the acquire action_2012 outgoing links
     * @generated
     */
    public static List getAcquireAction_2012OutgoingLinks(View view) {
        AcquireAction modelElement = (AcquireAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the release action_2010 outgoing links.
     *
     * @param view the view
     * @return the release action_2010 outgoing links
     * @generated
     */
    public static List getReleaseAction_2010OutgoingLinks(View view) {
        ReleaseAction modelElement = (ReleaseAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the fork action_2011 outgoing links.
     *
     * @param view the view
     * @return the fork action_2011 outgoing links
     * @generated
     */
    public static List getForkAction_2011OutgoingLinks(View view) {
        ForkAction modelElement = (ForkAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the recovery action_2016 outgoing links.
     *
     * @param view the view
     * @return the recovery action_2016 outgoing links
     * @generated
     */
    public static List getRecoveryAction_2016OutgoingLinks(View view) {
        de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction modelElement = (de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction) view
                .getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the variable usage_3042 outgoing links.
     *
     * @param view the view
     * @return the variable usage_3042 outgoing links
     * @generated
     */
    public static List getVariableUsage_3042OutgoingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the variable characterisation_3033 outgoing links.
     *
     * @param view the view
     * @return the variable characterisation_3033 outgoing links
     * @generated
     */
    public static List getVariableCharacterisation_3033OutgoingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the variable usage_3049 outgoing links.
     *
     * @param view the view
     * @return the variable usage_3049 outgoing links
     * @generated
     */
    public static List getVariableUsage_3049OutgoingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the variable characterisation_3035 outgoing links.
     *
     * @param view the view
     * @return the variable characterisation_3035 outgoing links
     * @generated
     */
    public static List getVariableCharacterisation_3035OutgoingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the variable usage_3047 outgoing links.
     *
     * @param view the view
     * @return the variable usage_3047 outgoing links
     * @generated
     */
    public static List getVariableUsage_3047OutgoingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the resource demanding behaviour_3003 outgoing links.
     *
     * @param view the view
     * @return the resource demanding behaviour_3003 outgoing links
     * @generated
     */
    public static List getResourceDemandingBehaviour_3003OutgoingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the start action_3004 outgoing links.
     *
     * @param view the view
     * @return the start action_3004 outgoing links
     * @generated
     */
    public static List getStartAction_3004OutgoingLinks(View view) {
        StartAction modelElement = (StartAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the stop action_3005 outgoing links.
     *
     * @param view the view
     * @return the stop action_3005 outgoing links
     * @generated
     */
    public static List getStopAction_3005OutgoingLinks(View view) {
        StopAction modelElement = (StopAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the loop action_3006 outgoing links.
     *
     * @param view the view
     * @return the loop action_3006 outgoing links
     * @generated
     */
    public static List getLoopAction_3006OutgoingLinks(View view) {
        LoopAction modelElement = (LoopAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the internal action_3007 outgoing links.
     *
     * @param view the view
     * @return the internal action_3007 outgoing links
     * @generated
     */
    public static List getInternalAction_3007OutgoingLinks(View view) {
        InternalAction modelElement = (InternalAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the parametric resource demand_3051 outgoing links.
     *
     * @param view the view
     * @return the parametric resource demand_3051 outgoing links
     * @generated
     */
    public static List getParametricResourceDemand_3051OutgoingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the internal failure occurrence description_3050 outgoing links.
     *
     * @param view the view
     * @return the internal failure occurrence description_3050 outgoing links
     * @generated
     */
    public static List getInternalFailureOccurrenceDescription_3050OutgoingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the infrastructure call_3053 outgoing links.
     *
     * @param view the view
     * @return the infrastructure call_3053 outgoing links
     * @generated
     */
    public static List getInfrastructureCall_3053OutgoingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the variable usage_3054 outgoing links.
     *
     * @param view the view
     * @return the variable usage_3054 outgoing links
     * @generated
     */
    public static List getVariableUsage_3054OutgoingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the branch action_3009 outgoing links.
     *
     * @param view the view
     * @return the branch action_3009 outgoing links
     * @generated
     */
    public static List getBranchAction_3009OutgoingLinks(View view) {
        BranchAction modelElement = (BranchAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the probabilistic branch transition_3010 outgoing links.
     *
     * @param view the view
     * @return the probabilistic branch transition_3010 outgoing links
     * @generated
     */
    public static List getProbabilisticBranchTransition_3010OutgoingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the resource demanding behaviour_3011 outgoing links.
     *
     * @param view the view
     * @return the resource demanding behaviour_3011 outgoing links
     * @generated
     */
    public static List getResourceDemandingBehaviour_3011OutgoingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the external call action_3012 outgoing links.
     *
     * @param view the view
     * @return the external call action_3012 outgoing links
     * @generated
     */
    public static List getExternalCallAction_3012OutgoingLinks(View view) {
        ExternalCallAction modelElement = (ExternalCallAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the emit event action_3046 outgoing links.
     *
     * @param view the view
     * @return the emit event action_3046 outgoing links
     * @generated
     */
    public static List getEmitEventAction_3046OutgoingLinks(View view) {
        EmitEventAction modelElement = (EmitEventAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the acquire action_3026 outgoing links.
     *
     * @param view the view
     * @return the acquire action_3026 outgoing links
     * @generated
     */
    public static List getAcquireAction_3026OutgoingLinks(View view) {
        AcquireAction modelElement = (AcquireAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the release action_3020 outgoing links.
     *
     * @param view the view
     * @return the release action_3020 outgoing links
     * @generated
     */
    public static List getReleaseAction_3020OutgoingLinks(View view) {
        ReleaseAction modelElement = (ReleaseAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the fork action_3023 outgoing links.
     *
     * @param view the view
     * @return the fork action_3023 outgoing links
     * @generated
     */
    public static List getForkAction_3023OutgoingLinks(View view) {
        ForkAction modelElement = (ForkAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the forked behaviour_3027 outgoing links.
     *
     * @param view the view
     * @return the forked behaviour_3027 outgoing links
     * @generated
     */
    public static List getForkedBehaviour_3027OutgoingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the collection iterator action_3013 outgoing links.
     *
     * @param view the view
     * @return the collection iterator action_3013 outgoing links
     * @generated
     */
    public static List getCollectionIteratorAction_3013OutgoingLinks(View view) {
        CollectionIteratorAction modelElement = (CollectionIteratorAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the resource demanding behaviour_3014 outgoing links.
     *
     * @param view the view
     * @return the resource demanding behaviour_3014 outgoing links
     * @generated
     */
    public static List getResourceDemandingBehaviour_3014OutgoingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the recovery action_3057 outgoing links.
     *
     * @param view the view
     * @return the recovery action_3057 outgoing links
     * @generated
     */
    public static List getRecoveryAction_3057OutgoingLinks(View view) {
        de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction modelElement = (de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction) view
                .getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the recovery action behaviour_3058 outgoing links.
     *
     * @param view the view
     * @return the recovery action behaviour_3058 outgoing links
     * @generated
     */
    public static List getRecoveryActionBehaviour_3058OutgoingLinks(View view) {
        de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour modelElement = (de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour) view
                .getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_RecoveryActionBehaviour_FailureHandlingAlternatives__RecoveryActionBehaviour_4004(modelElement));
        return result;
    }

    /**
     * Gets the synchronisation point_3038 outgoing links.
     *
     * @param view the view
     * @return the synchronisation point_3038 outgoing links
     * @generated
     */
    public static List getSynchronisationPoint_3038OutgoingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the forked behaviour_3039 outgoing links.
     *
     * @param view the view
     * @return the forked behaviour_3039 outgoing links
     * @generated
     */
    public static List getForkedBehaviour_3039OutgoingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the sets the variable action_3024 outgoing links.
     *
     * @param view the view
     * @return the sets the variable action_3024 outgoing links
     * @generated
     */
    public static List getSetVariableAction_3024OutgoingLinks(View view) {
        SetVariableAction modelElement = (SetVariableAction) view.getElement();
        List result = new LinkedList();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * Gets the variable usage_3036 outgoing links.
     *
     * @param view the view
     * @return the variable usage_3036 outgoing links
     * @generated
     */
    public static List getVariableUsage_3036OutgoingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the variable characterisation_3055 outgoing links.
     *
     * @param view the view
     * @return the variable characterisation_3055 outgoing links
     * @generated
     */
    public static List getVariableCharacterisation_3055OutgoingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the variable characterisation_3048 outgoing links.
     *
     * @param view the view
     * @return the variable characterisation_3048 outgoing links
     * @generated
     */
    public static List getVariableCharacterisation_3048OutgoingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the variable characterisation_3037 outgoing links.
     *
     * @param view the view
     * @return the variable characterisation_3037 outgoing links
     * @generated
     */
    public static List getVariableCharacterisation_3037OutgoingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the guarded branch transition_3017 outgoing links.
     *
     * @param view the view
     * @return the guarded branch transition_3017 outgoing links
     * @generated
     */
    public static List getGuardedBranchTransition_3017OutgoingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the resource demanding behaviour_3018 outgoing links.
     *
     * @param view the view
     * @return the resource demanding behaviour_3018 outgoing links
     * @generated
     */
    public static List getResourceDemandingBehaviour_3018OutgoingLinks(View view) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Gets the incoming feature model facet links_ abstract action_ successor_ abstract action_4001.
     *
     * @param target the target
     * @param crossReferences the cross references
     * @return the incoming feature model facet links_ abstract action_ successor_ abstract action_4001
     * @generated
     */
    private static Collection getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(
            AbstractAction target, Map crossReferences) {
        Collection result = new LinkedList();
        Collection settings = (Collection) crossReferences.get(target);
        for (Iterator it = settings.iterator(); it.hasNext();) {
            EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
            if (setting.getEStructuralFeature() == SeffPackage.eINSTANCE.getAbstractAction_Successor_AbstractAction()) {
                result.add(new PalladioComponentModelLinkDescriptor(setting.getEObject(), target,
                        PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001,
                        AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            }
        }
        return result;
    }

    /**
     * Gets the incoming feature model facet links_ recovery action behaviour_ failure handling alternatives__ recovery action behaviour_4004.
     *
     * @param target the target
     * @param crossReferences the cross references
     * @return the incoming feature model facet links_ recovery action behaviour_ failure handling alternatives__ recovery action behaviour_4004
     * @generated
     */
    private static Collection getIncomingFeatureModelFacetLinks_RecoveryActionBehaviour_FailureHandlingAlternatives__RecoveryActionBehaviour_4004(
            de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour target, Map crossReferences) {
        Collection result = new LinkedList();
        Collection settings = (Collection) crossReferences.get(target);
        for (Iterator it = settings.iterator(); it.hasNext();) {
            EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
            if (setting.getEStructuralFeature() == de.uka.ipd.sdq.pcm.seff.seff_reliability.SeffReliabilityPackage.eINSTANCE
                    .getRecoveryActionBehaviour_FailureHandlingAlternatives__RecoveryActionBehaviour()) {
                result.add(new PalladioComponentModelLinkDescriptor(
                        setting.getEObject(),
                        target,
                        PalladioComponentModelElementTypes.RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviour_4004,
                        RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviourEditPart.VISUAL_ID));
            }
        }
        return result;
    }

    /**
     * Gets the outgoing feature model facet links_ abstract action_ successor_ abstract action_4001.
     *
     * @param source the source
     * @return the outgoing feature model facet links_ abstract action_ successor_ abstract action_4001
     * @generated
     */
    private static Collection getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(
            AbstractAction source) {
        Collection result = new LinkedList();
        AbstractAction destination = source.getSuccessor_AbstractAction();
        if (destination == null) {
            return result;
        }
        result.add(new PalladioComponentModelLinkDescriptor(source, destination,
                PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001,
                AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
        return result;
    }

    /**
     * Gets the outgoing feature model facet links_ recovery action behaviour_ failure handling alternatives__ recovery action behaviour_4004.
     *
     * @param source the source
     * @return the outgoing feature model facet links_ recovery action behaviour_ failure handling alternatives__ recovery action behaviour_4004
     * @generated
     */
    private static Collection getOutgoingFeatureModelFacetLinks_RecoveryActionBehaviour_FailureHandlingAlternatives__RecoveryActionBehaviour_4004(
            de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour source) {
        Collection result = new LinkedList();
        for (Iterator destinations = source.getFailureHandlingAlternatives__RecoveryActionBehaviour().iterator(); destinations
                .hasNext();) {
            de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour destination = (de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour) destinations
                    .next();
            result.add(new PalladioComponentModelLinkDescriptor(
                    source,
                    destination,
                    PalladioComponentModelElementTypes.RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviour_4004,
                    RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviourEditPart.VISUAL_ID));
        }
        return result;
    }

}
