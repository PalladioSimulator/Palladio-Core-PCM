/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file;

import org.eclipse.core.runtime.IStatus;

import de.uka.ipd.sdq.sensorframework.SensorFrameworkPluginActivator;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.dao.IExperimentDAO;
import de.uka.ipd.sdq.sensorframework.entities.dao.IExperimentRunDAO;
import de.uka.ipd.sdq.sensorframework.entities.dao.IMeasurementDAO;
import de.uka.ipd.sdq.sensorframework.entities.dao.ISensorDAO;
import de.uka.ipd.sdq.sensorframework.entities.dao.IStateDAO;

/**
 * @author Ihssane El-Oudghiri 
 * 
 * A Data Access Object (DAO) is used to abstract and encapsulate all access to
 * the data source. The DAO manages the connection with the data source to
 * obtain and store data. The DAO pattern can be made highly flexible by
 * adopting the Factory Method pattern. This class represents the DAOFactory and
 * provides methods to create DAOs. The used data sources are files.
 * 
 */
public class FileDAOFactory implements IDAOFactory {

	/**
	 * Constants for the filenames used to store the entities
	 */
	public static final String EXP_FILE_NAME_PREFIX = "experiment";
	public static final String EXPRUN_FILE_NAME_PREFIX = "exprun";
	public static final String SENSOR_FILE_NAME_PREFIX = "sensor";
	public static final String STATE_FILE_NAME_PREFIX = "state";
	public static final String IDGEN_FILE_NAME_PREFIX = "id_generator";
	public static final String SUFFIX = ".ser";

	/**
	 * DAOs for single entity classes
	 */
	private IExperimentDAO experimentDAO;
	private IExperimentRunDAO experimentRunDAO;
	private ISensorDAO sensorDAO;
	private IStateDAO stateDAO;

	private IDGenerator idGen;
	private FileManager fileManager;
	private long factoryID;
	
	/** Constructor for a FileDAOFactory with automatically determined ID
	 * @param rootDirectory The directory in which to store the data
	 */
	public FileDAOFactory(String rootDirectory) {
		this(IDAOFactory.ID_NOT_SET,rootDirectory);
	}
	
	/** Constructor for a FileDAOFactory with given ID. Used by Sensorframework startup code to reinitialise the
	 * SensorframworkDataSet
	 * @param rootDirectory The directory in which to store the data
	 */
	public FileDAOFactory(long id, String rootDirectory) {
		this.factoryID = id;
		fileManager = new FileManager(rootDirectory, this);
		idGen = createIdGenerator();
	}

	/** Create or load the ID generator class
	 * @return ID generator used to generate IDs of the elements
	 */
	private IDGenerator createIdGenerator() {
		IDGenerator result = (IDGenerator) fileManager.deserializeFromFile(FileDAOFactory.IDGEN_FILE_NAME_PREFIX);
		if (result == null){
			result = new IDGenerator();
		}
		return result;
	}

	public String getRootDirectory() {
		return fileManager.getRootDirectory();
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory#createExperimentDAO()
	 */
	public IExperimentDAO createExperimentDAO() {
		if (this.experimentDAO == null)
			this.experimentDAO = new FileExperimentDAO(this, idGen);
		return this.experimentDAO;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory#createExperimentRunDAO()
	 */
	public IExperimentRunDAO createExperimentRunDAO() {
		if (this.experimentRunDAO == null)
			this.experimentRunDAO = new FileExperimentRunDAO(this, idGen);
		return this.experimentRunDAO;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory#createMeasurementDAO()
	 */
	public IMeasurementDAO createMeasurementDAO() {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory#createSensorDAO()
	 */
	public ISensorDAO createSensorDAO() {
		if (this.sensorDAO == null)
			this.sensorDAO = new FileSensorDAO(this, idGen);
		return this.sensorDAO;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory#createStateDAO()
	 */
	public IStateDAO createStateDAO() {
		if (this.stateDAO == null)
			this.stateDAO = new FileStateDAO(this, idGen);
		return this.stateDAO;
	}

	public void finalizeAndClose() {
		fileManager.closeAllLists();
		fileManager.serializeToFile(FileDAOFactory.IDGEN_FILE_NAME_PREFIX,idGen);
		
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
		return "File Datasource";
	}

	public String getPersistendInfo() {
		return fileManager.getRootDirectory();
	}

	public void setID(long i) {
		factoryID = i;
	}

	// This code is only a temporary solution to the reload problem. It
	// can cause problems on concurrent access.
	public void reload() {
		String oldFilename = "";
		boolean failed = false;
		
		try {
			oldFilename = fileManager.getRootDirectory();
			fileManager.closeAllLists();
		}
		catch (Exception ex) {
			SensorFrameworkPluginActivator.log(IStatus.ERROR, "Closing the open File Provider failed", ex);
			failed = true;
		}

		/* Reset all DAOs */
		experimentDAO = null;
		experimentRunDAO = null;
		sensorDAO = null;
		stateDAO = null;

		try {
			// StB: This is not safe for concurrent access, but an initial simple implementation
			fileManager = new FileManager(oldFilename, this);
			idGen = createIdGenerator();
		} catch (Exception ex) {
			SensorFrameworkPluginActivator.log(IStatus.ERROR, "Closing the open File Provider failed", ex);
			failed = true;
		}
		if (failed)
			throw new RuntimeException("Reloading the file provider with ID "+this.getID()+" failed. Consult the Error Log for Details.");
	}

	public void store() {
		fileManager.serializeToFile(FileDAOFactory.IDGEN_FILE_NAME_PREFIX,idGen);
		if (this.experimentDAO != null)
			((FileExperimentDAO)this.experimentDAO).storeAll();
		if (this.sensorDAO != null)
			((FileSensorDAO)this.sensorDAO).storeAll();
		if (this.stateDAO != null)
			((FileStateDAO)this.stateDAO).storeAll();
		if (this.experimentRunDAO != null)
			((FileExperimentRunDAO)this.experimentRunDAO).storeAll();
	}
	
}
