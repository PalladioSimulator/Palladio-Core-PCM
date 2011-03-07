package de.uka.ipd.sdq.sensorframework.visualisation.dialogs;

import java.io.File;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.ui.PlatformUI;
import de.uka.ipd.sdq.sensorframework.visualisation.dialogs.Separator;

/**
 * A dialog for the settings of the CSV data export.
 * 
 * @author David Scherr
 */
public class CSVSettingsDialog extends Dialog {

	protected Object result;
	protected Shell frmDialog;

	private String fileOrDirName = "";
	private String pathFileOrDir = "";
	private String pathParentDir = "";
	private Button btnSave;
	private Button chkHeader;
	private boolean isHeader = true;
	private boolean isSettingsDialogCanceled = false;
	private boolean isFileOrDirDialogCanceled = false;
	private Combo cmbSeparator;
	private String selectedSeparator = Separator.Semicolon.toString();
	private String[] separatorItems;
	private Label lblHeader;
	private String fileExtension = "";
	private DialogType dialogType;

	/**
	 * Create the dialog.
	 * 
	 * @param pathParentDir
	 *            Default path of the parent directory.
	 * @param fileOrDirName
	 *            If the type is <code>FILE</code> then it means the default file name or if the
	 *            type is <code>DIRECTORY</code> then it means the child directory name (but not a
	 *            whole path).
	 * @param fileExtension
	 *            Default file extension (only for type = <code>FILE</code>).
	 * @param type
	 *            The type of the dialog either DialogType.DIRECTORY stands for SWT DirectoryDialog
	 *            for choosing a directory path or DialogType.FILE stands for SWT FileDialog for
	 *            choosing a file path.
	 */
	public CSVSettingsDialog(String pathParentDir, String fileOrDirName, String fileExtension,
			DialogType type) {

		super(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				SWT.APPLICATION_MODAL | SWT.DIALOG_TRIM);
		setText("SWT Dialog");

		this.dialogType = type;
		this.pathParentDir = pathParentDir;
		this.fileOrDirName = fileOrDirName;
		this.fileExtension = fileExtension;

		separatorItems = new String[3];
		int i = 0;
		for (Separator sep : Separator.values()) {
			separatorItems[i] = sep.toString();
			i++;
		}
	}

	/**
	 * Open the dialog while you cancel or click on the <em>Save As</em> Button.
	 * 
	 * @return The result is not defined at the moment.
	 */
	public Object open() {
		createContents();
		frmDialog.open();
		frmDialog.layout();
		Display display = getParent().getDisplay();
		while (!frmDialog.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * @return {@link CSVSettingsDialog#isPathValid()}
	 */
	public boolean getValidPath() {
		String pathDir = "";
		/*
		 * If the directory doesn't exist, then it will be created. If the directory exists,
		 * then a message box ask to overwrite it.
		 */
		while (!isSettingsDialogCanceled & getPath().equals("")) {
			isFileOrDirDialogCanceled = false;
			isSettingsDialogCanceled = false;
			open();
			/*
			 * If the dialog type is DIRECTORY, then the file path (fileOrDirName) is the parent
			 * directory path + child directory name.
			 */
			if (isPathValid()) {
				if (dialogType == DialogType.DIRECTORY) {
					pathDir = getPath() + File.separatorChar + fileOrDirName;
					createDirectory(pathDir);
				} else if (dialogType == DialogType.FILE) {
					// Do nothing special.
				}
			}
		}
		if (dialogType == DialogType.DIRECTORY) {
			pathFileOrDir = pathDir;
		}
		dispose();
		return isPathValid();
	}

	/**
	 * If the directory doesn't exist then a dialog ask to create one or not.
	 * 
	 * @param pathDir
	 *            The full path of the directory that you want to create.
	 */
	private void createDirectory(String pathDir) {

		File fileObject = new File(pathDir);

		if (fileObject.exists()) {
			MessageBox box = new MessageBox(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getShell(), SWT.OK | SWT.CANCEL);
			box.setMessage("The directory already exists! Do you want to overwrite it?");
			int boxResult = box.open();

			if (boxResult == SWT.OK) {
				// Overwrite the existing directory.
				deleteTree(fileObject);
				fileObject.mkdirs();
			} else if (boxResult == SWT.CANCEL) {
				// Don't overwrite the existing directory.
				pathFileOrDir = "";
			}
		} else {
			// The directory doesn't exist.
			fileObject.mkdirs();
		}
	}

	/**
	 * Delete directories in recursion.
	 */
	private void deleteTree(File path) {
		for (File file : path.listFiles()) {
			if (file.isDirectory()) {
				deleteTree(file);
			} else {
				file.delete();
			}
		}
		path.delete();
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		frmDialog = new Shell(getParent(), SWT.DIALOG_TRIM);
		frmDialog.setMinimumSize(new Point(100, 100));
		frmDialog.setSize(245, 220);
		frmDialog.setText("CSV Settings");
		frmDialog.setLocation(300, 300);
		{
			Group grpSeparator = new Group(frmDialog, SWT.NONE);
			grpSeparator.setBounds(10, 31, 218, 90);
			{
				cmbSeparator = new Combo(grpSeparator, SWT.NONE);
				cmbSeparator.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent e) {
						selectedSeparator = cmbSeparator.getItem(cmbSeparator.getSelectionIndex());
					}
				});

				cmbSeparator.setBounds(10, 20, 105, 23);
				cmbSeparator.setItems(separatorItems);
				// The default selection index must be consistent with the
				// String value of the property separator.
				cmbSeparator.select(0);
			}
			{
				Label lblSeparator = new Label(grpSeparator, SWT.NONE);
				lblSeparator.setBounds(143, 23, 65, 20);
				lblSeparator.setText("Separator");
			}
			{
				chkHeader = new Button(grpSeparator, SWT.CHECK);
				chkHeader.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent e) {
						isHeader = chkHeader.getSelection();
					}
				});
				chkHeader.setBounds(56, 61, 51, 23);
				chkHeader.setSelection(isHeader);
			}
			{
				lblHeader = new Label(grpSeparator, SWT.NONE);
				lblHeader.setBounds(143, 64, 65, 20);
				lblHeader.setText("Header");
			}
		}
		{
			btnSave = new Button(frmDialog, SWT.NONE);
			btnSave.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					if (dialogType == DialogType.FILE) {
						saveAsCSVFileDialog();
					} else if (dialogType == DialogType.DIRECTORY) {
						CSVDirectoryDialog dirDialog = new CSVDirectoryDialog(pathParentDir);
						pathParentDir = dirDialog.getPathDir();
						pathFileOrDir = pathParentDir;
						isFileOrDirDialogCanceled = dirDialog.isCanceled();
					}
					frmDialog.close();
				}
			});
			btnSave.setBounds(10, 152, 75, 25);
			btnSave.setText("Save As");
		}
		{
			Button btnCancel = new Button(frmDialog, SWT.NONE);
			btnCancel.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					pathFileOrDir = "";
					frmDialog.close();
					isSettingsDialogCanceled = true;
				}
			});
			btnCancel.setBounds(153, 152, 75, 25);
			btnCancel.setText("Cancel");
		}

	}

	/**
	 * Open a Save File Dialog to select a target path for the CSV export.
	 */
	private void saveAsCSVFileDialog() {

		FileDialog dialog = new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getShell(), SWT.SAVE);

		dialog.setFilterPath(pathParentDir);
		dialog.setFileName(fileOrDirName);
		dialog.setFilterExtensions(new String[] { fileExtension });
		dialog.setOverwrite(true);

		pathFileOrDir = dialog.open();

		if (pathFileOrDir == null) {
			// The dialog is canceled.
			pathFileOrDir = "";
			isFileOrDirDialogCanceled = true;
		}
	}

	/**
	 * @return The complete target path for the CSV export.
	 */
	public String getPath() {
		return pathFileOrDir;
	}

	/**
	 * @return <code>true</code>: Save CSV file with integrated header.<br>
	 *         <code>false</code>: Save CSV file without any header.
	 */
	public boolean isHeader() {
		// It can't return chkHeader.getEnabled() after the dialog is closed, so
		// it is stored in an extra property.
		return isHeader;
	}

	/**
	 * @return The chosen separator which is one of the following characters:<br>
	 * <br>
	 *         <ul>
	 *         <li>Semicolon ";"</li>
	 *         <li>Comma ","</li>
	 *         <li>Tabulator "\t"</li>
	 *         </ul>
	 */
	public String getSeparator() {
		if (selectedSeparator.equals(Separator.Semicolon.toString())) {
			return ";";
		} else if (selectedSeparator.equals(Separator.Comma.toString())) {
			return ",";
		} else if (selectedSeparator.equals(Separator.Tabulator.toString())) {
			return "\t";
		}
		return ";"; // Standard
	}

	/**
	 * Dispose the resources of the dialog widgets.
	 */
	public void dispose() {
		frmDialog.dispose();
	}

	/**
	 * @return <code>true</code> if a path is chosen and the both dialog are not canceled or<br>
	 *         <code>false</code> if one of the dialogs is canceled or the path is an empty string.
	 */
	public boolean isPathValid() {
		if (getPath().equals("") | isFileOrDirDialogCanceled | isSettingsDialogCanceled) {
			return false;
		} else {
			return true;
		}
	}
}
