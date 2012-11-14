package de.uka.ipd.sdq.simucomframework.variables.functions;

import java.util.List;

import de.uka.ipd.sdq.probfunction.math.IBinomialDistribution;
import de.uka.ipd.sdq.probfunction.math.IPDFFactory;
import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;

import de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter;

public class BinomFunction extends AbstractProbDistFunction {

	

	public BinomFunction(IRandomGenerator randomGen, IPDFFactory factory) {
		super(randomGen, factory);

	}

	public boolean checkParameters(List<Object> parameters) {
		if (parameters.size() == 2 &&
				(parameters.get(0) instanceof Integer) &&
				(parameters.get(1) instanceof Double))
		{
			return true;}
		else
		{
			return false;
		}

	}

	public Object evaluate(List<Object> parameters) {
		int n = (Integer) parameters.get(0);
		double p = NumberConverter.toDouble(parameters.get(1));
		IBinomialDistribution distribution = factory.createBinomialDistribution(n, p);
		return distribution.inverseF(randomGen.random());
		
	}

}
