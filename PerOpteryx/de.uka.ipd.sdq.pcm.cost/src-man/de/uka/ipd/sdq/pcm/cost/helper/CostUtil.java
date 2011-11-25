package de.uka.ipd.sdq.pcm.cost.helper;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.cost.ScalarFunction;
import de.uka.ipd.sdq.pcm.cost.VariableProcessingResourceCost;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;
import de.uka.ipd.sdq.probfunction.math.impl.ProbabilityFunctionFactoryImpl;
import de.uka.ipd.sdq.simucomframework.SimuComDefaultRandomNumberGenerator;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.cache.StoExCache;
import de.uka.ipd.sdq.simucomframework.variables.cache.StoExCacheEntry;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import de.uka.ipd.sdq.simucomframework.variables.stoexvisitor.PCMStoExEvaluationVisitor;
import de.uka.ipd.sdq.simucomframework.variables.stoexvisitor.VariableMode;
import de.uka.ipd.sdq.stoex.Expression;

public class CostUtil {
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.pcm.cost.helper.CostUtil");
	
	private static final String PROCESSING_RATE_VARIABLE = "procRate.VALUE";
	private static final String NUMBER_OF_CORES_VARIABLE = "numberOfReplicas.VALUE";

	private CostStoExCache stoExCache;

	private IRandomGenerator randomGenerator;
	private IProbabilityFunctionFactory probFunctionFactory;
	
	private static CostUtil singletonInstance = null;
	
	public static CostUtil getInstance(){
		if (singletonInstance == null){
			singletonInstance = new CostUtil();
		}
		return singletonInstance;
	}
	
	private CostUtil(){
		this.randomGenerator = new SimuComDefaultRandomNumberGenerator(null);
		probFunctionFactory = ProbabilityFunctionFactoryImpl.getInstance();
		probFunctionFactory.setRandomGenerator(this.randomGenerator);
		this.stoExCache = new CostStoExCache(probFunctionFactory);
	}

	public double getDoubleFromSpecification(String specification) {
		// TODO Auto-generated method stub
		if (StoExCache.singleton() == null)
		{
			StoExCache.initialiseStoExCache(probFunctionFactory);
		}
		Object rate = StackContext.evaluateStatic(specification);
		// cannot use the following direct access to the solving visitor, as it also requires an initialised StoExCache. 
		//StoExCacheEntry entry =  new StoExCacheEntry(specification,null);
		//Object rate = new PCMStoExEvaluationVisitor(specification,new SimulatedStackframe<Object>(),VariableMode.EXCEPTION_ON_NOT_FOUND)
		//	.doSwitch(entry.getParsedExpression());
		return toDoubleOrZero(rate);
	}

	private static double toDoubleOrZero(Object number) {
		if (Double.class.isInstance(number)){
			return (Double)number;
		} else if (Integer.class.isInstance(number)){
			return ((Integer)number).doubleValue();
		}
		return 0.0;
	}
	
	public double getOperatingCost(
			VariableProcessingResourceCost varCost) {
		double functionValue = solveFunctionExpression(
				varCost,
				varCost.getProcessingRateOperatingFunction());
		double cost = varCost.getFixedOperatingCost() +  functionValue ;
		return cost;
	}


	private double solveFunctionExpression(
			VariableProcessingResourceCost varCost,
			ScalarFunction scalarFunction) {
		if (scalarFunction == null || scalarFunction.getSpecification() == ""){
			return 0.0;
		}
		double processingRate = getProcessingRate(varCost);
		int numberOfCores = getNumberOfReplicas(varCost);
		String specification = scalarFunction.getSpecification();
		SimulatedStackframe<Object> stackframe = new SimulatedStackframe<Object>();
		stackframe.addValue(PROCESSING_RATE_VARIABLE, processingRate);
		stackframe.addValue(NUMBER_OF_CORES_VARIABLE, numberOfCores);
		
		try {
			//Term parsedExpression = scalarFunction.getTerm();
			//ExpressionInferTypeVisitor typeInferer = StoExCache.singleton().getEntry(specification).getTypeInferer();
			//typeInferer.getTypeAnnotation().put(arg0, arg1)

			StoExCacheEntry stoExEntry = this.stoExCache.getEntry(specification);
			Expression parsedExpression = stoExEntry.getParsedExpression();

			PCMStoExEvaluationVisitor visitor = new PCMStoExEvaluationVisitor(stoExEntry,stackframe,VariableMode.RETURN_DEFAULT_ON_NOT_FOUND,probFunctionFactory);
			Object number = visitor.doSwitch(parsedExpression);
			return toDoubleOrZero(number);
		} catch (RuntimeException e){
			logger.warn("Error when evaluating processing rate cost function: "+e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}


	public double getInitialCost(
			VariableProcessingResourceCost varCost) {
		double functionValue = solveFunctionExpression(
				varCost,
				varCost.getProcessingRateInitialFunction());
		double cost = varCost.getFixedInitialCost() +  functionValue ;
		return cost;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	private double getProcessingRate(VariableProcessingResourceCost varCost) {
		//TODO: what about longs and shorts and stuff here? 
		if ( varCost.getProcessingresourcespecification() != null 
				&& varCost.getProcessingresourcespecification().getProcessingRate_ProcessingResourceSpecification() != null 
				&& varCost.getProcessingresourcespecification().getProcessingRate_ProcessingResourceSpecification().getSpecification() != null) {
			return getDoubleFromSpecification(varCost.getProcessingresourcespecification().getProcessingRate_ProcessingResourceSpecification().getSpecification());
		} 
		return 0;
	}
	
	private int getNumberOfReplicas(VariableProcessingResourceCost varCost){
		if (varCost.getProcessingresourcespecification() != null){
			return varCost.getProcessingresourcespecification().getNumberOfReplicas();
		}
		return 0;
	}
	
	public void resetCache(){
		this.stoExCache = new CostStoExCache(probFunctionFactory);
	}
	
}

class CostStoExCache extends StoExCache {
	
	protected CostStoExCache(IProbabilityFunctionFactory factory){
		super(factory);
	}
	
}
