/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.*;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.reliability.ReliabilityPackage;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

/**
 * @generated
 */
public class PalladioComponentModelVisualIDRegistry {

    /**
     * @generated
     */
    private static final String DEBUG_KEY = "de.uka.ipd.sdq.pcm.gmf.seff/debug/visualID"; //$NON-NLS-1$

    /**
     * @generated
     */
    public static int getVisualID(View view) {
        if (view instanceof Diagram) {
            if (ResourceDemandingSEFFEditPart.MODEL_ID.equals(view.getType())) {
                return ResourceDemandingSEFFEditPart.VISUAL_ID;
            } else {
                return -1;
            }
        }
        return de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry.getVisualID(view.getType());
    }

    /**
     * @generated
     */
    public static String getModelID(View view) {
        View diagram = view.getDiagram();
        while (view != diagram) {
            EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
            if (annotation != null) {
                return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
            }
            view = (View) view.eContainer();
        }
        return diagram != null ? diagram.getType() : null;
    }

    /**
     * @generated
     */
    public static int getVisualID(String type) {
        try {
            return Integer.parseInt(type);
        } catch (NumberFormatException e) {
            if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
                PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                        "Unable to parse view type as a visualID number: " + type);
            }
        }
        return -1;
    }

    /**
     * @generated
     */
    public static String getType(int visualID) {
        return Integer.toString(visualID);
    }

    /**
     * @generated
     */
    public static int getDiagramVisualID(EObject domainElement) {
        if (domainElement == null) {
            return -1;
        }
        if (SeffPackage.eINSTANCE.getResourceDemandingSEFF().isSuperTypeOf(domainElement.eClass())
                && isDiagram((ResourceDemandingSEFF) domainElement)) {
            return ResourceDemandingSEFFEditPart.VISUAL_ID;
        }
        return -1;
    }

    /**
     * @generated
     */
    public static int getNodeVisualID(View containerView, EObject domainElement) {
        if (domainElement == null) {
            return -1;
        }
        String containerModelID = de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry
                .getModelID(containerView);
        if (!ResourceDemandingSEFFEditPart.MODEL_ID.equals(containerModelID)) {
            return -1;
        }
        int containerVisualID;
        if (ResourceDemandingSEFFEditPart.MODEL_ID.equals(containerModelID)) {
            containerVisualID = de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry
                    .getVisualID(containerView);
        } else {
            if (containerView instanceof Diagram) {
                containerVisualID = ResourceDemandingSEFFEditPart.VISUAL_ID;
            } else {
                return -1;
            }
        }
        switch (containerVisualID) {
        case ResourceDemandingSEFFEditPart.VISUAL_ID:
            if (SeffPackage.eINSTANCE.getStartAction().isSuperTypeOf(domainElement.eClass())) {
                return StartActionEditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getStopAction().isSuperTypeOf(domainElement.eClass())) {
                return StopActionEditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getExternalCallAction().isSuperTypeOf(domainElement.eClass())) {
                return ExternalCallActionEditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getEmitEventAction().isSuperTypeOf(domainElement.eClass())) {
                return EmitEventActionEditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getLoopAction().isSuperTypeOf(domainElement.eClass())) {
                return LoopActionEditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getBranchAction().isSuperTypeOf(domainElement.eClass())) {
                return BranchActionEditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getInternalAction().isSuperTypeOf(domainElement.eClass())) {
                return InternalActionEditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getCollectionIteratorAction().isSuperTypeOf(domainElement.eClass())) {
                return CollectionIteratorActionEditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getSetVariableAction().isSuperTypeOf(domainElement.eClass())) {
                return SetVariableActionEditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getAcquireAction().isSuperTypeOf(domainElement.eClass())) {
                return AcquireActionEditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getReleaseAction().isSuperTypeOf(domainElement.eClass())) {
                return ReleaseActionEditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getForkAction().isSuperTypeOf(domainElement.eClass())) {
                return ForkActionEditPart.VISUAL_ID;
            }
            if (de.uka.ipd.sdq.pcm.seff.seff_reliability.SeffReliabilityPackage.eINSTANCE.getRecoveryAction()
                    .isSuperTypeOf(domainElement.eClass())) {
                return RecoveryActionEditPart.VISUAL_ID;
            }
            break;
        case LoopActionEditPart.VISUAL_ID:
            if (SeffPackage.eINSTANCE.getResourceDemandingBehaviour().isSuperTypeOf(domainElement.eClass())) {
                return ResourceDemandingBehaviourEditPart.VISUAL_ID;
            }
            break;
        case CollectionIteratorActionEditPart.VISUAL_ID:
            if (SeffPackage.eINSTANCE.getResourceDemandingBehaviour().isSuperTypeOf(domainElement.eClass())) {
                return ResourceDemandingBehaviour3EditPart.VISUAL_ID;
            }
            break;
        case LoopAction2EditPart.VISUAL_ID:
            if (SeffPackage.eINSTANCE.getResourceDemandingBehaviour().isSuperTypeOf(domainElement.eClass())) {
                return ResourceDemandingBehaviourEditPart.VISUAL_ID;
            }
            break;
        case ProbabilisticBranchTransitionEditPart.VISUAL_ID:
            if (SeffPackage.eINSTANCE.getResourceDemandingBehaviour().isSuperTypeOf(domainElement.eClass())) {
                return ResourceDemandingBehaviour2EditPart.VISUAL_ID;
            }
            break;
        case CollectionIteratorAction2EditPart.VISUAL_ID:
            if (SeffPackage.eINSTANCE.getResourceDemandingBehaviour().isSuperTypeOf(domainElement.eClass())) {
                return ResourceDemandingBehaviour3EditPart.VISUAL_ID;
            }
            break;
        case GuardedBranchTransitionEditPart.VISUAL_ID:
            if (SeffPackage.eINSTANCE.getResourceDemandingBehaviour().isSuperTypeOf(domainElement.eClass())) {
                return ResourceDemandingBehaviour4EditPart.VISUAL_ID;
            }
            break;
        case ExternalCallActionInputVariableUsageEditPart.VISUAL_ID:
            if (ParameterPackage.eINSTANCE.getVariableUsage().isSuperTypeOf(domainElement.eClass())) {
                return VariableUsageEditPart.VISUAL_ID;
            }
            break;
        case ExternalCallActionOutputVariableUsageEditPart.VISUAL_ID:
            if (ParameterPackage.eINSTANCE.getVariableUsage().isSuperTypeOf(domainElement.eClass())) {
                return VariableUsage2EditPart.VISUAL_ID;
            }
            break;
        case VariableUsageVariableCharacterisationEditPart.VISUAL_ID:
            if (ParameterPackage.eINSTANCE.getVariableCharacterisation().isSuperTypeOf(domainElement.eClass())) {
                return VariableCharacterisationEditPart.VISUAL_ID;
            }
            break;
        case VariableUsageVariableCharacterisation2EditPart.VISUAL_ID:
            if (ParameterPackage.eINSTANCE.getVariableCharacterisation().isSuperTypeOf(domainElement.eClass())) {
                return VariableCharacterisation2EditPart.VISUAL_ID;
            }
            break;
        case EmitEventActionInputVariableUsageEventEditPart.VISUAL_ID:
            if (ParameterPackage.eINSTANCE.getVariableUsage().isSuperTypeOf(domainElement.eClass())) {
                return VariableUsage4EditPart.VISUAL_ID;
            }
            break;
        case VariableUsageVariableCharacterisation4EditPart.VISUAL_ID:
            if (ParameterPackage.eINSTANCE.getVariableCharacterisation().isSuperTypeOf(domainElement.eClass())) {
                return VariableCharacterisation3EditPart.VISUAL_ID;
            }
            break;
        case ResourceDemandingBehaviourBehaviourCompartmentEditPart.VISUAL_ID:
            if (SeffPackage.eINSTANCE.getStartAction().isSuperTypeOf(domainElement.eClass())) {
                return StartAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getStopAction().isSuperTypeOf(domainElement.eClass())) {
                return StopAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getLoopAction().isSuperTypeOf(domainElement.eClass())) {
                return LoopAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getInternalAction().isSuperTypeOf(domainElement.eClass())) {
                return InternalAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getBranchAction().isSuperTypeOf(domainElement.eClass())) {
                return BranchAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getExternalCallAction().isSuperTypeOf(domainElement.eClass())) {
                return ExternalCallAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getEmitEventAction().isSuperTypeOf(domainElement.eClass())) {
                return EmitEventAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getCollectionIteratorAction().isSuperTypeOf(domainElement.eClass())) {
                return CollectionIteratorAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getAcquireAction().isSuperTypeOf(domainElement.eClass())) {
                return AcquireAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getReleaseAction().isSuperTypeOf(domainElement.eClass())) {
                return ReleaseAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getForkAction().isSuperTypeOf(domainElement.eClass())) {
                return ForkAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getSetVariableAction().isSuperTypeOf(domainElement.eClass())) {
                return SetVariableAction2EditPart.VISUAL_ID;
            }
            if (de.uka.ipd.sdq.pcm.seff.seff_reliability.SeffReliabilityPackage.eINSTANCE.getRecoveryAction()
                    .isSuperTypeOf(domainElement.eClass())) {
                return RecoveryAction2EditPart.VISUAL_ID;
            }
            break;
        case InternalActionResourceDemandEditPart.VISUAL_ID:
            if (de.uka.ipd.sdq.pcm.seff.seff_performance.SeffPerformancePackage.eINSTANCE.getParametricResourceDemand()
                    .isSuperTypeOf(domainElement.eClass())) {
                return ParametricResourceDemandEditPart.VISUAL_ID;
            }
            break;
        case InternalActionFailureOccurrenceDescriptionsEditPart.VISUAL_ID:
            if (ReliabilityPackage.eINSTANCE.getInternalFailureOccurrenceDescription().isSuperTypeOf(
                    domainElement.eClass())) {
                return InternalFailureOccurrenceDescriptionEditPart.VISUAL_ID;
            }
            break;
        case InternalActionInfrastructureCallsCompartmentEditPart.VISUAL_ID:
            if (de.uka.ipd.sdq.pcm.seff.seff_performance.SeffPerformancePackage.eINSTANCE.getInfrastructureCall()
                    .isSuperTypeOf(domainElement.eClass())) {
                return InfrastructureCallEditPart.VISUAL_ID;
            }
            break;
        case InfrastructureCallInfrastructureCallInputVariableUsagesEditPart.VISUAL_ID:
            if (ParameterPackage.eINSTANCE.getVariableUsage().isSuperTypeOf(domainElement.eClass())) {
                return VariableUsage5EditPart.VISUAL_ID;
            }
            break;
        case VariableUsageVariableCharacterisation5EditPart.VISUAL_ID:
            if (ParameterPackage.eINSTANCE.getVariableCharacterisation().isSuperTypeOf(domainElement.eClass())) {
                return VariableCharacterisation4EditPart.VISUAL_ID;
            }
            break;
        case BranchActionBranchTransitionCompartmentEditPart.VISUAL_ID:
            if (SeffPackage.eINSTANCE.getProbabilisticBranchTransition().isSuperTypeOf(domainElement.eClass())) {
                return ProbabilisticBranchTransitionEditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getGuardedBranchTransition().isSuperTypeOf(domainElement.eClass())) {
                return GuardedBranchTransitionEditPart.VISUAL_ID;
            }
            break;
        case ResourceDemandingBehaviourBehaviourCompartment2EditPart.VISUAL_ID:
            if (SeffPackage.eINSTANCE.getStartAction().isSuperTypeOf(domainElement.eClass())) {
                return StartAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getStopAction().isSuperTypeOf(domainElement.eClass())) {
                return StopAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getLoopAction().isSuperTypeOf(domainElement.eClass())) {
                return LoopAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getInternalAction().isSuperTypeOf(domainElement.eClass())) {
                return InternalAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getBranchAction().isSuperTypeOf(domainElement.eClass())) {
                return BranchAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getExternalCallAction().isSuperTypeOf(domainElement.eClass())) {
                return ExternalCallAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getEmitEventAction().isSuperTypeOf(domainElement.eClass())) {
                return EmitEventAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getAcquireAction().isSuperTypeOf(domainElement.eClass())) {
                return AcquireAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getReleaseAction().isSuperTypeOf(domainElement.eClass())) {
                return ReleaseAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getForkAction().isSuperTypeOf(domainElement.eClass())) {
                return ForkAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getCollectionIteratorAction().isSuperTypeOf(domainElement.eClass())) {
                return CollectionIteratorAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getSetVariableAction().isSuperTypeOf(domainElement.eClass())) {
                return SetVariableAction2EditPart.VISUAL_ID;
            }
            if (de.uka.ipd.sdq.pcm.seff.seff_reliability.SeffReliabilityPackage.eINSTANCE.getRecoveryAction()
                    .isSuperTypeOf(domainElement.eClass())) {
                return RecoveryAction2EditPart.VISUAL_ID;
            }
            break;
        case ExternalCallActionInputVariableUsage2EditPart.VISUAL_ID:
            if (ParameterPackage.eINSTANCE.getVariableUsage().isSuperTypeOf(domainElement.eClass())) {
                return VariableUsageEditPart.VISUAL_ID;
            }
            break;
        case ExternalCallActionOutputVariableUsage2EditPart.VISUAL_ID:
            if (ParameterPackage.eINSTANCE.getVariableUsage().isSuperTypeOf(domainElement.eClass())) {
                return VariableUsage2EditPart.VISUAL_ID;
            }
            break;
        case EmitEventActionInputVariableUsageEvent2EditPart.VISUAL_ID:
            if (ParameterPackage.eINSTANCE.getVariableUsage().isSuperTypeOf(domainElement.eClass())) {
                return VariableUsage4EditPart.VISUAL_ID;
            }
            break;
        case ForkActionForkedBehavioursEditPart.VISUAL_ID:
            if (SeffPackage.eINSTANCE.getForkedBehaviour().isSuperTypeOf(domainElement.eClass())) {
                return ForkedBehaviourEditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getSynchronisationPoint().isSuperTypeOf(domainElement.eClass())) {
                return SynchronisationPointEditPart.VISUAL_ID;
            }
            break;
        case ForkedBehaviourBehaviourCompartmentEditPart.VISUAL_ID:
            if (SeffPackage.eINSTANCE.getStartAction().isSuperTypeOf(domainElement.eClass())) {
                return StartAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getStopAction().isSuperTypeOf(domainElement.eClass())) {
                return StopAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getLoopAction().isSuperTypeOf(domainElement.eClass())) {
                return LoopAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getInternalAction().isSuperTypeOf(domainElement.eClass())) {
                return InternalAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getBranchAction().isSuperTypeOf(domainElement.eClass())) {
                return BranchAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getExternalCallAction().isSuperTypeOf(domainElement.eClass())) {
                return ExternalCallAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getEmitEventAction().isSuperTypeOf(domainElement.eClass())) {
                return EmitEventAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getCollectionIteratorAction().isSuperTypeOf(domainElement.eClass())) {
                return CollectionIteratorAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getAcquireAction().isSuperTypeOf(domainElement.eClass())) {
                return AcquireAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getReleaseAction().isSuperTypeOf(domainElement.eClass())) {
                return ReleaseAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getForkAction().isSuperTypeOf(domainElement.eClass())) {
                return ForkAction2EditPart.VISUAL_ID;
            }
            if (de.uka.ipd.sdq.pcm.seff.seff_reliability.SeffReliabilityPackage.eINSTANCE.getRecoveryAction()
                    .isSuperTypeOf(domainElement.eClass())) {
                return RecoveryAction2EditPart.VISUAL_ID;
            }
            break;
        case ResourceDemandingBehaviourBehaviourCompartment3EditPart.VISUAL_ID:
            if (SeffPackage.eINSTANCE.getStartAction().isSuperTypeOf(domainElement.eClass())) {
                return StartAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getStopAction().isSuperTypeOf(domainElement.eClass())) {
                return StopAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getLoopAction().isSuperTypeOf(domainElement.eClass())) {
                return LoopAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getInternalAction().isSuperTypeOf(domainElement.eClass())) {
                return InternalAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getBranchAction().isSuperTypeOf(domainElement.eClass())) {
                return BranchAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getExternalCallAction().isSuperTypeOf(domainElement.eClass())) {
                return ExternalCallAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getEmitEventAction().isSuperTypeOf(domainElement.eClass())) {
                return EmitEventAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getCollectionIteratorAction().isSuperTypeOf(domainElement.eClass())) {
                return CollectionIteratorAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getAcquireAction().isSuperTypeOf(domainElement.eClass())) {
                return AcquireAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getReleaseAction().isSuperTypeOf(domainElement.eClass())) {
                return ReleaseAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getForkAction().isSuperTypeOf(domainElement.eClass())) {
                return ForkAction2EditPart.VISUAL_ID;
            }
            if (de.uka.ipd.sdq.pcm.seff.seff_reliability.SeffReliabilityPackage.eINSTANCE.getRecoveryAction()
                    .isSuperTypeOf(domainElement.eClass())) {
                return RecoveryAction2EditPart.VISUAL_ID;
            }
            break;
        case RecoveryActionRecoveryBlockCompartmentEditPart.VISUAL_ID:
            if (de.uka.ipd.sdq.pcm.seff.seff_reliability.SeffReliabilityPackage.eINSTANCE.getRecoveryActionBehaviour()
                    .isSuperTypeOf(domainElement.eClass())) {
                return RecoveryActionBehaviourEditPart.VISUAL_ID;
            }
            break;
        case RecoveryActionBehaviourAlternativeBehaviourCompartmentEditPart.VISUAL_ID:
            if (SeffPackage.eINSTANCE.getStartAction().isSuperTypeOf(domainElement.eClass())) {
                return StartAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getStopAction().isSuperTypeOf(domainElement.eClass())) {
                return StopAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getLoopAction().isSuperTypeOf(domainElement.eClass())) {
                return LoopAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getInternalAction().isSuperTypeOf(domainElement.eClass())) {
                return InternalAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getBranchAction().isSuperTypeOf(domainElement.eClass())) {
                return BranchAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getExternalCallAction().isSuperTypeOf(domainElement.eClass())) {
                return ExternalCallAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getEmitEventAction().isSuperTypeOf(domainElement.eClass())) {
                return EmitEventAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getCollectionIteratorAction().isSuperTypeOf(domainElement.eClass())) {
                return CollectionIteratorAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getAcquireAction().isSuperTypeOf(domainElement.eClass())) {
                return AcquireAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getReleaseAction().isSuperTypeOf(domainElement.eClass())) {
                return ReleaseAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getForkAction().isSuperTypeOf(domainElement.eClass())) {
                return ForkAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getSetVariableAction().isSuperTypeOf(domainElement.eClass())) {
                return SetVariableAction2EditPart.VISUAL_ID;
            }
            if (de.uka.ipd.sdq.pcm.seff.seff_reliability.SeffReliabilityPackage.eINSTANCE.getRecoveryAction()
                    .isSuperTypeOf(domainElement.eClass())) {
                return RecoveryAction2EditPart.VISUAL_ID;
            }
            break;
        case SetVariableActionVariableSetterEditPart.VISUAL_ID:
            if (ParameterPackage.eINSTANCE.getVariableUsage().isSuperTypeOf(domainElement.eClass())) {
                return VariableUsage3EditPart.VISUAL_ID;
            }
            break;
        case VariableUsageVariableCharacterisation3EditPart.VISUAL_ID:
            if (ParameterPackage.eINSTANCE.getVariableCharacterisation().isSuperTypeOf(domainElement.eClass())) {
                return VariableCharacterisation5EditPart.VISUAL_ID;
            }
            break;
        case SynchronisationPointSynchronisationPointEditPart.VISUAL_ID:
            if (SeffPackage.eINSTANCE.getForkedBehaviour().isSuperTypeOf(domainElement.eClass())) {
                return ForkedBehaviour2EditPart.VISUAL_ID;
            }
            break;
        case ForkedBehaviourSynchronisationPointForkedBehavioursEditPart.VISUAL_ID:
            if (SeffPackage.eINSTANCE.getStartAction().isSuperTypeOf(domainElement.eClass())) {
                return StartAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getStopAction().isSuperTypeOf(domainElement.eClass())) {
                return StopAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getLoopAction().isSuperTypeOf(domainElement.eClass())) {
                return LoopAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getInternalAction().isSuperTypeOf(domainElement.eClass())) {
                return InternalAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getBranchAction().isSuperTypeOf(domainElement.eClass())) {
                return BranchAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getExternalCallAction().isSuperTypeOf(domainElement.eClass())) {
                return ExternalCallAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getEmitEventAction().isSuperTypeOf(domainElement.eClass())) {
                return EmitEventAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getCollectionIteratorAction().isSuperTypeOf(domainElement.eClass())) {
                return CollectionIteratorAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getAcquireAction().isSuperTypeOf(domainElement.eClass())) {
                return AcquireAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getReleaseAction().isSuperTypeOf(domainElement.eClass())) {
                return ReleaseAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getForkAction().isSuperTypeOf(domainElement.eClass())) {
                return ForkAction2EditPart.VISUAL_ID;
            }
            if (de.uka.ipd.sdq.pcm.seff.seff_reliability.SeffReliabilityPackage.eINSTANCE.getRecoveryAction()
                    .isSuperTypeOf(domainElement.eClass())) {
                return RecoveryAction2EditPart.VISUAL_ID;
            }
            break;
        case ResourceDemandingBehaviourBehaviourCompartment4EditPart.VISUAL_ID:
            if (SeffPackage.eINSTANCE.getStartAction().isSuperTypeOf(domainElement.eClass())) {
                return StartAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getStopAction().isSuperTypeOf(domainElement.eClass())) {
                return StopAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getLoopAction().isSuperTypeOf(domainElement.eClass())) {
                return LoopAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getInternalAction().isSuperTypeOf(domainElement.eClass())) {
                return InternalAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getBranchAction().isSuperTypeOf(domainElement.eClass())) {
                return BranchAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getExternalCallAction().isSuperTypeOf(domainElement.eClass())) {
                return ExternalCallAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getEmitEventAction().isSuperTypeOf(domainElement.eClass())) {
                return EmitEventAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getAcquireAction().isSuperTypeOf(domainElement.eClass())) {
                return AcquireAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getReleaseAction().isSuperTypeOf(domainElement.eClass())) {
                return ReleaseAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getForkAction().isSuperTypeOf(domainElement.eClass())) {
                return ForkAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getCollectionIteratorAction().isSuperTypeOf(domainElement.eClass())) {
                return CollectionIteratorAction2EditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getSetVariableAction().isSuperTypeOf(domainElement.eClass())) {
                return SetVariableAction2EditPart.VISUAL_ID;
            }
            if (de.uka.ipd.sdq.pcm.seff.seff_reliability.SeffReliabilityPackage.eINSTANCE.getRecoveryAction()
                    .isSuperTypeOf(domainElement.eClass())) {
                return RecoveryAction2EditPart.VISUAL_ID;
            }
            break;
        case BranchActionBranchTransitionCompartment2EditPart.VISUAL_ID:
            if (SeffPackage.eINSTANCE.getProbabilisticBranchTransition().isSuperTypeOf(domainElement.eClass())) {
                return ProbabilisticBranchTransitionEditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getGuardedBranchTransition().isSuperTypeOf(domainElement.eClass())) {
                return GuardedBranchTransitionEditPart.VISUAL_ID;
            }
            break;
        case InternalActionResourceDemand2EditPart.VISUAL_ID:
            if (de.uka.ipd.sdq.pcm.seff.seff_performance.SeffPerformancePackage.eINSTANCE.getParametricResourceDemand()
                    .isSuperTypeOf(domainElement.eClass())) {
                return ParametricResourceDemandEditPart.VISUAL_ID;
            }
            break;
        case InternalActionFailureOccurrenceDescriptions2EditPart.VISUAL_ID:
            if (ReliabilityPackage.eINSTANCE.getInternalFailureOccurrenceDescription().isSuperTypeOf(
                    domainElement.eClass())) {
                return InternalFailureOccurrenceDescriptionEditPart.VISUAL_ID;
            }
            break;
        case InternalActionInfrastructureCallsCompartment2EditPart.VISUAL_ID:
            if (de.uka.ipd.sdq.pcm.seff.seff_performance.SeffPerformancePackage.eINSTANCE.getInfrastructureCall()
                    .isSuperTypeOf(domainElement.eClass())) {
                return InfrastructureCallEditPart.VISUAL_ID;
            }
            break;
        case SetVariableActionVariableSetter2EditPart.VISUAL_ID:
            if (ParameterPackage.eINSTANCE.getVariableUsage().isSuperTypeOf(domainElement.eClass())) {
                return VariableUsage3EditPart.VISUAL_ID;
            }
            break;
        case ForkActionForkedBehaviours2EditPart.VISUAL_ID:
            if (SeffPackage.eINSTANCE.getForkedBehaviour().isSuperTypeOf(domainElement.eClass())) {
                return ForkedBehaviourEditPart.VISUAL_ID;
            }
            if (SeffPackage.eINSTANCE.getSynchronisationPoint().isSuperTypeOf(domainElement.eClass())) {
                return SynchronisationPointEditPart.VISUAL_ID;
            }
            break;
        case RecoveryActionRecoveryBlockCompartment2EditPart.VISUAL_ID:
            if (de.uka.ipd.sdq.pcm.seff.seff_reliability.SeffReliabilityPackage.eINSTANCE.getRecoveryActionBehaviour()
                    .isSuperTypeOf(domainElement.eClass())) {
                return RecoveryActionBehaviourEditPart.VISUAL_ID;
            }
            break;
        }
        return -1;
    }

    /**
     * @generated
     */
    public static boolean canCreateNode(View containerView, int nodeVisualID) {
        String containerModelID = de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry
                .getModelID(containerView);
        if (!ResourceDemandingSEFFEditPart.MODEL_ID.equals(containerModelID)) {
            return false;
        }
        int containerVisualID;
        if (ResourceDemandingSEFFEditPart.MODEL_ID.equals(containerModelID)) {
            containerVisualID = de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry
                    .getVisualID(containerView);
        } else {
            if (containerView instanceof Diagram) {
                containerVisualID = ResourceDemandingSEFFEditPart.VISUAL_ID;
            } else {
                return false;
            }
        }
        switch (containerVisualID) {
        case ResourceDemandingSEFFEditPart.VISUAL_ID:
            if (StartActionEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (StopActionEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ExternalCallActionEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (EmitEventActionEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (LoopActionEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (BranchActionEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (InternalActionEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (CollectionIteratorActionEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (SetVariableActionEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (AcquireActionEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ReleaseActionEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ForkActionEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (RecoveryActionEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case ExternalCallActionEditPart.VISUAL_ID:
            if (ExternalCallActionEntityNameEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ExternalCallActionInputVariableUsageEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ExternalCallActionOutputVariableUsageEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case EmitEventActionEditPart.VISUAL_ID:
            if (EmitEventActionEntityNameEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (EmitEventActionInputVariableUsageEventEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case LoopActionEditPart.VISUAL_ID:
            if (LoopActionEntityNameEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (LoopIterationsLabelEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ResourceDemandingBehaviourEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case BranchActionEditPart.VISUAL_ID:
            if (BranchActionEntityNameEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (BranchActionBranchTransitionCompartment2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case InternalActionEditPart.VISUAL_ID:
            if (InternalActionEntityNameEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (InternalActionResourceDemand2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (InternalActionFailureOccurrenceDescriptions2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (InternalActionInfrastructureCallsCompartment2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case CollectionIteratorActionEditPart.VISUAL_ID:
            if (CollectionIteratorActionEntityNameEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (CollectionIteratorParameterLabel2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ResourceDemandingBehaviour3EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case SetVariableActionEditPart.VISUAL_ID:
            if (SetVariableActionEntityNameEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (SetVariableActionVariableSetter2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case AcquireActionEditPart.VISUAL_ID:
            if (AcquireActionEntityNameEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case ReleaseActionEditPart.VISUAL_ID:
            if (ReleaseActionEntityNameEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case ForkActionEditPart.VISUAL_ID:
            if (ForkActionEntityNameEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ForkActionForkedBehaviours2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case RecoveryActionEditPart.VISUAL_ID:
            if (RecoveryActionEntityNameEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (RecoveryActionRecoveryBlockCompartment2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case VariableUsageEditPart.VISUAL_ID:
            if (VariableUsageLabelEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (VariableUsageVariableCharacterisationEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case VariableUsage2EditPart.VISUAL_ID:
            if (WrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (VariableUsageVariableCharacterisation2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case VariableUsage4EditPart.VISUAL_ID:
            if (VariableUsage4LabelEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (VariableUsageVariableCharacterisation4EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case ResourceDemandingBehaviourEditPart.VISUAL_ID:
            if (ResourceDemandingBehaviourBehaviourCompartmentEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case LoopAction2EditPart.VISUAL_ID:
            if (LoopActionEntityName2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (Loop2IterationsLabelEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ResourceDemandingBehaviourEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case InternalAction2EditPart.VISUAL_ID:
            if (InternalActionEntityName2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (InternalActionResourceDemandEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (InternalActionFailureOccurrenceDescriptionsEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (InternalActionInfrastructureCallsCompartmentEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case InfrastructureCallEditPart.VISUAL_ID:
            if (WrappingLabel2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (WrappingLabel3EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (InfrastructureCallInfrastructureCallInputVariableUsagesEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case VariableUsage5EditPart.VISUAL_ID:
            if (VariableUsage5LabelEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (VariableUsageVariableCharacterisation5EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case BranchAction2EditPart.VISUAL_ID:
            if (BranchActionEntityName2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (BranchActionBranchTransitionCompartmentEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case ProbabilisticBranchTransitionEditPart.VISUAL_ID:
            if (ProbabilisticBranchTransitionEntityNameEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ProbabilisticBranchTransitionBranchProbabilityEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ResourceDemandingBehaviour2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case ResourceDemandingBehaviour2EditPart.VISUAL_ID:
            if (ResourceDemandingBehaviourBehaviourCompartment2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case ExternalCallAction2EditPart.VISUAL_ID:
            if (ExternalCallActionEntityName2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ExternalCallActionInputVariableUsage2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ExternalCallActionOutputVariableUsage2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case EmitEventAction2EditPart.VISUAL_ID:
            if (EmitEventActionEntityName2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (EmitEventActionInputVariableUsageEvent2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case AcquireAction2EditPart.VISUAL_ID:
            if (AcquireActionEntityName2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case ReleaseAction2EditPart.VISUAL_ID:
            if (ReleaseActionEntityName2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case ForkAction2EditPart.VISUAL_ID:
            if (ForkActionEntityName2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ForkActionForkedBehavioursEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case ForkedBehaviourEditPart.VISUAL_ID:
            if (ForkedBehaviourBehaviourCompartmentEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case CollectionIteratorAction2EditPart.VISUAL_ID:
            if (CollectionIteratorActionEntityName2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (CollectionIteratorParameterLabelEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ResourceDemandingBehaviour3EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case ResourceDemandingBehaviour3EditPart.VISUAL_ID:
            if (ResourceDemandingBehaviourBehaviourCompartment3EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case RecoveryAction2EditPart.VISUAL_ID:
            if (RecoveryActionEntityName2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (RecoveryActionRecoveryBlockCompartmentEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case RecoveryActionBehaviourEditPart.VISUAL_ID:
            if (RecoveryActionBehaviourEntityNameEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (RecoveryActionBehaviourAlternativeBehaviourCompartmentEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case SetVariableAction2EditPart.VISUAL_ID:
            if (SetVariableActionEntityName2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (SetVariableActionVariableSetterEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case VariableUsage3EditPart.VISUAL_ID:
            if (VariableUsage3LabelEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (VariableUsageVariableCharacterisation3EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case SynchronisationPointEditPart.VISUAL_ID:
            if (SynchronisationPointSynchronisationPointEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case ForkedBehaviour2EditPart.VISUAL_ID:
            if (ForkedBehaviourSynchronisationPointForkedBehavioursEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case GuardedBranchTransitionEditPart.VISUAL_ID:
            if (GuardedBranchTransitionEntityNameEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (GuardedBranchTransitionIdEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ResourceDemandingBehaviour4EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case ResourceDemandingBehaviour4EditPart.VISUAL_ID:
            if (ResourceDemandingBehaviourBehaviourCompartment4EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case ExternalCallActionInputVariableUsageEditPart.VISUAL_ID:
            if (VariableUsageEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case ExternalCallActionOutputVariableUsageEditPart.VISUAL_ID:
            if (VariableUsage2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case VariableUsageVariableCharacterisationEditPart.VISUAL_ID:
            if (VariableCharacterisationEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case VariableUsageVariableCharacterisation2EditPart.VISUAL_ID:
            if (VariableCharacterisation2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case EmitEventActionInputVariableUsageEventEditPart.VISUAL_ID:
            if (VariableUsage4EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case VariableUsageVariableCharacterisation4EditPart.VISUAL_ID:
            if (VariableCharacterisation3EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case ResourceDemandingBehaviourBehaviourCompartmentEditPart.VISUAL_ID:
            if (StartAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (StopAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (LoopAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (InternalAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (BranchAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ExternalCallAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (EmitEventAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (CollectionIteratorAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (AcquireAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ReleaseAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ForkAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (SetVariableAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (RecoveryAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case InternalActionResourceDemandEditPart.VISUAL_ID:
            if (ParametricResourceDemandEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case InternalActionFailureOccurrenceDescriptionsEditPart.VISUAL_ID:
            if (InternalFailureOccurrenceDescriptionEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case InternalActionInfrastructureCallsCompartmentEditPart.VISUAL_ID:
            if (InfrastructureCallEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case InfrastructureCallInfrastructureCallInputVariableUsagesEditPart.VISUAL_ID:
            if (VariableUsage5EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case VariableUsageVariableCharacterisation5EditPart.VISUAL_ID:
            if (VariableCharacterisation4EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case BranchActionBranchTransitionCompartmentEditPart.VISUAL_ID:
            if (ProbabilisticBranchTransitionEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (GuardedBranchTransitionEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case ResourceDemandingBehaviourBehaviourCompartment2EditPart.VISUAL_ID:
            if (StartAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (StopAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (LoopAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (InternalAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (BranchAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ExternalCallAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (EmitEventAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (AcquireAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ReleaseAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ForkAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (CollectionIteratorAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (SetVariableAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (RecoveryAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case ExternalCallActionInputVariableUsage2EditPart.VISUAL_ID:
            if (VariableUsageEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case ExternalCallActionOutputVariableUsage2EditPart.VISUAL_ID:
            if (VariableUsage2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case EmitEventActionInputVariableUsageEvent2EditPart.VISUAL_ID:
            if (VariableUsage4EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case ForkActionForkedBehavioursEditPart.VISUAL_ID:
            if (ForkedBehaviourEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (SynchronisationPointEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case ForkedBehaviourBehaviourCompartmentEditPart.VISUAL_ID:
            if (StartAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (StopAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (LoopAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (InternalAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (BranchAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ExternalCallAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (EmitEventAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (CollectionIteratorAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (AcquireAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ReleaseAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ForkAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (RecoveryAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case ResourceDemandingBehaviourBehaviourCompartment3EditPart.VISUAL_ID:
            if (StartAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (StopAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (LoopAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (InternalAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (BranchAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ExternalCallAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (EmitEventAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (CollectionIteratorAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (AcquireAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ReleaseAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ForkAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (RecoveryAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case RecoveryActionRecoveryBlockCompartmentEditPart.VISUAL_ID:
            if (RecoveryActionBehaviourEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case RecoveryActionBehaviourAlternativeBehaviourCompartmentEditPart.VISUAL_ID:
            if (StartAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (StopAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (LoopAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (InternalAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (BranchAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ExternalCallAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (EmitEventAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (CollectionIteratorAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (AcquireAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ReleaseAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ForkAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (SetVariableAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (RecoveryAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case SetVariableActionVariableSetterEditPart.VISUAL_ID:
            if (VariableUsage3EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case VariableUsageVariableCharacterisation3EditPart.VISUAL_ID:
            if (VariableCharacterisation5EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case SynchronisationPointSynchronisationPointEditPart.VISUAL_ID:
            if (ForkedBehaviour2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case ForkedBehaviourSynchronisationPointForkedBehavioursEditPart.VISUAL_ID:
            if (StartAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (StopAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (LoopAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (InternalAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (BranchAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ExternalCallAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (EmitEventAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (CollectionIteratorAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (AcquireAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ReleaseAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ForkAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (RecoveryAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case ResourceDemandingBehaviourBehaviourCompartment4EditPart.VISUAL_ID:
            if (StartAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (StopAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (LoopAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (InternalAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (BranchAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ExternalCallAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (EmitEventAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (AcquireAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ReleaseAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (ForkAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (CollectionIteratorAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (SetVariableAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (RecoveryAction2EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case BranchActionBranchTransitionCompartment2EditPart.VISUAL_ID:
            if (ProbabilisticBranchTransitionEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (GuardedBranchTransitionEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case InternalActionResourceDemand2EditPart.VISUAL_ID:
            if (ParametricResourceDemandEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case InternalActionFailureOccurrenceDescriptions2EditPart.VISUAL_ID:
            if (InternalFailureOccurrenceDescriptionEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case InternalActionInfrastructureCallsCompartment2EditPart.VISUAL_ID:
            if (InfrastructureCallEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case SetVariableActionVariableSetter2EditPart.VISUAL_ID:
            if (VariableUsage3EditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case ForkActionForkedBehaviours2EditPart.VISUAL_ID:
            if (ForkedBehaviourEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            if (SynchronisationPointEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        case RecoveryActionRecoveryBlockCompartment2EditPart.VISUAL_ID:
            if (RecoveryActionBehaviourEditPart.VISUAL_ID == nodeVisualID) {
                return true;
            }
            break;
        }
        return false;
    }

    /**
     * @generated
     */
    public static int getLinkWithClassVisualID(EObject domainElement) {
        if (domainElement == null) {
            return -1;
        }
        return -1;
    }

    /**
     * @generated
     */
    private static boolean isDiagram(ResourceDemandingSEFF element) {
        return true;
    }

    /**
     * @generated
     */
    public static boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
        if (candidate == -1) {
            //unrecognized id is always bad
            return false;
        }
        int basic = getNodeVisualID(containerView, domainElement);
        return basic == candidate;
    }

    /**
     * @generated
     */
    public static boolean isCompartmentVisualID(int visualID) {
        switch (visualID) {
        case ExternalCallActionInputVariableUsageEditPart.VISUAL_ID:
        case ExternalCallActionOutputVariableUsageEditPart.VISUAL_ID:
        case VariableUsageVariableCharacterisationEditPart.VISUAL_ID:
        case VariableUsageVariableCharacterisation2EditPart.VISUAL_ID:
        case EmitEventActionInputVariableUsageEventEditPart.VISUAL_ID:
        case VariableUsageVariableCharacterisation4EditPart.VISUAL_ID:
        case ResourceDemandingBehaviourBehaviourCompartmentEditPart.VISUAL_ID:
        case InternalActionResourceDemandEditPart.VISUAL_ID:
        case InternalActionFailureOccurrenceDescriptionsEditPart.VISUAL_ID:
        case InternalActionInfrastructureCallsCompartmentEditPart.VISUAL_ID:
        case InfrastructureCallInfrastructureCallInputVariableUsagesEditPart.VISUAL_ID:
        case VariableUsageVariableCharacterisation5EditPart.VISUAL_ID:
        case BranchActionBranchTransitionCompartmentEditPart.VISUAL_ID:
        case ResourceDemandingBehaviourBehaviourCompartment2EditPart.VISUAL_ID:
        case ExternalCallActionInputVariableUsage2EditPart.VISUAL_ID:
        case ExternalCallActionOutputVariableUsage2EditPart.VISUAL_ID:
        case EmitEventActionInputVariableUsageEvent2EditPart.VISUAL_ID:
        case ForkActionForkedBehavioursEditPart.VISUAL_ID:
        case ForkedBehaviourBehaviourCompartmentEditPart.VISUAL_ID:
        case ResourceDemandingBehaviourBehaviourCompartment3EditPart.VISUAL_ID:
        case RecoveryActionRecoveryBlockCompartmentEditPart.VISUAL_ID:
        case RecoveryActionBehaviourAlternativeBehaviourCompartmentEditPart.VISUAL_ID:
        case SetVariableActionVariableSetterEditPart.VISUAL_ID:
        case VariableUsageVariableCharacterisation3EditPart.VISUAL_ID:
        case SynchronisationPointSynchronisationPointEditPart.VISUAL_ID:
        case ForkedBehaviourSynchronisationPointForkedBehavioursEditPart.VISUAL_ID:
        case ResourceDemandingBehaviourBehaviourCompartment4EditPart.VISUAL_ID:
        case BranchActionBranchTransitionCompartment2EditPart.VISUAL_ID:
        case InternalActionResourceDemand2EditPart.VISUAL_ID:
        case InternalActionFailureOccurrenceDescriptions2EditPart.VISUAL_ID:
        case InternalActionInfrastructureCallsCompartment2EditPart.VISUAL_ID:
        case SetVariableActionVariableSetter2EditPart.VISUAL_ID:
        case ForkActionForkedBehaviours2EditPart.VISUAL_ID:
        case RecoveryActionRecoveryBlockCompartment2EditPart.VISUAL_ID:
            return true;
        default:
            break;
        }
        return false;
    }

    /**
     * @generated
     */
    public static boolean isSemanticLeafVisualID(int visualID) {
        switch (visualID) {
        case ResourceDemandingSEFFEditPart.VISUAL_ID:
            return false;
        case StartActionEditPart.VISUAL_ID:
        case StopActionEditPart.VISUAL_ID:
        case ReleaseActionEditPart.VISUAL_ID:
        case AcquireActionEditPart.VISUAL_ID:
        case StartAction2EditPart.VISUAL_ID:
        case StopAction2EditPart.VISUAL_ID:
        case ReleaseAction2EditPart.VISUAL_ID:
        case AcquireAction2EditPart.VISUAL_ID:
        case VariableCharacterisationEditPart.VISUAL_ID:
        case VariableCharacterisation2EditPart.VISUAL_ID:
        case VariableCharacterisation3EditPart.VISUAL_ID:
        case VariableCharacterisation4EditPart.VISUAL_ID:
        case InternalFailureOccurrenceDescriptionEditPart.VISUAL_ID:
        case ParametricResourceDemandEditPart.VISUAL_ID:
        case VariableCharacterisation5EditPart.VISUAL_ID:
            return true;
        default:
            break;
        }
        return false;
    }

    /**
     * @generated
     */
    public static final DiagramStructure TYPED_INSTANCE = new DiagramStructure() {
        /**
         * @generated
         */
        @Override
        public int getVisualID(View view) {
            return de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry.getVisualID(view);
        }

        /**
         * @generated
         */
        @Override
        public String getModelID(View view) {
            return de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry.getModelID(view);
        }

        /**
         * @generated
         */
        @Override
        public int getNodeVisualID(View containerView, EObject domainElement) {
            return de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry.getNodeVisualID(
                    containerView, domainElement);
        }

        /**
         * @generated
         */
        @Override
        public boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
            return de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry.checkNodeVisualID(
                    containerView, domainElement, candidate);
        }

        /**
         * @generated
         */
        @Override
        public boolean isCompartmentVisualID(int visualID) {
            return de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry
                    .isCompartmentVisualID(visualID);
        }

        /**
         * @generated
         */
        @Override
        public boolean isSemanticLeafVisualID(int visualID) {
            return de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry
                    .isSemanticLeafVisualID(visualID);
        }
    };
}
