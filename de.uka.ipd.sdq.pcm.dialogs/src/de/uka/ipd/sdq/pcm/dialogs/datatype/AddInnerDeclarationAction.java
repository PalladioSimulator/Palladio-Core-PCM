package de.uka.ipd.sdq.pcm.dialogs.datatype;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import de.uka.ipd.sdq.pcm.parameter.ParameterFactory;
import de.uka.ipd.sdq.pcm.parameter.Variable;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;

/**
 * The class define an action, which a new InnerDeclaration to the CompositeDateType adds.
 * 
 * @author Roman Andrej
 */
public class AddInnerDeclarationAction extends SelectionAdapter {

	private CompositeDataType compositeDataType;
	private PalladioDataTypeDialog dialog;
	
	/**
	 * The transactional editing domain which is used to get the commands and
	 * alter the model
	 */
	private TransactionalEditingDomain editingDomain = null;

	/**
	 * @param compositeDataType
	 */
	public AddInnerDeclarationAction(PalladioDataTypeDialog dialog, TransactionalEditingDomain editingDomain) {
		this.dialog = dialog;
		this.editingDomain = editingDomain;
		this.compositeDataType = dialog.getCompositeDataType();
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

				if (compositeDataType == null) {
					// nur for own instance of the compositeDataType
					compositeDataType = RepositoryFactory.eINSTANCE
							.createCompositeDataType();
				}
				Variable variable = ParameterFactory.eINSTANCE.createVariable();
				// Build the name with count
				String declarationName = "DeclarationName"
						+ (compositeDataType
								.getMembers__CompositeDataType().size() + 1);

				variable.setEntityName(declarationName);

				compositeDataType.getMembers__CompositeDataType().add(
						variable);
			}
		};

		recCommand.setDescription("Add new CompositeDataTYpe");
		editingDomain.getCommandStack().execute(recCommand);

		/**
		 * set and validate a new CompositeDataType 
		 */
		dialog.setCompositeDataType(compositeDataType);
		dialog.getEditorContents().setViewerInput(compositeDataType);
		dialog.validateInput();
	}
}
