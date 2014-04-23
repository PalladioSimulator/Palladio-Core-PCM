package de.uka.ipd.sdq.simucomframework.probes;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.measure.unit.SI;

import org.palladiosimulator.metricspec.MetricDescriptionConstants;
import org.palladiosimulator.probeframework.probes.BasicEventProbe;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.simucomframework.resources.AbstractScheduledResource;
import de.uka.ipd.sdq.simucomframework.resources.IDemandListener;
import de.uka.ipd.sdq.simucomframework.resources.ScheduledResource;

/**
 * ProbeStrategy which is able to measure the demanded time of a {@link ScheduledResource}. The unit
 * is assumed to be {@link SI#SECOND}.
 * 
 * @author Steffen Becker, Philipp Merkle
 * 
 */
public class TakeScheduledResourceDemandProbe extends BasicEventProbe<AbstractScheduledResource, Double, Duration> implements IDemandListener {

    public TakeScheduledResourceDemandProbe(final AbstractScheduledResource r) {
        super(r,MetricDescriptionConstants.RESOURCE_DEMAND_METRIC);
    }

    @Override
    public void demand(final double demand) {
        notify(Measure.valueOf(demand, SI.SECOND));
    }

    @Override
    public void demandCompleted(final ISchedulableProcess simProcess) {
    }

    @Override
    protected void registerListener() {
        this.eventSource.addDemandListener(this);
    }
}
