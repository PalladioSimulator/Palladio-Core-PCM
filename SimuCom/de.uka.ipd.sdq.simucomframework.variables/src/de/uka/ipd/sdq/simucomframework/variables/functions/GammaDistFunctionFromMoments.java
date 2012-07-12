package de.uka.ipd.sdq.simucomframework.variables.functions;

import java.util.List;

import de.uka.ipd.sdq.probfunction.math.IGammaDistribution;
import de.uka.ipd.sdq.probfunction.math.IPDFFactory;
import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;

import de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter;

/**
 * Gamma distribution with shape alpha > 0 and inverse scale parameter beta > 0
 * There is another way to write the gamma function with k = alpha and theta = 1/beta, 
 * @author Anne
 *
 */
public class GammaDistFunctionFromMoments extends AbstractProbDistFunction {
	
	
	public GammaDistFunctionFromMoments(IRandomGenerator randomGen, IPDFFactory factory) {
		super(randomGen, factory);
	}

	/**
	 * Checks the validity of the parameter. 
	 * GammaDistFunctionFromMoments takes 
	 * two parameters mean and c coefficient of variance 
	 * mean needs to be larger than 0. 
	 * c needs to be larger than 0. 
	 */
	public boolean checkParameters(List<Object> parameters) {
		//two parameters mean and c
		if (parameters.size() != 2)
			return false;
		//mean needs to be larger than 0. 
		if (NumberConverter.toDouble(parameters.get(0)) < 0)
			return false;
		//c needs to be larger than 0. 
		if (NumberConverter.toDouble(parameters.get(1)) < 0)
			return false;		
		return true;
	}

	public Object evaluate(List<Object> parameters) {
		double mean = NumberConverter.toDouble(parameters.get(0));
		double coeffVar = NumberConverter.toDouble(parameters.get(1));
		
		IGammaDistribution distribution = factory.createGammaDistributionFromMoments(mean, coeffVar);
		return distribution.inverseF(randomGen.random());
	}

}
