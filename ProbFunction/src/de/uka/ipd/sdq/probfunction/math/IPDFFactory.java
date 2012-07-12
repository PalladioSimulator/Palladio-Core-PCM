package de.uka.ipd.sdq.probfunction.math;

public interface IPDFFactory extends IDiscretePDFFactory, IContinousPDFFactory {
	
	public void setRandomGenerator(IRandomGenerator randomGenerator);

}
