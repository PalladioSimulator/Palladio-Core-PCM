package de.uka.ipd.sdq.sensorframework.dao.file;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import de.uka.ipd.sdq.sensorframework.dao.file.entities.NamedSerializable;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

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
	 * ID Generator instance
	 */
	protected IDGenerator idGen;
	
	/**
	 * A cache for elements stored in this DAO
	 */
	private HashMap<Long, T> entitiesCache = null;

	
	@SuppressWarnings("unchecked")
	public AbstractFileDAO(IDAOFactory factory, IDGenerator idGen, String prefix) {
		this.factory = (FileDAOFactory)factory;
		this.idGen = idGen;
		this.myPrefix = prefix;
		loadDataFromStorage();
	}

	private void loadDataFromStorage() {
		this.entitiesCache = (HashMap<Long, T>) this.factory.getFileManager().deserializeFromFile(this.myPrefix);
		if (this.entitiesCache == null) {
			this.entitiesCache = new HashMap<Long, T>();
		} else {
			for (T value : this.entitiesCache.values()) {
				NamedSerializable serializable = (NamedSerializable) value;
				serializable.setFactory(this.factory);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void storeAll() {
		factory.getFileManager().serializeToFile(this.myPrefix,entitiesCache);
	}

	public T get(long id) {
		return this.getEntry(id);
	}
	
	protected void putEntity(T entity) {
		NamedSerializable serialisable = (NamedSerializable) entity;
		if (entitiesCache.containsKey(serialisable.getID()))
			throw new IllegalArgumentException("Entity with ID "+serialisable.getID()+" already exists in this DAO");
		this.entitiesCache.put(serialisable.getID(), entity);
	}
	
	protected T getEntry(long id) {
		if (!entitiesCache.containsKey(id)) 
			throw new IllegalArgumentException("Entity with ID "+id+" not found in DAO");
		return entitiesCache.get(id);
	}

	protected Collection<T> getAllEntities() {
		return Collections.unmodifiableCollection(entitiesCache.values());
	}
		
	public void removeEntity(T entity, boolean doCascade) {
		throw new UnsupportedOperationException();
//		if (entity == null)
//			throw new IllegalArgumentException("Entity can not be null");
//
//		if (doCascade == true) {
//			// TODO!
//		}
//		// TODO! entitiesCache.remove(entity.getSensorID());
//		factory.getFileManager().removeFile((NamedSerializable) entity);
	}
	
	public void dispose() {
		this.storeAll();
		this.entitiesCache.clear();
	}
}
