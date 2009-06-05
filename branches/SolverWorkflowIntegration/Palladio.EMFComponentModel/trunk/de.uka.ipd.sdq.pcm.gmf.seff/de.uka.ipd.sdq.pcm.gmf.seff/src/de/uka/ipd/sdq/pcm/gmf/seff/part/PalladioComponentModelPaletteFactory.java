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
		paletteContainer.add(createStartAction1CreationTool());
		paletteContainer.add(createStopAction2CreationTool());
		paletteContainer.add(createInternalAction3CreationTool());
		paletteContainer.add(createExternalCallAction4CreationTool());
		paletteContainer.add(createSetVariableAction5CreationTool());
		paletteContainer.add(createAcquireAction6CreationTool());
		paletteContainer.add(createReleaseAction7CreationTool());
		paletteContainer.add(createLoopAction8CreationTool());
		paletteContainer.add(createCollectionIteratorAction9CreationTool());
		paletteContainer.add(createBranchAction10CreationTool());
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
	private ToolEntry createStartAction1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(PalladioComponentModelElementTypes.StartAction_2001);
		types.add(PalladioComponentModelElementTypes.StartAction_3004);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.StartAction1CreationTool_title,
				Messages.StartAction1CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.StartAction_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createStopAction2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(PalladioComponentModelElementTypes.StopAction_2002);
		types.add(PalladioComponentModelElementTypes.StopAction_3005);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.StopAction2CreationTool_title,
				Messages.StopAction2CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.StopAction_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInternalAction3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(PalladioComponentModelElementTypes.InternalAction_3007);
		types.add(PalladioComponentModelElementTypes.InternalAction_2006);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.InternalAction3CreationTool_title,
				Messages.InternalAction3CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.InternalAction_3007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createExternalCallAction4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(PalladioComponentModelElementTypes.ExternalCallAction_2003);
		types.add(PalladioComponentModelElementTypes.ExternalCallAction_3012);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ExternalCallAction4CreationTool_title,
				Messages.ExternalCallAction4CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.ExternalCallAction_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSetVariableAction5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(PalladioComponentModelElementTypes.SetVariableAction_3024);
		types.add(PalladioComponentModelElementTypes.SetVariableAction_2008);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.SetVariableAction5CreationTool_title,
				Messages.SetVariableAction5CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.SetVariableAction_3024));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAcquireAction6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(PalladioComponentModelElementTypes.AcquireAction_3026);
		types.add(PalladioComponentModelElementTypes.AcquireAction_2012);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.AcquireAction6CreationTool_title,
				Messages.AcquireAction6CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.AcquireAction_3026));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createReleaseAction7CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(PalladioComponentModelElementTypes.ReleaseAction_3020);
		types.add(PalladioComponentModelElementTypes.ReleaseAction_2010);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ReleaseAction7CreationTool_title,
				Messages.ReleaseAction7CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.ReleaseAction_3020));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLoopAction8CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(PalladioComponentModelElementTypes.LoopAction_2004);
		types.add(PalladioComponentModelElementTypes.LoopAction_3006);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.LoopAction8CreationTool_title,
				Messages.LoopAction8CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.LoopAction_2004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCollectionIteratorAction9CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types
				.add(PalladioComponentModelElementTypes.CollectionIteratorAction_3013);
		types
				.add(PalladioComponentModelElementTypes.CollectionIteratorAction_2007);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.CollectionIteratorAction9CreationTool_title,
				Messages.CollectionIteratorAction9CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.CollectionIteratorAction_3013));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createBranchAction10CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(PalladioComponentModelElementTypes.BranchAction_3009);
		types.add(PalladioComponentModelElementTypes.BranchAction_2005);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.BranchAction10CreationTool_title,
				Messages.BranchAction10CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.BranchAction_3009));
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
				.add(PalladioComponentModelElementTypes.ParametricResourceDemand_3031);
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
		types.add(PalladioComponentModelElementTypes.VariableUsage_3028);
		types.add(PalladioComponentModelElementTypes.VariableUsage_3029);
		types.add(PalladioComponentModelElementTypes.VariableUsage_3030);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.VariableUsage3CreationTool_title,
				Messages.VariableUsage3CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.VariableUsage_3028));
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
		types.add(PalladioComponentModelElementTypes.ForkedBehaviour_3027);
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
