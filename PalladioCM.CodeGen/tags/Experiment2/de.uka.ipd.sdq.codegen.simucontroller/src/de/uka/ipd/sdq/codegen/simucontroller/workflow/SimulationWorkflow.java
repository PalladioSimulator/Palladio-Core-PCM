package de.uka.ipd.sdq.codegen.simucontroller.workflow;

import java.util.LinkedList;
import java.util.Stack;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;

import de.uka.ipd.sdq.codegen.simucontroller.SimuControllerPlugin;

/**
 * Class that manages the execution and rollback of a number of Jobs.
 * The jobs are executed in the order they are added to the workflow.
 * A rollback will affect all Jobs which have been executed.
 * The given Progress Monitor will receive updates before and after a
 * job is executed. 
 */

public class SimulationWorkflow {
	private LinkedList<ISimulationJob> myJobs;
	private Stack<ISimulationJob> myExecutedJobs;
	private IProgressMonitor myMonitor;

	public SimulationWorkflow(IProgressMonitor monitor) {
		myJobs = new LinkedList<ISimulationJob>();
		myExecutedJobs = new Stack<ISimulationJob>();

		if (monitor != null) {
			myMonitor = monitor;
		} else {
			myMonitor = new NullProgressMonitor();
		}
	}

	/**
	 * Start the workflow. The jobs will be executed in the order
	 * they were added to the workflow. Exceptions will be logged
	 * and then thrown again.
	 * 
	 * @throws Exception
	 */
	public void run() throws Exception {
		myMonitor.beginTask("Simulation Run", myJobs.size());
		boolean shouldContinue = true; 
		for (ISimulationJob job : myJobs) {
			try {
				if (myMonitor.isCanceled() || !shouldContinue) {
					return;
				}

				myMonitor.subTask(job.getName());
				myExecutedJobs.push(job);
				if (job.execute() == false)
					shouldContinue = false;
				myMonitor.worked(1);

			} catch (Exception e) {
				SimuControllerPlugin.log(IStatus.ERROR, e.getMessage());
				throw e;
			}
		}

		myMonitor.done();
	}

	/**
	 * Trigger a rollback of all jobs which have been executed.
	 * Exceptions will be logged and thrown again.
	 * 
	 * @throws Exception
	 */
	public void rollback() throws Exception {
		while (!myExecutedJobs.empty()) {
			try {
				myExecutedJobs.pop().rollback();
			} catch (Exception e) {
				SimuControllerPlugin.log(IStatus.ERROR, e.getMessage());
				throw e;
			}
		}
	}

	/**
	 * adds a job to the workflow
	 * @param job the job to add to the workflow
	 */
	public void addJob(ISimulationJob job) {
		if (job != null) {
			myJobs.add(job);
		}
	}
}
