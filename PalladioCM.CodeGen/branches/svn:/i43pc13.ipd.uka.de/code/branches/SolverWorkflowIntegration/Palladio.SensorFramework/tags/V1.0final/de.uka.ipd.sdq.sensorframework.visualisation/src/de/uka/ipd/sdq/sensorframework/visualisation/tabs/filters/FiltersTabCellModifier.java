package de.uka.ipd.sdq.sensorframework.visualisation.tabs.filters;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;

import de.uka.ipd.sdq.sensorframework.filter.IFilteredCollectionFactory;
import de.uka.ipd.sdq.sensorframework.visualisation.VisualisationPlugin;

/**
 * @author Roman Andrej
 */
public class FiltersTabCellModifier implements ICellModifier {

	private FiltersPropertySection section;
	private List<String> columnNames;
	
	public FiltersTabCellModifier(FiltersPropertySection section) {
		this.section = section;
		this.columnNames = Arrays.asList(FiltersPropertySection.columnNames);
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
	
		IFilteredCollectionFactory factory = (IFilteredCollectionFactory) item.getData();

		switch (columnIndex) {
		case FiltersPropertySection.ICON_COLUMN_INDEX: // ICON_COLUMN
			break;
		case FiltersPropertySection.FILTERNAME_COLUMN_INDEX: // FILTERNAME_COLUMN
			break;
		case FiltersPropertySection.PARAMETER_TYPE_COLUMN_INDEX: // PARAMETER_TYPE_COLUMN
			break;
		case FiltersPropertySection.PARAMETER_DESCRIPTION_COLUMN_INDEX: // PARAMETER_DESCRIPTION
			break;
		case FiltersPropertySection.PARAMETER_VALUE_COLUMN_INDEX: // PARAMETER_VALUE_COLUMN
			setFilteringParameter(factory, ((String) value).trim());
			break;
		default:
		}
	}
	
	/**
	 * The method set the new parameter value to the filter.
	 * 
	 * @param selected
	 *            filter
	 * @param new
	 *            parameter value
	 */
	private void setFilteringParameter(IFilteredCollectionFactory factory, String input) {
		try {
			// get properties
			Properties properties = factory.getProperties();
			// get first property description
			String desc = properties.propertyNames().nextElement().toString();
			// set new parameter
			properties.put(desc, factory.convertToType(input));
			// refresh section viewer
			section.refresh();

		} catch (NumberFormatException e) {
			MessageDialog.openInformation(getShell(),
					"Parameter conversion Error ",
					"The entered parameter is not of the type Number!");
		}
	}
	
	/** The method get the active shell. */
	private Shell getShell(){
		return VisualisationPlugin.getDefault()
		.getWorkbench().getActiveWorkbenchWindow().getShell();
	}
}
