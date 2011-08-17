/**
 * 
 */
package de.uka.ipd.sdq.dsexplore.analysis;

import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EvaluationAspect;
import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Dimension;

/**
 * This class is to be implemented by extensions of de.uka.ipd.sdq.dsexplore.analysis.
 * It declares, which {@code Dimension} and {@code EvaluationAspect} can be evaluated.  
 * 
 * @author noorshams
 *
 */
public interface IAnalysisQualityAttribute {
	
	/**
	 * 
	 * @return the Dimension that can be evaluated.
	 */
	public Dimension getDimension();
	
	/**
	 * 
	 * @param aspect
	 * @return {@code true}, if the {@code EvaluationAspect} can be evaluated;<br>{@code false}, otherwise.
	 */
	public boolean canEvaluateAspect(EvaluationAspect aspect); 
}
