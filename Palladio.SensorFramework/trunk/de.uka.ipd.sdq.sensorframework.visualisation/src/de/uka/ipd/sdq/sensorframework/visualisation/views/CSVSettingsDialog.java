package de.uka.ipd.sdq.sensorframework.visualisation.views;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
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
	private Label lblSavePath;
	private Button btnOK;
	private Button chkHeader;
	private boolean isHeader = true;
	
	private Combo cmbSeparator;
	private String SEMICOLON = "Semicolon";
	private String COMMA = "Comma";
	private String TABULATOR = "Tabulator";
	private String selectedSeparator = SEMICOLON;
	private String[] separatorItems = new String[] { SEMICOLON, COMMA,
			TABULATOR };

	/**
	 * Create the dialog.
	 * 
	 * @param parent
	 * @param style
	 */
	public CSVSettingsDialog(Shell parent, int style, String fileName) {
		super(parent, style);
		setText("SWT Dialog");
		this.fileName = fileName;
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
		frmDialog.setMinimumSize(new Point(400, 300));
		frmDialog.setSize(550, 320);
		frmDialog.setText("CSV Settings");
		{
			Group grpSeparator = new Group(frmDialog, SWT.NONE);
			grpSeparator.setBounds(10, 66, 525, 54);
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
				lblSeparator.setBounds(121, 23, 65, 20);
				lblSeparator.setText("Separator");
			}
			{
				chkHeader = new Button(grpSeparator, SWT.CHECK);
				chkHeader.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent e) {
						isHeader = chkHeader.getSelection();
					}
				});
				chkHeader.setText("CSV Header");
				chkHeader.setBounds(231, 20, 111, 23);
				chkHeader.setSelection(isHeader);
			}
			{
				Label label = new Label(grpSeparator, SWT.SEPARATOR
						| SWT.VERTICAL);
				label.setBounds(201, 17, 2, 28);
			}
		}
		{
			btnOK = new Button(frmDialog, SWT.NONE);
			btnOK.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					frmDialog.close();
				}
			});
			btnOK.setEnabled(false);
			btnOK.setBounds(376, 261, 75, 25);
			btnOK.setText("OK");
		}
		{
			Button btnAbbrechen = new Button(frmDialog, SWT.NONE);
			btnAbbrechen.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					filePath = "";
					frmDialog.close();
				}
			});
			btnAbbrechen.setBounds(460, 261, 75, 25);
			btnAbbrechen.setText("Abbrechen");
		}
		{
			Group group = new Group(frmDialog, SWT.NONE);
			group.setBounds(10, 126, 525, 83);
			{
				Button btnOpenSaveDialog = new Button(group, SWT.NONE);
				btnOpenSaveDialog.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent e) {
						saveAsCSVFileDialog();
						lblSavePath.setText(getFilePath());
						if (!(getFilePath().equals(""))) {
							btnOK.setEnabled(true);
						}
					}
				});
				btnOpenSaveDialog.setBounds(10, 20, 505, 25);
				btnOpenSaveDialog.setText("Open Save File Dialog");
			}
			{
				lblSavePath = new Label(group, SWT.BORDER);
				lblSavePath.setBounds(10, 52, 505, 22);
			}
		}

	}

	/**
	 * Open a Save File Dialog to select a target path for the CSV export.
	 * 
	 * @author David Scherr
	 */
	private void saveAsCSVFileDialog() {
		// Replace all chars, which can't be a part of a valid windows filename.
		fileName = fileName.replace('\\', '-');
		fileName = fileName.replace('/', '-');
		fileName = fileName.replace(':', '-');
		fileName = fileName.replace('*', '+');
		fileName = fileName.replace('?', '!');
		fileName = fileName.replace('"', ' ');
		fileName = fileName.replace('<', '(');
		fileName = fileName.replace('>', ')');
		fileName = fileName.replace('|', ',');

		FileDialog dialog = new FileDialog(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell(), SWT.SAVE);
		dialog.setFileName(fileName);
		dialog.setOverwrite(true);
		dialog.setFilterExtensions(new String[] { "*.csv" });
		filePath = dialog.open();
		if ((filePath == null) || (dialog.getFileName().equals(""))) {
			// The dialog is canceled.
			filePath = "";
			btnOK.setEnabled(false);
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
		if (selectedSeparator.equals(SEMICOLON)) {
			return ";";
		} else if (selectedSeparator.equals(COMMA)) {
			return ",";
		} else if (selectedSeparator.equals(TABULATOR)) {
			return "\t";
		}
		return ";"; // Standard
	}
}
