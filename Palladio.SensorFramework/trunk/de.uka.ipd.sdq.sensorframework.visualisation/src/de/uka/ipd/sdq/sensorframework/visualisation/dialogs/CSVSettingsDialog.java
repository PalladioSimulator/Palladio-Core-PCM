package de.uka.ipd.sdq.sensorframework.visualisation.dialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

/**
 * A dialog for CSV-data-export settings.
 * 
 * @author David Scherr
 */
public class CSVSettingsDialog extends Dialog {

	protected Object result;
	protected Shell frmDialog;

	private String fileName;
	private String filePath;
	private String fileDir;
	private Button btnSave;
	private Button chkHeader;
	private boolean isHeader = true;
	
	// The values are not in accordance with the common java convention, but as
	// entries for a Combobox it is more readable.
	private enum Separator {
		Semicolon, Comma, Tabulator; 
	}

	private Combo cmbSeparator;
	private String selectedSeparator = Separator.Semicolon.toString();
	private String[] separatorItems;	
	private Label lblHeader;
	private String fileExtension;
	private DialogType dialogType;
	
	/**
	 * Create the dialog.
	 * 
	 * @param parent The parent display shell on which the dialog will be created.
	 * @param style Behavior and style of the dialog.
	 * @param filePath default file path
	 * @param fileName default file name
	 * @param fileExtension default file extension
	 */
	public CSVSettingsDialog(String fileDir, String fileName, String fileExtension, DialogType type) {
		
		super(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				SWT.APPLICATION_MODAL | SWT.DIALOG_TRIM);
		setText("SWT Dialog");
		
		this.dialogType = type;
		this.fileDir = fileDir;	
		this.fileName = fileName;
		this.fileExtension = fileExtension;
		
		separatorItems = new String[3];
		int i = 0;
		for(Separator sep: Separator.values()) {
			separatorItems[i] = sep.toString();
			i++;
		}
	}

	/**
	 * Open the dialog.
	 * 
	 * @return the result
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
	 * Create contents of the dialog.
	 */
	private void createContents() {
		frmDialog = new Shell(getParent(), SWT.DIALOG_TRIM);
		frmDialog.setMinimumSize(new Point(100, 100));
		frmDialog.setSize(245, 220);
		frmDialog.setText("CSV Settings");
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
				// the default selection index must be consistent with the
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
					} else if (dialogType == DialogType.PATH) {
						CSVDirectoryDialog dirDialog = new CSVDirectoryDialog(fileDir);
						fileDir = dirDialog.getFileDir();
						filePath = fileDir;
					}
					frmDialog.close();
				}
			});
			btnSave.setBounds(10, 152, 75, 25);
			btnSave.setText("Save As");
		}
		{
			Button btnAbbrechen = new Button(frmDialog, SWT.NONE);
			btnAbbrechen.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					filePath = "";
					frmDialog.close();
				}
			});
			btnAbbrechen.setBounds(153, 152, 75, 25);
			btnAbbrechen.setText("Cancel");
		}

	}

	/**
	 * Open a Save File Dialog to select a target path for the CSV export.
	 * 
	 * @author David Scherr
	 */
	private void saveAsCSVFileDialog() {

		FileDialog dialog = new FileDialog(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell(), SWT.SAVE);

		dialog.setFilterPath(fileDir);
		dialog.setFileName(fileName);
		dialog.setFilterExtensions(new String[] {fileExtension});
		dialog.setOverwrite(true);
		
		filePath = dialog.open();

		if (filePath == null) {
			// The dialog is canceled.
			filePath = "";
		}
	}

	/**
	 * @author David Scherr
	 * @return The complete target path for the CSV export.
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * @author David Scherr
	 * @return true : Save CSV file with integrated header.\n false : Save CSV
	 *         file without any header.
	 */
	public boolean isHeader() {
		// It can't return chkHeader.getEnabled() after the dialog is closed, so
		// it is stored in an extra property.
		return isHeader;
	}

	/**
	 * @author David Scherr
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
	
	public void dispose() {
		frmDialog.dispose();
	}
}
