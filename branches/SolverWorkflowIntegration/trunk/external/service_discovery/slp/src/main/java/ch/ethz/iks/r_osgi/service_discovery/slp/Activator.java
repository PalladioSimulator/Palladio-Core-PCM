package ch.ethz.iks.r_osgi.service_discovery.slp;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import ch.ethz.iks.r_osgi.service_discovery.ServiceDiscoveryHandler;

public class Activator implements BundleActivator {

	public void start(BundleContext context) throws Exception {
		context.registerService(ServiceDiscoveryHandler.class.getName(),
				new SLPServiceDiscoveryHandler(context), null);
	}

	public void stop(BundleContext context) throws Exception {

	}

}
