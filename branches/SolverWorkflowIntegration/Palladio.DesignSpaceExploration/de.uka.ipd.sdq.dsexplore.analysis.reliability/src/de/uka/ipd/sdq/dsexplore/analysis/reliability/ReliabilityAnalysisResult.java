package de.uka.ipd.sdq.dsexplore.analysis.reliability;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcmsolver.PCMSolver;
import de.uka.ipd.sdq.pcmsolver.transformations.pcm2markov.Pcm2MarkovStrategy;

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

	
	public ReliabilityAnalysisResult(PCMInstance pcm, PCMSolver solver) {
		this.pcm = pcm;
		
		Pcm2MarkovStrategy strat = (Pcm2MarkovStrategy)solver.getStrategy();
		
		this.pofod = 1 - strat.getSolvedValue();
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
	public double getMeanValue() throws AnalysisFailedException {
		return this.pofod;

	}

	/**
	 * Not applicable to Reliability results. 
	 * @return -1
	 */
	@Override
	public double getMedianValue() throws AnalysisFailedException {
		return -1;
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
			throws AnalysisFailedException {
		// TODO Implement
		return -1;
	}

}
