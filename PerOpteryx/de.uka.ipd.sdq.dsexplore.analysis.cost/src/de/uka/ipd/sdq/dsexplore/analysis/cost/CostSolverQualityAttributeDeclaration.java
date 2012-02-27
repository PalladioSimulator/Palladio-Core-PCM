/**
 * 
 */
package de.uka.ipd.sdq.dsexplore.analysis.cost;

import java.util.List;
import java.util.ArrayList;

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
public class CostSolverQualityAttributeDeclaration implements IAnalysisQualityAttributeDeclaration {

	public static final String qualityAttributeTotalCost = QMLConstantsContainer.QUALITY_ATTRIBUTE_DIMENSION_TOTAL_COST_DEFINITION_PATH;
	public static final String qualityAttributeInitialCost = QMLConstantsContainer.QUALITY_ATTRIBUTE_DIMENSION_INITIAL_COST_DEFINITION_PATH;
	public static final String qualityAttributeOperatingCost = QMLConstantsContainer.QUALITY_ATTRIBUTE_DIMENSION_OPERATING_COST_DEFINITION_PATH;
	
	private Dimension totalCost;
	private Dimension initialCost;
	private Dimension operatingCost;
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.dsexplore.analysis.IQualityAttribute#getDimension()
	 */
	@Override
	public List<Dimension> getDimensions() {
		this.totalCost = new QMLDimensionReader().getDimension(qualityAttributeTotalCost);
		this.initialCost = new QMLDimensionReader().getDimension(qualityAttributeInitialCost);
		this.operatingCost = new QMLDimensionReader().getDimension(qualityAttributeOperatingCost);
		List<Dimension> result = new ArrayList<Dimension>(1);
		result.add(this.totalCost);
		result.add(this.initialCost);
		result.add(this.operatingCost);
		return result;
	}
	
	protected Dimension getTotalCostDimension(){
		return this.totalCost;
	}
	
	protected Dimension getInitialCostDimension(){
		return this.initialCost;
	}
	
	protected Dimension getOperatingCostDimension(){
		return this.operatingCost;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.dsexplore.analysis.IAnalysisQualityAttribute#getDimension()
	 */
	@Override
	public boolean canEvaluateAspectForDimension(EvaluationAspect aspect, Dimension dimension) {
		if(aspect instanceof Value) {
			return true;
		}
		return false;
	}

	@Override
	public QualityAttribute getQualityAttribute() {
		return QualityAttribute.COST_QUALITY;
	}

}
