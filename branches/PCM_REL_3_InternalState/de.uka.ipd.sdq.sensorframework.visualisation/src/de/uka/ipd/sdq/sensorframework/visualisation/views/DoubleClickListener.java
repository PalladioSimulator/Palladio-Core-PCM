package de.uka.ipd.sdq.sensorframework.visualisation.views;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.visualisation.dialogs.ViewAndAdapterFactory;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.ConfigEditorInput;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.ConfigEntry;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.SensorValidationToView;
import de.uka.ipd.sdq.sensorframework.visualisation.menu.DoubleClickAction;

/** @author roman */
public class DoubleClickListener implements IDoubleClickListener {

	private DoubleClickAction doubleClickAction;
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IDoubleClickListener#doubleClick(org.eclipse.jface.viewers.DoubleClickEvent)
	 */
	public void doubleClick(DoubleClickEvent event) {
		if (event.getSelection() instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection) event
					.getSelection();
			Object object = selection.getFirstElement();

			if (object instanceof TreeObject) {

				TreeObject treeObject = (TreeObject) object;
				Object innerObject = treeObject.getObject();
				ExperimentRun run = treeObject.getRun();

				/** Sensor */
				if (innerObject instanceof Sensor && run != null) {
					Sensor sensor = (Sensor) innerObject;
					SensorAndMeasurements sam = run.getMeasurementsOfSensor(sensor);
					
					if (sam.getMeasurements().size() != 0) {
						/** return all view, which can represent the sensor */
						Object[] viewers = SensorValidationToView.findViews(sam);
	
						ViewAndAdapterFactory selecedView = SensorValidationToView.getSelectedAction(event.getViewer().getControl()
								.getShell(), viewers);
						if (selecedView != null) {
							ConfigEditorInput editorInput = new ConfigEditorInput(selecedView.getFactory().getAdapterFactoryID());
							ConfigEntry configEntry = new ConfigEntry(treeObject
									.getDatasource(), treeObject.getRun(), treeObject
									.getExperiment(), sensor);
							editorInput.addConfigEntry(configEntry);
							IConfigurationElement action = selecedView.getView();
							hookDoubleClickAction(editorInput, action.getAttribute("editorID"));
						}
					} else {
						MessageDialog.openWarning(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), 
								"Empty Sensor", 
								"The selected sensor does not contain measurements in the selected Experiment Run." +
								" Refused to open view.");
					}
				}
			}
		}
	}
	
	private void hookDoubleClickAction(ConfigEditorInput editorInput,
			String editorID) {
		doubleClickAction = new DoubleClickAction(editorInput, editorID);
		doubleClickAction.run();
	}
}
