package de.uka.ipd.sdq.simucomframework.variables.functions;

import java.util.List;

public class TruncFunction implements IFunction {

	public boolean checkParameters(List<Object> parameters) {
		if (parameters.size() != 1)
			return false;
		if (!(parameters.get(0) instanceof Double) && !(parameters.get(0) instanceof Integer))
			return false;
		return true;
	}

	public Object evaluate(List<Object> parameters) {
		if (parameters.get(0) instanceof Integer)
			return parameters.get(0);
		return (int)Math.round(Math.floor((Double)parameters.get(0)));
	}

}
