/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.visualisation.tabs;

import java.util.List;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import de.uka.ipd.sdq.sensorfactory.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.visualisation.SimuImages;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.RunEntry;

/**
 * @author admin
 *
 */
public class SensorsTabLabelProvider implements ITableLabelProvider {
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object, int)
	 */
	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		if (columnIndex == SensorsPropertySection.ICON_COLUMN_INDEX)
			return SimuImages.imageRegistry.get(SimuImages.RUN);
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
	 */
	@Override
	public String getColumnText(Object element, int columnIndex) {
			String result = "";
		
			RunEntry entry = (RunEntry) element;

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

	
	private String setSenssorsArrayToString(RunEntry entry){
		String result = "";
		List<Sensor> sensors= entry.getSensors();
		
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
	@Override
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 */
	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object, java.lang.String)
	 */
	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

}
