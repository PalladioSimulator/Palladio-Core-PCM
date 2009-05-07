package de.uka.ipd.sdq.simucomframework.variables.functions;

import java.util.List;

import umontreal.iro.lecuyer.randvar.ExponentialGen;
import umontreal.iro.lecuyer.randvar.UniformGen;
import umontreal.iro.lecuyer.randvar.UniformIntGen;
import umontreal.iro.lecuyer.rng.GenF2w32;
import umontreal.iro.lecuyer.rng.RandomStream;

public class UniIntDistFunction implements IFunction {

	private RandomStream stream = new GenF2w32();

	public boolean checkParameters(List<Object> parameters) {
		if (parameters.size() != 2)
			return false;
		if (!(parameters.get(0) instanceof Integer && 
				parameters.get(1) instanceof Integer))
			return false;
		return true;
	}

	public Object evaluate(List<Object> parameters) {
		int a = (Integer)parameters.get(0);
		int b = (Integer)parameters.get(1);
		return UniformIntGen.nextInt(stream, a, b);
	}

}
