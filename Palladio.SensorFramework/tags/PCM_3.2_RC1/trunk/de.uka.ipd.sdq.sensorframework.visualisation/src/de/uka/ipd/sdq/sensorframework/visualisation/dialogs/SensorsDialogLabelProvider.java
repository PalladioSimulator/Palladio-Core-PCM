/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.visualisation.dialogs;

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
public class SensorsDialogLabelProvider implements ITableLabelProvider {
	
	
	private ConfigEntry entry ;

	/**
	 * @param entry
	 */
	public SensorsDialogLabelProvider(ConfigEntry entry) {
		this.entry = entry;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object, int)
	 */
	public Image getColumnImage(Object element, int columnIndex) {
		return (columnIndex == 0) ?   // COMPLETED_COLUMN?
				getImage(entry.isSensorChecked((Sensor) element)) :
				null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
	 */
	public String getColumnText(Object element, int columnIndex) {
		String result = "";
		
		Sensor sensor = (Sensor) element;

		switch (columnIndex) {
		case SensorsDialog.CHECK_COLUMN_INDEX:
			break;
		case SensorsDialog.SENSOR_ID_INDEX:
			// TODO
			result = "" + sensor.getSensorID();
			break;
		case SensorsDialog.SENSOR_NAME_COLUMN_INDEX:
			result = sensor.getSensorName();
			break;
		default:
			break;
		}
		return result;
	}

	
	/**
	 * Returns the image with the given key, or <code>null</code> if not found.
	 */
	private Image getImage(boolean isSelected) {
		String key = isSelected ? VisualisationImages.CHECKED_IMAGE : VisualisationImages.UNCHECKED_IMAGE;
		return  VisualisationImages.imageRegistry.get(key);
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
