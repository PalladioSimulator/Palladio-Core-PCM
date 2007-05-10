package de.uka.ipd.sdq.sensorframework.visualisation.views;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.widgets.TreeItem;

import de.uka.ipd.sdq.sensorfactory.IExperimentDAO;
import de.uka.ipd.sdq.sensorfactory.entities.Experiment;

public class TreeDropListener implements DropTargetListener {

	private TreeViewer view;

	public TreeDropListener(TreeViewer viewer) {
		this.view = viewer;
	}

	public void dragEnter(DropTargetEvent event) {
		// TODO Auto-generated method stub

	}

	public void dragLeave(DropTargetEvent event) {
		// TODO Auto-generated method stub

	}

	public void dragOperationChanged(DropTargetEvent event) {
		// TODO Auto-generated method stub

	}

	public void dragOver(DropTargetEvent event) {
		// TODO Auto-generated method stub

	}

	public void drop(DropTargetEvent event) {
		System.out.println("Drop");
		if (event.item instanceof TreeItem) {
			TreeItem treeItem = (TreeItem) event.item;
			if (treeItem.getData() instanceof IExperimentDAO){
				IExperimentDAO dao = (IExperimentDAO) treeItem.getData();
				IStructuredSelection selection = (IStructuredSelection) view.getSelection();
				Object selectedElement = selection.getFirstElement();
				if (selectedElement instanceof Experiment) {
					Experiment experiment = (Experiment)selectedElement;
					dao.insertExperiment(experiment);
					dao.storeExperiment(experiment);
				}
			}
		}
	}

	public void dropAccept(DropTargetEvent event) {
	}

}
