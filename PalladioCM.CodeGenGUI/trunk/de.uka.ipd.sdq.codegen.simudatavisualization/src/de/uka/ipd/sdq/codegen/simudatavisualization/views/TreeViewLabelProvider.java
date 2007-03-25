package de.uka.ipd.sdq.codegen.simudatavisualization.views;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.codegen.simudatavisualization.SimuImages;
import de.uka.ipd.sdq.sensorfactory.entities.Experiment;
import de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorfactory.entities.Sensor;
import de.uka.ipd.sdq.sensorfactory.entities.impl.ExperimentDAO;

/**
 * The label provider to define how model objects should be presented in the
 * view. Each view can present the same model objects using different labels and
 * icons, if needed. Alternatively, a single label provider can be shared
 * between views in order to ensure that objects of the same type are presented
 * in the same way everywhere.
 * 
 */
public class TreeViewLabelProvider extends LabelProvider {

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
			return ((ExperimentRun) obj).getExperimentDateTime();

		if (obj instanceof Sensor)
			return ((Sensor) obj).getSensorName();

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

		if (obj instanceof TreeContainer)
			return SimuImages.imageRegistry.get(SimuImages.SENSORS);

		if (obj instanceof ExperimentDAO)
			return SimuImages.imageRegistry.get(SimuImages.TREEROOT);

		return PlatformUI.getWorkbench().getSharedImages().getImage(
				ISharedImages.IMG_OBJ_ELEMENT);
	}
}
