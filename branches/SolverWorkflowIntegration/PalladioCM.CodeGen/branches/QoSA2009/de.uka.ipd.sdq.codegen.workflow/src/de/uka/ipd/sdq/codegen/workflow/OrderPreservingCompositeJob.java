package de.uka.ipd.sdq.codegen.workflow;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Implementation of a composite job that guarantees
 * the execution of it's jobs in the order they were added.
 * 
 * @author Philipp Meier
 */

public class OrderPreservingCompositeJob implements ICompositeJob {
	
	protected LinkedList<IJob> myJobs;
	protected Stack<IJob> myExecutedJobs;
	
	/**
	 * constructor
	 */
	public OrderPreservingCompositeJob() {
		myJobs = new LinkedList<IJob>();
		myExecutedJobs = new Stack<IJob>();
	}

	public void addJob(IJob job) {
		if (job != null) {
			myJobs.add(job);
		}
	}

	/** 
	 * Executes all contained jobs, i.e. call execute() for them. Contained 
	 * jobs can thus re-implement this method with functionality that should 
	 * be executed.
	 */ 
	public void execute() throws JobFailedException, UserCanceledException {
		for (IJob job : myJobs) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			myExecutedJobs.push(job);
			job.execute();
		}
	}

	public String getName() {
		String compositeName = "";
		for(IJob job:myJobs) {
			compositeName += job.getName() + " ";
		}
		
		return compositeName;
	}

	public void rollback() throws RollbackFailedException {
		while (!myExecutedJobs.empty()) {
			myExecutedJobs.pop().rollback();
		}
	}
}
