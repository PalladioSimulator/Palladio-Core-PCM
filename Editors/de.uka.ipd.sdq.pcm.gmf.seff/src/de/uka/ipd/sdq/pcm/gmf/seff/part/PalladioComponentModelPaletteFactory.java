/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.part;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class PalladioComponentModelPaletteFactory {

    /**
     * @generated
     */
    public void fillPalette(PaletteRoot paletteRoot) {
        paletteRoot.add(createActions1Group());
        paletteRoot.add(createActionDetails2Group());
        paletteRoot.add(createLinks3Group());
    }

    /**
     * @generated
     */
    private PaletteContainer createActions1Group() {
        PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Actions1Group_title);
        paletteContainer.setId("createActions1Group"); //$NON-NLS-1$
        paletteContainer.setDescription(Messages.Actions1Group_desc);
        paletteContainer.add(createStartAction1CreationTool());
        paletteContainer.add(createStopAction2CreationTool());
        paletteContainer.add(createInternalAction3CreationTool());
        paletteContainer.add(createExternalCallAction4CreationTool());
        paletteContainer.add(createEmitEventAction5CreationTool());
        paletteContainer.add(createSetVariableAction6CreationTool());
        paletteContainer.add(createAcquireAction7CreationTool());
        paletteContainer.add(createReleaseAction8CreationTool());
        paletteContainer.add(createLoopAction9CreationTool());
        paletteContainer.add(createCollectionIteratorAction10CreationTool());
        paletteContainer.add(createBranchAction11CreationTool());
        paletteContainer.add(createForkAction12CreationTool());
        paletteContainer.add(createRecoveryAction13CreationTool());
        return paletteContainer;
    }

    /**
     * @generated
     */
    private PaletteContainer createActionDetails2Group() {
        PaletteDrawer paletteContainer = new PaletteDrawer(Messages.ActionDetails2Group_title);
        paletteContainer.setId("createActionDetails2Group"); //$NON-NLS-1$
        paletteContainer.add(createResourceDemand1CreationTool());
        paletteContainer.add(createVariableUsage2CreationTool());
        paletteContainer.add(createVariableCharacterisation3CreationTool());
        paletteContainer.add(createFailureOccurrenceDescription4CreationTool());
        paletteContainer.add(createResourceDemandingBehaviour5CreationTool());
        paletteContainer.add(createSynchronisationPoint6CreationTool());
        paletteContainer.add(createProbabilisticBranchTransition7CreationTool());
        paletteContainer.add(createGuardedBranchTransition8CreationTool());
        paletteContainer.add(createRecoveryActionBehaviour9CreationTool());
        paletteContainer.add(createInfrastructureCall10CreationTool());
        return paletteContainer;
    }

    /**
     * @generated
     */
    private PaletteContainer createLinks3Group() {
        PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Links3Group_title);
        paletteContainer.setId("createLinks3Group"); //$NON-NLS-1$
        paletteContainer.add(createControlFlow1CreationTool());
        paletteContainer.add(createRecoveryFlow2CreationTool());
        return paletteContainer;
    }

    /**
     * @generated
     */
    private ToolEntry createStartAction1CreationTool() {
        ArrayList<IElementType> types = new ArrayList<IElementType>(2);
        types.add(PalladioComponentModelElementTypes.StartAction_2001);
        types.add(PalladioComponentModelElementTypes.StartAction_3004);
        NodeToolEntry entry = new NodeToolEntry(Messages.StartAction1CreationTool_title,
                Messages.StartAction1CreationTool_desc, types);
        entry.setId("createStartAction1CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.StartAction_2001));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createStopAction2CreationTool() {
        ArrayList<IElementType> types = new ArrayList<IElementType>(2);
        types.add(PalladioComponentModelElementTypes.StopAction_2002);
        types.add(PalladioComponentModelElementTypes.StopAction_3005);
        NodeToolEntry entry = new NodeToolEntry(Messages.StopAction2CreationTool_title,
                Messages.StopAction2CreationTool_desc, types);
        entry.setId("createStopAction2CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.StopAction_2002));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createInternalAction3CreationTool() {
        ArrayList<IElementType> types = new ArrayList<IElementType>(2);
        types.add(PalladioComponentModelElementTypes.InternalAction_3007);
        types.add(PalladioComponentModelElementTypes.InternalAction_2006);
        NodeToolEntry entry = new NodeToolEntry(Messages.InternalAction3CreationTool_title,
                Messages.InternalAction3CreationTool_desc, types);
        entry.setId("createInternalAction3CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.InternalAction_3007));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createExternalCallAction4CreationTool() {
        ArrayList<IElementType> types = new ArrayList<IElementType>(2);
        types.add(PalladioComponentModelElementTypes.ExternalCallAction_2003);
        types.add(PalladioComponentModelElementTypes.ExternalCallAction_3012);
        NodeToolEntry entry = new NodeToolEntry(Messages.ExternalCallAction4CreationTool_title,
                Messages.ExternalCallAction4CreationTool_desc, types);
        entry.setId("createExternalCallAction4CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.ExternalCallAction_2003));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createEmitEventAction5CreationTool() {
        ArrayList<IElementType> types = new ArrayList<IElementType>(2);
        types.add(PalladioComponentModelElementTypes.EmitEventAction_2013);
        types.add(PalladioComponentModelElementTypes.EmitEventAction_3046);
        NodeToolEntry entry = new NodeToolEntry(Messages.EmitEventAction5CreationTool_title,
                Messages.EmitEventAction5CreationTool_desc, types);
        entry.setId("createEmitEventAction5CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.EmitEventAction_2013));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createSetVariableAction6CreationTool() {
        ArrayList<IElementType> types = new ArrayList<IElementType>(2);
        types.add(PalladioComponentModelElementTypes.SetVariableAction_3024);
        types.add(PalladioComponentModelElementTypes.SetVariableAction_2008);
        NodeToolEntry entry = new NodeToolEntry(Messages.SetVariableAction6CreationTool_title,
                Messages.SetVariableAction6CreationTool_desc, types);
        entry.setId("createSetVariableAction6CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.SetVariableAction_3024));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createAcquireAction7CreationTool() {
        ArrayList<IElementType> types = new ArrayList<IElementType>(2);
        types.add(PalladioComponentModelElementTypes.AcquireAction_3026);
        types.add(PalladioComponentModelElementTypes.AcquireAction_2012);
        NodeToolEntry entry = new NodeToolEntry(Messages.AcquireAction7CreationTool_title,
                Messages.AcquireAction7CreationTool_desc, types);
        entry.setId("createAcquireAction7CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.AcquireAction_3026));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createReleaseAction8CreationTool() {
        ArrayList<IElementType> types = new ArrayList<IElementType>(2);
        types.add(PalladioComponentModelElementTypes.ReleaseAction_3020);
        types.add(PalladioComponentModelElementTypes.ReleaseAction_2010);
        NodeToolEntry entry = new NodeToolEntry(Messages.ReleaseAction8CreationTool_title,
                Messages.ReleaseAction8CreationTool_desc, types);
        entry.setId("createReleaseAction8CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.ReleaseAction_3020));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createLoopAction9CreationTool() {
        ArrayList<IElementType> types = new ArrayList<IElementType>(2);
        types.add(PalladioComponentModelElementTypes.LoopAction_2004);
        types.add(PalladioComponentModelElementTypes.LoopAction_3006);
        NodeToolEntry entry = new NodeToolEntry(Messages.LoopAction9CreationTool_title,
                Messages.LoopAction9CreationTool_desc, types);
        entry.setId("createLoopAction9CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.LoopAction_2004));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createCollectionIteratorAction10CreationTool() {
        ArrayList<IElementType> types = new ArrayList<IElementType>(2);
        types.add(PalladioComponentModelElementTypes.CollectionIteratorAction_3013);
        types.add(PalladioComponentModelElementTypes.CollectionIteratorAction_2007);
        NodeToolEntry entry = new NodeToolEntry(Messages.CollectionIteratorAction10CreationTool_title,
                Messages.CollectionIteratorAction10CreationTool_desc, types);
        entry.setId("createCollectionIteratorAction10CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.CollectionIteratorAction_3013));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createBranchAction11CreationTool() {
        ArrayList<IElementType> types = new ArrayList<IElementType>(2);
        types.add(PalladioComponentModelElementTypes.BranchAction_3009);
        types.add(PalladioComponentModelElementTypes.BranchAction_2005);
        NodeToolEntry entry = new NodeToolEntry(Messages.BranchAction11CreationTool_title,
                Messages.BranchAction11CreationTool_desc, types);
        entry.setId("createBranchAction11CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.BranchAction_3009));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createForkAction12CreationTool() {
        ArrayList<IElementType> types = new ArrayList<IElementType>(2);
        types.add(PalladioComponentModelElementTypes.ForkAction_3023);
        types.add(PalladioComponentModelElementTypes.ForkAction_2011);
        NodeToolEntry entry = new NodeToolEntry(Messages.ForkAction12CreationTool_title,
                Messages.ForkAction12CreationTool_desc, types);
        entry.setId("createForkAction12CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.ForkAction_3023));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createRecoveryAction13CreationTool() {
        ArrayList<IElementType> types = new ArrayList<IElementType>(2);
        types.add(PalladioComponentModelElementTypes.RecoveryAction_3061);
        types.add(PalladioComponentModelElementTypes.RecoveryAction_2017);
        NodeToolEntry entry = new NodeToolEntry(Messages.RecoveryAction13CreationTool_title,
                Messages.RecoveryAction13CreationTool_desc, types);
        entry.setId("createRecoveryAction13CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.RecoveryAction_3061));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createResourceDemand1CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.ResourceDemand1CreationTool_title,
                Messages.ResourceDemand1CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.ParametricResourceDemand_3051));
        entry.setId("createResourceDemand1CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelSeffDiagramEditorPlugin
                .findImageDescriptor("/org.palladiosimulator.pcm.edit/icons/full/ctool16/ParametricRessourceDemand.gif")); //$NON-NLS-1$
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createVariableUsage2CreationTool() {
        ArrayList<IElementType> types = new ArrayList<IElementType>(5);
        types.add(PalladioComponentModelElementTypes.VariableUsage_3042);
        types.add(PalladioComponentModelElementTypes.VariableUsage_3049);
        types.add(PalladioComponentModelElementTypes.VariableUsage_3047);
        types.add(PalladioComponentModelElementTypes.VariableUsage_3054);
        types.add(PalladioComponentModelElementTypes.VariableUsage_3036);
        NodeToolEntry entry = new NodeToolEntry(Messages.VariableUsage2CreationTool_title,
                Messages.VariableUsage2CreationTool_desc, types);
        entry.setId("createVariableUsage2CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.VariableUsage_3042));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createVariableCharacterisation3CreationTool() {
        ArrayList<IElementType> types = new ArrayList<IElementType>(5);
        types.add(PalladioComponentModelElementTypes.VariableCharacterisation_3033);
        types.add(PalladioComponentModelElementTypes.VariableCharacterisation_3035);
        types.add(PalladioComponentModelElementTypes.VariableCharacterisation_3037);
        types.add(PalladioComponentModelElementTypes.VariableCharacterisation_3048);
        types.add(PalladioComponentModelElementTypes.VariableCharacterisation_3055);
        NodeToolEntry entry = new NodeToolEntry(Messages.VariableCharacterisation3CreationTool_title,
                Messages.VariableCharacterisation3CreationTool_desc, types);
        entry.setId("createVariableCharacterisation3CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.VariableCharacterisation_3033));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createFailureOccurrenceDescription4CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.FailureOccurrenceDescription4CreationTool_title,
                Messages.FailureOccurrenceDescription4CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.InternalFailureOccurrenceDescription_3050));
        entry.setId("createFailureOccurrenceDescription4CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.InternalFailureOccurrenceDescription_3050));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createResourceDemandingBehaviour5CreationTool() {
        ArrayList<IElementType> types = new ArrayList<IElementType>(6);
        types.add(PalladioComponentModelElementTypes.ResourceDemandingBehaviour_3003);
        types.add(PalladioComponentModelElementTypes.ResourceDemandingBehaviour_3011);
        types.add(PalladioComponentModelElementTypes.ForkedBehaviour_3027);
        types.add(PalladioComponentModelElementTypes.ResourceDemandingBehaviour_3014);
        types.add(PalladioComponentModelElementTypes.ForkedBehaviour_3039);
        types.add(PalladioComponentModelElementTypes.ResourceDemandingBehaviour_3018);
        NodeToolEntry entry = new NodeToolEntry(Messages.ResourceDemandingBehaviour5CreationTool_title,
                Messages.ResourceDemandingBehaviour5CreationTool_desc, types);
        entry.setId("createResourceDemandingBehaviour5CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.ResourceDemandingBehaviour_3003));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createSynchronisationPoint6CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.SynchronisationPoint6CreationTool_title,
                Messages.SynchronisationPoint6CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.SynchronisationPoint_3038));
        entry.setId("createSynchronisationPoint6CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.SynchronisationPoint_3038));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createProbabilisticBranchTransition7CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.ProbabilisticBranchTransition7CreationTool_title,
                Messages.ProbabilisticBranchTransition7CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.ProbabilisticBranchTransition_3010));
        entry.setId("createProbabilisticBranchTransition7CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.ProbabilisticBranchTransition_3010));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createGuardedBranchTransition8CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.GuardedBranchTransition8CreationTool_title,
                Messages.GuardedBranchTransition8CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.GuardedBranchTransition_3017));
        entry.setId("createGuardedBranchTransition8CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.GuardedBranchTransition_3017));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createRecoveryActionBehaviour9CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.RecoveryActionBehaviour9CreationTool_title,
                Messages.RecoveryActionBehaviour9CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.RecoveryActionBehaviour_3062));
        entry.setId("createRecoveryActionBehaviour9CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.RecoveryActionBehaviour_3062));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createInfrastructureCall10CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.InfrastructureCall10CreationTool_title,
                Messages.InfrastructureCall10CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.InfrastructureCall_3053));
        entry.setId("createInfrastructureCall10CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.InfrastructureCall_3053));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createControlFlow1CreationTool() {
        LinkToolEntry entry = new LinkToolEntry(Messages.ControlFlow1CreationTool_title,
                Messages.ControlFlow1CreationTool_desc,
                Collections
                        .singletonList(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001));
        entry.setId("createControlFlow1CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelSeffDiagramEditorPlugin
                .findImageDescriptor("/org.palladiosimulator.pcm.edit/icons/full/ctool16/ControlFlow.gif")); //$NON-NLS-1$
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createRecoveryFlow2CreationTool() {
        LinkToolEntry entry = new LinkToolEntry(
                Messages.RecoveryFlow2CreationTool_title,
                Messages.RecoveryFlow2CreationTool_desc,
                Collections
                        .singletonList(PalladioComponentModelElementTypes.RecoveryActionBehaviourFailureHandlingAlternatives__RecoveryActionBehaviour_4004));
        entry.setId("createRecoveryFlow2CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelSeffDiagramEditorPlugin
                .findImageDescriptor("/org.palladiosimulator.pcm.edit/icons/full/ctool16/RecoveryFlow.gif")); //$NON-NLS-1$
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private static class NodeToolEntry extends ToolEntry {

        /**
         * @generated
         */
        private final List<IElementType> elementTypes;

        /**
         * @generated
         */
        private NodeToolEntry(String title, String description, List<IElementType> elementTypes) {
            super(title, description, null, null);
            this.elementTypes = elementTypes;
        }

        /**
         * @generated
         */
        public Tool createTool() {
            Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
            tool.setProperties(getToolProperties());
            return tool;
        }
    }

    /**
     * @generated
     */
    private static class LinkToolEntry extends ToolEntry {

        /**
         * @generated
         */
        private final List<IElementType> relationshipTypes;

        /**
         * @generated
         */
        private LinkToolEntry(String title, String description, List<IElementType> relationshipTypes) {
            super(title, description, null, null);
            this.relationshipTypes = relationshipTypes;
        }

        /**
         * @generated
         */
        public Tool createTool() {
            Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
            tool.setProperties(getToolProperties());
            return tool;
        }
    }
}
