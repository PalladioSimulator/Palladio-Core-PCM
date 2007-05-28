package de.uka.ipd.sdq.dialogs.parameters;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
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
public class UpParameterListener extends SelectionAdapter {

	private Signature parentSignature;
	private Parameter selectedParameter;
	private EList<Parameter> parameters;

	/**
	 * The transactional editing domain which is used to get the commands and
	 * alter the model
	 */
	protected TransactionalEditingDomain editingDomain = null;

	/**
	 * @param editingDomain
	 */
	public UpParameterListener(Signature signature) {
		this.parentSignature = signature;
		this.editingDomain = TransactionUtil.getEditingDomain(signature);
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
				int index = parameters.indexOf(selectedParameter);
				if (index != 0){
					parameters.move(index, index-1);
					
				}
			}
		};

		recCommand.setDescription("Up ...");
		editingDomain.getCommandStack().execute(recCommand);
	}
}
