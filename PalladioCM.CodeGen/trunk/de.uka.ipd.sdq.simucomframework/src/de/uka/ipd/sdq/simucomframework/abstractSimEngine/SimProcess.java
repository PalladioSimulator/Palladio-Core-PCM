package de.uka.ipd.sdq.simucomframework.abstractSimEngine;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.simucomframework.SimuComResult;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.simucomstatus.Process;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusFactory;
import de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForDelay;

public abstract class SimProcess extends SimulationElement 
implements ISimProcessDelegate, ISchedulableProcess {

	protected static Logger logger = 
		Logger.getLogger(SimProcess.class.getName());
	
	ISimProcessDelegate delegate = null;
	private Process processStatus = null;

	private boolean isDebug;
	
	protected SimProcess(SimuComModel model, String name) {
		super(model, name);
		delegate = model.getSimEngineFactory().createSimProcess(this,model,name);
		isDebug = model.getConfig().isDebug();
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimProcessDelegate#lifeCycle()
	 */
	public final void lifeCycle() {
		addProcessToSimStatus();
		try {
			this.internalLifeCycle();
		} catch (Exception e) {
			logger.warn("Simulation caused an exception. Caught it in SimProcess Lifecycle Method",e);
			((SimuComModel)getModel()).setStatus(SimuComResult.ERROR,
					e);
			logger.debug("Trying to stop simulation now...");
			this.getModel().getSimulationControl().stop();
		}
		removeProcessFromSimStatus();
	}

	/**
	 * 
	 */
	protected void removeProcessFromSimStatus() {
		logger.info("Terminating SimProcess "+this.getName());
		if (isDebug) {
			this.getModel().getSimulationStatus().getProcessStatus().getProcesses().remove(processStatus);
		}
	}

	/**
	 * Clients may override default behaviour, e.g., PassiveResource
	 */
	protected void addProcessToSimStatus() {
		logger.info("Starting simulation process "+this.getName());

		if (isDebug) {
			processStatus = SimucomstatusFactory.eINSTANCE.createProcess();
			this.getModel().getSimulationStatus().getProcessStatus().getProcesses().add(processStatus);
			processStatus.setId(this.getName());
			processStatus.setProcessStartTime(this.getModel().getSimulationControl().getCurrentSimulationTime());
		}
	}
	
	protected abstract void internalLifeCycle();

	// Strategy dependent methods

	public void hold(double d) {
		if (isDebug) {
			WaitForDelay action = SimucomstatusFactory.eINSTANCE.createWaitForDelay();
			action.setActionStartTime(this.getModel().getSimulationControl().getCurrentSimulationTime());
			action.setDelay(d);
			this.getSimProcessStatus().setCurrentAction(action);
		}
		delegate.hold(d);
	}

	public boolean isTerminated() {
		return delegate.isTerminated();
	}

	public void passivate() {
		delegate.passivate();
	}
	
	public void activate() {
		this.scheduleAt(0);
	}

	public void scheduleAt(double d) {
		delegate.scheduleAt(d);
	}
	
	public String getId() {
		return Thread.currentThread().getName();
	}
	
	public ISchedulableProcess getRootProcess(){
		// TODO: What is expected here?
		return null;
	}
	
	public boolean isFinished() {
		return isTerminated();
	}

	public Process getSimProcessStatus() {
		return this.processStatus;
	}
	
}
