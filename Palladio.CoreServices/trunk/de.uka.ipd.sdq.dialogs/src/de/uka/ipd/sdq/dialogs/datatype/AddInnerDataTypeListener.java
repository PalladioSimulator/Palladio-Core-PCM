package de.uka.ipd.sdq.dialogs.datatype;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.InnerDeclaration;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;

/**
 * @author roman
 * 
 */
public class AddInnerDataTypeListener extends SelectionAdapter {

	private CompositeDataType compositeDataType;
	private PalladioDataTypeDialog dialog;
	
	/**
	 * The transactional editing domain which is used to get the commands and
	 * alter the model
	 */
	final protected TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain(DialogRepository.EDITING_DOMAIN_ID);

	/**
	 * @param compositeDataType
	 */
	public AddInnerDataTypeListener(PalladioDataTypeDialog dialog) {
		this.dialog = dialog;
		
		if (dialog.getEditedDataType() instanceof CompositeDataType)
			compositeDataType = (CompositeDataType) dialog
					.getEditedDataType();
	}

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

				if (compositeDataType == null)
					// nur for own instance of the compositeDataType
					compositeDataType = RepositoryFactory.eINSTANCE
							.createCompositeDataType();
				InnerDeclaration declaration = RepositoryFactory.eINSTANCE
						.createInnerDeclaration();
				// Build the name with count
				String declaratonName = "DeclarationName"
						+ (compositeDataType
								.getInnerDeclaration_CompositeDataType().size() + 1);

				declaration.setEntityName(declaratonName);

				compositeDataType.getInnerDeclaration_CompositeDataType().add(
						declaration);
			}
		};

		recCommand.setDescription("Add new CompositeDataTYpe");
		editingDomain.getCommandStack().execute(recCommand);

		/*
		 * TODO
		 */
		// Set input for TableViewer
		DialogRepository.getParametersViewer().setInput(compositeDataType);
		DialogRepository.setNewCompositeDataType(compositeDataType);

		// Set enabled OK button in dialog
		dialog.setOKButtonEnabled();
		dialog.setErrorMessage(null);
	}
}
