package de.uka.ipd.sdq.pcm.dialogs.datatype;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import de.uka.ipd.sdq.pcm.dialogs.parameters.EditorContentsSelectionAction;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.InnerDeclaration;

/**
 * The class define an action, which a InnerDeclaration for the CompositeDataType delete.
 * 
 * @author Roman Andrej
 */
public class DeleteInnerDeclarationAction extends EditorContentsSelectionAction implements SelectionListener {

    private PalladioDataTypeDialog dialog;
    private TransactionalEditingDomain editingDomain;

    public DeleteInnerDeclarationAction(PalladioDataTypeDialog dialog, TransactionalEditingDomain editingDomain) {
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
