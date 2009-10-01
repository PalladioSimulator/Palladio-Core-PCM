package de.uka.ipd.sdq.simucomframework.variables.functions;

import java.util.List;

import de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter;

import umontreal.iro.lecuyer.randvar.GammaGen;
import umontreal.iro.lecuyer.rng.GenF2w32;
import umontreal.iro.lecuyer.rng.RandomStream;

/**
 * Gamma distribution with shape alpha > 0 and inverse scale parameter beta > 0
 * There is another way to write the gamma function with k = alpha and theta = 1/beta, 
 * @author Anne
 *
 */
public class GammaDistFunction implements IFunction {
	
	private RandomStream stream = new GenF2w32();

	public boolean checkParameters(List<Object> parameters) {
		//two parameters alpha and beta
		if (parameters.size() != 2)
			return false;
		//alpha needs to be larger than 0. 
		if (NumberConverter.toDouble(parameters.get(1)) < 0)
			return false;
		//beta needs to be larger than 0. 
		if (NumberConverter.toDouble(parameters.get(0)) < 0)
			return false;		
		return true;
	}

	public Object evaluate(List<Object> parameters) {
		double alpha = NumberConverter.toDouble(parameters.get(0));
		double beta= NumberConverter.toDouble(parameters.get(1));
		//k is alpha,  
		return GammaGen.nextDouble(stream, alpha, beta);
	}

}
