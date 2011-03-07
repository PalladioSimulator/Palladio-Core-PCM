package de.uka.ipd.sdq.simucomframework.variables.functions;

import java.util.List;

import umontreal.iro.lecuyer.probdist.GammaDistFromMoments;
import umontreal.iro.lecuyer.randvar.GammaGen;
import umontreal.iro.lecuyer.rng.RandomStream;
import de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter;

/**
 * Gamma distribution with shape alpha > 0 and inverse scale parameter beta > 0
 * There is another way to write the gamma function with k = alpha and theta = 1/beta, 
 * @author Anne
 *
 */
public class GammaDistFunctionFromMoments implements IFunction {
	
	private RandomStream stream;

	public GammaDistFunctionFromMoments(RandomStream stream2) {
		this.stream = stream2;
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
		double c = NumberConverter.toDouble(parameters.get(1));
		double variance = c*mean*c*mean;
		GammaGen generator = new GammaGen(stream, new GammaDistFromMoments(mean,variance));
		return generator.nextDouble();
	}

}
