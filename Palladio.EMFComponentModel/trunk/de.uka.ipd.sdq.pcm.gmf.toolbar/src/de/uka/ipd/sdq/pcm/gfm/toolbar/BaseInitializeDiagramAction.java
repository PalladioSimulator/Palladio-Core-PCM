package de.uka.ipd.sdq.pcm.gfm.toolbar;

import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IObjectActionDelegate;

/**
 * Baseclass for the inizialize diagram actions.
 * A factory method is used to retrieve the init diagram action
 * of the appropriate package.
 * 
 * @author Philipp Meier
 */
public abstract class BaseInitializeDiagramAction 
	extends BaseDiagramAction {
	
	public void run(IAction action) {
		
		IObjectActionDelegate initAction = getInitAction();
		assert(action != null);
		
		initAction.selectionChanged(
				action, 
				getWindow().getSelectionService().getSelection());
		initAction.setActivePart(
				action, 
				getWindow().getPartService().getActivePart());
		initAction.run(action);	
	}
	
	/**
	 * template method for the init actino to run
	 * @return the init action to run. must not be null
	 */
	abstract protected IObjectActionDelegate getInitAction();
}
