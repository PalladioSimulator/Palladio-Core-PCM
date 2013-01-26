/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.part;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * The Class LoadResourceAction.
 * 
 * @generated
 */
public class LoadResourceAction extends AbstractHandler {

    /**
     * Execute.
     * 
     * @param event
     *            the event
     * @return the object
     * @throws ExecutionException
     *             the execution exception
     * @generated
     */
    public Object execute(ExecutionEvent event) throws ExecutionException {
        IEditorPart diagramEditor = HandlerUtil.getActiveEditorChecked(event);
        Shell shell = diagramEditor.getEditorSite().getShell();
        assert diagramEditor instanceof DiagramEditor;
        TransactionalEditingDomain editingDomain = ((DiagramEditor) diagramEditor).getEditingDomain();
        org.eclipse.emf.edit.ui.action.LoadResourceAction.LoadResourceDialog loadResourceDialog = new org.eclipse.emf.edit.ui.action.LoadResourceAction.LoadResourceDialog(
                shell, editingDomain);
        loadResourceDialog.open();
        return null;
    }

}
