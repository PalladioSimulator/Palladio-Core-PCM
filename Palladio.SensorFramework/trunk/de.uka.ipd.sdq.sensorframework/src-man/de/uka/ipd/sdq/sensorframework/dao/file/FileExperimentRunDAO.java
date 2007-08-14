/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import de.uka.ipd.sdq.sensorframework.dao.file.entities.ExperimentRunImpl;
import de.uka.ipd.sdq.sensorframework.dao.file.entities.SensorAndMeasurementsImpl;
import de.uka.ipd.sdq.sensorframework.dao.db4o.IDGenerator;
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
		// File[] files = factory.listFiles("" + id);
		// ExperimentRun expRun = null;
		// if (files.length == 0)
		// return null;
		// else {
		// for (File file : files)
		// if (factory.deserializeFromFile(file) instanceof ExperimentRun) {
		// expRun = (ExperimentRun) factory.deserializeFromFile(file);
		// break;
		// }
		// }
		ExperimentRun result = null;
		for (Experiment exp : factory.createExperimentDAO().getExperiments()) {
			for (ExperimentRun run : exp.getExperimentRuns())
				if (run.getExperimentRunID() == id) {
					result = run;
					break;
				}

		}
		((ExperimentRunImpl) result).setFactory(factory);
		return result;
	}

	public Collection<ExperimentRun> getExperimentRuns() {
		// List<ExperimentRun> result = new ArrayList<ExperimentRun>();
		// File[] files = factory.listFiles("");
		// for (File file : files)
		// result.add((ExperimentRun) factory.deserializeFromFile(file));
		// return Collections.unmodifiableCollection(result);
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
				.getSensorAndMeasurements())
			factory.serializeToFile("ExpRun" + er.getExperimentRunID()
					+ "Measurements" + sam.getSensor().getSensorID(), sam);
	}

}
