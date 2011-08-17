package de.uka.ipd.sdq.dsexplore.analysis.cost;

import org.opt4j.core.Criterion;

import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;

public class CostAnalysisResult implements IAnalysisResult {

	private double totalCost;

	public CostAnalysisResult(double totalCost, PCMInstance pcmInstance2) {
		this.totalCost = totalCost;
	}

	@Override
	public double getValueFor(Criterion criterion)  {
		return this.totalCost;
	}

	public double getTotalCost() {
		return totalCost;
	}


}
