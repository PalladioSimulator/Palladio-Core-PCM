package de.uka.ipd.sdq.simucomframework.variables.functions;

import java.util.List;

import umontreal.iro.lecuyer.randvar.UniformGen;
import umontreal.iro.lecuyer.rng.GenF2w32;
import umontreal.iro.lecuyer.rng.RandomStream;
import de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter;

public class UniDoubleDistFunction implements IFunction {

	private RandomStream stream = new GenF2w32();

	public boolean checkParameters(List<Object> parameters) {
		if (parameters.size() != 2)
			return false;
		if (NumberConverter.toDouble(parameters.get(0)) > 
				NumberConverter.toDouble(parameters.get(1)))
			return false;
		return true;
	}

	public Object evaluate(List<Object> parameters) {
		double a = NumberConverter.toDouble(parameters.get(0));
		double b = NumberConverter.toDouble(parameters.get(1));
		return UniformGen.nextDouble(stream, a, b);
	}

}
