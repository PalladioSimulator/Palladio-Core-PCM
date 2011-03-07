package de.uka.ipd.sdq.simucomframework.variables.functions;

import java.util.List;

import umontreal.iro.lecuyer.probdist.LognormalDistFromMoments;
import umontreal.iro.lecuyer.randvar.LognormalGen;
import umontreal.iro.lecuyer.rng.RandomStream;
import de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter;

/**
 * Lognormal distribution from the distributions moments: Parameters mean and standard deviation.
 * @author Anne
 *
 */
public class LogNormDistFunctionFromMoments implements IFunction {
	
	private RandomStream stream;

	public LogNormDistFunctionFromMoments(RandomStream stream2) {
		this.stream = stream2;
	}

	/**
	 * Checks the validity of the parameter. 
	 * LognormFromMoments takes two parameters mean and standard deviation
	 * mean needs to be larger than 0. 
	 * stdev needs to be larger than 0. 
	 */
	public boolean checkParameters(List<Object> parameters) {
		//two parameters mean and c
		if (parameters.size() != 2)
			return false;
		//mean needs to be larger than 0. 
		if (NumberConverter.toDouble(parameters.get(0)) < 0)
			return false;
		//stdev needs to be larger than 0. 
		if (NumberConverter.toDouble(parameters.get(1)) < 0)
			return false;		
		return true;
	}

	public Object evaluate(List<Object> parameters) {
		double mean = NumberConverter.toDouble(parameters.get(0));
		double stdev = NumberConverter.toDouble(parameters.get(1));
		double variance = stdev*stdev;
		LognormalGen generator = new LognormalGen(stream, new LognormalDistFromMoments(mean,variance));
		return generator.nextDouble();
	}

}
