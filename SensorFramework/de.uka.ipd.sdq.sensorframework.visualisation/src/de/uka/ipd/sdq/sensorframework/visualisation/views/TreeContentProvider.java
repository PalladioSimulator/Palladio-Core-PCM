package de.uka.ipd.sdq.sensorframework.visualisation.views;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import de.uka.ipd.sdq.sensorframework.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.dao.IExperimentDAO;

/**
 * TODO
 * @author admin
 */
public class TreeContentProvider implements ITreeContentProvider {

	protected static final int EXPERIMENT_RUNS = 0;
	protected static final int SENSORS = 1;

	private List<IDAOFactory> rootEntry;

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 */
	public Object[] getElements(Object parent) {
		rootEntry = new ArrayList<IDAOFactory>();
		rootEntry.addAll(SensorFrameworkDataset.singleton().getDataSources());
		return getChildren(rootEntry);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public Object[] getChildren(Object parent) {

		/** List of root elements (DAO,...) */
		if (parent instanceof ArrayList)
			return ((ArrayList<IDAOFactory>) parent).toArray();

		/** ExperimentDAO */
		if (parent instanceof IDAOFactory){
			IExperimentDAO experimentDAO = ((IDAOFactory)parent).createExperimentDAO();
			return createExperimentAndDAOList((IDAOFactory)parent,experimentDAO.getExperiments()).toArray();
		}
		
		/** Experiment */
		if (parent instanceof ExperimentAndDAO) {
			ExperimentAndDAO experiment = (ExperimentAndDAO) parent;
			Object[] objects = {
					new TreeContainer(experiment.getDatasource(), experiment.getExperiment(), EXPERIMENT_RUNS),
					new TreeContainer(experiment.getDatasource(), experiment.getExperiment(), SENSORS) };
			return objects;
		}

		/** TreeObject - container of Sensor or ExperimentRun */
		if (parent instanceof TreeObject) {
			TreeObject treeObject = (TreeObject) parent;
			if (treeObject.getObject() instanceof ExperimentRun) {
				ExperimentRun run = (ExperimentRun) treeObject.getObject();
				Experiment experiment = treeObject.getExperiment();
				Collection<Sensor> sensors = experiment.getSensors();
				
				TreeObject[] objects = new TreeObject[sensors.size()];
				
				int i = 0;
				for (Sensor sensor : sensors) {
					objects[i++] = 
							new TreeObject(
									sensor, treeObject.getDatasource(), experiment,
									run);
				}
				return objects;

			}
		}

		/** TreeContainer - container a collection of TreeObject */
		if (parent instanceof TreeContainer)
			return ((TreeContainer) parent).getElements().toArray();

		return new Object[0];
	}

	private List<ExperimentAndDAO> createExperimentAndDAOList(
			IDAOFactory dao, Collection<Experiment> experiments){
		ArrayList<ExperimentAndDAO>result = new ArrayList<ExperimentAndDAO>();
		for(Experiment e:experiments)
			result.add(new ExperimentAndDAO(dao,e));
		return result;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 */
	public boolean hasChildren(Object parent) {
		if (parent instanceof TreeObject){
			TreeObject object = (TreeObject) parent;
			if (object.getObject() instanceof Sensor)
				return false;
		}
		
		if (parent instanceof IDAOFactory) {
			IExperimentDAO experimentDAO = ((IDAOFactory)parent).createExperimentDAO();
			return !experimentDAO.getExperiments().isEmpty();
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose() {
		if (rootEntry != null)
			rootEntry.clear();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 */
	public Object getParent(Object child) {
		// TODO Auto-generated method stub
		return null;
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub
	}
}
