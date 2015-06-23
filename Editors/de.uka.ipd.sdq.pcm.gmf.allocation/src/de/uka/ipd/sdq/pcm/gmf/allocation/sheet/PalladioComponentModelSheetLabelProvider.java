
	/*
 * Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.sheet;

/**
 * @generated
 */
public class PalladioComponentModelSheetLabelProvider extends org.eclipse.jface.viewers.BaseLabelProvider implements org.eclipse.jface.viewers.ILabelProvider {


	/**
 * @generated
 */
	public String getText(Object element) {
		element = unwrap(element);
		org.eclipse.gmf.runtime.emf.type.core.IElementType etype = getElementType(getView(element));
		return etype == null ? "" : etype.getDisplayName();
	}


	/**
 * @generated
 */
	public org.eclipse.swt.graphics.Image getImage(Object element) {
		org.eclipse.gmf.runtime.emf.type.core.IElementType etype = getElementType(getView(unwrap(element)));
		return etype == null ? null : de.uka.ipd.sdq.pcm.gmf.allocation.providers.PalladioComponentModelElementTypes.getImage(etype);
	}


	/**
 * @generated
 */
	private Object unwrap(Object element) {
		if (element instanceof org.eclipse.jface.viewers.IStructuredSelection) {
			return ((org.eclipse.jface.viewers.IStructuredSelection) element).getFirstElement();
		}
		return element;
	}

	/**
 * @generated
 */
	private org.eclipse.gmf.runtime.notation.View getView(Object element) {
		if (element instanceof org.eclipse.gmf.runtime.notation.View) {
			return (org.eclipse.gmf.runtime.notation.View) element;
		}
		if (element instanceof org.eclipse.core.runtime.IAdaptable) {
			return (org.eclipse.gmf.runtime.notation.View)
					((org.eclipse.core.runtime.IAdaptable) element).getAdapter(org.eclipse.gmf.runtime.notation.View.class);
		}
		return null;
	}

	/**
 * @generated
 */
	private org.eclipse.gmf.runtime.emf.type.core.IElementType getElementType(org.eclipse.gmf.runtime.notation.View view) {
		// For intermediate views climb up the containment hierarchy to find the one associated with an element type.
		while (view != null) {
			int vid = de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry.getVisualID(view);
			org.eclipse.gmf.runtime.emf.type.core.IElementType etype =
					de.uka.ipd.sdq.pcm.gmf.allocation.providers.PalladioComponentModelElementTypes.getElementType(vid);
			if (etype != null) {
				return etype;
			}
			view = view.eContainer() instanceof org.eclipse.gmf.runtime.notation.View ?
					(org.eclipse.gmf.runtime.notation.View) view.eContainer() : null;
		}
		return null;
	}



}
