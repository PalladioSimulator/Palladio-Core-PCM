package de.uka.ipd.sdq.edp2.transformation.filter;

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
import de.uka.ipd.sdq.edp2.visualization.wizards.FilterWizard;
import de.uka.ipd.sdq.edp2.visualization.wizards.IAdapterWizard;
import de.uka.ipd.sdq.edp2.visualization.wizards.IFilterWizard;
import de.uka.ipd.sdq.edp2.visualization.wizards.SelectAdapterPage;
import de.uka.ipd.sdq.edp2.visualization.wizards.SelectFilterPage;

/**
 * The wizard for creating a {@link WarmupFilter}. It is referenced in
 * the central {@link FilterWizard}. Receives the information on the
 * {@link AbstractDataSource} for which the filter is created from
 * {@link #setSourceFromCaller(AbstractDataSource, SelectFilterPage)}. If the wizard
 * is finished, it uses
 * {@link SelectFilterPage#setFilter(de.uka.ipd.sdq.edp2.visualization.IFilter)}
 * to pass the reference on to the central {@link FilterWizard}.
 * 
 * @author Dominik Ernst
 * 
 */
public class WarmupFilterWizard extends Wizard implements
		IFilterWizard, IExecutableExtension {

	private static final Logger logger = Logger
			.getLogger(WarmupFilterWizard.class.getCanonicalName());
	private static final String WINDOW_TITLE = "Warmup Filter";
	WarmupFilterSettingsPage settingsFilterPage;
	AbstractDataSource source;
	boolean finishable;
	WarmupFilter createdFilter;
	SelectFilterPage callingWizardPage;

	public boolean isFinishable() {
		return finishable;
	}

	public void setFinishable(boolean finishable) {
		this.finishable = finishable;
	}

	/**
	 * Default constructor for creation of elements from extension point.
	 */
	public WarmupFilterWizard() {
		setWindowTitle(WINDOW_TITLE);
		this.finishable = false;
	}

	/**
	 * Constructor for intra-project usage.
	 */
	public WarmupFilterWizard(AbstractDataSource source,
			SelectFilterPage selectFilterPage) {
		setWindowTitle(WINDOW_TITLE);
		this.finishable = false;
		setSourceFromCaller(source, selectFilterPage);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		if (canFinish()) {
			createdFilter = settingsFilterPage.getFilter();
			callingWizardPage.setFilter(createdFilter);
			callingWizardPage.getWizard().performFinish();
			return true;
		}
		return false;
	}

	@Override
	public void addPages() {
		settingsFilterPage = new WarmupFilterSettingsPage(source);
		addPage(settingsFilterPage);
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

	public WarmupFilter getFilter() {
		logger.log(Level.INFO, "FilterWizard returned non-null Filter");
		return createdFilter;
	}

	@Override
	public void setInitializationData(IConfigurationElement config,
			String propertyName, Object data) throws CoreException {
		// TODO Auto-generated method stub
	}

	@Override
	public void setSourceFromCaller(AbstractDataSource source,
			SelectFilterPage selectFilterPage) {
		this.source = source;
		this.callingWizardPage = selectFilterPage;
	}

}
