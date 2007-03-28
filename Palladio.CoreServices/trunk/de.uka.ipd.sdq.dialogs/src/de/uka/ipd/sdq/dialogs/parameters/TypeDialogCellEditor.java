package de.uka.ipd.sdq.dialogs.parameters;

import java.util.ArrayList;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import de.uka.ipd.sdq.dialogs.datatype.CallDataTypeDialog;
import de.uka.ipd.sdq.dialogs.datatype.DialogRepository;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.Repository;

/**
 * @author admin
 * 
 */
public class TypeDialogCellEditor extends DialogCellEditor {

	/**
	 * The transactional editing domain which is used to get the commands and
	 * alter the model
	 */

	final protected TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain(DialogRepository.EDITING_DOMAIN_ID);

	/*
	 * @See org.eclipse.jface.viewers.DialogCellEditor#DialogCellEditor(org.eclipse.swt.widgets.Control
	 *      parent)
	 */
	public TypeDialogCellEditor(Composite parent) {
		super(parent);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.DialogCellEditor#openDialogBox(org.eclipse.swt.widgets.Control)
	 */
	@Override
	protected Object openDialogBox(Control cellEditorWindow) {

		ArrayList<Object> filterList = new ArrayList<Object>();
		filterList.add(DataType.class);
		filterList.add(Repository.class);
		ArrayList<Object> additionalReferences = new ArrayList<Object>();

		CallDataTypeDialog dialog = new CallDataTypeDialog(cellEditorWindow
				.getShell(), filterList, additionalReferences, editingDomain
				.getResourceSet());

		dialog.open();

		if (!(dialog.getResult() instanceof DataType))
			return null;

		return dialog.getResult();
	}
}
