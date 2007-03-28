package de.uka.ipd.sdq.dialogs.parameters;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import de.uka.ipd.sdq.dialogs.datatype.DialogRepository;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;
import de.uka.ipd.sdq.pcm.repository.Signature;

/**
 * @author roman
 */
public class AddParameterListener extends SelectionAdapter{

	private Signature parentSignature;
	private String PARAMETER_NAME = "null";

	/**
	 * The transactional editing domain which is used to get the commands and
	 * alter the model
	 */
	final protected TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain(DialogRepository.EDITING_DOMAIN_ID);

	public AddParameterListener(Signature parentSignature) {
		this.parentSignature = parentSignature;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetSelected(SelectionEvent e) {
		Assert.isNotNull(parentSignature);

		final EList<Parameter> parameters = parentSignature
				.getParameters__Signature();

		RecordingCommand recCommand = new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				Parameter parameter = RepositoryFactory.eINSTANCE
						.createParameter();
				parameter.setParameterName(PARAMETER_NAME);
				parameters.add(parameter);
			}
		};

		recCommand.setDescription("Add new parameter to the signature");
		editingDomain.getCommandStack().execute(recCommand);
	}
}
