package de.uka.ipd.sdq.simucomframework.variables.functions;

import java.util.Collection;
import java.util.List;

public interface IFunction {
	Object evaluate(List<Object> parameters);
	boolean checkParameters(List<Object> parameters);
}
