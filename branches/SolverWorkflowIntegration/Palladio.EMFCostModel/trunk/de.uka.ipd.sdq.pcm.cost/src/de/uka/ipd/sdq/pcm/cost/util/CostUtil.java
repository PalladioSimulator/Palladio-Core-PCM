package de.uka.ipd.sdq.pcm.cost.util;

import de.uka.ipd.sdq.simucomframework.variables.StackContext;

public class CostUtil {

	public static double getDoubleFromSpecification(String specification) {
		// TODO Auto-generated method stub
		Object rate = StackContext.evaluateStatic(specification);
		if (Double.class.isInstance(rate)){
			return (Double)rate;
		} else if (Integer.class.isInstance(rate)){
			return ((Integer)rate).doubleValue();
		}
		return 0.0;
	}

}
