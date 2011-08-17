package de.uka.ipd.sdq.simucomframework.variables.functions;

import java.util.List;

import umontreal.iro.lecuyer.randvar.BinomialGen;
import umontreal.iro.lecuyer.rng.RandomStream;
import de.uka.ipd.sdq.simucomframework.variables.converter.NumberConverter;

public class BinomFunction implements IFunction {

	private RandomStream stream;

	public BinomFunction(RandomStream stream) {
		this.stream = stream;
	}

	public boolean checkParameters(List<Object> parameters) {
		if (parameters.size() == 2 &&
				(parameters.get(0) instanceof Integer) &&
				(parameters.get(1) instanceof Double))
		{
			return true;}
		else
		{
			return false;
		}

	}

	public Object evaluate(List<Object> parameters) {
		int n = (Integer) parameters.get(0);
		double p = NumberConverter.toDouble(parameters.get(1));
		return BinomialGen.nextInt(stream, n, p);
	}

}
