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
	 * @generated
	 */
	private PaletteContainer createNodes1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Nodes1Group_title);
		paletteContainer.setId("createNodes1Group"); //$NON-NLS-1$
		paletteContainer.add(createAssemblyContext1CreationTool());
		paletteContainer.add(createSystemOperationRequiredRole2CreationTool());
		paletteContainer.add(createSystemOperationProvidedRole3CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Links" palette tool group
	 * @generated
	 */
	private PaletteContainer createLinks2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Links2Group_title);
		paletteContainer.setId("createLinks2Group"); //$NON-NLS-1$
		paletteContainer
				.add(createOperationRequiredDelegationConnector1CreationTool());
		paletteContainer.add(createAssemblyConnector2CreationTool());
		paletteContainer.add(createAssemblyEventConnector3CreationTool());
		paletteContainer
				.add(createOperationProvidedDelegationConnector4CreationTool());
		return paletteContainer;
	}

	/**
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
	 * @generated
	 */
	private ToolEntry createAssemblyEventConnector3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.AssemblyEventConnector_4007);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.AssemblyEventConnector3CreationTool_title,
				Messages.AssemblyEventConnector3CreationTool_desc, types);
		entry.setId("createAssemblyEventConnector3CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.AssemblyEventConnector_4007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOperationProvidedDelegationConnector4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.ProvidedDelegationConnector_4006);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.OperationProvidedDelegationConnector4CreationTool_title,
				Messages.OperationProvidedDelegationConnector4CreationTool_desc,
				types);
		entry.setId("createOperationProvidedDelegationConnector4CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.ProvidedDelegationConnector_4006));
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
