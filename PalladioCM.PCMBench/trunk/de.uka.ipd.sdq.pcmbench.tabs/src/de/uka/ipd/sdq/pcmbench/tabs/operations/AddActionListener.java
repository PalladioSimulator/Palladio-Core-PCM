package de.uka.ipd.sdq.pcmbench.tabs.operations;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;
import de.uka.ipd.sdq.pcm.repository.Signature;

public class AddActionListener extends SelectionAdapter {

	private Interface selectedInterface;

	/**
	 * The transactional editing domain which is used to get the commands and alter the model 
	 */
	protected TransactionalEditingDomain editingDomain = null;

	public AddActionListener(Interface selectedInterface) {
		this.selectedInterface = selectedInterface;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetSelected(SelectionEvent e) {
		Assert.isNotNull(selectedInterface);
		editingDomain = TransactionUtil.getEditingDomain(selectedInterface);

		RecordingCommand recCommand = new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				Signature signature = RepositoryFactory.eINSTANCE
						.createSignature();
				signature
						.setServiceName("ServiceName"
								+ (selectedInterface.getSignatures__Interface()
										.size() + 1));
				selectedInterface.getSignatures__Interface().add(signature);
			}
		};

		recCommand.setDescription("Add new signature");
		editingDomain.getCommandStack().execute(recCommand);
	}
}
