/*
 *Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry;

/**
 * @generated
 */
public class PalladioComponentModelNavigatorSorter extends ViewerSorter {

    /**
     * @generated
     */
    private static final int GROUP_CATEGORY = 7110;

    /**
     * @generated
     */
    private static final int SHORTCUTS_CATEGORY = 7109;

    /**
     * @generated
     */
    public int category(Object element) {
        if (element instanceof PalladioComponentModelNavigatorItem) {
            PalladioComponentModelNavigatorItem item = (PalladioComponentModelNavigatorItem) element;
            if (item.getView().getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
                return SHORTCUTS_CATEGORY;
            }
            return PalladioComponentModelVisualIDRegistry.getVisualID(item.getView());
        }
        return GROUP_CATEGORY;
    }

}
