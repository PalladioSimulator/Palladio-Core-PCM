/*
 * Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts;

/**
 * @generated
 */
public class PalladioComponentModelEditPartFactory implements org.eclipse.gef.EditPartFactory {

		/**
 * @generated
 */
	public org.eclipse.gef.EditPart createEditPart(org.eclipse.gef.EditPart context, Object model) {
		if (model instanceof org.eclipse.gmf.runtime.notation.View) {
			org.eclipse.gmf.runtime.notation.View view = (org.eclipse.gmf.runtime.notation.View) model;
			switch (de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry.getVisualID(view)) {
				
	case de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationEditPart.VISUAL_ID:
		return new de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationEditPart(view);
									
	case de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerEditPart.VISUAL_ID:
		return new de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerEditPart(view);
					
	case de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerEntityNameEditPart.VISUAL_ID:
		return new de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerEntityNameEditPart(view);
									
	case de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEditPart.VISUAL_ID:
		return new de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEditPart(view);
					
	case de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEntityNameEditPart.VISUAL_ID:
		return new de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationContextEntityNameEditPart(view);

	case de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationComponentLabelEditPart.VISUAL_ID:
		return new de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.AllocationComponentLabelEditPart(view);
								
	case de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerAllocationCompartmentEditPart.VISUAL_ID:
		return new de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerAllocationCompartmentEditPart(view);
							}
		}
		return createUnrecognizedEditPart(context, model);
	}
	
		/**
 * @generated
 */
	 private org.eclipse.gef.EditPart createUnrecognizedEditPart(org.eclipse.gef.EditPart context, Object model) {
	 	// Handle creation of unrecognized child node EditParts here
	 	return null;
	 }
	
		/**
 * @generated
 */
	public static org.eclipse.gef.tools.CellEditorLocator getTextCellEditorLocator(
			org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart source) {
		return org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess.INSTANCE.getTextCellEditorLocator(source);
	}
	
	}
