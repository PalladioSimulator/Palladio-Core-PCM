package edu.kit.ipd.sdq.eventsim.resources;

import org.osgi.service.component.ComponentContext;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceType;
import edu.kit.ipd.sdq.simcomp.component.IActiveResource;
import edu.kit.ipd.sdq.simcomp.component.IRequest;
import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;
import edu.kit.ipd.sdq.simcomp.event.IEventHandler;
import edu.kit.ipd.sdq.simcomp.event.simulation.SimulationFinalizeEvent;
import edu.kit.ipd.sdq.simcomp.event.simulation.SimulationInitEvent;

public class EventSimActiveResource implements IActiveResource {

	private ISimulationMiddleware middleware;
	private Activator resourceActivator;
	private EventSimActiveResourceModel model;

	/**
	 * Initializes the active resource simulation component
	 */
	public void init() {
		this.model = new EventSimActiveResourceModel(this.middleware);
		this.model.init();
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
	}

	/**
	 * Registers the event handler which will initialize the system simulation
	 */
	private void registerEventHandler() {
		this.middleware.registerEventHandler(SimulationInitEvent.EVENT_ID, new IEventHandler<SimulationInitEvent>() {

			@Override
			public void handle(SimulationInitEvent event) {
				EventSimActiveResource.this.init();
			}

		});

		this.middleware.registerEventHandler(SimulationFinalizeEvent.EVENT_ID, new IEventHandler<SimulationFinalizeEvent>() {

			@Override
			public void handle(SimulationFinalizeEvent event) {
				EventSimActiveResource.this.finalise();
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

	/**
	 * Declarative service lifecycle method called when the active resource
	 * simulation component is activated.
	 * 
	 * @param context
	 */
	public void activate(ComponentContext context) {
		System.out.println("ActiveResource activated");

		this.resourceActivator = Activator.getDefault();
		this.resourceActivator.bindActiveResourceComponent(this);
	}

	/**
	 * Declarative service lifecycle method called when the active resource
	 * simulation component is deactivated.
	 * 
	 * @param context
	 */
	public void deactivate(ComponentContext context) {
		this.resourceActivator.unbindActiveResourceComponent();
		this.resourceActivator = null;
	}
}
