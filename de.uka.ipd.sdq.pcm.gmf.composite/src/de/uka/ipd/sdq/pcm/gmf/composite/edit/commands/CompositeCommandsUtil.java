/**
 * 
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.commands;

import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

/**
 * Utility functions for commands in composite package.
 * 
 * @author groenda
 * @generated not
 */
public class CompositeCommandsUtil {

    /**
     * Notifies the user that re-orientation is not supported and cancels the current command.
     * 
     * @return Result of cancel command.
     */
    public static CommandResult displayReorientationError() {
        Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
        MessageBox messageBox = new MessageBox(shell, SWT.OK | SWT.ICON_ERROR);
        messageBox.setText("Notice");
        messageBox.setMessage("Please delete the link and create a new one instead of reorienting it.");
        messageBox.open();
        return CommandResult.newCancelledCommandResult();
    }

}
