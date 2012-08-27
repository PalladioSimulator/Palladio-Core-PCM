/**
 * 
 */
package de.uka.ipd.sdq.edp2.visualization.wizards;

import java.util.logging.Logger;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import de.uka.ipd.sdq.edp2.visualization.AbstractDataSource;

/**
 * A wizard which is opened upon selection/doubleclick on an element containing Experiment Data.
 * Provides possible "Default-Combinations" of Filter/Adapter/Editor which allows to visualize the
 * the selected Data in a appropriate way.
 * @author Dominik Ernst
 * 
 */
public class DefaultViewsWizard extends Wizard implements INewWizard {
	
	private final static Logger logger = Logger.getLogger(DefaultViewsWizard.class.getName());
	/**
	 * The page, which displays the list of available filters.
	 */
	SelectDefaultCombinationsPage selectCombinationsPage;
	/**
	 * The source, which is associated with the selected RawMeasurements.
	 */
	AbstractDataSource source;
	/**
	 * Variable to indicate, if the user is allowed to finish the Wizard.
	 */
	boolean finishable;
	
	/**
	 * The default-combination, which was selected by the user.
	 */
	DefaultSequence selectedDefault;

	/**
	 * Sets the <finishable> attribute to the specified value.
	 * @param finishable a boolean value
	 */
	public void setFinishable(boolean finishable) {
		this.finishable = finishable;
	}

	/**
	 * Constructor assigning the source and assuring the wizard cannot be finished instantly.
	 */
	public DefaultViewsWizard(AbstractDataSource source) {
		setWindowTitle("Select a Visualization");
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
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {
		selectCombinationsPage = new SelectDefaultCombinationsPage("Select a Visualization", source);
		addPage(selectCombinationsPage);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#needsPreviousAndNextButtons()
	 */
	@Override
	public boolean needsPreviousAndNextButtons() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#createPageControls(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPageControls(Composite pageContainer) {
		super.createPageControls(pageContainer);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#canFinish()
	 */
	@Override
	public boolean canFinish() {
		return finishable;
	}
	
	/**
	 * @return the selected Default-combination
	 */
	public DefaultSequence getSelectedDefault() {
		return selectedDefault;
	}

	/**
	 * @param selectedDefault the selectedDefault to set
	 */
	public void setSelectedDefault(DefaultSequence selectedDefault) {
		this.selectedDefault = selectedDefault;
	}

}
