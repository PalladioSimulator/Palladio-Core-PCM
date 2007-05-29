package de.uka.ipd.sdq.dialogs.datatype;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import de.uka.ipd.sdq.dialogs.parameters.UpDownButtonsValidator;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.InnerDeclaration;

/** @author roman */
public class UpInnerDataTypeListener extends SelectionAdapter {
	
	private PalladioDataTypeDialog dialog;
	private InnerDeclaration selectedDeclaration;
	private CompositeDataType parentDataType;
	private EList<InnerDeclaration> declarations;
	private TransactionalEditingDomain editingDomain;

	public UpInnerDataTypeListener(PalladioDataTypeDialog dialog, TransactionalEditingDomain editingDomain) {
		this.dialog = dialog;
		this.editingDomain = editingDomain;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	public void widgetSelected(SelectionEvent e) {

		this.parentDataType = DialogRepository.getNewCompositeDataType();
		this.selectedDeclaration = (InnerDeclaration) DialogRepository
				.getSelectedEObject();

		Assert.isNotNull(parentDataType);
		Assert.isNotNull(selectedDeclaration);

		declarations = parentDataType.getInnerDeclaration_CompositeDataType();

		RecordingCommand recCommand = new RecordingCommand(editingDomain) {
			@Override
			protected void doExecute() {
				int index = declarations.indexOf(selectedDeclaration);
				if (index > 0) {
					declarations.move(index, index - 1);
					try {
						UpDownButtonsValidator.getSingelton().validate(index - 1,
								declarations.size());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		};

		recCommand.setDescription("Up ...");
		editingDomain.getCommandStack().execute(recCommand);

		dialog.validateInput();
	}

}
