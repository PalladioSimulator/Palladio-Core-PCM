package de.uka.ipd.sdq.sensorframework.visualisation.views;

import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.ui.part.EditorInputTransfer;

import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.visualisation.dialogs.ViewAndAdapterFactory;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.ConfigEditorInput;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.ConfigEntry;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.SensorValidationToView;

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
		Object[] viewers = null;

		if (EditorInputTransfer.getInstance().isSupportedType(event.dataType)) {
			TreeObject treeObject = (TreeObject) object;
			Object innerObject = treeObject.getObject();

			/** Sensor */
			if (innerObject instanceof Sensor) {
				Sensor sensor = (Sensor) innerObject;
				/** return all view, which can represent the sensor */
				viewers = SensorValidationToView.findViews(treeObject.getRun()
						.getMeasurementsOfSensor(sensor));
			}
			/** Experiment Run */
			if (innerObject instanceof ExperimentRun) {
				/** return all view */
				viewers = SensorValidationToView.getConfigurationElements();
			}

			ViewAndAdapterFactory selectedView = SensorValidationToView.getSelectedAction(event.display
					.getActiveShell(), viewers);
			if (selectedView != null) {

				ConfigEditorInput editorInput = new ConfigEditorInput(selectedView.getFactory().getAdapterFactoryID());
				/** Sensor */
				if (innerObject instanceof Sensor) {
					Sensor sensor = (Sensor) innerObject;
					ConfigEntry configEntry = new ConfigEntry(
							treeObject.getDatasource(),
							treeObject.getRun(),
							treeObject.getExperiment(), sensor);
					editorInput.addConfigEntry(configEntry);
				}
				/** Experiment Run */
				if (innerObject instanceof ExperimentRun) {
					ExperimentRun run = (ExperimentRun) innerObject;
					ConfigEntry configEntry = new ConfigEntry(treeObject.getDatasource(),
							run, treeObject
							.getExperiment(), null);
					editorInput.addConfigEntry(configEntry);
				}
				EditorInputTransfer.EditorInputData[] transferArray = new EditorInputTransfer.EditorInputData[] { EditorInputTransfer
						.createEditorInputData(selectedView.getView().getAttribute("editorID"),
								editorInput) };
				event.data = transferArray;
			} else {
				event.data = null;
				event.doit = false;
			}
		} else if (LocalSelectionTransfer.getTransfer().isSupportedType(
				event.dataType)) {
			LocalSelectionTransfer.getTransfer().setSelection(selection);
		}
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
	}
}
