/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.visualisation.views;

import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

/**
 * @author admin
 *
 */
public class TreeObject {
	private Object object = null;
	private IDAOFactory datasource = null;
	private Experiment experiment = null;
	private ExperimentRun run = null;;

	/** Experiment Run */
	public TreeObject(Object object, IDAOFactory datasource, Experiment experiment) {
		this.datasource = datasource;
		this.object = object;
		this.experiment = experiment;
	}

	/** Sensor*/
	public TreeObject(Object object, IDAOFactory datasource, Experiment experiment, ExperimentRun run) {
		this.object = object;
		this.datasource = datasource;
		this.experiment = experiment;
		this.run = run;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public Experiment getExperiment() {
		return experiment;
	}

	public void setExperiment(Experiment experiment) {
		this.experiment = experiment;
	}

	public ExperimentRun getRun() {
		return run;
	}

	public void setRun(ExperimentRun run) {
		this.run = run;
	}

	public IDAOFactory getDatasource() {
		return datasource;
	}

	public void setDatasource(IDAOFactory datasource) {
		this.datasource = datasource;
	}
	
}
