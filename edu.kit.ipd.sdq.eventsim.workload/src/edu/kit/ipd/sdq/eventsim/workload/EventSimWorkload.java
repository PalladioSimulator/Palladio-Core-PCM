package edu.kit.ipd.sdq.eventsim.workload;

import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;
import edu.kit.ipd.sdq.simcomp.component.IWorkload;
import edu.kit.ipd.sdq.simcomp.event.IEventHandler;
import edu.kit.ipd.sdq.simcomp.event.simulation.SimulationInitEvent;

/**
 * An EventSim based workload simulation component implementation.
 * 
 * @author Christoph Föhrdes
 */
public class EventSimWorkload implements IWorkload {

	ISimulationMiddleware middleware;

	@Override
	public void generate() {

		// create the event sim model
		EventSimWorkloadModel model = new EventSimWorkloadModel(this.middleware);

		// launch the event generation
		model.init();
	}

	/**
	 * Registers the event handler which will start the workload generation
	 * process.
	 */
	private void registerEventHandler() {
		this.middleware.registerEventHandler(SimulationInitEvent.EVENT_ID, new IEventHandler<SimulationInitEvent>() {

			@Override
			public void handle(SimulationInitEvent event) {
				EventSimWorkload.this.generate();
			}

		});
	}

	public void bindSimulationMiddleware(ISimulationMiddleware middleware) {
		this.middleware = middleware;

		// when the middleware is bound we register for some events
		this.registerEventHandler();
	}

	public void unbindSimulationMiddleware(ISimulationMiddleware middleware) {
		if (this.middleware.equals(middleware)) {
			this.middleware = null;
		}
	}
}
