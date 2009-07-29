package de.uka.ipd.sdq.pcm.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

import de.uka.ipd.sdq.pcm.diagram.part.PalladioComponentModelVisualIDRegistry;

/**
 * @generated
 */
public class PalladioComponentModelNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 7004;

	/**
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
