package de.uka.ipd.sdq.pcm.dialogs.datatype;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import de.uka.ipd.sdq.pcm.dialogs.parameters.EditorContentsSelectionAction;
import de.uka.ipd.sdq.pcm.dialogs.parameters.UpDownButtonsValidator;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.InnerDeclaration;

/**
 * This adapter class provides default implementations for the methods described by the
 * SelectionListener interface to upItem - Button in the ColpositeDataType edit area.
 * 
 * @author Roman Andrej
 */
public class UpInnerDeclarationAction extends EditorContentsSelectionAction implements SelectionListener {

    private PalladioDataTypeDialog dialog;
    private TransactionalEditingDomain editingDomain;

    public UpInnerDeclarationAction(PalladioDataTypeDialog dialog, TransactionalEditingDomain editingDomain) {
        this.dialog = dialog;
        this.editingDomain = editingDomain;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent
     * )
     */
    public void widgetSelected(SelectionEvent e) {

        final InnerDeclaration selectedDeclaration = (InnerDeclaration) getSelectedDeclaration();
        CompositeDataType parentDataType = (CompositeDataType) selectedDeclaration.eContainer();
        final EList<InnerDeclaration> declarations = parentDataType.getInnerDeclaration_CompositeDataType();

        RecordingCommand recCommand = new RecordingCommand(editingDomain) {
            @Override
            protected void doExecute() {
                int index = declarations.indexOf(selectedDeclaration);
                if (index > 0) {
                    declarations.move(index, index - 1);
                    try {
                        UpDownButtonsValidator.getSingelton().validate(index - 1, declarations.size());
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

    public void widgetDefaultSelected(SelectionEvent e) {
        // TODO Auto-generated method stub
    }
}
