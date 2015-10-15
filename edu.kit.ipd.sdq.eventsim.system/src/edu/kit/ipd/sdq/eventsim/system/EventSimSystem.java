package edu.kit.ipd.sdq.eventsim.system;

import org.apache.log4j.Logger;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.palladiosimulator.pcm.usagemodel.EntryLevelSystemCall;

import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;
import edu.kit.ipd.sdq.simcomp.component.IUser;
import edu.kit.ipd.sdq.simcomp.events.IEventHandler;
import edu.kit.ipd.sdq.simcomp.events.SimulationFinalizeEvent;
import edu.kit.ipd.sdq.simcomp.events.SimulationInitEvent;
import edu.kit.ipd.sdq.simcomp.resource.active.component.IActiveResource;
import edu.kit.ipd.sdq.simcomp.resource.passive.component.IPassiveResource;
import edu.kit.ipd.sdq.simcomp.system.component.ISystem;

@Component(immediate = true)
public class EventSimSystem implements ISystem {

	private static final Logger logger = Logger.getLogger(EventSimSystem.class);

	private ISimulationMiddleware middleware;
	private IActiveResource activeResourceComponent;
	private IPassiveResource passiveResourceComponent;
	private EventSimSystemModel model;

	// private Activator systemActivator;

	/**
	 * Initializes the system simulation component
	 */
	public void init() {
		this.model = new EventSimSystemModel(middleware, activeResourceComponent, passiveResourceComponent);
		this.model.init();
	}

	/**
	 * Cleans up the system simulation component
	 */
	public void finalise() {
		this.model.finalise();
		this.model = null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void callService(IUser user, EntryLevelSystemCall call) {

		if (logger.isDebugEnabled()) {
			logger.debug("Received service call from " + user.getId() + " on " + call.getEntityName() + " ("
					+ call.getOperationSignature__EntryLevelSystemCall().getEntityName() + ")");
		}

		// delegate the system call to the event sim model
		this.model.callService(user, call);

	}

	/**
	 * Registers the event handler which will initialize the system simulation
	 */
	private void registerEventHandler() {
		this.middleware.registerEventHandler(SimulationInitEvent.EVENT_ID, new IEventHandler<SimulationInitEvent>() {

			@Override
			public void handle(SimulationInitEvent event) {
				EventSimSystem.this.init();
			}

		}, false);

		this.middleware.registerEventHandler(SimulationFinalizeEvent.EVENT_ID,
				new IEventHandler<SimulationFinalizeEvent>() {

					@Override
					public void handle(SimulationFinalizeEvent event) {
						EventSimSystem.this.finalise();
					}

				}, false);
	}

	/**
	 * Binds a simulation middleware instance to the simulation component. Called by the declarative service framework.
	 * 
	 * @param middleware
	 */
	@Reference
	public void bindSimulationMiddleware(ISimulationMiddleware middleware) {
		this.middleware = middleware;

		// when the middleware is bound we register for some events
		this.registerEventHandler();
	}

	/**
	 * Unbind a simulation middleware instance from the simulation component when it is deactivated. Called by the
	 * declarative service framework.
	 * 
	 * @param middleware
	 */
	public void unbindSimulationMiddleware(ISimulationMiddleware middleware) {
		if (this.middleware.equals(middleware)) {
			this.middleware = null;
		}
	}

	@Reference
	public void bindActiveResourceComponent(IActiveResource resource) {
		System.out.println("ActiveResource bound to System");

		activeResourceComponent = resource;
	}

	public void unbindActiveResourceComponent(IActiveResource system) {
		activeResourceComponent = null;
	}

	public IActiveResource getActiveResourceComponent() {
		return activeResourceComponent;
	}

	@Reference
	public void bindPassiveResourceComponent(IPassiveResource resource) {
		System.out.println("PassiveResource bound to System");

		passiveResourceComponent = resource;
	}

	public void unbindPassiveResourceComponent(IPassiveResource system) {
		passiveResourceComponent = null;
	}

	public IPassiveResource getPassiveResourceComponent() {
		return passiveResourceComponent;
	}

	/**
	 * Declarative service lifecycle method called when the system simulation component is activated.
	 * 
	 * @param context
	 */
	@Activate
	public void activate(ComponentContext context) {
		System.out.println("System activated");

		// this.systemActivator = Activator.getDefault();
		// this.systemActivator.bindSystemComponent(this);
	}

	/**
	 * Declarative service lifecycle method called when the system simulation component is deactivated.
	 * 
	 * @param context
	 */
	@Deactivate
	public void deactivate(ComponentContext context) {
		// this.systemActivator.unbindSystemComponent();
		// this.systemActivator = null;
	}
}
