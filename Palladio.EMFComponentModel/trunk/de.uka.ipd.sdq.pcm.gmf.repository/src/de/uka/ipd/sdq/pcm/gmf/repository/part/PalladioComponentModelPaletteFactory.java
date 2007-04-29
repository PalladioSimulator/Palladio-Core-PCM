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
		paletteContainer.add(createRequiredDelegationConnector4CreationTool());
		paletteContainer.add(createChildComponentContext5CreationTool());
		paletteContainer.add(createProvidedRole6CreationTool());
		paletteContainer.add(createProvidedDelegationConnector7CreationTool());
		paletteContainer.add(createCompleteComponentType8CreationTool());
		paletteContainer.add(createCompositeComponent9CreationTool());
		paletteContainer.add(createCompositeAssemblyConnector10CreationTool());
		paletteContainer.add(createBasicComponent11CreationTool());
		paletteContainer.add(createProvidesComponentType12CreationTool());
		paletteContainer.add(createSEFF13CreationTool());
		paletteContainer.add(createCompleteParentType14CreationTool());
		paletteContainer.add(createProvidesParentType15CreationTool());
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
	private ToolEntry createRequiredDelegationConnector4CreationTool() {
		ToolEntry entry = new ToolEntry(
				Messages.RequiredDelegationConnector4CreationTool_title,
				Messages.RequiredDelegationConnector4CreationTool_desc, null,
				null) {
		};
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createChildComponentContext5CreationTool() {
		ToolEntry entry = new ToolEntry(
				Messages.ChildComponentContext5CreationTool_title,
				Messages.ChildComponentContext5CreationTool_desc, null, null) {
		};
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProvidedRole6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.ProvidedRole_4101);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.ProvidedRole6CreationTool_title,
				Messages.ProvidedRole6CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.ProvidedRole_4101));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProvidedDelegationConnector7CreationTool() {
		ToolEntry entry = new ToolEntry(
				Messages.ProvidedDelegationConnector7CreationTool_title,
				Messages.ProvidedDelegationConnector7CreationTool_desc, null,
				null) {
		};
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCompleteComponentType8CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.CompleteComponentType_2103);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.CompleteComponentType8CreationTool_title,
				Messages.CompleteComponentType8CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.CompleteComponentType_2103));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCompositeComponent9CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.CompositeComponent_2105);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.CompositeComponent9CreationTool_title,
				Messages.CompositeComponent9CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.CompositeComponent_2105));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCompositeAssemblyConnector10CreationTool() {
		ToolEntry entry = new ToolEntry(
				Messages.CompositeAssemblyConnector10CreationTool_title,
				Messages.CompositeAssemblyConnector10CreationTool_desc, null,
				null) {
		};
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createBasicComponent11CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.BasicComponent_2102);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.BasicComponent11CreationTool_title,
				Messages.BasicComponent11CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.BasicComponent_2102));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProvidesComponentType12CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.ProvidesComponentType_2104);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ProvidesComponentType12CreationTool_title,
				Messages.ProvidesComponentType12CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.ProvidesComponentType_2104));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSEFF13CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.ResourceDemandingSEFF_3102);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.SEFF13CreationTool_title,
				Messages.SEFF13CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.ResourceDemandingSEFF_3102));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCompleteParentType14CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.ImplementationComponentTypeParentCompleteComponentTypes_4103);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.CompleteParentType14CreationTool_title,
				Messages.CompleteParentType14CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.ImplementationComponentTypeParentCompleteComponentTypes_4103));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProvidesParentType15CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.CompleteComponentTypeParentProvidesComponentTypes_4104);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.ProvidesParentType15CreationTool_title,
				Messages.ProvidesParentType15CreationTool_desc, types);
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
