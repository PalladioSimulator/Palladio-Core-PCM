package de.uka.ipd.sdq.dsexplore.cost;

import java.util.Iterator;
import java.util.List;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.pcm.cost.Cost;
import de.uka.ipd.sdq.pcm.cost.CostRepository;

public class CostEvaluator {

	private CostRepository costModel;

	public CostEvaluator(CostRepository costs) {
		this.costModel = costs;
	}
	
	/** 
	 * Sums up the initial cost of the PCM elements present in the given PCM instance.
	 * TODO For now, all cost in the internal costRepository are considered. Thus, only 
	 * variable cost lead to a change in cost, e.g. the variable cost for 
	 * changing processing rates. 
	 * @param pcm the PCM instance
	 * @return 
	 */
	public double getInitialCost(PCMInstance pcm){
		List<Cost> costs = costModel.getCost();
		double sum = 0;
		for (Iterator<Cost> iterator = costs.iterator(); iterator.hasNext();) {
			Cost cost = iterator.next();
			//XXX Later: only sum up the cost of things that are really used in the instance. This might need more thought with the copying of the pcm instance, so that the right phenotype is looked at. 
			//if (modelElementIsUsedIn(cost.getAnnotatedElement(),pcm)){
				sum += cost.getInitialCost();
			//}
		}
		
		return sum;
	}

	public double getOperatingCost(PCMInstance pcm){
		return 0.0;
	}
	
	/**
	 * This calculates the perpetuity (see http://en.wikipedia.org/wiki/Present_value) cost.
	 * @param pcm
	 * @param interest If interest <= 0, no operating cost are taken into account.
	 * @return
	 */
	public double getTotalCost(PCMInstance pcm, double interest){
		double operatingCost = 0;
		if (interest > 0){
			operatingCost = this.getOperatingCost(pcm)/interest;
		}
		return this.getInitialCost(pcm) + operatingCost;
	}
	
	

}
