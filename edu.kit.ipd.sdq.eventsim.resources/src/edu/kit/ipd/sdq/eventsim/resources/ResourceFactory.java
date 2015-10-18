package edu.kit.ipd.sdq.eventsim.resources;

import java.util.concurrent.atomic.AtomicLong;

import org.palladiosimulator.pcm.core.PCMRandomVariable;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.repository.PassiveResource;
import org.palladiosimulator.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import org.palladiosimulator.pcm.resourceenvironment.ProcessingResourceSpecification;

import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.IPassiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulingFactory;
import de.uka.ipd.sdq.simucomframework.resources.SchedulingStrategy;
import de.uka.ipd.sdq.simucomframework.resources.SimSimpleFairPassiveResource;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import edu.kit.ipd.sdq.eventsim.AbstractEventSimModel;
import edu.kit.ipd.sdq.eventsim.exceptions.unchecked.EventSimException;
import edu.kit.ipd.sdq.eventsim.middleware.simulation.SimulationModel;
import edu.kit.ipd.sdq.eventsim.resources.entities.SimActiveResource;
import edu.kit.ipd.sdq.eventsim.resources.entities.SimLinkingResource;
import edu.kit.ipd.sdq.eventsim.resources.entities.SimPassiveResource;

public class ResourceFactory {

	private static final boolean SIMULATE_FAILURES = false;
	private static AtomicLong idGenerator = new AtomicLong(0);

	/**
	 * Creates an active resource in accordance with the given resource
	 * specification.
	 * 
	 * @param model
	 *            the simulation model
	 * @param specification
	 *            the resource specification
	 * @return the created resource
	 */
	public static SimActiveResource createActiveResource(final AbstractEventSimModel model, ISchedulingFactory schedulingFactory, final ProcessingResourceSpecification specification) {
		// TODO reliability stuff
		// double mttf = specification.getMTTF();
		// double mttr = specification.getMTTR();
		final int numberOfReplicas = specification.getNumberOfReplicas();
		final PCMRandomVariable processingRate = specification.getProcessingRate_ProcessingResourceSpecification();
		final SchedulingPolicy schedulingPolicy = SchedulingPolicy.getPolicyForId(specification.getSchedulingPolicy().getId());

		IActiveResource resource = null;
		String resourceName;
		switch (schedulingPolicy) {
		case FCFS:
			resourceName = SchedulingStrategy.FCFS.toString();
			resource = schedulingFactory.createSimFCFSResource(resourceName, getNextResourceId());
			break;
		case DELAY:
			resourceName = SchedulingStrategy.DELAY.toString();
			resource = schedulingFactory.createSimDelayResource(resourceName, getNextResourceId());
			break;
		case PROCESSOR_SHARING:
			resourceName = SchedulingStrategy.PROCESSOR_SHARING.toString();
			resource = schedulingFactory.createSimProcessorSharingResource(resourceName, getNextResourceId(), numberOfReplicas);
			break;
		default:
			throw new EventSimException("Unknown scheduling policy: " + schedulingPolicy.toString());
		}

		final SimActiveResource r = new SimActiveResource(model, resource, processingRate.getSpecification(), numberOfReplicas, schedulingPolicy, specification);

		return r;
	}

	/**
	 * Creates a linking resource in accordance with the given resource
	 * specification.
	 * 
	 * @param model
	 *            the simulation model
	 * @param specification
	 *            the resource specification
	 * @return the created resource
	 */
	public static SimLinkingResource createLinkingResource(final AbstractEventSimModel model, final CommunicationLinkResourceSpecification specification) {

		final PCMRandomVariable latency = specification.getLatency_CommunicationLinkResourceSpecification();
		final PCMRandomVariable throughput = specification.getThroughput_CommunicationLinkResourceSpecification();

		String resourceName = SchedulingStrategy.FCFS.toString();
		EventSimActiveResourceModel systemModel = (EventSimActiveResourceModel) model;
		IActiveResource resource = systemModel.getSchedulingFactory().createSimFCFSResource(resourceName, getNextResourceId());

		final SimLinkingResource r = new SimLinkingResource(model, resource, latency.getSpecification(), throughput.getSpecification());

		return r;
	}

	/**
	 * Creates a passive resource in accordance with the given resource
	 * specification.
	 * 
	 * @param model
	 *            the simulation model
	 * @param specification
	 *            the resource specification
	 * @param operatingSystem
	 *            the operating system managing the passive resource
	 * @param assemblyCtx
	 *            the assembly context in which the passive resource is created
	 * @return the created resource
	 */
	public static SimPassiveResource createPassiveResource(final AbstractEventSimModel model, final PassiveResource specification, final AssemblyContext assemblyCtx) {
		// obtain capacity by evaluating the associated StoEx
		final PCMRandomVariable capacitySpecification = specification.getCapacity_PassiveResource();
		final int capacity = StackContext.evaluateStatic(capacitySpecification.getSpecification(), Integer.class);

		final String name = specification.getEntityName();
		final String resourceId = specification.getId();
		final String assemblyContextId = assemblyCtx.getId();
		final String combinedId = resourceId + ":" + assemblyContextId;

		// create the scheduler resource for the operating system
		SimulationModel simulationModel = (SimulationModel) model.getSimulationMiddleware().getSimulationModel();
//		IPassiveResource schedulerResource = new SimSimpleFairPassiveResource(simulationModel, capacity, name, resourceId, assemblyContextId, combinedId, SIMULATE_FAILURES);
		
		IPassiveResource schedulerResource = new SimSimpleFairPassiveResource(specification, assemblyCtx, simulationModel, 
        		new Long(capacity));

		return new SimPassiveResource(model, schedulerResource);
	}

	/**
	 * Creates a unique resource ID.
	 * 
	 * @return the ID
	 */
	private static String getNextResourceId() {
		return Long.toString(idGenerator.incrementAndGet());
	}

}
