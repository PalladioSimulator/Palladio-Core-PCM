package edu.kit.ipd.sdq.eventsim.resources;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.repository.PassiveResource;

import edu.kit.ipd.sdq.eventsim.AbstractEventSimModel;
import edu.kit.ipd.sdq.eventsim.measurement.MeasurementFacade;
import edu.kit.ipd.sdq.eventsim.measurement.r.RMeasurementStore;
import edu.kit.ipd.sdq.eventsim.resources.calculators.HoldTimeCalculator;
import edu.kit.ipd.sdq.eventsim.resources.calculators.WaitingTimeCalculator;
import edu.kit.ipd.sdq.eventsim.resources.entities.SimPassiveResource;
import edu.kit.ipd.sdq.eventsim.resources.entities.SimulatedProcess;
import edu.kit.ipd.sdq.eventsim.util.PCMEntityHelper;
import edu.kit.ipd.sdq.simcomp.component.IRequest;
import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;

public class EventSimPassiveResourceModel extends AbstractEventSimModel {

    // maps (AssemblyContext ID, PassiveResource ID) -> SimPassiveResource
    private Map<String, SimPassiveResource> contextToResourceMap;
    private WeakHashMap<IRequest, SimulatedProcess> requestToSimulatedProcessMap;
	
    private MeasurementFacade<ResourceProbeConfiguration> measurementFacade;
    
	public EventSimPassiveResourceModel(ISimulationMiddleware middleware) {
		super(middleware);
		contextToResourceMap = new HashMap<String, SimPassiveResource>();
		
		requestToSimulatedProcessMap = new WeakHashMap<>();
	}

	@Override
	public void init() {
		measurementFacade = new MeasurementFacade<>(new ResourceProbeConfiguration(), Activator.getContext()
				.getBundle());
		
		RMeasurementStore rstore = getSimulationMiddleware().getMeasurementStore();
		rstore.addIdExtractor(SimPassiveResource.class, c -> ((SimPassiveResource)c).getSpecification().getId());
	}

//	private void initProbeSpecification() {
//		ProbeSpecContext probeContext = this.getSimulationMiddleware().getProbeSpecContext();
//		IProbeStrategyRegistry strategyRegistry = probeContext.getProbeStrategyRegistry();
//
//		/* RESOURCE_STATE */
//		// passive resources
//		strategyRegistry.registerProbeStrategy(new TakePassiveResourceStateStrategy(), ProbeType.RESOURCE_STATE, SimPassiveResource.class);
//
//	}

	public boolean acquire(IRequest request, AssemblyContext assCtx, PassiveResource specification, int i, boolean b, double timeoutValue) {
        SimPassiveResource res = this.getPassiveResource(specification, assCtx);
        boolean acquired = res.acquire(getOrCreateSimulatedProcess(request), i, b, timeoutValue);

		return acquired;
	}

	/* (non-Javadoc)
	 * @see edu.kit.ipd.sdq.eventsim.AbstractEventSimModel#finalise()
	 */
	@Override
	public void finalise() {
		super.finalise();
		
		contextToResourceMap.clear();
		
		measurementFacade = null;
	}

	public void release(IRequest request, AssemblyContext assCtx, PassiveResource specification, int i) {
        final SimPassiveResource res = this.getPassiveResource(specification, assCtx);
        res.release(getOrCreateSimulatedProcess(request), 1);
	}

    /**
     * @param specification
     *            the passive resource specification
     * @return the resource instance for the given resource specification
     */
    public SimPassiveResource getPassiveResource(final PassiveResource specification, AssemblyContext assCtx) {
        final SimPassiveResource simResource = findOrCreateResource(specification, assCtx);
        if (simResource == null) {
            throw new RuntimeException("Passive resource " + PCMEntityHelper.toString(specification)
                    + " for assembly context " + PCMEntityHelper.toString(assCtx) + " could not be found.");
        }
        return simResource;
    }
    
    
    /**
     * Finds the resource that has been registered for the specified type. If no resource of the
     * specified type can be found, the search continues with the parent resource container.
     * 
     * @param type
     *            the resource type
     * @return the resource of the specified type, if there is one; null else
     */
    public SimPassiveResource findOrCreateResource(PassiveResource specification, AssemblyContext assCtx) {
        if (!contextToResourceMap.containsKey(compoundKey(assCtx, specification))) {
            // create passive resource
            SimPassiveResource resource = ResourceFactory.createPassiveResource(this, specification, assCtx);

            // register the created passive resource
            contextToResourceMap.put(compoundKey(assCtx, specification), resource);
            
    		// create probes and calculators
    		measurementFacade.createProbe(resource, "queue_length").forEachMeasurement(
    				m -> getSimulationMiddleware().getMeasurementStore().put(m));
    		
			measurementFacade.createCalculator(new HoldTimeCalculator()).from(resource, "acquire")
					.to(resource, "release").forEachMeasurement(m -> getSimulationMiddleware().getMeasurementStore().put(m));
			
			measurementFacade.createCalculator(new WaitingTimeCalculator()).from(resource, "request")
					.to(resource, "acquire").forEachMeasurement(m -> getSimulationMiddleware().getMeasurementStore().put(m));
        }
        return contextToResourceMap.get(compoundKey(assCtx, specification));
    }
    

    
    /**
     * Returns the simulated process that is used to schedule resource requests issued by this
     * Request on an active or passive resource.
     * 
     * @return the simulated process
     */
//    public SimulatedProcess getOrCreateSimulatedProcess(IRequest request) {
//        if (!requestToSimulatedProcessMap.containsKey(request)) {
//        	SimulatedProcess p = new SimulatedProcess(this, request, Long.toString(request.getId()));
//        	requestToSimulatedProcessMap.put(request, p);
//        }
//        return requestToSimulatedProcessMap.get(request);
//    }
    
    
    // TODO duplicate from active resource model
	public SimulatedProcess getOrCreateSimulatedProcess(IRequest request) {
		if (!requestToSimulatedProcessMap.containsKey(request)) {
			SimulatedProcess parent = null;
			if(request.getParent() != null) {
				parent = getOrCreateSimulatedProcess(request.getParent());
			}
			SimulatedProcess process = new SimulatedProcess(this, parent, request);

//			// add listener for request finish
//			EventSimEntity requestEntity = (EventSimEntity) request;
//			requestEntity.addEntityListener(new RequestFinishedHandler(process));

			requestToSimulatedProcessMap.put(request, process);
		}
		return requestToSimulatedProcessMap.get(request);
	}
    
	private String compoundKey(AssemblyContext specification,
			PassiveResource resource) {
		// TODO better use resource name "CPU", HDD, ... as second component!?
		return specification.getId() + resource.getId();
	}
    
}
