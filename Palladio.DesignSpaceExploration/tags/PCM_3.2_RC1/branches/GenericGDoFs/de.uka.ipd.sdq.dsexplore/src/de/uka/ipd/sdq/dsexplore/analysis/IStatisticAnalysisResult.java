package de.uka.ipd.sdq.dsexplore.analysis;

import de.uka.ipd.sdq.statistics.estimation.ConfidenceInterval;

public interface IStatisticAnalysisResult extends IAnalysisResult {

	public double getMedianValue();
	
	//public double getUtilisationOfResource(PassiveResourceSpecification resource);

	public double getMeanValue();
	
	public double getStandardDeviation();
	
	public double getCoefficientOfVariance();

	public ConfidenceInterval getConfidenceInterval();
	
	public long getNumberOfObservations();
}
