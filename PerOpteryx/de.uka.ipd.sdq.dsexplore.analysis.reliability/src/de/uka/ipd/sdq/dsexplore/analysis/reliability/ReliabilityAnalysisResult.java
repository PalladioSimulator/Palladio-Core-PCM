package de.uka.ipd.sdq.dsexplore.analysis.reliability;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apache.log4j.Logger;
import org.opt4j.core.Criterion;

import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcmsolver.runconfig.PCMSolverWorkflowRunConfiguration;

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

	/**
	 * Store the reliability result. If the number of exact decimal places has been limited in the
	 * {@link PCMSolverWorkflowRunConfiguration}, the result is rounded to that value by cutting all following places. 
	 * @param d
	 * @param lastPCMSolverConfigurationconfiguration to determine whether to round the result. 
	 */
	public ReliabilityAnalysisResult(double d, PCMSolverWorkflowRunConfiguration lastPCMSolverConfiguration) {
		boolean limitedNumberOfExactDecimalPlaces = lastPCMSolverConfiguration.isNumberOfExactDecimalPlacesEnabled();
		if (limitedNumberOfExactDecimalPlaces){
			// +1 to not loose any information, because the solver is accurate to at least the given number of places. 
			int numberOfPlaces = lastPCMSolverConfiguration.getNumberOfExactDecimalPlaces()+1;
			BigDecimal bigD = new BigDecimal(d);
			bigD = bigD.setScale(numberOfPlaces, RoundingMode.FLOOR);
			d = bigD.doubleValue();
		}
		this.pofod = d;
	}

	/**
	 * {@inheritDoc}
	 * TODO: check correct criterion
	 */
	@Override
	public double getValueFor(Criterion criterion)  {
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
