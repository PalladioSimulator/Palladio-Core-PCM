package de.uka.ipd.sdq.sensorframework.visualisation.views;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;

import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

/**
 * @author roman
 * 
 * The content provider class is responsible for providing objects to the view.
 * It can wrap existing objects in adapters or simply return objects as-is.
 * These objects may be sensitive to the current input of the view, or ignore it
 * and always show the same content (like Task List, for example).
 */
public class ExperimentTreeContainer implements IAdaptable {
	
	private Experiment experiment;
	private List<TreeObject> elements = null;
	private String name;
	private ContentType type;
	
	public enum ContentType {
		EXPERIMENT_RUNS,
		SENSORS
	}
	
	private String EXPERIMENT_RUNS_NAME = "Experiment Runs";
	private String SENSORS_NAME		 = "Sensors";

	/**
	 * REFACTORIN!!
	 * @param experiment
	 */
	public ExperimentTreeContainer(IDAOFactory datasource, Experiment experiment, ContentType type) {
		this.experiment = experiment;
		this.type = type;
		this.elements = new ArrayList<TreeObject>();

		if (type == ContentType.EXPERIMENT_RUNS){
			Collection<ExperimentRun> runs = experiment.getExperimentRuns();
			for(ExperimentRun r : runs)
				elements.add(new TreeObject(r,datasource,experiment));

			this.name = EXPERIMENT_RUNS_NAME;
		}
		if (type == ContentType.SENSORS){
			Collection<Sensor> sensors = experiment.getSensors();
			for(Sensor s : sensors)
				elements.add(new TreeObject (s,datasource,experiment));
			
			this.name = SENSORS_NAME;
		}
	}

	public List<TreeObject> getElements() {
		return elements;
	}

	public Experiment getParent() {
		return experiment;
	}

	public void setParent(Experiment parent) {
		this.experiment = parent;
	}

	public Object getAdapter(Class adapter) {
//		if (adapter == de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun.class) {
//			this.elements = experiment.getExperimentRuns();
//			this.name = EXPERIMENT_RUNS_NAME;
//			return this;
//		}
//		if (adapter == de.uka.ipd.sdq.sensorfactory.entities.Sensor.class) {
//			this.elements = experiment.getSensors();
//			this.name = SENSORS_NAME;
//			return this;
//		}
		return null;
	}

	public String getName() {
		return name;
	}

	public ContentType getType() {
		return type;
	}
}
