package de.uka.ipd.sdq.sensorframework.visualisation.views;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;

import de.uka.ipd.sdq.sensorfactory.entities.Experiment;
import de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorfactory.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.visualisation.SimuPlugin;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.AbstractReportView;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.ConfigEditorInput;

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
		AbstractReportView editor = (AbstractReportView) page.getActiveEditor();

		// create chart and initialisation with Experiment run
		if (object instanceof TreeObject) {
			TreeObject treeObject = (TreeObject) object;
			if (treeObject.getObject() instanceof ExperimentRun) {
				ExperimentRun run = (ExperimentRun) treeObject.getObject();
				Experiment experiment = treeObject.getExperiment();
				if (editor == null) {
					// try {
					// TODO: Open Selection PopUp Menu
					// page.openEditor(new ConfigEditorInput(run),
					// ReportView.EDITOR_ID);
					// } catch (PartInitException e) {
					// e.printStackTrace();
					// }
				} else {
					ConfigEditorInput editorInput = (ConfigEditorInput) editor
							.getEditorInput();
					editorInput.addNewConfigEntry(run, experiment);
					editor.setFocus();
				}
			}

			// create chart and initialisation with a sensor
			if (treeObject.getObject() instanceof Sensor) {
				Sensor sensor = (Sensor) treeObject.getObject();
				if (editor == null) {
					// try {
					// TODO: Open Selection PopUp Menu
					// page.openEditor(new ConfigEditorInput(run),
					// ReportView.EDITOR_ID);
					// } catch (PartInitException e) {
					// e.printStackTrace();
					// }
				} else {
					ConfigEditorInput editorInput = (ConfigEditorInput) editor
							.getEditorInput();

					editorInput.editeConfigEntry(treeObject.getRun(),
							treeObject.getExperiment(), sensor);
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.dnd.DragSourceListener#dragStart(org.eclipse.swt.dnd.DragSourceEvent)
	 */
	public void dragStart(DragSourceEvent event) {
		IEditorPart editor = SimuPlugin.getDefault().getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
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
