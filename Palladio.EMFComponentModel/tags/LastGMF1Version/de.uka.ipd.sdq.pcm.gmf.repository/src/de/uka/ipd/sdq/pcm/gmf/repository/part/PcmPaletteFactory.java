/*
 *Copyright 2006 Institute for Software-Design and Quality, University of Karlsruhe (TH)
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
import org.eclipse.jface.resource.ImageDescriptor;

import de.uka.ipd.sdq.pcm.gmf.repository.providers.PcmElementTypes;

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
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSignature1CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = PcmElementTypes
				.getImageDescriptor(PcmElementTypes.Signature_2001);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(PcmElementTypes.Signature_2001);
		ToolEntry result = new NodeToolEntry("Signature",
				"Create new Signature", smallImage, largeImage, elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRequiredRole2CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = PcmElementTypes
				.getImageDescriptor(PcmElementTypes.RequiredRole_3002);

		largeImage = smallImage;

		final List relationshipTypes = new ArrayList();
		relationshipTypes.add(PcmElementTypes.RequiredRole_3002);
		ToolEntry result = new LinkToolEntry("RequiredRole",
				"Create new RequiredRole", smallImage, largeImage,
				relationshipTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInterface3CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = PcmElementTypes
				.getImageDescriptor(PcmElementTypes.Interface_1001);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(PcmElementTypes.Interface_1001);
		ToolEntry result = new NodeToolEntry("Interface",
				"Create new Interface", smallImage, largeImage, elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRequiredDelegationConnector4CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = null;

		largeImage = smallImage;

		ToolEntry result = new ToolEntry("RequiredDelegationConnector",
				"Create new RequiredDelegationConnector", smallImage,
				largeImage) {
		};

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createChildComponentContext5CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = null;

		largeImage = smallImage;

		ToolEntry result = new ToolEntry("ChildComponentContext",
				"Create new ChildComponentContext", smallImage, largeImage) {
		};

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProvidedRole6CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = PcmElementTypes
				.getImageDescriptor(PcmElementTypes.ProvidedRole_3001);

		largeImage = smallImage;

		final List relationshipTypes = new ArrayList();
		relationshipTypes.add(PcmElementTypes.ProvidedRole_3001);
		ToolEntry result = new LinkToolEntry("ProvidedRole",
				"Create new ProvidedRole", smallImage, largeImage,
				relationshipTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProvidedDelegationConnector7CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = null;

		largeImage = smallImage;

		ToolEntry result = new ToolEntry("ProvidedDelegationConnector",
				"Create new ProvidedDelegationConnector", smallImage,
				largeImage) {
		};

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCompleteComponentType8CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = PcmElementTypes
				.getImageDescriptor(PcmElementTypes.CompleteComponentType_1003);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(PcmElementTypes.CompleteComponentType_1003);
		ToolEntry result = new NodeToolEntry("CompleteComponentType",
				"Create new CompleteComponentType", smallImage, largeImage,
				elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCompositeComponent9CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = PcmElementTypes
				.getImageDescriptor(PcmElementTypes.CompositeComponent_1005);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(PcmElementTypes.CompositeComponent_1005);
		ToolEntry result = new NodeToolEntry("CompositeComponent",
				"Create new CompositeComponent", smallImage, largeImage,
				elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCompositeAssemblyConnector10CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = null;

		largeImage = smallImage;

		ToolEntry result = new ToolEntry("CompositeAssemblyConnector",
				"Create new CompositeAssemblyConnector", smallImage, largeImage) {
		};

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createBasicComponent11CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = PcmElementTypes
				.getImageDescriptor(PcmElementTypes.BasicComponent_1002);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(PcmElementTypes.BasicComponent_1002);
		ToolEntry result = new NodeToolEntry("BasicComponent",
				"Create new BasicComponent", smallImage, largeImage,
				elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProvidesComponentType12CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = PcmElementTypes
				.getImageDescriptor(PcmElementTypes.ProvidesComponentType_1004);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(PcmElementTypes.ProvidesComponentType_1004);
		ToolEntry result = new NodeToolEntry("ProvidesComponentType",
				"Create new ProvidesComponentType", smallImage, largeImage,
				elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSEFF13CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = PcmElementTypes
				.getImageDescriptor(PcmElementTypes.ResourceDemandingSEFF_2002);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(PcmElementTypes.ResourceDemandingSEFF_2002);
		ToolEntry result = new NodeToolEntry("SEFF", "SEFF", smallImage,
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
