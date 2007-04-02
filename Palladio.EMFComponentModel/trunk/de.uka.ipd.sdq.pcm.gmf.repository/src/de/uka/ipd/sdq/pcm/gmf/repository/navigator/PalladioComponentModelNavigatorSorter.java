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
	private static final int GROUP_CATEGORY = 7104;

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
