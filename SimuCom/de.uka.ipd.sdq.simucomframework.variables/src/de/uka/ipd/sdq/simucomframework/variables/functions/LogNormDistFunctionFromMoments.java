package de.uka.ipd.sdq.simucomframework.variables.functions;

import java.util.List;

import umontreal.iro.lecuyer.probdist.LognormalDistFromMoments;
import umontreal.iro.lecuyer.randvar.LognormalGen;
import umontreal.iro.lecuyer.rng.GenF2w32;
import umontreal.iro.lecuyer.rng.RandomStream;
import de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter;

/**
 * Lognormal distribution with parameters mu (mean) and sigma (standard deviation).
 * @author Anne
 *
 */
public class LogNormDistFunctionFromMoments implements IFunction {
	
	private RandomStream stream = new GenF2w32();

	/**
	 * Checks the validity of the parameter. 
	 * LognormFromMoments takes two parameters mean and c coefficient of variance 
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
		LognormalGen generator = new LognormalGen(stream, new LognormalDistFromMoments(mean,variance));
		return generator.nextDouble();
	}

}
