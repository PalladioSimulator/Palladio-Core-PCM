/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.navigator;

import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;

import org.eclipse.jface.viewers.ViewerSorter;

/**
 * @generated
 */
public class PalladioComponentModelNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 7027;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof PalladioComponentModelNavigatorItem) {
			PalladioComponentModelNavigatorItem item = (PalladioComponentModelNavigatorItem) element;
			return PalladioComponentModelVisualIDRegistry.getVisualID(item
					.getView());
		}
		return GROUP_CATEGORY;
	}

}
