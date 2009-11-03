package de.uka.ipd.sdq.dsexplore.analysis;

import de.uka.ipd.sdq.statistics.estimation.ConfidenceInterval;

public interface IStatisticAnalysisResult extends IAnalysisResult {

	public double getMedianValue() throws AnalysisFailedException;
	
	//public double getUtilisationOfResource(PassiveResourceSpecification resource);

	public double getStandardDeviation() throws AnalysisFailedException;
	
	public double getCoefficientOfVariance() throws AnalysisFailedException;

	public ConfidenceInterval getConfidenceInterval() throws AnalysisFailedException;
	
	public long getNumberOfObservations() throws AnalysisFailedException;
}
