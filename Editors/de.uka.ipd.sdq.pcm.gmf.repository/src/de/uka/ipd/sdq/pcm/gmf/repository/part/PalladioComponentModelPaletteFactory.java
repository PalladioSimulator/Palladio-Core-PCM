/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.part;

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

import de.uka.ipd.sdq.pcm.gmf.repository.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class PalladioComponentModelPaletteFactory {

    /**
     * @generated
     */
    public void fillPalette(PaletteRoot paletteRoot) {
        paletteRoot.add(createBasicModelElements1Group());
        paletteRoot.add(createInternalElements2Group());
        paletteRoot.add(createComponentTypes3Group());
        paletteRoot.add(createEventBasedCommunication4Group());
    }

    /**
     * @generated
     */
    private PaletteContainer createBasicModelElements1Group() {
        PaletteDrawer paletteContainer = new PaletteDrawer(Messages.BasicModelElements1Group_title);
        paletteContainer.setId("createBasicModelElements1Group"); //$NON-NLS-1$
        paletteContainer.setDescription(Messages.BasicModelElements1Group_desc);
        paletteContainer.add(createInterface1CreationTool());
        paletteContainer.add(createBasicComponent2CreationTool());
        paletteContainer.add(createCompositeComponent3CreationTool());
        paletteContainer.add(createRequiredRole4CreationTool());
        paletteContainer.add(createProvidedRole5CreationTool());
        paletteContainer.add(createSubSystem6CreationTool());
        paletteContainer.add(createInfrastructureProvidedRole7CreationTool());
        paletteContainer.add(createInfrastructureRequiredRole8CreationTool());
        paletteContainer.add(createInfrastructureInterface9CreationTool());
        return paletteContainer;
    }

    /**
     * @generated
     */
    private PaletteContainer createInternalElements2Group() {
        PaletteDrawer paletteContainer = new PaletteDrawer(Messages.InternalElements2Group_title);
        paletteContainer.setId("createInternalElements2Group"); //$NON-NLS-1$
        paletteContainer.setDescription(Messages.InternalElements2Group_desc);
        paletteContainer.add(createSignature1CreationTool());
        paletteContainer.add(createSEFF2CreationTool());
        paletteContainer.add(createPassiveResource3CreationTool());
        paletteContainer.add(createComponentParameter4CreationTool());
        paletteContainer.add(createVariableCharacterisation5CreationTool());
        return paletteContainer;
    }

    /**
     * @generated
     */
    private PaletteContainer createComponentTypes3Group() {
        PaletteDrawer paletteContainer = new PaletteDrawer(Messages.ComponentTypes3Group_title);
        paletteContainer.setId("createComponentTypes3Group"); //$NON-NLS-1$
        paletteContainer.setDescription(Messages.ComponentTypes3Group_desc);
        paletteContainer.add(createProvidesComponentType1CreationTool());
        paletteContainer.add(createCompleteComponentType2CreationTool());
        paletteContainer.add(createConformsProvidedType3CreationTool());
        paletteContainer.add(createConformsCompleteType4CreationTool());
        return paletteContainer;
    }

    /**
     * @generated
     */
    private PaletteContainer createEventBasedCommunication4Group() {
        PaletteDrawer paletteContainer = new PaletteDrawer(Messages.EventBasedCommunication4Group_title);
        paletteContainer.setId("createEventBasedCommunication4Group"); //$NON-NLS-1$
        paletteContainer.setDescription(Messages.EventBasedCommunication4Group_desc);
        paletteContainer.add(createEventGroup1CreationTool());
        paletteContainer.add(createEventType2CreationTool());
        paletteContainer.add(createSourceRole3CreationTool());
        paletteContainer.add(createSinkRole4CreationTool());
        return paletteContainer;
    }

    /**
     * @generated
     */
    private ToolEntry createInterface1CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.Interface1CreationTool_title,
                Messages.Interface1CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.OperationInterface_2107));
        entry.setId("createInterface1CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.OperationInterface_2107));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createBasicComponent2CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.BasicComponent2CreationTool_title,
                Messages.BasicComponent2CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.BasicComponent_2102));
        entry.setId("createBasicComponent2CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.BasicComponent_2102));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createCompositeComponent3CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.CompositeComponent3CreationTool_title,
                Messages.CompositeComponent3CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.CompositeComponent_2103));
        entry.setId("createCompositeComponent3CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.CompositeComponent_2103));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createRequiredRole4CreationTool() {
        LinkToolEntry entry = new LinkToolEntry(Messages.RequiredRole4CreationTool_title,
                Messages.RequiredRole4CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.OperationRequiredRole_4106));
        entry.setId("createRequiredRole4CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.OperationRequiredRole_4106));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createProvidedRole5CreationTool() {
        LinkToolEntry entry = new LinkToolEntry(Messages.ProvidedRole5CreationTool_title,
                Messages.ProvidedRole5CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.OperationProvidedRole_4105));
        entry.setId("createProvidedRole5CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.OperationProvidedRole_4105));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createSubSystem6CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.SubSystem6CreationTool_title,
                Messages.SubSystem6CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.SubSystem_2106));
        entry.setId("createSubSystem6CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.SubSystem_2106));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createInfrastructureProvidedRole7CreationTool() {
        LinkToolEntry entry = new LinkToolEntry(Messages.InfrastructureProvidedRole7CreationTool_title,
                Messages.InfrastructureProvidedRole7CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.InfrastructureProvidedRole_4111));
        entry.setId("createInfrastructureProvidedRole7CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.InfrastructureProvidedRole_4111));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createInfrastructureRequiredRole8CreationTool() {
        LinkToolEntry entry = new LinkToolEntry(Messages.InfrastructureRequiredRole8CreationTool_title,
                Messages.InfrastructureRequiredRole8CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.InfrastructureRequiredRole_4112));
        entry.setId("createInfrastructureRequiredRole8CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.InfrastructureRequiredRole_4112));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createInfrastructureInterface9CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.InfrastructureInterface9CreationTool_title,
                Messages.InfrastructureInterface9CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.InfrastructureInterface_2109));
        entry.setId("createInfrastructureInterface9CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.InfrastructureInterface_2109));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createSignature1CreationTool() {
        ArrayList<IElementType> types = new ArrayList<IElementType>(2);
        types.add(PalladioComponentModelElementTypes.OperationSignature_3106);
        types.add(PalladioComponentModelElementTypes.InfrastructureSignature_3108);
        NodeToolEntry entry = new NodeToolEntry(Messages.Signature1CreationTool_title,
                Messages.Signature1CreationTool_desc, types);
        entry.setId("createSignature1CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.OperationSignature_3106));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createSEFF2CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.SEFF2CreationTool_title, Messages.SEFF2CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.ResourceDemandingSEFF_3102));
        entry.setId("createSEFF2CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.ResourceDemandingSEFF_3102));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createPassiveResource3CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.PassiveResource3CreationTool_title,
                Messages.PassiveResource3CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.PassiveResource_3103));
        entry.setId("createPassiveResource3CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.PassiveResource_3103));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createComponentParameter4CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.ComponentParameter4CreationTool_title,
                Messages.ComponentParameter4CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.VariableUsage_3104));
        entry.setId("createComponentParameter4CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.VariableUsage_3104));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createVariableCharacterisation5CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.VariableCharacterisation5CreationTool_title,
                Messages.VariableCharacterisation5CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.VariableCharacterisation_3105));
        entry.setId("createVariableCharacterisation5CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.VariableCharacterisation_3105));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createProvidesComponentType1CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.ProvidesComponentType1CreationTool_title,
                Messages.ProvidesComponentType1CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.ProvidesComponentType_2105));
        entry.setId("createProvidesComponentType1CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.ProvidesComponentType_2105));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createCompleteComponentType2CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.CompleteComponentType2CreationTool_title,
                Messages.CompleteComponentType2CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.CompleteComponentType_2104));
        entry.setId("createCompleteComponentType2CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.CompleteComponentType_2104));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createConformsProvidedType3CreationTool() {
        LinkToolEntry entry = new LinkToolEntry(
                Messages.ConformsProvidedType3CreationTool_title,
                Messages.ConformsProvidedType3CreationTool_desc,
                Collections
                        .singletonList(PalladioComponentModelElementTypes.CompleteComponentTypeParentProvidesComponentTypes_4104));
        entry.setId("createConformsProvidedType3CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.CompleteComponentTypeParentProvidesComponentTypes_4104));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createConformsCompleteType4CreationTool() {
        LinkToolEntry entry = new LinkToolEntry(
                Messages.ConformsCompleteType4CreationTool_title,
                Messages.ConformsCompleteType4CreationTool_desc,
                Collections
                        .singletonList(PalladioComponentModelElementTypes.ImplementationComponentTypeParentCompleteComponentTypes_4103));
        entry.setId("createConformsCompleteType4CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.ImplementationComponentTypeParentCompleteComponentTypes_4103));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createEventGroup1CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.EventGroup1CreationTool_title,
                Messages.EventGroup1CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.EventGroup_2108));
        entry.setId("createEventGroup1CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.EventGroup_2108));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createEventType2CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.EventType2CreationTool_title,
                Messages.EventType2CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.EventType_3107));
        entry.setId("createEventType2CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.EventType_3107));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createSourceRole3CreationTool() {
        LinkToolEntry entry = new LinkToolEntry(Messages.SourceRole3CreationTool_title,
                Messages.SourceRole3CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.SourceRole_4110));
        entry.setId("createSourceRole3CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.SourceRole_4110));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createSinkRole4CreationTool() {
        LinkToolEntry entry = new LinkToolEntry(Messages.SinkRole4CreationTool_title,
                Messages.SinkRole4CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.SinkRole_4109));
        entry.setId("createSinkRole4CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.SinkRole_4109));
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
