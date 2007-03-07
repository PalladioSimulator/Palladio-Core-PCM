package de.uka.ipd.sdq.codegen.simudatavisualization.views;

import java.util.ArrayList;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IViewSite;

import de.uka.ipd.sdq.sensorfactory.entities.Experiment;
import de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorfactory.entities.Sensor;
import de.uka.ipd.sdq.sensorfactory.entities.impl.ExperimentDAO;

/**
 * @author admin
 * 
 */
public class TreeViewContentProvider implements IStructuredContentProvider,
		ITreeContentProvider {

	protected static String EXPERIMENT_RUNS = "Experiment Runs";
	protected static String SENSORS 		= "Sensors";

	private TreeRoot invisibleRoot;
	private IViewSite viewSite;

	/**
	 * @param viewSite
	 */
	public TreeViewContentProvider(IViewSite viewSite) {
		this.viewSite = viewSite;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 */
	public Object[] getElements(Object parent) {
		if (parent.equals(viewSite)) {
			if (invisibleRoot == null)
				invisibleRoot = new TreeRoot(ExperimentDAO.singleton());
			return getChildren(invisibleRoot);
		}
		return getChildren(parent);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer,
	 *      java.lang.Object, java.lang.Object)
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 */
	public Object[] getChildren(Object parent) {
		
		if (parent instanceof TreeRoot)
			return ((TreeRoot) parent).getTree().toArray();

		if (parent instanceof ExperimentDAO)
			return ((ExperimentDAO) parent).getExperiments().toArray();

		if (parent instanceof Experiment) {
			Experiment experiment = (Experiment) parent;
			Object[] objects = { new TreeContainer(experiment, EXPERIMENT_RUNS),
					new TreeContainer(experiment, SENSORS) };
			return objects;
		}

		if (parent instanceof TreeContainer)
			return ((TreeContainer) parent).getElements().toArray();

		return new Object[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 */
	public Object getParent(Object child) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 */
	public boolean hasChildren(Object parent) {

		if (parent instanceof Sensor)
			return false;
		
		if (parent instanceof ExperimentRun)
			return false;

		return true;
	}
}

class TreeRoot{
	
	private ArrayList<ExperimentDAO> tree;
	
	
	/**
	 * @return the tree
	 */
	public void removeFromTree(ExperimentDAO experimentDAO) {
		tree.remove(experimentDAO);
	}


	/**
	 * @param tree the tree to set
	 */
	public void addToTree(ExperimentDAO experimentDAO) {
		tree.add(experimentDAO);
	}


	public TreeRoot(ExperimentDAO experimentDAO) {
		this.tree = new ArrayList<ExperimentDAO>();
		tree.add(experimentDAO);
	}


	/**
	 * @return the tree
	 */
	public ArrayList<ExperimentDAO> getTree() {
		return tree;
	}

	
}