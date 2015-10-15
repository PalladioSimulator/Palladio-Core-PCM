package edu.kit.ipd.sdq.eventsim.workload;

import org.apache.log4j.Logger;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;
import edu.kit.ipd.sdq.simcomp.events.IEventHandler;
import edu.kit.ipd.sdq.simcomp.events.SimulationFinalizeEvent;
import edu.kit.ipd.sdq.simcomp.events.SimulationInitEvent;
import edu.kit.ipd.sdq.simcomp.system.component.ISystem;
import edu.kit.ipd.sdq.simcomp.workload.component.IWorkload;
import edu.kit.ipd.sdq.simcomp.workload.events.WorkloadUserFinished;

/**
 * An EventSim based workload simulation component implementation.
 * 
 * @author Christoph Föhrdes
 */
@Component(immediate = true)
public class EventSimWorkload implements IWorkload {

	private static final Logger logger = Logger.getLogger(EventSimWorkload.class);

	private ISimulationMiddleware middleware;
//	private List<ISystem> systemComponents;
	private ISystem systemComponent;
	private EventSimWorkloadModel model;

	private Activator workloadActivator;

//	public EventSimWorkload() {
//		systemComponents = new ArrayList<ISystem>();
//	}

	@Override
	public void generate() {

		if (logger.isDebugEnabled()) {
			logger.debug("Generating Workload");
		}

		// create the event sim model
		model = new EventSimWorkloadModel(this.middleware);

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

	@Reference(policy = ReferencePolicy.DYNAMIC, cardinality = ReferenceCardinality.AT_LEAST_ONE)
	public void bindSystemComponent(ISystem system) {
		System.out.println("System bound to Workload");

		this.systemComponent = system;
	}

	public void unbindSystemComponent(ISystem system) {
		this.systemComponent = null;
	}

	public ISystem getSystemComponent() {
		return systemComponent;
	}

	/**
	 * Binds a simulation middleware instance to the simulation component. Called by the declarative service framework.
	 * 
	 * @param middleware
	 */
	@Reference(policy = ReferencePolicy.DYNAMIC)
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

	/**
	 * Declarative service lifecycle method called when the workload simulation component is activated.
	 * 
	 * @param context
	 */
	@Activate
	public void activate(ComponentContext context) {
		System.out.println("Workload activated");

		this.workloadActivator = Activator.getDefault();
		this.workloadActivator.bindWorkloadComponent(this);
	}

	/**
	 * Declarative service lifecycle method called when the workload simulation component is deactivated.
	 * 
	 * @param context
	 */
	@Deactivate
	public void deactivate(ComponentContext context) {
		this.workloadActivator.unbindWorkloadComponent();
		this.workloadActivator = null;
	}
}
