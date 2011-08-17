/**
 * 
 */
package de.uka.ipd.sdq.dsexplore.analysis;

import de.uka.ipd.sdq.dsexplore.launch.DSEConstantsContainer.QualityAttribute;
import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EvaluationAspect;
import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Dimension;

import java.util.List;

/**
 * This class is to be implemented by extensions of de.uka.ipd.sdq.dsexplore.analysis.
 * It declares, which {@code Dimension} and {@code EvaluationAspect} can be evaluated.
 * 
 * FIXME: there is a conceptual mismatch here: An attribute is performance, not response time
 * SimuCom can for example evaluate response time and throughput. These are two dimensions, but only
 * one attribute, namely performance. Thus, attribute : dimension is not 1:1. (Anne)
 * 
 * @author noorshams
 *
 */
public interface IAnalysisQualityAttributeDeclaration {
	
	public QualityAttribute getQualityAttribute();
	
	/**
	 * 
	 * @return the Dimension that can be evaluated.
	 */
	public List<Dimension> getDimensions();
	
	/**
	 * 
	 * @param aspect
	 * @param dimension TODO
	 * @return {@code true}, if the {@code EvaluationAspect} can be evaluated;<br>{@code false}, otherwise.
	 */
	public boolean canEvaluateAspectForDimension(EvaluationAspect aspect, Dimension dimension); 
}
