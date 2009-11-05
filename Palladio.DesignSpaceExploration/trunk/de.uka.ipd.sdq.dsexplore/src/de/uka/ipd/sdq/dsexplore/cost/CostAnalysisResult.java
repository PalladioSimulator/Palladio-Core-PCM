package de.uka.ipd.sdq.dsexplore.cost;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;

public class CostAnalysisResult implements IAnalysisResult {

	private double totalCost;
	private PCMInstance pcmInstance;

	public CostAnalysisResult(double totalCost, PCMInstance pcm) {
		this.totalCost = totalCost;
		this.pcmInstance = pcm;
	}

	@Override
	public int compareTo(IAnalysisResult other) {
		double difference;
		try {
			difference = (this.getMeanValue() - other.getMeanValue());

			if (difference < 0 && difference > -1)
				return -1;
			if (difference > 0 && difference < 1)
				return 1;
			return (int) Math.round(difference);
		} catch (AnalysisFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}


	@Override
	public double getMeanValue()  {
		return this.totalCost;
	}

	@Override
	public PCMInstance getPCMInstance() {
		return this.pcmInstance;
	}

	@Override
	public double getUtilisationOfResource(ResourceContainer container,
			ProcessingResourceSpecification resource)
			throws AnalysisFailedException {
		throw new UnsupportedOperationException("No utilisation for cost model");
	}

	public double getTotalCost() {
		return totalCost;
	}

}
