package de.uka.ipd.sdq.pcmbench.tabs.dialogs;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import quicktime.app.spaces.Collection;

import de.uka.ipd.sdq.pcm.repository.CollectionDataType;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.InnerDeclaration;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;
import de.uka.ipd.sdq.pcmbench.EditingDomainFactory;

/**
 * @author roman
 * 
 */
public class AddInnerDataTypeActionListener extends SelectionAdapter {

	/**
	 * The transactional editing domain which is used to get the commands and
	 * alter the model
	 */

	final protected TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain(EditingDomainFactory.EDITING_DOMAIN_ID);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	@Override
	public void widgetSelected(SelectionEvent e) {

		RecordingCommand recCommand = new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				CompositeDataType dataType = RepositoryFactory.eINSTANCE
						.createCompositeDataType();
				
				InnerDeclaration declaration = RepositoryFactory.eINSTANCE
						.createInnerDeclaration();
				
				declaration.setDatatype_InnerDeclaration(dataType);
				
				
			}
		};

		recCommand.setDescription("Add new CompositeDataTYpe");
		editingDomain.getCommandStack().execute(recCommand);
	}

}
