/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.sensorframework.storage.lists.BackgroundMemoryList;

/**
 * @author Ihssane El-Oudghiri 
 * @author Steffen Becker
 * 
 * This class provides methods to deal with files. Especially to serialize and
 * deserialize an object to a file.
 */
public class FileManager {

	/**
	 * Directory in which this file provider stores its data
	 */
	private String rootDirectory;
	
	/**
	 * The parent DAOFactory which stores its data using this class
	 */
	private FileDAOFactory factory;
	
	/**
	 * A registry of open BackgroundMemoryLists. Used to finally close all open lists on closing this
	 * file provider 
	 */
	private ArrayList<BackgroundMemoryList<?>> openLists = new ArrayList<BackgroundMemoryList<?>>();

	public FileManager(String rootDirectory, FileDAOFactory factory) {
		checkPath(rootDirectory);
		this.rootDirectory = rootDirectory;
		this.factory = factory;
	}

	/** Test whether the given path exists and is a directory
	 * @param path The path to test
	 */
	private void checkPath(String path) {
		File f = new File(path);
		if (!f.isDirectory())
			throw new IllegalArgumentException("Error: " + path
					+ " is not a directory!");
	}

	/** Delete the given file
	 * @param filename Name of the file to delete
	 * @return true if deletion was successful
	 */
	public boolean removeFile(String filename) {
		File path = new File(new File(this.rootDirectory), filename
				.endsWith(".ser") ? filename : filename + ".ser");
		return path.delete();
	}

	/** Write the given serializable into the given file using Java's object serialisation mechanism
	 * @param filename Name of the file in which the data is written
	 * @param ser The object to persist
	 */
	public void serializeToFile(String filename, Serializable ser) {
		OutputStream fos = null;
		File path = new File(new File(this.rootDirectory), filename
				+ FileDAOFactory.SUFFIX);
		try {
			fos = new FileOutputStream(path);
			ObjectOutputStream o = new ObjectOutputStream(fos);
			o.writeObject(ser);
		} catch (IOException e) {
			throw new RuntimeException("Serialisation of DAO failed.", e);
		} finally {
			try {
				fos.close();
			} catch (Exception e) {
				throw new RuntimeException("Serialisation of DAO failed.", e);
			}
		}
	}

	/** Read the object stored in the given file
	 * @param fileName The file from which to read the data
	 * @return The object persisted in the given file
	 */
	public Serializable deserializeFromFile(String fileName) {
		File path = new File(new File(this.rootDirectory), fileName + FileDAOFactory.SUFFIX);
		return deserializeFromFile(path);
	}

	/** Read the object stored in the given file
	 * @param file The file from which to read the data
	 * @return The object persisted in the given file
	 */
	public Serializable deserializeFromFile(File file) {
		Serializable result = null;
		InputStream fis = null;
		if (file.exists()) {
			try {
				fis = new FileInputStream(file);
				ObjectInputStream o = new ObjectInputStream(fis);
				result = (Serializable) o.readObject();
			} catch (IOException e) {
				throw new RuntimeException("Sensorframework File Provider failed loading an entity",e);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Sensorframework File Provider failed loading an entity",e);
			} finally {
				try {
					fis.close();
				} catch (Exception e) {
					throw new RuntimeException("Sensorframework File Provider failed loading an entity",e);
				}
			}
		}
		return result;
	}

	public String getRootDirectory() {
		return rootDirectory;
	}
	
	/** Add a new BackgroundMemoryList to this class's registry of open lists
	 * @param list The list to add to the registry for closing on termination
	 */
	public void addOpenList(BackgroundMemoryList<?> list) {
		openLists.add(list);
	}
	
	/**
	 * Closes all lists registered in this class' registry of open background lists
	 */
	public void closeAllLists() {
		for (BackgroundMemoryList<?> list : openLists) {
			try {
				list.close();
			} catch (IOException e) {
			}
		}
		openLists.clear();
	}

	public IDAOFactory getDAOFactory() {
		return this.factory;
	}
	
	/**
	 * Flushes all open lists so that they use only little memory. 
	 */
	public void flush(){
		for (BackgroundMemoryList<?> list : openLists) {
			try {
				list.flush();
			} catch (IOException e) {
			}
		}
	}
	
}
