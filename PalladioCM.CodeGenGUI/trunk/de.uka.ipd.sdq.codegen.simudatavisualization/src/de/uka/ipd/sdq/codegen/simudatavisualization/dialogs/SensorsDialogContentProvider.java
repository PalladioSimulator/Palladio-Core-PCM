/**
 * 
 */
package de.uka.ipd.sdq.codegen.simudatavisualization.dialogs;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

import de.uka.ipd.sdq.sensorfactory.entities.Experiment;
import de.uka.ipd.sdq.sensorfactory.entities.Sensor;
import de.uka.ipd.sdq.sensorfactory.entities.impl.ExperimentDAO;

/**
 * @author admin
 *
 */
public class SensorsDialogContentProvider implements IStructuredContentProvider {

	Collection<Experiment> experiments;
	Collection<Sensor> sensors;
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 */
	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof ExperimentDAO) {
			ExperimentDAO dao = (ExperimentDAO) inputElement;
			experiments = dao.getExperiments();
			sensors = new ArrayList<Sensor>();
			for (Experiment e : experiments){
				sensors.addAll(e.getSensors());
			}
			return sensors.toArray();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub

	}

}
