package edu.kit.ipd.sdq.simcomp.event;

import edu.kit.ipd.sdq.simcomp.event.simulation.SimulationEvent;

/**
 * A handler callback for a simulation component event.
 * 
 * @author Christoph Föhrdes
 */
public interface IEventHandler <T extends SimulationEvent> {

	/**
	 * The handle method called when a specific event was triggered.
	 * 
	 * @param simulationEvent
	 *            The triggered event
	 * @param simulationEvent
	 *            The triggered event
	 */
	public void handle(T simulationEvent);
}
