package de.uka.ipd.sdq.simucomframework.variables.functions;

import java.util.ArrayList;

public interface IFunctionLib {

	/**
	 * Add a function to this function library.
	 * The passed function should use the instance of
	 * SimuComDefaultRandomNumberGenerator returned by
	 * {@link #getRandomStream()}.
	 *
	 * @param id Name of the function to add. It is the ID in the stoex
	 * @param f The function object used during evaluation
	 */
	public abstract void addFunction(String id, IFunction f);

	/**
	 * Evaluate the function with the given ID using the given parameters,
	 * e.g. f(10,29)
	 * @param functionID ID of the function to evaluate
	 * @param parameterValues Parameter set to use in evaluation
	 * @return Value of the function evaluated using the given parameters
	 */
	public abstract Object evaluate(String functionID,
			ArrayList<Object> parameterValues);

}