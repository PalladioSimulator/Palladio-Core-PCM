package de.uka.ipd.sdq.sensorframework;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Collection;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

import de.uka.ipd.sdq.sensorframework.adapter.AdapterRegistry;
import de.uka.ipd.sdq.sensorframework.adapter.IAdapterFactory;
import de.uka.ipd.sdq.sensorframework.dao.memory.MemoryDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.sensorframework.filter.FilteredCollectionRegistry;
import de.uka.ipd.sdq.sensorframework.filter.IFilteredCollectionFactory;

/**
 * The activator class controls the plug-in life cycle
 * @author Roman Andrej
 * @author Steffen Becker

 */
public class SensorFrameworkPluginActivator extends Plugin {

	/** The plug-in ID. */
	public static final String PLUGIN_ID = "de.uka.ipd.sdq.sensorframework";
	
	/** EPID - Filter extension Point ID. */
	private static final String ADAPTER_EPID = "de.uka.ipd.sdq.sensorframework.adapter";
	
	/** EPID - Filter extension Point ID. */
	private static final String FILTER_EPID = "de.uka.ipd.sdq.sensorframework.filter";

	/** The shared instance. */
	private static SensorFrameworkPluginActivator plugin;
	
	/** The constructor. */
	public SensorFrameworkPluginActivator() {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		IExtensionRegistry registry = Platform.getExtensionRegistry();

		for (IConfigurationElement configurationElement : registry
				.getConfigurationElementsFor(ADAPTER_EPID)) {

			IAdapterFactory factory = (IAdapterFactory) configurationElement
					.createExecutableExtension("class");
			AdapterRegistry.singleton().addAdapterFactory(factory);
		}

		for (IConfigurationElement configurationElement : registry
				.getConfigurationElementsFor(FILTER_EPID)) {

			IFilteredCollectionFactory factory = (IFilteredCollectionFactory) configurationElement
					.createExecutableExtension("class");
			String filterName = configurationElement
					.getAttribute("displayName");
			FilteredCollectionRegistry.singleton().addFilteredCollectionFactory(filterName, factory);
		}

		try {
			File file = context.getDataFile(PLUGIN_ID);
			FileInputStream fis = new FileInputStream(file);
			DataInputStream dos = new DataInputStream(fis);
			while (fis.available() > 0) {
				long id = dos.readLong();
				String className = dos.readUTF();
				String config = dos.readUTF();

				IDAOFactory factory = (IDAOFactory) Class.forName(className)
						.getConstructor(String.class).newInstance(config);
				factory.setID((int) id);
				SensorFrameworkDataset.singleton().addDataSource(factory);
			}
		} catch (Exception e) {
			log(IStatus.ERROR, "Restoring Dataset Configuration failed. Resetting configuration...", e);
			if (SensorFrameworkDataset.singleton().getDataSources().size() == 0)
				SensorFrameworkDataset.singleton().addDataSource(
						new MemoryDAOFactory(0));
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		File f = context.getDataFile("de.uka.ipd.sdq.sensorframework");
		try {
			f.delete();
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(f));
			Collection<IDAOFactory> sources = SensorFrameworkDataset.singleton().getDataSources();
			for (IDAOFactory source : sources) {
				try {
					source.finalizeAndClose();
				} catch (Exception e) {
					log(IStatus.ERROR, "Failed to close datasource with ID "+source.getID(),e);
				}
				dos.writeLong(source.getID());
				dos.writeUTF(source.getClass().getName());
		 		dos.writeUTF(source.getPersistendInfo());
			}
			dos.close();
		} catch (Exception e) {
			log(IStatus.ERROR, "Saving Dataset Configuration failed.",e);
			f.deleteOnExit();
		}
		super.stop(context);
	}
	
	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static SensorFrameworkPluginActivator getDefault() {
		return plugin;
	}
	
	public static void log(int severity, String message, Throwable t) {
		if (plugin != null) {
			plugin.getLog().log(new Status(severity,PLUGIN_ID,message,t));
		}
	}
}
