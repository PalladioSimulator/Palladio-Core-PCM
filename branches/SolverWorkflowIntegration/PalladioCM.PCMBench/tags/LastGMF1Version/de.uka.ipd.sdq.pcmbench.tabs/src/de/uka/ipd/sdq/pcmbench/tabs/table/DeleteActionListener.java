package de.uka.ipd.sdq.pcmbench.tabs.table;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.util.Assert;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcmbench.EditingDomainFactory;


public class DeleteActionListener extends SelectionAdapter {

	private Signature selectedSignature;
	private Interface selectedInterface;
	
	/**
	 * The transactional editing domain which is used to get the commands and alter the model 
	 */
	final protected TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
	.getEditingDomain(EditingDomainFactory.EDITING_DOMAIN_ID);

	/**
	 * singleton design patterns
	 */
	private static DeleteActionListener singleton = null;

	private DeleteActionListener() {
	}
	
	public synchronized static DeleteActionListener getSingelton(){
		if (singleton == null)
			singleton = new DeleteActionListener();  
		return singleton;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetSelected(SelectionEvent e) {
		Assert.isNotNull(selectedSignature);
		Assert.isNotNull(selectedInterface);
		
		RecordingCommand recCommand = new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
					selectedInterface.getSignatures__Interface().remove(selectedSignature);
			}		
		};
		
		recCommand.setDescription("Delete ...");
		editingDomain.getCommandStack().execute(recCommand);
	}

	/**
	 * @param selectedInterface the selectedInterface to set
	 */
	public void setSelectedInterface(Interface selectedInterface) {
		this.selectedInterface = selectedInterface;
	}

	/**
	 * @param selectedSignature the selectedSignature to set
	 */
	public void setSelectedSignature(Signature selectedSignature) {
		this.selectedSignature = selectedSignature;
	}

	/**
	 * @return the selectedInterface
	 */
	public Interface getSelectedInterface() {
		return selectedInterface;
	}
}
