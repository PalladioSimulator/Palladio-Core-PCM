/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
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

import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class PalladioComponentModelPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createActions1Group());
		paletteRoot.add(createLinks2Group());
		paletteRoot.add(createComposite3Group());
	}

	/**
	 * Creates "Actions" palette tool group
	 * @generated
	 */
	private PaletteContainer createActions1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Actions1Group_title);
		paletteContainer.setDescription(Messages.Actions1Group_desc);
		paletteContainer.add(createStopAction1CreationTool());
		paletteContainer.add(createStartAction2CreationTool());
		paletteContainer.add(createLoopAction3CreationTool());
		paletteContainer.add(createInternalAction4CreationTool());
		paletteContainer.add(createExternalCallAction5CreationTool());
		paletteContainer.add(createBranchAction6CreationTool());
		paletteContainer.add(createCollectionIteratorAction7CreationTool());
		paletteContainer.add(createSetVariableAction8CreationTool());
		paletteContainer.add(createAquireAction9CreationTool());
		paletteContainer.add(createReleaseAction10CreationTool());
		paletteContainer.add(createForkAction11CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Links" palette tool group
	 * @generated
	 */
	private PaletteContainer createLinks2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Links2Group_title);
		paletteContainer.add(createControlFlow1CreationTool());
		paletteContainer.add(createResourceDemand2CreationTool());
		paletteContainer.add(createVariableUsage3CreationTool());
		paletteContainer.add(createVariableCharacterisation4CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Composite" palette tool group
	 * @generated
	 */
	private PaletteContainer createComposite3Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Composite3Group_title);
		paletteContainer.add(createResourceDemandingBehaviour1CreationTool());
		paletteContainer
				.add(createProbabilisticBranchTransition2CreationTool());
		paletteContainer.add(createGuardedBranchTransition3CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createStopAction1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(PalladioComponentModelElementTypes.StopAction_2002);
		types.add(PalladioComponentModelElementTypes.StopAction_3005);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.StopAction1CreationTool_title,
				Messages.StopAction1CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.StopAction_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createStartAction2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(PalladioComponentModelElementTypes.StartAction_2001);
		types.add(PalladioComponentModelElementTypes.StartAction_3004);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.StartAction2CreationTool_title,
				Messages.StartAction2CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.StartAction_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLoopAction3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(PalladioComponentModelElementTypes.LoopAction_2004);
		types.add(PalladioComponentModelElementTypes.LoopAction_3006);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.LoopAction3CreationTool_title,
				Messages.LoopAction3CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.LoopAction_2004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInternalAction4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(PalladioComponentModelElementTypes.InternalAction_3007);
		types.add(PalladioComponentModelElementTypes.InternalAction_2006);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.InternalAction4CreationTool_title,
				Messages.InternalAction4CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.InternalAction_3007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createExternalCallAction5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(PalladioComponentModelElementTypes.ExternalCallAction_2003);
		types.add(PalladioComponentModelElementTypes.ExternalCallAction_3012);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ExternalCallAction5CreationTool_title,
				Messages.ExternalCallAction5CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.ExternalCallAction_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createBranchAction6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(PalladioComponentModelElementTypes.BranchAction_3009);
		types.add(PalladioComponentModelElementTypes.BranchAction_2005);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.BranchAction6CreationTool_title,
				Messages.BranchAction6CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.BranchAction_3009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCollectionIteratorAction7CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types
				.add(PalladioComponentModelElementTypes.CollectionIteratorAction_3013);
		types
				.add(PalladioComponentModelElementTypes.CollectionIteratorAction_2007);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.CollectionIteratorAction7CreationTool_title,
				Messages.CollectionIteratorAction7CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.CollectionIteratorAction_3013));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSetVariableAction8CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(PalladioComponentModelElementTypes.SetVariableAction_3024);
		types.add(PalladioComponentModelElementTypes.SetVariableAction_2008);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.SetVariableAction8CreationTool_title,
				Messages.SetVariableAction8CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.SetVariableAction_3024));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAquireAction9CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(PalladioComponentModelElementTypes.AquireAction_3019);
		types.add(PalladioComponentModelElementTypes.AquireAction_2009);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.AquireAction9CreationTool_title,
				Messages.AquireAction9CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.AquireAction_3019));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createReleaseAction10CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(PalladioComponentModelElementTypes.ReleaseAction_3020);
		types.add(PalladioComponentModelElementTypes.ReleaseAction_2010);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ReleaseAction10CreationTool_title,
				Messages.ReleaseAction10CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.ReleaseAction_3020));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createForkAction11CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(PalladioComponentModelElementTypes.ForkAction_3023);
		types.add(PalladioComponentModelElementTypes.ForkAction_2011);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ForkAction11CreationTool_title,
				Messages.ForkAction11CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.ForkAction_3023));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createControlFlow1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.ControlFlow1CreationTool_title,
				Messages.ControlFlow1CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelSeffDiagramEditorPlugin
						.findImageDescriptor("/de.uka.ipd.sdq.pcm.edit/icons/full/ctool16/ControlFlow.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createResourceDemand2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.ParametricResourceDemand_3008);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ResourceDemand2CreationTool_title,
				Messages.ResourceDemand2CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelSeffDiagramEditorPlugin
						.findImageDescriptor("/de.uka.ipd.sdq.pcm.edit/icons/full/ctool16/ParametricRessourceDemand.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createVariableUsage3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(3);
		types.add(PalladioComponentModelElementTypes.VariableUsage_3001);
		types.add(PalladioComponentModelElementTypes.VariableUsage_3022);
		types.add(PalladioComponentModelElementTypes.VariableUsage_3015);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.VariableUsage3CreationTool_title,
				Messages.VariableUsage3CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.VariableUsage_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createVariableCharacterisation4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(3);
		types
				.add(PalladioComponentModelElementTypes.VariableCharacterisation_3002);
		types
				.add(PalladioComponentModelElementTypes.VariableCharacterisation_3016);
		types
				.add(PalladioComponentModelElementTypes.VariableCharacterisation_3025);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.VariableCharacterisation4CreationTool_title,
				Messages.VariableCharacterisation4CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.VariableCharacterisation_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createResourceDemandingBehaviour1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(5);
		types
				.add(PalladioComponentModelElementTypes.ResourceDemandingBehaviour_3003);
		types
				.add(PalladioComponentModelElementTypes.ResourceDemandingBehaviour_3011);
		types
				.add(PalladioComponentModelElementTypes.ResourceDemandingBehaviour_3021);
		types
				.add(PalladioComponentModelElementTypes.ResourceDemandingBehaviour_3014);
		types
				.add(PalladioComponentModelElementTypes.ResourceDemandingBehaviour_3018);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ResourceDemandingBehaviour1CreationTool_title,
				Messages.ResourceDemandingBehaviour1CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.ResourceDemandingBehaviour_3003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProbabilisticBranchTransition2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.ProbabilisticBranchTransition_3010);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ProbabilisticBranchTransition2CreationTool_title,
				Messages.ProbabilisticBranchTransition2CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.ProbabilisticBranchTransition_3010));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createGuardedBranchTransition3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.GuardedBranchTransition_3017);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.GuardedBranchTransition3CreationTool_title,
				Messages.GuardedBranchTransition3CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.GuardedBranchTransition_3017));
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
