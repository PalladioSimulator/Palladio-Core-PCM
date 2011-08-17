package de.uka.ipd.sdq.probespec.framework.probes;

import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.exceptions.ProbeStrategyNotFoundException;

/**
 * Provides {@link IProbeStrategy}s, suitable for taking a specified measurement
 * at a specified entity.
 * <p>
 * In general there are different ProbeStrategies for different types of
 * measurement (compare {@link ProbeType}). Moreover, for a fixed type of
 * measurement (e.g. waiting time) the ProbeStrategy often depends on the
 * measured entity (CPU, HDD, ...). For instance, in order to measure the CPU
 * waiting time, frequently a different measuring strategy is needed compared to
 * measuring the HDD waiting time. Thus, a ProbeStrategyRegistry manages a
 * mapping {ProbeType} x {measurable entity} -> ProbeStrategy.
 * 
 * @author Philipp Merkle
 * 
 */
public interface IProbeStrategyRegistry {

	/**
	 * Adds a new mapping from <code>(type, measurableEntity)</code> to
	 * <code>strategy</code>.
	 * 
	 * @param strategy
	 * @param type
	 *            the measurement type the strategy is able to conduct
	 * @param measurableEntity
	 *            the entity the strategy is able to measure. <code>null</code>,
	 *            if there is no need for distinguish entities.
	 */
	public void registerProbeStrategy(IProbeStrategy strategy, ProbeType type,
			Object measurableEntity);

	/**
	 * Returns the {@link IProbeStrategy}, suitable for taking a measurement of
	 * the specified type for the specified entity.
	 * 
	 * @param type
	 *            the type which is to be measured
	 * @param measurableEntity
	 *            the entity which is to be measured
	 * @return the suitable measuring strategy. null, if such a strategy has not
	 *         been registered.
	 */
	public IProbeStrategy getProbeStrategy(ProbeType type,
			Object measurableEntity) throws ProbeStrategyNotFoundException;

}
