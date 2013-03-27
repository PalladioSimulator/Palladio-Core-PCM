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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;
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
 * @generated
 */
public class PalladioComponentModelDiagramUpdater {

    /**
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getSemanticChildren(View view) {
        switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
        case ResourceDemandingSEFFEditPart.VISUAL_ID:
            return getResourceDemandingSEFF_1000SemanticChildren(view);
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
            return getInfrastructureCallInfrastructureCallInputVariableUsages_7057SemanticChildren(view);
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
            return getRecoveryActionRecoveryBlockCompartment_7058SemanticChildren(view);
        case RecoveryActionBehaviourAlternativeBehaviourCompartmentEditPart.VISUAL_ID:
            return getRecoveryActionBehaviourAlternativeBehaviourCompartment_7059SemanticChildren(view);
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
            return getRecoveryActionRecoveryBlockCompartment_7060SemanticChildren(view);
        }
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getLoopAction_2004SemanticChildren(View view) {
        if (!view.isSetElement()) {
            return Collections.emptyList();
        }
        LoopAction modelElement = (LoopAction) view.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getCollectionIteratorAction_2007SemanticChildren(View view) {
        if (!view.isSetElement()) {
            return Collections.emptyList();
        }
        CollectionIteratorAction modelElement = (CollectionIteratorAction) view.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getLoopAction_3006SemanticChildren(View view) {
        if (!view.isSetElement()) {
            return Collections.emptyList();
        }
        LoopAction modelElement = (LoopAction) view.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getProbabilisticBranchTransition_3010SemanticChildren(
            View view) {
        if (!view.isSetElement()) {
            return Collections.emptyList();
        }
        ProbabilisticBranchTransition modelElement = (ProbabilisticBranchTransition) view.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getCollectionIteratorAction_3013SemanticChildren(View view) {
        if (!view.isSetElement()) {
            return Collections.emptyList();
        }
        CollectionIteratorAction modelElement = (CollectionIteratorAction) view.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getGuardedBranchTransition_3017SemanticChildren(View view) {
        if (!view.isSetElement()) {
            return Collections.emptyList();
        }
        GuardedBranchTransition modelElement = (GuardedBranchTransition) view.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getExternalCallActionInputVariableUsage_7001SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        ExternalCallAction modelElement = (ExternalCallAction) containerView.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getInputVariableUsages__CallAction().iterator(); it.hasNext();) {
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getExternalCallActionOutputVariableUsage_7021SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        ExternalCallAction modelElement = (ExternalCallAction) containerView.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getReturnVariableUsage__CallReturnAction().iterator(); it.hasNext();) {
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getVariableUsageVariableCharacterisation_7037SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        VariableUsage modelElement = (VariableUsage) containerView.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getVariableCharacterisation_VariableUsage().iterator(); it.hasNext();) {
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getVariableUsageVariableCharacterisation_7044SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        VariableUsage modelElement = (VariableUsage) containerView.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getVariableCharacterisation_VariableUsage().iterator(); it.hasNext();) {
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getEmitEventActionInputVariableUsageEvent_7042SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        EmitEventAction modelElement = (EmitEventAction) containerView.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getInputVariableUsages__CallAction().iterator(); it.hasNext();) {
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getVariableUsageVariableCharacterisation_7043SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        VariableUsage modelElement = (VariableUsage) containerView.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getVariableCharacterisation_VariableUsage().iterator(); it.hasNext();) {
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getResourceDemandingBehaviourBehaviourCompartment_7004SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        ResourceDemandingBehaviour modelElement = (ResourceDemandingBehaviour) containerView.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getSteps_Behaviour().iterator(); it.hasNext();) {
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getInternalActionResourceDemands_7006SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        InternalAction modelElement = (InternalAction) containerView.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getResourceDemand_Action().iterator(); it.hasNext();) {
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getInternalActionFailureOccurrenceDescriptions_7045SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        InternalAction modelElement = (InternalAction) containerView.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getInternalFailureOccurrenceDescriptions__InternalAction().iterator(); it
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getInternalActionInfrastructureCallsCompartment_7048SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        InternalAction modelElement = (InternalAction) containerView.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getInfrastructureCall__Action().iterator(); it.hasNext();) {
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getInfrastructureCallInfrastructureCallInputVariableUsages_7057SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        de.uka.ipd.sdq.pcm.seff.seff_performance.InfrastructureCall modelElement = (de.uka.ipd.sdq.pcm.seff.seff_performance.InfrastructureCall) containerView
                .getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getInputVariableUsages__CallAction().iterator(); it.hasNext();) {
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getVariableUsageVariableCharacterisation_7050SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        VariableUsage modelElement = (VariableUsage) containerView.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getVariableCharacterisation_VariableUsage().iterator(); it.hasNext();) {
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getBranchActionBranchTransitionCompartment_7007SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        BranchAction modelElement = (BranchAction) containerView.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getBranches_Branch().iterator(); it.hasNext();) {
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getResourceDemandingBehaviourBehaviourCompartment_7009SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        ResourceDemandingBehaviour modelElement = (ResourceDemandingBehaviour) containerView.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getSteps_Behaviour().iterator(); it.hasNext();) {
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getExternalCallActionInputVariableUsage_7010SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        ExternalCallAction modelElement = (ExternalCallAction) containerView.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getInputVariableUsages__CallAction().iterator(); it.hasNext();) {
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getExternalCallActionOutputVariableUsage_7023SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        ExternalCallAction modelElement = (ExternalCallAction) containerView.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getReturnVariableUsage__CallReturnAction().iterator(); it.hasNext();) {
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getEmitEventActionInputVariableUsageEvent_7041SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        EmitEventAction modelElement = (EmitEventAction) containerView.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getInputVariableUsages__CallAction().iterator(); it.hasNext();) {
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getForkActionForkedBehaviours_7024SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        ForkAction modelElement = (ForkAction) containerView.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getAsynchronousForkedBehaviours_ForkAction().iterator(); it.hasNext();) {
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getForkedBehaviourBehaviourCompartment_7026SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        ForkedBehaviour modelElement = (ForkedBehaviour) containerView.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getSteps_Behaviour().iterator(); it.hasNext();) {
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getResourceDemandingBehaviourBehaviourCompartment_7014SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        ResourceDemandingBehaviour modelElement = (ResourceDemandingBehaviour) containerView.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getSteps_Behaviour().iterator(); it.hasNext();) {
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getRecoveryActionRecoveryBlockCompartment_7058SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction modelElement = (de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction) containerView
                .getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getRecoveryActionBehaviours__RecoveryAction().iterator(); it.hasNext();) {
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getRecoveryActionBehaviourAlternativeBehaviourCompartment_7059SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour modelElement = (de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour) containerView
                .getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getSteps_Behaviour().iterator(); it.hasNext();) {
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getSynchronisationPointSynchronisationPoint_7034SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        SynchronisationPoint modelElement = (SynchronisationPoint) containerView.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getSynchronousForkedBehaviours_SynchronisationPoint().iterator(); it
                .hasNext();) {
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getForkedBehaviourBehaviourCompartment_7033SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        ForkedBehaviour modelElement = (ForkedBehaviour) containerView.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getSteps_Behaviour().iterator(); it.hasNext();) {
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getSetVariableActionVariableSetter_7025SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        SetVariableAction modelElement = (SetVariableAction) containerView.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getLocalVariableUsages_SetVariableAction().iterator(); it.hasNext();) {
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getVariableUsageVariableCharacterisation_7032SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        VariableUsage modelElement = (VariableUsage) containerView.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getVariableCharacterisation_VariableUsage().iterator(); it.hasNext();) {
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getResourceDemandingBehaviourBehaviourCompartment_7018SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        ResourceDemandingBehaviour modelElement = (ResourceDemandingBehaviour) containerView.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getSteps_Behaviour().iterator(); it.hasNext();) {
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getBranchActionBranchTransitionCompartment_7011SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        BranchAction modelElement = (BranchAction) containerView.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getBranches_Branch().iterator(); it.hasNext();) {
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getInternalActionResourceDemands_7012SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        InternalAction modelElement = (InternalAction) containerView.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getResourceDemand_Action().iterator(); it.hasNext();) {
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getInternalActionFailureOccurrenceDescriptions_7046SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        InternalAction modelElement = (InternalAction) containerView.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getInternalFailureOccurrenceDescriptions__InternalAction().iterator(); it
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getInternalActionInfrastructureCallsCompartment_7051SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        InternalAction modelElement = (InternalAction) containerView.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getInfrastructureCall__Action().iterator(); it.hasNext();) {
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getSetVariableActionVariableSetter_7016SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        SetVariableAction modelElement = (SetVariableAction) containerView.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getLocalVariableUsages_SetVariableAction().iterator(); it.hasNext();) {
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getForkActionForkedBehaviours_7019SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        ForkAction modelElement = (ForkAction) containerView.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getAsynchronousForkedBehaviours_ForkAction().iterator(); it.hasNext();) {
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getRecoveryActionRecoveryBlockCompartment_7060SemanticChildren(
            View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction modelElement = (de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction) containerView
                .getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getRecoveryActionBehaviours__RecoveryAction().iterator(); it.hasNext();) {
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
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getResourceDemandingSEFF_1000SemanticChildren(View view) {
        if (!view.isSetElement()) {
            return Collections.emptyList();
        }
        ResourceDemandingSEFF modelElement = (ResourceDemandingSEFF) view.getElement();
        LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (Iterator<?> it = modelElement.getSteps_Behaviour().iterator(); it.hasNext();) {
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
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getContainedLinks(View view) {
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
            return getRecoveryAction_2017ContainedLinks(view);
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
            return getRecoveryAction_3061ContainedLinks(view);
        case RecoveryActionBehaviourEditPart.VISUAL_ID:
            return getRecoveryActionBehaviour_3062ContainedLinks(view);
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
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getIncomingLinks(View view) {
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
            return getRecoveryAction_2017IncomingLinks(view);
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
            return getRecoveryAction_3061IncomingLinks(view);
        case RecoveryActionBehaviourEditPart.VISUAL_ID:
            return getRecoveryActionBehaviour_3062IncomingLinks(view);
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
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getOutgoingLinks(View view) {
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
            return getRecoveryAction_2017OutgoingLinks(view);
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
            return getRecoveryAction_3061OutgoingLinks(view);
        case RecoveryActionBehaviourEditPart.VISUAL_ID:
            return getRecoveryActionBehaviour_3062OutgoingLinks(view);
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
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getResourceDemandingSEFF_1000ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getStartAction_2001ContainedLinks(View view) {
        StartAction modelElement = (StartAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getStopAction_2002ContainedLinks(View view) {
        StopAction modelElement = (StopAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getExternalCallAction_2003ContainedLinks(View view) {
        ExternalCallAction modelElement = (ExternalCallAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getEmitEventAction_2013ContainedLinks(View view) {
        EmitEventAction modelElement = (EmitEventAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getLoopAction_2004ContainedLinks(View view) {
        LoopAction modelElement = (LoopAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getBranchAction_2005ContainedLinks(View view) {
        BranchAction modelElement = (BranchAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInternalAction_2006ContainedLinks(View view) {
        InternalAction modelElement = (InternalAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getCollectionIteratorAction_2007ContainedLinks(View view) {
        CollectionIteratorAction modelElement = (CollectionIteratorAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getSetVariableAction_2008ContainedLinks(View view) {
        SetVariableAction modelElement = (SetVariableAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getAcquireAction_2012ContainedLinks(View view) {
        AcquireAction modelElement = (AcquireAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getReleaseAction_2010ContainedLinks(View view) {
        ReleaseAction modelElement = (ReleaseAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getForkAction_2011ContainedLinks(View view) {
        ForkAction modelElement = (ForkAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getRecoveryAction_2017ContainedLinks(View view) {
        de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction modelElement = (de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction) view
                .getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableUsage_3042ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableCharacterisation_3033ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableUsage_3049ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableCharacterisation_3035ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableUsage_3047ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getResourceDemandingBehaviour_3003ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getStartAction_3004ContainedLinks(View view) {
        StartAction modelElement = (StartAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getStopAction_3005ContainedLinks(View view) {
        StopAction modelElement = (StopAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getLoopAction_3006ContainedLinks(View view) {
        LoopAction modelElement = (LoopAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInternalAction_3007ContainedLinks(View view) {
        InternalAction modelElement = (InternalAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getParametricResourceDemand_3051ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInternalFailureOccurrenceDescription_3050ContainedLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInfrastructureCall_3053ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableUsage_3054ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getBranchAction_3009ContainedLinks(View view) {
        BranchAction modelElement = (BranchAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getProbabilisticBranchTransition_3010ContainedLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getResourceDemandingBehaviour_3011ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getExternalCallAction_3012ContainedLinks(View view) {
        ExternalCallAction modelElement = (ExternalCallAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getEmitEventAction_3046ContainedLinks(View view) {
        EmitEventAction modelElement = (EmitEventAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getAcquireAction_3026ContainedLinks(View view) {
        AcquireAction modelElement = (AcquireAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getReleaseAction_3020ContainedLinks(View view) {
        ReleaseAction modelElement = (ReleaseAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getForkAction_3023ContainedLinks(View view) {
        ForkAction modelElement = (ForkAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getForkedBehaviour_3027ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getCollectionIteratorAction_3013ContainedLinks(View view) {
        CollectionIteratorAction modelElement = (CollectionIteratorAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getResourceDemandingBehaviour_3014ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getRecoveryAction_3061ContainedLinks(View view) {
        de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction modelElement = (de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction) view
                .getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getRecoveryActionBehaviour_3062ContainedLinks(View view) {
        de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour modelElement = (de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour) view
                .getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_RecoveryActionBehaviour_FailureHandlingAlternatives__RecoveryActionBehaviour_4004(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getSynchronisationPoint_3038ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getForkedBehaviour_3039ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getSetVariableAction_3024ContainedLinks(View view) {
        SetVariableAction modelElement = (SetVariableAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableUsage_3036ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableCharacterisation_3055ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableCharacterisation_3048ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableCharacterisation_3037ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getGuardedBranchTransition_3017ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getResourceDemandingBehaviour_3018ContainedLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getStartAction_2001IncomingLinks(View view) {
        StartAction modelElement = (StartAction) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
                .eResource().getResourceSet().getResources());
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getStopAction_2002IncomingLinks(View view) {
        StopAction modelElement = (StopAction) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
                .eResource().getResourceSet().getResources());
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getExternalCallAction_2003IncomingLinks(View view) {
        ExternalCallAction modelElement = (ExternalCallAction) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
                .eResource().getResourceSet().getResources());
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getEmitEventAction_2013IncomingLinks(View view) {
        EmitEventAction modelElement = (EmitEventAction) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
                .eResource().getResourceSet().getResources());
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getLoopAction_2004IncomingLinks(View view) {
        LoopAction modelElement = (LoopAction) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
                .eResource().getResourceSet().getResources());
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getBranchAction_2005IncomingLinks(View view) {
        BranchAction modelElement = (BranchAction) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
                .eResource().getResourceSet().getResources());
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInternalAction_2006IncomingLinks(View view) {
        InternalAction modelElement = (InternalAction) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
                .eResource().getResourceSet().getResources());
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getCollectionIteratorAction_2007IncomingLinks(View view) {
        CollectionIteratorAction modelElement = (CollectionIteratorAction) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
                .eResource().getResourceSet().getResources());
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getSetVariableAction_2008IncomingLinks(View view) {
        SetVariableAction modelElement = (SetVariableAction) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
                .eResource().getResourceSet().getResources());
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getAcquireAction_2012IncomingLinks(View view) {
        AcquireAction modelElement = (AcquireAction) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
                .eResource().getResourceSet().getResources());
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getReleaseAction_2010IncomingLinks(View view) {
        ReleaseAction modelElement = (ReleaseAction) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
                .eResource().getResourceSet().getResources());
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getForkAction_2011IncomingLinks(View view) {
        ForkAction modelElement = (ForkAction) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
                .eResource().getResourceSet().getResources());
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getRecoveryAction_2017IncomingLinks(View view) {
        de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction modelElement = (de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction) view
                .getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
                .eResource().getResourceSet().getResources());
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableUsage_3042IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableCharacterisation_3033IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableUsage_3049IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableCharacterisation_3035IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableUsage_3047IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getResourceDemandingBehaviour_3003IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getStartAction_3004IncomingLinks(View view) {
        StartAction modelElement = (StartAction) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
                .eResource().getResourceSet().getResources());
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getStopAction_3005IncomingLinks(View view) {
        StopAction modelElement = (StopAction) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
                .eResource().getResourceSet().getResources());
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getLoopAction_3006IncomingLinks(View view) {
        LoopAction modelElement = (LoopAction) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
                .eResource().getResourceSet().getResources());
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInternalAction_3007IncomingLinks(View view) {
        InternalAction modelElement = (InternalAction) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
                .eResource().getResourceSet().getResources());
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getParametricResourceDemand_3051IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInternalFailureOccurrenceDescription_3050IncomingLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInfrastructureCall_3053IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableUsage_3054IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getBranchAction_3009IncomingLinks(View view) {
        BranchAction modelElement = (BranchAction) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
                .eResource().getResourceSet().getResources());
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getProbabilisticBranchTransition_3010IncomingLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getResourceDemandingBehaviour_3011IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getExternalCallAction_3012IncomingLinks(View view) {
        ExternalCallAction modelElement = (ExternalCallAction) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
                .eResource().getResourceSet().getResources());
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getEmitEventAction_3046IncomingLinks(View view) {
        EmitEventAction modelElement = (EmitEventAction) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
                .eResource().getResourceSet().getResources());
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getAcquireAction_3026IncomingLinks(View view) {
        AcquireAction modelElement = (AcquireAction) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
                .eResource().getResourceSet().getResources());
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getReleaseAction_3020IncomingLinks(View view) {
        ReleaseAction modelElement = (ReleaseAction) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
                .eResource().getResourceSet().getResources());
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getForkAction_3023IncomingLinks(View view) {
        ForkAction modelElement = (ForkAction) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
                .eResource().getResourceSet().getResources());
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getForkedBehaviour_3027IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getCollectionIteratorAction_3013IncomingLinks(View view) {
        CollectionIteratorAction modelElement = (CollectionIteratorAction) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
                .eResource().getResourceSet().getResources());
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getResourceDemandingBehaviour_3014IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getRecoveryAction_3061IncomingLinks(View view) {
        de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction modelElement = (de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction) view
                .getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
                .eResource().getResourceSet().getResources());
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getRecoveryActionBehaviour_3062IncomingLinks(View view) {
        de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour modelElement = (de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour) view
                .getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
                .eResource().getResourceSet().getResources());
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_RecoveryActionBehaviour_FailureHandlingAlternatives__RecoveryActionBehaviour_4004(
                modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getSynchronisationPoint_3038IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getForkedBehaviour_3039IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getSetVariableAction_3024IncomingLinks(View view) {
        SetVariableAction modelElement = (SetVariableAction) view.getElement();
        Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer.find(view
                .eResource().getResourceSet().getResources());
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableUsage_3036IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableCharacterisation_3055IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableCharacterisation_3048IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableCharacterisation_3037IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getGuardedBranchTransition_3017IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getResourceDemandingBehaviour_3018IncomingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getStartAction_2001OutgoingLinks(View view) {
        StartAction modelElement = (StartAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getStopAction_2002OutgoingLinks(View view) {
        StopAction modelElement = (StopAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getExternalCallAction_2003OutgoingLinks(View view) {
        ExternalCallAction modelElement = (ExternalCallAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getEmitEventAction_2013OutgoingLinks(View view) {
        EmitEventAction modelElement = (EmitEventAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getLoopAction_2004OutgoingLinks(View view) {
        LoopAction modelElement = (LoopAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getBranchAction_2005OutgoingLinks(View view) {
        BranchAction modelElement = (BranchAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInternalAction_2006OutgoingLinks(View view) {
        InternalAction modelElement = (InternalAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getCollectionIteratorAction_2007OutgoingLinks(View view) {
        CollectionIteratorAction modelElement = (CollectionIteratorAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getSetVariableAction_2008OutgoingLinks(View view) {
        SetVariableAction modelElement = (SetVariableAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getAcquireAction_2012OutgoingLinks(View view) {
        AcquireAction modelElement = (AcquireAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getReleaseAction_2010OutgoingLinks(View view) {
        ReleaseAction modelElement = (ReleaseAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getForkAction_2011OutgoingLinks(View view) {
        ForkAction modelElement = (ForkAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getRecoveryAction_2017OutgoingLinks(View view) {
        de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction modelElement = (de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction) view
                .getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableUsage_3042OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableCharacterisation_3033OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableUsage_3049OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableCharacterisation_3035OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableUsage_3047OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getResourceDemandingBehaviour_3003OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getStartAction_3004OutgoingLinks(View view) {
        StartAction modelElement = (StartAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getStopAction_3005OutgoingLinks(View view) {
        StopAction modelElement = (StopAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getLoopAction_3006OutgoingLinks(View view) {
        LoopAction modelElement = (LoopAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInternalAction_3007OutgoingLinks(View view) {
        InternalAction modelElement = (InternalAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getParametricResourceDemand_3051OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInternalFailureOccurrenceDescription_3050OutgoingLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInfrastructureCall_3053OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableUsage_3054OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getBranchAction_3009OutgoingLinks(View view) {
        BranchAction modelElement = (BranchAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getProbabilisticBranchTransition_3010OutgoingLinks(
            View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getResourceDemandingBehaviour_3011OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getExternalCallAction_3012OutgoingLinks(View view) {
        ExternalCallAction modelElement = (ExternalCallAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getEmitEventAction_3046OutgoingLinks(View view) {
        EmitEventAction modelElement = (EmitEventAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getAcquireAction_3026OutgoingLinks(View view) {
        AcquireAction modelElement = (AcquireAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getReleaseAction_3020OutgoingLinks(View view) {
        ReleaseAction modelElement = (ReleaseAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getForkAction_3023OutgoingLinks(View view) {
        ForkAction modelElement = (ForkAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getForkedBehaviour_3027OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getCollectionIteratorAction_3013OutgoingLinks(View view) {
        CollectionIteratorAction modelElement = (CollectionIteratorAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getResourceDemandingBehaviour_3014OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getRecoveryAction_3061OutgoingLinks(View view) {
        de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction modelElement = (de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction) view
                .getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getRecoveryActionBehaviour_3062OutgoingLinks(View view) {
        de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour modelElement = (de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour) view
                .getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_RecoveryActionBehaviour_FailureHandlingAlternatives__RecoveryActionBehaviour_4004(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getSynchronisationPoint_3038OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getForkedBehaviour_3039OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getSetVariableAction_3024OutgoingLinks(View view) {
        SetVariableAction modelElement = (SetVariableAction) view.getElement();
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableUsage_3036OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableCharacterisation_3055OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableCharacterisation_3048OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableCharacterisation_3037OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getGuardedBranchTransition_3017OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getResourceDemandingBehaviour_3018OutgoingLinks(View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(
            AbstractAction target, Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
        for (EStructuralFeature.Setting setting : settings) {
            if (setting.getEStructuralFeature() == SeffPackage.eINSTANCE.getAbstractAction_Successor_AbstractAction()) {
                result.add(new PalladioComponentModelLinkDescriptor(setting.getEObject(), target,
                        PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001,
                        AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID));
            }
        }
        return result;
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getIncomingFeatureModelFacetLinks_RecoveryActionBehaviour_FailureHandlingAlternatives__RecoveryActionBehaviour_4004(
            de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour target,
            Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
        for (EStructuralFeature.Setting setting : settings) {
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
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(
            AbstractAction source) {
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
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
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getOutgoingFeatureModelFacetLinks_RecoveryActionBehaviour_FailureHandlingAlternatives__RecoveryActionBehaviour_4004(
            de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour source) {
        LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        for (Iterator<?> destinations = source.getFailureHandlingAlternatives__RecoveryActionBehaviour().iterator(); destinations
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

    /**
     * @generated
     */
    public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {
        /**
         * @generated
         */
        @Override
        public List<PalladioComponentModelNodeDescriptor> getSemanticChildren(View view) {
            return PalladioComponentModelDiagramUpdater.getSemanticChildren(view);
        }

        /**
         * @generated
         */
        @Override
        public List<PalladioComponentModelLinkDescriptor> getContainedLinks(View view) {
            return PalladioComponentModelDiagramUpdater.getContainedLinks(view);
        }

        /**
         * @generated
         */
        @Override
        public List<PalladioComponentModelLinkDescriptor> getIncomingLinks(View view) {
            return PalladioComponentModelDiagramUpdater.getIncomingLinks(view);
        }

        /**
         * @generated
         */
        @Override
        public List<PalladioComponentModelLinkDescriptor> getOutgoingLinks(View view) {
            return PalladioComponentModelDiagramUpdater.getOutgoingLinks(view);
        }
    };

}
