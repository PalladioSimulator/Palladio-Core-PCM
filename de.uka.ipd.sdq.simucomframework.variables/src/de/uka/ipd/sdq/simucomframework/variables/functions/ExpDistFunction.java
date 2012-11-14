package de.uka.ipd.sdq.simucomframework.variables.functions;

import java.util.List;

import de.uka.ipd.sdq.probfunction.math.IExponentialDistribution;
import de.uka.ipd.sdq.probfunction.math.IPDFFactory;
import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;

import de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter;

public class ExpDistFunction extends AbstractProbDistFunction {

	
	public ExpDistFunction(IRandomGenerator stream, IPDFFactory factory) {
		super(stream, factory);
	}

	public boolean checkParameters(List<Object> parameters) {
		if (parameters.size() != 1)
			return false;
		if (NumberConverter.toDouble(parameters.get(0)) <= 0)
			return false;
		return true;
	}

	public Object evaluate(List<Object> parameters) {
		double lambda = NumberConverter.toDouble(parameters.get(0));
		IExponentialDistribution distribution = factory.createExponentialDistribution(lambda);
		return distribution.inverseF(randomGen.random());
	}

}
