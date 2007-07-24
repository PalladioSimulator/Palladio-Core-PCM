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
import de.uka.ipd.sdq.sensorfactory.dao.file.entities.ExperimentRunImpl;
import de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorfactory.entities.dao.IExperimentRunDAO;

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
		File[] files = factory.listFiles("" + id);
		ExperimentRun expRun = null;
		if (files.length == 0)
			return null;
		else {
			for (File file : files)
				if (factory.deserializeFromFile(file) instanceof ExperimentRun) {
					expRun = (ExperimentRun) factory.deserializeFromFile(file);
					break;
				}
		}
		return expRun;
	}

	public Collection<ExperimentRun> getExperimentRuns() {
		List<ExperimentRun> result = new ArrayList<ExperimentRun>();
		File[] files = factory.listFiles("");
		for (File file : files)
			result.add((ExperimentRun) factory.deserializeFromFile(file));
		return Collections.unmodifiableCollection(result);
	}

	public void removeExperimentRun(ExperimentRun experimentRun,
			boolean doCascade) {
		factory.removeFile(experimentRun.getExperimentDateTime()
				+ experimentRun.getExperimentRunID());
	}

	public void store(ExperimentRun er) {
		factory.serializeToFile(er.getExperimentDateTime()
				+ er.getExperimentRunID(), er);
	}

}
