/*
 * Copyright 2009, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.resource.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;

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
	 * Creates "pcm" palette tool group
	 * @generated
	 */
	private PaletteContainer createPcm1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Pcm1Group_title);
		paletteContainer.setId("createPcm1Group"); //$NON-NLS-1$
		paletteContainer.add(createResourceContainer1CreationTool());
		paletteContainer
				.add(createCommunicationLinkResourceSpecification2CreationTool());
		paletteContainer.add(createLinkingResource3CreationTool());
		paletteContainer.add(createProcessingResourceSpecification4CreationTool());
		paletteContainer.add(createConnection5CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createResourceContainer1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.ResourceContainer_2001);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ResourceContainer1CreationTool_title,
				Messages.ResourceContainer1CreationTool_desc, types);
		entry.setId("createResourceContainer1CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.ResourceContainer_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCommunicationLinkResourceSpecification2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.CommunicationLinkResourceSpecification_3002);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.CommunicationLinkResourceSpecification2CreationTool_title,
				Messages.CommunicationLinkResourceSpecification2CreationTool_desc,
				types);
		entry.setId("createCommunicationLinkResourceSpecification2CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.CommunicationLinkResourceSpecification_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLinkingResource3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.LinkingResource_2003);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.LinkingResource3CreationTool_title,
				Messages.LinkingResource3CreationTool_desc, types);
		entry.setId("createLinkingResource3CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.LinkingResource_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProcessingResourceSpecification4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.ProcessingResourceSpecification_3001);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ProcessingResourceSpecification4CreationTool_title,
				Messages.ProcessingResourceSpecification4CreationTool_desc, types);
		entry.setId("createProcessingResourceSpecification4CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.ProcessingResourceSpecification_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createConnection5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.LinkingResourceFromResourceContainer_LinkingResource_4001);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Connection5CreationTool_title,
				Messages.Connection5CreationTool_desc, types);
		entry.setId("createConnection5CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(PalladioComponentModelDiagramEditorPlugin
						.findImageDescriptor("/de.uka.ipd.sdq.pcm.edit/icons/full/obj16/CommunicationLink.gif")); //$NON-NLS-1$
		entry
				.setLargeIcon(PalladioComponentModelDiagramEditorPlugin
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
		private final List elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description, List elementTypes) {
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
		private final List relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description,
				List relationshipTypes) {
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
