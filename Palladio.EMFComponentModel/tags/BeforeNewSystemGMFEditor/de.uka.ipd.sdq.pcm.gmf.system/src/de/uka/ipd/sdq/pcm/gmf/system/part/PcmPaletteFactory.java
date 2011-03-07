/*
 *by SDQ, IPD, U Karlrsuhe (TH), 2006
 */
package de.uka.ipd.sdq.pcm.gmf.system.part;

import java.util.List;
import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.jface.resource.ImageDescriptor;
import de.uka.ipd.sdq.pcm.gmf.system.providers.PcmElementTypes;

import java.util.ArrayList;

import org.eclipse.gef.palette.PaletteGroup;

import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;

/**
 * @generated
 */
public class PcmPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createpcm1Group());
	}

	/**
	 * @generated
	 */
	private PaletteContainer createpcm1Group() {
		PaletteContainer paletteContainer = new PaletteGroup("pcm");
		paletteContainer.add(createProvidedDelegationConnector1CreationTool());
		paletteContainer.add(createAssemblyContext2CreationTool());
		paletteContainer.add(createAssemblyConnector3CreationTool());
		paletteContainer.add(createRequiredDelegationConnector4CreationTool());
		paletteContainer.add(createSystemRequiredRole5CreationTool());
		paletteContainer.add(createSpecifiedTimeConsumption6CreationTool());
		paletteContainer.add(createSystemProvidedRole7CreationTool());
		paletteContainer.add(createComponent8CreationTool());
		paletteContainer.add(createRole9CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProvidedDelegationConnector1CreationTool() {
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
	private ToolEntry createAssemblyContext2CreationTool() {
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
	private ToolEntry createAssemblyConnector3CreationTool() {
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
	private ToolEntry createRequiredDelegationConnector4CreationTool() {
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
	private ToolEntry createSystemRequiredRole5CreationTool() {
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
	private ToolEntry createSpecifiedTimeConsumption6CreationTool() {
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
	private ToolEntry createSystemProvidedRole7CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = PcmElementTypes
				.getImageDescriptor(PcmElementTypes.SystemProvidedRole_1002);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(PcmElementTypes.SystemProvidedRole_1002);
		ToolEntry result = new NodeToolEntry("SystemProvidedRole",
				"Create new SystemProvidedRole", smallImage, largeImage,
				elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createComponent8CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = null;

		largeImage = smallImage;

		ToolEntry result = new ToolEntry("Component", "null", smallImage,
				largeImage) {
		};

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRole9CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = PcmElementTypes
				.getImageDescriptor(PcmElementTypes.Node_2001);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(PcmElementTypes.Node_2001);
		ToolEntry result = new NodeToolEntry("Role", "null", smallImage,
				largeImage, elementTypes);

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
