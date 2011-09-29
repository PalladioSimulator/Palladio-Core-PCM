package de.uka.ipd.sdq.edp2.transformation.filter;

import java.util.logging.Logger;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import de.uka.ipd.sdq.edp2.visualization.IAdapter;
import de.uka.ipd.sdq.edp2.visualization.IDataSource;

public class WarmupFilterSettingsPage extends WizardPage implements Listener {

	private final static String PAGE_NAME = "Warmup Filter Settings";

	private final static float DEFAULT_DROPPED = 10.0f;

	private static final Logger logger = Logger
			.getLogger(WarmupFilterSettingsPage.class.getCanonicalName());

	IDataSource source;
	IStatus numberStatus;
	Text droppedAbsText;
	Text droppedPerText;
	float droppedValuesPercentage;
	int droppedValuesAbsolute;
	long numberOfMeasurements;
	Status statusOK;

	public WarmupFilterSettingsPage(IDataSource source) {
		super(PAGE_NAME);
		this.source = source;
		setDescription("Choose the settings for the Warmup Filter.");
		setDroppedValuesPercentage(DEFAULT_DROPPED);
		statusOK = new Status(IStatus.OK, "not_used", 0, "", null);
		numberStatus = statusOK;
	}

	private void setDroppedValuesPercentage(float droppedValuesPercentage) {
		this.droppedValuesPercentage = droppedValuesPercentage;
		this.droppedValuesAbsolute = 0;
	}

	private void setDroppedValuesAbsolute(int droppedValuesAbsolute) {
		this.droppedValuesAbsolute = droppedValuesAbsolute;
		this.droppedValuesPercentage = 0.0f;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.
	 * Event)
	 */
	@Override
	public void handleEvent(Event event) {
		numberStatus = statusOK;
		if (event.widget == droppedAbsText) {
			int temp = 0;
			try {
				temp = Integer.parseInt(droppedAbsText.getText());
			} catch (NumberFormatException nfe) {
				numberStatus = new Status(IStatus.ERROR, "not_used", 0,
						"Not a valid number.", null);
			}
			if (temp > numberOfMeasurements || temp < 1) {
				numberStatus = new Status(
						IStatus.ERROR,
						"not_used",
						0,
						"The number of dropped values must be less than the number of measurements and greater than zero.",
						null);
			} else {
				setDroppedValuesAbsolute(temp);
			}
		}
		if (event.widget == droppedPerText) {
			float temp = 0;
			try {
				temp = Float.parseFloat(droppedPerText.getText());
			} catch (NumberFormatException nfe) {
				numberStatus = new Status(IStatus.ERROR, "not_used", 0,
						"Not a valid number.", null);
			}
			if (temp > 100.0 || temp < 0.0) {
				numberStatus = new Status(
						IStatus.ERROR,
						"not_used",
						0,
						"The number of dropped values must be less than 100% and greater than 0%.",
						null);
			} else {
				setDroppedValuesPercentage(temp);
			}

		}

		updatePageStatus();
		getWizard().getContainer().updateButtons();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets
	 * .Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		// create the composite to hold the widgets
		GridData gd;
		Composite composite = new Composite(parent, SWT.NONE);
		setControl(composite);
		// set the layout of the composite
		GridLayout gl = new GridLayout();
		int ncol = 2;
		gl.numColumns = ncol;
		composite.setLayout(gl);

		// create the widgets on the composite
		Label perLabel = new Label(composite, SWT.NONE);
		perLabel.setText("Dropped Values (as Percentage):");
		droppedPerText = new Text(composite, SWT.BORDER);
		droppedPerText.setSize(60, 20);
		droppedPerText.addListener(SWT.Deactivate, this);
		Label absLabel = new Label(composite, SWT.NONE);
		absLabel.setText("Dropped Values (absolute):");
		droppedAbsText = new Text(composite, SWT.BORDER);
		droppedAbsText.setSize(60, 20);
		droppedAbsText.addListener(SWT.Deactivate, this);
	}

	/**
	 * Updates the overall status of this page.
	 * 
	 * @return the new page status ({@link IStatus})
	 */
	public IStatus updatePageStatus() {
		IStatus pageStatus = statusOK;
		switch (numberStatus.getSeverity()) {
		case IStatus.OK:
			setErrorMessage(null);
			setMessage(numberStatus.getMessage());
			pageStatus = statusOK;
			break;
		case IStatus.WARNING:
			setErrorMessage(null);
			setMessage(numberStatus.getMessage(), WizardPage.WARNING);
			pageStatus = numberStatus;
			break;
		case IStatus.INFO:
			setErrorMessage(null);
			setMessage(numberStatus.getMessage(), WizardPage.INFORMATION);
			pageStatus = numberStatus;
			break;
		default:
			setErrorMessage(numberStatus.getMessage());
			setMessage(numberStatus.getMessage());
			pageStatus = numberStatus;
			break;
		}

		return pageStatus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#canFlipToNextPage()
	 */
	@Override
	public boolean canFlipToNextPage() {
		IStatus currentPageStatus = updatePageStatus();
		if (currentPageStatus.isOK() || currentPageStatus.matches(IStatus.INFO)) {
			((WarmupFilterWizard) getWizard()).setFinishable(true);
			return false;
		}
		((WarmupFilterWizard) getWizard()).setFinishable(false);
		return false;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#getNextPage()
	 */
	@Override
	public IWizardPage getNextPage() {
		return null;
	}

	/**
	 * Retrieves the values of the form, which are the properties of the
	 * {@link IAdapter} for whose setup this wizard page is responsible.
	 * 
	 * @return the properties
	 */
	public String[] getProperties() {
		String[] properties = new String[2];
		return properties;
	}

	public WarmupFilter getFilter() {
		// TODO Auto-generated method stub
		return new WarmupFilter(source, droppedValuesAbsolute, droppedValuesPercentage);
	}

}
