package de.uka.ipd.sdq.sensorframework.visualisation.editor;

import java.util.ArrayList;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import de.uka.ipd.sdq.sensorfactory.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.adapter.AdapterRegistry;
import de.uka.ipd.sdq.sensorframework.visualisation.SimuPlugin;
import de.uka.ipd.sdq.sensorframework.visualisation.dialogs.ActionListSelectionDialog;

/**
 * This Klass offers the methods, which it for validating possible a 
 * Sensor->View makes. Sensor->View - that only Views for sensors should be
 * selectable, which can also represent the sensor
 * 
 * @author roman
 * 
 */
public class SensorValidationToView {

	/**
	 * @return - all view, which can represent the sensor
	 */
	public static Object[] findViews(SensorAndMeasurements sensorAndMeasurements) {

		IConfigurationElement[] elements = getConfigurationElements();

		ArrayList<IConfigurationElement> views = new ArrayList<IConfigurationElement>();

		for (int i = 0; i < elements.length; i++) {
			IConfigurationElement element = elements[i];
			String executableObject = element.getAttribute("acceptsData");
			try {
				Class viewerAcceptsClass = Class.forName(executableObject);
				if (viewerAcceptsClass.isInstance(sensorAndMeasurements) ||
						AdapterRegistry.singleton().canAdapt(sensorAndMeasurements,viewerAcceptsClass)
						|| viewerAcceptsClass.isInstance(sensorAndMeasurements.getSensor()))
					views.add(element);
			} catch (ClassNotFoundException e) {
				// catch exeption for TimeSpanSensor
			}
		}
		return views.toArray();
	}

	public static boolean canViewSensor(
			SensorAndMeasurements sensorAndMeasurements) {

		String activeEditorId = SimuPlugin.getDefault().getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor()
				.getSite().getId();
		Object[] views = findViews(sensorAndMeasurements);

		for (int i = 0; i < views.length; i++) {
			IConfigurationElement viewer = (IConfigurationElement) views[i];
			String editorId = viewer.getAttribute("editorID");
			if (activeEditorId.equals(editorId))
				return true;
		}
		return false;
	}

	/**
	 * @return - actions, which are present in Menu/Visualization
	 */
	public static IConfigurationElement[] getConfigurationElements() {
		IConfigurationElement[] configurationElements = Platform
				.getExtensionRegistry().getConfigurationElementsFor(
						"de.uka.ipd.sdq.sensorframework.visualisation");
		return configurationElements;
	}

	/**
	 * show message use the MessageDialog. DialogTitle is a curent name of
	 * active editor
	 */
	public static void showMessage(Shell shell) {
		String msg = "This View do not support the representation of the selected sensor!";

		String editorName = SimuPlugin.getDefault().getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor()
				.getTitle();

		MessageDialog.openInformation(shell, editorName, msg);
	}
	
	/**
	 * @return - choose Action from ActionListSelectionDialog
	 */
	public static IConfigurationElement getSelectedAction(Shell shell,
			Object[] elements) {
		ActionListSelectionDialog dialog = new ActionListSelectionDialog(shell);

		dialog.setElements(elements);
		dialog.open();
		Object[] results = dialog.getResult();
		if (results != null)
			return (IConfigurationElement) results[0];
		else return null;
	}
}
