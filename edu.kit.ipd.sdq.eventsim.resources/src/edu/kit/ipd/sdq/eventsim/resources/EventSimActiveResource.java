package edu.kit.ipd.sdq.eventsim.resources;

import org.palladiosimulator.pcm.resourceenvironment.ResourceContainer;
import org.palladiosimulator.pcm.resourcetype.ResourceType;

import edu.kit.ipd.sdq.eventsim.api.IActiveResource;
import edu.kit.ipd.sdq.eventsim.api.IRequest;
import edu.kit.ipd.sdq.eventsim.middleware.ISimulationMiddleware;
import edu.kit.ipd.sdq.eventsim.middleware.events.IEventHandler;
import edu.kit.ipd.sdq.eventsim.middleware.events.SimulationFinalizeEvent;
import edu.kit.ipd.sdq.eventsim.middleware.events.SimulationInitEvent;

public class EventSimActiveResource implements IActiveResource {

	private ISimulationMiddleware middleware;
	private EventSimActiveResourceModel model;
	
	public EventSimActiveResource(ISimulationMiddleware middleware) {
		this.middleware = middleware;
		
		this.model = new EventSimActiveResourceModel(this.middleware);
		this.model.init();
		
		this.registerEventHandler();
	}

	@Override
	public void consume(IRequest request, ResourceContainer resourceContainer, ResourceType resourceType, double absoluteDemand) {
		this.model.consume(request, resourceContainer, resourceType, absoluteDemand);
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
//				EventSimActiveResource.this.init();
				// TODO ?
			}

		}, false);

		this.middleware.registerEventHandler(SimulationFinalizeEvent.EVENT_ID, new IEventHandler<SimulationFinalizeEvent>() {

			@Override
			public void handle(SimulationFinalizeEvent event) {
				EventSimActiveResource.this.finalise();
			}

		}, false);
	}

}
