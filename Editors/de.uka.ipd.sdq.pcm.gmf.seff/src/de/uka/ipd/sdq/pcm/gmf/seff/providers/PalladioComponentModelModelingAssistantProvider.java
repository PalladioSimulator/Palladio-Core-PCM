/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

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
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkActionForkedBehaviours2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkActionForkedBehavioursEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkedBehaviourBehaviourCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkedBehaviourSynchronisationPointForkedBehavioursEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.GuardedBranchTransitionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InfrastructureCallEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InfrastructureCallInfrastructureCallInputVariableUsagesEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ProbabilisticBranchTransitionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.RecoveryAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.RecoveryActionBehaviourAlternativeBehaviourCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.RecoveryActionBehaviourEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.RecoveryActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.RecoveryActionRecoveryBlockCompartment2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.RecoveryActionRecoveryBlockCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ReleaseAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ReleaseActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourBehaviourCompartment2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourBehaviourCompartment3EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourBehaviourCompartment4EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourBehaviourCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingSEFFEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SetVariableAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SetVariableActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StartAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StartActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StopAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StopActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SynchronisationPointSynchronisationPointEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsage2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsage3EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsage4EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsage5EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.part.Messages;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelSeffDiagramEditorPlugin;

/**
 * @generated
 */
public class PalladioComponentModelModelingAssistantProvider extends ModelingAssistantProvider {

    /**
     * @generated
     */
    public List getTypesForPopupBar(IAdaptable host) {
        IGraphicalEditPart editPart = (IGraphicalEditPart) host.getAdapter(IGraphicalEditPart.class);
        if (editPart instanceof ResourceDemandingSEFFEditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(13);
            types.add(PalladioComponentModelElementTypes.StartAction_2001);
            types.add(PalladioComponentModelElementTypes.StopAction_2002);
            types.add(PalladioComponentModelElementTypes.ExternalCallAction_2003);
            types.add(PalladioComponentModelElementTypes.EmitEventAction_2013);
            types.add(PalladioComponentModelElementTypes.LoopAction_2004);
            types.add(PalladioComponentModelElementTypes.BranchAction_2005);
            types.add(PalladioComponentModelElementTypes.InternalAction_2006);
            types.add(PalladioComponentModelElementTypes.CollectionIteratorAction_2007);
            types.add(PalladioComponentModelElementTypes.SetVariableAction_2008);
            types.add(PalladioComponentModelElementTypes.AcquireAction_2012);
            types.add(PalladioComponentModelElementTypes.ReleaseAction_2010);
            types.add(PalladioComponentModelElementTypes.ForkAction_2011);
            types.add(PalladioComponentModelElementTypes.RecoveryAction_2017);
            return types;
        }
        if (editPart instanceof ExternalCallActionEditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(2);
            types.add(PalladioComponentModelElementTypes.VariableUsage_3042);
            types.add(PalladioComponentModelElementTypes.VariableUsage_3049);
            return types;
        }
        if (editPart instanceof EmitEventActionEditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(1);
            types.add(PalladioComponentModelElementTypes.VariableUsage_3047);
            return types;
        }
        if (editPart instanceof LoopActionEditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(1);
            types.add(PalladioComponentModelElementTypes.ResourceDemandingBehaviour_3003);
            return types;
        }
        if (editPart instanceof InternalActionEditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(3);
            types.add(PalladioComponentModelElementTypes.ParametricResourceDemand_3051);
            types.add(PalladioComponentModelElementTypes.InternalFailureOccurrenceDescription_3050);
            types.add(PalladioComponentModelElementTypes.InfrastructureCall_3053);
            return types;
        }
        if (editPart instanceof CollectionIteratorActionEditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(1);
            types.add(PalladioComponentModelElementTypes.ResourceDemandingBehaviour_3014);
            return types;
        }
        if (editPart instanceof SetVariableActionEditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(1);
            types.add(PalladioComponentModelElementTypes.VariableUsage_3036);
            return types;
        }
        if (editPart instanceof VariableUsageEditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(1);
            types.add(PalladioComponentModelElementTypes.VariableCharacterisation_3033);
            return types;
        }
        if (editPart instanceof VariableUsage2EditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(1);
            types.add(PalladioComponentModelElementTypes.VariableCharacterisation_3035);
            return types;
        }
        if (editPart instanceof VariableUsage4EditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(1);
            types.add(PalladioComponentModelElementTypes.VariableCharacterisation_3037);
            return types;
        }
        if (editPart instanceof LoopAction2EditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(1);
            types.add(PalladioComponentModelElementTypes.ResourceDemandingBehaviour_3003);
            return types;
        }
        if (editPart instanceof InternalAction2EditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(3);
            types.add(PalladioComponentModelElementTypes.ParametricResourceDemand_3051);
            types.add(PalladioComponentModelElementTypes.InternalFailureOccurrenceDescription_3050);
            types.add(PalladioComponentModelElementTypes.InfrastructureCall_3053);
            return types;
        }
        if (editPart instanceof VariableUsage5EditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(1);
            types.add(PalladioComponentModelElementTypes.VariableCharacterisation_3048);
            return types;
        }
        if (editPart instanceof ProbabilisticBranchTransitionEditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(1);
            types.add(PalladioComponentModelElementTypes.ResourceDemandingBehaviour_3011);
            return types;
        }
        if (editPart instanceof ExternalCallAction2EditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(2);
            types.add(PalladioComponentModelElementTypes.VariableUsage_3042);
            types.add(PalladioComponentModelElementTypes.VariableUsage_3049);
            return types;
        }
        if (editPart instanceof EmitEventAction2EditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(1);
            types.add(PalladioComponentModelElementTypes.VariableUsage_3047);
            return types;
        }
        if (editPart instanceof CollectionIteratorAction2EditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(1);
            types.add(PalladioComponentModelElementTypes.ResourceDemandingBehaviour_3014);
            return types;
        }
        if (editPart instanceof SetVariableAction2EditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(1);
            types.add(PalladioComponentModelElementTypes.VariableUsage_3036);
            return types;
        }
        if (editPart instanceof VariableUsage3EditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(1);
            types.add(PalladioComponentModelElementTypes.VariableCharacterisation_3055);
            return types;
        }
        if (editPart instanceof GuardedBranchTransitionEditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(1);
            types.add(PalladioComponentModelElementTypes.ResourceDemandingBehaviour_3018);
            return types;
        }
        if (editPart instanceof ResourceDemandingBehaviourBehaviourCompartmentEditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(13);
            types.add(PalladioComponentModelElementTypes.StartAction_3004);
            types.add(PalladioComponentModelElementTypes.StopAction_3005);
            types.add(PalladioComponentModelElementTypes.LoopAction_3006);
            types.add(PalladioComponentModelElementTypes.InternalAction_3007);
            types.add(PalladioComponentModelElementTypes.BranchAction_3009);
            types.add(PalladioComponentModelElementTypes.ExternalCallAction_3012);
            types.add(PalladioComponentModelElementTypes.EmitEventAction_3046);
            types.add(PalladioComponentModelElementTypes.CollectionIteratorAction_3013);
            types.add(PalladioComponentModelElementTypes.AcquireAction_3026);
            types.add(PalladioComponentModelElementTypes.ReleaseAction_3020);
            types.add(PalladioComponentModelElementTypes.ForkAction_3023);
            types.add(PalladioComponentModelElementTypes.SetVariableAction_3024);
            types.add(PalladioComponentModelElementTypes.RecoveryAction_3061);
            return types;
        }
        if (editPart instanceof InfrastructureCallInfrastructureCallInputVariableUsagesEditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(1);
            types.add(PalladioComponentModelElementTypes.VariableUsage_3054);
            return types;
        }
        if (editPart instanceof BranchActionBranchTransitionCompartmentEditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(2);
            types.add(PalladioComponentModelElementTypes.ProbabilisticBranchTransition_3010);
            types.add(PalladioComponentModelElementTypes.GuardedBranchTransition_3017);
            return types;
        }
        if (editPart instanceof ResourceDemandingBehaviourBehaviourCompartment2EditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(13);
            types.add(PalladioComponentModelElementTypes.StartAction_3004);
            types.add(PalladioComponentModelElementTypes.StopAction_3005);
            types.add(PalladioComponentModelElementTypes.LoopAction_3006);
            types.add(PalladioComponentModelElementTypes.InternalAction_3007);
            types.add(PalladioComponentModelElementTypes.BranchAction_3009);
            types.add(PalladioComponentModelElementTypes.ExternalCallAction_3012);
            types.add(PalladioComponentModelElementTypes.EmitEventAction_3046);
            types.add(PalladioComponentModelElementTypes.AcquireAction_3026);
            types.add(PalladioComponentModelElementTypes.ReleaseAction_3020);
            types.add(PalladioComponentModelElementTypes.ForkAction_3023);
            types.add(PalladioComponentModelElementTypes.CollectionIteratorAction_3013);
            types.add(PalladioComponentModelElementTypes.SetVariableAction_3024);
            types.add(PalladioComponentModelElementTypes.RecoveryAction_3061);
            return types;
        }
        if (editPart instanceof ForkActionForkedBehavioursEditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(2);
            types.add(PalladioComponentModelElementTypes.ForkedBehaviour_3027);
            types.add(PalladioComponentModelElementTypes.SynchronisationPoint_3038);
            return types;
        }
        if (editPart instanceof ForkedBehaviourBehaviourCompartmentEditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(12);
            types.add(PalladioComponentModelElementTypes.StartAction_3004);
            types.add(PalladioComponentModelElementTypes.StopAction_3005);
            types.add(PalladioComponentModelElementTypes.LoopAction_3006);
            types.add(PalladioComponentModelElementTypes.InternalAction_3007);
            types.add(PalladioComponentModelElementTypes.BranchAction_3009);
            types.add(PalladioComponentModelElementTypes.ExternalCallAction_3012);
            types.add(PalladioComponentModelElementTypes.EmitEventAction_3046);
            types.add(PalladioComponentModelElementTypes.CollectionIteratorAction_3013);
            types.add(PalladioComponentModelElementTypes.AcquireAction_3026);
            types.add(PalladioComponentModelElementTypes.ReleaseAction_3020);
            types.add(PalladioComponentModelElementTypes.ForkAction_3023);
            types.add(PalladioComponentModelElementTypes.RecoveryAction_3061);
            return types;
        }
        if (editPart instanceof ResourceDemandingBehaviourBehaviourCompartment3EditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(12);
            types.add(PalladioComponentModelElementTypes.StartAction_3004);
            types.add(PalladioComponentModelElementTypes.StopAction_3005);
            types.add(PalladioComponentModelElementTypes.LoopAction_3006);
            types.add(PalladioComponentModelElementTypes.InternalAction_3007);
            types.add(PalladioComponentModelElementTypes.BranchAction_3009);
            types.add(PalladioComponentModelElementTypes.ExternalCallAction_3012);
            types.add(PalladioComponentModelElementTypes.EmitEventAction_3046);
            types.add(PalladioComponentModelElementTypes.CollectionIteratorAction_3013);
            types.add(PalladioComponentModelElementTypes.AcquireAction_3026);
            types.add(PalladioComponentModelElementTypes.ReleaseAction_3020);
            types.add(PalladioComponentModelElementTypes.ForkAction_3023);
            types.add(PalladioComponentModelElementTypes.RecoveryAction_3061);
            return types;
        }
        if (editPart instanceof RecoveryActionRecoveryBlockCompartmentEditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(1);
            types.add(PalladioComponentModelElementTypes.RecoveryActionBehaviour_3062);
            return types;
        }
        if (editPart instanceof RecoveryActionBehaviourAlternativeBehaviourCompartmentEditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(13);
            types.add(PalladioComponentModelElementTypes.StartAction_3004);
            types.add(PalladioComponentModelElementTypes.StopAction_3005);
            types.add(PalladioComponentModelElementTypes.LoopAction_3006);
            types.add(PalladioComponentModelElementTypes.InternalAction_3007);
            types.add(PalladioComponentModelElementTypes.BranchAction_3009);
            types.add(PalladioComponentModelElementTypes.ExternalCallAction_3012);
            types.add(PalladioComponentModelElementTypes.EmitEventAction_3046);
            types.add(PalladioComponentModelElementTypes.CollectionIteratorAction_3013);
            types.add(PalladioComponentModelElementTypes.AcquireAction_3026);
            types.add(PalladioComponentModelElementTypes.ReleaseAction_3020);
            types.add(PalladioComponentModelElementTypes.ForkAction_3023);
            types.add(PalladioComponentModelElementTypes.SetVariableAction_3024);
            types.add(PalladioComponentModelElementTypes.RecoveryAction_3061);
            return types;
        }
        if (editPart instanceof SynchronisationPointSynchronisationPointEditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(1);
            types.add(PalladioComponentModelElementTypes.ForkedBehaviour_3039);
            return types;
        }
        if (editPart instanceof ForkedBehaviourSynchronisationPointForkedBehavioursEditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(12);
            types.add(PalladioComponentModelElementTypes.StartAction_3004);
            types.add(PalladioComponentModelElementTypes.StopAction_3005);
            types.add(PalladioComponentModelElementTypes.LoopAction_3006);
            types.add(PalladioComponentModelElementTypes.InternalAction_3007);
            types.add(PalladioComponentModelElementTypes.BranchAction_3009);
            types.add(PalladioComponentModelElementTypes.ExternalCallAction_3012);
            types.add(PalladioComponentModelElementTypes.EmitEventAction_3046);
            types.add(PalladioComponentModelElementTypes.CollectionIteratorAction_3013);
            types.add(PalladioComponentModelElementTypes.AcquireAction_3026);
            types.add(PalladioComponentModelElementTypes.ReleaseAction_3020);
            types.add(PalladioComponentModelElementTypes.ForkAction_3023);
            types.add(PalladioComponentModelElementTypes.RecoveryAction_3061);
            return types;
        }
        if (editPart instanceof ResourceDemandingBehaviourBehaviourCompartment4EditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(13);
            types.add(PalladioComponentModelElementTypes.StartAction_3004);
            types.add(PalladioComponentModelElementTypes.StopAction_3005);
            types.add(PalladioComponentModelElementTypes.LoopAction_3006);
            types.add(PalladioComponentModelElementTypes.InternalAction_3007);
            types.add(PalladioComponentModelElementTypes.BranchAction_3009);
            types.add(PalladioComponentModelElementTypes.ExternalCallAction_3012);
            types.add(PalladioComponentModelElementTypes.EmitEventAction_3046);
            types.add(PalladioComponentModelElementTypes.AcquireAction_3026);
            types.add(PalladioComponentModelElementTypes.ReleaseAction_3020);
            types.add(PalladioComponentModelElementTypes.ForkAction_3023);
            types.add(PalladioComponentModelElementTypes.CollectionIteratorAction_3013);
            types.add(PalladioComponentModelElementTypes.SetVariableAction_3024);
            types.add(PalladioComponentModelElementTypes.RecoveryAction_3061);
            return types;
        }
        if (editPart instanceof BranchActionBranchTransitionCompartment2EditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(2);
            types.add(PalladioComponentModelElementTypes.ProbabilisticBranchTransition_3010);
            types.add(PalladioComponentModelElementTypes.GuardedBranchTransition_3017);
            return types;
        }
        if (editPart instanceof ForkActionForkedBehaviours2EditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(2);
            types.add(PalladioComponentModelElementTypes.ForkedBehaviour_3027);
            types.add(PalladioComponentModelElementTypes.SynchronisationPoint_3038);
            return types;
        }
        if (editPart instanceof RecoveryActionRecoveryBlockCompartment2EditPart) {
            ArrayList<IElementType> types = new ArrayList<IElementType>(1);
            types.add(PalladioComponentModelElementTypes.RecoveryActionBehaviour_3062);
            return types;
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public List getRelTypesOnSource(IAdaptable source) {
        IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
        if (sourceEditPart instanceof StartActionEditPart) {
            return ((StartActionEditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof StopActionEditPart) {
            return ((StopActionEditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof ExternalCallActionEditPart) {
            return ((ExternalCallActionEditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof EmitEventActionEditPart) {
            return ((EmitEventActionEditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof LoopActionEditPart) {
            return ((LoopActionEditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof BranchActionEditPart) {
            return ((BranchActionEditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof InternalActionEditPart) {
            return ((InternalActionEditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof CollectionIteratorActionEditPart) {
            return ((CollectionIteratorActionEditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof SetVariableActionEditPart) {
            return ((SetVariableActionEditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof AcquireActionEditPart) {
            return ((AcquireActionEditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof ReleaseActionEditPart) {
            return ((ReleaseActionEditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof ForkActionEditPart) {
            return ((ForkActionEditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof RecoveryActionEditPart) {
            return ((RecoveryActionEditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof StartAction2EditPart) {
            return ((StartAction2EditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof StopAction2EditPart) {
            return ((StopAction2EditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof LoopAction2EditPart) {
            return ((LoopAction2EditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof InternalAction2EditPart) {
            return ((InternalAction2EditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof BranchAction2EditPart) {
            return ((BranchAction2EditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof ExternalCallAction2EditPart) {
            return ((ExternalCallAction2EditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof EmitEventAction2EditPart) {
            return ((EmitEventAction2EditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof AcquireAction2EditPart) {
            return ((AcquireAction2EditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof ReleaseAction2EditPart) {
            return ((ReleaseAction2EditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof ForkAction2EditPart) {
            return ((ForkAction2EditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof CollectionIteratorAction2EditPart) {
            return ((CollectionIteratorAction2EditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof RecoveryAction2EditPart) {
            return ((RecoveryAction2EditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof RecoveryActionBehaviourEditPart) {
            return ((RecoveryActionBehaviourEditPart) sourceEditPart).getMARelTypesOnSource();
        }
        if (sourceEditPart instanceof SetVariableAction2EditPart) {
            return ((SetVariableAction2EditPart) sourceEditPart).getMARelTypesOnSource();
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public List getRelTypesOnTarget(IAdaptable target) {
        IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
        if (targetEditPart instanceof StartActionEditPart) {
            return ((StartActionEditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof StopActionEditPart) {
            return ((StopActionEditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof ExternalCallActionEditPart) {
            return ((ExternalCallActionEditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof EmitEventActionEditPart) {
            return ((EmitEventActionEditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof LoopActionEditPart) {
            return ((LoopActionEditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof BranchActionEditPart) {
            return ((BranchActionEditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof InternalActionEditPart) {
            return ((InternalActionEditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof CollectionIteratorActionEditPart) {
            return ((CollectionIteratorActionEditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof SetVariableActionEditPart) {
            return ((SetVariableActionEditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof AcquireActionEditPart) {
            return ((AcquireActionEditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof ReleaseActionEditPart) {
            return ((ReleaseActionEditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof ForkActionEditPart) {
            return ((ForkActionEditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof RecoveryActionEditPart) {
            return ((RecoveryActionEditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof StartAction2EditPart) {
            return ((StartAction2EditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof StopAction2EditPart) {
            return ((StopAction2EditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof LoopAction2EditPart) {
            return ((LoopAction2EditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof InternalAction2EditPart) {
            return ((InternalAction2EditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof BranchAction2EditPart) {
            return ((BranchAction2EditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof ExternalCallAction2EditPart) {
            return ((ExternalCallAction2EditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof EmitEventAction2EditPart) {
            return ((EmitEventAction2EditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof AcquireAction2EditPart) {
            return ((AcquireAction2EditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof ReleaseAction2EditPart) {
            return ((ReleaseAction2EditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof ForkAction2EditPart) {
            return ((ForkAction2EditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof CollectionIteratorAction2EditPart) {
            return ((CollectionIteratorAction2EditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof RecoveryAction2EditPart) {
            return ((RecoveryAction2EditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof RecoveryActionBehaviourEditPart) {
            return ((RecoveryActionBehaviourEditPart) targetEditPart).getMARelTypesOnTarget();
        }
        if (targetEditPart instanceof SetVariableAction2EditPart) {
            return ((SetVariableAction2EditPart) targetEditPart).getMARelTypesOnTarget();
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
        IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
        IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
        if (sourceEditPart instanceof StartActionEditPart) {
            return ((StartActionEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof StopActionEditPart) {
            return ((StopActionEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof ExternalCallActionEditPart) {
            return ((ExternalCallActionEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof EmitEventActionEditPart) {
            return ((EmitEventActionEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof LoopActionEditPart) {
            return ((LoopActionEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof BranchActionEditPart) {
            return ((BranchActionEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof InternalActionEditPart) {
            return ((InternalActionEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof CollectionIteratorActionEditPart) {
            return ((CollectionIteratorActionEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof SetVariableActionEditPart) {
            return ((SetVariableActionEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof AcquireActionEditPart) {
            return ((AcquireActionEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof ReleaseActionEditPart) {
            return ((ReleaseActionEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof ForkActionEditPart) {
            return ((ForkActionEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof RecoveryActionEditPart) {
            return ((RecoveryActionEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof StartAction2EditPart) {
            return ((StartAction2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof StopAction2EditPart) {
            return ((StopAction2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof LoopAction2EditPart) {
            return ((LoopAction2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof InternalAction2EditPart) {
            return ((InternalAction2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof BranchAction2EditPart) {
            return ((BranchAction2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof ExternalCallAction2EditPart) {
            return ((ExternalCallAction2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof EmitEventAction2EditPart) {
            return ((EmitEventAction2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof AcquireAction2EditPart) {
            return ((AcquireAction2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof ReleaseAction2EditPart) {
            return ((ReleaseAction2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof ForkAction2EditPart) {
            return ((ForkAction2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof CollectionIteratorAction2EditPart) {
            return ((CollectionIteratorAction2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof RecoveryAction2EditPart) {
            return ((RecoveryAction2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof RecoveryActionBehaviourEditPart) {
            return ((RecoveryActionBehaviourEditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        if (sourceEditPart instanceof SetVariableAction2EditPart) {
            return ((SetVariableAction2EditPart) sourceEditPart).getMARelTypesOnSourceAndTarget(targetEditPart);
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public List getTypesForSource(IAdaptable target, IElementType relationshipType) {
        IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
        if (targetEditPart instanceof StartActionEditPart) {
            return ((StartActionEditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof StopActionEditPart) {
            return ((StopActionEditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof ExternalCallActionEditPart) {
            return ((ExternalCallActionEditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof EmitEventActionEditPart) {
            return ((EmitEventActionEditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof LoopActionEditPart) {
            return ((LoopActionEditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof BranchActionEditPart) {
            return ((BranchActionEditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof InternalActionEditPart) {
            return ((InternalActionEditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof CollectionIteratorActionEditPart) {
            return ((CollectionIteratorActionEditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof SetVariableActionEditPart) {
            return ((SetVariableActionEditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof AcquireActionEditPart) {
            return ((AcquireActionEditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof ReleaseActionEditPart) {
            return ((ReleaseActionEditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof ForkActionEditPart) {
            return ((ForkActionEditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof RecoveryActionEditPart) {
            return ((RecoveryActionEditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof StartAction2EditPart) {
            return ((StartAction2EditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof StopAction2EditPart) {
            return ((StopAction2EditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof LoopAction2EditPart) {
            return ((LoopAction2EditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof InternalAction2EditPart) {
            return ((InternalAction2EditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof BranchAction2EditPart) {
            return ((BranchAction2EditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof ExternalCallAction2EditPart) {
            return ((ExternalCallAction2EditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof EmitEventAction2EditPart) {
            return ((EmitEventAction2EditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof AcquireAction2EditPart) {
            return ((AcquireAction2EditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof ReleaseAction2EditPart) {
            return ((ReleaseAction2EditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof ForkAction2EditPart) {
            return ((ForkAction2EditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof CollectionIteratorAction2EditPart) {
            return ((CollectionIteratorAction2EditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof RecoveryAction2EditPart) {
            return ((RecoveryAction2EditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof RecoveryActionBehaviourEditPart) {
            return ((RecoveryActionBehaviourEditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        if (targetEditPart instanceof SetVariableAction2EditPart) {
            return ((SetVariableAction2EditPart) targetEditPart).getMATypesForSource(relationshipType);
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public List getTypesForTarget(IAdaptable source, IElementType relationshipType) {
        IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
        if (sourceEditPart instanceof StartActionEditPart) {
            return ((StartActionEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof StopActionEditPart) {
            return ((StopActionEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof ExternalCallActionEditPart) {
            return ((ExternalCallActionEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof EmitEventActionEditPart) {
            return ((EmitEventActionEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof LoopActionEditPart) {
            return ((LoopActionEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof BranchActionEditPart) {
            return ((BranchActionEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof InternalActionEditPart) {
            return ((InternalActionEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof CollectionIteratorActionEditPart) {
            return ((CollectionIteratorActionEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof SetVariableActionEditPart) {
            return ((SetVariableActionEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof AcquireActionEditPart) {
            return ((AcquireActionEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof ReleaseActionEditPart) {
            return ((ReleaseActionEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof ForkActionEditPart) {
            return ((ForkActionEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof RecoveryActionEditPart) {
            return ((RecoveryActionEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof StartAction2EditPart) {
            return ((StartAction2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof StopAction2EditPart) {
            return ((StopAction2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof LoopAction2EditPart) {
            return ((LoopAction2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof InternalAction2EditPart) {
            return ((InternalAction2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof BranchAction2EditPart) {
            return ((BranchAction2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof ExternalCallAction2EditPart) {
            return ((ExternalCallAction2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof EmitEventAction2EditPart) {
            return ((EmitEventAction2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof AcquireAction2EditPart) {
            return ((AcquireAction2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof ReleaseAction2EditPart) {
            return ((ReleaseAction2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof ForkAction2EditPart) {
            return ((ForkAction2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof CollectionIteratorAction2EditPart) {
            return ((CollectionIteratorAction2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof RecoveryAction2EditPart) {
            return ((RecoveryAction2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof RecoveryActionBehaviourEditPart) {
            return ((RecoveryActionBehaviourEditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        if (sourceEditPart instanceof SetVariableAction2EditPart) {
            return ((SetVariableAction2EditPart) sourceEditPart).getMATypesForTarget(relationshipType);
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * @generated
     */
    public EObject selectExistingElementForSource(IAdaptable target, IElementType relationshipType) {
        return selectExistingElement(target, getTypesForSource(target, relationshipType));
    }

    /**
     * @generated
     */
    public EObject selectExistingElementForTarget(IAdaptable source, IElementType relationshipType) {
        return selectExistingElement(source, getTypesForTarget(source, relationshipType));
    }

    /**
     * @generated
     */
    protected EObject selectExistingElement(IAdaptable host, Collection types) {
        if (types.isEmpty()) {
            return null;
        }
        IGraphicalEditPart editPart = (IGraphicalEditPart) host.getAdapter(IGraphicalEditPart.class);
        if (editPart == null) {
            return null;
        }
        Diagram diagram = (Diagram) editPart.getRoot().getContents().getModel();
        HashSet<EObject> elements = new HashSet<EObject>();
        for (Iterator<EObject> it = diagram.getElement().eAllContents(); it.hasNext();) {
            EObject element = it.next();
            if (isApplicableElement(element, types)) {
                elements.add(element);
            }
        }
        if (elements.isEmpty()) {
            return null;
        }
        return selectElement((EObject[]) elements.toArray(new EObject[elements.size()]));
    }

    /**
     * @generated
     */
    protected boolean isApplicableElement(EObject element, Collection types) {
        IElementType type = ElementTypeRegistry.getInstance().getElementType(element);
        return types.contains(type);
    }

    /**
     * @generated
     */
    protected EObject selectElement(EObject[] elements) {
        Shell shell = Display.getCurrent().getActiveShell();
        ILabelProvider labelProvider = new AdapterFactoryLabelProvider(PalladioComponentModelSeffDiagramEditorPlugin
                .getInstance().getItemProvidersAdapterFactory());
        ElementListSelectionDialog dialog = new ElementListSelectionDialog(shell, labelProvider);
        dialog.setMessage(Messages.PalladioComponentModelModelingAssistantProviderMessage);
        dialog.setTitle(Messages.PalladioComponentModelModelingAssistantProviderTitle);
        dialog.setMultipleSelection(false);
        dialog.setElements(elements);
        EObject selected = null;
        if (dialog.open() == Window.OK) {
            selected = (EObject) dialog.getFirstResult();
        }
        return selected;
    }
}
