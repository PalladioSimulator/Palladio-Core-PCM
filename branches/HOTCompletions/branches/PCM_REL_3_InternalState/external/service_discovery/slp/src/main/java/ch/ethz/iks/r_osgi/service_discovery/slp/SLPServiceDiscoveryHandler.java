package ch.ethz.iks.r_osgi.service_discovery.slp;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;
import ch.ethz.iks.r_osgi.URI;
import ch.ethz.iks.r_osgi.RemoteOSGiException;
import ch.ethz.iks.r_osgi.service_discovery.ServiceDiscoveryHandler;
import ch.ethz.iks.r_osgi.service_discovery.ServiceDiscoveryListener;
import ch.ethz.iks.slp.Advertiser;
import ch.ethz.iks.slp.Locator;
import ch.ethz.iks.slp.ServiceLocationEnumeration;
import ch.ethz.iks.slp.ServiceLocationException;
import ch.ethz.iks.slp.ServiceType;
import ch.ethz.iks.slp.ServiceURL;
import ch.ethz.iks.util.CollectionUtils;
import ch.ethz.iks.util.ScheduleListener;
import ch.ethz.iks.util.Scheduler;

public class SLPServiceDiscoveryHandler implements ServiceDiscoveryHandler,
		ScheduleListener {

	private static final int DISCOVERY_INTERVAL = Integer
			.parseInt(System
					.getProperty(
							"ch.ethz.iks.r_osgi.service_discovery.slp.discovery_interval",
							"20"));

	/**
	 * SLP registration scheduler.
	 */
	private final Scheduler reregistration = new Scheduler(this);

	private Advertiser advertiser;

	private Locator locator;

	private Map registrations = new HashMap();

	private ServiceTracker discoveryListenerTracker;

	private boolean hasListeners = false;

	private Set seenServices = new HashSet();

	// known to a certain listener ?
	// sref -> [known service urls]
	private HashMap knownServices = new HashMap();

	private ArrayList warningList = new ArrayList();

	private DiscoveryThread thread;

	// queries
	// filter string -> [srefs]
	private HashMap queries = new HashMap();

	private static final ServiceType OSGI = new ServiceType("service:osgi");

	/**
	 * constant that holds the property string for SLP registration lifetime.
	 * Default is 60 seconds.
	 */
	private static final String DEFAULT_SLP_LIFETIME_PROPERTY = "ch.ethz.iks.r_osgi.service_discovery.slp.defaultLifetime";

	/**
	 * default lifetime for SLP registration.
	 */
	static int DEFAULT_SLP_LIFETIME;

	public SLPServiceDiscoveryHandler(final BundleContext context) {
		final String prop = context.getProperty(DEFAULT_SLP_LIFETIME_PROPERTY);
		DEFAULT_SLP_LIFETIME = prop != null ? Integer.parseInt(prop) : 90;

		final ServiceReference advRef = context
				.getServiceReference(Advertiser.class.getName());
		final ServiceReference locRef = context
				.getServiceReference(Locator.class.getName());
		if (advRef == null || locRef == null) {
			throw new RuntimeException("jSLP is not running.");
		}
		this.advertiser = (Advertiser) context.getService(advRef);
		this.locator = (Locator) context.getService(locRef);

		if (DISCOVERY_INTERVAL > 0) {
			thread = new DiscoveryThread();
			thread.start();

			try {
				discoveryListenerTracker = new ServiceTracker(context, context
						.createFilter("(" + Constants.OBJECTCLASS + "="
								+ ServiceDiscoveryListener.class.getName()
								+ ")"), new ServiceTrackerCustomizer() {

					public Object addingService(ServiceReference reference) {

						synchronized (thread) {
							if (!hasListeners) {
								hasListeners = true;
								thread.notifyAll();
							}
						}

						// TODO: modify the query

						final String filter = (String) reference
								.getProperty(ServiceDiscoveryListener.FILTER_PROPERTY);
						CollectionUtils.addValue(queries, filter, reference);

						// TODO: check all known services

						return context.getService(reference);
					}

					public void modifiedService(ServiceReference reference,
							Object service) {
						// TODO: modify the query

					}

					public void removedService(ServiceReference reference,
							Object service) {

						final String filter = (String) reference
								.getProperty(ServiceDiscoveryListener.FILTER_PROPERTY);
						CollectionUtils.removeValue(queries,
								new Object[] { filter }, reference);

						synchronized (thread) {
							if (discoveryListenerTracker.getTrackingCount() == 0) {
								hasListeners = true;
								thread.notifyAll();
							}
						}
					}
				});
				discoveryListenerTracker.open();
			} catch (InvalidSyntaxException ise) {
				// should not happen
				ise.printStackTrace();
			}
		}
	}

	public void registerService(final ServiceReference ref,
			final Dictionary properties, final URI uri) {
		try {
			final SLPServiceRegistration reg = new SLPServiceRegistration(ref,
					properties, uri);
			registrations.put(ref, reg);
			reg.register(advertiser);
			reregistration.schedule(reg, System.currentTimeMillis()
					+ (SLPServiceDiscoveryHandler.DEFAULT_SLP_LIFETIME - 1)
					* 1000);
		} catch (ServiceLocationException slp) {
			slp.printStackTrace();
		}
	}

	public void unregisterService(final ServiceReference ref) {
		final SLPServiceRegistration reg = (SLPServiceRegistration) registrations
				.get(ref);
		try {
			reg.unregister(advertiser);
		} catch (ServiceLocationException slp) {
			slp.printStackTrace();
		}
		reregistration.unschedule(reg);
	}

	public void due(Scheduler scheduler, long timestamp, Object object) {
		final SLPServiceRegistration reg = (SLPServiceRegistration) object;
		try {
			reg.register(advertiser);
		} catch (ServiceLocationException slp) {
			slp.printStackTrace();
		}
		scheduler.reschedule(reg, System.currentTimeMillis()
				+ (SLPServiceDiscoveryHandler.DEFAULT_SLP_LIFETIME - 1) * 1000);
	}

	private void announceService(final URI uri,
			final String serviceInterfaceName, final ServiceReference ref) {
		((ServiceDiscoveryListener) discoveryListenerTracker.getService(ref))
				.announceService(serviceInterfaceName, uri);
	}

	private void discardService(final URI uri,
			final String serviceInterfaceName, final ServiceReference ref) {
		((ServiceDiscoveryListener) discoveryListenerTracker.getService(ref))
				.discardService(serviceInterfaceName, uri);
	}

	private URI uriFromServiceURL(final ServiceURL service) {
		return URI.create(service.getProtocol() + "://" + service.getHost()
				+ ":" + service.getPort() + "#"
				+ service.getURLPath().substring(1));
	}

	private final class DiscoveryThread extends Thread {

		public void run() {
			try {
				while (!isInterrupted()) {
					// in case nobody listens, don't do any discovery
					synchronized (this) {
						if (!hasListeners) {
							wait();
						}
					}

					try {
						// initially contains all known services
						final List lostServices = new ArrayList(seenServices);

						final String[] filters = (String[]) queries.keySet()
								.toArray(new String[queries.size()]);

						// for each active filter
						for (int i = 0; i < filters.length; i++) {
							// find all services of type osgi
							final ServiceLocationEnumeration services = locator
									.findServices(OSGI, null, filters[i]);

							// iterate over the results
							while (services.hasMoreElements()) {

								final ServiceURL service = (ServiceURL) services
										.next();

								if (!seenServices.contains(service)) {
									seenServices.add(service);
								}

								// create the URI
								final URI uri = uriFromServiceURL(service);

								// find the srefs that match
								final List l = (List) queries.get(filters[i]);
								if (l != null) {
									final ServiceReference[] refs = (ServiceReference[]) l
											.toArray(new ServiceReference[l
													.size()]);

									for (int j = 0; j < refs.length; j++) {
										// already known to this service?
										final List known = (List) knownServices
												.get(refs[j]);
										if (known == null
												|| !known.contains(service
														.toString())) {

											// does the listener look for this
											// type
											// of interface?
											final String serviceInterfaceName = service
													.getServiceType()
													.getConcreteTypeName()
													.replace('/', '.');

											final String[] interfaces = (String[]) refs[i]
													.getProperty(ServiceDiscoveryListener.SERVICE_INTERFACES_PROPERTY);
											if (interfaces == null) {
												CollectionUtils.addValue(
														knownServices, refs[j],
														service.toString());
												announceService(uri,
														serviceInterfaceName,
														refs[j]);
												break;
											}

											for (int k = 0; k < interfaces.length; k++) {
												if (interfaces[k]
														.equals(serviceInterfaceName)) {
													CollectionUtils
															.addValue(
																	knownServices,
																	refs[j],
																	service
																			.toString());
													announceService(
															uri,
															serviceInterfaceName,
															refs[j]);
													break;
												}
											}

										}
									}
								}
								// seen, so remove from lost list
								lostServices.remove(service);
							}
						}

						// notify the listeners for all lost services
						for (Iterator iter = lostServices.iterator(); iter
								.hasNext();) {
							ServiceURL lostService = (ServiceURL) iter.next();
							if (!warningList.contains(lostService)) {
								warningList.add(lostService);
							} else {
								warningList.remove(lostService);
								seenServices.remove(lostService);
								final URI uri = uriFromServiceURL(lostService);
								final ServiceReference[] refs = (ServiceReference[]) discoveryListenerTracker
										.getServiceReferences();
								for (int i = 0; i < refs.length; i++) {
									final List known = (List) knownServices
											.get(refs[i]);
									if (known != null
											&& known.contains(lostService
													.toString())) {
										known.remove(lostService.toString());
										discardService(uri, lostService
												.getServiceType()
												.getConcreteTypeName().replace(
														'/', '.'), refs[i]);
									}
								}
							}
						}
					} catch (ServiceLocationException sle) {
						sle.printStackTrace();
					} catch (RemoteOSGiException re) {
						re.printStackTrace();
					}
					Thread.sleep(DISCOVERY_INTERVAL * 1000);
				}
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
}
