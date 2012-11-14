package de.uka.ipd.sdq.simucomframework.probes;

import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.probes.IProbeStrategyRegistry;
import de.uka.ipd.sdq.probespec.framework.probes.ProbeStrategyRegistry;
import de.uka.ipd.sdq.scheduler.IPassiveResource;
import de.uka.ipd.sdq.simucomframework.resources.AbstractScheduledResource;

/**
 * Implementation of the {@link IProbeStrategyRegistry} interface for SimuCom.
 * <p>
 * Invoking the default constructor registers ProbeStrategies for the following
 * <code>({@link ProbeType}, measurable entity)</code>-pairs.
 * <ul>
 * <li>{@link ProbeType#CURRENT_TIME}, <code>null</code></li>
 * <li>{@link ProbeType#RESOURCE_DEMAND}, {@link AbstractScheduledResource}</li>
 * <li>{@link ProbeType#RESOURCE_STATE}, {@link AbstractScheduledResource}</li>
 * <li>{@link ProbeType#RESOURCE_STATE}, {@link IPassiveResource}</li>
 * <li>{@link ProbeType#EXECUTION_RESULT}, <code>null</code></li>
 * </ul>
 * 
 * @author Philipp Merkle, brosch
 * 
 */
public class SimuComProbeStrategyRegistry extends ProbeStrategyRegistry {

	/**
	 * Default constructor. Sets up the SimuCom specific ProbeStrategies as
	 * described above.
	 */
	public SimuComProbeStrategyRegistry() {
		setupProbeStrategies();
	}

	private void setupProbeStrategies() {
		/* CURRENT_TIME */
		registerProbeStrategy(new TakeSimulatedTimeStrategy(),
				ProbeType.CURRENT_TIME, null);

		/* RESOURCE_DEMAND */
		// scheduled resources
		registerProbeStrategy(new TakeScheduledResourceDemandStrategy(),
				ProbeType.RESOURCE_DEMAND, AbstractScheduledResource.class);

		/* RESOURCE_STATE */
		// scheduled resources
		registerProbeStrategy(new TakeScheduledResourceStateStrategy(),
				ProbeType.RESOURCE_STATE, AbstractScheduledResource.class);

		// passive resources
		registerProbeStrategy(new TakePassiveResourceStateStrategy(),
				ProbeType.RESOURCE_STATE, IPassiveResource.class);

		// execution result
		registerProbeStrategy(new TakeExecutionResultStrategy(),
				ProbeType.EXECUTION_RESULT, null);
	}

}
