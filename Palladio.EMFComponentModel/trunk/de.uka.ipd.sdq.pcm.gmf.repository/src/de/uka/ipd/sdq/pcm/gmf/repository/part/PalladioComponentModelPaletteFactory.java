/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
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
		paletteRoot.add(createBasicModelElements1Group());
		paletteRoot.add(createInternalElements2Group());
		paletteRoot.add(createComponentTypes3Group());
	}

	/**
	 * Creates "Basic Model Elements" palette tool group
	 * @generated
	 */
	private PaletteContainer createBasicModelElements1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.BasicModelElements1Group_title);
		paletteContainer.setDescription(Messages.BasicModelElements1Group_desc);
		paletteContainer.add(createInterface1CreationTool());
		paletteContainer.add(createBasicComponent2CreationTool());
		paletteContainer.add(createCompositeComponent3CreationTool());
		paletteContainer.add(createRequiredRole4CreationTool());
		paletteContainer.add(createProvidedRole5CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Internal Elements" palette tool group
	 * @generated
	 */
	private PaletteContainer createInternalElements2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.InternalElements2Group_title);
		paletteContainer.setDescription(Messages.InternalElements2Group_desc);
		paletteContainer.add(createSignature1CreationTool());
		paletteContainer.add(createSEFF2CreationTool());
		paletteContainer.add(createPassiveResource3CreationTool());
		paletteContainer.add(createComponentParameter4CreationTool());
		paletteContainer.add(createVariableCharacterisation5CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Component Types" palette tool group
	 * @generated
	 */
	private PaletteContainer createComponentTypes3Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.ComponentTypes3Group_title);
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
	private ToolEntry createInterface1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.Interface_2101);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Interface1CreationTool_title,
				Messages.Interface1CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.Interface_2101));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createBasicComponent2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.BasicComponent_2102);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.BasicComponent2CreationTool_title,
				Messages.BasicComponent2CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.BasicComponent_2102));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCompositeComponent3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.CompositeComponent_2105);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.CompositeComponent3CreationTool_title,
				Messages.CompositeComponent3CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.CompositeComponent_2105));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRequiredRole4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.RequiredRole_4102);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.RequiredRole4CreationTool_title,
				Messages.RequiredRole4CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.RequiredRole_4102));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProvidedRole5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.ProvidedRole_4101);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.ProvidedRole5CreationTool_title,
				Messages.ProvidedRole5CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.ProvidedRole_4101));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
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
	private ToolEntry createSEFF2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.ResourceDemandingSEFF_3102);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.SEFF2CreationTool_title,
				Messages.SEFF2CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.ResourceDemandingSEFF_3102));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPassiveResource3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.PassiveResource_3103);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.PassiveResource3CreationTool_title,
				Messages.PassiveResource3CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.PassiveResource_3103));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createComponentParameter4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.VariableUsage_3104);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ComponentParameter4CreationTool_title,
				Messages.ComponentParameter4CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.VariableUsage_3104));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createVariableCharacterisation5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.VariableCharacterisation_3105);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.VariableCharacterisation5CreationTool_title,
				Messages.VariableCharacterisation5CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.VariableCharacterisation_3105));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProvidesComponentType1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.ProvidesComponentType_2104);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ProvidesComponentType1CreationTool_title,
				Messages.ProvidesComponentType1CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.ProvidesComponentType_2104));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCompleteComponentType2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.CompleteComponentType_2103);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.CompleteComponentType2CreationTool_title,
				Messages.CompleteComponentType2CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.CompleteComponentType_2103));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createConformsProvidedType3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.CompleteComponentTypeParentProvidesComponentTypes_4104);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.ConformsProvidedType3CreationTool_title,
				Messages.ConformsProvidedType3CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.CompleteComponentTypeParentProvidesComponentTypes_4104));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createConformsCompleteType4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.ImplementationComponentTypeParentCompleteComponentTypes_4103);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.ConformsCompleteType4CreationTool_title,
				Messages.ConformsCompleteType4CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.ImplementationComponentTypeParentCompleteComponentTypes_4103));
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
