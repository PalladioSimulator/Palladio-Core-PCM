/**
 * 
 */
package de.uka.ipd.sdq.edp2.transformation.adapter;

import java.util.HashMap;
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
import de.uka.ipd.sdq.edp2.visualization.AbstractAdapter;
import de.uka.ipd.sdq.edp2.visualization.AbstractDataSource;

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

	private static final Logger logger = Logger
			.getLogger(HistogramFrequencyAdapterSettingsPage.class
					.getCanonicalName());
	AbstractDataSource source;
	IStatus selectionStatus;
	List dataSeriesList;
	Status statusOK;

	public HistogramFrequencyAdapterSettingsPage(AbstractDataSource source) {
		super(PAGE_NAME);
		this.source = source;
		// initialize defaults
		setDescription("Choose the settings for the Histogram.");
		statusOK = new Status(IStatus.OK, "not_used", 0, "", null);
		selectionStatus = statusOK;
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
				.toBaseMetricDescriptions(source.getMeasurementsRange()
						.getMeasurements().getMeasure().getMetric());
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
			setMessage(selectionStatus.getMessage());
			pageStatus = selectionStatus;
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
	 * Creates the adapter from the data on the form.
	 * 
	 * @return a new {@link HistogramFrequencyAdapter}
	 */
	public HistogramFrequencyAdapter getAdapter() {
		logger.log(Level.INFO, "AdapterSettingsPage returned non-null adapter");
		HistogramFrequencyAdapter adapter = new HistogramFrequencyAdapter();
		HashMap<String, Object> properties = adapter.getProperties();
		properties.put("dataSeriesIndex",
				dataSeriesList.getSelectionIndex());
		adapter.setProperties(properties);
		adapter.setSource(source);
		return adapter;
	}

}
