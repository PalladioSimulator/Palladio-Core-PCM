package org.palladiosimulator.protocom.framework.java.ee.stubs;

public class ProbabilityFunctionFactoryImpl implements IProbabilityFunctionFactory {
	public static ProbabilityFunctionFactoryImpl getInstance() {
		return new ProbabilityFunctionFactoryImpl();
	}

	@Override
	public void setRandomGenerator(IRandomGenerator randomGenerator) {
	}
}
