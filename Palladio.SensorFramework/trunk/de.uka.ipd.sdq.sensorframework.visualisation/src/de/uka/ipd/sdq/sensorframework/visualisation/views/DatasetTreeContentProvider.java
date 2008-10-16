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

/**Provides the tree structure for datasets of the sensor framework.
 * @author admin
 * @author groenda
 */
public class DatasetTreeContentProvider implements ITreeContentProvider {

	/** root element representing the dataset. */
	private SensorFrameworkDataset dataset;

	/**Initializes a new content provider for a given dataset.
	 * @param dataset The initial dataset.
	 */
	public DatasetTreeContentProvider(SensorFrameworkDataset dataset) {
		this.dataset = dataset;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 */
	public Object[] getElements(Object parent) {
		ArrayList<IDAOFactory> rootEntry = new ArrayList<IDAOFactory>();
		rootEntry.addAll(dataset.getDataSources());
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
					new ExperimentTreeContainer(
							experiment.getDatasource(), experiment.getExperiment(), 
							ExperimentTreeContainer.ContentType.EXPERIMENT_RUNS),
					new ExperimentTreeContainer(
							experiment.getDatasource(), experiment.getExperiment(), 
							ExperimentTreeContainer.ContentType.SENSORS) };
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
					objects[i++] = new TreeObject(s, treeObject.getDatasource(), experiment, run);

				return objects;
			}
		}

		/** TreeContainer - container a collection of TreeObject */
		if (parent instanceof ExperimentTreeContainer)
			return ((ExperimentTreeContainer) parent).getElements().toArray();

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
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 */
	public Object getParent(Object child) {
		// parent direction not navigable
		return null;
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub
	}
}
