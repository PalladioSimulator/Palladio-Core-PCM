

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Collection;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

import de.uka.ipd.sdq.sensorfactory.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorfactory.dao.memory.MemoryDAOFactory;
import de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.sensorframework.adapter.AdapterRegistry;
import de.uka.ipd.sdq.sensorframework.adapter.IAdapterFactory;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "de.uka.ipd.sdq.sensorframework";

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		
		for(IConfigurationElement configurationElement : Platform.getExtensionRegistry().
				getConfigurationElementsFor("de.uka.ipd.sdq.sensorframework.adapter")){
		            
			IAdapterFactory factory = (IAdapterFactory)configurationElement.createExecutableExtension("class");
            AdapterRegistry.singleton().addAdapterFactory(factory);
		}
		try {
			File f = context.getDataFile("de.uka.ipd.sdq.sensorframework");
			FileInputStream fis = new FileInputStream(f);
			DataInputStream dos = new DataInputStream(fis);
			while(fis.available() > 0) {
				long id = dos.readLong();
				String className = dos.readUTF();
				String config = dos.readUTF();
				
				IDAOFactory factory = (IDAOFactory)Class.forName(className).getConstructor(String.class).
					newInstance(config);
				factory.setID((int)id);
				SensorFrameworkDataset.singleton().addDataSource(factory);
			}
		}catch(Exception e){
			if (SensorFrameworkDataset.singleton().getDataSources().size() == 0)
				SensorFrameworkDataset.singleton().addDataSource(new MemoryDAOFactory(0));
		}
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		File f = context.getDataFile("de.uka.ipd.sdq.sensorframework");
		f.delete();
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(f));
		Collection<IDAOFactory> sources = SensorFrameworkDataset.singleton().getDataSources();
		for (IDAOFactory source : sources) {
			source.finalizeAndClose();
			dos.writeLong(source.getID());
			dos.writeUTF(source.getClass().getName());
	 		dos.writeUTF(source.getPersistendInfo());
		}
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

}
