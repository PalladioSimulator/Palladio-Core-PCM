/**
 * 
 */
package de.uka.ipd.sdq.edp2.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import de.uka.ipd.sdq.edp2.MeasurementsDao;
import de.uka.ipd.sdq.edp2.MeasurementsDaoRegistry;


/**Default implementation of the DaoRegistry.
 * Responsible to hold a list of all registered DAOs and the access to them.
 * The DAO factories should be used for creation of DAOs. They must register
 * the DAOs at the central registry.
 * @author groenda
 */
public class MeasurementsDaoRegistryImpl implements MeasurementsDaoRegistry {
	/** Logger for this class. */
	private static final Logger logger = Logger.getLogger(MeasurementsDaoRegistryImpl.class.getCanonicalName());
	
	/** Map of the registered DAOs. */
	private ConcurrentMap<String, MeasurementsDao> registeredDaos;
	
	
	/**Initialize the registry.
	 */
	public MeasurementsDaoRegistryImpl() {
		registeredDaos = new ConcurrentHashMap<String, MeasurementsDao>();
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.DaoRegistry#deregister(java.lang.String)
	 */
	@Override
	public void deregister(String uuid) {
		if (!isRegistered(uuid)) {
			String msg = "Tried to deregister a DAO which was not registered. UUID was " + uuid + ".";
			logger.log(Level.SEVERE, msg);
			throw new IllegalArgumentException(msg);
		} else {
			registeredDaos.remove(uuid);
		}
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.DaoRegistry#isRegistered(java.lang.String)
	 */
	@Override
	public boolean isRegistered(String uuid) {
		return registeredDaos.containsKey(uuid);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.DaoRegistry#register(de.uka.ipd.sdq.edp2.Edp2Dao, java.lang.String)
	 */
	@Override
	public void register(MeasurementsDao dao, String uuid) {
		if (isRegistered(uuid)) {
			String msg = "Tried to register a DAO which was already registered. UUID was " + uuid + ".";
			logger.log(Level.SEVERE, msg);
			throw new IllegalArgumentException(msg);
		} else {
			registeredDaos.put(uuid, dao);
		}
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.Edp2DaoRegistry#getEdp2Dao(java.lang.String)
	 */
	@Override
	public MeasurementsDao getMeasurementsDao(String uuid) {
		return registeredDaos.get(uuid);
	}

	@Override
	public Set<String> getRegisteredUuids() {
		Set<String> returnSet = new HashSet<String>();
		Iterator<String> listIterator = registeredDaos.keySet().iterator();
		while (listIterator.hasNext()) {
			returnSet.add(listIterator.next());
		}
		return registeredDaos.keySet();
	}

}
