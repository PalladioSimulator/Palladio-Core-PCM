package de.uka.ipd.sdq.dsexplore.analysis.cost;

import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.opt4j.core.Criterion;

import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.EvaluationAspectWithContext;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;

public class CostAnalysisResult implements IAnalysisResult {
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore.analysis.cost");

	private double totalCost;
	private double operatingCost;
	private double initialCost;
	
	private Map<Criterion, EvaluationAspectWithContext> criterionToAspectMap;
	private CostSolverQualityAttributeDeclaration costQualityDimensionDeclaration;


	public CostAnalysisResult(double totalCost, double initialCost, double operatingCost, PCMInstance pcmInstance2, Map<Criterion, EvaluationAspectWithContext> criterionToAspect, CostSolverQualityAttributeDeclaration costQualityAttribute) {
		this.totalCost = totalCost;
		this.operatingCost = operatingCost;
		this.initialCost = initialCost;
		this.criterionToAspectMap = criterionToAspect;
		this.costQualityDimensionDeclaration = costQualityAttribute;
	}

	@Override
	public double getValueFor(Criterion criterion)  {
		EvaluationAspectWithContext aspect = this.criterionToAspectMap.get(criterion);
		
		if (aspect != null){
			if (EcoreUtil.equals(aspect.getDimension(), this.costQualityDimensionDeclaration.getTotalCostDimension())){
				return this.getTotalCost();
			} else if (EcoreUtil.equals(aspect.getDimension(), this.costQualityDimensionDeclaration.getInitialCostDimension())){
				return this.getInitialCost();
			}  else if (EcoreUtil.equals(aspect.getDimension(), this.costQualityDimensionDeclaration.getOperatingCostDimension())){
				return this.getOperatingCost();
			}
		} 
		
		logger.warn("Unknown aspect for LQN result, adding NaN.");
		return Double.NaN;
	}

	private double getOperatingCost() {
		return this.operatingCost;
	}

	private double getInitialCost() {
		return this.initialCost;
	}

	public double getTotalCost() {
		return totalCost;
	}


}
