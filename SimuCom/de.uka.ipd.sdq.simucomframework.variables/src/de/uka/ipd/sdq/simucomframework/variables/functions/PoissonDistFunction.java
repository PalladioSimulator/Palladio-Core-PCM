package de.uka.ipd.sdq.simucomframework.variables.functions;

import java.util.List;

import umontreal.iro.lecuyer.randvar.PoissonGen;
import umontreal.iro.lecuyer.rng.RandomStream;
import de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter;

public class PoissonDistFunction implements IFunction {

	private RandomStream stream;

	public PoissonDistFunction(RandomStream stream2) {
		this.stream = stream2;
	}

	public boolean checkParameters(List<Object> parameters) {
		if (parameters.size() != 1)
			return false;
		if (NumberConverter.toDouble(parameters.get(0)) < 0)
			return false;
		return true;
	}

	public Object evaluate(List<Object> parameters) {
		double mean = NumberConverter.toDouble(parameters.get(0));
		return PoissonGen.nextInt(stream, mean);
	}

}
