package edu.kit.ipd.sdq.eventsim.resources;

import java.util.HashMap;
import java.util.Map;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.probes.IProbeStrategyRegistry;
import edu.kit.ipd.sdq.eventsim.AbstractEventSimModel;
import edu.kit.ipd.sdq.eventsim.resources.entities.SimPassiveResource;
import edu.kit.ipd.sdq.eventsim.resources.entities.SimulatedProcess;
import edu.kit.ipd.sdq.eventsim.resources.probespec.commands.BuildPassiveResourceCalculators;
import edu.kit.ipd.sdq.eventsim.resources.probespec.commands.MountPassiveResourceProbes;
import edu.kit.ipd.sdq.eventsim.resources.probespec.probes.TakePassiveResourceStateStrategy;
import edu.kit.ipd.sdq.eventsim.util.PCMEntityHelper;
import edu.kit.ipd.sdq.simcomp.component.IRequest;
import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;

public class EventSimPassiveResourceModel extends AbstractEventSimModel {
	
//	private final PassiveResourceRegistry passiveResourceRegistry;

	// TODO give me a better name
    // maps (AssemblyContext ID, PassiveResource ID) -> SimPassiveResource
    private Map<String, SimPassiveResource> map;
    
    private Map<IRequest, SimulatedProcess> requestToSimulatedProcessMap;
	
	public EventSimPassiveResourceModel(ISimulationMiddleware middleware) {
		super(middleware);
//		this.passiveResourceRegistry = new PassiveResourceRegistry();
		map = new HashMap<String, SimPassiveResource>();
		
		requestToSimulatedProcessMap = new HashMap<IRequest, SimulatedProcess>();
	}

	@Override
	public void init() {
		// initialize the probe specification
		this.initProbeSpecification();
	}

	private void initProbeSpecification() {
		ProbeSpecContext probeContext = this.getSimulationMiddleware().getProbeSpecContext();
		IProbeStrategyRegistry strategyRegistry = probeContext.getProbeStrategyRegistry();

		/* RESOURCE_STATE */
		// passive resources
		strategyRegistry.registerProbeStrategy(new TakePassiveResourceStateStrategy(), ProbeType.RESOURCE_STATE, SimPassiveResource.class);

	}

	public boolean acquire(IRequest request, AssemblyContext assCtx, PassiveResource specification, int i, boolean b, double timeoutValue) {
//		Request eventSimRequest = (Request) request;
//		ComponentInstance component = eventSimRequest.getRequestState().getComponent();
        SimPassiveResource res = this.getPassiveResource(specification, assCtx);
        boolean acquired = res.acquire(getOrCreateSimulatedProcess(request), i, b, timeoutValue);

		return acquired;
	}

	public void release(IRequest request, AssemblyContext assCtx, PassiveResource specification, int i) {
//		Request eventSimRequest = (Request) request;
//		ComponentInstance component = eventSimRequest.getRequestState().getComponent();
        final SimPassiveResource res = this.getPassiveResource(specification, assCtx);
        res.release(getOrCreateSimulatedProcess(request), 1);
	}

//	/**
//	 * Returns the registry for passive resources.
//	 * 
//	 * @return
//	 */
//	public PassiveResourceRegistry getPassiveResourceRegistry() {
//		return this.passiveResourceRegistry;
//	}

    /**
     * @param specification
     *            the passive resource specification
     * @return the resource instance for the given resource specification
     */
    public SimPassiveResource getPassiveResource(final PassiveResource specification, AssemblyContext assCtx) {
        final SimPassiveResource simResource = map.get(assCtx); //this.getPassiveResourceRegistry().getPassiveResourceForContext(specification, component.getAssemblyCtx());
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
        if (!map.containsKey(compoundKey(assCtx, specification))) {
//            if (parent != null) {
//                return parent.findResource(type);
//            } else {
//                return null;
//            }
        	// TODO create resource
            // create resource
//            ResourceType resourceType = s.getActiveResourceType_ActiveResourceSpecification();
        	
        	
        	
        	
        	
//        	RepositoryComponent component = assCtx.getEncapsulatedComponent__AssemblyContext();
//            BasicComponent basicComponent = null;
//            if (RepositoryPackage.eINSTANCE.getBasicComponent().isInstance(component)) {
//                basicComponent = (BasicComponent) component;
//            } else {
//                throw new EventSimException("Currently, only BasicComponents are supported, but found a "
//                        + component.eClass().getName());
//            }
//
//            // for each passive resource specification
//            PassiveResource pr = null;
//            for (PassiveResource s : basicComponent.getPassiveResource_BasicComponent()) {
//
//            }
        	
        	
            // create passive resource
            SimPassiveResource simResource = ResourceFactory.createPassiveResource(this, specification, assCtx);

            // register the created passive resource
            map.put(compoundKey(assCtx, specification), simResource);
            
//            this.passiveResourceRegistry.registerPassiveResource(s, simResource, ctx.getAssemblyContext_AllocationContext());
            
    		// build calculators
    		this.execute(new BuildPassiveResourceCalculators(this, simResource));
    		
    		// mount probes
    		this.execute(new MountPassiveResourceProbes(this, simResource));
            
        	
        }
        return map.get(compoundKey(assCtx, specification));
    }
    

    
    /**
     * Returns the simulated process that is used to schedule resource requests issued by this
     * Request on an active or passive resource.
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
    
	private String compoundKey(AssemblyContext specification,
			PassiveResource resource) {
		// TODO better use resource name "CPU", HDD, ... as second component!?
		return specification.getId() + resource.getId();
	}
    
}
