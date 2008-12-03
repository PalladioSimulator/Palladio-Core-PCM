/*
 * Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.part;

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

import de.uka.ipd.sdq.pcm.gmf.usage.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class PalladioComponentModelPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createUserActions1Group());
		paletteRoot.add(createLinks2Group());
		paletteRoot.add(createInternals3Group());
		paletteRoot.add(createWorkloads4Group());
	}

	/**
	 * Creates "User Actions" palette tool group
	 * @generated
	 */
	private PaletteContainer createUserActions1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.UserActions1Group_title);
		paletteContainer.setDescription(Messages.UserActions1Group_desc);
		paletteContainer.add(createStart1CreationTool());
		paletteContainer.add(createStop2CreationTool());
		paletteContainer.add(createEntryLevelSystemCall3CreationTool());
		paletteContainer.add(createLoop4CreationTool());
		paletteContainer.add(createBranch5CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Links" palette tool group
	 * @generated
	 */
	private PaletteContainer createLinks2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Links2Group_title);
		paletteContainer.setDescription(Messages.Links2Group_desc);
		paletteContainer.add(createUsageFlow1CreationTool());
		paletteContainer.add(createVariableUsage2CreationTool());
		paletteContainer.add(createVariableCharacterisation3CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Internals" palette tool group
	 * @generated
	 */
	private PaletteContainer createInternals3Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Internals3Group_title);
		paletteContainer.setDescription(Messages.Internals3Group_desc);
		paletteContainer.add(createScenarioBehaviour1CreationTool());
		paletteContainer.add(createBranchTransition2CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Workloads" palette tool group
	 * @generated
	 */
	private PaletteContainer createWorkloads4Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Workloads4Group_title);
		paletteContainer.setDescription(Messages.Workloads4Group_desc);
		paletteContainer.add(createOpenWorkload1CreationTool());
		paletteContainer.add(createClosedWorkload2CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createStart1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.Start_3001);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Start1CreationTool_title,
				Messages.Start1CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.Start_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createStop2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.Stop_3002);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Stop2CreationTool_title,
				Messages.Stop2CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.Stop_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEntryLevelSystemCall3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.EntryLevelSystemCall_3003);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.EntryLevelSystemCall3CreationTool_title,
				Messages.EntryLevelSystemCall3CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.EntryLevelSystemCall_3003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLoop4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.Loop_3005);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Loop4CreationTool_title,
				Messages.Loop4CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.Loop_3005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createBranch5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.Branch_3008);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Branch5CreationTool_title,
				Messages.Branch5CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.Branch_3008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createUsageFlow1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.UsageFlow1CreationTool_title,
				Messages.UsageFlow1CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelUsageDiagramEditorPlugin
						.findImageDescriptor("/de.uka.ipd.sdq.pcm.edit/icons/full/ctool16/ControlFlow.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createVariableUsage2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.VariableUsage_3012);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.VariableUsage2CreationTool_title,
				Messages.VariableUsage2CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.VariableUsage_3012));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createVariableCharacterisation3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.VariableCharacterisation_3013);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.VariableCharacterisation3CreationTool_title,
				Messages.VariableCharacterisation3CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.VariableCharacterisation_3013));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createScenarioBehaviour1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(3);
		types.add(PalladioComponentModelElementTypes.ScenarioBehaviour_2001);
		types.add(PalladioComponentModelElementTypes.ScenarioBehaviour_3007);
		types.add(PalladioComponentModelElementTypes.ScenarioBehaviour_3010);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ScenarioBehaviour1CreationTool_title,
				Messages.ScenarioBehaviour1CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.ScenarioBehaviour_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createBranchTransition2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.BranchTransition_3009);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.BranchTransition2CreationTool_title,
				Messages.BranchTransition2CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.BranchTransition_3009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOpenWorkload1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.OpenWorkload_2003);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.OpenWorkload1CreationTool_title,
				Messages.OpenWorkload1CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.OpenWorkload_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createClosedWorkload2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.ClosedWorkload_2002);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ClosedWorkload2CreationTool_title,
				Messages.ClosedWorkload2CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.ClosedWorkload_2002));
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
