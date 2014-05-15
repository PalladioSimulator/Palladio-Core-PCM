package edu.kit.ipd.sdq.eventsim.resources;

import java.util.Map;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand;
import de.uka.ipd.sdq.scheduler.ISchedulingFactory;
import de.uka.ipd.sdq.scheduler.factory.SchedulingFactory;
import de.uka.ipd.sdq.scheduler.resources.active.AbstractActiveResource;
import de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter;
import edu.kit.ipd.sdq.eventsim.AbstractEventSimModel;
import edu.kit.ipd.sdq.eventsim.entities.Request;
import edu.kit.ipd.sdq.eventsim.interpreter.state.RequestState;
import edu.kit.ipd.sdq.eventsim.resources.command.BuildComponentInstances;
import edu.kit.ipd.sdq.eventsim.resources.entities.SimActiveResource;
import edu.kit.ipd.sdq.eventsim.resources.probespec.commands.BuildActiveResourceCalculators;
import edu.kit.ipd.sdq.eventsim.resources.probespec.commands.MountActiveResourceProbes;
import edu.kit.ipd.sdq.eventsim.resources.staticstructure.AllocationRegistry;
import edu.kit.ipd.sdq.eventsim.resources.staticstructure.SimulatedResourceContainer;
import edu.kit.ipd.sdq.eventsim.resources.staticstructure.SimulatedResourceEnvironment;
import edu.kit.ipd.sdq.eventsim.resources.staticstructure.commands.BuildResourceAllocation;
import edu.kit.ipd.sdq.eventsim.resources.staticstructure.commands.BuildSimulatedResourceEnvironment;
import edu.kit.ipd.sdq.eventsim.staticstructure.ComponentInstance;
import edu.kit.ipd.sdq.simcomp.component.IRequest;
import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;
import edu.kit.ipd.sdq.simcomp.middleware.simulation.SimulationModel;

public class EventSimActiveResourceModel extends AbstractEventSimModel {

	private ISchedulingFactory schedulingFactory;
	private SimulatedResourceEnvironment resourceEnvironment;
	private AllocationRegistry resourceAllocation;
	private Map<String, ComponentInstance> componentRegistry;

	public EventSimActiveResourceModel(ISimulationMiddleware middleware) {
		super(middleware);
	}

	@Override
	public void init() {
		// set up the resource scheduler
		SimulationModel simModel = (SimulationModel) this.getSimulationMiddleware().getSimulationModel();
		this.schedulingFactory = new SchedulingFactory(simModel);

		// initialise resource environment and allocation
		this.resourceEnvironment = this.execute(new BuildSimulatedResourceEnvironment(this, schedulingFactory));
		this.resourceAllocation = this.execute(new BuildResourceAllocation(this.resourceEnvironment));

		// initialise component instances
		this.componentRegistry = this.execute(new BuildComponentInstances(this, this.resourceAllocation));

		// initialize the probe specification
		this.initProbeSpecification();
	}

	/**
	 * Initializes the Probe Specification by setting up the calculators and
	 * mounting the probes.
	 */
	private void initProbeSpecification() {

		// build calculators
		this.execute(new BuildActiveResourceCalculators(this, this.resourceEnvironment));

		// mount probes
		this.execute(new MountActiveResourceProbes(this, this.resourceEnvironment));
	}

	public void consume(IRequest request, ParametricResourceDemand demand) {
		Request eventSimRequest = (Request) request;

		RequestState state = eventSimRequest.getRequestState();
		final ProcessingResourceType resourceType = demand.getRequiredResource_ParametricResourceDemand();
		final PCMRandomVariable demandSpecification = demand.getSpecification_ParametericResourceDemand();

		final double absoluteDemand = NumberConverter.toDouble(state.getStoExContext().evaluate(demandSpecification.getSpecification()));

		final SimulatedResourceContainer resourceContainer = (SimulatedResourceContainer) state.getComponent().getResourceContainer();

		System.out.println("fetch resource (type: " + resourceType.getEntityName() + ")");
		final SimActiveResource resource = resourceContainer.findResource(resourceType);
		if (resource == null) {
			throw new RuntimeException("Could not find a resource of type " + resourceType.getEntityName());
		}

		System.out.println("consume resource " + resourceType.getEntityName() + " (demand: " + demand + ")");
		resource.consumeResource(eventSimRequest.getSimulatedProcess(), absoluteDemand);
	}

	@Override
	public void finalise() {
		super.finalise();

		// deactivate all resources
		for (SimulatedResourceContainer c : this.resourceEnvironment.getResourceContainers()) {
			for (SimActiveResource r : c.getResources()) {
				r.deactivateResource();
			}
		}

		AbstractActiveResource.cleanProcesses();
	}

	/**
	 * Returns the resource environment comprising
	 * {@link SimulatedResourceContainer}.
	 * 
	 * @return the resource environment
	 */
	public SimulatedResourceEnvironment getResourceEnvironment() {
		return this.resourceEnvironment;
	}

	/**
	 * Returns the allocation of {@link AssemblyContext}s to
	 * {@link SimulatedResourceContainer}s.
	 * 
	 * @return a registry containing the resource allocations
	 */
	public AllocationRegistry getResourceAllocation() {
		return this.resourceAllocation;
	}

	/**
	 * Returns the component instance that is encapsulated by the specified
	 * assembly context.
	 * 
	 * @param assemblyContext
	 *            the assembly context
	 * @return the queried component instance
	 */
	public ComponentInstance getComponent(final AssemblyContext assemblyContext) {
		return this.componentRegistry.get(assemblyContext.getId());
	}

	public ISchedulingFactory getSchedulingFactory() {
		return schedulingFactory;
	}

}
