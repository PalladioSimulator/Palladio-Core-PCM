package de.uka.ipd.sdq.dsexplore.analysis.reliability;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;

/**
 * This class represents the result of a LQN Solver analysis. 
 * 
 * @author anne
 *
 */
public class ReliabilityAnalysisResult implements IAnalysisResult {
	
	protected static Logger logger = Logger
			.getLogger("de.uka.ipd.sdq.dsexplore");
	

	private double pofod;

	
	public ReliabilityAnalysisResult(double d) {
		this.pofod = d;
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	public int compareTo(IAnalysisResult other) {
		int res = 0;
		
		res = Double.valueOf(getValue())
				.compareTo(other.getValue());

		
		return res;
	}

	/**
	 * {@inheritDoc}
	 */
	public double getValue()  {
		return this.pofod;

	}


	/**
	 * Not applicable to Reliability results. 
	 * @return -1
	 */
	public double getUtilisationOfResource(ResourceContainer container,
			ProcessingResourceSpecification resource)
			 {
		// TODO Implement
		return -1;
	}

}
