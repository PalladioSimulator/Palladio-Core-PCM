/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import de.uka.ipd.sdq.sensorframework.dao.db4o.IDGenerator;
import de.uka.ipd.sdq.sensorframework.dao.file.entities.ExperimentImpl;
import de.uka.ipd.sdq.sensorframework.dao.file.entities.NamedSerializable;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.dao.IExperimentDAO;

/**
 * @author ihssane
 * 
 * Data Access Object (DAO) for persistence of Experiment Objects.
 * 
 */
public class FileExperimentDAO implements IExperimentDAO {

	private HashMap<Long, Experiment> experiments;
	private FileDAOFactory factory;
	private IDGenerator idGen;

	public FileExperimentDAO(IDAOFactory factory, IDGenerator idGen) {
		this.factory = (FileDAOFactory) factory;
		this.idGen = idGen;
		experiments = new HashMap<Long, Experiment>();
		loadExperiments();
	}

	public Experiment addExperiment(String p_experimentname) {
		ExperimentImpl exp = new ExperimentImpl(factory);
		exp.setExperimentID(idGen.getNextExperimentID());
		exp.setExperimentName(p_experimentname);

		experiments.put(exp.getExperimentID(), exp);
		return exp;
	}

	public void loadExperiments() {
		File[] files = factory.getFileManager().listFiles(
				FileDAOFactory.EXP_FILE_NAME_PREFIX);
		for (File file : files) {
			Experiment exp = factory.getFileManager().getExperiment(file);
			experiments.put(exp.getExperimentID(), exp);
		}
	}

	public Collection<Experiment> findByExperimentName(String searchKey) {
		List<Experiment> result = new ArrayList<Experiment>();
		for (Experiment exp : experiments.values())
			if (exp.getExperimentName().equals(searchKey))
				result.add(exp);

		return Collections.unmodifiableCollection(result);
	}

	public Experiment get(long id) {
		return experiments.get(id);
	}

	public Collection<Experiment> getExperiments() {
		return Collections.unmodifiableCollection(experiments.values());
	}

	public void removeExperiment(Experiment experiment, boolean doCascade) {
		experiments.remove(experiment.getExperimentID());
		factory.getFileManager().removeFile((NamedSerializable) experiment);
	}

	public void store(Experiment e) {
		factory.getFileManager().serializeToFile((ExperimentImpl) e);
		for (ExperimentRun er : e.getExperimentRuns())
			factory.createExperimentRunDAO().store(er);
		for (Sensor s : e.getSensors())
			factory.createSensorDAO().store(s);
	}

}
