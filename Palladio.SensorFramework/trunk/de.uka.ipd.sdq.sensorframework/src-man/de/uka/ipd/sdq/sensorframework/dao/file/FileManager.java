/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import de.uka.ipd.sdq.sensorframework.dao.file.entities.ExperimentImpl;
import de.uka.ipd.sdq.sensorframework.dao.file.entities.AbstractSensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.dao.file.entities.NamedSerializable;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.State;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.sensorframework.storage.lists.BackgroundMemoryList;

/**
 * @author ihssane
 * 
 * This class provides methods to deal with files. Especially to serialize and
 * deserialize an object to a file.
 */
public class FileManager {

	private String rootDirectory;
	private FileDAOFactory factory;
	private ArrayList<BackgroundMemoryList<?>> openLists = new ArrayList<BackgroundMemoryList<?>>();

	public FileManager(String rootDirectory, FileDAOFactory factory) {
		checkPath(rootDirectory);
		this.rootDirectory = rootDirectory;
		this.factory = factory;
	}

	private void checkPath(String path) {
		File f = new File(path);
		if (!f.isDirectory())
			throw new IllegalArgumentException("Error: " + path
					+ " is not a directory!");
	}

	/**
	 * returns an Array of files with extension ".ser", which in the root
	 * directory located and their name contains the given pattern. if the
	 * pattern is an empty string, all files in the root directory are returned.
	 * 
	 */
	public File[] listFiles(final String pattern) {
		File path = new File(rootDirectory);
		return path.listFiles(new FilenameFilter() {

			public boolean accept(File dir, String name) {
				return name.toLowerCase().endsWith(FileDAOFactory.SUFFIX)
						&& name.toLowerCase().contains(pattern);
			}

		});
	}

	public boolean removeFile(String filename) {
		File path = new File(new File(this.rootDirectory), filename
				.endsWith(".ser") ? filename : filename + ".ser");
		return path.delete();
	}

	public boolean removeFile(NamedSerializable ser) {
		File f = new File(new File(rootDirectory), ser.getFileName());
		return f.delete();
	}

	public void serializeToFile(NamedSerializable ser) {
		OutputStream fos = null;
		File path = new File(new File(this.rootDirectory), ser.getFileName()
				+ ".ser");
		try {
			fos = new FileOutputStream(path);
			ObjectOutputStream o = new ObjectOutputStream(fos);
			o.writeObject(ser);
		} catch (IOException e) {
			System.err.println(e);
		} finally {
			try {
				fos.close();
			} catch (Exception e) {
				System.err.println(e);
			}
		}
	}

	public NamedSerializable deserializeFromFile(String fileName) {
		File path = new File(new File(this.rootDirectory), fileName + FileDAOFactory.SUFFIX);
		return deserializeFromFile(path);
	}

	public NamedSerializable deserializeFromFile(File file) {
		InputStream fis = null;
		NamedSerializable result = null;
		if (file.exists()) {
			try {
				fis = new FileInputStream(file);
				ObjectInputStream o = new ObjectInputStream(fis);
				result = (NamedSerializable) o.readObject();
				result.setFactory(this.factory);
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

	// Not needed for Background memory lists
//	public AbstractSensorAndMeasurements loadMeasurementForSensor(long exprunID,
//			long sensorID) {
//		return (AbstractSensorAndMeasurements) deserializeFromFile(FileDAOFactory.EXPRUN_FILE_NAME_PREFIX
//				+ exprunID + "_" + sensorID);
//	}

	public Experiment getExperiment(File file) {
		Experiment exp = (Experiment) deserializeFromFile(file);
		((ExperimentImpl) exp).setFactory(factory);

		return exp;
	}

	public Sensor getSensor(File file) {
		Sensor sensor = (Sensor) deserializeFromFile(file);
		return sensor;
	}

	public State getState(File file) {
		State state = (State) deserializeFromFile(file);
		return state;
	}

	public String getRootDirectory() {
		return rootDirectory;
	}
	
	public void addOpenList(BackgroundMemoryList<?> list) {
		openLists.add(list);
	}
	
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
	
}
