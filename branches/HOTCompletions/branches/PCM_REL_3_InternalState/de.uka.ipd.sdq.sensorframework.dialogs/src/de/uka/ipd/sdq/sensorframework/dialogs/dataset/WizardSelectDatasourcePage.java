package de.uka.ipd.sdq.sensorframework.dialogs.dataset;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class WizardSelectDatasourcePage extends WizardPage {

	/**String constants for existing data sources */
	public static String MEMORY_DATASRC = "Memory Datasource";
	public static String FILE_DATASRC = "File Datasource";
	
	private Combo myCombo;
	protected String result = "";
	private String pageName;
	private boolean memoryEntry, db40Entry, fileEntry;

	protected WizardSelectDatasourcePage(String pageName, boolean memoryEntry,
			boolean db40Entry, boolean fileEntry) {
		super(pageName);
		this.pageName = pageName;
		this.memoryEntry = memoryEntry;
		this.db40Entry = db40Entry;
		this.fileEntry = fileEntry;
	}

	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		
		initializeDialogUnits(parent);
		Composite topLevel = new Composite(parent, SWT.NONE);
		topLevel.setLayout(new GridLayout());
		topLevel.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_FILL
				| GridData.HORIZONTAL_ALIGN_FILL));
		topLevel.setFont(parent.getFont());
		setControl(topLevel);
		createPageContent(topLevel);
		this.setPageComplete(false);
	}

	private void createPageContent(Composite parent) {
		Composite panel = new Composite(parent, SWT.NONE);
		panel.setLayoutData(new GridData(GridData.FILL_BOTH));
		GridLayout layout = new GridLayout();
		panel.setLayout(layout);

		Label label = new Label(panel, SWT.NONE);
		label.setText(pageName + ":");
		label.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));

		myCombo = new Combo(panel, SWT.DROP_DOWN | SWT.READ_ONLY);
		populateComboBox();
		myCombo.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				WizardSelectDatasourcePage.this.result = myCombo.getText();
				WizardSelectDatasourcePage.this.setPageComplete(!myCombo
						.getText().equals(""));
			}

			public void widgetSelected(SelectionEvent e) {
				WizardSelectDatasourcePage.this.result = myCombo.getText();
				WizardSelectDatasourcePage.this.setPageComplete(!myCombo
						.getText().equals(""));
			}

		});
	}

	private void populateComboBox() {
		if (memoryEntry)
			myCombo.add(MEMORY_DATASRC);
		if (fileEntry)
			myCombo.add(FILE_DATASRC);
	}

	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.WizardPage#canFlipToNextPage()
	 */
	@Override
	public boolean canFlipToNextPage() {
		boolean canFlip = !myCombo.getText().equals("");
		canFlip = canFlip
				&& (myCombo.getText().equals(FILE_DATASRC));

		return super.canFlipToNextPage() && canFlip;
	}

	public String getResult() {
		return result;
	}
}
