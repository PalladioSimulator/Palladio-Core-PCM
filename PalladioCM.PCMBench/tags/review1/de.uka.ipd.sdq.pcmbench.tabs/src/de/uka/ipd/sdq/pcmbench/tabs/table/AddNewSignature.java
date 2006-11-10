/**
 * 
 */
package de.uka.ipd.sdq.pcmbench.tabs.table;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.repository.impl.RepositoryFactoryImpl;



/**
 * @author admin
 *
 */
public class AddNewSignature implements SelectionListener{

	private Interface inputInterface;
	
	
	public static final String EDITING_DOMAIN_ID = "de.uka.ipd.sdq.PCMBench.editingDomain";

	/**
	 * The transactional editing domain which is used to get the commands and alter the model 
	 */
	final protected TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
					.getEditingDomain(EDITING_DOMAIN_ID);
	
	
	/**
	 * @param inputInterface
	 */
	public AddNewSignature(Interface inputInterface) {
		super();
		this.inputInterface = inputInterface;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetSelected(SelectionEvent e) {
		
		RecordingCommand recCommand = new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				RepositoryFactory repositoryFactory = new RepositoryFactoryImpl();
				Signature signature = repositoryFactory.eINSTANCE.createSignature();
				signature.setServiceName("ServiceName");
				inputInterface.getSignatures__Interface().add(signature);
				
			}
			
		};
		
		recCommand.setDescription("Add new Signaturer");
		recCommand.setLabel("Set ServiceName");
		editingDomain.getCommandStack().execute(recCommand);
	}

	

}
