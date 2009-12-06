package de.uka.ipd.sdq.simucomframework.calculator;

import de.uka.ipd.sdq.probespec.framework.SampleBlackboard;

public interface ICalculatorRepositoryFactory {

	public CalculatorRepository createCalculatorRepository(SampleBlackboard blackboard);
	
}
