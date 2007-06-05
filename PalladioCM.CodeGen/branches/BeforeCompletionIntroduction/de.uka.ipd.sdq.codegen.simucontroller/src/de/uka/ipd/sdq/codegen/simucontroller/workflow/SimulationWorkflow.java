package de.uka.ipd.sdq.codegen.simucontroller.workflow;

import java.util.LinkedList;
import java.util.Stack;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;

import de.uka.ipd.sdq.codegen.simucontroller.SimuControllerPlugin;

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

	public void run() throws Exception {
		myMonitor.beginTask("Simulation Run", myJobs.size());

		for (ISimulationJob job : myJobs) {
			try {
				if (myMonitor.isCanceled()) {
					return;
				}

				myMonitor.subTask(job.getName());
				myExecutedJobs.push(job);
				job.execute();
				myMonitor.worked(1);

			} catch (Exception e) {
				SimuControllerPlugin.log(IStatus.ERROR, e.getMessage());
				throw e;
			}
		}

		myMonitor.done();
	}

	public void rollback() {
		while (!myExecutedJobs.empty()) {
			try {
				myExecutedJobs.pop().rollback();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void addJob(ISimulationJob job) {
		if (job != null) {
			myJobs.add(job);
		}
	}
}
