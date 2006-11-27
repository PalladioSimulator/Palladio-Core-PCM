package de.uka.ipd.sdq.pcmbench.tabs.dialog;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.swt.widgets.TableItem;

import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcmbench.tabs.table.TabResources;

/**
 * @author admin
 * 
 */
public class AttributeCellModifier implements ICellModifier {

	private List columnNames;

	private Parameter parameter;

	/**
	 * The transactional editing domain which is used to get the commands and
	 * alter the model
	 */
	final protected TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain(TabResources.EDITING_DOMAIN_ID);

	public AttributeCellModifier() {
		this.columnNames = Arrays
				.asList(TabResources.getAttributeTableColumn());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ICellModifier#canModify(java.lang.Object,
	 *      java.lang.String)
	 */
	public boolean canModify(Object element, String property) {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ICellModifier#getValue(java.lang.Object,
	 *      java.lang.String)
	 */
	public Object getValue(Object element, String property) {
		return (new AttributesItemProvider(null)).getColumnText(element,
				columnNames.indexOf(property));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ICellModifier#modify(java.lang.Object,
	 *      java.lang.String, java.lang.Object)
	 */
	public void modify(Object element, String property, Object value) {

		// Find the index of the column
		int columnIndex = columnNames.indexOf(property);

		Assert.isNotNull(element);
		TableItem item = (TableItem) element;
		parameter = (Parameter) item.getData();

		switch (columnIndex) {
		case AttributesViewer.ICON_COLUMN_INDEX: // COMPLETED_COLUMN
			break;
		case AttributesViewer.CONTEXT_COLUMN_INDEX: // RETURNTYPE_COLUMN
			break;
		case AttributesViewer.NAME_COLUMN_INDEX: // SERVICENAME_COLUMN
			String valueString = ((String) value).trim();
			textChanged(valueString);
			break;
		case AttributesViewer.TYPE_COLUMN_INDEX: // OWNEDPARAMETER_COLUMN
			break;
		default:
		}
	}

	private void textChanged(String valueString) {
		final String value = valueString;

		RecordingCommand recCommand = new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				parameter.setParameterName(value);
			}
		};

		if (!value.equals(parameter.getParameterName())) {
			recCommand.setLabel("Set ParameterName");
			editingDomain.getCommandStack().execute(recCommand);
		}
	}

}
