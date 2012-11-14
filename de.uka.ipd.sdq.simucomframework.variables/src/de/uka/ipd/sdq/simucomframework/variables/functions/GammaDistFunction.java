package de.uka.ipd.sdq.simucomframework.variables.functions;

import java.util.List;

import de.uka.ipd.sdq.probfunction.math.IGammaDistribution;
import de.uka.ipd.sdq.probfunction.math.IPDFFactory;
import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;
import de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter;

/**
 * Gamma distribution with shape alpha > 0 and scale parameter theta > 0
 * There is another way to write the gamma function with k = alpha or
 * rate parameter beta = 1/theta, 
 * @author Anne
 *
 */
public class GammaDistFunction extends AbstractProbDistFunction  {
	
	

	public GammaDistFunction(IRandomGenerator randomGen, IPDFFactory factory) {
		super(randomGen, factory);
	}

	public boolean checkParameters(List<Object> parameters) {
		//two parameters alpha and theta
		if (parameters.size() != 2)
			return false;
		//alpha needs to be larger than 0. 
		if (NumberConverter.toDouble(parameters.get(1)) <= 0)
			return false;
		//theta needs to be larger than 0. 
		if (NumberConverter.toDouble(parameters.get(0)) <= 0)
			return false;		
		return true;
	}

	public Object evaluate(List<Object> parameters) {
		double alpha = NumberConverter.toDouble(parameters.get(0));
		double theta= NumberConverter.toDouble(parameters.get(1));
		//alpha is alpha (also called k), lambda is 1/theta
		IGammaDistribution distribution = factory.createGammaDistribution(alpha, theta);
		return distribution.inverseF(randomGen.random());
	}

}
