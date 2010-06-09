package de.uka.ipd.sdq.pcm.dialogs.datatype;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import de.uka.ipd.sdq.pcm.dialogs.parameters.EditorContentsSelectionAction;
import de.uka.ipd.sdq.pcm.parameter.Variable;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;

/**
 * The class define an action, which a InnerDeclaration for the
 * CompositeDataType delete.
 * 
 * @author Roman Andrej
 */
public class DeleteInnerDeclarationAction extends EditorContentsSelectionAction
		implements SelectionListener {

	private PalladioDataTypeDialog dialog;
	private TransactionalEditingDomain editingDomain;

	public DeleteInnerDeclarationAction(PalladioDataTypeDialog dialog, TransactionalEditingDomain editingDomain) {
		this.dialog = dialog;
		this.editingDomain = editingDomain;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetSelected(SelectionEvent e) {

		final Variable selectedDeclaration = (Variable) getSelectedDeclaration();
		CompositeDataType parentDataType = (CompositeDataType) selectedDeclaration
				.eContainer();
		final EList<Variable> declarations = parentDataType
				.getMembers__CompositeDataType();

		RecordingCommand recCommand = new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				declarations.remove(selectedDeclaration);
			}
		};

		recCommand.setDescription("Delete ...");
		editingDomain.getCommandStack().execute(recCommand);
		// validate the innerdeclaration
		dialog.validateInput();
	}

	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
