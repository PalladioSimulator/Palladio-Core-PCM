package de.uka.ipd.sdq.simucomframework.variables.functions;

import java.util.ArrayList;
import java.util.HashMap;

import de.uka.ipd.sdq.simucomframework.variables.exceptions.FunctionParametersNotAcceptedException;
import de.uka.ipd.sdq.simucomframework.variables.exceptions.FunctionUnknownException;

/**
 * Function library of functions available in stoex in simucom
 * @author Steffen Becker
 *
 */
public class FunctionLib {

	private HashMap<String, IFunction> myFunctions = new HashMap<String, IFunction>();
	
	/**
	 * Initialise the function library 
	 */
	public FunctionLib() {
		addStdFunctionsToLib();
	}

	/**
	 * Add the functions available in simucoms standard library
	 */
	private void addStdFunctionsToLib() {
		myFunctions.put("Norm",new NormDistFunction());
		myFunctions.put("Exp",new ExpDistFunction());
		myFunctions.put("Pois",new PoissonDistFunction());
		myFunctions.put("UniDouble",new UniDoubleDistFunction());
		myFunctions.put("UniInt",new UniIntDistFunction());
		myFunctions.put("Trunc",new TruncFunction());
		myFunctions.put("Round",new RoundFunction());
	}

	/**
	 * Add a function to this function library
	 * @param id Name of the function to add. It is the ID in the stoex
	 * @param f The function object used during evaluation
	 */
	public void addFunction(String id, IFunction f) {
		myFunctions.put(id, f);
	}
	
	/**
	 * Evaluate the function with the given ID using the given parameters,
	 * e.g. f(10,29)
	 * @param functionID ID of the function to evaluate
	 * @param parameterValues Parameter set to use in evaluation
	 * @return Value of the function evaluated using the given parameters
	 */
	public Object evaluate(String functionID, ArrayList<Object> parameterValues) {
		if (!myFunctions.containsKey(functionID))
			throw new FunctionUnknownException("Function "+functionID+" is unknown! Evaluation aborted");
		IFunction f = myFunctions.get(functionID);
		if (!f.checkParameters(parameterValues))
			throw new FunctionParametersNotAcceptedException("Parameters passed to function "+functionID+" do not match function definition!");
		return f.evaluate(parameterValues);
	}
}
