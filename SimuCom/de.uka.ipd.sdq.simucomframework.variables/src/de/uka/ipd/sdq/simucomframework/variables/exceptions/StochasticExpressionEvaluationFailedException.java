package de.uka.ipd.sdq.simucomframework.variables.exceptions;

public class StochasticExpressionEvaluationFailedException extends RuntimeException {

    public StochasticExpressionEvaluationFailedException(String string, Exception ex) {
        super(string, ex);
    }

}
