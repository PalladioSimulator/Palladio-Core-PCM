package de.uka.ipd.sdq.simucom.stochastics;

import java.io.StringBufferInputStream;

import stoex.parser.ExpressionLexer;
import stoex.parser.ExpressionParser;
import stoex.parser.ExpressionParserTokenTypes;
import stoex.stochastics.RandomVariable;
import stoex.visitors.DefinitionTreeParser;
import antlr.CommonAST;
import antlr.RecognitionException;
import antlr.TokenStreamException;
import antlr.collections.AST;
import de.uka.ipd.sdq.simucom.DistributionObjectsStorage;
import de.uka.ipd.sdq.simucom.SimuComModel;
import de.uka.ipd.sdq.simucom.behaviour.SimulatedStackFrame;

public class RandomVariableHelper {

	public static Object getSample(String specification, SimulatedStackFrame stackFrame) throws Exception {
		StoExEvaluationVisitor evalVisitor = new StoExEvaluationVisitor(specification,stackFrame);
		return evalVisitor.evaluate();
	}	
	
	public static double getDoubleSample(String specification, SimulatedStackFrame stackFrame) throws Exception {
		StoExEvaluationVisitor evalVisitor = new StoExEvaluationVisitor(specification,stackFrame);
		TypeEnum resultType = evalVisitor.getEvaluatedType();
		Object result = evalVisitor.evaluate();
		
		assert result != null;
		
		if (resultType == TypeEnum.INT)
			return ((Integer)result).doubleValue();
		else if (resultType == TypeEnum.REAL)
			return (Double)result;
		else
			throw new Exception("Runtime typecast exception while casting to double "+specification);
	}	

	public static int getIntSample(String specification, SimulatedStackFrame stackFrame) throws Exception {
		StoExEvaluationVisitor evalVisitor = new StoExEvaluationVisitor(specification,stackFrame);
		TypeEnum resultType = evalVisitor.getEvaluatedType();
		Object result = evalVisitor.evaluate();
		
		if (resultType == TypeEnum.INT)
			return (Integer)result;
		else
			throw new Exception("Runtime typecast exception while casting to double "+specification);
	}	
	
}
