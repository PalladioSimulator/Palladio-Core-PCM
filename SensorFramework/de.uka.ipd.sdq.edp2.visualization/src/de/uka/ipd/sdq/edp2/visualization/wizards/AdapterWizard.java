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
import de.uka.ipd.sdq.edp2.visualization.AbstractAdapter;
import de.uka.ipd.sdq.edp2.visualization.AbstractDataSource;

/**
 * The main wizard, which shows available adapters for the currently selected {@link RawMeasurements}. 
 * @author Dominik Ernst
 * 
 */
public class AdapterWizard extends Wizard implements INewWizard {
	
	/**
	 * The page, which displays the list of adapters.
	 */
	SelectAdapterPage selectAdapterPage;
	/**
	 * The source, which is associated with the selected RawMeasurements.
	 */
	AbstractDataSource source;
	/**
	 * Variable to indicate, if the user is allowed to finish the Wizard.
	 */
	boolean finishable;
	/**
	 * The adapter, which is to be created by the Wizard (passed reference from nested Wizard).
	 */
	AbstractAdapter createdAdapter;

	public boolean isFinishable() {
		return finishable;
	}

	public void setFinishable(boolean finishable) {
		this.finishable = finishable;
	}

	/**
	 * 
	 */
	public AdapterWizard(AbstractDataSource source) {
		setWindowTitle("Add a new Adapter");
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
		selectAdapterPage = new SelectAdapterPage("Add a new Adapter..", source);
		addPage(selectAdapterPage);
	}

	@Override
	public boolean needsPreviousAndNextButtons() {
		return true;
	}

	@Override
	public void createPageControls(Composite pageContainer) {
		super.createPageControls(pageContainer);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {

	}

	@Override
	public boolean canFinish() {
		return finishable;
	}

	public AbstractAdapter getAdapter() {
		return createdAdapter;
	}
	
	public void setAdapter(AbstractAdapter adapter) {
		this.createdAdapter = adapter;
	}

}
