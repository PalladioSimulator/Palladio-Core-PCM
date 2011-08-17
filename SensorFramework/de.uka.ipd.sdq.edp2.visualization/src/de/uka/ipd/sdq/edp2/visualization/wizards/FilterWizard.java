/**
 * 
 */
package de.uka.ipd.sdq.edp2.visualization.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import de.uka.ipd.sdq.edp2.models.ExperimentData.RawMeasurements;
import de.uka.ipd.sdq.edp2.visualization.IAdapter;
import de.uka.ipd.sdq.edp2.visualization.IDataSource;
import de.uka.ipd.sdq.edp2.visualization.IFilter;

/**
 * The main wizard, which shows available adapters for the currently selected {@link RawMeasurements}. 
 * @author Dominik Ernst
 * 
 */
public class FilterWizard extends Wizard implements INewWizard {
	
	/**
	 * The page, which displays the list of available filters.
	 */
	SelectFilterPage selectFilterPage;
	/**
	 * The source, which is associated with the selected RawMeasurements.
	 */
	IDataSource source;
	/**
	 * Variable to indicate, if the user is allowed to finish the Wizard.
	 */
	boolean finishable;
	/**
	 * The adapter, which is to be created by the Wizard (passed reference from nested Wizard).
	 */
	IFilter createdFilter;

	public boolean isFinishable() {
		return finishable;
	}

	public void setFinishable(boolean finishable) {
		this.finishable = finishable;
	}

	/**
	 * 
	 */
	public FilterWizard(IDataSource source) {
		setWindowTitle("Add a new Filter");
		this.source = source;
		this.finishable = false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		if (canFinish()) {
			return true;
		}
		return false;
	}
	
	@Override
	public void addPages() {
		selectFilterPage = new SelectFilterPage("Add a new Filter..", source);
		addPage(selectFilterPage);
	}

	@Override
	public boolean needsPreviousAndNextButtons() {
		return true;
	}

	@Override
	public void createPageControls(Composite pageContainer) {
		// TODO Auto-generated method stub
		super.createPageControls(pageContainer);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {

	}

	@Override
	public boolean canFinish() {
		return finishable;
	}

	public IFilter getFilter() {
		return createdFilter;
	}
	
	public void setFilter(IFilter filter) {
		this.createdFilter = filter;
	}

}
