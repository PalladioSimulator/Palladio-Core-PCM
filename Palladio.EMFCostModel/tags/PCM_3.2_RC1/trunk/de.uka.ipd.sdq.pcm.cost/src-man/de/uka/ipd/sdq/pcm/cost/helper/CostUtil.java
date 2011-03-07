package de.uka.ipd.sdq.pcm.cost.helper;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.cost.ScalarFunction;
import de.uka.ipd.sdq.pcm.cost.VariableProcessingResourceCost;
import de.uka.ipd.sdq.simucomframework.SimuComDefaultRandomNumberGenerator;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.cache.StoExCache;
import de.uka.ipd.sdq.simucomframework.variables.cache.StoExCacheEntry;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import de.uka.ipd.sdq.simucomframework.variables.stoexvisitor.PCMStoExEvaluationVisitor;
import de.uka.ipd.sdq.simucomframework.variables.stoexvisitor.VariableMode;
import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.Term;
import de.uka.ipd.sdq.stoex.analyser.visitors.ExpressionInferTypeVisitor;

public class CostUtil {
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.pcm.cost.helper.CostUtil");
	
	private static final String PROCESSING_RATE_VARIABLE = "procRate.VALUE";

	public static double getDoubleFromSpecification(String specification) {
		// TODO Auto-generated method stub
		if (StoExCache.singleton() == null){
			StoExCache.initialiseStoExCache(new SimuComDefaultRandomNumberGenerator(null));
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
	
	public static double getOperatingCost(
			VariableProcessingResourceCost varCost) {
		double functionValue = solveFunctionExpression(
				varCost,
				varCost.getProcessingRateOperatingFunction());
		double cost = varCost.getFixedOperatingCost() +  functionValue ;
		return cost;
	}


	private static double solveFunctionExpression(
			VariableProcessingResourceCost varCost,
			ScalarFunction scalarFunction) {
		if (scalarFunction == null){
			return 0.0;
		}
		double processingRate = getProcessingRate(varCost);
		String specification = scalarFunction.getSpecification();
		SimulatedStackframe<Object> stackframe = new SimulatedStackframe<Object>();
		stackframe.addValue(PROCESSING_RATE_VARIABLE, processingRate);
		
		try {
			//Term parsedExpression = scalarFunction.getTerm();
			//ExpressionInferTypeVisitor typeInferer = StoExCache.singleton().getEntry(specification).getTypeInferer();
			//typeInferer.getTypeAnnotation().put(arg0, arg1)
			Expression parsedExpression = StoExCache.singleton().getEntry(specification).getParsedExpression();

			PCMStoExEvaluationVisitor visitor = new PCMStoExEvaluationVisitor(specification,stackframe,VariableMode.RETURN_DEFAULT_ON_NOT_FOUND);
			Object number = visitor.doSwitch(parsedExpression);
			return toDoubleOrZero(number);
		} catch (RuntimeException e){
			logger.warn("Error when evaluating processing rate cost function: "+e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}


	public static double getInitialCost(
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
	private static double getProcessingRate(VariableProcessingResourceCost varCost) {
		//TODO: what about longs and shorts and stuff here? 
		if ( varCost.getProcessingresourcespecification() != null 
				&& varCost.getProcessingresourcespecification().getProcessingRate_ProcessingResourceSpecification() != null 
				&& varCost.getProcessingresourcespecification().getProcessingRate_ProcessingResourceSpecification().getSpecification() != null) {
			return getDoubleFromSpecification(varCost.getProcessingresourcespecification().getProcessingRate_ProcessingResourceSpecification().getSpecification());
		} 
		return 0;
	}

}
