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

import de.uka.ipd.sdq.sensorframework.dao.file.entities.ExperimentImpl;
import de.uka.ipd.sdq.sensorframework.dao.file.entities.SensorAndMeasurementsImpl;
import de.uka.ipd.sdq.sensorframework.dao.file.entities.Serializable;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.State;

/**
 * @author ihssane
 * 
 * This class provides methods to deal with files. Especially to serialize and
 * deserialize an object to a file.
 */
public class FileManager {

    private String rootDirectory;
    private FileDAOFactory factory;

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
		return name.toLowerCase().endsWith(".ser")
			&& name.toLowerCase().contains(pattern);
	    }

	});
    }

    public boolean removeFile(String fileName) {
	File path = new File(new File(this.rootDirectory), fileName + ".ser");
	return path.delete();
    }

    public void serializeToFile(Serializable ser) {
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

    public Object deserializeFromFile(String fileName) {
	File path = new File(new File(this.rootDirectory), fileName + ".ser");
	return deserializeFromFile(path);
    }

    private Object deserializeFromFile(File file) {
	InputStream fis = null;
	Object result = null;
	try {
	    fis = new FileInputStream(file);
	    ObjectInputStream o = new ObjectInputStream(fis);
	    result = o.readObject();
	} catch (IOException e) {
	    System.err.println(e);
	} catch (ClassNotFoundException e) {
	    System.err.println(e);
	} finally {
	    try {
		fis.close();
	    } catch (Exception e) {
		System.err.println(e);
	    }
	}
	return result;
    }

    public SensorAndMeasurementsImpl loadMeasurementForSensor(long exprunID,
	    long sensorID) {
	return (SensorAndMeasurementsImpl) factory.getFileManager()
		.deserializeFromFile(
			FileDAOFactory.EXPRUN_FILE_NAME_PREFIX + exprunID + "_"
				+ sensorID);
    }

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
}
