/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;

import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes;

/**
 * A factory for creating PalladioComponentModelPalette objects.
 *
 * @generated
 */
public class PalladioComponentModelPaletteFactory {

	/**
	 * Fill palette.
	 *
	 * @param paletteRoot the palette root
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createNodes1Group());
		paletteRoot.add(createLinks2Group());
	}

	/**
	 * Creates "Nodes" palette tool group.
	 *
	 * @return the palette container
	 * @generated
	 */
	private PaletteContainer createNodes1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Nodes1Group_title);
		paletteContainer.setId("createNodes1Group"); //$NON-NLS-1$
		paletteContainer.add(createAssemblyContext1CreationTool());
		paletteContainer.add(createSystemOperationRequiredRole2CreationTool());
		paletteContainer.add(createSystemOperationProvidedRole3CreationTool());
		paletteContainer.add(createEventChannel4CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Links" palette tool group.
	 *
	 * @return the palette container
	 * @generated
	 */
	private PaletteContainer createLinks2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Links2Group_title);
		paletteContainer.setId("createLinks2Group"); //$NON-NLS-1$
		paletteContainer
				.add(createOperationRequiredDelegationConnector1CreationTool());
		paletteContainer.add(createAssemblyConnector2CreationTool());
		paletteContainer
				.add(createAssemblyInfrastructureConnector3CreationTool());
		paletteContainer.add(createAssemblyEventConnector4CreationTool());
		paletteContainer
				.add(createOperationProvidedDelegationConnector5CreationTool());
		paletteContainer.add(createEventChannelSourceConnector6CreationTool());
		paletteContainer.add(createEventChannelSinkConnector7CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates a new PalladioComponentModelPalette object.
	 *
	 * @return the tool entry
	 * @generated
	 */
	private ToolEntry createAssemblyContext1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.AssemblyContext_3006);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.AssemblyContext1CreationTool_title,
				Messages.AssemblyContext1CreationTool_desc, types);
		entry.setId("createAssemblyContext1CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.AssemblyContext_3006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * Creates a new PalladioComponentModelPalette object.
	 *
	 * @return the tool entry
	 * @generated
	 */
	private ToolEntry createSystemOperationRequiredRole2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.OperationRequiredRole_3012);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.SystemOperationRequiredRole2CreationTool_title,
				Messages.SystemOperationRequiredRole2CreationTool_desc, types);
		entry.setId("createSystemOperationRequiredRole2CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.OperationRequiredRole_3012));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * Creates a new PalladioComponentModelPalette object.
	 *
	 * @return the tool entry
	 * @generated
	 */
	private ToolEntry createSystemOperationProvidedRole3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.OperationProvidedRole_3011);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.SystemOperationProvidedRole3CreationTool_title,
				Messages.SystemOperationProvidedRole3CreationTool_desc, types);
		entry.setId("createSystemOperationProvidedRole3CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.OperationProvidedRole_3011));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * Creates a new PalladioComponentModelPalette object.
	 *
	 * @return the tool entry
	 * @generated
	 */
	private ToolEntry createEventChannel4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.EventChannel_3017);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.EventChannel4CreationTool_title,
				Messages.EventChannel4CreationTool_desc, types);
		entry.setId("createEventChannel4CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.EventChannel_3017));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * Creates a new PalladioComponentModelPalette object.
	 *
	 * @return the tool entry
	 * @generated
	 */
	private ToolEntry createOperationRequiredDelegationConnector1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.RequiredDelegationConnector_4005);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.OperationRequiredDelegationConnector1CreationTool_title,
				Messages.OperationRequiredDelegationConnector1CreationTool_desc,
				types);
		entry.setId("createOperationRequiredDelegationConnector1CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.RequiredDelegationConnector_4005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * Creates a new PalladioComponentModelPalette object.
	 *
	 * @return the tool entry
	 * @generated
	 */
	private ToolEntry createAssemblyConnector2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.AssemblyConnector_4004);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.AssemblyConnector2CreationTool_title,
				Messages.AssemblyConnector2CreationTool_desc, types);
		entry.setId("createAssemblyConnector2CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.AssemblyConnector_4004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * Creates a new PalladioComponentModelPalette object.
	 *
	 * @return the tool entry
	 * @generated
	 */
	private ToolEntry createAssemblyInfrastructureConnector3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.AssemblyInfrastructureConnector_4008);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.AssemblyInfrastructureConnector3CreationTool_title,
				Messages.AssemblyInfrastructureConnector3CreationTool_desc,
				types);
		entry.setId("createAssemblyInfrastructureConnector3CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.AssemblyInfrastructureConnector_4008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * Creates a new PalladioComponentModelPalette object.
	 *
	 * @return the tool entry
	 * @generated
	 */
	private ToolEntry createAssemblyEventConnector4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.AssemblyEventConnector_4007);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.AssemblyEventConnector4CreationTool_title,
				Messages.AssemblyEventConnector4CreationTool_desc, types);
		entry.setId("createAssemblyEventConnector4CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.AssemblyEventConnector_4007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * Creates a new PalladioComponentModelPalette object.
	 *
	 * @return the tool entry
	 * @generated
	 */
	private ToolEntry createOperationProvidedDelegationConnector5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.ProvidedDelegationConnector_4006);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.OperationProvidedDelegationConnector5CreationTool_title,
				Messages.OperationProvidedDelegationConnector5CreationTool_desc,
				types);
		entry.setId("createOperationProvidedDelegationConnector5CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.ProvidedDelegationConnector_4006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
<<<<<<< .mine
	 * The Class NodeToolEntry.
	 *
	 * @generated
	 */
	private ToolEntry createEventChannelSourceConnector6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.EventChannelSourceConnector_4009);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.EventChannelSourceConnector6CreationTool_title,
				Messages.EventChannelSourceConnector6CreationTool_desc, types);
		entry.setId("createEventChannelSourceConnector6CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.EventChannelSourceConnector_4009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEventChannelSinkConnector7CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.EventChannelSinkConnector_4010);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.EventChannelSinkConnector7CreationTool_title,
				Messages.EventChannelSinkConnector7CreationTool_desc, types);
		entry.setId("createEventChannelSinkConnector7CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.EventChannelSinkConnector_4010));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
=======
	 * The Class NodeToolEntry.
	 *
>>>>>>> .r16773
	 * @generated
	 */
	private static class NodeToolEntry extends ToolEntry {

		/** The element types. @generated */
		private final List elementTypes;

		/**
		 * Instantiates a new node tool entry.
		 *
		 * @param title the title
		 * @param description the description
		 * @param elementTypes the element types
		 * @generated
		 */
		private NodeToolEntry(String title, String description,
				List elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * Creates the tool.
		 *
		 * @return the tool
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * The Class LinkToolEntry.
	 *
	 * @generated
	 */
	private static class LinkToolEntry extends ToolEntry {

		/** The relationship types. @generated */
		private final List relationshipTypes;

		/**
		 * Instantiates a new link tool entry.
		 *
		 * @param title the title
		 * @param description the description
		 * @param relationshipTypes the relationship types
		 * @generated
		 */
		private LinkToolEntry(String title, String description,
				List relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * Creates the tool.
		 *
		 * @return the tool
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}
