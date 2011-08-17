package de.uka.ipd.sdq.cip.runtime;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;


/**
 * The class is used for the administration the images stored in the Plug-In.
 * 
 * @author Roman Andrej
 * @author Thomas Schuischel
 */
public class RunConfigImages {
	
	/**
	 * Names of images used to represent actions in ToolBar
	 */
	public static final String COMPLETION_TAB 		= "completion_tab";
	public static final String FOLDER_ICON	 		= "folder_icon";
	public static final String ANNOTATION_ICON 		= "annotation_icon";
	public static final String ANNOTATION_NEW_ICON 	= "annotation_new_icon";
	public static final String CHILI_ICON 			= "chili";
	
	/** For the toolbar images */
	public static ImageRegistry imageRegistry = new ImageRegistry();
	
	/**
	 * Note: An image registry owns all of the image objects registered with it,
	 * and automatically disposes of them the SWT Display is disposed.
	 */ 
	static {
		String iconPath = "icons/";
		
		imageRegistry.put(COMPLETION_TAB,
				 getImageDescriptor(iconPath + COMPLETION_TAB + ".gif"));
		
		imageRegistry.put(FOLDER_ICON,
				 getImageDescriptor(iconPath + FOLDER_ICON + ".png"));
		
		imageRegistry.put(ANNOTATION_ICON,
				 getImageDescriptor(iconPath + ANNOTATION_ICON + ".png"));
		
		imageRegistry.put(ANNOTATION_NEW_ICON,
				 getImageDescriptor(iconPath + ANNOTATION_NEW_ICON + ".png"));
		
		imageRegistry.put(CHILI_ICON,
				 getImageDescriptor(iconPath + CHILI_ICON + ".jpg"));
	}

	/**
	 * @param imageFilePath
	 *            the relative to the root of the plug-in; the path must be
	 *            legal
	 * @return an image descriptor, or null if no image could be found
	 */
	public static ImageDescriptor getImageDescriptor(String imageFilePath) {
		return CipRuntimePlugin.imageDescriptorFromPlugin(CipRuntimePlugin.PLUGIN_ID, imageFilePath);
	}

	public static Image getCompletionTabImage() {
		return imageRegistry.get(COMPLETION_TAB);
	}

	public static Image getFileNamesTabImage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static Image getFolderIcon() {
		return imageRegistry.get(FOLDER_ICON);
	}
	
	public static Image getAnnotationIcon() {
		return imageRegistry.get(ANNOTATION_ICON);
	}
	
	public static Image getAnnotationNewIcon() {
		return imageRegistry.get(ANNOTATION_NEW_ICON);
	}
	
	public static ImageDescriptor getChiliIconDescriptor() {
		return imageRegistry.getDescriptor(CHILI_ICON);
	}
}
