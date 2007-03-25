package de.uka.ipd.sdq.codegen.simudatavisualization.views;

import java.util.Collection;

import org.eclipse.core.runtime.IAdaptable;

import de.uka.ipd.sdq.sensorfactory.entities.Experiment;

/**
 * TODO
 * The content provider class is responsible for providing objects to the view.
 * It can wrap existing objects in adapters or simply return objects as-is.
 * These objects may be sensitive to the current input of the view, or ignore it
 * and always show the same content (like Task List, for example).
 */
public class TreeContainer implements IAdaptable {
	
	private Experiment parent;
	private Collection<?> elements = null;
	private String name;
	
	private String EXPERIMENT_RUNS_NAME = "Experiment Runs";
	private String SENSORS_NAME		 = "Sensors";

	/**
	 * @param parent
	 */
	public TreeContainer(Experiment parent, int index) {
		this.parent = parent;

		if (index == TreeViewContentProvider.EXPERIMENT_RUNS){
			this.elements = parent.getExperimentRuns();
			this.name = EXPERIMENT_RUNS_NAME;
		}
		if (index == TreeViewContentProvider.SENSORS){
			this.elements = parent.getSensors();
			this.name = SENSORS_NAME;
		}
	}

	public Collection<?> getElements() {
		return elements;
	}

	public void setElements(Collection<?> elements) {
		this.elements = elements;
	}

	public Experiment getParent() {
		return parent;
	}

	public void setParent(Experiment parent) {
		this.parent = parent;
	}

	public Object getAdapter(Class adapter) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName() {
		return name;
	}
}
