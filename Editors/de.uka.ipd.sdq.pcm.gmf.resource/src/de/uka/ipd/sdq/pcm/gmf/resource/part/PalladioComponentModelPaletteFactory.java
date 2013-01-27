/*
 * Copyright 2009, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.resource.part;

import java.util.Collections;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import de.uka.ipd.sdq.pcm.gmf.resource.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class PalladioComponentModelPaletteFactory {

    /**
     * @generated
     */
    public void fillPalette(PaletteRoot paletteRoot) {
        paletteRoot.add(createPcm1Group());
    }

    /**
     * @generated
     */
    private PaletteContainer createPcm1Group() {
        PaletteGroup paletteContainer = new PaletteGroup(Messages.Pcm1Group_title);
        paletteContainer.setId("createPcm1Group"); //$NON-NLS-1$
        paletteContainer.add(createResourceContainer1CreationTool());
        paletteContainer.add(createLinkingResource2CreationTool());
        paletteContainer.add(createProcessingResourceSpecification3CreationTool());
        paletteContainer.add(createConnection4CreationTool());
        return paletteContainer;
    }

    /**
     * @generated
     */
    private ToolEntry createResourceContainer1CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.ResourceContainer1CreationTool_title,
                Messages.ResourceContainer1CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.ResourceContainer_2004));
        entry.setId("createResourceContainer1CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.ResourceContainer_2004));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createLinkingResource2CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.LinkingResource2CreationTool_title,
                Messages.LinkingResource2CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.LinkingResource_2005));
        entry.setId("createLinkingResource2CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.LinkingResource_2005));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createProcessingResourceSpecification3CreationTool() {
        NodeToolEntry entry = new NodeToolEntry(Messages.ProcessingResourceSpecification3CreationTool_title,
                Messages.ProcessingResourceSpecification3CreationTool_desc,
                Collections.singletonList(PalladioComponentModelElementTypes.ProcessingResourceSpecification_3003));
        entry.setId("createProcessingResourceSpecification3CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelElementTypes
                .getImageDescriptor(PalladioComponentModelElementTypes.ProcessingResourceSpecification_3003));
        entry.setLargeIcon(entry.getSmallIcon());
        return entry;
    }

    /**
     * @generated
     */
    private ToolEntry createConnection4CreationTool() {
        LinkToolEntry entry = new LinkToolEntry(
                Messages.Connection4CreationTool_title,
                Messages.Connection4CreationTool_desc,
                Collections
                        .singletonList(PalladioComponentModelElementTypes.LinkingResourceConnectedResourceContainers_LinkingResource_4003));
        entry.setId("createConnection4CreationTool"); //$NON-NLS-1$
        entry.setSmallIcon(PalladioComponentModelDiagramEditorPlugin
                .findImageDescriptor("/de.uka.ipd.sdq.pcm.edit/icons/full/obj16/CommunicationLink.gif")); //$NON-NLS-1$
        entry.setLargeIcon(PalladioComponentModelDiagramEditorPlugin
                .findImageDescriptor("/de.uka.ipd.sdq.pcm.edit/icons/full/obj16/CommunicationLink.gif")); //$NON-NLS-1$
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
