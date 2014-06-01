package edu.kit.ipd.sdq.eventsim.system;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.osgi.service.component.ComponentContext;

import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;
import edu.kit.ipd.sdq.simcomp.component.IUser;
import edu.kit.ipd.sdq.simcomp.events.IEventHandler;
import edu.kit.ipd.sdq.simcomp.events.SimulationFinalizeEvent;
import edu.kit.ipd.sdq.simcomp.events.SimulationInitEvent;
import edu.kit.ipd.sdq.simcomp.resource.active.component.IActiveResource;
import edu.kit.ipd.sdq.simcomp.resource.passive.component.IPassiveResource;
import edu.kit.ipd.sdq.simcomp.system.component.ISystem;

public class EventSimSystem implements ISystem {

	private static final Logger logger = Logger.getLogger(EventSimSystem.class);

	private ISimulationMiddleware middleware;
	private List<IActiveResource> activeResourceComponents;
	private List<IPassiveResource> passiveResourceComponents;
	private EventSimSystemModel model;

	private Activator systemActivator;

	public EventSimSystem() {
		activeResourceComponents = new ArrayList<IActiveResource>();
		passiveResourceComponents = new ArrayList<IPassiveResource>();
	}

	/**
	 * Initializes the system simulation component
	 */
	public void init() {
		this.model = new EventSimSystemModel(middleware);
		this.model.init();
	}

	/**
	 * Cleans up the system simulation component
	 */
	public void finalise() {
		this.model.finalise();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void callService(IUser user, EntryLevelSystemCall call) {

		if (logger.isDebugEnabled()) {
			logger.debug("Received service call from " + user.getId() + " on " + call.getEntityName() + " (" + call.getOperationSignature__EntryLevelSystemCall().getEntityName() + ")");
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

		this.middleware.registerEventHandler(SimulationFinalizeEvent.EVENT_ID, new IEventHandler<SimulationFinalizeEvent>() {

			@Override
			public void handle(SimulationFinalizeEvent event) {
				EventSimSystem.this.finalise();
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

	public void bindActiveResourceComponent(IActiveResource system) {
		System.out.println("ActiveResource bound to System");

		this.activeResourceComponents.add(system);
	}

	public void unbindActiveResourceComponent(IActiveResource system) {
		if (this.activeResourceComponents.contains(system)) {
			this.activeResourceComponents.remove(system);
		}
	}

	public List<IActiveResource> getActiveResourceComponents() {
		return this.activeResourceComponents;
	}

	public void bindPassiveResourceComponent(IPassiveResource system) {
		System.out.println("PassiveResource bound to System");

		this.passiveResourceComponents.add(system);
	}

	public void unbindPassiveResourceComponent(IPassiveResource system) {
		if (this.passiveResourceComponents.contains(system)) {
			this.passiveResourceComponents.remove(system);
		}
	}

	public List<IPassiveResource> getPassiveResourceComponents() {
		return this.passiveResourceComponents;
	}

	/**
	 * Declarative service lifecycle method called when the system simulation
	 * component is activated.
	 * 
	 * @param context
	 */
	public void activate(ComponentContext context) {
		System.out.println("System activated");

		this.systemActivator = Activator.getDefault();
		this.systemActivator.bindSystemComponent(this);
	}

	/**
	 * Declarative service lifecycle method called when the system simulation
	 * component is deactivated.
	 * 
	 * @param context
	 */
	public void deactivate(ComponentContext context) {
		this.systemActivator.unbindSystemComponent();
		this.systemActivator = null;
	}
}
