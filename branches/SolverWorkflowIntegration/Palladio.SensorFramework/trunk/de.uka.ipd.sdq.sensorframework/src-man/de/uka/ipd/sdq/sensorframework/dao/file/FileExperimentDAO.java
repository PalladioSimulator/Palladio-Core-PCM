/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.dao.file;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import de.uka.ipd.sdq.sensorframework.dao.file.entities.ExperimentImpl;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.dao.IExperimentDAO;

/**
 * @author Ihssane El-Oudghiri 
 * @author Steffen Becker
 * 
 * Data Access Object (DAO) for persistence of Experiment Objects.
 * 
 */
public class FileExperimentDAO extends AbstractFileDAO<Experiment> implements IExperimentDAO {

	public FileExperimentDAO(IDAOFactory factory, IDGenerator idGen) {
		super(factory,idGen,FileDAOFactory.EXP_FILE_NAME_PREFIX);
	}

	public Experiment addExperiment(String p_experimentname) {
		ExperimentImpl exp = new ExperimentImpl(factory);
		exp.setExperimentID(idGen.getNextExperimentID());
		exp.setExperimentName(p_experimentname);

		this.putEntity(exp);
		
		return exp;
	}

	/**{@inheritDoc}*/
	public Collection<Experiment> findByExperimentName(String searchKey) {
		List<Experiment> result = new ArrayList<Experiment>();
		for (Experiment exp : getAllEntities())
			if (exp.getExperimentName().equals(searchKey))
				result.add(exp);

		return Collections.unmodifiableCollection(result);
	}

	public Collection<Experiment> getExperiments() {
		return this.getAllEntities();
	}

	public void removeExperiment(Experiment experiment, boolean doCascade) {
		this.removeEntity(experiment, doCascade);
	}
}
