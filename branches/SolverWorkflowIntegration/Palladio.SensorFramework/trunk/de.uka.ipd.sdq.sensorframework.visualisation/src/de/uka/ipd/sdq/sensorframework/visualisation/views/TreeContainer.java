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
public class TreeContainer implements IAdaptable {
	
	private Experiment experiment;
	private List<TreeObject> elements = null;
	private String name;
	private int type;
	
	private String EXPERIMENT_RUNS_NAME = "Experiment Runs";
	private String SENSORS_NAME		 = "Sensors";

	/**
	 * REFACTORIN!!
	 * @param experiment
	 */
	public TreeContainer(IDAOFactory datasource, Experiment experiment, int type) {
		this.experiment = experiment;
		this.type = type;
		this.elements = new ArrayList<TreeObject>();

		if (type == TreeContentProvider.EXPERIMENT_RUNS){
			Collection<ExperimentRun> runs = experiment.getExperimentRuns();
			for(ExperimentRun r : runs)
				elements.add(new TreeObject(r,datasource,experiment));

			this.name = EXPERIMENT_RUNS_NAME;
		}
		if (type == TreeContentProvider.SENSORS){
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

	@SuppressWarnings("unchecked")
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

	public int getType() {
		return type;
	}
}
