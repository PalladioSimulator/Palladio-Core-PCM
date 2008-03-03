package de.uka.ipd.sdq.codegen.workflow;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

/**
 * Implementation of a workflow. A workflow is a special composite job which executes all other jobs while displaying the progress in a progress
 * bar to the user.
 * The given Progress Monitor will receive updates before and after a
 * job is executed.
 * 
 * @author Philipp Meier
 * 		   Steffen Becker
 */
public class Workflow 
	extends OrderPreservingCompositeJob
	implements ICompositeJob {
	
	private IProgressMonitor myMonitor;

	/** 
	 * @param monitor the progress monitor to use
	 */
	public Workflow(IProgressMonitor monitor) {
		if (monitor != null) {
			myMonitor = monitor;
		} else {
			myMonitor = new NullProgressMonitor();
		}
	}

	public void run() throws JobFailedException, UserCanceledException {
		myMonitor.beginTask("Workflow", 1);		
		myMonitor.subTask(this.getName());	
		
		this.execute();
		
		myMonitor.worked(1);		
		myMonitor.done();
	}
}
