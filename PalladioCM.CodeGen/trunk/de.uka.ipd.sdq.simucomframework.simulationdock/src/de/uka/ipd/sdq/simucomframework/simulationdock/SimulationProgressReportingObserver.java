package de.uka.ipd.sdq.simucomframework.simulationdock;

import java.util.Hashtable;
import java.util.Map;

import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;

import de.uka.ipd.sdq.simucomframework.IStatusObserver;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;

public class SimulationProgressReportingObserver implements IStatusObserver {
	private int lastPercent = 0;
	private SimuComConfig config;
	private SimulationDockService myDock;
	private EventAdmin eventAdmin;
	
	public SimulationProgressReportingObserver(SimuComConfig config,
			EventAdmin eventAdmin, SimulationDockService dock) {
		this.config = config;
		this.eventAdmin = eventAdmin;
		this.myDock = dock;
	}
	
	public void updateStatus(int percentDone, double currentSimTime,
			long measurementsTaken) {
		if (percentDone > lastPercent ||  (config.isDebug() /* TODO: && myDock.isSuspended() */)){
			Hashtable<String,Object> properties = new Hashtable<String,Object>();
			properties.put("PERCENT_DONE", percentDone);
			properties.put("CURRENT_TIME", currentSimTime);
			properties.put("MEASUREMENTS_TAKEN", measurementsTaken);
			postEvent("de/uka/ipd/sdq/simucomframework/simucomdock/UPDATE_SIM_STATUS",properties);
			lastPercent = percentDone;
		}
	}

	private void postEvent(String topic, Hashtable<String,Object> newProperties) {
		Map<String,Object> properties = new Hashtable<String,Object>();
		properties.put("DOCK_ID", myDock.getDockId());
		properties.putAll(newProperties);
		Event event = new Event(topic, properties);
		eventAdmin.postEvent(event);
	}
	
}
