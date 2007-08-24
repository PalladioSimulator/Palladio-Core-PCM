/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import de.uka.ipd.sdq.sensorframework.dao.db4o.IDGenerator;
import de.uka.ipd.sdq.sensorframework.dao.file.entities.ExperimentRunImpl;
import de.uka.ipd.sdq.sensorframework.dao.file.entities.SensorAndMeasurementsImpl;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.dao.IExperimentRunDAO;

/**
 * @author ihssane
 * 
 */
public class FileExperimentRunDAO implements IExperimentRunDAO {

	private FileDAOFactory factory;
	private IDGenerator idGen;

	public FileExperimentRunDAO(FileDAOFactory factory, IDGenerator idGen) {
		this.factory = factory;
		this.idGen = idGen;
	}

	public ExperimentRun addExperimentRun(String p_experimentdatetime) {
		ExperimentRunImpl expRun = new ExperimentRunImpl(factory);
		expRun.setExperimentRunID(idGen.getNextExperimentRunID());
		expRun.setExperimentDateTime(p_experimentdatetime);

		return expRun;
	}

	public ExperimentRun get(long id) {
		ExperimentRun result = null;
		// TODO: Lassen sich die Metadaten hier cleverer anlegen, z.B. in einer HashTable?
		// getExperimentForRunId(id).getRun(id) 
		// beide methoden sind ein lookup in einer hashtable
		for (Experiment exp : factory.createExperimentDAO().getExperiments()) {
			for (ExperimentRun run : exp.getExperimentRuns())
				if (run.getExperimentRunID() == id) {
					result = run;
					break;
				}

		}
		((ExperimentRunImpl) result).setFactory(factory); // TODO: Warum muss hier die Factory gesetzt werden?
		return result;
	}

	// TODO: Werden hier auch alle Runs geladen, oder nur die Metadaten?
	// TODO: Wenn nur die MetaDaten geladen werden, sollte das einmal zu Anfang geschehen. Hier nur zugriff auf eine entsprechende Hashtabelle.
	public Collection<ExperimentRun> getExperimentRuns() {
		List<ExperimentRun> result = new ArrayList<ExperimentRun>();
		for (Experiment exp : factory.createExperimentDAO().getExperiments()) {
			result.addAll(exp.getExperimentRuns());
		}
		// add factory
		for (ExperimentRun exprun : result)
			((ExperimentRunImpl) exprun).setFactory(factory);
		return result;
	}

	public void removeExperimentRun(ExperimentRun experimentRun,
			boolean doCascade) {
		factory.removeFile(experimentRun.getExperimentDateTime()
				+ experimentRun.getExperimentRunID());
	}

	public void store(ExperimentRun er) {
		for (SensorAndMeasurementsImpl sam : ((ExperimentRunImpl) er)
				.getCachedSensorAndMeasurements())
			factory.serializeToFile("ExpRun" + er.getExperimentRunID()
					+ "Measurements" + sam.getSensor().getSensorID(), sam);
	}
}
