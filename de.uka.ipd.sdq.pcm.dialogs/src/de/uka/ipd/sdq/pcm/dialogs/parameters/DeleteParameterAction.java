package de.uka.ipd.sdq.pcm.dialogs.parameters;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import de.uka.ipd.sdq.pcm.parameter.Variable;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;

/**
 * The class define an action, which a parameter for the signature delete.
 * 
 * @author Roman Andrej
 */
public class DeleteParameterAction extends EditorContentsSelectionAction
		implements SelectionListener {

	private OperationSignature parentSignature;

	/**
	 * The transactional editing domain which is used to get the commands and
	 * alter the model
	 */
	private TransactionalEditingDomain editingDomain = null;

	public DeleteParameterAction(OperationSignature signature) {
		this.parentSignature = signature;
		this.editingDomain = TransactionUtil.getEditingDomain(signature);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetSelected(SelectionEvent e) {
		final Variable selectedParameter = (Variable) getSelectedDeclaration();
		final EList<Variable> parameters = parentSignature.getParameters__OperationSignature();

		RecordingCommand recCommand = new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				parameters.remove(selectedParameter);
			}
		};

		recCommand.setDescription("Delete ...");
		editingDomain.getCommandStack().execute(recCommand);
	}

	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
