package edu.kit.ipd.sdq.eventsim.resources;

import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import edu.kit.ipd.sdq.eventsim.AbstractEventSimModel;
import edu.kit.ipd.sdq.eventsim.entities.Request;
import edu.kit.ipd.sdq.eventsim.interpreter.state.RequestState;
import edu.kit.ipd.sdq.eventsim.resources.entities.SimPassiveResource;
import edu.kit.ipd.sdq.eventsim.resources.probespec.commands.BuildPassiveResourceCalculators;
import edu.kit.ipd.sdq.eventsim.resources.probespec.commands.MountPassiveResourceProbes;
import edu.kit.ipd.sdq.eventsim.resources.staticstructure.PassiveResourceRegistry;
import edu.kit.ipd.sdq.eventsim.resources.staticstructure.commands.BuildAndRegisterPassiveResources;
import edu.kit.ipd.sdq.eventsim.util.PCMEntityHelper;
import edu.kit.ipd.sdq.simcomp.component.IRequest;
import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;

public class EventSimPassiveResourceModel extends AbstractEventSimModel {
	
	private final PassiveResourceRegistry passiveResourceRegistry;

	public EventSimPassiveResourceModel(ISimulationMiddleware middleware) {
		super(middleware);
		this.passiveResourceRegistry = new PassiveResourceRegistry();
	}

	@Override
	public void init() {

		// initialize passive resources
		this.execute(new BuildAndRegisterPassiveResources(this, this.passiveResourceRegistry));

		// initialize the probe specification
		this.initProbeSpecification();
	}

	/**
	 * Initializes the Probe Specification by setting up the calculators and mounting the probes.
	 */
	private void initProbeSpecification() {

		// build calculators
		this.execute(new BuildPassiveResourceCalculators(this, this.passiveResourceRegistry));
		
		// mount probes
		this.execute(new MountPassiveResourceProbes(this, this.passiveResourceRegistry));
	}

	public boolean acquire(IRequest request, PassiveResource specification, int i, boolean b, double timeoutValue) {
		Request eventSimRequest = (Request) request;
        SimPassiveResource res = this.getPassiveResource(specification);
        boolean acquired = res.acquire(eventSimRequest.getSimulatedProcess(), i, b, timeoutValue);

		return acquired;
	}

	public void release(IRequest request, PassiveResource specification, int i) {
		Request eventSimRequest = (Request) request;
        final SimPassiveResource res = this.getPassiveResource(specification);
        res.release(eventSimRequest.getSimulatedProcess(), 1);
	}

	/**
	 * Returns the registry for passive resources.
	 * 
	 * @return
	 */
	public PassiveResourceRegistry getPassiveResourceRegistry() {
		return this.passiveResourceRegistry;
	}

    /**
     * @param specification
     *            the passive resource specification
     * @return the resource instance for the given resource specification
     */
    public SimPassiveResource getPassiveResource(final PassiveResource specification) {
        final SimPassiveResource simResource = this.getPassiveResourceRegistry().getPassiveResourceForContext(specification, this.assemblyCtx);
        if (simResource == null) {
            throw new RuntimeException("Passive resource " + PCMEntityHelper.toString(specification)
                    + " for assembly context " + PCMEntityHelper.toString(this.assemblyCtx) + " could not be found.");
        }
        return simResource;
    }

}
