package de.uka.ipd.sdq.simucomframework.probes;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;

import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;
import org.palladiosimulator.probeframework.probes.BasicEventProbe;

import de.uka.ipd.sdq.simucomframework.ResourceRegistry;
import de.uka.ipd.sdq.simucomframework.resources.IResourceEnvironmentListener;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedResourceContainer;

/**
 * Probes the number of resource containers within a resource environment. The probe listens to a
 * resource registry (event source type), informing about any changes within the resource
 * environment. Therefore, the probe has to implement the <code>IResourceEnvironmentListener</code>
 * interface and to register itself in the <code>registerListener</code> method to this resource
 * registry.
 * 
 * @author Sebastian Lehrig
 */
public class TakeNumberOfResourceContainersProbe extends BasicEventProbe<ResourceRegistry, Long, Dimensionless>
        implements IResourceEnvironmentListener {

    /**
     * Default constructor.
     * 
     * @param resourceRegistry
     *            The event source is a resource registry, thus, notifying about newly available and
     *            shut-down resource containers.
     */
    public TakeNumberOfResourceContainersProbe(final ResourceRegistry resourceRegistry) {
        super(resourceRegistry, MetricDescriptionConstants.NUMBER_OF_RESOURCE_CONTAINERS);
    }

    /**
     * Registers this class as an observer of the resource registry (event source type).
     */
    @Override
    protected void registerListener() {
        this.eventSource.addObserver(this);
    }

    @Override
    public void addedResourceContainer(final SimulatedResourceContainer container, final long totalContainers) {
        notify(Measure.valueOf(totalContainers, Dimensionless.UNIT));
    }

    @Override
    public void removedResourceContainer(final SimulatedResourceContainer container, final long totalContainers) {
        notify(Measure.valueOf(totalContainers, Dimensionless.UNIT));
    }
}
