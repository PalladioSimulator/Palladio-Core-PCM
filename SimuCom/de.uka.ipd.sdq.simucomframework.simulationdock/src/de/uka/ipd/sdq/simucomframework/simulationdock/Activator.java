package de.uka.ipd.sdq.simucomframework.simulationdock;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;

import ch.ethz.iks.r_osgi.RemoteOSGiService;

public class Activator implements BundleActivator {

	private SimulationDockService service;
	private ServiceRegistration serviceRegistryEntry;
	private ServiceTracker eventService;
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		Hashtable properties = new Hashtable();
		if (System.getProperty("simucom.registerDock") != null)
			properties.put(RemoteOSGiService.R_OSGi_REGISTRATION, true);		
		
		service = new SimulationDockServiceImpl(context);
		// register the service
		serviceRegistryEntry = context.registerService(SimulationDockService.class.getName(), service, properties);	
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		serviceRegistryEntry.unregister();
		service = null;
	}

}
