package de.uka.ipd.sdq.sensorframework.visualisation.views;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;

import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.dao.IExperimentDAO;

/**
 * Adapter class that supplies functionality applicable to Experiments
 */
class ExperimentsAdapter implements ISelectionChangedListener {

	private TreeViewer myChildTree;

	private Action myDeleteAction;
	private Action myRenameAction;

	public ExperimentsAdapter(TreeViewer childTree) {
		assert (childTree != null );
		myChildTree = childTree;
		createActions();
		myChildTree.addSelectionChangedListener(this);
	}

	/**
	 * Adds actions to the menu if the selection is a single experiment.
	 * This method is called every time the user right clicks to open
	 * a popup menu.
	 * @param manager the menu manager to add the actions to
	 */
	public void addNavigationActions(IMenuManager manager) {
		if (getSelectedExperiments().size() < 1){
			return;
		}
		
		//actions which only apply to selections containing experiments
		
		if (getCurrentSelection().size() == 1) {
			//action which only apply to a single distinctly selected experiment
			manager.add(myRenameAction);
		}
		
		
		manager.add(myDeleteAction);	
	}

	/**
	 * Adds actions to the toolbar which should then be enabled
	 * and disabled when the selection changes.
	 * @param toolbar the toolbar to add actions to
	 */
	public void addNavigationActions(IToolBarManager toolbar) {
		// don't add anything to the toolbar
	}

	public void selectionChanged(SelectionChangedEvent event) {
		updateNavigationButtons();		
	}

	private void createActions() {
		myRenameAction = new RenameAction();
		myDeleteAction = new DeleteAction();
	}

	/**
	 * enables or disables navigation buttons depending on the selection
	 * @param selection the current selection
	 */
	private void updateNavigationButtons() {
		// no toolbar items or context menu items that need to be updated
	}

	/** 
	 * returns the current selection as a structured selection
	 * @return the current selection or null if no elements are contained
	 */
	private IStructuredSelection getCurrentSelection() {
		//check if selection has objects
		if ( ! (myChildTree.getSelection() instanceof IStructuredSelection)) {
			return null;
		}

		return (IStructuredSelection)myChildTree.getSelection();
	}

	/**
	 * retrieves all currently selected Experiments
	 * @return a list of all currently selected experiments
	 */
	private List<Experiment> getSelectedExperiments() {
		List<Experiment> experiments = new LinkedList<Experiment>();

		//check if selection has objects
		if ( ! (myChildTree.getSelection() instanceof IStructuredSelection)) {
			return experiments;
		}

		IStructuredSelection selection = 
			(IStructuredSelection)myChildTree.getSelection();			

		Iterator<?> it = selection.iterator();
		while (it.hasNext()) {
			//add experiment to list, if we find one
			Object selectedObject = it.next();
			if (selectedObject instanceof ExperimentAndDAO) {
				experiments.add(((ExperimentAndDAO) selectedObject).getExperiment());
			}
		}

		return experiments;
	}
	
	private List<ExperimentAndDAO> getSelectedExperimentAndDAOs() {
		List<ExperimentAndDAO> exAndDAOs = new LinkedList<ExperimentAndDAO>();

		//check if selection has objects
		if ( ! (myChildTree.getSelection() instanceof IStructuredSelection)) {
			return exAndDAOs;
		}

		IStructuredSelection selection = 
			(IStructuredSelection)myChildTree.getSelection();			

		Iterator<?> it = selection.iterator();
		while (it.hasNext()) {
			//add experiment to list, if we find one
			Object selectedObject = it.next();
			if (selectedObject instanceof ExperimentAndDAO) {
				exAndDAOs.add((ExperimentAndDAO) selectedObject);
			}
		}

		return exAndDAOs;
	}
	
	/**
	 * Action that deletes all selected Experiments and their contents.
	 * Note: Currently Experiments are stored as part of ExperimentAndDAO, so
	 * these will be deleted instead of just the experiment.
	 */
	private class DeleteAction extends Action {
		public DeleteAction() {
			super();
			setText("Delete");
			setToolTipText("Delete Experiment");
			setEnabled(true);
		}
		
		@Override
		public void run() {
			List<ExperimentAndDAO> exAndDAOs = getSelectedExperimentAndDAOs();
			
			//delete all selected exAndDAOs
			Iterator<ExperimentAndDAO> it = exAndDAOs.iterator();
			while (it.hasNext()) {
				ExperimentAndDAO toDel = it.next();
				IExperimentDAO dao = toDel.getDatasource().createExperimentDAO();
				dao.removeExperiment(toDel.getExperiment(), true);
				myChildTree.remove(toDel);
			}
		}
	}

	/**
	 * Action that pops up a dialog to rename an experiment.
	 * Only runs, if exacly one experiment and nothing else is selected. 
	 */
	private class RenameAction extends Action {
		public RenameAction() {
			super();
			setText("Rename");
			setToolTipText("Rename Experiment");
			setEnabled(true);
		}

		@Override
		public void run() {
			//check if only a single element has been selected
			if (getCurrentSelection().size() != 1) {
				return;
			}
			
			List<ExperimentAndDAO> expAndDAOs = getSelectedExperimentAndDAOs();
			if (expAndDAOs.isEmpty()) {
				return;
			}
			
			//get the first (and only) selected experiment
			Experiment experiment = expAndDAOs.get(0).getExperiment();
			
			//ask the user for a new name
			InputDialog dlg = new InputDialog(Display.getCurrent().getActiveShell(),
		            "Rename experiment", "Enter the new experiment name!", experiment.getExperimentName(), new NameValidator());
		    if (dlg.open() == Window.OK) {
		        experiment.setExperimentName(dlg.getValue());
		        
		        myChildTree.refresh();
		    }
		}
		
		private class NameValidator implements IInputValidator {
			
			public String isValid(String newText) {
				if ( newText == "" ) {
					return "Please enter a name!";
				}
				
				return null;
			}
			
		}
	}
}