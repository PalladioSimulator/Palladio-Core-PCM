package de.uka.ipd.sdq.simucomframework.probes;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.measure.unit.SI;

import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;
import org.palladiosimulator.probeframework.probes.BasicEventProbe;

import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.simucomframework.resources.AbstractScheduledResource;
import de.uka.ipd.sdq.simucomframework.resources.IDemandListener;

/**
 * Measures a resource demand metric (in seconds) by listening to demands to a scheduled resource
 * (event source type). Therefore, it has to implement the <code>IDemandListener</code> interface
 * and to register itself in the <code>registerListener</code> method to this scheduled resource.
 * The measured demand is directly received by the <code>demand</code> call-back method of the
 * listener.
 * 
 * @author Sebastian Lehrig, Steffen Becker
 * 
 */
public class TakeScheduledResourceDemandProbe extends BasicEventProbe<AbstractScheduledResource, Double, Duration>
        implements IDemandListener {

    /**
     * Default constructor.
     * 
     * @param resource
     *            The event source is a scheduled resource, thus, notifying about newly available
     *            demands.
     */
    public TakeScheduledResourceDemandProbe(final AbstractScheduledResource resource) {
        super(resource, MetricDescriptionConstants.RESOURCE_DEMAND_METRIC);
    }

    /**
     * The demand measure is directly forwarded to the notify method.
     */
    @Override
    public void demand(final double demand) {
        notify(Measure.valueOf(demand, SI.SECOND));
    }

    /**
     * No need to react on demand completion within this probe.
     */
    @Override
    public void demandCompleted(final ISchedulableProcess simProcess) {
    }

    /**
     * Registers this class to the scheduled resource (event source type).
     */
    @Override
    protected void registerListener() {
        this.eventSource.addDemandListener(this);
    }
}
