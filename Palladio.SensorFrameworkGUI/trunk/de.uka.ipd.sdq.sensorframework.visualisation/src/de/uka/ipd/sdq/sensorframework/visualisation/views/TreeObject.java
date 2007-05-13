/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.visualisation.views;

import de.uka.ipd.sdq.sensorfactory.entities.Experiment;
import de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun;

/**
 * @author admin
 *
 */
public class TreeObject {
	private Object object = null;
	private Experiment experiment = null;
	private ExperimentRun run = null;;

	public TreeObject(Object object, Experiment experiment) {
		this.object = object;
		this.experiment = experiment;
	}

	public TreeObject(Object object, Experiment experiment, ExperimentRun run) {
		this.object = object;
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
	
}
