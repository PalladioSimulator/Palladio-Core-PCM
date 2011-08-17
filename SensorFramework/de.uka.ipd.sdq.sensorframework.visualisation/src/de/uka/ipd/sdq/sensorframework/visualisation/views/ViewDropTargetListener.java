package de.uka.ipd.sdq.sensorframework.visualisation.views;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.views.navigator.LocalSelectionTransfer;

import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.ConfigEditorInput;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.ConfigEntry;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.SensorValidationToView;

/** @author admin */
public class ViewDropTargetListener extends DropTargetAdapter {

	private ConfigEditorInput configEditorInput;

	public ViewDropTargetListener(IEditorInput editorInput) {
		this.configEditorInput = (ConfigEditorInput)editorInput;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.dnd.DropTargetListener#dragEnter(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	@Override
	public void dragEnter(DropTargetEvent event) {
		if (event.detail == DND.DROP_DEFAULT) 
		{
			 if ((event.operations & DND.DROP_COPY) != 0)
			 	event.detail = DND.DROP_COPY;
			 else 
			 	event.detail = DND.DROP_NONE; 
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.swt.dnd.DropTargetListener#dragLeave(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	@Override
	public void dragLeave(DropTargetEvent event) {
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.dnd.DropTargetListener#dragOperationChanged(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	@Override
	public void dragOperationChanged(DropTargetEvent event) {
		if (event.detail == DND.DROP_DEFAULT) 
		{
			 if ((event.operations & DND.DROP_COPY) != 0)
			 	event.detail = DND.DROP_COPY;
			 else 
			 	event.detail = DND.DROP_NONE; 
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.dnd.DropTargetListener#drop(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	@Override
	public void drop(DropTargetEvent event) {
		IStructuredSelection selection = (IStructuredSelection) LocalSelectionTransfer
				.getTransfer().getSelection();
		Object object = selection.getFirstElement();
		if (object instanceof TreeObject) {
			TreeObject treeObject = (TreeObject) object;
			Object innerObject = treeObject.getObject();
			/** Drop a sensor */
			if (innerObject instanceof Sensor) {
				Sensor sensor = (Sensor) innerObject;
				ExperimentRun run = treeObject.getRun();
				Experiment experiment = treeObject.getExperiment();
				SensorAndMeasurements sam = run.getMeasurementsOfSensor(sensor);
				if (sam.getMeasurements().size() > 0){
					/**
					 * sensor validation - if view do support the representation of
					 * the selected sensor
					 */
					if (SensorValidationToView.canViewSensor(sam)) {
						configEditorInput.editConfigEntry(treeObject.getDatasource(), run, experiment, sensor, null);
					} else {
						SensorValidationToView.showMessage(event.display
								.getActiveShell());
					}
				} else {
					MessageDialog.openWarning(event.display.getActiveShell(), 
							"Empty Sensor", 
							"The dropped sensor does not contain measurements in the selected Experiment Run." +
							" Refused to add sensor to view.");
				}
			}
			/** Drop a experiment run */
			if (innerObject instanceof ExperimentRun) {
				ExperimentRun run = (ExperimentRun) innerObject;
				if (configEditorInput.getConfigEntryToRun(run) == null) {
					ConfigEntry configEntry = new ConfigEntry(treeObject.getDatasource(),
							run, treeObject
							.getExperiment(), null);
					configEditorInput.addConfigEntry(configEntry);
				}
			}
		}
	}

	
	/* (non-Javadoc)
	 * @see org.eclipse.swt.dnd.DropTargetListener#dropAccept(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	@Override
	public void dropAccept(DropTargetEvent event) {
		// TODO Auto-generated method stub
	}
}
