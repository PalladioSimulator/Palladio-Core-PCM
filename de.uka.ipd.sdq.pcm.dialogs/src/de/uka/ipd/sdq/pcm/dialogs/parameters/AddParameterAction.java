package de.uka.ipd.sdq.pcm.dialogs.parameters;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import de.uka.ipd.sdq.pcm.parameter.ParameterFactory;
import de.uka.ipd.sdq.pcm.parameter.Variable;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;

/**
 * The class define an action, which a new parameter for the signature adds.
 * 
 * @author Roman Andrej
 */
public class AddParameterAction extends SelectionAdapter{

	private OperationSignature parentSignature = null;
	private String parameterName = "null";

	/**
	 * The transactional editing domain which is used to get the commands and
	 * alter the model
	 */
	private TransactionalEditingDomain editingDomain = null;

	public AddParameterAction(OperationSignature parentSignature) {
		this.parentSignature = parentSignature;
		this.editingDomain = TransactionUtil.getEditingDomain(parentSignature);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	@Override
	public void widgetSelected(SelectionEvent e) {
		Assert.isNotNull(parentSignature);

		final EList<Variable> parameters = parentSignature
				.getParameters__OperationSignature();

		RecordingCommand recCommand = new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				Variable parameter = ParameterFactory.eINSTANCE
						.createVariable();
				parameter.setEntityName(parameterName);
				parameters.add(parameter);
			}
		};

		recCommand.setDescription("Add new parameter to the signature");
		editingDomain.getCommandStack().execute(recCommand);
	}
}
