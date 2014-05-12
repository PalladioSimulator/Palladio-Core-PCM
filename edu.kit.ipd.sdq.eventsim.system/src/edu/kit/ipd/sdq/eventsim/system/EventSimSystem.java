package edu.kit.ipd.sdq.eventsim.system;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;
import edu.kit.ipd.sdq.simcomp.component.ISystem;
import edu.kit.ipd.sdq.simcomp.component.IUser;
import edu.kit.ipd.sdq.simcomp.event.IEventHandler;
import edu.kit.ipd.sdq.simcomp.event.simulation.SimulationInitEvent;

public class EventSimSystem implements ISystem {

	private static final Logger logger = Logger.getLogger(EventSimSystem.class);

	private ISimulationMiddleware middleware;
	private EventSimSystemModel model;

	/**
	 * Initializes the system simulation component
	 */
	public void init() {
		this.model = new EventSimSystemModel(middleware);
		this.model.init();
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
