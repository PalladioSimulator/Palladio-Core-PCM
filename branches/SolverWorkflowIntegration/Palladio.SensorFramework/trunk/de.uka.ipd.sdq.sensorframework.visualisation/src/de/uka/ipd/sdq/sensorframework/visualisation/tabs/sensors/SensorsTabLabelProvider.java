/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.visualisation.tabs.sensors;

import java.util.Collection;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import de.uka.ipd.sdq.sensorframework.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.visualisation.VisualisationImages;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.ConfigEntry;

/**
 * @author admin
 *
 */
public class SensorsTabLabelProvider implements ITableLabelProvider {
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object, int)
	 */
	public Image getColumnImage(Object element, int columnIndex) {
		if (columnIndex == SensorsPropertySection.ICON_COLUMN_INDEX)
			return VisualisationImages.imageRegistry.get(VisualisationImages.RUN);
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
	 */
	public String getColumnText(Object element, int columnIndex) {
			String result = "";
		
			ConfigEntry entry = (ConfigEntry) element;

			switch (columnIndex) {
			case SensorsPropertySection.ICON_COLUMN_INDEX:
				break;
			case SensorsPropertySection.CONTEXT_COLUMN_INDEX:
				result = entry.getExperimentRun().getClass().getSimpleName();
				break;
			case SensorsPropertySection.RUN_COLUMN_INDEX:
				result = entry.getExperimentRun().getExperimentDateTime();
				break;
			case SensorsPropertySection.SENSORS_COLUMN_INDEX:
				result = setSenssorsArrayToString(entry);
				break;
			default:
				break;
			}
			return result;
	}

	
	private String setSenssorsArrayToString(ConfigEntry entry){
		String result = "";
		Collection<Sensor> sensors=  entry.getSensors();
		
		for(Sensor s: sensors){
			result = result + s.getSensorName() + ", ";
		}
		return deleteComma(result);
	}
	
	/**
	 * Comma of the sentence deletes ends
	 */
	public String deleteComma(String result) {
		if (!result.equals("")) {
			result = result.substring(0, result.length() - 2);
		}
		return result;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 */
	public void dispose() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object, java.lang.String)
	 */
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

}
