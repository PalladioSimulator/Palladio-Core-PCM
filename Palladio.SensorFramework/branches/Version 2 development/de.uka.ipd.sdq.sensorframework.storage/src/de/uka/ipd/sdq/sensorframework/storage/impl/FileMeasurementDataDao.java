/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.storage.impl;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import de.uka.ipd.sdq.sensorframework.storage.DataNotAccessibleException;
import de.uka.ipd.sdq.sensorframework.storage.MeasurementDataDao;
import de.uka.ipd.sdq.sensorframework.storage.file.BackgroundMemoryList;
import de.uka.ipd.sdq.sensorframework.storage.file.Serializer;
import de.uka.ipd.sdq.sensorframework.storage.file.impl.BackgroundMemoryListImpl;

/**DAO for measurement data stored in binary files.
 * @author groenda
 */
public class FileMeasurementDataDao<T> implements MeasurementDataDao<T> {
	/** Suffix for files in which the measurements are stored. */
	public final static String FILE_SUFFIX = ".bin";
	
	/** Directory in which all files are stored. */
	private File storageDirectory = null;
	/** Unique identifier for the measurements. Must be a valid file name. */
	private String uuid = null;
	/** Serializer to use for the background list. */
	private Serializer<T> serializer = null;
	/** Background memory list used to actually handle the list. */
	private BackgroundMemoryList<T> backgroundMemoryList;
	/** Status if the background storage is currently accessible. */
	private boolean accessible = false;
	
	/**Calculates the absolute path for the file in which the measurements are stored.
	 * @return Absolute path to the file.
	 */
	private String getAbsolutePath() {
		return storageDirectory.getAbsolutePath() + "/" + uuid + FILE_SUFFIX;
	}
	
	public void openStorage() throws DataNotAccessibleException {
		if (storageDirectory==null || uuid == null || serializer == null || accessible == true) {
			throw new IllegalStateException("Protocol violation. It is mandataory to provide " +
					"information about the file location first. Files are not allowed to be opened " +
					"twice.", null);
		}
		try {
			this.backgroundMemoryList = new BackgroundMemoryListImpl<T>(getAbsolutePath(), serializer);
			accessible = true;
		} catch (IOException ioe) {
			throw new DataNotAccessibleException("Error accessing file on background storage.", ioe);
		}
	}
	
	public void closeStorage() throws DataNotAccessibleException {
		if (accessible) {
			try {
				backgroundMemoryList.close();
			} catch (IOException ioe) {
				throw new DataNotAccessibleException("Error accessing file on background storage.", ioe);
			}
		} else {
			throw new IllegalStateException("Protocol violation. The background story was not opened before it was closed.");
		}
	}
	
	public boolean isStorageClosed() {
		return false;
	}

	@Override
	public boolean add(T e) {
		return backgroundMemoryList.add(e);
	}

	@Override
	public void add(int index, T element) {
		backgroundMemoryList.add(index, element);
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		return backgroundMemoryList.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		return backgroundMemoryList.addAll(index, c);
	}

	@Override
	public void clear() {
		backgroundMemoryList.clear();
	}

	@Override
	public boolean contains(Object o) {
		return backgroundMemoryList.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return backgroundMemoryList.containsAll(c);
	}

	@Override
	public T get(int index) {
		return backgroundMemoryList.get(index);
	}

	@Override
	public int indexOf(Object o) {
		return backgroundMemoryList.indexOf(o);
	}

	@Override
	public boolean isEmpty() {
		return backgroundMemoryList.isEmpty();
	}

	@Override
	public Iterator<T> iterator() {
		return backgroundMemoryList.iterator();
	}

	@Override
	public int lastIndexOf(Object o) {
		return backgroundMemoryList.lastIndexOf(o);
	}

	@Override
	public ListIterator<T> listIterator() {
		return backgroundMemoryList.listIterator();
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		return backgroundMemoryList.listIterator(index);
	}

	@Override
	public boolean remove(Object o) {
		return backgroundMemoryList.remove(o);
	}

	@Override
	public T remove(int index) {
		return backgroundMemoryList.remove(index);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return backgroundMemoryList.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return backgroundMemoryList.retainAll(c);
	}

	@Override
	public T set(int index, T element) {
		return backgroundMemoryList.set(index, element);
	}

	@Override
	public int size() {
		return backgroundMemoryList.size();
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		return backgroundMemoryList.subList(fromIndex, toIndex);
	}

	@Override
	public Object[] toArray() {
		return backgroundMemoryList.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return backgroundMemoryList.toArray(a);
	}

	public File getStorageDirectory() {
		return storageDirectory;
	}

	public void setStorageDirectory(File storageDirectory) {
		this.storageDirectory = storageDirectory;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Serializer<T> getSerializer() {
		return serializer;
	}

	public void setSerializer(Serializer<T> serializer) {
		this.serializer = serializer;
	}
}
