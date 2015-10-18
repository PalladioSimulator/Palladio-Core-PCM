package edu.kit.ipd.sdq.eventsim.workload;

import org.apache.log4j.Logger;

import edu.kit.ipd.sdq.eventsim.api.ISystem;
import edu.kit.ipd.sdq.eventsim.api.IWorkload;
import edu.kit.ipd.sdq.eventsim.api.events.WorkloadUserFinished;
import edu.kit.ipd.sdq.eventsim.middleware.ISimulationMiddleware;
import edu.kit.ipd.sdq.eventsim.middleware.events.IEventHandler;
import edu.kit.ipd.sdq.eventsim.middleware.events.SimulationFinalizeEvent;
import edu.kit.ipd.sdq.eventsim.middleware.events.SimulationInitEvent;

/**
 * An EventSim based workload simulation component implementation.
 * 
 * @author Christoph Föhrdes
 */
public class EventSimWorkload implements IWorkload {

	private static final Logger logger = Logger.getLogger(EventSimWorkload.class);

	private ISimulationMiddleware middleware;
//	private List<ISystem> systemComponents;
	private EventSimWorkloadModel model;

	private SystemCallListener systemCallCallback;
	
	public EventSimWorkload(ISimulationMiddleware middleware) {
		// TODO enable more than one system
		this.middleware = middleware;
		
		// when the middleware is bound we register for some events
		this.registerEventHandler();
	}
	
	@Override
	public void generate() {

		if (logger.isDebugEnabled()) {
			logger.debug("Generating Workload");
		}

		// create the event sim model
		model = new EventSimWorkloadModel(this.middleware, systemCallCallback);

		// launch the event generation
		model.init();
	}

	/**
	 * Cleans up the system simulation component
	 */
	public void finalise() {
		this.model.finalise();
		this.model = null;
	}

	/**
	 * Registers the event handler which will start the workload generation process.
	 */
	private void registerEventHandler() {
		// initialization event handler
		this.middleware.registerEventHandler(SimulationInitEvent.EVENT_ID, new IEventHandler<SimulationInitEvent>() {

			@Override
			public void handle(SimulationInitEvent event) {
				EventSimWorkload.this.generate();
			}

		}, false);

		// clean up event handler
		this.middleware.registerEventHandler(SimulationFinalizeEvent.EVENT_ID,
				new IEventHandler<SimulationFinalizeEvent>() {

					@Override
					public void handle(SimulationFinalizeEvent event) {
						EventSimWorkload.this.finalise();
					}

				}, false);

		// measurement count event handler
		this.middleware.registerEventHandler(WorkloadUserFinished.EVENT_ID, new IEventHandler<WorkloadUserFinished>() {

			@Override
			public void handle(WorkloadUserFinished simulationEvent) {
				// processed user request increases the measurement count
				middleware.increaseMeasurementCount();
			}

		}, false);
	}

	@Override
	public void onSystemCall(SystemCallListener callback) {
		this.systemCallCallback = callback;
	}

}
