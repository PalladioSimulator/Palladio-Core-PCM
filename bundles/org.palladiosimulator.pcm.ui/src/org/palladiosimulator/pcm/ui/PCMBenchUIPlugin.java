package org.palladiosimulator.pcm.ui;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;

/**
 * The activator class controls the plug-in life cycle
 */
public class PCMBenchUIPlugin extends EMFPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.palladiosimulator.pcm.ui";

	// The shared instance
	private static Implementation plugin;

	public static final PCMBenchUIPlugin INSTANCE = new PCMBenchUIPlugin();
	
	/**
	 * The constructor
	 */
	public PCMBenchUIPlugin() {
		super(new ResourceLocator[]{});
	}
	
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}	

	public static class Implementation extends EclipsePlugin {
		/**
		 * Creates an instance.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public Implementation() {
			super();

			// Remember the static instance.
			//
			plugin = this;
		}
	}

}
