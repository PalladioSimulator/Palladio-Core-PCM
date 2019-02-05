package de.uka.ipd.sdq.stoex.analyser.visitors;

import de.uka.ipd.sdq.stoex.Expression;

class ExpressionSolvingFailedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7389557819248772502L;

	public ExpressionSolvingFailedException(String message, Expression expr) {
		super("Solving expression "+new StoExPrettyPrintVisitor().doSwitch(expr)+"failed: "+message);
	}

	public ExpressionSolvingFailedException(Expression expr, Exception e) {
		super("Solving expression "+new StoExPrettyPrintVisitor().doSwitch(expr)+"failed.",e);
	}
	
	

}
