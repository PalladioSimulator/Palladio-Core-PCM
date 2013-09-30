package de.uka.ipd.sdq.codegen.simucontroller.dockmodel;

import java.io.Serializable;
import java.util.Observable;

import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.events.DockBusyEvent;
import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.events.DockIdleEvent;
import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.events.DockPerformedDebugStepEvent;
import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.events.DockResumedEvent;
import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.events.DockSimTimeChangedEvent;
import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.events.DockSimulationStartedEvent;
import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.events.DockSimulationTerminatedEvent;
import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.events.DockStartedDebugStepEvent;
import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.events.DockSuspendedEvent;
import de.uka.ipd.sdq.simucomframework.simulationdock.SimulationDockService;

/**
 * This class represents a single Simulation Dock's status. It fires events if the status of the dock changes.
 * @author Steffen
 *
 */
public class DockModel extends Observable implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2378222579642029801L;
	private int percentDone = 0;
	private double simTime = 0;
	private long measurementCount = 0;
	private boolean idle = true;
	private String id = null;
	private String remoteMaschineURI;
	private boolean isStepping = false;
	private boolean isSuspended = false;
	
	private transient SimulationDockService service;
	private boolean isStarted; 

	public DockModel(SimulationDockService service) {
		this(service,null);
	}
	
	public DockModel(SimulationDockService service, String remoteMaschineURI) {
		this.service = service;
		this.id = service.getDockId();
		this.remoteMaschineURI = remoteMaschineURI;
	}
	
	public int getPercentDone() {
		return percentDone;
	}
	public double getSimTime() {
		return simTime;
	}
	public long getMeasurementCount() {
		return measurementCount;
	}
	public boolean isIdle() {
		return idle;
	}
	
	public void setPercentDone(int percentDone) {
		if (!this.isIdle() && this.percentDone != percentDone) {
			this.percentDone = percentDone;
			setChanged();
			notifyObservers();
		}
	}

	public void setSimTime(double simTime) {
		if (!this.isIdle() && this.simTime != simTime) {
			this.simTime = simTime;
			setChanged();
			notifyObservers(new DockSimTimeChangedEvent(this,simTime));
		}
	}
	
	public void setMeasurementCount(long measurementCount) {
		if (!this.isIdle()) {
			this.measurementCount = measurementCount;
			setChanged();
			notifyObservers();
		}
	}
	
	public void setIdle(boolean idle) {
		if (this.idle != idle) {
			this.idle = idle;
			this.measurementCount = 0;
			this.simTime = 0;
			this.percentDone = 0;
			setChanged();
			if (idle) 
				notifyObservers(new DockIdleEvent(this));
			else
				notifyObservers(new DockBusyEvent(this));
		}
	}
	
	public String getID() {
		return id;
	}

	public SimulationDockService getService() {
		return service;
	}

	public boolean isRemote() {
		return remoteMaschineURI != null;
	}

	public String getRemoteMaschineURI() {
		return remoteMaschineURI;
	}

	public boolean isStepping() {
		return isStepping;
	}

	public void setIsStepping(boolean isStepping) {
		if (this.isStepping != isStepping) {
			this.isStepping = isStepping;
			setChanged();
			if (isStepping)
				notifyObservers(new DockStartedDebugStepEvent(this));
			else
				notifyObservers(new DockPerformedDebugStepEvent(this));
		}
	}

	public boolean isSuspended() {
		return isSuspended;
	}

	public void setIsSuspended(boolean isSuspended) {
		if (this.isSuspended != isSuspended) {
			this.isSuspended = isSuspended;
			setChanged();
			if (isSuspended)
				notifyObservers(new DockSuspendedEvent(this));
			else
				notifyObservers(new DockResumedEvent(this));
		}
	}

	public void setStarted(boolean started) {
		if (this.isStarted != started) {
			this.isStarted = started;
			setChanged();
			if (isStarted)
				notifyObservers(new DockSimulationStartedEvent(this));
			else
				notifyObservers(new DockSimulationTerminatedEvent(this));
		}
	}
	
}
