package de.uka.ipd.sdq.simucomframework.variables.functions;

import java.util.List;

import umontreal.iro.lecuyer.randvar.LognormalGen;
import umontreal.iro.lecuyer.rng.GenF2w32;
import umontreal.iro.lecuyer.rng.RandomStream;
import de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter;

/**
 * Lognormal distribution with parameters mu (mean) and sigma (standard deviation).
 * @author Anne
 *
 */
public class LogNormDistFunction implements IFunction {
	
	private RandomStream stream = new GenF2w32();

	/**
	 * Checks the validity of the parameter. 
	 * Lognorm takes two parameters mu (mean) and sigma (standard deviation) 
	 * sigma needs to be larger than 0. 
	 * mu parameter can be any double
	 */
	public boolean checkParameters(List<Object> parameters) {
		//two parameters mu and sigma
		if (parameters.size() != 2)
			return false;
		//sigma needs to be larger than 0. 
		if (NumberConverter.toDouble(parameters.get(1)) < 0)
			return false;
		//mu parameter can be any double
		NumberConverter.toDouble(parameters.get(0));		
		return true;
	}

	public Object evaluate(List<Object> parameters) {
		double mu = NumberConverter.toDouble(parameters.get(0));
		double sigma= NumberConverter.toDouble(parameters.get(1));
		return LognormalGen.nextDouble(stream, mu, sigma);
	}

}
