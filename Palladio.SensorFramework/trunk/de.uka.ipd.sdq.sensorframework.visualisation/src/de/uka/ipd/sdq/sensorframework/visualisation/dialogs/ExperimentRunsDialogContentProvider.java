package de.uka.ipd.sdq.sensorframework.visualisation.dialogs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import de.uka.ipd.sdq.sensorframework.SensorFrameworkDataset;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.dao.IExperimentDAO;
import de.uka.ipd.sdq.sensorframework.visualisation.views.ExperimentAndDAO;
import de.uka.ipd.sdq.sensorframework.visualisation.views.TreeObject;

/** @author roman */
public class ExperimentRunsDialogContentProvider implements ITreeContentProvider {
	
	private List<IDAOFactory> root;

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public Object[] getChildren(Object parent) {
		
		if (parent instanceof ArrayList) 
			return ((ArrayList<IDAOFactory>) parent).toArray();
		
		if (parent instanceof IDAOFactory){
			IExperimentDAO experimentDAO = ((IDAOFactory)parent).createExperimentDAO();
			return createExperimentAndDAOList((IDAOFactory)parent,experimentDAO.getExperiments()).toArray();
		}

		if (parent instanceof ExperimentAndDAO) {
			ExperimentAndDAO experiment = (ExperimentAndDAO) parent;
			Collection<ExperimentRun> runs = experiment.getExperiment().getExperimentRuns();
			Object[] objects = new Object[runs.size()];
			int i = 0;
			for (ExperimentRun r : runs)
				objects[i++] = new TreeObject(r,experiment.getDatasource(), experiment.getExperiment());

			return objects;
		}
			

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
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 */
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 */
	public boolean hasChildren(Object element) {
		if (element instanceof TreeObject){
			TreeObject object = (TreeObject) element;
			if (object.getObject() instanceof ExperimentRun)
				return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 */
	public Object[] getElements(Object inputElement) {
		if (root == null){
			root = new ArrayList<IDAOFactory>();
			root.addAll(SensorFrameworkDataset.singleton().getDataSources());
		}
		return getChildren(root);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub

	}

}
