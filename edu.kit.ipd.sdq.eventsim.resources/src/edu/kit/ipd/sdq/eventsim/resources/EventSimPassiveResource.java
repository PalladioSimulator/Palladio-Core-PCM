package edu.kit.ipd.sdq.eventsim.resources;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.repository.PassiveResource;

import edu.kit.ipd.sdq.eventsim.api.IPassiveResource;
import edu.kit.ipd.sdq.eventsim.api.IRequest;
import edu.kit.ipd.sdq.eventsim.middleware.ISimulationMiddleware;
import edu.kit.ipd.sdq.eventsim.middleware.events.IEventHandler;
import edu.kit.ipd.sdq.eventsim.middleware.events.SimulationFinalizeEvent;
import edu.kit.ipd.sdq.eventsim.middleware.events.SimulationInitEvent;

public class EventSimPassiveResource implements IPassiveResource {

	private ISimulationMiddleware middleware;
	private EventSimPassiveResourceModel model;

	public EventSimPassiveResource(ISimulationMiddleware middleware) {
		this.middleware = middleware;
		this.registerEventHandler();
	}

	/**
	 * Initializes the passive resource simulation component
	 */
	public void init() {
		this.model = new EventSimPassiveResourceModel(this.middleware);
		this.model.init();
	}

	@Override
	public boolean acquire(IRequest request, AssemblyContext ctx, PassiveResource specification, int num) {
		return this.model.acquire(request, ctx, specification, num);
	}

	@Override
	public void release(IRequest request, AssemblyContext ctx, PassiveResource specification, int num) {
		this.model.release(request, ctx, specification, num);
	}

	/**
	 * Cleans up the system simulation component
	 */
	public void finalise() {
		this.model.finalise();
		this.model = null;
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

		}, false);

		this.middleware.registerEventHandler(SimulationFinalizeEvent.EVENT_ID, new IEventHandler<SimulationFinalizeEvent>() {

			@Override
			public void handle(SimulationFinalizeEvent event) {
				EventSimPassiveResource.this.finalise();
			}

		}, false);
	}

}
