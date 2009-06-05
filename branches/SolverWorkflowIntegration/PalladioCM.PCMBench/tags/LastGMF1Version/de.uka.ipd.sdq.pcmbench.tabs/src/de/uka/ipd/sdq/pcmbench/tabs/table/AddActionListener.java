package de.uka.ipd.sdq.pcmbench.tabs.table;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.util.Assert;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcmbench.EditingDomainFactory;


public class AddActionListener extends SelectionAdapter {

	private Interface selectedInterface;
	
	/**
	 * The transactional editing domain which is used to get the commands and alter the model 
	 */
	final protected TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
	.getEditingDomain(EditingDomainFactory.EDITING_DOMAIN_ID);
	
	/**
	 * singleton design patterns
	 */
	private static AddActionListener singleton = null;

	private AddActionListener(){
	}
	
	public synchronized static AddActionListener getSingelton(){
		if (singleton == null)
			singleton = new AddActionListener();  
		return singleton;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetSelected(SelectionEvent e) {
		Assert.isNotNull(selectedInterface);
		
		RecordingCommand recCommand = new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				Signature signature = RepositoryFactory.eINSTANCE.createSignature();
				signature.setServiceName("ServiceName" + (selectedInterface.getSignatures__Interface().size()+ 1));
				selectedInterface.getSignatures__Interface().add(signature);
			}		
		};
		
		recCommand.setDescription("Add new signature");
		editingDomain.getCommandStack().execute(recCommand);
	}

	/**
	 * @param selectedInterface the selectedInterface to set
	 */
	public void setSelectedInterface(Interface selectedInterface) {
		this.selectedInterface = selectedInterface;
	}

}
