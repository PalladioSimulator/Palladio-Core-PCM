package de.uka.ipd.sdq.codegen.simucontroller.gui;

import java.io.Serializable;
import java.util.Observable;

import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.simucomframework.simulationdock.SimulationDockService;

public class DockStatusModel extends Observable implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2378222579642029801L;
	private int percentDone = 0;
	private double simTime = 0;
	private long measurementCount = 0;
	private boolean idle = true;
	private String id;
	private String remoteMaschineURI;
	
	private transient SimulationDockService service; 

	public DockStatusModel(SimulationDockService service) {
		this(service,null);
	}
	
	public DockStatusModel(SimulationDockService service, String remoteMaschineURI) {
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
		this.percentDone = percentDone;
		setChanged();
		notifyObservers();
	}
	public void setSimTime(double simTime) {
		this.simTime = simTime;
		notifyObservers();
	}
	public void setMeasurementCount(long measurementCount) {
		this.measurementCount = measurementCount;
		setChanged();
		notifyObservers();
	}
	public void setIdle(boolean idle) {
		this.idle = idle;
		this.measurementCount = 0;
		this.simTime = 0;
		this.percentDone = 0;
		setChanged();
		notifyObservers();
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
}
