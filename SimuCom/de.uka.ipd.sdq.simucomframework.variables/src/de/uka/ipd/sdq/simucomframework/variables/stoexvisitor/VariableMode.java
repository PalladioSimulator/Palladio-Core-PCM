package de.uka.ipd.sdq.simucomframework.variables.stoexvisitor;

/**
 * Modes for evaluating stochastic expressions.
 * 
 * @author Steffen Becker
 *
 */
public enum VariableMode {

    /**
     * An exception is thrown if the evaluation encounters a variable unknown in the current
     * stackframe
     */
    EXCEPTION_ON_NOT_FOUND,

    /**
     * A default value is returned for variables which do not exist in the stackframe. It is 0 for
     * numeric types and "" for enum types. Useful for determining bytesizes of the stack contents
     * in cases where not for all variables characterisations exist
     */
    RETURN_DEFAULT_ON_NOT_FOUND,

    /**
     * NULL is returned for variables which do not exist in the stackframe. Useful for copying
     * stackframes
     */
    RETURN_NULL_ON_NOT_FOUND
}
