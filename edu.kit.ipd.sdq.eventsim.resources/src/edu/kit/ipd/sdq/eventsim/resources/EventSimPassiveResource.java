package edu.kit.ipd.sdq.eventsim.resources;

import org.osgi.service.component.ComponentContext;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.repository.PassiveResource;

import edu.kit.ipd.sdq.simcomp.component.IRequest;
import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;
import edu.kit.ipd.sdq.simcomp.events.IEventHandler;
import edu.kit.ipd.sdq.simcomp.events.SimulationFinalizeEvent;
import edu.kit.ipd.sdq.simcomp.events.SimulationInitEvent;
import edu.kit.ipd.sdq.simcomp.resource.passive.component.IPassiveResource;

public class EventSimPassiveResource implements IPassiveResource {

	private ISimulationMiddleware middleware;
	private Activator resourceActivator;
	private EventSimPassiveResourceModel model;

	/**
	 * Initializes the passive resource simulation component
	 */
	public void init() {
		this.model = new EventSimPassiveResourceModel(this.middleware);
		this.model.init();
	}

	@Override
	public boolean acquire(IRequest request, AssemblyContext ctx, PassiveResource specification, int i, boolean b, double timeoutValue) {
		return this.model.acquire(request, ctx, specification, i, b, timeoutValue);
	}

	@Override
	public void release(IRequest request, AssemblyContext ctx, PassiveResource specification, int i) {
		this.model.release(request, ctx, specification, i);
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
	 * Declarative service lifecycle method called when the passive resource
	 * simulation component is activated.
	 * 
	 * @param context
	 */
	public void activate(ComponentContext context) {
		System.out.println("PassiveResource activated");

		this.resourceActivator = Activator.getDefault();
		this.resourceActivator.bindPassiveResourceComponent(this);
	}

	/**
	 * Declarative service lifecycle method called when the passive resource
	 * simulation component is deactivated.
	 * 
	 * @param context
	 */
	public void deactivate(ComponentContext context) {
		this.resourceActivator.unbindPassiveResourceComponent();
		this.resourceActivator = null;
	}
}
