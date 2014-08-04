package de.uka.ipd.sdq.simucomframework.variables.functions;

import java.util.ArrayList;
import java.util.HashMap;

import de.uka.ipd.sdq.probfunction.math.IPDFFactory;
import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;
import de.uka.ipd.sdq.simucomframework.variables.exceptions.FunctionParametersNotAcceptedException;
import de.uka.ipd.sdq.simucomframework.variables.exceptions.FunctionUnknownException;
import de.uka.ipd.sdq.stoex.analyser.probfunction.ProbfunctionHelper;

/**
 * Function library of functions available in stoex in simucom
 * 
 * @author Steffen Becker
 *
 */
public class FunctionLib {

    private HashMap<String, IFunction> myFunctions = new HashMap<String, IFunction>();
    private IRandomGenerator randomStream;

    /**
     * Initialise the function library.
     * 
     */
    public FunctionLib(IRandomGenerator randomStream, IPDFFactory factory) {
        this.randomStream = randomStream;
        addStdFunctionsToLib(randomStream, factory);
    }

    /**
     * Add the functions available in simucoms standard library
     */
    private void addStdFunctionsToLib(IRandomGenerator randomGen, IPDFFactory factory) {
        myFunctions.put("Norm", new NormDistFunction(randomGen, factory));
        myFunctions.put("Exp", new ExpDistFunction(randomGen, factory));
        myFunctions.put("Pois", new PoissonDistFunction(randomGen, factory));
        myFunctions.put("UniDouble", new UniDoubleDistFunction(randomGen, factory));
        myFunctions.put("UniInt", new UniIntDistFunction(randomGen, factory));
        myFunctions.put("Trunc", new TruncFunction());
        myFunctions.put(RoundFunction.ROUND_FUNCTION_NAME, new RoundFunction());
        myFunctions.put(ProbfunctionHelper.LOGNORM, new LogNormDistFunction(randomGen, factory));
        myFunctions.put(ProbfunctionHelper.LOGNORM2, new LogNormDistFunctionFromMoments(randomGen, factory));
        myFunctions.put(ProbfunctionHelper.GAMMA, new GammaDistFunction(randomGen, factory));
        myFunctions.put(ProbfunctionHelper.GAMMA2, new GammaDistFunctionFromMoments(randomGen, factory));
        myFunctions.put(MinFunction.MIN_FUNCTION_NAME, new MinFunction());
        myFunctions.put(MaxFunction.MAX_FUNCTION_NAME, new MaxFunction());
        myFunctions.put(MinDeviationFunction.MIN_DEVIATION_FUNCTION_NAME, new MinDeviationFunction());
        myFunctions.put(MaxDeviationFunction.MAX_DEVIATION_FUNCTION_NAME, new MaxDeviationFunction());
    }

    /**
     * Add a function to this function library. The passed function should use the instance of
     * SimuComDefaultRandomNumberGenerator returned by {@link #getRandomStream()}.
     *
     * @param id
     *            Name of the function to add. It is the ID in the stoex
     * @param f
     *            The function object used during evaluation
     */
    public void addFunction(String id, IFunction f) {
        myFunctions.put(id, f);
    }

    public IRandomGenerator getRandomStream() {
        return randomStream;
    }

    /**
     * Evaluate the function with the given ID using the given parameters, e.g. f(10,29)
     * 
     * @param functionID
     *            ID of the function to evaluate
     * @param parameterValues
     *            Parameter set to use in evaluation
     * @return Value of the function evaluated using the given parameters
     */
    public Object evaluate(String functionID, ArrayList<Object> parameterValues) {
        if (!myFunctions.containsKey(functionID))
            throw new FunctionUnknownException("Function " + functionID + " is unknown! Evaluation aborted");
        IFunction f = myFunctions.get(functionID);
        if (!f.checkParameters(parameterValues))
            throw new FunctionParametersNotAcceptedException("Parameters passed to function " + functionID
                    + " do not match function definition!");
        return f.evaluate(parameterValues);
    }
}
