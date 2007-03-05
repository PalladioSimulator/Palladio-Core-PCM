package de.uka.ipd.sdq.codegen.simudatavisualization.views;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/**
 * The label provider to define how model objects should be presented in the
 * view. Each view can present the same model objects using different labels and
 * icons, if needed. Alternatively, a single label provider can be shared
 * between views in order to ensure that objects of the same type are presented
 * in the same way everywhere.
 * 
 */
public class TreeViewLabelProvider extends LabelProvider {

	public String getText(Object obj) {
		return obj.toString();
	}

	public Image getImage(Object obj) {
		String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
		if (obj instanceof TreeParent)
			imageKey = ISharedImages.IMG_OBJ_FOLDER;
		return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
	}

}
