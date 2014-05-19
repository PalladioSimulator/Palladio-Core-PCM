package edu.kit.ipd.sdq.eventsim.resources;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceType;
import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.probes.IProbeStrategyRegistry;
import de.uka.ipd.sdq.scheduler.ISchedulingFactory;
import de.uka.ipd.sdq.scheduler.factory.SchedulingFactory;
import de.uka.ipd.sdq.scheduler.resources.active.AbstractActiveResource;
import edu.kit.ipd.sdq.eventsim.AbstractEventSimModel;
import edu.kit.ipd.sdq.eventsim.entities.IEntityListener;
import edu.kit.ipd.sdq.eventsim.resources.entities.SimActiveResource;
import edu.kit.ipd.sdq.eventsim.resources.entities.SimulatedProcess;
import edu.kit.ipd.sdq.eventsim.resources.probespec.commands.BuildActiveResourceCalculators;
import edu.kit.ipd.sdq.eventsim.resources.probespec.commands.MountActiveResourceProbes;
import edu.kit.ipd.sdq.eventsim.resources.probespec.probes.TakeScheduledResourceDemandStrategy;
import edu.kit.ipd.sdq.eventsim.resources.probespec.probes.TakeScheduledResourceStateStrategy;
import edu.kit.ipd.sdq.eventsim.util.PCMEntityHelper;
import edu.kit.ipd.sdq.simcomp.component.IRequest;
import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;
import edu.kit.ipd.sdq.simcomp.middleware.simulation.SimulationModel;

public class EventSimActiveResourceModel extends AbstractEventSimModel {

	private static final Logger logger = Logger.getLogger(EventSimActiveResourceModel.class);

	private ISchedulingFactory schedulingFactory;

	// maps (ResourceContainer ID, ResourceType ID) -> SimActiveResource
	private Map<String, SimActiveResource> containerToResourceMap;

	private Map<IRequest, SimulatedProcess> requestToSimulatedProcessMap;

	public EventSimActiveResourceModel(ISimulationMiddleware middleware) {
		super(middleware);

		containerToResourceMap = new HashMap<String, SimActiveResource>();
		requestToSimulatedProcessMap = new HashMap<IRequest, SimulatedProcess>();
	}

	@Override
	public void init() {
		// set up the resource scheduler
		SimulationModel simModel = (SimulationModel) this.getSimulationMiddleware().getSimulationModel();
		this.schedulingFactory = new SchedulingFactory(simModel);

		this.initProbeSpecification();
	}

	private void initProbeSpecification() {
		ProbeSpecContext probeContext = this.getSimulationMiddleware().getProbeSpecContext();
		IProbeStrategyRegistry strategyRegistry = probeContext.getProbeStrategyRegistry();

		/* RESOURCE_DEMAND */
		// active resources
		strategyRegistry.registerProbeStrategy(new TakeScheduledResourceDemandStrategy(), ProbeType.RESOURCE_DEMAND, SimActiveResource.class);

		/* RESOURCE_STATE */
		// active resources
		strategyRegistry.registerProbeStrategy(new TakeScheduledResourceStateStrategy(), ProbeType.RESOURCE_STATE, SimActiveResource.class);

	}

	// TODO String type -> ResourceType type?
	public void consume(IRequest request, ResourceContainer resourceContainer, ResourceType resourceType, double absoluteDemand) {
		// Request eventSimRequest = (Request) request;
		//
		// RequestState state = eventSimRequest.getRequestState();
		// final ProcessingResourceType resourceType =
		// demand.getRequiredResource_ParametricResourceDemand();
		// final PCMRandomVariable demandSpecification =
		// demand.getSpecification_ParametericResourceDemand();
		//
		// final double absoluteDemand =
		// NumberConverter.toDouble(state.getStoExContext().evaluate(demandSpecification.getSpecification()));
		//
		// final SimulatedResourceContainer resourceContainer =
		// (SimulatedResourceContainer)
		// state.getComponent().getResourceContainer();

		System.out.println("fetch resource (type: " + resourceType.getEntityName() + ")");
		final SimActiveResource resource = findOrCreateResource(resourceContainer, resourceType);
		if (resource == null) {
			throw new RuntimeException("Could not find a resource of type " + resourceType.getEntityName());
		}

		System.out.println("consume resource " + resourceType.getEntityName() + " (demand: " + absoluteDemand + ")");
		resource.consumeResource(getOrCreateSimulatedProcess(request), absoluteDemand);
	}

	@Override
	public void finalise() {
		super.finalise();

		// TODO (SimComp) erzeugte Ressourcen merken und diese
		// aufräumen/deaktivieren

		// deactivate all resources
		// for (SimulatedResourceContainer c :
		// this.resourceEnvironment.getResourceContainers()) {
		// for (SimActiveResource r : c.getResources()) {
		// r.deactivateResource();
		// }
		// }

		AbstractActiveResource.cleanProcesses();
	}

	public ISchedulingFactory getSchedulingFactory() {
		return schedulingFactory;
	}

	/**
	 * Registers a resource for the specified resource type. Only one resource
	 * can be registered for each resource type. Thus, providing a resource for
	 * an already registered resource type overwrites the existing resource.
	 * 
	 * @param resource
	 *            the resource that is to be registered
	 * @param type
	 *            the type of the resource
	 */
	private void registerResource(ResourceContainer specification, SimActiveResource resource, ResourceType type) {
		if (logger.isDebugEnabled()) {
			logger.debug("Registering a " + type.getEntityName() + " resource at " + PCMEntityHelper.toString(specification));
		}
		if (this.containerToResourceMap.containsKey(type)) {
			if (logger.isEnabledFor(Level.WARN))
				logger.warn("Registered a resource of type " + type.getEntityName() + ", but there was already a resource of this type. The existing resource has been overwritten.");
		}

		this.containerToResourceMap.put(compoundKey(specification, type), resource);

		// initialise probe spec
		this.execute(new BuildActiveResourceCalculators(this, resource));
		this.execute(new MountActiveResourceProbes(this, resource));
	}

	/**
	 * Finds the resource that has been registered for the specified type. If no
	 * resource of the specified type can be found, the search continues with
	 * the parent resource container.
	 * 
	 * @param type
	 *            the resource type
	 * @return the resource of the specified type, if there is one; null else
	 */
	public SimActiveResource findOrCreateResource(ResourceContainer specification, ResourceType resourceType) {
		if (!containerToResourceMap.containsKey(compoundKey(specification, resourceType))) {
			// if (parent != null) {
			// return parent.findResource(type);
			// } else {
			// return null;
			// }
			// TODO create resource
			// create resource
			// ResourceType resourceType =
			// s.getActiveResourceType_ActiveResourceSpecification();

			ProcessingResourceSpecification s = null;
			for (ProcessingResourceSpecification spec : specification.getActiveResourceSpecifications_ResourceContainer()) {
				// TODO does this work!??
				if (spec.getActiveResourceType_ActiveResourceSpecification().equals(resourceType)) {
					s = spec;
					break;
				}
			}
			if (s == null) {
				// remove
				throw new RuntimeException("refactoring went wrong :(");
			}

			SimActiveResource resource = ResourceFactory.createActiveResource(this, schedulingFactory, s);
			resource.setDescription(specification.getEntityName() + " [" + resourceType.getEntityName() + "] <" + specification.getId() + ">");

			// register the created resource
			// TODO (SimComp) map.put here?
			registerResource(specification, resource, resourceType);
		}
		return containerToResourceMap.get(compoundKey(specification, resourceType));
	}

	// protected SimulatedProcess createSimulatedProcess(IRequest request) {
	// // initialise the simulated process by specifying its ID and a handler
	// that reacts when the
	// // process gets activated by the scheduler
	// SimulatedProcess process = new SimulatedProcess(this, request,
	// Long.toString(request.getId()));
	//
	// // add a handler that reacts when this Request has finished its execution
	// and informs the
	// // simulated process about that.
	//
	// // TODO (SimComp) get notified when request is finished!!!
	// // this.addEntityListener(new RequestFinishedHandler(process));
	//
	// return process;
	// }

	private String compoundKey(ResourceContainer specification, ResourceType resourceType) {
		// TODO better use resource name "CPU", HDD, ... as second component!?
		return specification.getId() + resourceType.getId();
	}

	/**
	 * This handler reacts when the Request has been finished and informs the
	 * simulated process about that.
	 * 
	 * @author Philipp Merkle
	 * 
	 */
	private static final class RequestFinishedHandler implements IEntityListener {

		private SimulatedProcess process;

		public RequestFinishedHandler(SimulatedProcess process) {
			this.process = process;
		}

		@Override
		public void leftSystem() {
			this.process.setFinished();
		}

		@Override
		public void enteredSystem() {
			// nothing to do
		}

	}

	/**
	 * Returns the simulated process that is used to schedule resource requests
	 * issued by this Request on an active or passive resource.
	 * 
	 * @return the simulated process
	 */
	public SimulatedProcess getOrCreateSimulatedProcess(IRequest request) {
		if (!requestToSimulatedProcessMap.containsKey(request)) {
			SimulatedProcess p = new SimulatedProcess(this, request, Long.toString(request.getId()));
			requestToSimulatedProcessMap.put(request, p);
		}
		return requestToSimulatedProcessMap.get(request);
	}

}
