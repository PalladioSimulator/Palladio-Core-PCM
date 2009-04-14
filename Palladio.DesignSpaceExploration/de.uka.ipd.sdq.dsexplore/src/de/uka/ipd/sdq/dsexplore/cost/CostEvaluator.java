package de.uka.ipd.sdq.dsexplore.cost;

import java.util.Iterator;
import java.util.List;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.pcm.cost.Cost;
import de.uka.ipd.sdq.pcm.cost.CostRepository;
import de.uka.ipd.sdq.pcm.cost.VariableProcessingResourceCost;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;

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
	 * 
	 * Careful: This must point to the right pcm instance first. 
	 * @param pcm the PCM instance
	 * @return 
	 */
	private double getInitialCost(PCMInstance pcm){
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

	/**
	 * Careful: This must point to the right pcm instance first. 
	 * @param pcm
	 * @return
	 */
	private double getOperatingCost(PCMInstance pcm){
		return 0.0;
	}
	
	/**
	 * This calculates the perpetuity (see http://en.wikipedia.org/wiki/Present_value) cost.
	 * @param pcm
	 * @param interest If interest <= 0, no operating cost are taken into account.
	 * @return
	 */
	public double getTotalCost(PCMInstance pcm, double interest){
		
		//Important: "Read in" the right PCM instance first.  
		updateCostModel(pcm);
		
		double operatingCost = 0;
		if (interest > 0){
			operatingCost = this.getOperatingCost(pcm)/interest;
		}
		return this.getInitialCost(pcm) + operatingCost;
	}

	private void updateCostModel(PCMInstance pcm) {

		// Fix all urls in the cost model file

		// Fix reporitory URLs

		// Fix resource environment references
		List<Cost> allCosts = this.costModel.getCost();
		
		for (Cost cost : allCosts) {

			if (VariableProcessingResourceCost.class.isInstance(cost)) {
				
				VariableProcessingResourceCost varCost = (VariableProcessingResourceCost)cost; 

				ProcessingResourceSpecification old_prs = ((VariableProcessingResourceCost) cost)
						.getProcessingresourcespecification();
				ResourceContainer old_rc = (ResourceContainer) old_prs
						.eContainer();
				ProcessingResourceType ars = old_prs
						.getActiveResourceType_ActiveResourceSpecification();

				List<ResourceContainer> all_new_rcs = pcm
						.getResourceenvironment()
						.getResourceContainer_ResourceEnvironment();
				
				for (ResourceContainer resourceContainer : all_new_rcs) {
					
					if (resourceContainer.getId().equals(old_rc.getId())) {
						
						List<ProcessingResourceSpecification> new_resources = resourceContainer
								.getActiveResourceSpecifications_ResourceContainer();
						
						boolean resourceTypeFound = false;
						
						for (ProcessingResourceSpecification new_prs : new_resources) {
							
							if (new_prs
									.getActiveResourceType_ActiveResourceSpecification()
									.getId()
									.equals(ars.getId())) {
								if (!resourceTypeFound){
									//Reset the processing rate with the first matching one found
									varCost.setProcessingresourcespecification(new_prs);
									resourceTypeFound = true;
								} else {
									throw new RuntimeException("There are two processing resources with the same resource type within one resource container, this cannot be handled by the optimisation yet. Please change your model.");
								}
							}
						}
						break;
					}

					/*
					 * Resource resource = prs.eResource(); if (resource !=
					 * null){ URI oldURI = resource.getURI();
					 * resource.setURI(resEnvFileURI); } else {
					 * System.out.println
					 * ("Resource of ProcessingResourceSpecification "
					 * +prs.toString()+" has a null eResource!"); }
					 */
				}
			}
		}

	}
	
	

}
