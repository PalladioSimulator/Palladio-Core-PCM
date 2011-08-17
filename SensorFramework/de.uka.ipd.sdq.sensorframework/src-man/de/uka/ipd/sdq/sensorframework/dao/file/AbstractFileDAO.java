package de.uka.ipd.sdq.sensorframework.dao.file;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import de.uka.ipd.sdq.sensorframework.dao.file.entities.SerializableEntity;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

/**
 * An abstract implementation of a file DAO. The DAO is based on the following principle. All entities
 * are stored in a hashmap which hashes IDs to entities. The hashmap is fully loaded from the background
 * storage at startup, manipulated in memory, and finally stored back on request or when the DAO is disposed.
 * 
 * @author Steffen Becker
 *
 * @param <T> The type of the entities this DAO is able to handle
 */
public abstract class AbstractFileDAO<T> {

	/**
	 * Interface to other DAOs 
	 */
	protected FileDAOFactory factory = null;

	/**
	 * Prefix of the file which stores the elements controlled by this DAO
	 */
	private String myPrefix;

	/**
	 * ID Generator instance. Used by subclasses to create IDs of new elements
	 */
	protected IDGenerator idGen;
	
	/**
	 * A cache/storage for elements in this DAO
	 */
	private HashMap<Long, T> entitiesCache = null;//why not a sorted map?

	
	/** Constructor of this DAO
	 * @param factory Interface to other DAOs
	 * @param idGen Identifier Generator used for new elements
	 * @param prefix Filename prefix for the filename used to persist the elements controlled by this DAO
	 */
	public AbstractFileDAO(IDAOFactory factory, IDGenerator idGen, String prefix) {
		this.factory = (FileDAOFactory)factory;
		this.idGen = idGen;
		this.myPrefix = prefix;
		loadDataFromStorage();
	}

	/**
	 * Load all elements controlled by this DAO into memory. Called on startup to initialise this DAO
	 */
	@SuppressWarnings("unchecked")
	private void loadDataFromStorage() {
		this.entitiesCache = (HashMap<Long, T>) this.factory.getFileManager().deserializeFromFile(this.myPrefix);
		if (this.entitiesCache == null) {
			this.entitiesCache = new HashMap<Long, T>();
		} else {
			for (T value : this.entitiesCache.values()) {
				SerializableEntity serializable = (SerializableEntity) value;
				serializable.setFactory(this.factory);
			}
		}
	}

	/**
	 * Stores all elements controlled by this DAO on the persistent storage
	 */
	public void storeAll() {
		factory.getFileManager().serializeToFile(this.myPrefix,entitiesCache);
	}

	/** Get entity with given ID from DAO
	 * @param id ID of the element to retrieve. The element with ID id has to exist otherwise an 
	 * IllegalArguementException is thrown
	 * @return The requested element
	 */
	public T get(long id) {
		if (!entitiesCache.containsKey(id)) 
			throw new IllegalArgumentException("Entity with ID "+id+" not found in DAO");
		return entitiesCache.get(id);
	}
	
	/**
	 * Store a new element in this DAO. Used by subclasses to register newly created elements
	 * @param entity A new element. The element must not be controlled by the DAO already
	 */
	protected void putEntity(T entity) {
		SerializableEntity serialisable = (SerializableEntity) entity;
		if (entitiesCache.containsKey(serialisable.getID()))
			throw new IllegalArgumentException("Entity with ID "+serialisable.getID()+" already exists in this DAO");
		this.entitiesCache.put(serialisable.getID(), entity);
	}
	
	/** Returns a list of all entities stored in this DAO
	 * @return A list of all entities stored in this DAO
	 */
	protected Collection<T> getAllEntities() {
		return Collections.unmodifiableCollection(entitiesCache.values());
	}
		
	/** Remove the given entity from this DAO's control
	 * @param entity The entity to remove
	 * @param doCascade If true, all entities which depend on the passed entity are deleted as well
	 */
	public void removeEntity(T entity, boolean doCascade) {
		if (entity == null)
			throw new IllegalArgumentException("Entity can not be null");
		if (!entitiesCache.containsValue(entity))
			throw new IllegalArgumentException("Entity not controlled by this DAO");

		if (doCascade == true) {
			throw new UnsupportedOperationException();
		}
		
		entitiesCache.remove(((SerializableEntity)entity).getID());
	}
	
	/**
	 * Disposes this DAO. This includes persisting all changes to the background storage
	 */
	public void dispose() {
		this.storeAll();
		this.entitiesCache.clear();
	}
}
