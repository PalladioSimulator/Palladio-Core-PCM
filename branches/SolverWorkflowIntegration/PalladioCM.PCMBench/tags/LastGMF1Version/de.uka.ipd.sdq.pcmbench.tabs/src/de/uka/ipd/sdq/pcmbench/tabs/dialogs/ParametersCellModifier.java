package de.uka.ipd.sdq.pcmbench.tabs.dialogs;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.swt.widgets.TableItem;

import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcmbench.EditingDomainFactory;
import de.uka.ipd.sdq.pcmbench.tabs.table.OperationsTabResources;

/**
 * @author admin
 * 
 */
public class ParametersCellModifier implements ICellModifier {

	private List<String> columnNames;
	private Parameter parameter;

	/**
	 * The transactional editing domain which is used to get the commands and
	 * alter the model
	 */
	final protected TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain(EditingDomainFactory.EDITING_DOMAIN_ID);

	public ParametersCellModifier() {
		this.columnNames = Arrays
				.asList(OperationsTabResources.getAttributeTableColumn());
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
		
		AdapterFactory decoratedFactory = OperationsTabResources.getAttributeDecoratedFactory();
		
		return (new ParametersItemProvider(null,decoratedFactory)).getColumnText(element,
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
		case ParametersDialogResources.ICON_COLUMN_INDEX: // COMPLETED_COLUMN
			break;
		case ParametersDialogResources.CONTEXT_COLUMN_INDEX: // RETURNTYPE_COLUMN
			break;
		case ParametersDialogResources.NAME_COLUMN_INDEX: // SERVICENAME_COLUMN
			String valueString = ((String) value).trim();
			setParameterName(valueString);
			break;
		case ParametersDialogResources.TYPE_COLUMN_INDEX: // OWNEDPARAMETER_COLUMN
			if (value instanceof DataType) {
				DataType valueDataType = (DataType) value;
				setDataType(valueDataType);
			}
			break;
		default:
		}
	}

	/**
	 * TODO
	 * @param type
	 */
	private void setDataType(DataType type) {
		final DataType dataType = type;

		RecordingCommand recCommand = new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				parameter.setDatatype__Parameter(dataType);
			}
		};

		if (!dataType.equals(parameter.getDatatype__Parameter())) {
			recCommand.setDescription("Edit Parameter Property");
			recCommand.setLabel("Set parameter DataType");
			editingDomain.getCommandStack().execute(recCommand);
			reloadParameterViewer();
		}
		
	}
	/*
	 * TODO
	 */
	private void setParameterName(String valueString) {
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
			reloadOperationsViewer();
		}
	}
	
	private void reloadParameterViewer(){
		OperationsTabResources.getParametersViewer().refresh();
	}
	
	private void reloadOperationsViewer(){
		OperationsTabResources.getOperationsViewer().refresh();
	}
}
