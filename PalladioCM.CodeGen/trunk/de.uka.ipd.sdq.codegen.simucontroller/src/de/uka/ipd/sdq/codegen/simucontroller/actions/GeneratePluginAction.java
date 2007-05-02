package de.uka.ipd.sdq.codegen.simucontroller.actions;

import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.openarchitectureware.workflow.WorkflowRunner;
import org.openarchitectureware.workflow.monitor.NullProgressMonitor;
import org.osgi.framework.Bundle;

import de.uka.ipd.sdq.codegen.simucontroller.SimuControllerPlugin;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.GeneratedPluginHandling;

/**
 * Our sample action implements view action delegate.
 * The action proxy will be created by the view and
 * shown in the UI. When the user tries to use the action,
 * this delegate will be created and execution will be 
 * delegated to it.
 * @see IWorkbenchWindowActionDelegate
 */
public class GeneratePluginAction implements IViewActionDelegate {
	

	private IProgressMonitor monitor;
	private Map<String, String> properties;
	
	private boolean status = true;
	
	/**
	 * workflow files
	 */
	public static String REPOSITORY_FILE 	= "codegen_repository.oaw";
	public static String SYSTEM_FILE 		= "codegen_system.oaw";
	public static String USAGE_FILE 		= "codegen_usage.oaw";
	public static String TEMPLATE_METHODS 	= "simulation_template_methods";

	public static String[] workflowFiles = { REPOSITORY_FILE, SYSTEM_FILE,
			USAGE_FILE };
	
	
	/**
	 * The constructor.
	 */
	public GeneratePluginAction(Map<String, String> properties ,IProgressMonitor monitor) {
		this.monitor = monitor;
		this.properties = properties;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {

		Map<String, Object> slotContents = new HashMap<String, Object>();
		GeneratedPluginHandling pluginHandling = GeneratedPluginHandling
				.create(monitor);

		MessageConsole console = new MessageConsole(
				"SimuComController Generator Console", null);
		console.activate();
		ConsolePlugin.getDefault().getConsoleManager().addConsoles(
				new IConsole[] { console });
		MessageConsoleStream stream = console.newMessageStream();
		PrintStream outStream = System.out;
		System.setOut(new PrintStream(stream));
		System.out.println("Running oAW Generator");
		pluginHandling.setMonitorBeginTask("Simulation Run");
		try {
			pluginHandling.setMonitorSubTask("Generate Code");
			for (int i = 0; i < workflowFiles.length; i++)
				status &= runWorkflowRunner(workflowFiles[i], properties,
						slotContents);
			pluginHandling.monitorWorked();
		} catch (CoreException e) {
			pluginHandling.setLogMessage("Codegen failed: ", e);
		} finally {
			System.setOut(outStream);
			ConsolePlugin.getDefault().getConsoleManager().removeConsoles(
					new IConsole[] { console });
		}
	}

	/**
	 * Start the Workflow-Engine of oAW - Generator
	 * 
	 * @param workflowFile - *.oaw
	 * @param properties - HashMap with workflow properties
	 * 
	 * @return code generate status
	 */
	public boolean runWorkflowRunner(String workflowFile,
			Map<String, String> properties, Map<String, Object> slotContents)
			throws CoreException, JavaModelException {
		
		WorkflowRunner runner = new WorkflowRunner();
		return runner.run(workflowFile, new NullProgressMonitor(), properties,
				slotContents);
	}

	/**
	 * This function return the workflow file from Plug-In location.
	 */
	public String getWorkflowFile(String fileName) {
		Bundle pluginBundle = SimuControllerPlugin.getDefault().getBundle();

		// where plugin is of type org.eclipse.core.runtime.Plugin:
		URL url = FileLocator.find(pluginBundle, new Path(fileName), null);

		if (url != null)
			try {
				url = FileLocator.resolve(url);
			} catch (IOException e) {
				e.printStackTrace();
			}
		return url.getFile().replaceFirst("/", "");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IViewActionDelegate#init(org.eclipse.ui.IViewPart)
	 */
	public void init(IViewPart view) {
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction, org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub
		
	}
}