/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file;

import java.io.IOException;
import java.util.ArrayList;

import de.uka.ipd.sdq.sensorframework.dao.db4o.IDGenerator;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.dao.IExperimentDAO;
import de.uka.ipd.sdq.sensorframework.entities.dao.IExperimentRunDAO;
import de.uka.ipd.sdq.sensorframework.entities.dao.IMeasurementDAO;
import de.uka.ipd.sdq.sensorframework.entities.dao.ISensorDAO;
import de.uka.ipd.sdq.sensorframework.entities.dao.IStateDAO;
import de.uka.ipd.sdq.sensorframework.storage.lists.BackgroundMemoryList;

/**
 * @author ihssane
 * 
 * A Data Access Object (DAO) is used to abstract and encapsulate all access to
 * the data source. The DAO manages the connection with the data source to
 * obtain and store data. The DAO pattern can be made highly flexible by
 * adopting the Factory Method pattern. This class represents the DAOFactory and
 * provides methods to create DAOs. The used data sources are files.
 * 
 */
public class FileDAOFactory implements IDAOFactory {

	public static final String EXP_FILE_NAME_PREFIX = "experiment";
	public static final String EXPRUN_FILE_NAME_PREFIX = "exprun";
	public static final String SENSOR_FILE_NAME_PREFIX = "sensor";
	public static final String STATE_FILE_NAME_PREFIX = "state";
	public static final String SUFFIX = ".ser";

	private IExperimentDAO experimentDAO;
	private IExperimentRunDAO experimentRunDAO;
	private IMeasurementDAO measurementDAO;
	private ISensorDAO sensorDAO;
	private IStateDAO stateDAO;

	private IDGenerator idGen;
	private FileManager fileManager;
	private long factoryID;
	
	public FileDAOFactory(long id, String rootDirectory) {
		this.factoryID = id;
		fileManager = new FileManager(rootDirectory, this);
		idGen = createIdGenerator();
	}

	public FileDAOFactory(String rootDirectory) {
		this(-1,rootDirectory);
	}
	
	private IDGenerator createIdGenerator() {
		IDGenerator result = (IDGenerator) fileManager.deserializeFromFile(IDGenerator.FILE_NAME);
		if (result == null){
			result = new IDGenerator();
		}
		return result;
	}

	public String getRootDirectory() {
		return fileManager.getRootDirectory();
	}

	public IExperimentDAO createExperimentDAO() {
		if (this.experimentDAO == null)
			this.experimentDAO = new FileExperimentDAO(this, idGen);
		return this.experimentDAO;
	}

	public IExperimentRunDAO createExperimentRunDAO() {
		if (this.experimentRunDAO == null)
			this.experimentRunDAO = new FileExperimentRunDAO(this, idGen);
		return this.experimentRunDAO;
	}

	public IMeasurementDAO createMeasurementDAO() {
		if (this.measurementDAO == null)
			this.measurementDAO = new FileMeasurementDAO(this, idGen);
		return this.measurementDAO;
	}

	public ISensorDAO createSensorDAO() {
		if (this.sensorDAO == null)
			this.sensorDAO = new FileSensorDAO(this, idGen);
		return this.sensorDAO;
	}

	public IStateDAO createStateDAO() {
		if (this.stateDAO == null)
			this.stateDAO = new FileStateDAO(this, idGen);
		return this.stateDAO;
	}

	public void finalizeAndClose() {
		fileManager.closeAllLists();
		fileManager.serializeToFile(idGen);
		
		if (this.experimentDAO != null)
			((FileExperimentDAO)this.experimentDAO).dispose();
		if (this.sensorDAO != null)
			((FileSensorDAO)this.sensorDAO).dispose();
		if (this.stateDAO != null)
			((FileStateDAO)this.stateDAO).dispose();
		if (this.experimentRunDAO != null)
			((FileExperimentRunDAO)this.experimentRunDAO).dispose();
	}

	public FileManager getFileManager() {
		return fileManager;
	}

	public String getDescription() {
		return fileManager.getRootDirectory();
	}

	public long getID() {
		return factoryID;
	}

	public String getName() {
		return "File datasource";
	}

	public String getPersistendInfo() {
		return fileManager.getRootDirectory();
	}

	public void setID(long i) {
		factoryID = i;
	}

	public void reload() {
		String oldFilename = fileManager.getRootDirectory();
		
		/* Reset all DAOs */
		experimentDAO = null;
		experimentRunDAO = null;
		measurementDAO = null;
		sensorDAO = null;
		stateDAO = null;

		// StB: This is not safe for concurrent access, but an inital simple implementation
		fileManager = new FileManager(oldFilename, this);
		idGen = createIdGenerator();
	}
	
}
