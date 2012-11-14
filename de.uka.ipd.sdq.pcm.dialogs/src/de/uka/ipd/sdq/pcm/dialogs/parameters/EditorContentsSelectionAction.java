package de.uka.ipd.sdq.pcm.dialogs.parameters;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;

/**
 * The class delegates straight in the active View selected object on the subclass.
 * 
 * @author Roman Andrej
 */
public class EditorContentsSelectionAction implements ISelectionChangedListener {

    private EObject selectedDeclaration = null;

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers
     * .SelectionChangedEvent)
     */
    public void selectionChanged(SelectionChangedEvent event) {
        IStructuredSelection sel = (IStructuredSelection) event.getSelection();
        Object selection = (Object) sel.getFirstElement();
        this.selectedDeclaration = (EObject) selection;

        /** make validation(Enabled/Unenabled) for delete-,up-,downToolItem */
        UpDownButtonsValidator.getSingelton().validateSelection(selection);
    }

    public EObject getSelectedDeclaration() {
        return selectedDeclaration;
    }
}
