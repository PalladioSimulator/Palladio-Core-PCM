/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.part;

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

import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class PalladioComponentModelPaletteFactory {

    /**
     * @generated
     */
    public void fillPalette(PaletteRoot paletteRoot) {
        paletteRoot.add(createNodes1Group());
        paletteRoot.add(createLinks2Group());
    }

    /**
     * Creates "Nodes" palette tool group
     * 
     * @generated
     */
    private PaletteContainer createNodes1Group() {
        PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Nodes1Group_title);
        paletteContainer.setId("createNodes1Group"); //$NON-NLS-1$
        paletteContainer.add(createAssemblyContext1CreationTool());
        paletteContainer.add(createSystemOperationRequiredRole2CreationTool());
        paletteContainer.add(createSystemOperationProvidedRole3CreationTool());
        paletteContainer.add(createEventChannel4CreationTool());
        return paletteContainer;
    }

    /**
     * Creates "Links" palette tool group
     * 
     * @generated
     */
    private PaletteContainer createLinks2Group() {
        PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Links2Group_title);
        paletteContainer.setId("createLinks2Group"); //$NON-NLS-1$
        paletteContainer.add(createOperationRequiredDelegationConnector1CreationTool());
        paletteContainer.add(createAssemblyConnector2CreationTool());
        paletteContainer.add(createAssemblyInfrastructureConnector3CreationTool());
        paletteContainer.add(createAssemblyEventConnector4CreationTool());
        paletteContainer.add(createOperationProvidedDelegationConnector5CreationTool());
        paletteContainer.add(createEventChannelSourceConnector6CreationTool());
        paletteContainer.add(createEventChannelSinkConnector7CreationTool());
        return paletteContainer;
    }

    /**
     * @generated
     */
    private ToolEntry createAssemblyContext1CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.AssemblyContext1CreationTool_title,
                Messages.AssemblyContext1CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.AssemblyContext_3006));
        entry.setId("createAssemblyContext1CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.AssemblyContext_3006));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createSystemOperationRequiredRole2CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.SystemOperationRequiredRole2CreationTool_title,
                Messages.SystemOperationRequiredRole2CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.OperationRequiredRole_3012));
        entry.setId("createSystemOperationRequiredRole2CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.OperationRequiredRole_3012));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createSystemOperationProvidedRole3CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.SystemOperationProvidedRole3CreationTool_title,
                Messages.SystemOperationProvidedRole3CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.OperationProvidedRole_3011));
        entry.setId("createSystemOperationProvidedRole3CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.OperationProvidedRole_3011));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createEventChannel4CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.EventChannel4CreationTool_title,
                Messages.EventChannel4CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.EventChannel_3017));
        entry.setId("createEventChannel4CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.EventChannel_3017));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createOperationRequiredDelegationConnector1CreationTool() {
        LinkToolEntry entry = new LinkToolEntry(Messages.OperationRequiredDelegationConnector1CreationTool_title,
                Messages.OperationRequiredDelegationConnector1CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.RequiredDelegationConnector_4005));
        entry.setId("createOperationRequiredDelegationConnector1CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.RequiredDelegationConnector_4005));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createAssemblyConnector2CreationTool() {
        LinkToolEntry entry = new LinkToolEntry(Messages.AssemblyConnector2CreationTool_title,
                Messages.AssemblyConnector2CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.AssemblyConnector_4004));
        entry.setId("createAssemblyConnector2CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.AssemblyConnector_4004));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createAssemblyInfrastructureConnector3CreationTool() {
        LinkToolEntry entry = new LinkToolEntry(Messages.AssemblyInfrastructureConnector3CreationTool_title,
                Messages.AssemblyInfrastructureConnector3CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.AssemblyInfrastructureConnector_4008));
        entry.setId("createAssemblyInfrastructureConnector3CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.AssemblyInfrastructureConnector_4008));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createAssemblyEventConnector4CreationTool() {
        LinkToolEntry entry = new LinkToolEntry(Messages.AssemblyEventConnector4CreationTool_title,
                Messages.AssemblyEventConnector4CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.AssemblyEventConnector_4007));
        entry.setId("createAssemblyEventConnector4CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.AssemblyEventConnector_4007));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createOperationProvidedDelegationConnector5CreationTool() {
        LinkToolEntry entry = new LinkToolEntry(Messages.OperationProvidedDelegationConnector5CreationTool_title,
                Messages.OperationProvidedDelegationConnector5CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.ProvidedDelegationConnector_4006));
        entry.setId("createOperationProvidedDelegationConnector5CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.ProvidedDelegationConnector_4006));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createEventChannelSourceConnector6CreationTool() {
        LinkToolEntry entry = new LinkToolEntry(Messages.EventChannelSourceConnector6CreationTool_title,
                Messages.EventChannelSourceConnector6CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.EventChannelSourceConnector_4009));
        entry.setId("createEventChannelSourceConnector6CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.EventChannelSourceConnector_4009));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createEventChannelSinkConnector7CreationTool() {
        LinkToolEntry entry = new LinkToolEntry(Messages.EventChannelSinkConnector7CreationTool_title,
                Messages.EventChannelSinkConnector7CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.EventChannelSinkConnector_4010));
        entry.setId("createEventChannelSinkConnector7CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.EventChannelSinkConnector_4010));
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
