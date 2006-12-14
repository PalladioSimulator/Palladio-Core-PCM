package de.uka.ipd.sdq.dsolver.pcm2regex;

import java.util.Stack;

import de.uka.ipd.sdq.pcm.usagemodel.Loop;
import de.uka.ipd.sdq.spa.expression.Alternative;
import de.uka.ipd.sdq.spa.expression.Expression;
import de.uka.ipd.sdq.spa.expression.Operation;
import de.uka.ipd.sdq.spa.expression.Sequence;
import de.uka.ipd.sdq.spa.expression.Symbol;

public class ExpressionBuilder {

	private Stack<Operation> opStack;
	private Expression resultExpression;

	public ExpressionBuilder(){
		opStack = new Stack<Operation>();
	}

	public Expression getResultExpression() {
		return resultExpression;
	}

	/**
	 * @param op
	 */
	public void connectToExpression(Operation op) {
		if (opStack.empty()){
			resultExpression = (Expression)op;
			opStack.push(op);
		} else {
			Operation lastOperation = opStack.peek();
			if (lastOperation instanceof Sequence){
				Sequence lastSeq = (Sequence)lastOperation;
				if (lastSeq.getLeftRegExp() == null){
					lastSeq.setLeftRegExp(op);
					opStack.push(op);
				} else if(lastSeq.getRightRegExp() == null){
					lastSeq.setRightRegExp(op);
					opStack.pop();
					opStack.push(op);
				} else {
					opStack.pop();
					connectToExpression(op);
				}
			} else if(lastOperation instanceof Alternative){
				Alternative lastAlt = (Alternative)lastOperation;
				if (lastAlt.getLeftOption().getRegexp() == null){
					lastAlt.getLeftOption().setRegexp(op);
					opStack.push(op);
				} else if(lastAlt.getRightOption().getRegexp() == null){
					lastAlt.getRightOption().setRegexp(op);
					opStack.pop();
					opStack.push(op);
				} else {
					opStack.pop();
					connectToExpression(op);
				}
			} else if(lastOperation instanceof de.uka.ipd.sdq.spa.expression.Loop){
				de.uka.ipd.sdq.spa.expression.Loop lastLoop = (de.uka.ipd.sdq.spa.expression.Loop)lastOperation;
				if (lastLoop.getRegExp() == null){
					lastLoop.setRegExp(op);
					opStack.pop();
					opStack.push(op);
				} else {
					opStack.pop();
					connectToExpression(op);
				}
			}
		}

	}
	

	/**
	 * @param sym
	 */
	public void connectLastSymbol(Symbol sym) {
		Operation lastOperation = opStack.pop();
		if (lastOperation instanceof Sequence){
			Sequence lastSeq = (Sequence)lastOperation;
			lastSeq.setRightRegExp(sym);
		} else if (lastOperation instanceof Alternative){
			Alternative lastAlt = (Alternative)lastOperation;
			lastAlt.getRightOption().setRegexp(sym);
		} else if (lastOperation instanceof Loop){
			de.uka.ipd.sdq.spa.expression.Loop lastLoop = (de.uka.ipd.sdq.spa.expression.Loop)lastOperation;
			lastLoop.setRegExp(sym);
		}
	}
}
