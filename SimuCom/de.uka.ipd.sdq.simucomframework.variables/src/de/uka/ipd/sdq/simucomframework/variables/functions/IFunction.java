package de.uka.ipd.sdq.simucomframework.variables.functions;

import java.util.List;

/**
 * Interface for functions available in stochastic expression evaluation, like Norm, Trunc, etc.
 * 
 * @author Steffen Becker
 *
 */
public interface IFunction {

    /**
     * Evaluate the functions result using the parameters given
     * 
     * @param parameters
     *            Parameters for the function
     * @return Value of the function
     */
    Object evaluate(List<Object> parameters);

    /**
     * Test whether the given parameters can be processed by this function
     * 
     * @param parameters
     *            A set of parameters to be processed
     * @return true if the parameters fit to the functions preconditions, false otherwise
     */
    boolean checkParameters(List<Object> parameters);
}
