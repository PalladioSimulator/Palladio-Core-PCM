/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.visualisation.tabs.filters;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import de.uka.ipd.sdq.sensorframework.filter.AbstractMeasurementsFilter;


/**
 * @author Roman Andrej
 */
public class FiltersTabLabelProvider implements ITableLabelProvider {

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object, int)
	 */
	public Image getColumnImage(Object element, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
	 */
	public String getColumnText(Object element, int columnIndex) {
		String result = "";

		AbstractMeasurementsFilter entry = (AbstractMeasurementsFilter) element;

		switch (columnIndex) {
		case FiltersPropertySection.ICON_COLUMN_INDEX:
			break;
		case FiltersPropertySection.FILTERNAME_COLUMN_INDEX:
			result = entry.getClass().getSimpleName();
			break;
		case FiltersPropertySection.PARAMETER_TYPE_COLUMN_INDEX:
			result = entry.getParameter().getValue().getClass().getSimpleName();
			break;
		case FiltersPropertySection.PARAMETER_VALUE_COLUMN_INDEX:
			result = String.valueOf(entry.getParameter().getValue());
			break;
		default:
			break;
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	public void addListener(ILabelProviderListener listener) {
		// The implementation is not necessary.
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 */
	public void dispose() {
		// The implementation is not necessary.
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object, java.lang.String)
	 */
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	public void removeListener(ILabelProviderListener listener) {
		// The implementation is not necessary.
	}
}
