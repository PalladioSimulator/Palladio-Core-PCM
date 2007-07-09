package de.uka.ipd.sdq.simucomframework.variables.functions;

import java.util.ArrayList;
import java.util.HashMap;

public class FunctionLib {

	private HashMap<String, IFunction> myFunctions = new HashMap<String, IFunction>();
	
	public FunctionLib() {
		addStdFunctionsToLib();
	}

	private void addStdFunctionsToLib() {
		myFunctions.put("Norm",new NormDistFunction());
		myFunctions.put("Exp",new ExpDistFunction());
		myFunctions.put("Pois",new PoissonDistFunction());
		myFunctions.put("UniDouble",new UniDoubleDistFunction());
		myFunctions.put("UniInt",new UniIntDistFunction());
		myFunctions.put("Trunc",new TruncFunction());
		myFunctions.put("Round",new RoundFunction());
	}

	public void addFunction(String id, IFunction f) {
		myFunctions.put(id, f);
	}
	
	public Object evaluate(String functionID, ArrayList<Object> parameterValues) {
		if (!myFunctions.containsKey(functionID))
			throw new FunctionUnknownException("Function "+functionID+" is unknown! Evaluation aborted");
		IFunction f = myFunctions.get(functionID);
		if (!f.checkParameters(parameterValues))
			throw new FunctionParametersNotAcceptedException("Parameters passed to function "+functionID+" do not match function definition!");
		return f.evaluate(parameterValues);
	}
}
