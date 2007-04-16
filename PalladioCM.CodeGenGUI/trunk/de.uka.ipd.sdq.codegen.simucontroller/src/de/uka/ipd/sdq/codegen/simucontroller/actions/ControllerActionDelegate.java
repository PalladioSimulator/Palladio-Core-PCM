/**
 * 
 */
package de.uka.ipd.sdq.codegen.simucontroller.actions;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.dynamichelpers.IExtensionTracker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PlatformUI;

/**
 * @author admin
 *
 */
public class ControllerActionDelegate implements IViewActionDelegate {

	public static String STARTACTION_ID = "StartAction";
	public static String STOPACTION_ID = "StopAction";
	
	private static final String PID = "de.uka.ipd.sdq.codegen.simucontroller";
	private static final String EPID = "controller";
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IViewActionDelegate#init(org.eclipse.ui.IViewPart)
	 */
	@Override
	public void init(IViewPart view) {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	@Override
	public void run(IAction action) {
		if (action.getId().equals(STARTACTION_ID)){
			findPlugin();
		}else if (action.getId().equals(STOPACTION_ID)){
		
		}
	}
	
	public void findPlugin(){
		
		ISimuComControl control = null;
		
		IExtensionTracker tracker = PlatformUI.getWorkbench()
				.getExtensionTracker();
		IExtensionPoint point = Platform.getExtensionRegistry()
				.getExtensionPoint(PID, EPID);
		
		IExtension[] extensions = point.getExtensions();
		for (int i = 0; i < extensions.length; i++) {
			IConfigurationElement[] elements = extensions[i]
					.getConfigurationElements();
			for (int j = 0; j < elements.length; j++) {
				try {
					control = (ISimuComControl) elements[j]
							.createExecutableExtension("class");
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if (control != null)
			control.StartSimulation();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction, org.eclipse.jface.viewers.ISelection)
	 */
	@Override
	public void selectionChanged(IAction action, ISelection selection) {
	}

}
