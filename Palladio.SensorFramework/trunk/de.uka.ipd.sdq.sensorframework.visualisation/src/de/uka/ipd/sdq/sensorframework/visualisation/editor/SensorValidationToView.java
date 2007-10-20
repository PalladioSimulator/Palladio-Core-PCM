package de.uka.ipd.sdq.sensorframework.visualisation.editor;

import java.util.ArrayList;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import de.uka.ipd.sdq.sensorframework.adapter.AdapterRegistry;
import de.uka.ipd.sdq.sensorframework.adapter.IAdapterFactory;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.visualisation.SimuPlugin;
import de.uka.ipd.sdq.sensorframework.visualisation.dialogs.ActionListSelectionDialog;
import de.uka.ipd.sdq.sensorframework.visualisation.dialogs.ViewAndAdapterFactory;

/**
 * This class offers the methods, which it for validating possible a 
 * Sensor->View makes. Sensor->View - that only Views for sensors can be
 * selected that can represent this sensor
 * 
 * @author roman
 * 
 */
public class SensorValidationToView {

	/**
	 * @return - all view, which can represent the sensor
	 */
	public static Object[] findViews(SensorAndMeasurements sensorAndMeasurements) {
		ArrayList<ViewAndAdapterFactory> result = new ArrayList<ViewAndAdapterFactory>();
		IConfigurationElement[] elements = getConfigurationElements();

		for (IConfigurationElement element : elements) { // Iterate over all registered views
			String executableObject = element.getAttribute("acceptsData");
			try {
				Class<?> viewerAcceptsClass = Class.forName(executableObject);
				if (AdapterRegistry.singleton().canAdapt(sensorAndMeasurements,viewerAcceptsClass)) {
					// there is at least one adapter which makes the combination work
					for (IAdapterFactory f : AdapterRegistry.singleton().getAllAvailableFactories(sensorAndMeasurements, viewerAcceptsClass)) {
						result.add(new ViewAndAdapterFactory(element,f));
					}
				}
			} catch (ClassNotFoundException e) {
				// catch exception for TimeSpanSensor
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result.toArray();
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
	public static ViewAndAdapterFactory getSelectedAction(Shell shell,
			Object[] elements) {
		ActionListSelectionDialog dialog = new ActionListSelectionDialog(shell);

		dialog.setElements(elements);
		dialog.open();
		Object[] results = dialog.getResult();
		if (results != null)
			return (ViewAndAdapterFactory)results[0];
		else return null;
	}
}
