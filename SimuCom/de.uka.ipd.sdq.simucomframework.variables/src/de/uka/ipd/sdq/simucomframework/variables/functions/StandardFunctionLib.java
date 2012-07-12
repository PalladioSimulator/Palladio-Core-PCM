package de.uka.ipd.sdq.simucomframework.variables.functions;

import java.util.HashMap;

import de.uka.ipd.sdq.probfunction.math.IPDFFactory;
import de.uka.ipd.sdq.stoex.analyser.probfunction.ProbfunctionHelper;

/**
 * Function library of functions available in stoex in simucom.
 * The standard functions are seen as extrinsic state of a complete 
 * FunctionLibFlyweight and are therefore only instantiated for one time.
 * 
 * @author Steffen Becker
 * @author Daniel.Schmidt
 */
public class StandardFunctionLib {

	private HashMap<String, IFunction> standardFunctions = new HashMap<String, IFunction>();

	/**
	 * Initialise the function library.
	 * 
	 */
	public StandardFunctionLib(IPDFFactory factory) {
		addStdFunctionsToLib(factory);
	}

	/**
	 * Add the functions available in simucoms standard library
	 */
	private void addStdFunctionsToLib(IPDFFactory factory) {
		standardFunctions.put("Norm",new NormDistFunction(factory.getRandomGenerator(), factory));
		standardFunctions.put("Exp",new ExpDistFunction(factory.getRandomGenerator(), factory));
		standardFunctions.put("Pois",new PoissonDistFunction(factory.getRandomGenerator(), factory));
		standardFunctions.put("UniDouble",new UniDoubleDistFunction(factory.getRandomGenerator(), factory));
		standardFunctions.put("UniInt",new UniIntDistFunction(factory.getRandomGenerator(), factory));
		standardFunctions.put("Trunc",new TruncFunction());
		standardFunctions.put(RoundFunction.ROUND_FUNCTION_NAME,new RoundFunction());
		standardFunctions.put(ProbfunctionHelper.LOGNORM,new LogNormDistFunction(factory.getRandomGenerator(), factory));
		standardFunctions.put(ProbfunctionHelper.LOGNORM2,new LogNormDistFunctionFromMoments(factory.getRandomGenerator(), factory));
		standardFunctions.put(ProbfunctionHelper.GAMMA,new GammaDistFunction(factory.getRandomGenerator(), factory));
		standardFunctions.put(ProbfunctionHelper.GAMMA2,new GammaDistFunctionFromMoments(factory.getRandomGenerator(), factory));
		standardFunctions.put(MinFunction.MIN_FUNCTION_NAME, new MinFunction());
		standardFunctions.put(MaxFunction.MAX_FUNCTION_NAME, new MaxFunction());
		standardFunctions.put(MinDeviationFunction.MIN_DEVIATION_FUNCTION_NAME, new MinDeviationFunction());
		standardFunctions.put(MaxDeviationFunction.MAX_DEVIATION_FUNCTION_NAME, new MaxDeviationFunction());
	}

	/**
	 * Returns the standard function available in stoex in simucom.
	 * @return
	 */
	public HashMap<String, IFunction> getStandardFunctions() {
		return standardFunctions;
	}
}
