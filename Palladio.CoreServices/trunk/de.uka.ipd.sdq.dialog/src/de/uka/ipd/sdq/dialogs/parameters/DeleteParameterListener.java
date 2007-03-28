package de.uka.ipd.sdq.dialogs.parameters;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import de.uka.ipd.sdq.dialogs.datatype.DialogRepository;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.Signature;

/**
 * TODO Refactaring?
 * 
 * @author roman
 * 
 */
public class DeleteParameterListener extends SelectionAdapter {

	private Signature parentSignature;
	private Parameter selectedParameter;
	private EList<Parameter> parameters;

	/**
	 * The transactional editing domain which is used to get the commands and
	 * alter the model
	 */
	final protected TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain(DialogRepository.EDITING_DOMAIN_ID);

	/**
	 * @param editingDomain
	 */
	public DeleteParameterListener(Signature signature) {
		this.parentSignature = signature;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetSelected(SelectionEvent e) {
		this.selectedParameter = (Parameter) DialogRepository
				.getSelectedEObject();

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
}
