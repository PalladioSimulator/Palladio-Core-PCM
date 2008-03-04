/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.visualisation.tabs.filters;

import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;

import de.uka.ipd.sdq.sensorframework.filter.AbstractMeasurementsFilter;
import de.uka.ipd.sdq.sensorframework.filter.FilterParameter;
import de.uka.ipd.sdq.sensorframework.visualisation.VisualisationPlugin;

/**
 * @author Roman Andrej
 */
public class FiltersTabCellModifier implements ICellModifier {

	private List<String> columnNames;
	private AbstractMeasurementsFilter filter;
	
	public FiltersTabCellModifier(String[] columnNames,
			AbstractMeasurementsFilter filter) {
		this.columnNames = Arrays.asList(columnNames);
		this.filter = filter;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ICellModifier#canModify(java.lang.Object, java.lang.String)
	 */
	public boolean canModify(Object element, String property) {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ICellModifier#getValue(java.lang.Object, java.lang.String)
	 */
	public Object getValue(Object element, String property) {
		return (new FiltersTabLabelProvider()).getColumnText(element,
				columnNames.indexOf(property));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ICellModifier#modify(java.lang.Object, java.lang.String, java.lang.Object)
	 */
	public void modify(Object element, String property, Object value) {
		// Find the index of the column
		int columnIndex = columnNames.indexOf(property);

		TableItem item = (TableItem) element;
	
		filter = (AbstractMeasurementsFilter) item.getData();

		switch (columnIndex) {
		case FiltersPropertySection.ICON_COLUMN_INDEX: // ICON_COLUMN
			break;
		case FiltersPropertySection.FILTERNAME_COLUMN_INDEX: // FILTERNAME_COLUMN
			break;
		case FiltersPropertySection.PARAMETER_TYPE_COLUMN_INDEX: // PARAMETER_TYPE_COLUMN
			break;
		case FiltersPropertySection.PARAMETER_VALUE_COLUMN_INDEX: // PARAMETER_VALUE_COLUMN
			setParameter(((String) value).trim());
			break;
		default:
		}
	}
	
	/** The methode set the new parameter to the filter. */
	private void setParameter(String input) {
		Object value = filter.getParameter().getValue();

		try {
			if (value instanceof Double) {
				// parse string to Double
				Double parameterValue = Double.valueOf(input).doubleValue();
				// create new parameter
				FilterParameter<Double> parameter = new FilterParameter<Double>(
						parameterValue, filter.getParameter().getDescription());
				// set parameter
				filter.setParameter(parameter);
			}

			if (value instanceof Long) {
				// parse string to Long
				Long parameterValue = Long.valueOf(input).longValue();
				// create new parameter
				FilterParameter<Long> parameter = new FilterParameter<Long>(
						parameterValue, filter.getParameter().getDescription());
				// set parameter
				filter.setParameter(parameter);
			}
		} catch (NumberFormatException e) {

			MessageDialog.openInformation(getShell(),
					"Parameter conversion Error ",
					"The entered parameter is not of the type "
							+ value.getClass().getSimpleName() + "!");
		}
	}
	
	/** The method get the active shell. */
	private Shell getShell(){
		return VisualisationPlugin.getDefault()
		.getWorkbench().getActiveWorkbenchWindow().getShell();
	}
}
