package de.uka.ipd.sdq.codegen.workflow;

import java.util.LinkedList;
import java.util.Stack;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;


/**
 * Implementation of a workflow.
 * The given Progress Monitor will receive updates before and after a
 * job is executed.
 * 
 * @author Philipp Meier
 */
public class Workflow
	implements IWorkflow {
	private LinkedList<IJob> myJobs;
	private Stack<IJob> myExecutedJobs;
	private IProgressMonitor myMonitor;

	/** 
	 * @param monitor the progress monitor to use
	 */
	public Workflow(IProgressMonitor monitor) {
		myJobs = new LinkedList<IJob>();
		myExecutedJobs = new Stack<IJob>();

		if (monitor != null) {
			myMonitor = monitor;
		} else {
			myMonitor = new NullProgressMonitor();
		}
	}

	public void run() throws JobFailedException, UserCanceledException {
		myMonitor.beginTask("Workflow", myJobs.size());
		
		for (IJob job : myJobs) {
			if (myMonitor.isCanceled()) {
				throw new UserCanceledException("User canceled through progress monitor.");
			}

			myMonitor.subTask(job.getName());
			myExecutedJobs.push(job);
			job.execute();
			myMonitor.worked(1);
		}
		
		myMonitor.done();
	}

	public void rollback() throws RollbackFailedException {
		while (!myExecutedJobs.empty()) {
			myExecutedJobs.pop().rollback();
		}
	}

	public void addJob(IJob job) {
		if (job != null) {
			myJobs.add(job);
		}
	}
}
