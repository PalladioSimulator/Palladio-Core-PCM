package org.palladiosimulator.protocom.framework.jee.servlet.stubs;

public class ProbabilityFunctionFactoryImpl implements IProbabilityFunctionFactory {
	public static ProbabilityFunctionFactoryImpl getInstance() {
		return new ProbabilityFunctionFactoryImpl();
	}

	@Override
	public void setRandomGenerator(IRandomGenerator randomGenerator) {
	}
}
