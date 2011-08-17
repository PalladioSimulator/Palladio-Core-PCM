package de.uka.ipd.sdq.simucomframework.abstractSimEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.LoggingWrapper;
import de.uka.ipd.sdq.scheduler.resources.active.SimDelayResource;
import de.uka.ipd.sdq.simucomframework.SimuComResult;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.simucomstatus.Process;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusFactory;

public abstract class SimProcess extends SimulationElement implements
		ISimProcessDelegate, ISchedulableProcess {

	protected static Logger logger = Logger.getLogger(SimProcess.class
			.getName());

	ISimProcessDelegate delegate = null;
	private Process processStatus = null;
	private long id;
	private SimDelayResource delayResource = null;

	private boolean isDebug;

	protected SimProcess(SimuComModel model, String name) {
		super(model, name);
		id = getNextID();
		isDebug = model.getConfig().isDebug();
		logger.debug("Create SimProcess with id " + id);
		delegate = model.getSimEngineFactory().createSimProcess(this, model,
				name);
		this.delayResource = new SimDelayResource(name + "_thinktime", name
				+ "_thinktime");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimProcessDelegate
	 * #lifeCycle()
	 */
	public final void lifeCycle() {
		addProcessToSimStatus();
		try {
			this.internalLifeCycle();
			this.fireTerminated();
		} catch (Exception e) {
			e.printStackTrace();
			logger
					.warn(
							"Simulation caused an exception. Caught it in SimProcess Lifecycle Method",
							e);
			((SimuComModel) getModel()).setStatus(SimuComResult.ERROR, e);
			logger.debug("Trying to stop simulation now...");
			this.getModel().getSimulationControl().stop();
		}
		removeProcessFromSimStatus();
	}

	/**
	 * 
	 */
	protected void removeProcessFromSimStatus() {
		logger.debug("Terminating SimProcess " + this.getName());
		if (isDebug) {
			this.getModel().getSimulationStatus().getProcessStatus()
					.getProcesses().remove(processStatus);
		}
	}

	/**
	 * Clients may override default behaviour, e.g., PassiveResource
	 */
	protected void addProcessToSimStatus() {
		logger.debug("Starting simulation process " + this.getName());

		if (isDebug) {
			processStatus = SimucomstatusFactory.eINSTANCE.createProcess();
			this.getModel().getSimulationStatus().getProcessStatus()
					.getProcesses().add(processStatus);
			processStatus.setId(this.getName());
			processStatus.setProcessStartTime(this.getModel()
					.getSimulationControl().getCurrentSimulationTime());
		}
	}

	protected abstract void internalLifeCycle();

	// Strategy dependent methods

	public void hold(double d) {
		delayResource.process(this, d);
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
		return getName() + "_" + id;
	}

	public ISchedulableProcess getRootProcess() {
		// TODO: What is expected here?
		return null;
	}

	public boolean isFinished() {
		return isTerminated();
	}

	public Process getSimProcessStatus() {
		return this.processStatus;
	}

	private static AtomicLong processID = new AtomicLong(0);

	protected static long getNextID() {
		return processID.incrementAndGet();
	}

	private ArrayList<IActiveResource> terminatedObservers = new ArrayList<IActiveResource>();
	private List<IActiveResource> removedObservers = new ArrayList<IActiveResource>();;

	public void fireTerminated() {
		LoggingWrapper.log("Process " + this.getId() + " terminated.");
		for (IActiveResource o : terminatedObservers)
			o.notifyTerminated(this);
		terminatedObservers.removeAll(removedObservers);
		removedObservers.clear();
	}

	public void addTerminatedObserver(IActiveResource r) {
		terminatedObservers.add(r);
	}

	public void removeTerminatedObserver(IActiveResource r) {
		removedObservers.add(r);
	}

}
