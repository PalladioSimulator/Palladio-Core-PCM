package de.uka.ipd.sdq.simucomframework.variables.functions;

import java.util.List;

public class RoundFunction implements IFunction {

	public boolean checkParameters(List<Object> parameters) {
		if (parameters.size() != 1)
			return false;
		if (!(parameters.get(0) instanceof Double))
			return false;
		return true;
	}

	public Object evaluate(List<Object> parameters) {
		return (int)Math.round((Double)parameters.get(0));
	}

}
