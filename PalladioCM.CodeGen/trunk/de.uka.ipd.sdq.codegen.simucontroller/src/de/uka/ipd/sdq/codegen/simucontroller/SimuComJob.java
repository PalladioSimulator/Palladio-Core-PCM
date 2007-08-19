package de.uka.ipd.sdq.codegen.simucontroller;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import de.uka.ipd.sdq.codegen.simucontroller.actions.ISimuComControl;
import de.uka.ipd.sdq.simucomframework.IStatusObserver;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;
import de.uka.ipd.sdq.simucomframework.SimuComStatus;

public class SimuComJob extends Job implements IStatusObserver {

	private ISimuComControl control;
	private IProgressMonitor monitor;
	private int lastProgress;
	
	private SimuComStatus status;
	private SimuComConfig config;
	private Throwable errorThrowable;

	public SimuComJob(ISimuComControl control, SimuComConfig config) {
		super("Simulation Run");
		this.control = control;
		this.config = config;
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		this.monitor = monitor;
		lastProgress = 0;
		monitor.beginTask("Simulation Run", 100);
		try {
			status = control.startSimulation(config, this);
		} catch (Exception e) {
			this.status = SimuComStatus.ERROR;
			this.errorThrowable = e;
			return Status.CANCEL_STATUS;
		} finally {
			monitor.done();
		}
		if (status == SimuComStatus.ERROR){
			this.errorThrowable = control.getErrorThrowable();
		}
		return Status.OK_STATUS;
	}

	public void updateStatus(final int percentDone) {
		if (lastProgress < percentDone) {
			monitor.worked(percentDone - lastProgress);
			lastProgress = percentDone;
		}
		
		if (monitor.isCanceled()) {
			control.stopSimulation();
		}
	}

	public Throwable getErrorThrowable() {
		return errorThrowable;
	}

	public SimuComStatus getStatus() {
		return status;
	}
}