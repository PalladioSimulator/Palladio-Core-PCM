package de.uka.ipd.sdq.sensorframework.visualisation.views;

import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;

import de.uka.ipd.sdq.sensorfactory.entities.Experiment;
import de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorfactory.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.visualisation.SimuPlugin;
import de.uka.ipd.sdq.sensorframework.visualisation.dialogs.ActionListSelectionDialog;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.AbstractReportView;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.ConfigEditorInput;
import de.uka.ipd.sdq.sensorframework.visualisation.menu.OpenAction;
import de.uka.ipd.sdq.sensorframework.visualisation.menu.VisualisationMenuItemContributions;

/**
 * @author admin
 */
public class TreeDragSourceListener implements DragSourceListener {

	TreeViewer viewer;
	
	public TreeDragSourceListener(TreeViewer viewer) {
		this.viewer = viewer;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.swt.dnd.DragSourceListener#dragSetData(org.eclipse.swt.dnd.DragSourceEvent)
	 */
	public void dragSetData(DragSourceEvent event) {
		IStructuredSelection selection = (IStructuredSelection) viewer
				.getSelection();
		Object object = selection.getFirstElement();
		IWorkbenchPage page = SimuPlugin.getDefault().getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();
		IEditorPart editor = page.getActiveEditor();

		if (object instanceof TreeObject) {
			TreeObject treeObject = (TreeObject) object;
			if (editor == null) {
				OpenAction action = getSelectedAction(event.display
						.getActiveShell());
				action.run();

				editor = (AbstractReportView) page.getActiveEditor();
			}

			// create chart and initialisation with Experiment run
			if (treeObject.getObject() instanceof ExperimentRun) {
				ExperimentRun run = (ExperimentRun) treeObject.getObject();
				Experiment experiment = treeObject.getExperiment();
				ConfigEditorInput editorInput = (ConfigEditorInput) editor
						.getEditorInput();
				editorInput.addNewConfigEntry(run, experiment);

			}

			// create chart and initialisation with a sensor
			if (treeObject.getObject() instanceof Sensor) {
				Sensor sensor = (Sensor) treeObject.getObject();
				ConfigEditorInput editorInput = (ConfigEditorInput) editor
						.getEditorInput();
				editorInput.editeConfigEntry(treeObject.getRun(), treeObject
						.getExperiment(), sensor);
			}
		}
	}

	/**
	 * @return - choise Action from ActionListSelectionDialog
	 */
	private OpenAction getSelectedAction(Shell shell) {
		
		ActionListSelectionDialog dialog = new ActionListSelectionDialog(shell);
		dialog.setElements(getElements());
		dialog.open();
		Object[] results = dialog.getResult();
		return (OpenAction) results[0];
	}
	
	/**
	 * @return - actions, which are present in Menu/Visualization
	 */
	private Object[] getElements() {
		VisualisationMenuItemContributions contribution = new VisualisationMenuItemContributions();
		IContributionItem[] items = contribution.getContributionItems();
		Object[] actions = new Object[items.length];

		for (int i = 0; i < items.length; i++) {
			ActionContributionItem item = (ActionContributionItem) items[i];
			actions[i] = item.getAction();
		}

		return actions;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.swt.dnd.DragSourceListener#dragStart(org.eclipse.swt.dnd.DragSourceEvent)
	 */
	public void dragStart(DragSourceEvent event) {
		IStructuredSelection selection = (IStructuredSelection) viewer
				.getSelection();
		Object object = selection.getFirstElement();

		event.doit = false;

		if (object instanceof TreeObject) {
			event.doit = true;
			// if the sensor is not a child from ExperimentRun
			TreeObject treeObject = (TreeObject) object;
			ExperimentRun run = treeObject.getRun();
			if (treeObject.getObject() instanceof Sensor && run == null)
				event.doit = false;
		}
	}

	public void dragFinished(DragSourceEvent event) {
		// TODO Auto-generated method stub
	}
}
