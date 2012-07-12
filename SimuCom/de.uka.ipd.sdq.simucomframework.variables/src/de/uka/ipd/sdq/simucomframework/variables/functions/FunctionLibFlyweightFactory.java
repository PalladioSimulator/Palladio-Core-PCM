package de.uka.ipd.sdq.simucomframework.variables.functions;

import java.util.HashMap;
import java.util.Map;

import de.uka.ipd.sdq.probfunction.math.IPDFFactory;

/**
 * The {@link FunctionLibFlyweightFactory} is used to create {@link FunctionLibFlyweight}s
 * in an appropriate way.
 * 
 * @author Daniel.Schmidt
 *
 */
public class FunctionLibFlyweightFactory {

	private static Map<IPDFFactory, FunctionLibFlyweightFactory> functionLibFlyweightFactories = new HashMap<IPDFFactory, FunctionLibFlyweightFactory>();
	private static FunctionLibFlyweightFactory factory = null;
	private StandardFunctionLib standardFunctionLib;
	
	/**
	 * C'tor
	 * 
	 * @param factory the {@link IPDFFactory} that is needed to create the {@link IFunctionLib}s.
	 */
	private FunctionLibFlyweightFactory(IPDFFactory factory) {
		standardFunctionLib = new StandardFunctionLib(factory);
	}
	
	/**
	 * Returns a {@link FunctionLibFlyweightFactory} specified by the given {@link IPDFFactory}.
	 * 
	 * @param factory
	 * @return
	 */
	public static synchronized FunctionLibFlyweightFactory getFactory(IPDFFactory pdfFactory) {
//		FunctionLibFlyweightFactory functionLibFlyweightFactory = functionLibFlyweightFactories.get(factory);
//		if(functionLibFlyweightFactory == null) {
//			functionLibFlyweightFactory = new FunctionLibFlyweightFactory(factory);
//			functionLibFlyweightFactories.put(factory, functionLibFlyweightFactory);
//		}
		if(factory == null) {
			factory = new FunctionLibFlyweightFactory(pdfFactory);
		}
		return factory;
	}
	
	/**
	 * Creates an {@link IFunctionLib} containing the extrinsic state (standard libs).
	 * 
	 * @return an {@link IFunctionLib} containing the extrinsic state (standard libs).
	 */
	public IFunctionLib createFunctionLibFlyweight() {
		
		return new FunctionLibFlyweight(standardFunctionLib);
	}
}
