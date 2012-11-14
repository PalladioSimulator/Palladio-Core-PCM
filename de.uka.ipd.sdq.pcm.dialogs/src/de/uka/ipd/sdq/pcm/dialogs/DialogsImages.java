package de.uka.ipd.sdq.pcm.dialogs;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * @author roman Compilation of the pictures used in de.uka.ipd.sdq.dialogs-Plugin
 */
public class DialogsImages {

    /**
     * Names of images used to represent actions in ToolBar
     */
    public static final String ADD = "add_action";
    public static final String DELETE = "delete_action";
    public static final String UP = "up_action";
    public static final String DOWN = "down_action";
    public static final String ERROR = "error";
    public static final String WARNING = "warning";

    public static ImageRegistry imageRegistry = new ImageRegistry();

    /**
     * Note: An image registry owns all of the image objects registered with it, and automatically
     * disposes of them the SWT Display is disposed.
     */
    static {
        String iconPath = "icons/";

        imageRegistry.put(ADD, getImageDescriptor(iconPath + ADD + ".gif"));

        imageRegistry.put(DELETE, getImageDescriptor(iconPath + DELETE + ".gif"));
        imageRegistry.put(DOWN, getImageDescriptor(iconPath + DOWN + ".gif"));
        imageRegistry.put(UP, getImageDescriptor(iconPath + UP + ".gif"));
        imageRegistry.put(ERROR, getImageDescriptor(iconPath + ERROR + ".gif"));
        imageRegistry.put(WARNING, getImageDescriptor(iconPath + WARNING + ".gif"));
    }

    /**
     * @param imageFilePath
     *            the relative to the root of the plug-in; the path must be legal
     * @return an image descriptor, or null if no image could be found
     */
    public static ImageDescriptor getImageDescriptor(String imageFilePath) {
        return AbstractUIPlugin.imageDescriptorFromPlugin(PCMDialogPluginActivator.PLUGIN_ID, imageFilePath);
    }

}
