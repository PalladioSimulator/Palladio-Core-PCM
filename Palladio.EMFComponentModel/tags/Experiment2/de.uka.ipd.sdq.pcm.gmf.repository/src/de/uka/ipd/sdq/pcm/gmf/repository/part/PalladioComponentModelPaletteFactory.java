/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;

import de.uka.ipd.sdq.pcm.gmf.repository.providers.PalladioComponentModelElementTypes;

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
		PaletteGroup paletteContainer = new PaletteGroup(
				Messages.Pcm1Group_title);
		paletteContainer.add(createSignature1CreationTool());
		paletteContainer.add(createRequiredRole2CreationTool());
		paletteContainer.add(createInterface3CreationTool());
		paletteContainer.add(createProvidedRole4CreationTool());
		paletteContainer.add(createCompleteComponentType5CreationTool());
		paletteContainer.add(createCompositeComponent6CreationTool());
		paletteContainer.add(createBasicComponent7CreationTool());
		paletteContainer.add(createProvidesComponentType8CreationTool());
		paletteContainer.add(createSEFF9CreationTool());
		paletteContainer.add(createCompleteParentType10CreationTool());
		paletteContainer.add(createProvidesParentType11CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSignature1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.Signature_3101);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Signature1CreationTool_title,
				Messages.Signature1CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.Signature_3101));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRequiredRole2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.RequiredRole_4102);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.RequiredRole2CreationTool_title,
				Messages.RequiredRole2CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.RequiredRole_4102));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInterface3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.Interface_2101);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Interface3CreationTool_title,
				Messages.Interface3CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.Interface_2101));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProvidedRole4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.ProvidedRole_4101);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.ProvidedRole4CreationTool_title,
				Messages.ProvidedRole4CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.ProvidedRole_4101));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCompleteComponentType5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.CompleteComponentType_2103);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.CompleteComponentType5CreationTool_title,
				Messages.CompleteComponentType5CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.CompleteComponentType_2103));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCompositeComponent6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.CompositeComponent_2105);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.CompositeComponent6CreationTool_title,
				Messages.CompositeComponent6CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.CompositeComponent_2105));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createBasicComponent7CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.BasicComponent_2102);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.BasicComponent7CreationTool_title,
				Messages.BasicComponent7CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.BasicComponent_2102));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProvidesComponentType8CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.ProvidesComponentType_2104);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ProvidesComponentType8CreationTool_title,
				Messages.ProvidesComponentType8CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.ProvidesComponentType_2104));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSEFF9CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.ResourceDemandingSEFF_3102);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.SEFF9CreationTool_title,
				Messages.SEFF9CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.ResourceDemandingSEFF_3102));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCompleteParentType10CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.ImplementationComponentTypeParentCompleteComponentTypes_4103);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.CompleteParentType10CreationTool_title,
				Messages.CompleteParentType10CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.ImplementationComponentTypeParentCompleteComponentTypes_4103));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProvidesParentType11CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.CompleteComponentTypeParentProvidesComponentTypes_4104);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.ProvidesParentType11CreationTool_title,
				Messages.ProvidesParentType11CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.CompleteComponentTypeParentProvidesComponentTypes_4104));
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
		private final List elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description,
				List elementTypes) {
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
