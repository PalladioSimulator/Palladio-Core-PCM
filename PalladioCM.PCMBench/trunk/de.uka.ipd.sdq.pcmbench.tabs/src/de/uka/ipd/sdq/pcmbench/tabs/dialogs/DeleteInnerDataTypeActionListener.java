package de.uka.ipd.sdq.pcmbench.tabs.dialogs;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.InnerDeclaration;
import de.uka.ipd.sdq.pcmbench.EditingDomainFactory;
import de.uka.ipd.sdq.pcmbench.tabs.table.OperationsTabResources;

/**
 * @author admin
 *
 */
public class DeleteInnerDataTypeActionListener extends SelectionAdapter {
	
	private PalladioCreateDataTypeDialog dialog;
	private InnerDeclaration selectedDeclaration;
	private CompositeDataType parentDataType;
	private EList<InnerDeclaration> declarations;
	
	/**
	 * The transactional editing domain which is used to get the commands and alter the model 
	 */
	final protected TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
	.getEditingDomain(EditingDomainFactory.EDITING_DOMAIN_ID);
	
	/**
	 * TODO
	 * @param dialog
	 */
	public DeleteInnerDataTypeActionListener(PalladioCreateDataTypeDialog dialog) {
		this.dialog = dialog;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetSelected(SelectionEvent e) {

		this.parentDataType = OperationsTabResources.getNewCompositeDataType();
		this.selectedDeclaration = (InnerDeclaration) OperationsTabResources.getSelectedEObject();

		Assert.isNotNull(parentDataType);
		Assert.isNotNull(selectedDeclaration);
		
		declarations = parentDataType.getInnerDeclaration_CompositeDataType();
		
		RecordingCommand recCommand = new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				declarations.remove(selectedDeclaration);
			}		
		};
		
		recCommand.setDescription("Delete ...");
		editingDomain.getCommandStack().execute(recCommand);
		
		// Set enabled OK button in dialog
		dialog.setOKButtonEnabled();

		/**
		 * Call error message of PalladioCreateDataTypeDialog, if declaration list is empty
		 * and disable the OK Button.
		 */
		if (declarations.isEmpty()){
			dialog.callErrorMsgInner();
			dialog.setOKButtonDisabled();
		}
		
	}

}
