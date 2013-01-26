/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.sheet;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.graphics.Image;

import de.uka.ipd.sdq.pcm.gmf.composite.navigator.PalladioComponentModelNavigatorGroup;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes;

/**
 * The Class PalladioComponentModelSheetLabelProvider.
 * 
 * @generated
 */
public class PalladioComponentModelSheetLabelProvider extends BaseLabelProvider implements ILabelProvider {

    /**
     * Gets the text.
     * 
     * @param element
     *            the element
     * @return the text
     * @generated
     */
    public String getText(Object element) {
        element = unwrap(element);
        if (element instanceof PalladioComponentModelNavigatorGroup) {
            return ((PalladioComponentModelNavigatorGroup) element).getGroupName();
        }
        IElementType etype = getElementType(getView(element));
        return etype == null ? "" : etype.getDisplayName();
    }

    /**
     * Gets the image.
     * 
     * @param element
     *            the element
     * @return the image
     * @generated
     */
    public Image getImage(Object element) {
        IElementType etype = getElementType(getView(unwrap(element)));
        return etype == null ? null : PalladioComponentModelElementTypes.getImage(etype);
    }

    /**
     * Unwrap.
     * 
     * @param element
     *            the element
     * @return the object
     * @generated
     */
    private Object unwrap(Object element) {
        if (element instanceof IStructuredSelection) {
            return ((IStructuredSelection) element).getFirstElement();
        }
        return element;
    }

    /**
     * Gets the view.
     * 
     * @param element
     *            the element
     * @return the view
     * @generated
     */
    private View getView(Object element) {
        if (element instanceof View) {
            return (View) element;
        }
        if (element instanceof IAdaptable) {
            return (View) ((IAdaptable) element).getAdapter(View.class);
        }
        return null;
    }

    /**
     * Gets the element type.
     * 
     * @param view
     *            the view
     * @return the element type
     * @generated
     */
    private IElementType getElementType(View view) {
        // For intermediate views climb up the containment hierarchy to find the one associated with
        // an element type.
        while (view != null) {
            int vid = PalladioComponentModelVisualIDRegistry.getVisualID(view);
            IElementType etype = PalladioComponentModelElementTypes.getElementType(vid);
            if (etype != null) {
                return etype;
            }
            view = view.eContainer() instanceof View ? (View) view.eContainer() : null;
        }
        return null;
    }

}
