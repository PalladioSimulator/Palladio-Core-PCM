/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.custom.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.pcm.gmf.composite.edit.commands.AssemblyConnectorReorientCommand;

public class CustomAssemblyConnectorReorientCommand extends AssemblyConnectorReorientCommand {

    public CustomAssemblyConnectorReorientCommand(
			ReorientRelationshipRequest request) {
		super(request);
	}

	/**
     * Reorient source.
     * 
     * @return the command result
     * @throws ExecutionException
     *             the execution exception
     * @generated NOT
     */
    protected CommandResult reorientSource() throws ExecutionException {
        Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
        MessageBox messageBox = new MessageBox(shell, SWT.OK | SWT.ICON_ERROR);
        messageBox.setText("Notice");
        messageBox.setMessage("Please delete the link and create a new one instead of reorienting it.");
        messageBox.open();
        return CommandResult.newCancelledCommandResult();
    }

    /**
     * Reorient target.
     * 
     * @return the command result
     * @throws ExecutionException
     *             the execution exception
     * @generated NOT
     */
    protected CommandResult reorientTarget() throws ExecutionException {
        Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
        MessageBox messageBox = new MessageBox(shell, SWT.OK | SWT.ICON_ERROR);
        messageBox.setText("Notice");
        messageBox.setMessage("Please delete the link and create a new one instead of reorienting it.");
        messageBox.open();
        return CommandResult.newCancelledCommandResult();
    }

}
