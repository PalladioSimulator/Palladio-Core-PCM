package de.uka.ipd.sdq.simucomframework.variables.functions;

import java.util.List;

import de.uka.ipd.sdq.probfunction.math.ILognormalDistribution;
import de.uka.ipd.sdq.probfunction.math.IPDFFactory;
import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;
import de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter;

/**
 * Lognormal distribution with parameters scale parameter mu and shape parameter sigma > 0.
 * @author Anne
 *
 */
public class LogNormDistFunction extends AbstractProbDistFunction {
	


	public LogNormDistFunction(IRandomGenerator randomGen, IPDFFactory factory) {
		super(randomGen, factory);
	}

	/**
	 * Checks the validity of the parameter. 
	 * Lognorm takes two parameters mu (scale parameter) and sigma (shape parameter) 
	 * sigma needs to be larger than 0. 
	 * mu parameter can be any double
	 */
	public boolean checkParameters(List<Object> parameters) {
		//two parameters mu and sigma
		if (parameters.size() != 2)
			return false;
		//sigma needs to be larger than 0. 
		if (NumberConverter.toDouble(parameters.get(1)) <= 0)
			return false;
		//mu parameter can be any double
		NumberConverter.toDouble(parameters.get(0));		
		return true;
	}

	public Object evaluate(List<Object> parameters) {
		double mu = NumberConverter.toDouble(parameters.get(0));
		double sigma= NumberConverter.toDouble(parameters.get(1));
		ILognormalDistribution distribution = factory.createLognormalDistribution(mu, sigma);
		return distribution.inverseF(randomGen.random());
	}

}
