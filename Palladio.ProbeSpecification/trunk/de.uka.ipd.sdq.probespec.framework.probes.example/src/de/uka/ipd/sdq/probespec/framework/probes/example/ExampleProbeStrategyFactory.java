package de.uka.ipd.sdq.probespec.framework.probes.example;

import de.uka.ipd.sdq.probespec.framework.probes.AProbeStrategyFactory;
import de.uka.ipd.sdq.probespec.framework.probes.ATakeCPUDemandStrategy;
import de.uka.ipd.sdq.probespec.framework.probes.ATakeCPUStateStrategy;
import de.uka.ipd.sdq.probespec.framework.probes.ATakeCurrentTimeStrategy;
import de.uka.ipd.sdq.probespec.framework.probes.ATakeHDDDemandStrategy;
import de.uka.ipd.sdq.probespec.framework.probes.ATakeHDDStateStrategy;
import de.uka.ipd.sdq.probespec.framework.probes.ATakePassiveResourceStateStrategy;
import de.uka.ipd.sdq.probespec.framework.probes.ATakeSEFFParameterStrategy;
import de.uka.ipd.sdq.probespec.framework.probes.ATakeStoExStrategy;

/**
 * Provides a specialized {@link AProbeStrategyFactory} for demonstration
 * purposes. It is in particular used inside of several test cases.
 * 
 * @author pmerkle
 * 
 */
public class ExampleProbeStrategyFactory extends AProbeStrategyFactory {

	private SimpleSimulationContext ctx;

	private ATakeCurrentTimeStrategy takeCurrentTime;

	private ATakeCPUStateStrategy takeCPUState;
	
	private ATakeHDDStateStrategy takeHDDState;
	
	private ATakePassiveResourceStateStrategy takePassiveResourceState;
	
	private ATakeCPUDemandStrategy takeCPUDemand;
	
	private ATakeHDDDemandStrategy takeHDDDemand;
	
	private ATakeStoExStrategy takeStoEx;
	
	private ATakeSEFFParameterStrategy takeSEFFParameter;

	/**
	 * Class constructor specifying the example simulation context.
	 * 
	 * @param ctx
	 *            the example simulation context
	 * @see SimpleSimulationContext
	 */
	public ExampleProbeStrategyFactory(SimpleSimulationContext ctx) {
		this.ctx = ctx;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ATakeCurrentTimeStrategy getTakeCurrentTime() {
		if (takeCurrentTime == null) {
			takeCurrentTime = new ExampleTakeCurrentTimeStrategy(ctx);
		}
		return takeCurrentTime;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ATakeCPUStateStrategy getTakeCPUState() {
		if (takeCPUState == null) {
			takeCPUState = new ExampleTakeCPUStateStrategy();
		}
		return takeCPUState;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ATakeHDDStateStrategy getTakeHDDState() {
		if (takeHDDState == null) {
			takeHDDState = new ExampleTakeHDDStateStrategy();
		}
		return takeHDDState;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ATakePassiveResourceStateStrategy getTakePassiveResourceStateStrategy() {
		if (takePassiveResourceState == null) {
			takePassiveResourceState = new ExampleTakePassiveResourceState();
		}
		return takePassiveResourceState;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ATakeCPUDemandStrategy getTakeCPUDemand() {
		if (takeCPUDemand == null) {
			takeCPUDemand = new ExampleTakeCPUDemandStrategy();
		}
		return takeCPUDemand;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ATakeHDDDemandStrategy getTakeHDDDemand() {
		if (takeHDDDemand == null) {
			takeHDDDemand = new ExampleTakeHDDDemandStrategy();
		}
		return takeHDDDemand;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ATakeStoExStrategy getStoExStrategy() {
		if (takeStoEx == null) {
			takeStoEx = new ExampleTakeStoExStrategy();
		}
		return takeStoEx;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ATakeSEFFParameterStrategy getSEFFParameterStrategy() {
		if (takeSEFFParameter == null) {
			takeSEFFParameter = new ExampleTakeSEFFParameterStrategy();
		}
		return takeSEFFParameter;
	}
	
	
	
}
