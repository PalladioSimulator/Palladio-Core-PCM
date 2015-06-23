/*
 * Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.part;

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

import de.uka.ipd.sdq.pcm.gmf.usage.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class PalladioComponentModelPaletteFactory {

    /**
     * @generated
     */
    public void fillPalette(PaletteRoot paletteRoot) {
        paletteRoot.add(createUserActions1Group());
        paletteRoot.add(createActionDetails2Group());
        paletteRoot.add(createLinks3Group());
        paletteRoot.add(createWorkloads4Group());
    }

    /**
     * @generated
     */
    private PaletteContainer createUserActions1Group() {
        PaletteDrawer paletteContainer = new PaletteDrawer(Messages.UserActions1Group_title);
        paletteContainer.setId("createUserActions1Group"); //$NON-NLS-1$
        paletteContainer.setDescription(Messages.UserActions1Group_desc);
        paletteContainer.add(createStart1CreationTool());
        paletteContainer.add(createStop2CreationTool());
        paletteContainer.add(createDelay3CreationTool());
        paletteContainer.add(createEntryLevelSystemCall4CreationTool());
        paletteContainer.add(createLoop5CreationTool());
        paletteContainer.add(createBranch6CreationTool());
        return paletteContainer;
    }

    /**
     * @generated
     */
    private PaletteContainer createActionDetails2Group() {
        PaletteDrawer paletteContainer = new PaletteDrawer(Messages.ActionDetails2Group_title);
        paletteContainer.setId("createActionDetails2Group"); //$NON-NLS-1$
        paletteContainer.setDescription(Messages.ActionDetails2Group_desc);
        paletteContainer.add(createVariableUsage1CreationTool());
        paletteContainer.add(createVariableCharacterisation2CreationTool());
        paletteContainer.add(createScenarioBehaviour3CreationTool());
        paletteContainer.add(createBranchTransition4CreationTool());
        return paletteContainer;
    }

    /**
     * @generated
     */
    private PaletteContainer createLinks3Group() {
        PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Links3Group_title);
        paletteContainer.setId("createLinks3Group"); //$NON-NLS-1$
        paletteContainer.setDescription(Messages.Links3Group_desc);
        paletteContainer.add(createUsageFlow1CreationTool());
        return paletteContainer;
    }

    /**
     * @generated
     */
    private PaletteContainer createWorkloads4Group() {
        PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Workloads4Group_title);
        paletteContainer.setId("createWorkloads4Group"); //$NON-NLS-1$
        paletteContainer.setDescription(Messages.Workloads4Group_desc);
        paletteContainer.add(createOpenWorkload1CreationTool());
        paletteContainer.add(createClosedWorkload2CreationTool());
        paletteContainer.add(createUsageScenario3CreationTool());
        return paletteContainer;
    }

    /**
     * @generated
     */
    private ToolEntry createStart1CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.Start1CreationTool_title, Messages.Start1CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.Start_3001));
        entry.setId("createStart1CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.Start_3001));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createStop2CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.Stop2CreationTool_title, Messages.Stop2CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.Stop_3002));
        entry.setId("createStop2CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.Stop_3002));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createDelay3CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.Delay3CreationTool_title, Messages.Delay3CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.Delay_3017));
        entry.setId("createDelay3CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.Delay_3017));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createEntryLevelSystemCall4CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.EntryLevelSystemCall4CreationTool_title,
                Messages.EntryLevelSystemCall4CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.EntryLevelSystemCall_3003));
        entry.setId("createEntryLevelSystemCall4CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.EntryLevelSystemCall_3003));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createLoop5CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.Loop5CreationTool_title, Messages.Loop5CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.Loop_3005));
        entry.setId("createLoop5CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.Loop_3005));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createBranch6CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.Branch6CreationTool_title, Messages.Branch6CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.Branch_3008));
        entry.setId("createBranch6CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.Branch_3008));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createUsageFlow1CreationTool() {
        LinkToolEntry entry = new LinkToolEntry(Messages.UsageFlow1CreationTool_title,
                Messages.UsageFlow1CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002));
        entry.setId("createUsageFlow1CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelUsageDiagramEditorPlugin
                .findImageDescriptor("/org.palladiosimulator.pcm.edit/icons/full/ctool16/ControlFlow.gif")); //$NON-NLS-1$
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createVariableUsage1CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.VariableUsage1CreationTool_title,
                Messages.VariableUsage1CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.VariableUsage_3012));
        entry.setId("createVariableUsage1CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.VariableUsage_3012));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createVariableCharacterisation2CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.VariableCharacterisation2CreationTool_title,
                Messages.VariableCharacterisation2CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.VariableCharacterisation_3013));
        entry.setId("createVariableCharacterisation2CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.VariableCharacterisation_3013));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createScenarioBehaviour3CreationTool() {
        ArrayList<IElementType> types = new ArrayList<IElementType>(3);
        types.add(PalladioComponentModelElementTypes.ScenarioBehaviour_3014);
        types.add(PalladioComponentModelElementTypes.ScenarioBehaviour_3007);
        types.add(PalladioComponentModelElementTypes.ScenarioBehaviour_3010);
        NodeToolEntry entry = new NodeToolEntry(Messages.ScenarioBehaviour3CreationTool_title,
                Messages.ScenarioBehaviour3CreationTool_desc, types);
        entry.setId("createScenarioBehaviour3CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.ScenarioBehaviour_3014));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createBranchTransition4CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.BranchTransition4CreationTool_title,
                Messages.BranchTransition4CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.BranchTransition_3009));
        entry.setId("createBranchTransition4CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.BranchTransition_3009));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createOpenWorkload1CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.OpenWorkload1CreationTool_title,
                Messages.OpenWorkload1CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.OpenWorkload_3016));
        entry.setId("createOpenWorkload1CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.OpenWorkload_3016));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createClosedWorkload2CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.ClosedWorkload2CreationTool_title,
                Messages.ClosedWorkload2CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.ClosedWorkload_3015));
        entry.setId("createClosedWorkload2CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.ClosedWorkload_3015));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createUsageScenario3CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.UsageScenario3CreationTool_title,
                Messages.UsageScenario3CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.UsageScenario_2004));
        entry.setId("createUsageScenario3CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.UsageScenario_2004));
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
