/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.visualisation.views;

import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

/**
 * @author admin
 *
 */
public class TreeObject {
	private final Object object;
	private final IDAOFactory datasource;
	private final Experiment experiment;
	private final ExperimentRun run;
	private final boolean isEmpty;


	/** Experiment Run */
	public TreeObject(Object object, IDAOFactory datasource, Experiment experiment) {
		this.datasource = datasource;
		this.object = object;
		this.experiment = experiment;
		this.run = null;
		this.isEmpty = true;
	}

	/** Sensor*/
	public TreeObject(Sensor sensor, IDAOFactory datasource, Experiment experiment, ExperimentRun run) {
		this.datasource = datasource;
		this.object = sensor;
		this.experiment = experiment;
		this.run = run;
		this.isEmpty=run.getMeasurementsOfSensor(sensor).getMeasurements().isEmpty();
	}

	public Object getObject() {
		return object;
	}

	public Experiment getExperiment() {
		return experiment;
	}

	public ExperimentRun getRun() {
		return run;
	}

	public IDAOFactory getDatasource() {
		return datasource;
	}
	
	//returns true of the sensor contains measurements
	public boolean isEmpty() {
		return isEmpty;
	}
}
