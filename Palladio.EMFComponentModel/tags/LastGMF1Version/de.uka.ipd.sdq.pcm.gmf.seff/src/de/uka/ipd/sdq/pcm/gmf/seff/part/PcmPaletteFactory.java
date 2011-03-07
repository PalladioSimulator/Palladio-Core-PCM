/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.jface.resource.ImageDescriptor;

import de.uka.ipd.sdq.pcm.gmf.seff.providers.PcmElementTypes;

/**
 * @generated
 */
public class PcmPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createActions1Group());
		paletteRoot.add(createLinks2Group());
		paletteRoot.add(createComposite3Group());
	}

	/**
	 * @generated
	 */
	private PaletteContainer createActions1Group() {
		PaletteContainer paletteContainer = new PaletteDrawer("Actions");
		paletteContainer.setDescription("");
		paletteContainer.add(createStopAction1CreationTool());
		paletteContainer.add(createStartAction2CreationTool());
		paletteContainer.add(createLoopAction3CreationTool());
		paletteContainer.add(createInternalAction4CreationTool());
		paletteContainer.add(createExternalCallAction5CreationTool());
		paletteContainer.add(createBranchAction6CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private PaletteContainer createLinks2Group() {
		PaletteContainer paletteContainer = new PaletteDrawer("Links");
		paletteContainer.add(createControlFlow1CreationTool());
		paletteContainer.add(createResourceDemand2CreationTool());
		paletteContainer.add(createParametricParameterUsage3CreationTool());
		paletteContainer.add(createVariableCharacterisation4CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private PaletteContainer createComposite3Group() {
		PaletteContainer paletteContainer = new PaletteDrawer("Composite");
		paletteContainer.add(createResourceDemandingBehaviour1CreationTool());
		paletteContainer.add(createBranchTransition2CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createStopAction1CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = PcmElementTypes
				.getImageDescriptor(PcmElementTypes.StopAction_1002);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(PcmElementTypes.StopAction_1002);
		elementTypes.add(PcmElementTypes.StopAction_2005);
		ToolEntry result = new NodeToolEntry("StopAction",
				"Create new StopAction", smallImage, largeImage, elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createStartAction2CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = PcmElementTypes
				.getImageDescriptor(PcmElementTypes.StartAction_1001);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(PcmElementTypes.StartAction_1001);
		elementTypes.add(PcmElementTypes.StartAction_2004);
		ToolEntry result = new NodeToolEntry("StartAction",
				"Create new StartAction", smallImage, largeImage, elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLoopAction3CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = PcmElementTypes
				.getImageDescriptor(PcmElementTypes.LoopAction_1004);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(PcmElementTypes.LoopAction_1004);
		elementTypes.add(PcmElementTypes.LoopAction_2006);
		ToolEntry result = new NodeToolEntry("LoopAction",
				"Create new LoopAction", smallImage, largeImage, elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInternalAction4CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = PcmElementTypes
				.getImageDescriptor(PcmElementTypes.InternalAction_2007);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(PcmElementTypes.InternalAction_2007);
		elementTypes.add(PcmElementTypes.InternalAction_1006);
		ToolEntry result = new NodeToolEntry("InternalAction",
				"Create new InternalAction", smallImage, largeImage,
				elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createExternalCallAction5CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = PcmElementTypes
				.getImageDescriptor(PcmElementTypes.ExternalCallAction_1003);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(PcmElementTypes.ExternalCallAction_1003);
		elementTypes.add(PcmElementTypes.ExternalCallAction_2012);
		ToolEntry result = new NodeToolEntry("ExternalCallAction",
				"Create new ExternalCallAction", smallImage, largeImage,
				elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createBranchAction6CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = PcmElementTypes
				.getImageDescriptor(PcmElementTypes.BranchAction_2009);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(PcmElementTypes.BranchAction_2009);
		elementTypes.add(PcmElementTypes.BranchAction_1005);
		ToolEntry result = new NodeToolEntry("BranchAction",
				"Create new BranchAction", smallImage, largeImage, elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createControlFlow1CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = PcmDiagramEditorPlugin
				.findImageDescriptor("/de.uka.ipd.sdq.pcm.edit/icons/full/ctool16/ControlFlow.gif");

		largeImage = smallImage;

		final List relationshipTypes = new ArrayList();
		relationshipTypes
				.add(PcmElementTypes.AbstractActionSuccessor_AbstractAction_3001);
		ToolEntry result = new LinkToolEntry("Control Flow",
				"Create new Control Flow Link", smallImage, largeImage,
				relationshipTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createResourceDemand2CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = PcmDiagramEditorPlugin
				.findImageDescriptor("/de.uka.ipd.sdq.pcm.edit/icons/full/ctool16/ParametricRessourceDemand.gif");

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(PcmElementTypes.ParametricResourceDemand_2008);
		ToolEntry result = new NodeToolEntry("Resource Demand",
				"Create new Resource Demand", smallImage, largeImage,
				elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createParametricParameterUsage3CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = PcmElementTypes
				.getImageDescriptor(PcmElementTypes.VariableUsage_2001);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(PcmElementTypes.VariableUsage_2001);
		ToolEntry result = new NodeToolEntry("ParametricParameterUsage",
				"Link a Parametric Parameter Usage", smallImage, largeImage,
				elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createVariableCharacterisation4CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = PcmElementTypes
				.getImageDescriptor(PcmElementTypes.VariableCharacterisation_2002);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(PcmElementTypes.VariableCharacterisation_2002);
		ToolEntry result = new NodeToolEntry("VariableCharacterisation",
				"VariableCharacterisation", smallImage, largeImage,
				elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createResourceDemandingBehaviour1CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = PcmElementTypes
				.getImageDescriptor(PcmElementTypes.ResourceDemandingBehaviour_2003);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(PcmElementTypes.ResourceDemandingBehaviour_2003);
		elementTypes.add(PcmElementTypes.ResourceDemandingBehaviour_2011);
		ToolEntry result = new NodeToolEntry("ResourceDemandingBehaviour",
				"Create new ResourceDemandingBehaviour", smallImage,
				largeImage, elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createBranchTransition2CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = PcmElementTypes
				.getImageDescriptor(PcmElementTypes.ProbabilisticBranchTransition_2010);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(PcmElementTypes.ProbabilisticBranchTransition_2010);
		ToolEntry result = new NodeToolEntry("BranchTransition",
				"Create new BranchTransition", smallImage, largeImage,
				elementTypes);

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
