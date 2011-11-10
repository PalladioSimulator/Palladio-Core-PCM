/**
 * 
 */
package de.uka.ipd.sdq.edp2.transformation.adapter;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Composite;

import de.uka.ipd.sdq.edp2.visualization.AbstractDataSource;
import de.uka.ipd.sdq.edp2.visualization.wizards.AdapterWizard;
import de.uka.ipd.sdq.edp2.visualization.wizards.IAdapterWizard;
import de.uka.ipd.sdq.edp2.visualization.wizards.SelectAdapterPage;

/**
 * The wizard for creating a {@link HistogramFrequencyAdapter}. Is referenced in
 * the central {@link AdapterWizard}. Receives the information on the
 * {@link AbstractDataSource} for which the Adapter is created from
 * {@link #setSourceFromCaller(AbstractDataSource, SelectAdapterPage)}. If the wizard
 * is finished, it uses
 * {@link SelectAdapterPage#setAdapter(de.uka.ipd.sdq.edp2.visualization.IAdapter)}
 * to pass the reference on to the central {@link AdapterWizard}.
 * 
 * @author Dominik Ernst
 * 
 */
public class HistogramFrequencyAdapterWizard extends Wizard implements
		IAdapterWizard, IExecutableExtension {

	private static final Logger logger = Logger
			.getLogger(HistogramFrequencyAdapterWizard.class.getCanonicalName());
	private static final String WINDOW_TITLE = "Histogram Frequency Adapter";
	HistogramFrequencyAdapterSettingsPage settingsAdapterPage;
	AbstractDataSource source;
	boolean finishable;
	HistogramFrequencyAdapter createdAdapter;
	SelectAdapterPage callingWizardPage;

	public boolean isFinishable() {
		return finishable;
	}

	public void setFinishable(boolean finishable) {
		this.finishable = finishable;
	}

	/**
	 * Default constructor for creation of elements from extension point.
	 */
	public HistogramFrequencyAdapterWizard() {
		setWindowTitle(WINDOW_TITLE);
		this.finishable = false;
	}

	/**
	 * Constructor for intra-project usage.
	 */
	public HistogramFrequencyAdapterWizard(AbstractDataSource source,
			SelectAdapterPage selectAdapterPage) {
		setWindowTitle(WINDOW_TITLE);
		this.finishable = false;
		setSourceFromCaller(source, selectAdapterPage);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		if (canFinish()) {
			createdAdapter = settingsAdapterPage.getAdapter();
			callingWizardPage.setAdapter(createdAdapter);
			callingWizardPage.getWizard().performFinish();
			return true;
		}
		return false;
	}

	@Override
	public void addPages() {
		settingsAdapterPage = new HistogramFrequencyAdapterSettingsPage(source);
		addPage(settingsAdapterPage);
	}

	@Override
	public void createPageControls(Composite pageContainer) {
		// TODO Auto-generated method stub
		super.createPageControls(pageContainer);
	}

	@Override
	public boolean canFinish() {
		return finishable;
	}

	public HistogramFrequencyAdapter getAdapter() {
		logger.log(Level.INFO, "HistogramWizard returned non-null adapter");
		return createdAdapter;
	}

	@Override
	public void setInitializationData(IConfigurationElement config,
			String propertyName, Object data) throws CoreException {
		// TODO Auto-generated method stub
	}

	@Override
	public void setSourceFromCaller(AbstractDataSource source,
			SelectAdapterPage selectAdapterPage) {
		this.source = source;
		this.callingWizardPage = selectAdapterPage;

	}

}
