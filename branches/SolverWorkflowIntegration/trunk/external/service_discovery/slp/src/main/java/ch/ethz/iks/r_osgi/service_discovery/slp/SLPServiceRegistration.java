package ch.ethz.iks.r_osgi.service_discovery.slp;

import java.util.Dictionary;
import java.util.Enumeration;

import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;
import ch.ethz.iks.r_osgi.URI;
import ch.ethz.iks.slp.Advertiser;
import ch.ethz.iks.slp.ServiceLocationException;
import ch.ethz.iks.slp.ServiceURL;

public class SLPServiceRegistration {

	private ServiceURL[] urls;

	private Dictionary properties;

	SLPServiceRegistration(final ServiceReference ref,
			final Dictionary properties, final URI uri) {
		this.properties = properties;
		final String[] interfaces = (String[]) ref
				.getProperty(Constants.OBJECTCLASS);

		// cleaning up the properties
		for (Enumeration e = properties.keys(); e.hasMoreElements();) {
			final String key = (String) e.nextElement();
			final Object value = properties.get(key);
			if (value instanceof String[]) {
				final String[] sa = (String[]) value;
				final StringBuffer buffer = new StringBuffer();
				for (int i = 0; i < sa.length - 1; i++) {
					buffer.append(sa[i]);
					buffer.append(",");
				}
				for (int i = sa.length - 1; i < sa.length; i++) {
					buffer.append(sa[i]);
				}
				properties.put(key, sa);
			}
		}

		urls = new ServiceURL[interfaces.length];
		for (int i = 0; i < interfaces.length; i++) {
			try {
				urls[i] = new ServiceURL("service:osgi:"
						+ interfaces[i].replace('.', '/') + "://"
						+ uri.getScheme() + "://" + uri.getHostName() + ":"
						+ uri.getPort() + "/" + uri.getFragment(),
						SLPServiceDiscoveryHandler.DEFAULT_SLP_LIFETIME * 1000);
			} catch (ServiceLocationException sle) {
				sle.printStackTrace();
			}
		}
	}

	void register(final Advertiser advertiser) throws ServiceLocationException {
		for (int i = 0; i < urls.length; i++) {
			advertiser.register(urls[i], properties);
		}
	}

	public void unregister(Advertiser advertiser)
			throws ServiceLocationException {
		for (int i = 0; i < urls.length; i++) {
			advertiser.deregister(urls[i]);
		}
	}
}
