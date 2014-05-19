package edu.kit.ipd.sdq.simcomp.events;


/**
 * Represents a simulation event which is triggered by a simulation component.
 * The default events can be found in the interface of a simulation component.
 * 
 * @author Christoph Föhrdes
 */
abstract public class SimulationEvent {

	/**
	 * Prefix for an event ID to identify simulation component events.
	 */
	public static String ID_PREFIX = "simcomp/";

	public static SimulationEvent EVENT_DEBUG = new SimulationDebugEvent();

	public static String SIMCOMP_EVENT_PROPERTY = "simcomp.event";

	private String eventId;

	public SimulationEvent(String eventId) {
		this.eventId = eventId;
	}

	/**
	 * The unique ID for a specific event.
	 * 
	 * @return A unique event ID
	 */
	public String getEventId() {
		return this.eventId;
	}

}
