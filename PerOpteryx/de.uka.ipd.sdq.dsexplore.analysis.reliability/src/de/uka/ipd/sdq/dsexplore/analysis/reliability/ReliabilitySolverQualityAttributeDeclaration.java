/**
 * 
 */
package de.uka.ipd.sdq.dsexplore.analysis.reliability;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisQualityAttributeDeclaration;
import de.uka.ipd.sdq.dsexplore.launch.DSEConstantsContainer.QualityAttribute;
import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EvaluationAspect;
import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Value;
import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Dimension;
import de.uka.ipd.sdq.dsexplore.qml.handling.QMLConstantsContainer;
import de.uka.ipd.sdq.dsexplore.qml.reader.QMLDimensionReader;

/**
 * This class declares, which {@code Dimension} and {@code EvaluationAspect} can 
 * be evaluated by this extension.
 * 
 * @author noorshams
 *
 */
public class ReliabilitySolverQualityAttributeDeclaration implements IAnalysisQualityAttributeDeclaration {

	public static final String qualityAttribute = QMLConstantsContainer.QUALITY_ATTRIBUTE_DIMENSION_POFOD_DEFINITION_PATH;
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.dsexplore.analysis.IAnalysisQualityAttribute#canEvaluateAspect(de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EvaluationAspect)
	 */
	@Override
	public boolean canEvaluateAspectForDimension(EvaluationAspect aspect, Dimension dimension) {
		if(aspect instanceof Value) {
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.dsexplore.analysis.IAnalysisQualityAttribute#getDimension()
	 */
	@Override
	public List<Dimension> getDimensions() {
		Dimension dimension = new QMLDimensionReader().getDimension(qualityAttribute);
		List<Dimension> result = new ArrayList<Dimension>(1);
		result.add(dimension);
		return result;
	}

	@Override
	public QualityAttribute getQualityAttribute() {
		return QualityAttribute.RELIABILITY_QUALITY;
	}

}
