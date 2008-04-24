/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.visualisation.tabs.filters;

import java.util.Properties;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import de.uka.ipd.sdq.sensorframework.filter.IFilteredCollectionFactory;


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

		IFilteredCollectionFactory entry = (IFilteredCollectionFactory) element;

		switch (columnIndex) {
		case FiltersPropertySection.ICON_COLUMN_INDEX:
			break;
		case FiltersPropertySection.FILTERNAME_COLUMN_INDEX:
			result = entry.getFilterFactoryID();
			break;
		case FiltersPropertySection.PARAMETER_TYPE_COLUMN_INDEX:
			result = getType(entry.getProperties());
			break;
		case FiltersPropertySection.PARAMETER_DESCRIPTION_COLUMN_INDEX:
			result = getDescription(entry.getProperties());
			break;
		case FiltersPropertySection.PARAMETER_VALUE_COLUMN_INDEX:
			result = getValue(entry.getProperties());
			break;
		default:
			break;
		}
		return result;
	}
	
	private String getDescription(Properties properties){
		return properties.propertyNames().nextElement().toString();
	}
	
	private String getType(Properties properties){
		return properties.get(getDescription(properties)).getClass().getSimpleName();
	}
	
	private String getValue(Properties properties){
		return properties.get(getDescription(properties)).toString();
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
