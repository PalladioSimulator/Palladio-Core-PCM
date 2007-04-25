package de.uka.ipd.sdq.sensorframework.visualisation.views;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.sensorfactory.entities.Experiment;
import de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorfactory.entities.Sensor;
import de.uka.ipd.sdq.sensorfactory.entities.impl.ExperimentDAO;
import de.uka.ipd.sdq.sensorframework.visualisation.SimuImages;

/**
 * The label provider to define how model objects should be presented in the
 * view. Each view can present the same model objects using different labels and
 * icons, if needed. Alternatively, a single label provider can be shared
 * between views in order to ensure that objects of the same type are presented
 * in the same way everywhere.
 * 
 */
public class TreeLabelProvider extends LabelProvider {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object obj) {
		if (obj instanceof Experiment)
			return ((Experiment) obj).getExperimentName();

		if (obj instanceof ExperimentRun)
			return runRepresentation((ExperimentRun) obj);

		if (obj instanceof Sensor)
			return sensorRepresentation((Sensor) obj);

		if (obj instanceof TreeContainer)
			return ((TreeContainer) obj).getName();
		if (obj instanceof ExperimentDAO)
			return "DB NAME";

		return obj.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.LabelProvider#getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(Object obj) {

		if (obj instanceof Experiment)
			return SimuImages.imageRegistry.get(SimuImages.EXPERIMENT);

		if (obj instanceof ExperimentRun)
			return SimuImages.imageRegistry.get(SimuImages.RUN);

		if (obj instanceof Sensor)
			return SimuImages.imageRegistry.get(SimuImages.SENSOR);

		if (obj instanceof TreeContainer){
			String icon = "";
			TreeContainer container = (TreeContainer) obj;
			switch (container.getType()) {
			case TreeContentProvider.EXPERIMENT_RUNS:
				icon = SimuImages.RUNS;
				break;
			case TreeContentProvider.SENSORS:
				icon = SimuImages.SENSORS;
				break;
			}
			return SimuImages.imageRegistry.get(icon);
		}

		if (obj instanceof ExperimentDAO)
			return SimuImages.imageRegistry.get(SimuImages.TREEROOT);

		return PlatformUI.getWorkbench().getSharedImages().getImage(
				ISharedImages.IMG_OBJ_ELEMENT);
	}

	public String sensorRepresentation(Sensor sensor) {
		return sensor.getSensorName() + " [ID:" + sensor.getSensorID() + "]";
	}
	
	public String runRepresentation(ExperimentRun run) {
		return run.getExperimentDateTime() + " [ID:" + run.getExperimentRunID() + "]";
	}
}
