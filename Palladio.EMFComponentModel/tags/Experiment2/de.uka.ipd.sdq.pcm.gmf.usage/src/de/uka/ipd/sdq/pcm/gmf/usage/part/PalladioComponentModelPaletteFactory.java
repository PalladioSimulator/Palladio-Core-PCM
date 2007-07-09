/*
 * Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
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
		paletteRoot.add(createUsage1Group());
	}

	/**
	 * Creates "usage" palette tool group
	 * @generated
	 */
	private PaletteContainer createUsage1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				Messages.Usage1Group_title);
		paletteContainer.add(createVariableCharacterisation1CreationTool());
		paletteContainer.add(createVariableUsage2CreationTool());
		paletteContainer.add(createScenarioBehaviour3CreationTool());
		paletteContainer.add(createStop4CreationTool());
		paletteContainer.add(createStart5CreationTool());
		paletteContainer.add(createOpenWorkload6CreationTool());
		paletteContainer.add(createLoop7CreationTool());
		paletteContainer.add(createEntryLevelSystemCall8CreationTool());
		paletteContainer.add(createClosedWorkload9CreationTool());
		paletteContainer.add(createBranch10CreationTool());
		paletteContainer.add(createBranchTransition11CreationTool());
		paletteContainer.add(createUsageFlow12CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createVariableCharacterisation1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.VariableCharacterisation_3006);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.VariableCharacterisation1CreationTool_title,
				Messages.VariableCharacterisation1CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.VariableCharacterisation_3006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createVariableUsage2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.VariableUsage_3004);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.VariableUsage2CreationTool_title,
				Messages.VariableUsage2CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.VariableUsage_3004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createScenarioBehaviour3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(3);
		types.add(PalladioComponentModelElementTypes.ScenarioBehaviour_2001);
		types.add(PalladioComponentModelElementTypes.ScenarioBehaviour_3007);
		types.add(PalladioComponentModelElementTypes.ScenarioBehaviour_3010);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ScenarioBehaviour3CreationTool_title,
				Messages.ScenarioBehaviour3CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.ScenarioBehaviour_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createStop4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.Stop_3002);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Stop4CreationTool_title,
				Messages.Stop4CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.Stop_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createStart5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.Start_3001);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Start5CreationTool_title,
				Messages.Start5CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.Start_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createOpenWorkload6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.OpenWorkload_2003);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.OpenWorkload6CreationTool_title,
				Messages.OpenWorkload6CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.OpenWorkload_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLoop7CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.Loop_3005);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Loop7CreationTool_title,
				Messages.Loop7CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.Loop_3005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEntryLevelSystemCall8CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.EntryLevelSystemCall_3003);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.EntryLevelSystemCall8CreationTool_title,
				Messages.EntryLevelSystemCall8CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.EntryLevelSystemCall_3003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createClosedWorkload9CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.ClosedWorkload_2002);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ClosedWorkload9CreationTool_title,
				Messages.ClosedWorkload9CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.ClosedWorkload_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createBranch10CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.Branch_3008);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Branch10CreationTool_title,
				Messages.Branch10CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.Branch_3008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createBranchTransition11CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(PalladioComponentModelElementTypes.BranchTransition_3009);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.BranchTransition11CreationTool_title,
				Messages.BranchTransition11CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelElementTypes
						.getImageDescriptor(PalladioComponentModelElementTypes.BranchTransition_3009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createUsageFlow12CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(PalladioComponentModelElementTypes.AbstractUserActionSuccessor_4002);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.UsageFlow12CreationTool_title,
				Messages.UsageFlow12CreationTool_desc, types);
		entry
				.setSmallIcon(PalladioComponentModelUsageDiagramEditorPlugin
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
