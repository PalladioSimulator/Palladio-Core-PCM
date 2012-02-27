package de.uka.ipd.sdq.dsexplore.helper;

import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.dsexplore.DSEPluginActivator;

public class DSEMessageBox implements Runnable {

	private String title;
	private String message;
	private int dialogImageType;

	public DSEMessageBox(String title, String message, int dialogImageType) {
		super();
		this.title = title;
		this.message = message;
		this.dialogImageType = dialogImageType;
	}

	@Override
	public void run() {
		MessageDialog dlg = new MessageDialog(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell(), title, null, message,
				dialogImageType, new String[] { "Ok" }, 1);
		dlg.open();

	}

	public static void showMessage(String title, String message, int dialogType) {
		Display display = Display.getDefault();
		
		DSEPluginActivator.log(Status.OK, message);

		display.syncExec(new DSEMessageBox(title, message, dialogType));
	}

}
