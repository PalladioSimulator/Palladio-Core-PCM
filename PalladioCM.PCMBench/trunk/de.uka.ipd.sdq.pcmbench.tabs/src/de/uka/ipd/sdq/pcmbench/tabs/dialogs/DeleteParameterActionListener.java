package de.uka.ipd.sdq.pcmbench.tabs.dialogs;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcmbench.EditingDomainFactory;

/**
 * @author roman
 *
 */
public class DeleteParameterActionListener extends SelectionAdapter {

	private Signature parentSignature;
	private Parameter selectedParameter;
	private EList parameters;

	/**
	 * The transactional editing domain which is used to get the commands and alter the model 
	 */
	final protected TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
	.getEditingDomain(EditingDomainFactory.EDITING_DOMAIN_ID);

	/**
	 * singleton design patterns
	 */
	private static DeleteParameterActionListener singleton = null;

	private DeleteParameterActionListener() {
	}
	
	public synchronized static DeleteParameterActionListener getSingelton(){
		if (singleton == null)
			singleton = new DeleteParameterActionListener();  
		return singleton;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetSelected(SelectionEvent e) {
		Assert.isNotNull(parentSignature);
		Assert.isNotNull(selectedParameter);
		
		parameters = parentSignature.getParameters__Signature();
		
		RecordingCommand recCommand = new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				parameters.remove(selectedParameter);
			}		
		};
		
		recCommand.setDescription("Delete ...");
		editingDomain.getCommandStack().execute(recCommand);
	}

	/**
	 * @return the singleton
	 */
	public static DeleteParameterActionListener getSingleton() {
		return singleton;
	}

	/**
	 * @param parentSignature the parentSignature to set
	 */
	public void setParentSignature(Signature parentSignature) {
		this.parentSignature = parentSignature;
	}

	/**
	 * @param selectedParameter the selectedParameter to set
	 */
	public void setSelectedParameter(Parameter selectedParameter) {
		this.selectedParameter = selectedParameter;
	}

}
