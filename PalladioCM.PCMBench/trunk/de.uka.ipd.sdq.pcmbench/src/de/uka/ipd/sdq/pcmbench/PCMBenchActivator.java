package de.uka.ipd.sdq.pcmbench;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class PCMBenchActivator extends AbstractUIPlugin {

	public final static String PLUGIN_ID = "de.uka.ipd.sdq.pcmbench";
	
	//	 The shared instance
	private static PCMBenchActivator plugin;
	
	public PCMBenchActivator(){
		plugin = this;
	}
	/* (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		super.start(context);
	}

	/** Returns the shared instance	 */
	public static PCMBenchActivator getDefault() {
		return plugin;
	}

}
