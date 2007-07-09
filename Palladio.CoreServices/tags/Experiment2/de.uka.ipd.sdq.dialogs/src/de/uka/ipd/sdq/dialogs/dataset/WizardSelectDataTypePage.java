package de.uka.ipd.sdq.dialogs.dataset;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class WizardSelectDataTypePage extends WizardPage {

	private Combo myCombo;
	protected String result = "";

	protected WizardSelectDataTypePage(String pageName) {
		super(pageName);
	}

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
		label.setText("Select Type of Datasource to create:");
		label.setLayoutData(new GridData(
				GridData.HORIZONTAL_ALIGN_BEGINNING));

		myCombo = new Combo(panel, SWT.DROP_DOWN | SWT.READ_ONLY);
		populateComboBox();
		myCombo.addSelectionListener(new SelectionListener(){

			public void widgetDefaultSelected(SelectionEvent e) {
				WizardSelectDataTypePage.this.result = myCombo.getText();
				WizardSelectDataTypePage.this.setPageComplete(
						!myCombo.getText().equals(""));
			}

			public void widgetSelected(SelectionEvent e) {
				WizardSelectDataTypePage.this.result = myCombo.getText();
				WizardSelectDataTypePage.this.setPageComplete(
					!myCombo.getText().equals(""));
			}
			
		});
	}

	private void populateComboBox() {
		myCombo.add("Memory Datasource");
		myCombo.add("DB4O Datasource");
	}

	@Override
	public boolean canFlipToNextPage() {
		boolean canFlip = !myCombo.getText().equals("");
		canFlip = canFlip && myCombo.getText().equals("DB4O Datasource");

		return super.canFlipToNextPage() && canFlip;
	}

	public Object getResult() {
		return result;
	}

}
