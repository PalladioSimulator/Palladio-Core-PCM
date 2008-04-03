package de.uka.ipd.sdq.sensorframework.dao.file;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.Map.Entry;

import de.uka.ipd.sdq.sensorframework.dao.db4o.IDGenerator;
import de.uka.ipd.sdq.sensorframework.dao.file.entities.NamedSerializable;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.State;
import de.uka.ipd.sdq.sensorframework.entities.StateSensor;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

interface IRemovalNotifier {

	void notifyRemoval(Entry eldest);
	
}

class LRUHashMap<K,V> extends LinkedHashMap<K,V> {
	private static final long serialVersionUID = 1L;
	private int capacity;
	private IRemovalNotifier parent;
	
	public LRUHashMap(int capacity, IRemovalNotifier parent) {
		this.capacity = capacity;
		this.parent = parent;
	}
	protected boolean removeEldestEntry(Map.Entry eldest) {
		boolean shouldRemove = size() > capacity;
		if (shouldRemove && parent != null) {
			parent.notifyRemoval(eldest);
		}
		return shouldRemove;
	}
}

public abstract class AbstractFileDAO<T> implements IRemovalNotifier {

	/**
	 * Configuration for the LRU cache used to store elements 
	 */
	private static final int MAX_CACHE_SIZE = 1000;

	/**
	 * Interface to other DAOs 
	 */
	protected FileDAOFactory factory = null;
	
	/**
	 * ID Generator instance
	 */
	protected IDGenerator idGen;
	
	/**
	 * A cache for elements stored in this DAO
	 */
	private LRUHashMap<Long, T> entitiesCache = null;

	private String myPrefix;
	
	public AbstractFileDAO(IDAOFactory factory, IDGenerator idGen, String prefix) {
		this.factory = (FileDAOFactory)factory;
		this.idGen = idGen;
		this.myPrefix = prefix;
		this.entitiesCache = new LRUHashMap<Long, T>(MAX_CACHE_SIZE,this);
	}

	public void store(T s) {
		NamedSerializable serialiseable = (NamedSerializable) s;
		factory.getFileManager().serializeToFile(serialiseable);
		serialiseable.serializeChildren();
		
		this.entitiesCache.put(serialiseable.getID(), (T) serialiseable);
	}

	public T get(long id) {
		return this.getEntry(id);
	}
	
	protected T getEntry(long id) {
		if (entitiesCache.containsKey(id) && entitiesCache.get(id) != null) {
			return entitiesCache.get(id);
		} else {
			T newEntry = loadEntry(id);
			this.entitiesCache.put(id,newEntry);
			return newEntry;
		}
	}

	protected Collection<T> getAllEntities() {
		ArrayList<T> result = new ArrayList<T>();
		File[] files = factory.getFileManager().listFiles(
					this.myPrefix);
		for (File file : files) {
			String name = file.getName();
			name = name.replace(this.myPrefix, "");
			name = name.substring(0,name.indexOf(FileDAOFactory.SUFFIX));
			long id = Long.parseLong(name);
			result.add(getEntry(id));
		}
		return Collections.unmodifiableCollection(result);
	}
	
	@SuppressWarnings("unchecked")
	protected T loadEntry(File file) {
		return (T) factory.getFileManager().deserializeFromFile(
				file);
	}

	@SuppressWarnings("unchecked")
	protected T loadEntry(long id) {
		return (T) factory.getFileManager().deserializeFromFile(
				this.myPrefix+id);
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
	
	@SuppressWarnings("unchecked")
	public void notifyRemoval(Entry eldest) {
		// StB: On eviction from the cache, persist the latest version available
		// However, this might not be expected as persistence should only be done on
		// explicit call to persist... Maybe change this to a temp storage solution later...
		store((T)eldest.getValue());
	}
	
	public void dispose() {
		this.entitiesCache.clear();
	}
}
