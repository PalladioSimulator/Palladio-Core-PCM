package de.uka.ipd.sdq.probespec.framework.probes;

/**
 * Provides an abstract factory for probe strategies.
 * <p>
 * Different simulation frameworks (or more general: software performance
 * analysis frameworks) requires different method to measure an aspect. To meet
 * these specific requirements, a suitable ProbeStrategyFactory can be
 * implemented. The specialized factory returns measuring methods (probe
 * strategies) for the several probe types. These measuring methods knows how to
 * take a sample when the specific simulation framework is used.
 * <p>
 * Subclasses should instantiate the various probe strategies only once and
 * return the cached object thereafter.
 * 
 * @author pmerkle
 * @see IProbeStrategy
 */
abstract public class AProbeStrategyFactory {

	/**
	 * Returns the probe strategy which is capable of measuring the current
	 * time.
	 * 
	 * @return the probe strategy which takes the current time
	 */
	abstract public ATakeCurrentTimeStrategy getTakeCurrentTime();

	/**
	 * Returns the probe strategy which is capable of measuring the state of a
	 * CPU active resource.
	 * 
	 * @return the probe strategy which takes a CPU state
	 */
	abstract public ATakeCPUStateStrategy getTakeCPUState();

	/**
	 * Returns the probe strategy which is capable of measuring the state of a
	 * HDD active resource.
	 * 
	 * @return the probe strategy which takes a HDD state
	 */
	abstract public ATakeHDDStateStrategy getTakeHDDState();

	/**
	 * Returns the probe strategy which is capable of measuring the state of a
	 * passive resource.
	 * 
	 * @return the probe strategy which takes a passive resource's state
	 */
	abstract public ATakePassiveResourceStateStrategy getTakePassiveResourceStateStrategy();

	/**
	 * Returns the probe strategy which is capable of measuring the resource
	 * demand induced by a CPU demanding entity.
	 * 
	 * @return the probe strategy which takes the CPU resource demand
	 */
	abstract public ATakeCPUDemandStrategy getTakeCPUDemand();

	/**
	 * Returns the probe strategy which is capable of measuring the resource
	 * demand induced by a HDD demanding entity.
	 * 
	 * @return the probe strategy which takes the HDD resource demand
	 */
	abstract public ATakeHDDDemandStrategy getTakeHDDDemand();

	/**
	 * Returns the probe strategy which is capable of measuring evaluated
	 * stochastic expressions (StoEx).
	 * 
	 * @return the probe strategy which takes the evaluated stochastic
	 *         expression
	 */
	abstract public ATakeStoExStrategy getStoExStrategy();

	/**
	 * Returns the probe strategy which is capable of measuring a service
	 * effect's (SEFF) parameter value.
	 * 
	 * @return the probe strategy which takes the value of a SEFF parameter
	 */
	abstract public ATakeSEFFParameterStrategy getSEFFParameterStrategy();

}
