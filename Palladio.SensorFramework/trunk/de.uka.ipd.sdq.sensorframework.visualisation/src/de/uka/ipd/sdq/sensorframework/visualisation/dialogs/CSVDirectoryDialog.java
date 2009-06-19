package de.uka.ipd.sdq.sensorframework.visualisation.dialogs;

import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

/**
 * This class demonstrates the DirectoryDialog class.
 * 
 * @author David Scherr
 */
public class CSVDirectoryDialog {
	private String pathDir;
	private boolean isCanceled = false;

	/**
	 * Runs the application.
	 * 
	 * @param pathDir The full path of the directory.
	 */
	public CSVDirectoryDialog(String pathDir) {
		
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		shell.setText("CSV Directory");

		this.pathDir = pathDir;
		DirectoryDialog dialog = new DirectoryDialog(shell);
		dialog.setFilterPath(pathDir);
		dialog.setText("Directory of Experiment Run");
		dialog.setMessage("Select a directory");
		
		this.pathDir = dialog.open();
		
		if (this.pathDir == null) {
			this.pathDir = "";
			isCanceled  = true;
		}
	}

	/**
	 * @return The full path of the directory.
	 */
	public String getPathDir() {
		return pathDir;
	}
	
	/**
	 * @return {@link CSVSettingsDialog#isSettingsDialogCanceled()}
	 */
	public boolean isCanceled() {
		return isCanceled;
	}
}
