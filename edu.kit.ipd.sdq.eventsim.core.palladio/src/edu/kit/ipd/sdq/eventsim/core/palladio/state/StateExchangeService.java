package edu.kit.ipd.sdq.eventsim.core.palladio.state;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of the user state exchange service to provide access to a
 * users state over simulation component borders.
 * 
 * @author Christoph Föhrdes
 * 
 */
public class StateExchangeService implements IStateExchangeService {

	Map<String, IUserState> userToStateMap;

	public StateExchangeService() {
		userToStateMap = new HashMap<String, IUserState>();
	}

	@Override
	public void storeUserState(String userId, IUserState state) {
		userToStateMap.put(userId, state);
	}

	@Override
	public IUserState getUserState(String userId) {
		return userToStateMap.get(userId);
	}

}
