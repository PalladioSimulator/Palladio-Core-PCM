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
import org.palladiosimulator.pcm.parameter.VariableCharacterisation;
import org.palladiosimulator.pcm.parameter.VariableUsage;
import org.palladiosimulator.pcm.reliability.InternalFailureOccurrenceDescription;
import org.palladiosimulator.pcm.seff.AbstractAction;
import org.palladiosimulator.pcm.seff.AbstractBranchTransition;
import org.palladiosimulator.pcm.seff.AcquireAction;
import org.palladiosimulator.pcm.seff.BranchAction;
import org.palladiosimulator.pcm.seff.CollectionIteratorAction;
import org.palladiosimulator.pcm.seff.EmitEventAction;
import org.palladiosimulator.pcm.seff.ExternalCallAction;
import org.palladiosimulator.pcm.seff.ForkAction;
import org.palladiosimulator.pcm.seff.ForkedBehaviour;
import org.palladiosimulator.pcm.seff.GuardedBranchTransition;
import org.palladiosimulator.pcm.seff.InternalAction;
import org.palladiosimulator.pcm.seff.LoopAction;
import org.palladiosimulator.pcm.seff.ProbabilisticBranchTransition;
import org.palladiosimulator.pcm.seff.ReleaseAction;
import org.palladiosimulator.pcm.seff.ResourceDemandingBehaviour;
import org.palladiosimulator.pcm.seff.ResourceDemandingSEFF;
import org.palladiosimulator.pcm.seff.SeffPackage;
import org.palladiosimulator.pcm.seff.SetVariableAction;
import org.palladiosimulator.pcm.seff.StartAction;
import org.palladiosimulator.pcm.seff.StopAction;
import org.palladiosimulator.pcm.seff.SynchronisationPoint;

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

/**
 * @generated
 */
public class PalladioComponentModelDiagramUpdater {

    /**
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getSemanticChildren(final View view) {
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
    public static List<PalladioComponentModelNodeDescriptor> getLoopAction_2004SemanticChildren(final View view) {
        if (!view.isSetElement()) {
            return Collections.emptyList();
        }
        final LoopAction modelElement = (LoopAction) view.getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        {
            final ResourceDemandingBehaviour childElement = modelElement.getBodyBehaviour_Loop();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == ResourceDemandingBehaviourEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getCollectionIteratorAction_2007SemanticChildren(
            final View view) {
        if (!view.isSetElement()) {
            return Collections.emptyList();
        }
        final CollectionIteratorAction modelElement = (CollectionIteratorAction) view.getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        {
            final ResourceDemandingBehaviour childElement = modelElement.getBodyBehaviour_Loop();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == ResourceDemandingBehaviour3EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getLoopAction_3006SemanticChildren(final View view) {
        if (!view.isSetElement()) {
            return Collections.emptyList();
        }
        final LoopAction modelElement = (LoopAction) view.getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        {
            final ResourceDemandingBehaviour childElement = modelElement.getBodyBehaviour_Loop();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
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
            final View view) {
        if (!view.isSetElement()) {
            return Collections.emptyList();
        }
        final ProbabilisticBranchTransition modelElement = (ProbabilisticBranchTransition) view.getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        {
            final ResourceDemandingBehaviour childElement = modelElement.getBranchBehaviour_BranchTransition();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == ResourceDemandingBehaviour2EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getCollectionIteratorAction_3013SemanticChildren(
            final View view) {
        if (!view.isSetElement()) {
            return Collections.emptyList();
        }
        final CollectionIteratorAction modelElement = (CollectionIteratorAction) view.getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        {
            final ResourceDemandingBehaviour childElement = modelElement.getBodyBehaviour_Loop();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == ResourceDemandingBehaviour3EditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
            }
        }
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelNodeDescriptor> getGuardedBranchTransition_3017SemanticChildren(
            final View view) {
        if (!view.isSetElement()) {
            return Collections.emptyList();
        }
        final GuardedBranchTransition modelElement = (GuardedBranchTransition) view.getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        {
            final ResourceDemandingBehaviour childElement = modelElement.getBranchBehaviour_BranchTransition();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
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
            final View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        final View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        final ExternalCallAction modelElement = (ExternalCallAction) containerView.getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (final Iterator<?> it = modelElement.getInputVariableUsages__CallAction().iterator(); it.hasNext();) {
            final VariableUsage childElement = (VariableUsage) it.next();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
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
            final View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        final View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        final ExternalCallAction modelElement = (ExternalCallAction) containerView.getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (final Iterator<?> it = modelElement.getReturnVariableUsage__CallReturnAction().iterator(); it.hasNext();) {
            final VariableUsage childElement = (VariableUsage) it.next();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
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
            final View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        final View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        final VariableUsage modelElement = (VariableUsage) containerView.getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (final Iterator<?> it = modelElement.getVariableCharacterisation_VariableUsage().iterator(); it
                .hasNext();) {
            final VariableCharacterisation childElement = (VariableCharacterisation) it.next();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
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
            final View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        final View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        final VariableUsage modelElement = (VariableUsage) containerView.getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (final Iterator<?> it = modelElement.getVariableCharacterisation_VariableUsage().iterator(); it
                .hasNext();) {
            final VariableCharacterisation childElement = (VariableCharacterisation) it.next();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
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
            final View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        final View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        final EmitEventAction modelElement = (EmitEventAction) containerView.getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (final Iterator<?> it = modelElement.getInputVariableUsages__CallAction().iterator(); it.hasNext();) {
            final VariableUsage childElement = (VariableUsage) it.next();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
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
            final View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        final View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        final VariableUsage modelElement = (VariableUsage) containerView.getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (final Iterator<?> it = modelElement.getVariableCharacterisation_VariableUsage().iterator(); it
                .hasNext();) {
            final VariableCharacterisation childElement = (VariableCharacterisation) it.next();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
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
            final View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        final View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        final ResourceDemandingBehaviour modelElement = (ResourceDemandingBehaviour) containerView.getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (final Iterator<?> it = modelElement.getSteps_Behaviour().iterator(); it.hasNext();) {
            final AbstractAction childElement = (AbstractAction) it.next();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
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
            final View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        final View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        final InternalAction modelElement = (InternalAction) containerView.getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (final Iterator<?> it = modelElement.getResourceDemand_Action().iterator(); it.hasNext();) {
            final org.palladiosimulator.pcm.seff.seff_performance.ParametricResourceDemand childElement = (org.palladiosimulator.pcm.seff.seff_performance.ParametricResourceDemand) it
                    .next();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
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
            final View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        final View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        final InternalAction modelElement = (InternalAction) containerView.getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (final Iterator<?> it = modelElement.getInternalFailureOccurrenceDescriptions__InternalAction()
                .iterator(); it.hasNext();) {
            final InternalFailureOccurrenceDescription childElement = (InternalFailureOccurrenceDescription) it.next();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
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
            final View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        final View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        final InternalAction modelElement = (InternalAction) containerView.getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (final Iterator<?> it = modelElement.getInfrastructureCall__Action().iterator(); it.hasNext();) {
            final org.palladiosimulator.pcm.seff.seff_performance.InfrastructureCall childElement = (org.palladiosimulator.pcm.seff.seff_performance.InfrastructureCall) it
                    .next();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
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
            final View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        final View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        final org.palladiosimulator.pcm.seff.seff_performance.InfrastructureCall modelElement = (org.palladiosimulator.pcm.seff.seff_performance.InfrastructureCall) containerView
                .getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (final Iterator<?> it = modelElement.getInputVariableUsages__CallAction().iterator(); it.hasNext();) {
            final VariableUsage childElement = (VariableUsage) it.next();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
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
            final View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        final View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        final VariableUsage modelElement = (VariableUsage) containerView.getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (final Iterator<?> it = modelElement.getVariableCharacterisation_VariableUsage().iterator(); it
                .hasNext();) {
            final VariableCharacterisation childElement = (VariableCharacterisation) it.next();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
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
            final View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        final View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        final BranchAction modelElement = (BranchAction) containerView.getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (final Iterator<?> it = modelElement.getBranches_Branch().iterator(); it.hasNext();) {
            final AbstractBranchTransition childElement = (AbstractBranchTransition) it.next();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
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
            final View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        final View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        final ResourceDemandingBehaviour modelElement = (ResourceDemandingBehaviour) containerView.getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (final Iterator<?> it = modelElement.getSteps_Behaviour().iterator(); it.hasNext();) {
            final AbstractAction childElement = (AbstractAction) it.next();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
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
            final View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        final View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        final ExternalCallAction modelElement = (ExternalCallAction) containerView.getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (final Iterator<?> it = modelElement.getInputVariableUsages__CallAction().iterator(); it.hasNext();) {
            final VariableUsage childElement = (VariableUsage) it.next();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
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
            final View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        final View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        final ExternalCallAction modelElement = (ExternalCallAction) containerView.getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (final Iterator<?> it = modelElement.getReturnVariableUsage__CallReturnAction().iterator(); it.hasNext();) {
            final VariableUsage childElement = (VariableUsage) it.next();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
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
            final View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        final View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        final EmitEventAction modelElement = (EmitEventAction) containerView.getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (final Iterator<?> it = modelElement.getInputVariableUsages__CallAction().iterator(); it.hasNext();) {
            final VariableUsage childElement = (VariableUsage) it.next();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
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
            final View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        final View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        final ForkAction modelElement = (ForkAction) containerView.getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (final Iterator<?> it = modelElement.getAsynchronousForkedBehaviours_ForkAction().iterator(); it
                .hasNext();) {
            final ForkedBehaviour childElement = (ForkedBehaviour) it.next();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == ForkedBehaviourEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        {
            final SynchronisationPoint childElement = modelElement.getSynchronisingBehaviours_ForkAction();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
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
            final View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        final View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        final ForkedBehaviour modelElement = (ForkedBehaviour) containerView.getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (final Iterator<?> it = modelElement.getSteps_Behaviour().iterator(); it.hasNext();) {
            final AbstractAction childElement = (AbstractAction) it.next();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
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
            final View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        final View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        final ResourceDemandingBehaviour modelElement = (ResourceDemandingBehaviour) containerView.getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (final Iterator<?> it = modelElement.getSteps_Behaviour().iterator(); it.hasNext();) {
            final AbstractAction childElement = (AbstractAction) it.next();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
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
            final View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        final View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        final org.palladiosimulator.pcm.seff.seff_reliability.RecoveryAction modelElement = (org.palladiosimulator.pcm.seff.seff_reliability.RecoveryAction) containerView
                .getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (final Iterator<?> it = modelElement.getRecoveryActionBehaviours__RecoveryAction().iterator(); it
                .hasNext();) {
            final org.palladiosimulator.pcm.seff.seff_reliability.RecoveryActionBehaviour childElement = (org.palladiosimulator.pcm.seff.seff_reliability.RecoveryActionBehaviour) it
                    .next();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
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
            final View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        final View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        final org.palladiosimulator.pcm.seff.seff_reliability.RecoveryActionBehaviour modelElement = (org.palladiosimulator.pcm.seff.seff_reliability.RecoveryActionBehaviour) containerView
                .getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (final Iterator<?> it = modelElement.getSteps_Behaviour().iterator(); it.hasNext();) {
            final AbstractAction childElement = (AbstractAction) it.next();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
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
            final View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        final View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        final SynchronisationPoint modelElement = (SynchronisationPoint) containerView.getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (final Iterator<?> it = modelElement.getSynchronousForkedBehaviours_SynchronisationPoint().iterator(); it
                .hasNext();) {
            final ForkedBehaviour childElement = (ForkedBehaviour) it.next();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
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
            final View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        final View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        final ForkedBehaviour modelElement = (ForkedBehaviour) containerView.getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (final Iterator<?> it = modelElement.getSteps_Behaviour().iterator(); it.hasNext();) {
            final AbstractAction childElement = (AbstractAction) it.next();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
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
            final View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        final View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        final SetVariableAction modelElement = (SetVariableAction) containerView.getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (final Iterator<?> it = modelElement.getLocalVariableUsages_SetVariableAction().iterator(); it.hasNext();) {
            final VariableUsage childElement = (VariableUsage) it.next();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
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
            final View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        final View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        final VariableUsage modelElement = (VariableUsage) containerView.getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (final Iterator<?> it = modelElement.getVariableCharacterisation_VariableUsage().iterator(); it
                .hasNext();) {
            final VariableCharacterisation childElement = (VariableCharacterisation) it.next();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
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
            final View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        final View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        final ResourceDemandingBehaviour modelElement = (ResourceDemandingBehaviour) containerView.getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (final Iterator<?> it = modelElement.getSteps_Behaviour().iterator(); it.hasNext();) {
            final AbstractAction childElement = (AbstractAction) it.next();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
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
            final View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        final View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        final BranchAction modelElement = (BranchAction) containerView.getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (final Iterator<?> it = modelElement.getBranches_Branch().iterator(); it.hasNext();) {
            final AbstractBranchTransition childElement = (AbstractBranchTransition) it.next();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
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
            final View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        final View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        final InternalAction modelElement = (InternalAction) containerView.getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (final Iterator<?> it = modelElement.getResourceDemand_Action().iterator(); it.hasNext();) {
            final org.palladiosimulator.pcm.seff.seff_performance.ParametricResourceDemand childElement = (org.palladiosimulator.pcm.seff.seff_performance.ParametricResourceDemand) it
                    .next();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
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
            final View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        final View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        final InternalAction modelElement = (InternalAction) containerView.getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (final Iterator<?> it = modelElement.getInternalFailureOccurrenceDescriptions__InternalAction()
                .iterator(); it.hasNext();) {
            final InternalFailureOccurrenceDescription childElement = (InternalFailureOccurrenceDescription) it.next();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
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
            final View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        final View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        final InternalAction modelElement = (InternalAction) containerView.getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (final Iterator<?> it = modelElement.getInfrastructureCall__Action().iterator(); it.hasNext();) {
            final org.palladiosimulator.pcm.seff.seff_performance.InfrastructureCall childElement = (org.palladiosimulator.pcm.seff.seff_performance.InfrastructureCall) it
                    .next();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
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
            final View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        final View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        final SetVariableAction modelElement = (SetVariableAction) containerView.getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (final Iterator<?> it = modelElement.getLocalVariableUsages_SetVariableAction().iterator(); it.hasNext();) {
            final VariableUsage childElement = (VariableUsage) it.next();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
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
            final View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        final View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        final ForkAction modelElement = (ForkAction) containerView.getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (final Iterator<?> it = modelElement.getAsynchronousForkedBehaviours_ForkAction().iterator(); it
                .hasNext();) {
            final ForkedBehaviour childElement = (ForkedBehaviour) it.next();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
            if (visualID == ForkedBehaviourEditPart.VISUAL_ID) {
                result.add(new PalladioComponentModelNodeDescriptor(childElement, visualID));
                continue;
            }
        }
        {
            final SynchronisationPoint childElement = modelElement.getSynchronisingBehaviours_ForkAction();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
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
            final View view) {
        if (false == view.eContainer() instanceof View) {
            return Collections.emptyList();
        }
        final View containerView = (View) view.eContainer();
        if (!containerView.isSetElement()) {
            return Collections.emptyList();
        }
        final org.palladiosimulator.pcm.seff.seff_reliability.RecoveryAction modelElement = (org.palladiosimulator.pcm.seff.seff_reliability.RecoveryAction) containerView
                .getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (final Iterator<?> it = modelElement.getRecoveryActionBehaviours__RecoveryAction().iterator(); it
                .hasNext();) {
            final org.palladiosimulator.pcm.seff.seff_reliability.RecoveryActionBehaviour childElement = (org.palladiosimulator.pcm.seff.seff_reliability.RecoveryActionBehaviour) it
                    .next();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
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
    public static List<PalladioComponentModelNodeDescriptor> getResourceDemandingSEFF_1000SemanticChildren(
            final View view) {
        if (!view.isSetElement()) {
            return Collections.emptyList();
        }
        final ResourceDemandingSEFF modelElement = (ResourceDemandingSEFF) view.getElement();
        final LinkedList<PalladioComponentModelNodeDescriptor> result = new LinkedList<PalladioComponentModelNodeDescriptor>();
        for (final Iterator<?> it = modelElement.getSteps_Behaviour().iterator(); it.hasNext();) {
            final AbstractAction childElement = (AbstractAction) it.next();
            final int visualID = PalladioComponentModelVisualIDRegistry.getNodeVisualID(view, childElement);
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
    public static List<PalladioComponentModelLinkDescriptor> getContainedLinks(final View view) {
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
    public static List<PalladioComponentModelLinkDescriptor> getIncomingLinks(final View view) {
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
    public static List<PalladioComponentModelLinkDescriptor> getOutgoingLinks(final View view) {
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
    public static List<PalladioComponentModelLinkDescriptor> getResourceDemandingSEFF_1000ContainedLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getStartAction_2001ContainedLinks(final View view) {
        final StartAction modelElement = (StartAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getStopAction_2002ContainedLinks(final View view) {
        final StopAction modelElement = (StopAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getExternalCallAction_2003ContainedLinks(final View view) {
        final ExternalCallAction modelElement = (ExternalCallAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getEmitEventAction_2013ContainedLinks(final View view) {
        final EmitEventAction modelElement = (EmitEventAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getLoopAction_2004ContainedLinks(final View view) {
        final LoopAction modelElement = (LoopAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getBranchAction_2005ContainedLinks(final View view) {
        final BranchAction modelElement = (BranchAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInternalAction_2006ContainedLinks(final View view) {
        final InternalAction modelElement = (InternalAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getCollectionIteratorAction_2007ContainedLinks(
            final View view) {
        final CollectionIteratorAction modelElement = (CollectionIteratorAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getSetVariableAction_2008ContainedLinks(final View view) {
        final SetVariableAction modelElement = (SetVariableAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getAcquireAction_2012ContainedLinks(final View view) {
        final AcquireAction modelElement = (AcquireAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getReleaseAction_2010ContainedLinks(final View view) {
        final ReleaseAction modelElement = (ReleaseAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getForkAction_2011ContainedLinks(final View view) {
        final ForkAction modelElement = (ForkAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getRecoveryAction_2017ContainedLinks(final View view) {
        final org.palladiosimulator.pcm.seff.seff_reliability.RecoveryAction modelElement = (org.palladiosimulator.pcm.seff.seff_reliability.RecoveryAction) view
                .getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableUsage_3042ContainedLinks(final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableCharacterisation_3033ContainedLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableUsage_3049ContainedLinks(final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableCharacterisation_3035ContainedLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableUsage_3047ContainedLinks(final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getResourceDemandingBehaviour_3003ContainedLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getStartAction_3004ContainedLinks(final View view) {
        final StartAction modelElement = (StartAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getStopAction_3005ContainedLinks(final View view) {
        final StopAction modelElement = (StopAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getLoopAction_3006ContainedLinks(final View view) {
        final LoopAction modelElement = (LoopAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInternalAction_3007ContainedLinks(final View view) {
        final InternalAction modelElement = (InternalAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getParametricResourceDemand_3051ContainedLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInternalFailureOccurrenceDescription_3050ContainedLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInfrastructureCall_3053ContainedLinks(final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableUsage_3054ContainedLinks(final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getBranchAction_3009ContainedLinks(final View view) {
        final BranchAction modelElement = (BranchAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getProbabilisticBranchTransition_3010ContainedLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getResourceDemandingBehaviour_3011ContainedLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getExternalCallAction_3012ContainedLinks(final View view) {
        final ExternalCallAction modelElement = (ExternalCallAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getEmitEventAction_3046ContainedLinks(final View view) {
        final EmitEventAction modelElement = (EmitEventAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getAcquireAction_3026ContainedLinks(final View view) {
        final AcquireAction modelElement = (AcquireAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getReleaseAction_3020ContainedLinks(final View view) {
        final ReleaseAction modelElement = (ReleaseAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getForkAction_3023ContainedLinks(final View view) {
        final ForkAction modelElement = (ForkAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getForkedBehaviour_3027ContainedLinks(final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getCollectionIteratorAction_3013ContainedLinks(
            final View view) {
        final CollectionIteratorAction modelElement = (CollectionIteratorAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getResourceDemandingBehaviour_3014ContainedLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getRecoveryAction_3061ContainedLinks(final View view) {
        final org.palladiosimulator.pcm.seff.seff_reliability.RecoveryAction modelElement = (org.palladiosimulator.pcm.seff.seff_reliability.RecoveryAction) view
                .getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getRecoveryActionBehaviour_3062ContainedLinks(
            final View view) {
        final org.palladiosimulator.pcm.seff.seff_reliability.RecoveryActionBehaviour modelElement = (org.palladiosimulator.pcm.seff.seff_reliability.RecoveryActionBehaviour) view
                .getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(
                getOutgoingFeatureModelFacetLinks_RecoveryActionBehaviour_FailureHandlingAlternatives__RecoveryActionBehaviour_4004(
                        modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getSynchronisationPoint_3038ContainedLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getForkedBehaviour_3039ContainedLinks(final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getSetVariableAction_3024ContainedLinks(final View view) {
        final SetVariableAction modelElement = (SetVariableAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableUsage_3036ContainedLinks(final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableCharacterisation_3055ContainedLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableCharacterisation_3048ContainedLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableCharacterisation_3037ContainedLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getGuardedBranchTransition_3017ContainedLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getResourceDemandingBehaviour_3018ContainedLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getStartAction_2001IncomingLinks(final View view) {
        final StartAction modelElement = (StartAction) view.getElement();
        final Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getStopAction_2002IncomingLinks(final View view) {
        final StopAction modelElement = (StopAction) view.getElement();
        final Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getExternalCallAction_2003IncomingLinks(final View view) {
        final ExternalCallAction modelElement = (ExternalCallAction) view.getElement();
        final Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getEmitEventAction_2013IncomingLinks(final View view) {
        final EmitEventAction modelElement = (EmitEventAction) view.getElement();
        final Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getLoopAction_2004IncomingLinks(final View view) {
        final LoopAction modelElement = (LoopAction) view.getElement();
        final Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getBranchAction_2005IncomingLinks(final View view) {
        final BranchAction modelElement = (BranchAction) view.getElement();
        final Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInternalAction_2006IncomingLinks(final View view) {
        final InternalAction modelElement = (InternalAction) view.getElement();
        final Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getCollectionIteratorAction_2007IncomingLinks(
            final View view) {
        final CollectionIteratorAction modelElement = (CollectionIteratorAction) view.getElement();
        final Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getSetVariableAction_2008IncomingLinks(final View view) {
        final SetVariableAction modelElement = (SetVariableAction) view.getElement();
        final Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getAcquireAction_2012IncomingLinks(final View view) {
        final AcquireAction modelElement = (AcquireAction) view.getElement();
        final Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getReleaseAction_2010IncomingLinks(final View view) {
        final ReleaseAction modelElement = (ReleaseAction) view.getElement();
        final Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getForkAction_2011IncomingLinks(final View view) {
        final ForkAction modelElement = (ForkAction) view.getElement();
        final Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getRecoveryAction_2017IncomingLinks(final View view) {
        final org.palladiosimulator.pcm.seff.seff_reliability.RecoveryAction modelElement = (org.palladiosimulator.pcm.seff.seff_reliability.RecoveryAction) view
                .getElement();
        final Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableUsage_3042IncomingLinks(final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableCharacterisation_3033IncomingLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableUsage_3049IncomingLinks(final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableCharacterisation_3035IncomingLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableUsage_3047IncomingLinks(final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getResourceDemandingBehaviour_3003IncomingLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getStartAction_3004IncomingLinks(final View view) {
        final StartAction modelElement = (StartAction) view.getElement();
        final Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getStopAction_3005IncomingLinks(final View view) {
        final StopAction modelElement = (StopAction) view.getElement();
        final Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getLoopAction_3006IncomingLinks(final View view) {
        final LoopAction modelElement = (LoopAction) view.getElement();
        final Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInternalAction_3007IncomingLinks(final View view) {
        final InternalAction modelElement = (InternalAction) view.getElement();
        final Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getParametricResourceDemand_3051IncomingLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInternalFailureOccurrenceDescription_3050IncomingLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInfrastructureCall_3053IncomingLinks(final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableUsage_3054IncomingLinks(final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getBranchAction_3009IncomingLinks(final View view) {
        final BranchAction modelElement = (BranchAction) view.getElement();
        final Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getProbabilisticBranchTransition_3010IncomingLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getResourceDemandingBehaviour_3011IncomingLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getExternalCallAction_3012IncomingLinks(final View view) {
        final ExternalCallAction modelElement = (ExternalCallAction) view.getElement();
        final Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getEmitEventAction_3046IncomingLinks(final View view) {
        final EmitEventAction modelElement = (EmitEventAction) view.getElement();
        final Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getAcquireAction_3026IncomingLinks(final View view) {
        final AcquireAction modelElement = (AcquireAction) view.getElement();
        final Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getReleaseAction_3020IncomingLinks(final View view) {
        final ReleaseAction modelElement = (ReleaseAction) view.getElement();
        final Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getForkAction_3023IncomingLinks(final View view) {
        final ForkAction modelElement = (ForkAction) view.getElement();
        final Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getForkedBehaviour_3027IncomingLinks(final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getCollectionIteratorAction_3013IncomingLinks(
            final View view) {
        final CollectionIteratorAction modelElement = (CollectionIteratorAction) view.getElement();
        final Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getResourceDemandingBehaviour_3014IncomingLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getRecoveryAction_3061IncomingLinks(final View view) {
        final org.palladiosimulator.pcm.seff.seff_reliability.RecoveryAction modelElement = (org.palladiosimulator.pcm.seff.seff_reliability.RecoveryAction) view
                .getElement();
        final Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getRecoveryActionBehaviour_3062IncomingLinks(
            final View view) {
        final org.palladiosimulator.pcm.seff.seff_reliability.RecoveryActionBehaviour modelElement = (org.palladiosimulator.pcm.seff.seff_reliability.RecoveryActionBehaviour) view
                .getElement();
        final Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(
                getIncomingFeatureModelFacetLinks_RecoveryActionBehaviour_FailureHandlingAlternatives__RecoveryActionBehaviour_4004(
                        modelElement, crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getSynchronisationPoint_3038IncomingLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getForkedBehaviour_3039IncomingLinks(final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getSetVariableAction_3024IncomingLinks(final View view) {
        final SetVariableAction modelElement = (SetVariableAction) view.getElement();
        final Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
                .find(view.eResource().getResourceSet().getResources());
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement,
                crossReferences));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableUsage_3036IncomingLinks(final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableCharacterisation_3055IncomingLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableCharacterisation_3048IncomingLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableCharacterisation_3037IncomingLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getGuardedBranchTransition_3017IncomingLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getResourceDemandingBehaviour_3018IncomingLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getStartAction_2001OutgoingLinks(final View view) {
        final StartAction modelElement = (StartAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getStopAction_2002OutgoingLinks(final View view) {
        final StopAction modelElement = (StopAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getExternalCallAction_2003OutgoingLinks(final View view) {
        final ExternalCallAction modelElement = (ExternalCallAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getEmitEventAction_2013OutgoingLinks(final View view) {
        final EmitEventAction modelElement = (EmitEventAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getLoopAction_2004OutgoingLinks(final View view) {
        final LoopAction modelElement = (LoopAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getBranchAction_2005OutgoingLinks(final View view) {
        final BranchAction modelElement = (BranchAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInternalAction_2006OutgoingLinks(final View view) {
        final InternalAction modelElement = (InternalAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getCollectionIteratorAction_2007OutgoingLinks(
            final View view) {
        final CollectionIteratorAction modelElement = (CollectionIteratorAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getSetVariableAction_2008OutgoingLinks(final View view) {
        final SetVariableAction modelElement = (SetVariableAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getAcquireAction_2012OutgoingLinks(final View view) {
        final AcquireAction modelElement = (AcquireAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getReleaseAction_2010OutgoingLinks(final View view) {
        final ReleaseAction modelElement = (ReleaseAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getForkAction_2011OutgoingLinks(final View view) {
        final ForkAction modelElement = (ForkAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getRecoveryAction_2017OutgoingLinks(final View view) {
        final org.palladiosimulator.pcm.seff.seff_reliability.RecoveryAction modelElement = (org.palladiosimulator.pcm.seff.seff_reliability.RecoveryAction) view
                .getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableUsage_3042OutgoingLinks(final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableCharacterisation_3033OutgoingLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableUsage_3049OutgoingLinks(final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableCharacterisation_3035OutgoingLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableUsage_3047OutgoingLinks(final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getResourceDemandingBehaviour_3003OutgoingLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getStartAction_3004OutgoingLinks(final View view) {
        final StartAction modelElement = (StartAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getStopAction_3005OutgoingLinks(final View view) {
        final StopAction modelElement = (StopAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getLoopAction_3006OutgoingLinks(final View view) {
        final LoopAction modelElement = (LoopAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInternalAction_3007OutgoingLinks(final View view) {
        final InternalAction modelElement = (InternalAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getParametricResourceDemand_3051OutgoingLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInternalFailureOccurrenceDescription_3050OutgoingLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getInfrastructureCall_3053OutgoingLinks(final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableUsage_3054OutgoingLinks(final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getBranchAction_3009OutgoingLinks(final View view) {
        final BranchAction modelElement = (BranchAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getProbabilisticBranchTransition_3010OutgoingLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getResourceDemandingBehaviour_3011OutgoingLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getExternalCallAction_3012OutgoingLinks(final View view) {
        final ExternalCallAction modelElement = (ExternalCallAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getEmitEventAction_3046OutgoingLinks(final View view) {
        final EmitEventAction modelElement = (EmitEventAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getAcquireAction_3026OutgoingLinks(final View view) {
        final AcquireAction modelElement = (AcquireAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getReleaseAction_3020OutgoingLinks(final View view) {
        final ReleaseAction modelElement = (ReleaseAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getForkAction_3023OutgoingLinks(final View view) {
        final ForkAction modelElement = (ForkAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getForkedBehaviour_3027OutgoingLinks(final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getCollectionIteratorAction_3013OutgoingLinks(
            final View view) {
        final CollectionIteratorAction modelElement = (CollectionIteratorAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getResourceDemandingBehaviour_3014OutgoingLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getRecoveryAction_3061OutgoingLinks(final View view) {
        final org.palladiosimulator.pcm.seff.seff_reliability.RecoveryAction modelElement = (org.palladiosimulator.pcm.seff.seff_reliability.RecoveryAction) view
                .getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getRecoveryActionBehaviour_3062OutgoingLinks(
            final View view) {
        final org.palladiosimulator.pcm.seff.seff_reliability.RecoveryActionBehaviour modelElement = (org.palladiosimulator.pcm.seff.seff_reliability.RecoveryActionBehaviour) view
                .getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(
                getOutgoingFeatureModelFacetLinks_RecoveryActionBehaviour_FailureHandlingAlternatives__RecoveryActionBehaviour_4004(
                        modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getSynchronisationPoint_3038OutgoingLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getForkedBehaviour_3039OutgoingLinks(final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getSetVariableAction_3024OutgoingLinks(final View view) {
        final SetVariableAction modelElement = (SetVariableAction) view.getElement();
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        result.addAll(getOutgoingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(modelElement));
        return result;
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableUsage_3036OutgoingLinks(final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableCharacterisation_3055OutgoingLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableCharacterisation_3048OutgoingLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getVariableCharacterisation_3037OutgoingLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getGuardedBranchTransition_3017OutgoingLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    public static List<PalladioComponentModelLinkDescriptor> getResourceDemandingBehaviour_3018OutgoingLinks(
            final View view) {
        return Collections.emptyList();
    }

    /**
     * @generated
     */
    private static Collection<PalladioComponentModelLinkDescriptor> getIncomingFeatureModelFacetLinks_AbstractAction_Successor_AbstractAction_4001(
            final AbstractAction target, final Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        final Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
        for (final EStructuralFeature.Setting setting : settings) {
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
            final org.palladiosimulator.pcm.seff.seff_reliability.RecoveryActionBehaviour target,
            final Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        final Collection<EStructuralFeature.Setting> settings = crossReferences.get(target);
        for (final EStructuralFeature.Setting setting : settings) {
            if (setting
                    .getEStructuralFeature() == org.palladiosimulator.pcm.seff.seff_reliability.SeffReliabilityPackage.eINSTANCE
                            .getRecoveryActionBehaviour_FailureHandlingAlternatives__RecoveryActionBehaviour()) {
                result.add(new PalladioComponentModelLinkDescriptor(setting.getEObject(), target,
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
            final AbstractAction source) {
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        final AbstractAction destination = source.getSuccessor_AbstractAction();
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
            final org.palladiosimulator.pcm.seff.seff_reliability.RecoveryActionBehaviour source) {
        final LinkedList<PalladioComponentModelLinkDescriptor> result = new LinkedList<PalladioComponentModelLinkDescriptor>();
        for (final Iterator<?> destinations = source.getFailureHandlingAlternatives__RecoveryActionBehaviour()
                .iterator(); destinations.hasNext();) {
            final org.palladiosimulator.pcm.seff.seff_reliability.RecoveryActionBehaviour destination = (org.palladiosimulator.pcm.seff.seff_reliability.RecoveryActionBehaviour) destinations
                    .next();
            result.add(new PalladioComponentModelLinkDescriptor(source, destination,
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
        public List<PalladioComponentModelNodeDescriptor> getSemanticChildren(final View view) {
            return PalladioComponentModelDiagramUpdater.getSemanticChildren(view);
        }

        /**
         * @generated
         */
        @Override
        public List<PalladioComponentModelLinkDescriptor> getContainedLinks(final View view) {
            return PalladioComponentModelDiagramUpdater.getContainedLinks(view);
        }

        /**
         * @generated
         */
        @Override
        public List<PalladioComponentModelLinkDescriptor> getIncomingLinks(final View view) {
            return PalladioComponentModelDiagramUpdater.getIncomingLinks(view);
        }

        /**
         * @generated
         */
        @Override
        public List<PalladioComponentModelLinkDescriptor> getOutgoingLinks(final View view) {
            return PalladioComponentModelDiagramUpdater.getOutgoingLinks(view);
        }
    };

}
