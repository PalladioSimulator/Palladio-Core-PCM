/**
 * 
 */
package de.uka.ipd.sdq.codegen.simucontroller.actions;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;

import de.uka.ipd.sdq.codegen.simucontroller.SimuComJob;
import de.uka.ipd.sdq.codegen.simucontroller.SimuControllerPlugin;
import de.uka.ipd.sdq.codegen.simucontroller.views.SimuView;

/**
 * @author admin
 *
 */



public class ControllerActionDelegate implements IViewActionDelegate {

	public static String STARTACTION_ID = "StartAction";
	public static String STOPACTION_ID = "StopAction";
	
	private static final String PID = "de.uka.ipd.sdq.codegen.simucontroller";
	private static final String EPID = "controller";
	private IViewPart myView;
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IViewActionDelegate#init(org.eclipse.ui.IViewPart)
	 */
	public void init(IViewPart view) {
		myView = view;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {
		if (action.getId().equals(STARTACTION_ID)){
			findPlugin();
		}else if (action.getId().equals(STOPACTION_ID)){
		
		} 
	}
	
	public void findPlugin(){
		
		ISimuComControl control = null;
		
		for(IConfigurationElement configurationElement : Platform.getExtensionRegistry().
				getConfigurationElementsFor(PID+"."+EPID)){
				try {
					control = (ISimuComControl) configurationElement
							.createExecutableExtension("class");
				} catch (CoreException e) {
					SimuControllerPlugin.log(IStatus.ERROR, 
							"No simulation plugin found: "+e.getMessage());
				}
		}
		if (control != null){
//			Job simuJob = new SimuComJob(control,1,(SimuView)myView);
//			simuJob.setUser(false);
//			simuJob.schedule();
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction, org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	}

}
