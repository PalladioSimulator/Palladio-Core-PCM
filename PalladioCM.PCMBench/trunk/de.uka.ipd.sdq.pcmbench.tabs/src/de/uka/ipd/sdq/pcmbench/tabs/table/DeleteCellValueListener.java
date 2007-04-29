/**
 * 
 */
package de.uka.ipd.sdq.pcmbench.tabs.table;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcmbench.EditingDomainFactory;

/**
 * @author admin
 *
 */
public class DeleteCellValueListener extends SelectionAdapter {

	private Signature signature;
	
	/**
	 * The transactional editing domain which is used to get the commands and alter the model 
	 */
	final protected TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
	.getEditingDomain(EditingDomainFactory.EDITING_DOMAIN_ID);
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	@Override
	public void widgetSelected(SelectionEvent e) {
		signature = OperationsTabRepository.getEditedSignature();
		

		RecordingCommand recCommand = new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				signature.setReturntype__Signature(null);
			}		
		};
		
		recCommand.setDescription("Set void return type signature");
		editingDomain.getCommandStack().execute(recCommand);
	}

}
