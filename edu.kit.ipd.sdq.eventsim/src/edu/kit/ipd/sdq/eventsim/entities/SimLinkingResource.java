package edu.kit.ipd.sdq.eventsim.entities;

import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.simucomframework.Context;
import edu.kit.ipd.sdq.eventsim.EventSimModel;
import edu.kit.ipd.sdq.eventsim.resources.SchedulingPolicy;

public class SimLinkingResource extends SimActiveResource {

    private String latencySpecification;
    private String throughputSpecification;

    public SimLinkingResource(EventSimModel model, IActiveResource resource, String latencySpecification, String throughputSpecification) {
        super(model, resource, throughputSpecification, 1, SchedulingPolicy.FCFS);
        this.latencySpecification = latencySpecification;
        this.throughputSpecification = throughputSpecification;
    }

    @Override
    protected double calculateConcreteDemand(double abstractDemand) {
        // use calculation routine from super-class, but add latency
        return super.calculateConcreteDemand(abstractDemand) + Context.evaluateStatic(latencySpecification, Double.class);
    }

}
