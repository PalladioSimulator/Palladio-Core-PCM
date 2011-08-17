package de.uka.ipd.sdq.simucomframework.variables.functions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import umontreal.iro.lecuyer.rng.MRG32k3a;
import umontreal.iro.lecuyer.rng.RandomStream;
import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;
import de.uka.ipd.sdq.simucomframework.variables.exceptions.FunctionParametersNotAcceptedException;
import de.uka.ipd.sdq.simucomframework.variables.exceptions.FunctionUnknownException;
import de.uka.ipd.sdq.stoex.analyser.probfunction.ProbfunctionHelper;

/**
 * Function library of functions available in stoex in simucom
 * @author Steffen Becker
 *
 */
public class FunctionLib {

	private HashMap<String, IFunction> myFunctions = new HashMap<String, IFunction>();
	private RandomStream randomStream;

	/**
	 * Initialise the function library.
	 * If the passed {@link IRandomGenerator} is an instance
	 * of {@link RandomStream} and thus can be used for the
	 * function initialisations, it is casted and used.
	 * Otherwise, a new {@link MRG32k3a} stream is generated.
	 *
	 * It would be nicer to use just one interface for random numbers, and
	 * not both {@link IRandomGenerator} and {@link RandomStream}.
	 * However, I did not want to replace the Probfunction interface IRandomGenerator
     * completely by RandomStream because if we want to get rid of SSJ at some point,
     * it should not be referenced in the whole code.
	 */
	public FunctionLib(IRandomGenerator iRandomGenerator) {
		RandomStream myStream = null;
		if (iRandomGenerator instanceof RandomStream){
			myStream = (RandomStream)iRandomGenerator;
		} else {
			// same initialisation as in
			// de.uka.ipd.sdq.simucomframework.SimuComDefaultRandomNumberGenerator
			MRG32k3a myMRG32k3aStream = new MRG32k3a();
			long[] myRandomSeed = new long[6];
			Random r = new Random();
			for (int i = 0; i < myRandomSeed.length; i++) {
				myRandomSeed[i] = r.nextInt();
			}
			myMRG32k3aStream.setSeed(myRandomSeed);
			myStream = myMRG32k3aStream;
			// end random stream initialisation
		}
		addStdFunctionsToLib(myStream);
		this.randomStream = myStream;
	}

	/**
	 * Add the functions available in simucoms standard library
	 */
	private void addStdFunctionsToLib(RandomStream stream) {
		myFunctions.put("Norm",new NormDistFunction(stream));
		myFunctions.put("Exp",new ExpDistFunction(stream));
		myFunctions.put("Pois",new PoissonDistFunction(stream));
		myFunctions.put("UniDouble",new UniDoubleDistFunction(stream));
		myFunctions.put("UniInt",new UniIntDistFunction(stream));
		myFunctions.put("Trunc",new TruncFunction());
		myFunctions.put(RoundFunction.ROUND_FUNCTION_NAME,new RoundFunction());
		myFunctions.put(ProbfunctionHelper.LOGNORM,new LogNormDistFunction(stream));
		myFunctions.put(ProbfunctionHelper.LOGNORM2,new LogNormDistFunctionFromMoments(stream));
		myFunctions.put(ProbfunctionHelper.GAMMA,new GammaDistFunction(stream));
		myFunctions.put(ProbfunctionHelper.GAMMA2,new GammaDistFunctionFromMoments(stream));
		myFunctions.put(MinFunction.MIN_FUNCTION_NAME, new MinFunction());
		myFunctions.put(MaxFunction.MAX_FUNCTION_NAME, new MaxFunction());
		myFunctions.put(MinDeviationFunction.MIN_DEVIATION_FUNCTION_NAME, new MinDeviationFunction());
		myFunctions.put(MaxDeviationFunction.MAX_DEVIATION_FUNCTION_NAME, new MaxDeviationFunction());
	}

	/**
	 * Add a function to this function library.
	 * The passed function should use the instance of
	 * SimuComDefaultRandomNumberGenerator returned by
	 * {@link #getRandomStream()}.
	 *
	 * @param id Name of the function to add. It is the ID in the stoex
	 * @param f The function object used during evaluation
	 */
	public void addFunction(String id, IFunction f) {
		myFunctions.put(id, f);
	}

	public RandomStream getRandomStream(){
		return randomStream;
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
