/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.visualisation.dialogs;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.ConfigEntry;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.SensorValidationToView;

/** @author roman */
public class SensorsDialogContentProvider implements IStructuredContentProvider {

	Collection<Sensor> sensors;
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 */
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof ConfigEntry)
			return sensorsValidation((ConfigEntry) inputElement);
		return null;
	}
	
	/**
	 * This function get a sensors list, which can be indicated by
	 * current View.
	 */
	private Object[] sensorsValidation(ConfigEntry entry) {
		ExperimentRun run = entry.getExperimentRun();
		Collection<Sensor> sensors = entry.getExperiment().getSensors();
		ArrayList<Sensor> validSensors = new ArrayList<Sensor>();

		for (Sensor sensor : sensors) {
			if (SensorValidationToView.canViewSensor(run
					.getMeasurementsOfSensor(sensor)))
				validSensors.add(sensor);
		}

		return validSensors.toArray();
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
