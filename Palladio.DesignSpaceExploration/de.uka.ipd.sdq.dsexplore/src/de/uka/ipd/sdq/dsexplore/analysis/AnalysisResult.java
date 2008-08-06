package de.uka.ipd.sdq.dsexplore.analysis;

import java.util.Collection;

import de.uka.ipd.sdq.dsexplore.qualityAttributes.Performance;
import de.uka.ipd.sdq.dsexplore.qualityAttributes.QualityAttribute;

/**
 * Class to store the results of a DSE analysis step.
 * <code>AnalysisResult</code>s abstract from the actual analysis that was
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
public interface AnalysisResult {
	
	public double getMeanValue();

	public void setMeanValue(double meanValue);
	


}

