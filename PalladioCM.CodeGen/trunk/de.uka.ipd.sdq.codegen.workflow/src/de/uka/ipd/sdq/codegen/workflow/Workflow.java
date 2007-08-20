package de.uka.ipd.sdq.codegen.workflow;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

/**
 * Implementation of a workflow.
 * The given Progress Monitor will receive updates before and after a
 * job is executed.
 * 
 * @author Philipp Meier
 */
public class Workflow extends OrderPreservingCompositeJob
	implements IWorkflow {
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
