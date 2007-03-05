package de.uka.ipd.sdq.codegen.simudatavisualization.views;

import java.util.Collection;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IViewSite;

import de.uka.ipd.sdq.codegen.simudatavisualization.views.TreeParent;
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

	private TreeParent invisibleRoot;

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
				initialize();
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
		if (parent instanceof TreeParent) {
			return ((TreeParent) parent).getChildren();
		}
		return new Object[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 */
	public Object getParent(Object child) {
		if (child instanceof TreeObject) {
			return ((TreeObject) child).getParent();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 */
	public boolean hasChildren(Object parent) {
		if (parent instanceof TreeParent)
			return ((TreeParent) parent).hasChildren();
		return false;
	}

	/**
	 * We will set initialize tree heararchy. In a real code, you will connect
	 * to a real model and expose its hierarchy.
	 */
	private void initialize() {

		Collection<Experiment> experiments = ExperimentDAO.singleton()
				.getExperiments();

		TreeParent root = new TreeParent("Experiments");

		for (Experiment e : experiments) {
			TreeParent simuconf = new TreeParent(e.getExperimentName());
			root.addChild(simuconf);

			TreeParent sensors = new TreeParent("Sensors");
			
			for (Sensor s :e.getSensors()){
				TreeObject object = new TreeObject(s.getSensorName());
				sensors.addChild(object);
			}
			
			TreeParent runs = new TreeParent("Runs");
			
			for (ExperimentRun r :e.getExperimentRuns()){
				TreeObject object = new TreeObject(r.getExperimentDateTime());
				runs.addChild(object);
			}

			simuconf.addChild(sensors);
			simuconf.addChild(runs);
		}

		invisibleRoot = new TreeParent("");
		invisibleRoot.addChild(root);
	}

}
