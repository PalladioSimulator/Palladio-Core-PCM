/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import de.uka.ipd.sdq.sensorframework.dao.db4o.IDGenerator;
import de.uka.ipd.sdq.sensorframework.dao.file.entities.ExperimentRunImpl;
import de.uka.ipd.sdq.sensorframework.dao.file.entities.SensorAndMeasurementsImpl;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.dao.IExperimentRunDAO;

/**
 * @author ihssane
 * 
 * Data Access Object (DAO) for persistence of ExperimentRun Objects.
 * 
 */
public class FileExperimentRunDAO implements IExperimentRunDAO {

    public static final String FILE_NAME_PREFIX = "exprun";

    private HashMap<Long, ExperimentRun> experimentRuns;
    private FileDAOFactory factory;
    private IDGenerator idGen;

    public FileExperimentRunDAO(FileDAOFactory factory, IDGenerator idGen) {
	this.factory = factory;
	this.idGen = idGen;
	experimentRuns = new HashMap<Long, ExperimentRun>();
    }

    public ExperimentRun addExperimentRun(String p_experimentdatetime) {
	ExperimentRunImpl expRun = new ExperimentRunImpl(factory);
	expRun.setExperimentRunID(idGen.getNextExperimentRunID());
	expRun.setExperimentDateTime(p_experimentdatetime);

	experimentRuns.put(expRun.getExperimentRunID(), expRun);
	return expRun;
    }

    public void loadExperimentRuns() {
	for (Experiment exp : factory.createExperimentDAO().getExperiments()) {
	    for (ExperimentRun run : exp.getExperimentRuns())
		experimentRuns.put(run.getExperimentRunID(), run);
	}
    }

    public ExperimentRun get(long id) {
	return experimentRuns.get(id);
    }

    public Collection<ExperimentRun> getExperimentRuns() {
	return Collections.unmodifiableCollection(experimentRuns.values());
    }

    public void removeExperimentRun(ExperimentRun experimentRun,
	    boolean doCascade) {
	factory.getFileManager().removeFile(
		FILE_NAME_PREFIX + experimentRun.getExperimentRunID());
	// TODO lösche auch bei Experiment !
    }

    public void store(ExperimentRun er) {
	for (SensorAndMeasurementsImpl sam : ((ExperimentRunImpl) er)
		.getCachedSensorAndMeasurements())
	    factory.getFileManager().serializeToFile(sam);
    }
}
