package de.uka.ipd.sdq.pcmbench.tabs.dialogs;

import java.util.ArrayList;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcmbench.EditingDomainFactory;

/**
 * @author admin
 * 
 */
public class ReturnTypeDialogCellEditor extends DialogCellEditor {

	/**
	 * The transactional editing domain which is used to get the commands and
	 * alter the model
	 */

	final protected TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain(EditingDomainFactory.EDITING_DOMAIN_ID);

	/*
	 * @See org.eclipse.jface.viewers.DialogCellEditor#DialogCellEditor(org.eclipse.swt.widgets.Control
	 *      parent)
	 */
	public ReturnTypeDialogCellEditor(Composite parent) {
		super(parent);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.DialogCellEditor#openDialogBox(org.eclipse.swt.widgets.Control)
	 */
	@Override
	protected Object openDialogBox(Control cellEditorWindow) {
		
		
		ArrayList filterList = new ArrayList();
		filterList.add(DataType.class);
		filterList.add(Repository.class);
		ArrayList additionalReferences = new ArrayList();

		ReturnTypeDialog dialog = new ReturnTypeDialog(
				cellEditorWindow.getShell(),
				filterList,
				additionalReferences,
				editingDomain.getResourceSet());
		dialog.open();

		if (!(dialog.getResult() instanceof DataType))
			return null;
		
		return dialog.getResult();
	}
}
