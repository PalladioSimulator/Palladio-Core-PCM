package de.uka.ipd.sdq.simucomframework.variables.functions;

import de.uka.ipd.sdq.probfunction.math.IPDFFactory;
import de.uka.ipd.sdq.probfunction.math.IRandomGenerator;


public abstract class AbstractProbDistFunction implements IFunction
{
	protected IRandomGenerator randomGen;
	protected IPDFFactory factory;
	
	public AbstractProbDistFunction(IRandomGenerator randomGen, IPDFFactory factory) {

		this.randomGen = randomGen;
		this.factory = factory;
	}
	

}
