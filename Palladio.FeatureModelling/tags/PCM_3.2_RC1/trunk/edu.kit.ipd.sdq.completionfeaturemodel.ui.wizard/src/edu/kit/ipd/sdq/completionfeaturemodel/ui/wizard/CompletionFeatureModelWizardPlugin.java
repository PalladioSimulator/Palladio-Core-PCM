package edu.kit.ipd.sdq.completionfeaturemodel.ui.wizard;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class CompletionFeatureModelWizardPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "edu.kit.ipd.sdq.completionfeaturemodel.ui.wizard";

	// The shared instance
	private static CompletionFeatureModelWizardPlugin plugin;
	
	//private final ImageCache imageRegistry = new ImageCache();
	
	/**
	 * The constructor
	 */
	public CompletionFeatureModelWizardPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
		//imageRegistry.dispose();
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static CompletionFeatureModelWizardPlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
	
/*	public Image getImage(ImageDescriptor imageDescriptor){
		return imageRegistry.getImage(imageDescriptor);
		
	}
	
	public Image getImage(String path) {
		return getImage(getImageDescriptor(path));
	}
	
	protected class ImageCache {
		private final Map<ImageDescriptor, Image> imageMap = new HashMap<ImageDescriptor, Image>();
		
		public Image getImage(ImageDescriptor imageDescriptor){
			if(imageDescriptor == null)
				return null;
			Image image = imageMap.get(imageDescriptor);
			if(image == null) {
				image = imageDescriptor.createImage();
				imageMap.put(imageDescriptor, image);
			}
			return image;
			
		}
		
		public void dispose() {
			Iterator<Image> iter = imageMap.values().iterator();
			while(iter.hasNext()) {
				iter.next().dispose();
			}
			imageMap.clear();
		}
	}*/
	
	
}
