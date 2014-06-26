package edu.kit.ipd.sdq.eventsim.core.palladio.state;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import edu.kit.ipd.sdq.eventsim.core.palladio.Activator;

/**
 * Class to access the user state exchange service.
 * 
 * @author Christoph Föhrdes
 *
 */
public class StateExchange {

	public static void storeUserState(String userId, IUserState state) {
		BundleContext bundleContext = Activator.getContext();
		ServiceReference<IStateExchangeService> stateExServiceRef = bundleContext.getServiceReference(IStateExchangeService.class);
		IStateExchangeService stateExService = bundleContext.getService(stateExServiceRef);

		if (stateExService == null) {
			throw new RuntimeException("Could not find user state exchange service");
		}

		stateExService.storeUserState(userId, state);
	}

	public static IUserState getUserState(String userId) {
		BundleContext bundleContext = Activator.getContext();
		ServiceReference<IStateExchangeService> stateExServiceRef = bundleContext.getServiceReference(IStateExchangeService.class);
		IStateExchangeService stateExService = bundleContext.getService(stateExServiceRef);

		if (stateExService == null) {
			throw new RuntimeException("Could not find user state exchange service");
		}

		return stateExService.getUserState(userId);
	}

	public static void cleanupUserState(String userId) {
		BundleContext bundleContext = Activator.getContext();
		ServiceReference<IStateExchangeService> stateExServiceRef = bundleContext.getServiceReference(IStateExchangeService.class);
		IStateExchangeService stateExService = bundleContext.getService(stateExServiceRef);

		if (stateExService == null) {
			throw new RuntimeException("Could not find user state exchange service");
		}

		stateExService.cleanupUserState(userId);
	}
	
}
