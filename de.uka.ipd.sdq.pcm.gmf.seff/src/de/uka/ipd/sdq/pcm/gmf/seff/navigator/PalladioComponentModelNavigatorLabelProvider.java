/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.navigator;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.AbstractActionSuccessor_AbstractActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.AcquireAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.AcquireActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.AcquireActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.AcquireActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.CollectionIteratorAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.CollectionIteratorActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.CollectionIteratorActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.CollectionIteratorActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.EmitEventAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.EmitEventActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.EmitEventActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.EmitEventActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkedBehaviour2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ForkedBehaviourEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.GuardedBranchTransitionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.GuardedBranchTransitionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InfrastructureCallEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InfrastructureCallNumberOfCallsLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalFailureOccurrenceDescriptionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ParametricResourceDemandEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ProbabilisticBranchTransitionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ProbabilisticBranchTransitionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.RecoveryAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.RecoveryActionBehaviourEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.RecoveryActionBehaviourEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviourEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.RecoveryActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.RecoveryActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.RecoveryActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ReleaseAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ReleaseActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ReleaseActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ReleaseActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviour2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviour3EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviour4EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingBehaviourEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ResourceDemandingSEFFEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SetVariableAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SetVariableActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SetVariableActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SetVariableActionEntityNameEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StartAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StartActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StopAction2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.StopActionEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.SynchronisationPointEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisation2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisation3EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisation4EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisation5EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsage2EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsage3EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsage3LabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsage4EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsage4LabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsage5EditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsage5LabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableUsageLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.WrappingLabelEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelSeffDiagramEditorPlugin;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelParserProvider;
import de.uka.ipd.sdq.pcm.seff.ForkedBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.seff.StopAction;

/**
 * The Class PalladioComponentModelNavigatorLabelProvider.
 *
 * @generated
 */
public class PalladioComponentModelNavigatorLabelProvider extends LabelProvider implements ICommonLabelProvider,
        ITreePathLabelProvider {

    /**
     * @generated
     */
    static {
        PalladioComponentModelSeffDiagramEditorPlugin.getInstance().getImageRegistry()
                .put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
        PalladioComponentModelSeffDiagramEditorPlugin.getInstance().getImageRegistry()
                .put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
    }

    /**
     * Update label.
     *
     * @param label the label
     * @param elementPath the element path
     * @generated
     */
    public void updateLabel(ViewerLabel label, TreePath elementPath) {
        Object element = elementPath.getLastSegment();
        if (element instanceof PalladioComponentModelNavigatorItem
                && !isOwnView(((PalladioComponentModelNavigatorItem) element).getView())) {
            return;
        }
        label.setText(getText(element));
        label.setImage(getImage(element));
    }

    /**
     * Gets the image.
     *
     * @param element the element
     * @return the image
     * @generated
     */
    public Image getImage(Object element) {
        if (element instanceof PalladioComponentModelNavigatorGroup) {
            PalladioComponentModelNavigatorGroup group = (PalladioComponentModelNavigatorGroup) element;
            return PalladioComponentModelSeffDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
        }

        if (element instanceof PalladioComponentModelNavigatorItem) {
            PalladioComponentModelNavigatorItem navigatorItem = (PalladioComponentModelNavigatorItem) element;
            if (!isOwnView(navigatorItem.getView())) {
                return super.getImage(element);
            }
            return getImage(navigatorItem.getView());
        }

        return super.getImage(element);
    }

    /**
     * Gets the image.
     *
     * @param view the view
     * @return the image
     * @generated
     */
    public Image getImage(View view) {
        switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
        case ResourceDemandingSEFFEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Diagram?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/5.0?ResourceDemandingSEFF", PalladioComponentModelElementTypes.ResourceDemandingSEFF_1000); //$NON-NLS-1$
        case StartActionEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?TopLevelNode?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/5.0?StartAction", PalladioComponentModelElementTypes.StartAction_2001); //$NON-NLS-1$
        case StopActionEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?TopLevelNode?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/5.0?StopAction", PalladioComponentModelElementTypes.StopAction_2002); //$NON-NLS-1$
        case ExternalCallActionEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?TopLevelNode?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/5.0?ExternalCallAction", PalladioComponentModelElementTypes.ExternalCallAction_2003); //$NON-NLS-1$
        case EmitEventActionEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?TopLevelNode?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/5.0?EmitEventAction", PalladioComponentModelElementTypes.EmitEventAction_2013); //$NON-NLS-1$
        case LoopActionEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?TopLevelNode?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/5.0?LoopAction", PalladioComponentModelElementTypes.LoopAction_2004); //$NON-NLS-1$
        case BranchActionEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?TopLevelNode?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/5.0?BranchAction", PalladioComponentModelElementTypes.BranchAction_2005); //$NON-NLS-1$
        case InternalActionEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?TopLevelNode?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/5.0?InternalAction", PalladioComponentModelElementTypes.InternalAction_2006); //$NON-NLS-1$
        case CollectionIteratorActionEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?TopLevelNode?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/5.0?CollectionIteratorAction", PalladioComponentModelElementTypes.CollectionIteratorAction_2007); //$NON-NLS-1$
        case SetVariableActionEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?TopLevelNode?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/5.0?SetVariableAction", PalladioComponentModelElementTypes.SetVariableAction_2008); //$NON-NLS-1$
        case AcquireActionEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?TopLevelNode?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/5.0?AcquireAction", PalladioComponentModelElementTypes.AcquireAction_2012); //$NON-NLS-1$
        case ReleaseActionEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?TopLevelNode?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/5.0?ReleaseAction", PalladioComponentModelElementTypes.ReleaseAction_2010); //$NON-NLS-1$
        case ForkActionEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?TopLevelNode?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/5.0?ForkAction", PalladioComponentModelElementTypes.ForkAction_2011); //$NON-NLS-1$
        case RecoveryActionEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?TopLevelNode?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/SEFF_Reliability/5.0?RecoveryAction", PalladioComponentModelElementTypes.RecoveryAction_2016); //$NON-NLS-1$
        case VariableUsageEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/Parameter/5.0?VariableUsage", PalladioComponentModelElementTypes.VariableUsage_3042); //$NON-NLS-1$
        case VariableCharacterisationEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/Parameter/5.0?VariableCharacterisation", PalladioComponentModelElementTypes.VariableCharacterisation_3033); //$NON-NLS-1$
        case VariableUsage2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/Parameter/5.0?VariableUsage", PalladioComponentModelElementTypes.VariableUsage_3049); //$NON-NLS-1$
        case VariableCharacterisation2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/Parameter/5.0?VariableCharacterisation", PalladioComponentModelElementTypes.VariableCharacterisation_3035); //$NON-NLS-1$
        case VariableUsage4EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/Parameter/5.0?VariableUsage", PalladioComponentModelElementTypes.VariableUsage_3047); //$NON-NLS-1$
        case VariableCharacterisation3EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/Parameter/5.0?VariableCharacterisation", PalladioComponentModelElementTypes.VariableCharacterisation_3037); //$NON-NLS-1$
        case ResourceDemandingBehaviourEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/5.0?ResourceDemandingBehaviour", PalladioComponentModelElementTypes.ResourceDemandingBehaviour_3003); //$NON-NLS-1$
        case StartAction2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/5.0?StartAction", PalladioComponentModelElementTypes.StartAction_3004); //$NON-NLS-1$
        case StopAction2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/5.0?StopAction", PalladioComponentModelElementTypes.StopAction_3005); //$NON-NLS-1$
        case LoopAction2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/5.0?LoopAction", PalladioComponentModelElementTypes.LoopAction_3006); //$NON-NLS-1$
        case InternalAction2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/5.0?InternalAction", PalladioComponentModelElementTypes.InternalAction_3007); //$NON-NLS-1$
        case ParametricResourceDemandEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/SEFF_Performance/5.0?ParametricResourceDemand", PalladioComponentModelElementTypes.ParametricResourceDemand_3051); //$NON-NLS-1$
        case InternalFailureOccurrenceDescriptionEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/Reliability/5.0?InternalFailureOccurrenceDescription", PalladioComponentModelElementTypes.InternalFailureOccurrenceDescription_3050); //$NON-NLS-1$
        case InfrastructureCallEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/SEFF_Performance/5.0?InfrastructureCall", PalladioComponentModelElementTypes.InfrastructureCall_3053); //$NON-NLS-1$
        case VariableUsage5EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/Parameter/5.0?VariableUsage", PalladioComponentModelElementTypes.VariableUsage_3054); //$NON-NLS-1$
        case VariableCharacterisation4EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/Parameter/5.0?VariableCharacterisation", PalladioComponentModelElementTypes.VariableCharacterisation_3048); //$NON-NLS-1$
        case BranchAction2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/5.0?BranchAction", PalladioComponentModelElementTypes.BranchAction_3009); //$NON-NLS-1$
        case ProbabilisticBranchTransitionEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/5.0?ProbabilisticBranchTransition", PalladioComponentModelElementTypes.ProbabilisticBranchTransition_3010); //$NON-NLS-1$
        case ResourceDemandingBehaviour2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/5.0?ResourceDemandingBehaviour", PalladioComponentModelElementTypes.ResourceDemandingBehaviour_3011); //$NON-NLS-1$
        case ExternalCallAction2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/5.0?ExternalCallAction", PalladioComponentModelElementTypes.ExternalCallAction_3012); //$NON-NLS-1$
        case EmitEventAction2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/5.0?EmitEventAction", PalladioComponentModelElementTypes.EmitEventAction_3046); //$NON-NLS-1$
        case AcquireAction2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/5.0?AcquireAction", PalladioComponentModelElementTypes.AcquireAction_3026); //$NON-NLS-1$
        case ReleaseAction2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/5.0?ReleaseAction", PalladioComponentModelElementTypes.ReleaseAction_3020); //$NON-NLS-1$
        case ForkAction2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/5.0?ForkAction", PalladioComponentModelElementTypes.ForkAction_3023); //$NON-NLS-1$
        case ForkedBehaviourEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/5.0?ForkedBehaviour", PalladioComponentModelElementTypes.ForkedBehaviour_3027); //$NON-NLS-1$
        case CollectionIteratorAction2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/5.0?CollectionIteratorAction", PalladioComponentModelElementTypes.CollectionIteratorAction_3013); //$NON-NLS-1$
        case ResourceDemandingBehaviour3EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/5.0?ResourceDemandingBehaviour", PalladioComponentModelElementTypes.ResourceDemandingBehaviour_3014); //$NON-NLS-1$
        case RecoveryAction2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/SEFF_Reliability/5.0?RecoveryAction", PalladioComponentModelElementTypes.RecoveryAction_3057); //$NON-NLS-1$
        case RecoveryActionBehaviourEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/SEFF_Reliability/5.0?RecoveryActionBehaviour", PalladioComponentModelElementTypes.RecoveryActionBehaviour_3058); //$NON-NLS-1$
        case SetVariableAction2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/5.0?SetVariableAction", PalladioComponentModelElementTypes.SetVariableAction_3024); //$NON-NLS-1$
        case VariableUsage3EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/Parameter/5.0?VariableUsage", PalladioComponentModelElementTypes.VariableUsage_3036); //$NON-NLS-1$
        case VariableCharacterisation5EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/Parameter/5.0?VariableCharacterisation", PalladioComponentModelElementTypes.VariableCharacterisation_3055); //$NON-NLS-1$
        case SynchronisationPointEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/5.0?SynchronisationPoint", PalladioComponentModelElementTypes.SynchronisationPoint_3038); //$NON-NLS-1$
        case ForkedBehaviour2EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/5.0?ForkedBehaviour", PalladioComponentModelElementTypes.ForkedBehaviour_3039); //$NON-NLS-1$
        case GuardedBranchTransitionEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/5.0?GuardedBranchTransition", PalladioComponentModelElementTypes.GuardedBranchTransition_3017); //$NON-NLS-1$
        case ResourceDemandingBehaviour4EditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Node?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/5.0?ResourceDemandingBehaviour", PalladioComponentModelElementTypes.ResourceDemandingBehaviour_3018); //$NON-NLS-1$
        case AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Link?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/5.0?AbstractAction?successor_AbstractAction", PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001); //$NON-NLS-1$
        case RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviourEditPart.VISUAL_ID:
            return getImage(
                    "Navigator?Link?http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/SEFF_Reliability/5.0?RecoveryActionBehaviour?failureHandlingAlternatives__RecoveryActionBehaviour", PalladioComponentModelElementTypes.RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviour_4004); //$NON-NLS-1$
        }
        return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
    }

    /**
     * Gets the image.
     *
     * @param key the key
     * @param elementType the element type
     * @return the image
     * @generated
     */
    private Image getImage(String key, IElementType elementType) {
        ImageRegistry imageRegistry = PalladioComponentModelSeffDiagramEditorPlugin.getInstance().getImageRegistry();
        Image image = imageRegistry.get(key);
        if (image == null && elementType != null && PalladioComponentModelElementTypes.isKnownElementType(elementType)) {
            image = PalladioComponentModelElementTypes.getImage(elementType);
            imageRegistry.put(key, image);
        }

        if (image == null) {
            image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
            imageRegistry.put(key, image);
        }
        return image;
    }

    /**
     * Gets the text.
     *
     * @param element the element
     * @return the text
     * @generated
     */
    public String getText(Object element) {
        if (element instanceof PalladioComponentModelNavigatorGroup) {
            PalladioComponentModelNavigatorGroup group = (PalladioComponentModelNavigatorGroup) element;
            return group.getGroupName();
        }

        if (element instanceof PalladioComponentModelNavigatorItem) {
            PalladioComponentModelNavigatorItem navigatorItem = (PalladioComponentModelNavigatorItem) element;
            if (!isOwnView(navigatorItem.getView())) {
                return null;
            }
            return getText(navigatorItem.getView());
        }

        return super.getText(element);
    }

    /**
     * Gets the text.
     *
     * @param view the view
     * @return the text
     * @generated
     */
    public String getText(View view) {
        if (view.getElement() != null && view.getElement().eIsProxy()) {
            return getUnresolvedDomainElementProxyText(view);
        }
        switch (PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
        case ResourceDemandingSEFFEditPart.VISUAL_ID:
            return getResourceDemandingSEFF_1000Text(view);
        case StartActionEditPart.VISUAL_ID:
            return getStartAction_2001Text(view);
        case StopActionEditPart.VISUAL_ID:
            return getStopAction_2002Text(view);
        case ExternalCallActionEditPart.VISUAL_ID:
            return getExternalCallAction_2003Text(view);
        case EmitEventActionEditPart.VISUAL_ID:
            return getEmitEventAction_2013Text(view);
        case LoopActionEditPart.VISUAL_ID:
            return getLoopAction_2004Text(view);
        case BranchActionEditPart.VISUAL_ID:
            return getBranchAction_2005Text(view);
        case InternalActionEditPart.VISUAL_ID:
            return getInternalAction_2006Text(view);
        case CollectionIteratorActionEditPart.VISUAL_ID:
            return getCollectionIteratorAction_2007Text(view);
        case SetVariableActionEditPart.VISUAL_ID:
            return getSetVariableAction_2008Text(view);
        case AcquireActionEditPart.VISUAL_ID:
            return getAcquireAction_2012Text(view);
        case ReleaseActionEditPart.VISUAL_ID:
            return getReleaseAction_2010Text(view);
        case ForkActionEditPart.VISUAL_ID:
            return getForkAction_2011Text(view);
        case RecoveryActionEditPart.VISUAL_ID:
            return getRecoveryAction_2016Text(view);
        case VariableUsageEditPart.VISUAL_ID:
            return getVariableUsage_3042Text(view);
        case VariableCharacterisationEditPart.VISUAL_ID:
            return getVariableCharacterisation_3033Text(view);
        case VariableUsage2EditPart.VISUAL_ID:
            return getVariableUsage_3049Text(view);
        case VariableCharacterisation2EditPart.VISUAL_ID:
            return getVariableCharacterisation_3035Text(view);
        case VariableUsage4EditPart.VISUAL_ID:
            return getVariableUsage_3047Text(view);
        case VariableCharacterisation3EditPart.VISUAL_ID:
            return getVariableCharacterisation_3037Text(view);
        case ResourceDemandingBehaviourEditPart.VISUAL_ID:
            return getResourceDemandingBehaviour_3003Text(view);
        case StartAction2EditPart.VISUAL_ID:
            return getStartAction_3004Text(view);
        case StopAction2EditPart.VISUAL_ID:
            return getStopAction_3005Text(view);
        case LoopAction2EditPart.VISUAL_ID:
            return getLoopAction_3006Text(view);
        case InternalAction2EditPart.VISUAL_ID:
            return getInternalAction_3007Text(view);
        case ParametricResourceDemandEditPart.VISUAL_ID:
            return getParametricResourceDemand_3051Text(view);
        case InternalFailureOccurrenceDescriptionEditPart.VISUAL_ID:
            return getInternalFailureOccurrenceDescription_3050Text(view);
        case InfrastructureCallEditPart.VISUAL_ID:
            return getInfrastructureCall_3053Text(view);
        case VariableUsage5EditPart.VISUAL_ID:
            return getVariableUsage_3054Text(view);
        case VariableCharacterisation4EditPart.VISUAL_ID:
            return getVariableCharacterisation_3048Text(view);
        case BranchAction2EditPart.VISUAL_ID:
            return getBranchAction_3009Text(view);
        case ProbabilisticBranchTransitionEditPart.VISUAL_ID:
            return getProbabilisticBranchTransition_3010Text(view);
        case ResourceDemandingBehaviour2EditPart.VISUAL_ID:
            return getResourceDemandingBehaviour_3011Text(view);
        case ExternalCallAction2EditPart.VISUAL_ID:
            return getExternalCallAction_3012Text(view);
        case EmitEventAction2EditPart.VISUAL_ID:
            return getEmitEventAction_3046Text(view);
        case AcquireAction2EditPart.VISUAL_ID:
            return getAcquireAction_3026Text(view);
        case ReleaseAction2EditPart.VISUAL_ID:
            return getReleaseAction_3020Text(view);
        case ForkAction2EditPart.VISUAL_ID:
            return getForkAction_3023Text(view);
        case ForkedBehaviourEditPart.VISUAL_ID:
            return getForkedBehaviour_3027Text(view);
        case CollectionIteratorAction2EditPart.VISUAL_ID:
            return getCollectionIteratorAction_3013Text(view);
        case ResourceDemandingBehaviour3EditPart.VISUAL_ID:
            return getResourceDemandingBehaviour_3014Text(view);
        case RecoveryAction2EditPart.VISUAL_ID:
            return getRecoveryAction_3057Text(view);
        case RecoveryActionBehaviourEditPart.VISUAL_ID:
            return getRecoveryActionBehaviour_3058Text(view);
        case SetVariableAction2EditPart.VISUAL_ID:
            return getSetVariableAction_3024Text(view);
        case VariableUsage3EditPart.VISUAL_ID:
            return getVariableUsage_3036Text(view);
        case VariableCharacterisation5EditPart.VISUAL_ID:
            return getVariableCharacterisation_3055Text(view);
        case SynchronisationPointEditPart.VISUAL_ID:
            return getSynchronisationPoint_3038Text(view);
        case ForkedBehaviour2EditPart.VISUAL_ID:
            return getForkedBehaviour_3039Text(view);
        case GuardedBranchTransitionEditPart.VISUAL_ID:
            return getGuardedBranchTransition_3017Text(view);
        case ResourceDemandingBehaviour4EditPart.VISUAL_ID:
            return getResourceDemandingBehaviour_3018Text(view);
        case AbstractActionSuccessor_AbstractActionEditPart.VISUAL_ID:
            return getAbstractActionSuccessor_AbstractAction_4001Text(view);
        case RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviourEditPart.VISUAL_ID:
            return getRecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviour_4004Text(view);
        }
        return getUnknownElementText(view);
    }

    /**
     * Gets the resource demanding sef f_1000 text.
     *
     * @param view the view
     * @return the resource demanding sef f_1000 text
     * @generated
     */
    private String getResourceDemandingSEFF_1000Text(View view) {
        ResourceDemandingSEFF domainModelElement = (ResourceDemandingSEFF) view.getElement();
        if (domainModelElement != null) {
            return domainModelElement.getId();
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "No domain element for view with visualID = " + 1000); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the start action_2001 text.
     *
     * @param view the view
     * @return the start action_2001 text
     * @generated
     */
    private String getStartAction_2001Text(View view) {
        StartAction domainModelElement = (StartAction) view.getElement();
        if (domainModelElement != null) {
            return domainModelElement.getId();
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "No domain element for view with visualID = " + 2001); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the stop action_2002 text.
     *
     * @param view the view
     * @return the stop action_2002 text
     * @generated
     */
    private String getStopAction_2002Text(View view) {
        StopAction domainModelElement = (StopAction) view.getElement();
        if (domainModelElement != null) {
            return domainModelElement.getId();
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "No domain element for view with visualID = " + 2002); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the external call action_2003 text.
     *
     * @param view the view
     * @return the external call action_2003 text
     * @generated
     */
    private String getExternalCallAction_2003Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.ExternalCallAction_2003,
                view.getElement() != null ? view.getElement() : view,
                PalladioComponentModelVisualIDRegistry.getType(ExternalCallActionEntityNameEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5002); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the emit event action_2013 text.
     *
     * @param view the view
     * @return the emit event action_2013 text
     * @generated
     */
    private String getEmitEventAction_2013Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.EmitEventAction_2013, view.getElement() != null ? view.getElement()
                        : view, PalladioComponentModelVisualIDRegistry
                        .getType(EmitEventActionEntityNameEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5046); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the loop action_2004 text.
     *
     * @param view the view
     * @return the loop action_2004 text
     * @generated
     */
    private String getLoopAction_2004Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.LoopAction_2004, view.getElement() != null ? view.getElement()
                        : view, PalladioComponentModelVisualIDRegistry.getType(LoopActionEntityNameEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5009); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the branch action_2005 text.
     *
     * @param view the view
     * @return the branch action_2005 text
     * @generated
     */
    private String getBranchAction_2005Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.BranchAction_2005, view.getElement() != null ? view.getElement()
                        : view, PalladioComponentModelVisualIDRegistry
                        .getType(BranchActionEntityNameEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5011); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the internal action_2006 text.
     *
     * @param view the view
     * @return the internal action_2006 text
     * @generated
     */
    private String getInternalAction_2006Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.InternalAction_2006, view.getElement() != null ? view.getElement()
                        : view, PalladioComponentModelVisualIDRegistry
                        .getType(InternalActionEntityNameEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5012); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the collection iterator action_2007 text.
     *
     * @param view the view
     * @return the collection iterator action_2007 text
     * @generated
     */
    private String getCollectionIteratorAction_2007Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.CollectionIteratorAction_2007,
                view.getElement() != null ? view.getElement() : view,
                PalladioComponentModelVisualIDRegistry.getType(CollectionIteratorActionEntityNameEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5015); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the sets the variable action_2008 text.
     *
     * @param view the view
     * @return the sets the variable action_2008 text
     * @generated
     */
    private String getSetVariableAction_2008Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.SetVariableAction_2008,
                view.getElement() != null ? view.getElement() : view,
                PalladioComponentModelVisualIDRegistry.getType(SetVariableActionEntityNameEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5023); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the acquire action_2012 text.
     *
     * @param view the view
     * @return the acquire action_2012 text
     * @generated
     */
    private String getAcquireAction_2012Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.AcquireAction_2012, view.getElement() != null ? view.getElement()
                        : view, PalladioComponentModelVisualIDRegistry
                        .getType(AcquireActionEntityNameEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5029); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the release action_2010 text.
     *
     * @param view the view
     * @return the release action_2010 text
     * @generated
     */
    private String getReleaseAction_2010Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.ReleaseAction_2010, view.getElement() != null ? view.getElement()
                        : view, PalladioComponentModelVisualIDRegistry
                        .getType(ReleaseActionEntityNameEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5022); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the fork action_2011 text.
     *
     * @param view the view
     * @return the fork action_2011 text
     * @generated
     */
    private String getForkAction_2011Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.ForkAction_2011, view.getElement() != null ? view.getElement()
                        : view, PalladioComponentModelVisualIDRegistry.getType(ForkActionEntityNameEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5024); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the recovery action_2016 text.
     *
     * @param view the view
     * @return the recovery action_2016 text
     * @generated
     */
    private String getRecoveryAction_2016Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.RecoveryAction_2016, view.getElement() != null ? view.getElement()
                        : view, PalladioComponentModelVisualIDRegistry
                        .getType(RecoveryActionEntityNameEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5056); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the variable usage_3042 text.
     *
     * @param view the view
     * @return the variable usage_3042 text
     * @generated
     */
    private String getVariableUsage_3042Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.VariableUsage_3042, view.getElement() != null ? view.getElement()
                        : view, PalladioComponentModelVisualIDRegistry.getType(VariableUsageLabelEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5040); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the variable characterisation_3033 text.
     *
     * @param view the view
     * @return the variable characterisation_3033 text
     * @generated
     */
    private String getVariableCharacterisation_3033Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.VariableCharacterisation_3033,
                view.getElement() != null ? view.getElement() : view,
                PalladioComponentModelVisualIDRegistry.getType(VariableCharacterisationEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 3033); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the variable usage_3049 text.
     *
     * @param view the view
     * @return the variable usage_3049 text
     * @generated
     */
    private String getVariableUsage_3049Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.VariableUsage_3049, view.getElement() != null ? view.getElement()
                        : view, PalladioComponentModelVisualIDRegistry.getType(WrappingLabelEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5047); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the variable characterisation_3035 text.
     *
     * @param view the view
     * @return the variable characterisation_3035 text
     * @generated
     */
    private String getVariableCharacterisation_3035Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.VariableCharacterisation_3035,
                view.getElement() != null ? view.getElement() : view,
                PalladioComponentModelVisualIDRegistry.getType(VariableCharacterisation2EditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 3035); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the variable usage_3047 text.
     *
     * @param view the view
     * @return the variable usage_3047 text
     * @generated
     */
    private String getVariableUsage_3047Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.VariableUsage_3047, view.getElement() != null ? view.getElement()
                        : view, PalladioComponentModelVisualIDRegistry.getType(VariableUsage4LabelEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5045); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the resource demanding behaviour_3003 text.
     *
     * @param view the view
     * @return the resource demanding behaviour_3003 text
     * @generated
     */
    private String getResourceDemandingBehaviour_3003Text(View view) {
        ResourceDemandingBehaviour domainModelElement = (ResourceDemandingBehaviour) view.getElement();
        if (domainModelElement != null) {
            return domainModelElement.getId();
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "No domain element for view with visualID = " + 3003); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the start action_3004 text.
     *
     * @param view the view
     * @return the start action_3004 text
     * @generated
     */
    private String getStartAction_3004Text(View view) {
        StartAction domainModelElement = (StartAction) view.getElement();
        if (domainModelElement != null) {
            return domainModelElement.getId();
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "No domain element for view with visualID = " + 3004); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the stop action_3005 text.
     *
     * @param view the view
     * @return the stop action_3005 text
     * @generated
     */
    private String getStopAction_3005Text(View view) {
        StopAction domainModelElement = (StopAction) view.getElement();
        if (domainModelElement != null) {
            return domainModelElement.getId();
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "No domain element for view with visualID = " + 3005); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the loop action_3006 text.
     *
     * @param view the view
     * @return the loop action_3006 text
     * @generated
     */
    private String getLoopAction_3006Text(View view) {
        IParser parser = PalladioComponentModelParserProvider
                .getParser(PalladioComponentModelElementTypes.LoopAction_3006,
                        view.getElement() != null ? view.getElement() : view,
                        PalladioComponentModelVisualIDRegistry.getType(LoopActionEntityName2EditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5003); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the internal action_3007 text.
     *
     * @param view the view
     * @return the internal action_3007 text
     * @generated
     */
    private String getInternalAction_3007Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.InternalAction_3007, view.getElement() != null ? view.getElement()
                        : view, PalladioComponentModelVisualIDRegistry
                        .getType(InternalActionEntityName2EditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5005); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the parametric resource demand_3051 text.
     *
     * @param view the view
     * @return the parametric resource demand_3051 text
     * @generated
     */
    private String getParametricResourceDemand_3051Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.ParametricResourceDemand_3051,
                view.getElement() != null ? view.getElement() : view,
                PalladioComponentModelVisualIDRegistry.getType(ParametricResourceDemandEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 3051); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the internal failure occurrence description_3050 text.
     *
     * @param view the view
     * @return the internal failure occurrence description_3050 text
     * @generated
     */
    private String getInternalFailureOccurrenceDescription_3050Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.InternalFailureOccurrenceDescription_3050,
                view.getElement() != null ? view.getElement() : view, PalladioComponentModelVisualIDRegistry
                        .getType(InternalFailureOccurrenceDescriptionEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 3050); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the infrastructure call_3053 text.
     *
     * @param view the view
     * @return the infrastructure call_3053 text
     * @generated
     */
    private String getInfrastructureCall_3053Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.InfrastructureCall_3053,
                view.getElement() != null ? view.getElement() : view,
                PalladioComponentModelVisualIDRegistry.getType(InfrastructureCallNumberOfCallsLabelEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5051); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the variable usage_3054 text.
     *
     * @param view the view
     * @return the variable usage_3054 text
     * @generated
     */
    private String getVariableUsage_3054Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.VariableUsage_3054, view.getElement() != null ? view.getElement()
                        : view, PalladioComponentModelVisualIDRegistry.getType(VariableUsage5LabelEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5050); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the branch action_3009 text.
     *
     * @param view the view
     * @return the branch action_3009 text
     * @generated
     */
    private String getBranchAction_3009Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.BranchAction_3009, view.getElement() != null ? view.getElement()
                        : view, PalladioComponentModelVisualIDRegistry
                        .getType(BranchActionEntityName2EditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5008); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the probabilistic branch transition_3010 text.
     *
     * @param view the view
     * @return the probabilistic branch transition_3010 text
     * @generated
     */
    private String getProbabilisticBranchTransition_3010Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.ProbabilisticBranchTransition_3010,
                view.getElement() != null ? view.getElement() : view, PalladioComponentModelVisualIDRegistry
                        .getType(ProbabilisticBranchTransitionEntityNameEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5007); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the resource demanding behaviour_3011 text.
     *
     * @param view the view
     * @return the resource demanding behaviour_3011 text
     * @generated
     */
    private String getResourceDemandingBehaviour_3011Text(View view) {
        ResourceDemandingBehaviour domainModelElement = (ResourceDemandingBehaviour) view.getElement();
        if (domainModelElement != null) {
            return domainModelElement.getId();
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "No domain element for view with visualID = " + 3011); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the external call action_3012 text.
     *
     * @param view the view
     * @return the external call action_3012 text
     * @generated
     */
    private String getExternalCallAction_3012Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.ExternalCallAction_3012,
                view.getElement() != null ? view.getElement() : view,
                PalladioComponentModelVisualIDRegistry.getType(ExternalCallActionEntityName2EditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5006); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the emit event action_3046 text.
     *
     * @param view the view
     * @return the emit event action_3046 text
     * @generated
     */
    private String getEmitEventAction_3046Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.EmitEventAction_3046, view.getElement() != null ? view.getElement()
                        : view, PalladioComponentModelVisualIDRegistry
                        .getType(EmitEventActionEntityName2EditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5044); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the acquire action_3026 text.
     *
     * @param view the view
     * @return the acquire action_3026 text
     * @generated
     */
    private String getAcquireAction_3026Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.AcquireAction_3026, view.getElement() != null ? view.getElement()
                        : view, PalladioComponentModelVisualIDRegistry
                        .getType(AcquireActionEntityName2EditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5028); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the release action_3020 text.
     *
     * @param view the view
     * @return the release action_3020 text
     * @generated
     */
    private String getReleaseAction_3020Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.ReleaseAction_3020, view.getElement() != null ? view.getElement()
                        : view, PalladioComponentModelVisualIDRegistry
                        .getType(ReleaseActionEntityName2EditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5020); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the fork action_3023 text.
     *
     * @param view the view
     * @return the fork action_3023 text
     * @generated
     */
    private String getForkAction_3023Text(View view) {
        IParser parser = PalladioComponentModelParserProvider
                .getParser(PalladioComponentModelElementTypes.ForkAction_3023,
                        view.getElement() != null ? view.getElement() : view,
                        PalladioComponentModelVisualIDRegistry.getType(ForkActionEntityName2EditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5026); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the forked behaviour_3027 text.
     *
     * @param view the view
     * @return the forked behaviour_3027 text
     * @generated
     */
    private String getForkedBehaviour_3027Text(View view) {
        ForkedBehaviour domainModelElement = (ForkedBehaviour) view.getElement();
        if (domainModelElement != null) {
            return domainModelElement.getId();
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "No domain element for view with visualID = " + 3027); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the collection iterator action_3013 text.
     *
     * @param view the view
     * @return the collection iterator action_3013 text
     * @generated
     */
    private String getCollectionIteratorAction_3013Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.CollectionIteratorAction_3013,
                view.getElement() != null ? view.getElement() : view,
                PalladioComponentModelVisualIDRegistry.getType(CollectionIteratorActionEntityName2EditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5013); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the resource demanding behaviour_3014 text.
     *
     * @param view the view
     * @return the resource demanding behaviour_3014 text
     * @generated
     */
    private String getResourceDemandingBehaviour_3014Text(View view) {
        ResourceDemandingBehaviour domainModelElement = (ResourceDemandingBehaviour) view.getElement();
        if (domainModelElement != null) {
            return domainModelElement.getId();
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "No domain element for view with visualID = " + 3014); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the recovery action_3057 text.
     *
     * @param view the view
     * @return the recovery action_3057 text
     * @generated
     */
    private String getRecoveryAction_3057Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.RecoveryAction_3057, view.getElement() != null ? view.getElement()
                        : view, PalladioComponentModelVisualIDRegistry
                        .getType(RecoveryActionEntityName2EditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5055); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the recovery action behaviour_3058 text.
     *
     * @param view the view
     * @return the recovery action behaviour_3058 text
     * @generated
     */
    private String getRecoveryActionBehaviour_3058Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.RecoveryActionBehaviour_3058,
                view.getElement() != null ? view.getElement() : view,
                PalladioComponentModelVisualIDRegistry.getType(RecoveryActionBehaviourEntityNameEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5054); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the synchronisation point_3038 text.
     *
     * @param view the view
     * @return the synchronisation point_3038 text
     * @generated
     */
    private String getSynchronisationPoint_3038Text(View view) {
        return ""; //$NON-NLS-1$
    }

    /**
     * Gets the forked behaviour_3039 text.
     *
     * @param view the view
     * @return the forked behaviour_3039 text
     * @generated
     */
    private String getForkedBehaviour_3039Text(View view) {
        ForkedBehaviour domainModelElement = (ForkedBehaviour) view.getElement();
        if (domainModelElement != null) {
            return domainModelElement.getId();
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "No domain element for view with visualID = " + 3039); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the sets the variable action_3024 text.
     *
     * @param view the view
     * @return the sets the variable action_3024 text
     * @generated
     */
    private String getSetVariableAction_3024Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.SetVariableAction_3024,
                view.getElement() != null ? view.getElement() : view,
                PalladioComponentModelVisualIDRegistry.getType(SetVariableActionEntityName2EditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5027); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the variable usage_3036 text.
     *
     * @param view the view
     * @return the variable usage_3036 text
     * @generated
     */
    private String getVariableUsage_3036Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.VariableUsage_3036, view.getElement() != null ? view.getElement()
                        : view, PalladioComponentModelVisualIDRegistry.getType(VariableUsage3LabelEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5035); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the variable characterisation_3055 text.
     *
     * @param view the view
     * @return the variable characterisation_3055 text
     * @generated
     */
    private String getVariableCharacterisation_3055Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.VariableCharacterisation_3055,
                view.getElement() != null ? view.getElement() : view,
                PalladioComponentModelVisualIDRegistry.getType(VariableCharacterisation5EditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 3055); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the variable characterisation_3048 text.
     *
     * @param view the view
     * @return the variable characterisation_3048 text
     * @generated
     */
    private String getVariableCharacterisation_3048Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.VariableCharacterisation_3048,
                view.getElement() != null ? view.getElement() : view,
                PalladioComponentModelVisualIDRegistry.getType(VariableCharacterisation4EditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 3048); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the variable characterisation_3037 text.
     *
     * @param view the view
     * @return the variable characterisation_3037 text
     * @generated
     */
    private String getVariableCharacterisation_3037Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.VariableCharacterisation_3037,
                view.getElement() != null ? view.getElement() : view,
                PalladioComponentModelVisualIDRegistry.getType(VariableCharacterisation3EditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 3037); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the guarded branch transition_3017 text.
     *
     * @param view the view
     * @return the guarded branch transition_3017 text
     * @generated
     */
    private String getGuardedBranchTransition_3017Text(View view) {
        IParser parser = PalladioComponentModelParserProvider.getParser(
                PalladioComponentModelElementTypes.GuardedBranchTransition_3017,
                view.getElement() != null ? view.getElement() : view,
                PalladioComponentModelVisualIDRegistry.getType(GuardedBranchTransitionEntityNameEditPart.VISUAL_ID));
        if (parser != null) {
            return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
                    ParserOptions.NONE.intValue());
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "Parser was not found for label " + 5018); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the resource demanding behaviour_3018 text.
     *
     * @param view the view
     * @return the resource demanding behaviour_3018 text
     * @generated
     */
    private String getResourceDemandingBehaviour_3018Text(View view) {
        ResourceDemandingBehaviour domainModelElement = (ResourceDemandingBehaviour) view.getElement();
        if (domainModelElement != null) {
            return domainModelElement.getId();
        } else {
            PalladioComponentModelSeffDiagramEditorPlugin.getInstance().logError(
                    "No domain element for view with visualID = " + 3018); //$NON-NLS-1$
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * Gets the abstract action successor_ abstract action_4001 text.
     *
     * @param view the view
     * @return the abstract action successor_ abstract action_4001 text
     * @generated
     */
    private String getAbstractActionSuccessor_AbstractAction_4001Text(View view) {
        return ""; //$NON-NLS-1$
    }

    /**
     * Gets the recovery action behaviour failure handling alternatives__ recovery action behaviour_4004 text.
     *
     * @param view the view
     * @return the recovery action behaviour failure handling alternatives__ recovery action behaviour_4004 text
     * @generated
     */
    private String getRecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviour_4004Text(View view) {
        return ""; //$NON-NLS-1$
    }

    /**
     * Gets the unknown element text.
     *
     * @param view the view
     * @return the unknown element text
     * @generated
     */
    private String getUnknownElementText(View view) {
        return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
    }

    /**
     * Gets the unresolved domain element proxy text.
     *
     * @param view the view
     * @return the unresolved domain element proxy text
     * @generated
     */
    private String getUnresolvedDomainElementProxyText(View view) {
        return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
    }

    /**
     * Inits the.
     *
     * @param aConfig the a config
     * @generated
     */
    public void init(ICommonContentExtensionSite aConfig) {
    }

    /**
     * Restore state.
     *
     * @param aMemento the a memento
     * @generated
     */
    public void restoreState(IMemento aMemento) {
    }

    /**
     * Save state.
     *
     * @param aMemento the a memento
     * @generated
     */
    public void saveState(IMemento aMemento) {
    }

    /**
     * Gets the description.
     *
     * @param anElement the an element
     * @return the description
     * @generated
     */
    public String getDescription(Object anElement) {
        return null;
    }

    /**
     * Checks if is own view.
     *
     * @param view the view
     * @return true, if is own view
     * @generated
     */
    private boolean isOwnView(View view) {
        return ResourceDemandingSEFFEditPart.MODEL_ID.equals(PalladioComponentModelVisualIDRegistry.getModelID(view));
    }

}
