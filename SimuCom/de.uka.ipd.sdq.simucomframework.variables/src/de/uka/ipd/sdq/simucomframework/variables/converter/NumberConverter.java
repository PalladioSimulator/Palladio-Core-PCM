package de.uka.ipd.sdq.simucomframework.variables.converter;

import javax.naming.OperationNotSupportedException;

public class NumberConverter {
	public static double toDouble(Object o){
		if (o instanceof Double){
			return (Double)o;
		} else if (o instanceof Integer){
			int i = (Integer)o;
			return i;
		}
		throw new RuntimeException("Can't case "+o+" to double!");
	}
}
