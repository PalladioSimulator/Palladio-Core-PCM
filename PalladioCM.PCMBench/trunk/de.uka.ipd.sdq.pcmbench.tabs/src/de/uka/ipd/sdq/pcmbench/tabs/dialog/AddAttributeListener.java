/**
 * 
 */
package de.uka.ipd.sdq.pcmbench.tabs.dialog;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.util.Assert;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcmbench.tabs.table.TabResources;

/**
 * @author admin
 *
 */
public class AddAttributeListener extends SelectionAdapter {
	
	private Signature parentSignature;
	private EList parameters;
	
	/**
	 * The transactional editing domain which is used to get the commands and alter the model 
	 */
	final protected TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
					.getEditingDomain(TabResources.EDITING_DOMAIN_ID);
	
	/**
	 * @param parentSignature
	 */
	public AddAttributeListener(Signature parentSignature) {
		this.parentSignature = parentSignature;
		this.parameters = parentSignature.getParameters__Signature();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetSelected(SelectionEvent e) {
		Assert.isNotNull(parentSignature);
		
		RecordingCommand recCommand = new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				
				Parameter parameter = RepositoryFactory.eINSTANCE.createParameter();
				parameter.setParameterName("null");
				parameters.add(parameter);
			}		
		};
		
		recCommand.setDescription("Add new parameter to the signature");
		editingDomain.getCommandStack().execute(recCommand);
	}

}
