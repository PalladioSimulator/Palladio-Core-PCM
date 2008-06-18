/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import de.uka.ipd.sdq.sensorframework.dao.file.entities.ScalabilityExperimentRunImpl;
import de.uka.ipd.sdq.sensorframework.dao.file.entities.ExperimentRunImpl;
import de.uka.ipd.sdq.sensorframework.dao.file.entities.AbstractSensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.dao.file.entities.SerializableEntity;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.dao.IExperimentRunDAO;

/**
 * @author ihssane, Steffen
 * 
 * Data Access Object (DAO) for persistence of ExperimentRun Objects.
 * 
 */
public class FileExperimentRunDAO extends AbstractFileDAO<ExperimentRun> implements IExperimentRunDAO {

	public FileExperimentRunDAO(FileDAOFactory factory, IDGenerator idGen) {
		super(factory,idGen,FileDAOFactory.EXPRUN_FILE_NAME_PREFIX);
	}

	public ExperimentRun addExperimentRun(String p_experimentdatetime) {
		ExperimentRunImpl expRun = new ExperimentRunImpl(factory);
		expRun.setExperimentRunID(idGen.getNextExperimentRunID());
		expRun.setExperimentDateTime(p_experimentdatetime);
		
		this.putEntity(expRun);

		return expRun;
	}
	
	public ExperimentRun addScalabilityExperimentRun(String p_experimentdatetime) {
		ScalabilityExperimentRunImpl expRun = new ScalabilityExperimentRunImpl(factory);
		expRun.setExperimentRunID(idGen.getNextExperimentRunID());
		expRun.setExperimentDateTime(p_experimentdatetime);
		
		this.putEntity(expRun);

		return expRun;
	}

	public Collection<ExperimentRun> getExperimentRuns() {
		return Collections.unmodifiableCollection(getAllEntities());
	}

	public void removeExperimentRun(ExperimentRun experimentRun,
			boolean doCascade) {
		this.removeEntity(experimentRun, doCascade);
	}
}
