package de.uka.ipd.sdq.sensorfactory.dao.memory;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

import de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorfactory.entities.Measurement;
import de.uka.ipd.sdq.sensorfactory.entities.Sensor;
import de.uka.ipd.sdq.sensorfactory.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.sensorfactory.entities.dao.IExperimentRunDAO;
import de.uka.ipd.sdq.sensorfactory.entities.impl.ExperimentRunImpl;

public class MemoryExperimentRunDAO implements IExperimentRunDAO {

	private long nextID = 0;
	private IDAOFactory myFactory;
	private HashMap<Long,ExperimentRun> index = new HashMap<Long, ExperimentRun>();
	
	public MemoryExperimentRunDAO(IDAOFactory memoryDAOFactory) {
		this.myFactory = memoryDAOFactory;
	}

	public synchronized ExperimentRun addExperimentRun(String p_experimentdatetime) {
		ExperimentRun result = new ExperimentRunImpl(this.myFactory);
		result.setExperimentRunID(nextID++);
		result.setExperimentDateTime(new Date().toString());
		
		index.put(result.getExperimentRunID(),result);
		return result;
	}

	public synchronized ExperimentRun get(long id) {
		return index.get(id);
	}

	public synchronized Collection<ExperimentRun> getExperimentRuns() {
		return Collections.unmodifiableCollection(index.values());
	}

	public void store(ExperimentRun er) {
	}

	public synchronized void removeExperimentRun(ExperimentRun experimentRun,
			boolean doCascade) {
		if (experimentRun == null) {
			return;
		}
		
		if ( doCascade == true ) {
			//remove all measurements
			for (Measurement measurement:experimentRun.getMeasurements()) {
				myFactory.createMeasurementDAO().removeMeasurement(measurement, true);
			}
		}
		index.remove(experimentRun.getExperimentRunID());		
	}

}
