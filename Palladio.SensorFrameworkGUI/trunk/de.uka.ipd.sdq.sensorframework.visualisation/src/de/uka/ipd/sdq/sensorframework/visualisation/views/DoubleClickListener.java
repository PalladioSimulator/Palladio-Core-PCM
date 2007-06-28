package de.uka.ipd.sdq.sensorframework.visualisation.views;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;

import de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorfactory.entities.Sensor;
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
	@Override
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

					ConfigEditorInput editorInput = new ConfigEditorInput();

					ConfigEntry configEntry = new ConfigEntry(treeObject
							.getDatasource(), treeObject.getRun(), treeObject
							.getExperiment(), sensor);
					editorInput.addConfigEntry(configEntry);

					/** return all view, which can represent the sensor */
					Object[] viewers = SensorValidationToView.findViews(run
							.getMeasurementsOfSensor(sensor));

					IConfigurationElement action = SensorValidationToView
							.getSelectedAction(event.getViewer().getControl()
									.getShell(), viewers);
					hookDoubleClickAction(editorInput, action.getAttribute("editorID"));

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
