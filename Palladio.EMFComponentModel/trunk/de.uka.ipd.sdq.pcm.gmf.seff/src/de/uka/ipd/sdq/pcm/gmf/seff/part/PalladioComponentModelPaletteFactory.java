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
		paletteRoot.add(createActionDetails2Group());
		paletteRoot.add(createLinks3Group());
	}

	/**
	 * Creates "Actions" palette tool group
	 * @generated
	 */
	private PaletteContainer createActions1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Actions1Group_title);
		paletteContainer.setId("createActions1Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Actions1Group_desc);
		paletteContainer.add(createStartAction1CreationTool());
		paletteContainer.add(createStopAction2CreationTool());
		paletteContainer.add(createInternalAction3CreationTool());
		paletteContainer.add(createExternalCallAction4CreationTool());
		paletteContainer.add(createEmitEventAction5CreationTool());
		paletteContainer.add(createSetVariableAction6CreationTool());
		paletteContainer.add(createAcquireAction7CreationTool());
		paletteContainer.add(createReleaseAction8CreationTool());
		paletteContainer.add(createLoopAction9CreationTool());
		paletteContainer.add(createCollectionIteratorAction10CreationTool());
		paletteContainer.add(createBranchAction11CreationTool());
		paletteContainer.add(createForkAction12CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Action Details" palette tool group
	 * @generated
	 */
	private PaletteContainer createActionDetails2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.ActionDetails2Group_title);
		paletteContainer.setId("createActionDetails2Group"); //$NON-NLS-1$
		paletteContainer.add(createResourceDemand1CreationTool());
		paletteContainer.add(createVariableUsage2CreationTool());
		paletteContainer.add(createVariableCharacterisation3CreationTool());
		paletteContainer.add(createResourceDemandingBehaviour4CreationTool());
		paletteContainer.add(createSynchronisationPoint5CreationTool());
		paletteContainer
				.add(createProbabilisticBranchTransition6CreationTool());
		paletteContainer.add(createGuardedBranchTransition7CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Links" palette tool group
	 * @generated
	 */
	private PaletteContainer createLinks3Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Links3Group_title);
		paletteContainer.setId("createLinks3Group"); //$NON-NLS-1$
		paletteContainer.add(createControlFlow1CreationTool());
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
		entry.setId("createStartAction1CreationTool"); //$NON-NLS-1$
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
		entry.setId("createStopAction2CreationTool"); //$NON-NLS-1$
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
		entry.setId("createInternalAction3CreationTool"); //$NON-NLS-1$
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
		entry.setId("createExternalCallAction4CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.ExternalCallAction_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEmitEventAction5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(PalladioComponentModelElementTypes.EmitEventAction_2013);
		types.add(PalladioComponentModelElementTypes.EmitEventAction_3046);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.EmitEventAction5CreationTool_title,
				Messages.EmitEventAction5CreationTool_desc, types);
		entry.setId("createEmitEventAction5CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.EmitEventAction_2013));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSetVariableAction6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(PalladioComponentModelElementTypes.SetVariableAction_3024);
		types.add(PalladioComponentModelElementTypes.SetVariableAction_2008);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.SetVariableAction6CreationTool_title,
				Messages.SetVariableAction6CreationTool_desc, types);
		entry.setId("createSetVariableAction6CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.SetVariableAction_3024));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAcquireAction7CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(PalladioComponentModelElementTypes.AcquireAction_3026);
		types.add(PalladioComponentModelElementTypes.AcquireAction_2012);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.AcquireAction7CreationTool_title,
				Messages.AcquireAction7CreationTool_desc, types);
		entry.setId("createAcquireAction7CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.AcquireAction_3026));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createReleaseAction8CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(PalladioComponentModelElementTypes.ReleaseAction_3020);
		types.add(PalladioComponentModelElementTypes.ReleaseAction_2010);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ReleaseAction8CreationTool_title,
				Messages.ReleaseAction8CreationTool_desc, types);
		entry.setId("createReleaseAction8CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.ReleaseAction_3020));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLoopAction9CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(PalladioComponentModelElementTypes.LoopAction_2004);
		types.add(PalladioComponentModelElementTypes.LoopAction_3006);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.LoopAction9CreationTool_title,
				Messages.LoopAction9CreationTool_desc, types);
		entry.setId("createLoopAction9CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.LoopAction_2004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createCollectionIteratorAction10CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types
				.add(PalladioComponentModelElementTypes.CollectionIteratorAction_3013);
		types
				.add(PalladioComponentModelElementTypes.CollectionIteratorAction_2007);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.CollectionIteratorAction10CreationTool_title,
				Messages.CollectionIteratorAction10CreationTool_desc, types);
		entry.setId("createCollectionIteratorAction10CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.CollectionIteratorAction_3013));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createBranchAction11CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(PalladioComponentModelElementTypes.BranchAction_3009);
		types.add(PalladioComponentModelElementTypes.BranchAction_2005);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.BranchAction11CreationTool_title,
				Messages.BranchAction11CreationTool_desc, types);
		entry.setId("createBranchAction11CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.BranchAction_3009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createForkAction12CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(PalladioComponentModelElementTypes.ForkAction_3023);
		types.add(PalladioComponentModelElementTypes.ForkAction_2011);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ForkAction12CreationTool_title,
				Messages.ForkAction12CreationTool_desc, types);
		entry.setId("createForkAction12CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.ForkAction_3023));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createResourceDemand1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.ParametricResourceDemand_3031);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ResourceDemand1CreationTool_title,
				Messages.ResourceDemand1CreationTool_desc, types);
		entry.setId("createResourceDemand1CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(PalladioComponentModelSeffDiagramEditorPlugin
						.findImageDescriptor("/de.uka.ipd.sdq.pcm.edit/icons/full/ctool16/ParametricRessourceDemand.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createVariableUsage2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(4);
		types.add(PalladioComponentModelElementTypes.VariableUsage_3042);
		types.add(PalladioComponentModelElementTypes.VariableUsage_3049);
		types.add(PalladioComponentModelElementTypes.VariableUsage_3047);
		types.add(PalladioComponentModelElementTypes.VariableUsage_3036);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.VariableUsage2CreationTool_title,
				Messages.VariableUsage2CreationTool_desc, types);
		entry.setId("createVariableUsage2CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.VariableUsage_3042));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createVariableCharacterisation3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(4);
		types
				.add(PalladioComponentModelElementTypes.VariableCharacterisation_3033);
		types
				.add(PalladioComponentModelElementTypes.VariableCharacterisation_3035);
		types
				.add(PalladioComponentModelElementTypes.VariableCharacterisation_3037);
		types
				.add(PalladioComponentModelElementTypes.VariableCharacterisation_3048);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.VariableCharacterisation3CreationTool_title,
				Messages.VariableCharacterisation3CreationTool_desc, types);
		entry.setId("createVariableCharacterisation3CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.VariableCharacterisation_3033));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createResourceDemandingBehaviour4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(6);
		types
				.add(PalladioComponentModelElementTypes.ResourceDemandingBehaviour_3003);
		types
				.add(PalladioComponentModelElementTypes.ResourceDemandingBehaviour_3011);
		types.add(PalladioComponentModelElementTypes.ForkedBehaviour_3027);
		types
				.add(PalladioComponentModelElementTypes.ResourceDemandingBehaviour_3014);
		types.add(PalladioComponentModelElementTypes.ForkedBehaviour_3039);
		types
				.add(PalladioComponentModelElementTypes.ResourceDemandingBehaviour_3018);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ResourceDemandingBehaviour4CreationTool_title,
				Messages.ResourceDemandingBehaviour4CreationTool_desc, types);
		entry.setId("createResourceDemandingBehaviour4CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.ResourceDemandingBehaviour_3003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSynchronisationPoint5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.SynchronisationPoint_3038);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.SynchronisationPoint5CreationTool_title,
				Messages.SynchronisationPoint5CreationTool_desc, types);
		entry.setId("createSynchronisationPoint5CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.SynchronisationPoint_3038));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProbabilisticBranchTransition6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.ProbabilisticBranchTransition_3010);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ProbabilisticBranchTransition6CreationTool_title,
				Messages.ProbabilisticBranchTransition6CreationTool_desc, types);
		entry.setId("createProbabilisticBranchTransition6CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.ProbabilisticBranchTransition_3010));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createGuardedBranchTransition7CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.GuardedBranchTransition_3017);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.GuardedBranchTransition7CreationTool_title,
				Messages.GuardedBranchTransition7CreationTool_desc, types);
		entry.setId("createGuardedBranchTransition7CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.GuardedBranchTransition_3017));
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
		entry.setId("createControlFlow1CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(PalladioComponentModelSeffDiagramEditorPlugin
						.findImageDescriptor("/de.uka.ipd.sdq.pcm.edit/icons/full/ctool16/ControlFlow.gif")); //$NON-NLS-1$
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