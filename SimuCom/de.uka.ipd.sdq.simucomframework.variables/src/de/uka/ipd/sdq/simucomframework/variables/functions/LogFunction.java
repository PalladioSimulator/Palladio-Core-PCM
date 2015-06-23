package de.uka.ipd.sdq.simucomframework.variables.functions;

import java.util.List;

public class LogFunction implements IFunction {
    /** Name used in the stochastic expression for this function. */
    public static final String LOG_FUNCTION_NAME = "Log";

    public boolean checkParameters(List<Object> parameters) {
        if (parameters.size() != 2)
            return false;
        
        // base
        if (parameters.get(0) instanceof Double) {
        	Double base = (Double) parameters.get(0);
        	if(base<=0 || base==1)
        		return false;
        }
        else if (parameters.get(0) instanceof Integer) {
        	Integer base = (Integer) parameters.get(0);
        	if(base<=0 || base==1)
        		return false;
        }
        else {
            return false;
        }
        
        // value
        if (parameters.get(1) instanceof Double) {
        	Double value = (Double) parameters.get(1);
        	if(value <= 0)
        		return false;
        }
        else if (parameters.get(1) instanceof Integer) {
        	Integer value = (Integer) parameters.get(1);
        	if(value <= 0)
        		return false;
        }
        else {
            return false;
        }
        
        return true;
    }

    public Object evaluate(List<Object> parameters) {
    	Double base;
        if (parameters.get(0) instanceof Integer)
    		base = (double)(int)parameters.get(0);
        else
        	base = (Double) parameters.get(0);
        
    	Double value;
        if (parameters.get(1) instanceof Integer)
        	value = (double)(int)parameters.get(1);
        else
        	value = (Double) parameters.get(1);
    	
        return Math.log(value)/Math.log(base);
    }

}
