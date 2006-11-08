/*
 *by SDQ, IPD, U Karlrsuhe (TH), 2006
 */
package de.uka.ipd.sdq.pcm.gmf.system.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.jface.resource.ImageDescriptor;

import de.uka.ipd.sdq.pcm.gmf.system.providers.PcmElementTypes;

/**
 * @generated
 */
public class PcmPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createNodes1Group());
		paletteRoot.add(createLinks2Group());
	}

	/**
	 * @generated
	 */
	private PaletteContainer createNodes1Group() {
		PaletteContainer paletteContainer = new PaletteGroup("Nodes");
		paletteContainer.add(createAssemblyContext1CreationTool());
		paletteContainer.add(createSystemRequiredRole2CreationTool());
		paletteContainer.add(createSpecifiedTimeConsumption3CreationTool());
		paletteContainer.add(createSystemProvidedRole4CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private PaletteContainer createLinks2Group() {
		PaletteContainer paletteContainer = new PaletteGroup("Links");
		paletteContainer.add(createRequiredDelegationConnector1CreationTool());
		paletteContainer.add(createAssemblyConnector2CreationTool());
		paletteContainer.add(createProvidedDelegationConnector3CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAssemblyContext1CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = PcmElementTypes
				.getImageDescriptor(PcmElementTypes.AssemblyContext_1001);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(PcmElementTypes.AssemblyContext_1001);
		ToolEntry result = new NodeToolEntry("AssemblyContext",
				"Create new AssemblyContext", smallImage, largeImage,
				elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSystemRequiredRole2CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = PcmElementTypes
				.getImageDescriptor(PcmElementTypes.SystemRequiredRole_1003);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(PcmElementTypes.SystemRequiredRole_1003);
		ToolEntry result = new NodeToolEntry("SystemRequiredRole",
				"Create new SystemRequiredRole", smallImage, largeImage,
				elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSpecifiedTimeConsumption3CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = null;

		largeImage = smallImage;

		ToolEntry result = new ToolEntry("SpecifiedTimeConsumption",
				"Create new SpecifiedTimeConsumption", smallImage, largeImage) {
		};

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSystemProvidedRole4CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = PcmElementTypes
				.getImageDescriptor(PcmElementTypes.SystemProvidedRole_1004);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(PcmElementTypes.SystemProvidedRole_1004);
		ToolEntry result = new NodeToolEntry("SystemProvidedRole",
				"Create new SystemProvidedRole", smallImage, largeImage,
				elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRequiredDelegationConnector1CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = PcmElementTypes
				.getImageDescriptor(PcmElementTypes.RequiredDelegationConnector_3003);

		largeImage = smallImage;

		final List relationshipTypes = new ArrayList();
		relationshipTypes.add(PcmElementTypes.RequiredDelegationConnector_3003);
		ToolEntry result = new LinkToolEntry("RequiredDelegationConnector",
				"Create new RequiredDelegationConnector", smallImage,
				largeImage, relationshipTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAssemblyConnector2CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = PcmElementTypes
				.getImageDescriptor(PcmElementTypes.AssemblyConnector_3001);

		largeImage = smallImage;

		final List relationshipTypes = new ArrayList();
		relationshipTypes.add(PcmElementTypes.AssemblyConnector_3001);
		ToolEntry result = new LinkToolEntry("AssemblyConnector",
				"Create new AssemblyConnector", smallImage, largeImage,
				relationshipTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProvidedDelegationConnector3CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = PcmElementTypes
				.getImageDescriptor(PcmElementTypes.ProvidedDelegationConnector_3002);

		largeImage = smallImage;

		final List relationshipTypes = new ArrayList();
		relationshipTypes.add(PcmElementTypes.ProvidedDelegationConnector_3002);
		ToolEntry result = new LinkToolEntry("ProvidedDelegationConnector",
				"Create new ProvidedDelegationConnector", smallImage,
				largeImage, relationshipTypes);

		return result;
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
				ImageDescriptor smallIcon, ImageDescriptor largeIcon,
				List elementTypes) {
			super(title, description, smallIcon, largeIcon);
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
				ImageDescriptor smallIcon, ImageDescriptor largeIcon,
				List relationshipTypes) {
			super(title, description, smallIcon, largeIcon);
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
