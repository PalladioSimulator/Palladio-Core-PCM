package de.uka.ipd.sdq.ByCounter.execution;

import java.util.Arrays;


/**
 * A class that contains all parameter information that is needed
 * for method invocation at runtime.
 *
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.9
 */
public class RuntimeMethodParameters {

	/* Conversion constants */
	public static final  int TO_PRIMITIVE_BOOLEAN		= 1;
	public static final  int TO_PRIMITIVE_BYTE			= 2;
	public static final  int TO_PRIMITIVE_CHAR			= 3;
	public static final  int TO_PRIMITIVE_DOUBLE		= 4;
	public static final  int TO_PRIMITIVE_FLOAT			= 5;
	public static final  int TO_PRIMITIVE_INT			= 6;
	public static final  int TO_PRIMITIVE_LONG			= 7;
	public static final  int TO_PRIMITIVE_SHORT			= 8;
	public static final  int TO_ARRAY_PRIMITIVE_BOOLEAN	= 11;
	public static final  int TO_ARRAY_PRIMITIVE_BYTE	= 12;
	public static final  int TO_ARRAY_PRIMITIVE_CHAR	= 13;
	public static final  int TO_ARRAY_PRIMITIVE_DOUBLE	= 14;
	public static final  int TO_ARRAY_PRIMITIVE_FLOAT	= 15;
	public static final  int TO_ARRAY_PRIMITIVE_INT		= 16;
	public static final  int TO_ARRAY_PRIMITIVE_LONG	= 17;
	public static final  int TO_ARRAY_PRIMITIVE_SHORT	= 18;
	public static final  int TO_ARRAY_PRIMITIVE_OBJECT	= 18;
	public static final  int TO_REAL_CLASS_TYPE			= 0;
	
	/**
	 * Constants that specify conversions to class types as in Object.getClass().
	 */
	private int[] conversions;		
	
	/**
	 * TODO
	 */
	private Long[] innerElementCharacterisation;

	/**
	 * the method parameters 
	 */
	private Object[] parameters;
	
	/**
	 * Construct an empty runtime parameter set.
	 */
	public RuntimeMethodParameters() {
		this.parameters = new Object[]{};
		this.conversions = new int[]{};
	}
	
	/**
	 * Construct a runtime parameter set.
	 * @param parameters the method parameters as objects.
	 * @param conversions an array holding the conversion constants for all parameters
	 */
	public RuntimeMethodParameters(Object[] parameters, int[] conversions) {
		this.parameters = parameters;
		this.conversions = conversions;
	}

	/**
	 * @return the conversions
	 */
	public int[] getConversions() {
		return conversions;
	}
	
	/**
	 * @return the parameters
	 */
	public Object[] getParameters() {
		return parameters;
	}
	/**
	 * @param conversions the conversions to set
	 */
	public void setConversions(int[] conversions) {
		this.conversions = conversions;
	}

	/**
	 * @param parameters the parameters to set
	 */
	public void setParameters(Object[] parameters) {
		this.parameters = parameters;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return ("RuntimeMethodParameters instance: ["+
				Arrays.toString(conversions)+
				Arrays.toString(innerElementCharacterisation)+
				Arrays.toString(parameters)+"]");
	}
	
}
