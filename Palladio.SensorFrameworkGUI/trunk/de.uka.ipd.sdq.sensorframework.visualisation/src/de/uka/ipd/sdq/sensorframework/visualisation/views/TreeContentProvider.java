package de.uka.ipd.sdq.sensorframework.visualisation.views;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import de.uka.ipd.sdq.sensorfactory.IExperimentDAO;
import de.uka.ipd.sdq.sensorfactory.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorfactory.entities.Experiment;
import de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorfactory.entities.Sensor;

/**
 * TODO
 * @author admin
 */
public class TreeContentProvider implements ITreeContentProvider {

	protected static final int EXPERIMENT_RUNS = 0;
	protected static final int SENSORS = 1;

	private List<IExperimentDAO> rootEntry;

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 */
	public Object[] getElements(Object parent) {
		if (rootEntry == null) {
			rootEntry = new ArrayList<IExperimentDAO>();
			rootEntry.addAll(SensorFrameworkDataset.singleton().getDataSources());
		}
		return getChildren(rootEntry);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 */
	@Override
	public Object[] getChildren(Object parent) {

		/** List of root elements (DAO,...) */
		if (parent instanceof ArrayList)
			return ((ArrayList<IExperimentDAO>) parent).toArray();

		/** ExperimentDAO */
		if (parent instanceof IExperimentDAO)
			return ((IExperimentDAO) parent).getExperiments().toArray();

		/** Experiment */
		if (parent instanceof Experiment) {
			Experiment experiment = (Experiment) parent;
			Object[] objects = {
					new TreeContainer(experiment, EXPERIMENT_RUNS),
					new TreeContainer(experiment, SENSORS) };
			return objects;
		}

		/** TreeObject - container of Sensor or ExperimentRun */
		if (parent instanceof TreeObject) {
			TreeObject treeObject = (TreeObject) parent;
			if (treeObject.getObject() instanceof ExperimentRun) {
				ExperimentRun run = (ExperimentRun) treeObject.getObject();
				Experiment experiment = treeObject.getExperiment();
				Collection<Sensor> sensors = experiment.getSensors();
				
				Object[] objects = new Object[sensors.size()];
				
				int i = 0;
				for (Sensor s : sensors)
					objects[i++] = new TreeObject(s, experiment, run);

				return objects;
			}
		}

		/** TreeContainer - container a collection of TreeObject */
		if (parent instanceof TreeContainer)
			return ((TreeContainer) parent).getElements().toArray();

		return new Object[0];
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 */
	@Override
	public boolean hasChildren(Object parent) {
		if (parent instanceof TreeObject){
			TreeObject object = (TreeObject) parent;
			if (object.getObject() instanceof Sensor)
				return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	@Override
	public void dispose() {
		if (rootEntry != null)
			rootEntry.clear();
	}

	public static Collection<Sensor> getSensorsToTreeObject(TreeObject object){
		Collection<Sensor> sensors = null;
		Experiment experiment = object.getExperiment();
		return sensors;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 */
	@Override
	public Object getParent(Object child) {
		// TODO Auto-generated method stub
		return null;
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub
	}
}
