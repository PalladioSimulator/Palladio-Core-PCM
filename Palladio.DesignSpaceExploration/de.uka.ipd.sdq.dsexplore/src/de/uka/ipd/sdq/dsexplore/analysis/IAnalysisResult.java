package de.uka.ipd.sdq.dsexplore.analysis;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.qualityAttributes.QualityAttribute;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;

/**
 * Class to store the results of a DSE analysis step.
 * <code>IAnalysisResult</code>s abstract from the actual analysis that was
 * conducted, e.g. SimuCom or an LQN analysis. The results are stored in an
 * general way here. Initially, this is just a mean value. Later, this class can
 * be extended to include more sophisticated results.
 * 
 * Maybe later I could have make this an interface defining several methods that
 * is then implemented by classes such as SimuComAnalysisResults (which stores
 * the <code>Measurements</code>). This is one dimension of differences in
 * analysis results.
 * 
 * Additionally, I have different {@link QualityAttribute}s as analysis results
 * and for each, different metrics that may be of interest. The different
 * metrics are derived for different PCM entities, e.g. the utilisation of a
 * resource for performance or the response time of a service or scenario for
 * performance. However, I will leave this aside for now and just do what I need
 * for SimuCom Performance results with mean response time values for scenarios.
 * 
 * @author Anne
 * 
 */
public interface IAnalysisResult extends Comparable<IAnalysisResult>{
	
	/**
	 * Get the mean value of an analysis result.
	 * @return mean value calculated from this analysis result
	 * @throws AnalysisFailedException if the mean value could not be calculated (e.g. because the results are null or because the R connection is not working. 
	 */
	public double getMeanValue() throws AnalysisFailedException;

	public PCMInstance getPCMInstance();
	
	/**
	 * Returns the difference in response time (rounded to an integer). Returns
	 * a negative integer, zero, or a positive integer as this {@link IAnalysisResult} has a lesser,
	 * equal, or greater mean response time than the specified {@link IAnalysisResult} other. 
	 * 
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	int compareTo(IAnalysisResult other);
	
	/**
	 * Returns the utilisation of the goven resource from the analysis results
	 * @param resource
	 * @return a doubke between 0 and 1 that describes the utilisation. 
	 */
	public double getUtilisationOfResource(ResourceContainer container, ProcessingResourceSpecification resource) throws AnalysisFailedException;

	public double getMedianValue() throws AnalysisFailedException;
	
	//public double getUtilisationOfResource(PassiveResourceSpecification resource);


}

