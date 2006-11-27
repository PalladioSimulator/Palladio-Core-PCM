package de.uka.ipd.sdq.pcmbench.tabs.dialog;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.Signature;

/**
 * @author admin
 *
 */
public class DeleteAttributeListener extends SelectionAdapter {

	private Signature parentSignature;
	private Parameter selectedParameter;
	private EList parameters;

	public static final String EDITING_DOMAIN_ID = "de.uka.ipd.sdq.PCMBench.editingDomain";
	
	/**
	 * The transactional editing domain which is used to get the commands and alter the model 
	 */
	final protected static TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
					.getEditingDomain(EDITING_DOMAIN_ID);

	/**
	 * singleton design patterns
	 */
	private static DeleteAttributeListener singleton = null;

	private DeleteAttributeListener() {
	}
	
	public synchronized static DeleteAttributeListener getSingelton(){
		if (singleton == null)
			singleton = new DeleteAttributeListener();  
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
	public static DeleteAttributeListener getSingleton() {
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
