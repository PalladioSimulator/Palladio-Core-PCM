package de.uka.ipd.sdq.pcm.dialogs.exception;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import de.uka.ipd.sdq.pcm.repository.ExceptionType;
import de.uka.ipd.sdq.pcm.repository.Signature;

/** @author roman */
public class DeleteExctentionAction extends SelectionAdapter implements ISelectionChangedListener {

    private Signature parentSignature;
    private ExceptionType exceptionType = null;

    /**
     * The transactional editing domain which is used to get the commands and alter the model
     */
    protected TransactionalEditingDomain editingDomain = null;

    public DeleteExctentionAction(Signature signature) {
        this.parentSignature = signature;
        this.editingDomain = TransactionUtil.getEditingDomain(signature);
    }

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
        this.exceptionType = (ExceptionType) selection;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent
     * )
     */
    @Override
    public void widgetSelected(SelectionEvent e) {
        Assert.isNotNull(exceptionType);
        final EList<ExceptionType> exceptions = parentSignature.getExceptions__Signature();

        RecordingCommand recCommand = new RecordingCommand(editingDomain) {
            @Override
            protected void doExecute() {
                exceptions.remove(exceptionType);
            }
        };

        recCommand.setDescription("Delete ...");
        editingDomain.getCommandStack().execute(recCommand);
    }
}
