package de.uka.ipd.sdq.simucomframework.probes;

import de.uka.ipd.sdq.probespec.framework.probes.AProbeStrategyFactory;
import de.uka.ipd.sdq.probespec.framework.probes.ATakeCPUDemandStrategy;
import de.uka.ipd.sdq.probespec.framework.probes.ATakeCPUStateStrategy;
import de.uka.ipd.sdq.probespec.framework.probes.ATakeCurrentTimeStrategy;
import de.uka.ipd.sdq.probespec.framework.probes.ATakeHDDDemandStrategy;
import de.uka.ipd.sdq.probespec.framework.probes.ATakeHDDStateStrategy;
import de.uka.ipd.sdq.probespec.framework.probes.ATakePassiveResourceStateStrategy;
import de.uka.ipd.sdq.probespec.framework.probes.ATakeSEFFParameterStrategy;
import de.uka.ipd.sdq.probespec.framework.probes.ATakeStoExStrategy;

public class SimuComProbeStrategyFactory extends AProbeStrategyFactory {

	private ATakeCurrentTimeStrategy takeCurrentTimeStrategy; 
	
	@Override
	public ATakeSEFFParameterStrategy getSEFFParameterStrategy() {
		throw new RuntimeException("Not yet implemented!");
	}

	@Override
	public ATakeStoExStrategy getStoExStrategy() {
		throw new RuntimeException("Not yet implemented!");
	}

	@Override
	public ATakeCPUDemandStrategy getTakeCPUDemand() {
		throw new RuntimeException("Not yet implemented!");
	}

	@Override
	public ATakeCPUStateStrategy getTakeCPUState() {
		throw new RuntimeException("Not yet implemented!");
	}

	@Override
	public ATakeCurrentTimeStrategy getTakeCurrentTime() {
		if (takeCurrentTimeStrategy == null) {
			takeCurrentTimeStrategy = new SimuComTakeCurrentTimeStrategy();
		} 
		return takeCurrentTimeStrategy;
	}

	@Override
	public ATakeHDDDemandStrategy getTakeHDDDemand() {
		throw new RuntimeException("Not yet implemented!");
	}

	@Override
	public ATakeHDDStateStrategy getTakeHDDState() {
		throw new RuntimeException("Not yet implemented!");
	}

	@Override
	public ATakePassiveResourceStateStrategy getTakePassiveResourceStateStrategy() {
		throw new RuntimeException("Not yet implemented!");
	}

}
