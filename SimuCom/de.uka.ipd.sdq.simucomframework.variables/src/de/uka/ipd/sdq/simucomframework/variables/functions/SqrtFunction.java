package de.uka.ipd.sdq.simucomframework.variables.functions;

import java.util.List;

public class SqrtFunction implements IFunction {
    /** Name used in the stochastic expression for this function. */
    public static final String SQRT_FUNCTION_NAME = "Sqrt";

    public boolean checkParameters(List<Object> parameters) {
        if (parameters.size() != 1)
            return false;
        if (!(parameters.get(0) instanceof Double) && !(parameters.get(0) instanceof Integer))
            return false;
        return true;
    }

    public Object evaluate(List<Object> parameters) {
    	double value;
        if (parameters.get(0) instanceof Integer)
            value = (int)parameters.get(0);
        else
        	value = (double)parameters.get(0);
        
        return Math.sqrt(value);
    }

}
