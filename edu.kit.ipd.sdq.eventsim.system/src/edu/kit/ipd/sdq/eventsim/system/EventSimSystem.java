package edu.kit.ipd.sdq.eventsim.system;

import org.apache.log4j.Logger;
import org.palladiosimulator.pcm.usagemodel.EntryLevelSystemCall;

import edu.kit.ipd.sdq.eventsim.api.ISystem;
import edu.kit.ipd.sdq.eventsim.api.IUser;
import edu.kit.ipd.sdq.eventsim.middleware.ISimulationMiddleware;
import edu.kit.ipd.sdq.eventsim.middleware.events.IEventHandler;
import edu.kit.ipd.sdq.eventsim.middleware.events.SimulationFinalizeEvent;
import edu.kit.ipd.sdq.eventsim.middleware.events.SimulationInitEvent;

public class EventSimSystem implements ISystem {

	private static final Logger logger = Logger.getLogger(EventSimSystem.class);

	private ISimulationMiddleware middleware;
	
	private EventSimSystemModel model;
	
	private ActiveResourceListener activeResourceCallback;
	
	private PassiveResourceAcquireListener acquireCallback;
	
	private PassiveResourceReleaseListener releaseCallback;

	public EventSimSystem(ISimulationMiddleware middleware) {
		this.middleware = middleware;
		this.registerEventHandler();
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
		
		// TODO where to place?
		if(model == null) {
			this.model = new EventSimSystemModel(middleware, activeResourceCallback, acquireCallback, releaseCallback);
			this.model.init();
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
				// nothing to do
//				EventSimSystem.this.init(); TODO remove?
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

	@Override
	public void onActiveResourceDemand(ActiveResourceListener callback) {
		this.activeResourceCallback = callback;
	}

	@Override
	public void onPassiveResourceAcquire(PassiveResourceAcquireListener callback) {
		this.acquireCallback = callback;
	}

	@Override
	public void onPassiveResourceRelease(PassiveResourceReleaseListener callback) {
		this.releaseCallback = callback;
	}

}
