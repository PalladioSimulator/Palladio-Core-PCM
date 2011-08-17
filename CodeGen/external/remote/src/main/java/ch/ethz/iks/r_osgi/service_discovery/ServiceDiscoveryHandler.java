package ch.ethz.iks.r_osgi.service_discovery;

import java.util.Dictionary;

import org.osgi.framework.ServiceReference;

import ch.ethz.iks.r_osgi.URI;

public interface ServiceDiscoveryHandler {

	void registerService(final ServiceReference ref,
			final Dictionary properties, final URI uri);

	void unregisterService(final ServiceReference ref);

}
