package edu.kit.ipd.sdq.eventsim.resources;

import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import edu.kit.ipd.sdq.simcomp.component.IPassiveResource;
import edu.kit.ipd.sdq.simcomp.component.IRequest;
import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;
import edu.kit.ipd.sdq.simcomp.event.IEventHandler;
import edu.kit.ipd.sdq.simcomp.event.simulation.SimulationInitEvent;

public class EventSimPassiveResource implements IPassiveResource {

	private ISimulationMiddleware middleware;
	private EventSimPassiveResourceModel model;

	public void init() {
		this.model = new EventSimPassiveResourceModel(this.middleware);
		this.model.init();
	}

	@Override
	public boolean acquire(IRequest request, PassiveResource specification, int i, boolean b, double timeoutValue) {
		return this.model.acquire(request, specification, i, b, timeoutValue);
	}

	@Override
	public void release(IRequest request, PassiveResource specification, int i) {
		this.model.release(request, specification, i);
	}

	/**
	 * Registers the event handler which will initialize the system simulation
	 */
	private void registerEventHandler() {
		this.middleware.registerEventHandler(SimulationInitEvent.EVENT_ID, new IEventHandler<SimulationInitEvent>() {

			@Override
			public void handle(SimulationInitEvent event) {
				EventSimPassiveResource.this.init();
			}

		});
	}

	/**
	 * Binds a simulation middleware instance to the simulation component.
	 * Called by the declarative service framework.
	 * 
	 * @param middleware
	 */
	public void bindSimulationMiddleware(ISimulationMiddleware middleware) {
		this.middleware = middleware;

		// when the middleware is bound we register for some events
		this.registerEventHandler();
	}

	/**
	 * Unbind a simulation middleware instance from the simulation component
	 * when it is deactivated. Called by the declarative service framework.
	 * 
	 * @param middleware
	 */
	public void unbindSimulationMiddleware(ISimulationMiddleware middleware) {
		if (this.middleware.equals(middleware)) {
			this.middleware = null;
		}
	}
}
