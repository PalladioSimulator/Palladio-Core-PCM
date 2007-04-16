package de.uka.ipd.sdq.codegen.simucontroller.actions;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.jface.dialogs.MessageDialog;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;

import de.uka.ipd.sdq.codegen.simucontroller.SimuControllerPlugin;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.CreatePluginProject;

/**
 * Our sample action implements workbench action delegate.
 * The action proxy will be created by the workbench and
 * shown in the UI. When the user tries to use the action,
 * this delegate will be created and execution will be 
 * delegated to it.
 * @see IWorkbenchWindowActionDelegate
 */
public class GeneratePluginAction implements IWorkbenchWindowActionDelegate {
	private IWorkbenchWindow window;
	
	private static final String PID = "de.uka.ipd.sdq.codegen.simucontroller";
	private static final String PT_ID = PID + "." + "controller";
	/**
	 * The constructor.
	 */
	public GeneratePluginAction() {
	}

	/**
	 * The action has been activated. The argument of the
	 * method represents the 'real' action sitting
	 * in the workbench UI.
	 * @see IWorkbenchWindowActionDelegate#run
	 */
	public void run(IAction action) {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(
				CreatePluginProject.PROJECT_ID);

		String location = project.getLocationURI().toString();
		
		BundleContext bundleContext = SimuControllerPlugin.getDefault().getBundle().getBundleContext();

		try {
			Bundle bundle = bundleContext.installBundle(location);
			bundle.start();
			bundle.update();
			
		} catch (BundleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		IConfigurationElement[] elements = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(
						SimuControllerPlugin.PLUGIN_ID + ".controller");
	}

	/**
	 * Selection in the workbench has been changed. We 
	 * can change the state of the 'real' action here
	 * if we want, but this can only happen after 
	 * the delegate has been created.
	 * @see IWorkbenchWindowActionDelegate#selectionChanged
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	}

	/**
	 * We can use this method to dispose of any system
	 * resources we previously allocated.
	 * @see IWorkbenchWindowActionDelegate#dispose
	 */
	public void dispose() {
	}

	/**
	 * We will cache window object in order to
	 * be able to provide parent shell for the message dialog.
	 * @see IWorkbenchWindowActionDelegate#init
	 */
	public void init(IWorkbenchWindow window) {
		this.window = window;
	}
}