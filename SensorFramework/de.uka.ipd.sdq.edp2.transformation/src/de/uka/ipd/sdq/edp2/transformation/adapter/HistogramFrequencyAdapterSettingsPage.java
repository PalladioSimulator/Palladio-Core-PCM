/**
 * 
 */
package de.uka.ipd.sdq.edp2.transformation.adapter;

import java.util.logging.Level;
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
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import de.uka.ipd.sdq.edp2.impl.MetricDescriptionUtility;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricDescription;
import de.uka.ipd.sdq.edp2.visualization.IAdapter;
import de.uka.ipd.sdq.edp2.visualization.IDataSource;

/**
 * A {@link WizardPage}, which provides the settings for
 * {@link HistogramFrequencyAdapter} elements. Can be used as a template for
 * other Wizards.
 * 
 * @author Dominik Ernst
 * 
 */
public class HistogramFrequencyAdapterSettingsPage extends WizardPage implements
		Listener {

	private final static String PAGE_NAME = "Histogram Frequency Adapter Settings";
	private final static int DEFAULT_NUMBER_BINS = 5;
	private static final Logger logger = Logger
			.getLogger(HistogramFrequencyAdapterSettingsPage.class
					.getCanonicalName());
	IDataSource source;
	IStatus selectionStatus;
	IStatus binStatus;
	List dataSeriesList;
	Text binText;
	int numberBins;
	Status statusOK;

	public HistogramFrequencyAdapterSettingsPage(IDataSource source) {
		super(PAGE_NAME);
		this.source = source;
		// initialize defaults
		setDescription("Choose the settings for the Histogram.");
		numberBins = DEFAULT_NUMBER_BINS;
		statusOK = new Status(IStatus.OK, "not_used", 0, "", null);
		selectionStatus = statusOK;
		binStatus = statusOK;
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

		if (event.widget == dataSeriesList) {
			selectionStatus = statusOK;
			if (dataSeriesList.getSelectionCount() == 0) {
				selectionStatus = new Status(IStatus.ERROR, "not_used", 0,
						"Must select a Series of Data to proceed.", null);
			}
		}
		if (event.widget == binText) {
			binStatus = statusOK;
			try {
				numberBins = Integer.parseInt(binText.getText());
			} catch (NumberFormatException nfe) {
				binStatus = new Status(IStatus.ERROR, "not_used", 0,
						"Not a valid number.", null);
				numberBins = 5;
			}
			binText.setText("" + numberBins);
			if (numberBins < 2) {
				binStatus = new Status(
						IStatus.INFO,
						"not_used",
						0,
						"The number of bins is 1, should be > 1 to receive a meaningful output.",
						null);
			}
			if (numberBins < 1) {
				binStatus = new Status(IStatus.ERROR, "not_used", 0,
						"The number of bins must be positive.", null);
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

		// set the layout of the composite
		GridLayout gl = new GridLayout();
		int ncol = 2;
		gl.numColumns = ncol;
		composite.setLayout(gl);

		// create the widgets on the composite
		Label seriesLabel = new Label(composite, SWT.NONE);
		seriesLabel.setText("Data Series:");

		dataSeriesList = new List(composite, SWT.BORDER | SWT.READ_ONLY);

		// gets labels of the different data series in the source
		MetricDescription[] mds = MetricDescriptionUtility
				.toBaseMetricDescriptions(source.getMeasurementsRange().getMeasurements().getMeasure().getMetric());
		for (int i = 0; i < mds.length; i++) {
			dataSeriesList.add(mds[i].getName());
		}

		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = ncol;
		dataSeriesList.setLayoutData(gd);
		dataSeriesList.addListener(SWT.Selection, this);

		// set the composite as the control for this page
		setControl(composite);
		setPageComplete(true);

		// create another widget
		Label binLabel = new Label(composite, SWT.NONE);
		binLabel.setText("Number of bins:");
		binText = new Text(composite, SWT.BORDER);
		binText.setTabs(5);
		binText.setText("" + numberBins);
		binText.addListener(SWT.Deactivate, this);
	}

	/**
	 * Updates the overall status of this page.
	 * 
	 * @return the new page status ({@link IStatus})
	 */
	public IStatus updatePageStatus() {
		IStatus pageStatus = statusOK;
		switch (selectionStatus.getSeverity()) {
		case IStatus.OK:
			setErrorMessage(null);
			setMessage(selectionStatus.getMessage());
			pageStatus = statusOK;
			break;
		case IStatus.WARNING:
			setErrorMessage(null);
			setMessage(selectionStatus.getMessage(), WizardPage.WARNING);
			pageStatus = selectionStatus;
			break;
		case IStatus.INFO:
			setErrorMessage(null);
			setMessage(selectionStatus.getMessage(), WizardPage.INFORMATION);
			pageStatus = selectionStatus;
			break;
		default:
			setErrorMessage(selectionStatus.getMessage());
			setMessage(binStatus.getMessage());
			pageStatus = selectionStatus;
			break;
		}
		switch (binStatus.getSeverity()) {
		case IStatus.OK:
			setErrorMessage(null);
			setMessage(binStatus.getMessage());
			pageStatus = statusOK;
			break;
		case IStatus.WARNING:
			setErrorMessage(null);
			setMessage(binStatus.getMessage(), WizardPage.WARNING);
			pageStatus = binStatus;
			break;
		case IStatus.INFO:
			setErrorMessage(null);
			setMessage(binStatus.getMessage(), WizardPage.INFORMATION);
			pageStatus = binStatus;
			break;
		default:
			setErrorMessage(binStatus.getMessage());
			setMessage(binStatus.getMessage());
			pageStatus = binStatus;
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
			((HistogramFrequencyAdapterWizard) getWizard()).setFinishable(true);
			return false;
		}
		((HistogramFrequencyAdapterWizard) getWizard()).setFinishable(false);
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
		properties[0] = "" + dataSeriesList.getSelectionIndex();
		properties[1] = binText.getText();
		return properties;
	}

	/**
	 * Creates the adapter from the data on the form.
	 * 
	 * @return a new {@link HistogramFrequencyAdapter}
	 */
	public HistogramFrequencyAdapter getAdapter() {
		logger.log(Level.INFO, "AdapterSettingsPage returned non-null adapter");
		return new HistogramFrequencyAdapter(source, Integer
				.parseInt(getProperties()[0]), numberBins);
	}

}
