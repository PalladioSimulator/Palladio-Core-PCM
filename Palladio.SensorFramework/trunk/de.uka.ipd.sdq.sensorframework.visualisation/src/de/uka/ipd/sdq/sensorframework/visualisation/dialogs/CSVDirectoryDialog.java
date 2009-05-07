package de.uka.ipd.sdq.sensorframework.visualisation.dialogs;

import org.eclipse.swt.widgets.*;
import org.eclipse.ui.PlatformUI;

/**
 * This class demonstrates the DirectoryDialog class
 */
public class CSVDirectoryDialog {
	private String fileDir;

	/**
	 * Runs the application
	 */
	public CSVDirectoryDialog(String fileDir) {
		
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		shell.setText("CSV Directory");

		this.fileDir = fileDir;
		DirectoryDialog dialog = new DirectoryDialog(shell);
		dialog.setFilterPath(fileDir);
		dialog.setText("SWT's DirectoryDialog");
		dialog.setMessage("Select a directory");

		this.fileDir = dialog.open();
		if (this.fileDir == null) {
			this.fileDir = "";
		}		
	}

	public String getFileDir() {
		return fileDir;
	}
}
