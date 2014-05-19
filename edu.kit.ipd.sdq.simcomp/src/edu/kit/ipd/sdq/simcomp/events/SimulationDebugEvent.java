package edu.kit.ipd.sdq.simcomp.events;

/**
 * This event refers to any simulation component event. The event is intended to
 * be used for debug puposes.
 * 
 * @author Christoph Föhrdes
 */
public class SimulationDebugEvent extends SimulationEvent {

	public SimulationDebugEvent() {
		super(SimulationEvent.ID_PREFIX + "*");
	}

}
