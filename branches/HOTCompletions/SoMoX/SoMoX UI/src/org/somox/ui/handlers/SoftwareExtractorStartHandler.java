package org.somox.ui.handlers;


import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;
import org.somox.ui.Activator;
import org.somox.ui.GUISoMoXCoreController;

/**
 * Handler to start the configured extractors
 * @author benjamin klatt
 *
 */
public class SoftwareExtractorStartHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
	/*	Shell shell = HandlerUtil.getActiveWorkbenchWindow(event).getShell();

		// check that the controller is available
		GUISoMoXCoreController controller = Activator.getDefault().getGuiSoMoXCoreController();
		if(controller == null){
			MessageDialog.openError(shell, "SoMoX Core Controller not loaded", "The SoMoX Core Controller can not be accessed. This indicates that the controller is not loaded yet. May be the SoMoX Core itself is not in place or not started yet.");
			return null;
		}

		// open the monitor dialog with an internal class
		// calling the SoMoX core controller
		ProgressMonitorDialog dialog = new ProgressMonitorDialog(shell);
		dialog.setCancelable(false);
		try {
			dialog.run(true,false,new IRunnableWithProgress(){
				@Override
				public void run(IProgressMonitor progressMonitor)
						throws InvocationTargetException, InterruptedException {
					GUISoMoXCoreController controller = Activator.getDefault().getGuiSoMoXCoreController();
					controller.startExtraction(progressMonitor);
				}});
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
*/
		return null;
	}

}
