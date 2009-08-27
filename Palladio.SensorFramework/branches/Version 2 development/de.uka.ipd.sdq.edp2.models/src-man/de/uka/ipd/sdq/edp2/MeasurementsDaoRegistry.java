/**
 * 
 */
package de.uka.ipd.sdq.edp2;

import java.util.Set;

/**Registry for all existing DAOs.
 * @author groenda
 */
public interface MeasurementsDaoRegistry {
	
	/**Registers a new DAO.
	 * @param dao The DAO to register.
	 * @param uuid The UUID for which the DAO is responsible.
	 */
	public void register(MeasurementsDao dao, String uuid);
	
	/**Deregisters an registered DAO.
	 * @param uuid The UUID of the registered DAO.
	 */
	public void deregister(String uuid);
	
	/**Checks if a DAO is registered for the UUID.
	 * @param uuid The UUID of the DAO.
	 * @return <code>true</code> if there is a DAO registered.
	 */
	public boolean isRegistered(String uuid);
	
	/**Returns the registered UUIDs.
	 * @return List with all registered UUIDs.
	 */
	public Set<String> getRegisteredUuids();
	
	/**Returns a registered DAO.
	 * @param uuid The UUID of the DAO.
	 * @return The DAO.
	 */
	public MeasurementsDao getMeasurementsDao(String uuid);
}
