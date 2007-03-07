package de.uka.ipd.sdq.codegen.simudatavisualization.views;

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.codegen.simudatavisualization.Activator;
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

	public static final String RUN = "run_obj";
	public static final String SENSOR = "sensor_obj";
	public static final String EXPERIMENT = "experiment_obj";
	public static final String SENSORS = "sensors_category";
	public static final String TREEROOT = "tree_root";

	// For the toolbar images
	public static ImageRegistry imageRegistry = new ImageRegistry();

	/**
	 * Note: An image registry owns all of the image objects registered with it,
	 * and automatically disposes of them the SWT Display is disposed.
	 */

	static {
		String iconPath = "icons/";

		imageRegistry.put(RUN, Activator.getImageDescriptor(iconPath + RUN
				+ ".gif"));
		imageRegistry.put(SENSOR, Activator.getImageDescriptor(iconPath
				+ SENSOR + ".gif"));
		imageRegistry.put(SENSORS, Activator.getImageDescriptor(iconPath
				+ SENSORS + ".gif"));
		imageRegistry.put(EXPERIMENT, Activator.getImageDescriptor(iconPath
				+ EXPERIMENT + ".gif"));
		imageRegistry.put(TREEROOT, Activator.getImageDescriptor(iconPath
				+ TREEROOT + ".gif"));
	}

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

	public Image getImage(Object obj) {
		/*
		 * String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
		 * 
		 * if (obj instanceof Experiment) { imageKey =
		 * ISharedImages.IMG_OBJ_FOLDER; return
		 * PlatformUI.getWorkbench().getSharedImages().getImage( imageKey); }
		 */

		String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
		
		if (obj instanceof Experiment)
			return imageRegistry.get(EXPERIMENT);

		if (obj instanceof ExperimentRun)
			return imageRegistry.get(RUN);

		if (obj instanceof Sensor)
			return imageRegistry.get(SENSOR);
		
		if (obj instanceof TreeContainer)
			return imageRegistry.get(SENSORS);
		
		if (obj instanceof ExperimentDAO)
			return imageRegistry.get(TREEROOT);

		return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
	}

}
