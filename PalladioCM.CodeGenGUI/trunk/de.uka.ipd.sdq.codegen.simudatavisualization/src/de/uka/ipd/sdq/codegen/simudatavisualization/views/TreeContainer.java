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
	private Collection elements;
	private String name;

	/**
	 * @param parent
	 */
	public TreeContainer(Experiment parent, String name) {
		this.parent = parent;
		this.name = name;

		if (name.equals(TreeViewContentProvider.EXPERIMENT_RUNS))
			this.elements = parent.getExperimentRuns();
		else if (name.equals(TreeViewContentProvider.SENSORS))
			this.elements = parent.getSensors();
		else
			this.elements = null;
	}

	public Collection getElements() {
		return elements;
	}

	public void setElements(Collection elements) {
		this.elements = elements;
	}

	public Experiment getParent() {
		return parent;
	}

	public void setParent(Experiment parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public Object getAdapter(Class adapter) {
		// TODO Auto-generated method stub
		return null;
	}
}
