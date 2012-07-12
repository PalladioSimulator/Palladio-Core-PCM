package de.uka.ipd.sdq.simucomframework.variables.functions;

import java.util.ArrayList;
import java.util.HashMap;

import de.uka.ipd.sdq.simucomframework.variables.exceptions.FunctionParametersNotAcceptedException;
import de.uka.ipd.sdq.simucomframework.variables.exceptions.FunctionUnknownException;

/**
 * {@link FunctionLibFlyweight} acts like a complete FunctionLib by implementing the {@link IFunctionLib}
 * interface. Each {@link FunctionLibFlyweight} consists of an extrinsic state containg the standard function
 * libs, and an intrinsic state containing the individual functions that may be added.
 * 
 * @author Daniel.Schmidt
 *
 */
public class FunctionLibFlyweight implements IFunctionLib {

	private HashMap<String, IFunction> myFunctions;
	private StandardFunctionLib standardFunctionLib;
	/**
	 * C'tor
	 * 
	 * @param standardFunctionLib the extrinsic state of this flyweight containing all standard
	 * function libs.
	 * 
	 */
	protected FunctionLibFlyweight(StandardFunctionLib standardFunctionLib) {
		this.standardFunctionLib = standardFunctionLib;
	}
	

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.simucomframework.variables.functions.IFunctionLib#addFunction(java.lang.String, de.uka.ipd.sdq.simucomframework.variables.functions.IFunction)
	 */
	@Override
	public void addFunction(String id, IFunction f) {
		if(myFunctions == null) {
			myFunctions = new HashMap<String, IFunction>();
		}
		myFunctions.put(id, f);
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.simucomframework.variables.functions.IFunctionLib#evaluate(java.lang.String, java.util.ArrayList)
	 */
	@Override
	public Object evaluate(String functionID, ArrayList<Object> parameterValues) {

		if ((myFunctions == null || !standardFunctionLib.getStandardFunctions().containsKey(functionID) && !myFunctions.containsKey(functionID)))
			throw new FunctionUnknownException("Function "+functionID+" is unknown! Evaluation aborted");
		IFunction f = standardFunctionLib.getStandardFunctions().get(functionID);
		if(f == null)
			f = myFunctions.get(functionID);
		if (!f.checkParameters(parameterValues))
			throw new FunctionParametersNotAcceptedException("Parameters passed to function "+functionID+" do not match function definition!");

		return f.evaluate(parameterValues);
	}
}
