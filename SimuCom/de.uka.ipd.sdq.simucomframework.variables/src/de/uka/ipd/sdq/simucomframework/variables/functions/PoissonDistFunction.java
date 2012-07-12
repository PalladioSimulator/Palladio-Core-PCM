package de.uka.ipd.sdq.simucomframework.variables.functions;

import java.util.List;

import de.uka.ipd.sdq.probfunction.math.IPDFFactory;
import de.uka.ipd.sdq.probfunction.math.IPoissonDistribution;
import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;
import de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter;

public class PoissonDistFunction extends AbstractProbDistFunction {

	

	public PoissonDistFunction(IRandomGenerator random, IPDFFactory factory) {
		super(random, factory);
	}

	public boolean checkParameters(List<Object> parameters) {
		if (parameters.size() != 1)
			return false;
		if (NumberConverter.toDouble(parameters.get(0)) < 0)
			return false;
		return true;
	}

	public Object evaluate(List<Object> parameters) {
		double mean = NumberConverter.toDouble(parameters.get(0));
		IPoissonDistribution distribution = factory.createPoissonDistribution(mean);
		return distribution.inverseF(randomGen.random());
	}

}
