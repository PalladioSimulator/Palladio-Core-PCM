/**
 * 
 */
package de.uka.ipd.sdq.sensorfactory.dao.file;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import de.uka.ipd.sdq.sensorfactory.dao.db4o.IDGenerator;
import de.uka.ipd.sdq.sensorfactory.dao.file.entities.ExperimentImpl;
import de.uka.ipd.sdq.sensorfactory.entities.Experiment;
import de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.sensorfactory.entities.dao.IExperimentDAO;

/**
 * @author ihssane
 * 
 */
public class FileExperimentDAO implements IExperimentDAO {

	private FileDAOFactory factory;

	private IDGenerator idGen;

	public FileExperimentDAO(IDAOFactory factory, IDGenerator idGen) {
		this.factory = (FileDAOFactory) factory;
		this.idGen = idGen;
	}

	public Experiment addExperiment(String p_experimentname) {
		ExperimentImpl exp = new ExperimentImpl(factory);
		exp.setExperimentID(idGen.getNextExperimentID());
		exp.setExperimentName(p_experimentname);

		return exp;
	}

	public Collection<Experiment> findByExperimentName(String searchKey) {
		List<Experiment> result = new ArrayList<Experiment>();
		File[] files = factory.listFiles(searchKey);
		for (File file : files)
			result.add((Experiment) factory.deserializeFromFile(file));
		return Collections.unmodifiableCollection(result);
	}

	public Experiment get(long id) {
		File[] files = factory.listFiles("" + id);
		Experiment exp = null;
		if (files.length == 0)
			return null;
		else {
			for (File file : files)
				if (factory.deserializeFromFile(file) instanceof Experiment) {
					exp = (Experiment) factory.deserializeFromFile(file);
					((ExperimentImpl) exp).setFactory(factory);
					break;
				}
		}
		return exp;
	}

	public Collection<Experiment> getExperiments() {
		return findByExperimentName("");
	}

	public void removeExperiment(Experiment experiment, boolean doCascade) {
		factory.removeFile(experiment.getExperimentName()
				+ experiment.getExperimentID());
	}

	public void store(Experiment e) {
		factory.serializeToFile(e.getExperimentName() + e.getExperimentID(), e);
		for (ExperimentRun er : e.getExperimentRuns())
			factory.createExperimentRunDAO().store(er);
	}

}
