/**
 * 
 */
package de.uka.ipd.sdq.pcmbench.tabs.table;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import de.uka.ipd.sdq.pcm.repository.Signature;

/**
 * @author admin
 *
 */
public class DeleteCellValueListener extends SelectionAdapter {

	private Signature signature;
		
	
	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	@Override
	public void widgetSelected(SelectionEvent e) {
		signature = OperationsTabRepository.getEditedSignature();
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(signature);
		

		RecordingCommand recCommand = new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				signature.setReturntype__Signature(null);
			}		
		};
		
		recCommand.setDescription("Set void return type signature");
		editingDomain.getCommandStack().execute(recCommand);
		refreshViewer();
	}

	private void refreshViewer(){
		OperationsTabRepository.getOperationsViewer().refresh();
	}
}
