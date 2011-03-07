package de.uka.ipd.sdq.simucomframework.variables.functions;

import java.util.List;

import umontreal.iro.lecuyer.randvar.NormalGen;
import umontreal.iro.lecuyer.rng.RandomStream;
import de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter;

public class NormDistFunction implements IFunction {

	private RandomStream stream;
	
	public NormDistFunction(RandomStream stream2) {
		this.stream = stream2;
	}

	public boolean checkParameters(List<Object> parameters) {
		if (parameters.size() != 2)
			return false;
		return true;
	}

	public Object evaluate(List<Object> parameters) {
		double mean = NumberConverter.toDouble(parameters.get(0));
		double deviation = NumberConverter.toDouble(parameters.get(1));
		return NormalGen.nextDouble(stream, mean, deviation);
	}

}
