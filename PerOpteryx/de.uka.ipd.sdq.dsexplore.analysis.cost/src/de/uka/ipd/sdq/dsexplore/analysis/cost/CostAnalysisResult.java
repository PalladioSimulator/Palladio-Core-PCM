package de.uka.ipd.sdq.dsexplore.analysis.cost;

import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;

public class CostAnalysisResult implements IAnalysisResult {

	private double totalCost;

	public CostAnalysisResult(double totalCost, PCMInstance pcmInstance2) {
		this.totalCost = totalCost;
	}

	@Override
	public int compareTo(IAnalysisResult other) {
		double difference;
		difference = (this.getValue() - other.getValue());

		if (difference < 0 && difference > -1)
			return -1;
		if (difference > 0 && difference < 1)
			return 1;
		return (int) Math.round(difference);
	}


	@Override
	public double getValue()  {
		return this.totalCost;
	}

	public double getTotalCost() {
		return totalCost;
	}


}
