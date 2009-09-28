package de.uka.ipd.sdq.dsexplore.analysis.reliability;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
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
	

	private PCMInstance pcm;


	private double pofod;

	
	public ReliabilityAnalysisResult(PCMInstance pcm, double d) {
		this.pcm = pcm;
		
		this.pofod = d;
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(IAnalysisResult other) {
		int res = 0;
		try {
			res = Double.valueOf(getMeanValue())
					.compareTo(other.getMeanValue());
		} catch (AnalysisFailedException ex) {
			logger.error("Failed to compare the analysis results.", ex);
		}
		
		return res;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getMeanValue()  {
		return this.pofod;

	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public PCMInstance getPCMInstance() {
		return pcm;
	}

	/**
	 * Not applicable to Reliability results. 
	 * @return -1
	 */
	@Override
	public double getUtilisationOfResource(ResourceContainer container,
			ProcessingResourceSpecification resource)
			 {
		// TODO Implement
		return -1;
	}

}
