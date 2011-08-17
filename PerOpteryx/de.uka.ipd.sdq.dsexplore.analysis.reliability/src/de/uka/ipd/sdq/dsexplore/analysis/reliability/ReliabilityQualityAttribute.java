/**
 * 
 */
package de.uka.ipd.sdq.dsexplore.analysis.reliability;

import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisQualityAttribute;
import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EvaluationAspect;
import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Value;
import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Dimension;
import de.uka.ipd.sdq.dsexplore.qml.reader.QMLDimensionReader;

/**
 * This class declares, which {@code Dimension} and {@code EvaluationAspect} can 
 * be evaluated by this extension.
 * 
 * @author noorshams
 *
 */
public class ReliabilityQualityAttribute implements IAnalysisQualityAttribute {

	public static final String qualityAttribute = "pathmap://PCM_MODELS/Dimension_pofod.qmlcontracttype";
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.dsexplore.analysis.IAnalysisQualityAttribute#canEvaluateAspect(de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EvaluationAspect)
	 */
	@Override
	public boolean canEvaluateAspect(EvaluationAspect aspect) {
		if(aspect instanceof Value) {
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.dsexplore.analysis.IAnalysisQualityAttribute#getDimension()
	 */
	@Override
	public Dimension getDimension() {
		return new QMLDimensionReader().getDimension(qualityAttribute);
	}

}
