package de.uka.ipd.sdq.pcm.dialogs.datatype;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import de.uka.ipd.sdq.pcm.dialogs.parameters.EditorContentsSelectionAction;
import de.uka.ipd.sdq.pcm.dialogs.parameters.UpDownButtonsValidator;
import de.uka.ipd.sdq.pcm.parameter.Variable;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;

/**
 * This adapter class provides default implementations for the methods described
 * by the SelectionListener interface to downItem - Button in the
 * CompositeDataType edit area.
 * 
 * @author Roman Andrej
 */
public class DownInnerDeclarationAction extends EditorContentsSelectionAction
		implements SelectionListener {
	
	private PalladioDataTypeDialog dialog;
	private TransactionalEditingDomain editingDomain;
	
	public DownInnerDeclarationAction(PalladioDataTypeDialog dialog, TransactionalEditingDomain editingDomain) {
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
				int index = declarations.indexOf(selectedDeclaration);
				if (index >= 0 && index < declarations.size() - 1) {
					declarations.move(index, index + 1);
					try {
						UpDownButtonsValidator.getSingelton().validate(
								index + 1, declarations.size());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		};

		recCommand.setDescription("Down ...");
		editingDomain.getCommandStack().execute(recCommand);

		dialog.validateInput();
	}

	public void widgetDefaultSelected(SelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
