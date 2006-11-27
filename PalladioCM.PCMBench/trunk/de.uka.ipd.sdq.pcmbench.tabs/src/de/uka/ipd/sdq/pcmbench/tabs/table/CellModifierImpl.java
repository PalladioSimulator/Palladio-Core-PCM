package de.uka.ipd.sdq.pcmbench.tabs.table;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.swt.widgets.TableItem;

import de.uka.ipd.sdq.pcm.repository.Signature;

/**
 * @author roman
 * 
 * This class implements an ICellModifier. An ICellModifier is called when the
 * user modifes a cell in the tableViewer
 */

public class CellModifierImpl implements ICellModifier {

	private List columnNames;

	private Signature signature;

	public CellModifierImpl() {
		this.columnNames = Arrays.asList(TabResources
				.getOperationsTableColumn());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ICellModifier#canModify(Object element,
	 *      String property)
	 */
	public boolean canModify(Object element, String property) {
		return true;
	}

	public Object getValue(Object element, String property) {
		return (new OperationsTabItemProvider(null)).getColumnText(element,
				columnNames.indexOf(property));
	}

	public void modify(Object element, String property, Object value) {

		// Find the index of the column
		int columnIndex = columnNames.indexOf(property);
		
		Assert.isNotNull(element);
		TableItem item = (TableItem) element;
		signature = (Signature) item.getData();

		switch (columnIndex) {
		case OperationsTabViewer.ICON_COLUMN_INDEX: // COMPLETED_COLUMN
			break;
		case OperationsTabViewer.RETURNTYPE_COLUMN_INDEX: // RETURNTYPE_COLUMN
			break;
		case OperationsTabViewer.SIGNATURENAME_COLUMN_INDEX: // SERVICENAME_COLUMN
			String valueString = ((String) value).trim();
			textChanged(valueString);
			break;
		case OperationsTabViewer.PARAMETER_COLUMN_INDEX: // OWNEDPARAMETER_COLUMN
			break;
		case OperationsTabViewer.EXCEPTIONS_COLUMN_INDEX: // EXEPTIONTYPE_COLUM
			break;
		default:
		}
	}

	private void textChanged(String valueString) {
		final String value = valueString;

		RecordingCommand recCommand = new RecordingCommand(
				TabResources.editingDomain) {
			@Override
			protected void doExecute() {
				signature.setServiceName(value);
			}
		};

		if (!value.equals(signature.getServiceName())) {
			recCommand.setDescription("Edit Signature Property");
			recCommand.setLabel("Set ServiceName");
			TabResources.editingDomain.getCommandStack().execute(recCommand);
		}
	}
}
