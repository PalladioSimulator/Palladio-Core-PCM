
/*
 * Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.part;

/**
 * @generated
 */
public class PalladioComponentModelPaletteFactory {

	/**
 * @generated
 */
	public void fillPalette(org.eclipse.gef.palette.PaletteRoot paletteRoot) {
		paletteRoot.add(createPcm1Group());
	}

	/**
 * Creates "pcm" palette tool group
 * @generated
 */
	private org.eclipse.gef.palette.PaletteContainer createPcm1Group() {
				org.eclipse.gef.palette.PaletteGroup paletteContainer = new org.eclipse.gef.palette.PaletteGroup(de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.Pcm1Group_title);
				 paletteContainer.setId("createPcm1Group"); //$NON-NLS-1$
								paletteContainer.add(createAllocationContext1CreationTool());
		return paletteContainer;
	}

	/**
 * @generated
 */
	private org.eclipse.gef.palette.ToolEntry createAllocationContext1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.AllocationContext1CreationTool_title, de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages.AllocationContext1CreationTool_desc, java.util.Collections.singletonList(de.uka.ipd.sdq.pcm.gmf.allocation.providers.PalladioComponentModelElementTypes.AllocationContext_3002));
				 entry.setId("createAllocationContext1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(de.uka.ipd.sdq.pcm.gmf.allocation.providers.PalladioComponentModelElementTypes.getImageDescriptor(de.uka.ipd.sdq.pcm.gmf.allocation.providers.PalladioComponentModelElementTypes.AllocationContext_3002));
		entry.setLargeIcon(entry.getSmallIcon());
						return entry;
	}



	/**
 * @generated
 */
	private static class NodeToolEntry extends org.eclipse.gef.palette.ToolEntry {

		/**
 * @generated
 */
		private final java.util.List<org.eclipse.gmf.runtime.emf.type.core.IElementType> elementTypes;

		/**
 * @generated
 */
		private NodeToolEntry(String title, String description, java.util.List<org.eclipse.gmf.runtime.emf.type.core.IElementType> elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
 * @generated
 */
		public org.eclipse.gef.Tool createTool() {
			org.eclipse.gef.Tool tool = new org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}
