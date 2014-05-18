package edu.kit.ipd.sdq.eventsim.core.palladio.state;

/**
 * Defines a service to store a user state for a specific user for internal stae
 * exchange.
 * 
 * @author Christoph Föhrdes
 * 
 */
public interface IStateExchangeService {

	/**
	 * Stores a state for a given user ID.
	 * 
	 * @param userId
	 * @param state
	 */
	public void storeUserState(String userId, IUserState state);

	/**
	 * Returns a user state for a given user ID.
	 * 
	 * @param userId
	 * @return A user state object
	 */
	public IUserState getUserState(String userId);
}
