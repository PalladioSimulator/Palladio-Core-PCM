package de.uka.ipd.sdq.probespec.framework.probes.example;

import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.probes.ProbeStrategyRegistry;

/**
 * Implementation of the {@link IProbeStrategyRegistry} interface for
 * demonstration purposes.
 * <p>
 * Invoking the default constructor registers ProbeStrategies for the following
 * <code>({@link ProbeType}, measurable entity)</code>-pairs.
 * <ul>
 * <li>{@link ProbeType#CURRENT_TIME}, <code>null</code></li>
 * <li>{@link ProbeType#RESOURCE_DEMAND}, {@link SimpleCPUResource}</li>
 * <li>{@link ProbeType#RESOURCE_STATE}, {@link SimpleCPUResource}</li>
 * <li>{@link ProbeType#RESOURCE_STATE}, {@link ASimplePassiveResource}</li>
 * <li>{@link ProbeType#SEFF_PARAMETER}, {@link SimpleSEFFParameter}</li>
 * <li>{@link ProbeType#STOEX}, {@link SimpleStoEx}</li>
 * </ul>
 * 
 * @author Philipp Merkle
 * 
 */
public class ExampleProbeStrategyRegistry extends ProbeStrategyRegistry {

	/**
	 * Default constructor. Sets up the specific ProbeStrategies as described
	 * above.
	 */
	public ExampleProbeStrategyRegistry() {
		setupProbeStrategies();
	}

	private void setupProbeStrategies() {
		/* CURRENT_TIME */
		registerProbeStrategy(new ExampleTakeCurrentTimeStrategy(),
				ProbeType.CURRENT_TIME, null);

		/* RESOURCE_DEMAND */
		// active resources
		registerProbeStrategy(new ExampleTakeCPUDemandStrategy(),
				ProbeType.RESOURCE_DEMAND, SimpleCPUResource.class);

		/* RESOURCE_STATE */
		// scheduled resources
		registerProbeStrategy(new ExampleTakeCPUStateStrategy(),
				ProbeType.RESOURCE_STATE, SimpleCPUResource.class);

		// passive resources
		registerProbeStrategy(new ExampleTakePassiveResourceState(),
				ProbeType.RESOURCE_STATE, ASimplePassiveResource.class);

		/* SEFF_PARAMETER */
		registerProbeStrategy(new ExampleTakeSEFFParameterStrategy(),
				ProbeType.SEFF_PARAMETER, SimpleSEFFParameter.class);
		
		/* STOEX */
		registerProbeStrategy(new ExampleTakeStoExStrategy(),
				ProbeType.STOEX, SimpleStoEx.class);
	}

}
