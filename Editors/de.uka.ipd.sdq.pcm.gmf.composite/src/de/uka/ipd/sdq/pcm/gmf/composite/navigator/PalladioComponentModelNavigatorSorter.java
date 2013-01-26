/*
 *Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;

/**
 * The Class PalladioComponentModelNavigatorSorter.
 * 
 * @generated
 */
public class PalladioComponentModelNavigatorSorter extends ViewerSorter {

    /** The Constant GROUP_CATEGORY. @generated */
    private static final int GROUP_CATEGORY = 7004;

    /**
     * Category.
     * 
     * @param element
     *            the element
     * @return the int
     * @generated
     */
    public int category(Object element) {
        if (element instanceof PalladioComponentModelNavigatorItem) {
            PalladioComponentModelNavigatorItem item = (PalladioComponentModelNavigatorItem) element;
            return PalladioComponentModelVisualIDRegistry.getVisualID(item.getView());
        }
        return GROUP_CATEGORY;
    }

}
