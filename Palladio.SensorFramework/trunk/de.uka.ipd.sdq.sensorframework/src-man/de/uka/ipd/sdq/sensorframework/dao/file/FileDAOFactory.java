/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file;

import de.uka.ipd.sdq.sensorframework.dao.db4o.IDGenerator;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.dao.IExperimentDAO;
import de.uka.ipd.sdq.sensorframework.entities.dao.IExperimentRunDAO;
import de.uka.ipd.sdq.sensorframework.entities.dao.IMeasurementDAO;
import de.uka.ipd.sdq.sensorframework.entities.dao.ISensorDAO;
import de.uka.ipd.sdq.sensorframework.entities.dao.IStateDAO;

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
    public static final String SENSO_FILE_NAME_PREFIX = "sensor";
    public static final String STATE_FILE_NAME_PREFIX = "state";

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
	idGen = new IDGenerator();
	fileManager = new FileManager(rootDirectory, this);
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
	// nothing to do
    }

    public FileManager getFileManager() {
	return fileManager;
    }

    public String getDescription() {
	return "";
    }

    public long getID() {
	return factoryID;
    }

    public String getName() {
	return "File datasource";
    }

    public String getPersistendInfo() {
	return "";
    }

    public void setID(long i) {
	factoryID = i;
    }

}
