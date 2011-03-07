package de.uka.ipd.sdq.simucomframework.abstractSimEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.probespec.framework.RequestContext;
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

	private RequestContext requestContext;
	
	protected SimProcess(SimuComModel model, String name) {
		this(model, name, null);
	}
	
	protected SimProcess(SimuComModel model, String name, RequestContext parentRequestContext) {
		super(model, name);
		id = getNextID();
		isDebug = model.getConfig().isDebug();
		logger.debug("Create SimProcess with id " + id);
		this.delayResource = new SimDelayResource(name + "_thinktime", name
				+ "_thinktime");
		delegate = model.getSimEngineFactory().createSimProcess(this, model,
				name);
		requestContext = new RequestContext(Long.valueOf(id).toString(), parentRequestContext);
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
			String message = e.getMessage();
			message = message == null ? "" : message;
			if (e instanceof IllegalArgumentException && message.contains("Cannot schedule in the past")){
				logger.warn(
						"Simulation caused an exception because it scheduled in the past. Check your models that you do not have any negative demands, arrival times, or similar",
						e);
			}
			else {
				logger.warn(
					"Simulation caused an exception. Caught it in SimProcess Lifecycle Method",
					e);
			}
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
	
	/**
	 * Returns the {@link RequestContext} in which this simulated process is
	 * executed.
	 * 
	 * @return the request context
	 */
	public RequestContext getRequestContext() {
		return requestContext;
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

	private static AtomicLong processID = new AtomicLong(0);
	private static AtomicLong sessionID = new AtomicLong(0);

	protected static long getNextID() {
		return processID.incrementAndGet();
	}
	
	protected long currentSessionId;
	
	public long getCurrentSessionId() {
		return currentSessionId;
	}
	
	protected void updateNewSessionID() {
		currentSessionId = sessionID.incrementAndGet();
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
		if (!terminatedObservers.contains(r)){
			terminatedObservers.add(r);
		}
	}

	public void removeTerminatedObserver(IActiveResource r) {
		removedObservers.remove(r);
	}

}
