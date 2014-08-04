package de.uka.ipd.sdq.simucomframework.variables.converter;

/**
 * Helper class for basic type conversions
 * 
 * @author Steffen Becker
 *
 */
public class NumberConverter {
    /**
     * Cast the given object to double
     * 
     * @param o
     *            The object to cast
     * @return The double represented by o
     */
    public static double toDouble(Object o) {
        if (o instanceof Double) {
            return (Double) o;
        } else if (o instanceof Integer) {
            int i = (Integer) o;
            return i;
        }
        throw new RuntimeException("Can't case " + o + " to double!");
    }
}
