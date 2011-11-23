package de.uka.ipd.sdq.probfunction.math;

import de.uka.ipd.sdq.probfunction.math.apache.impl.ContinousPDFFactory;
import de.uka.ipd.sdq.probfunction.math.impl.ProbabilityFunctionFactoryImpl;

public class ApacheProbabilityFunctionFactoryImpl extends
		ProbabilityFunctionFactoryImpl {
	
	static
	{
		ProbabilityFunctionFactoryImpl.factoryInstance = new ApacheProbabilityFunctionFactoryImpl();
	}
	
	
	private ApacheProbabilityFunctionFactoryImpl()
	{
		super(new ContinousPDFFactory());
	}

}
