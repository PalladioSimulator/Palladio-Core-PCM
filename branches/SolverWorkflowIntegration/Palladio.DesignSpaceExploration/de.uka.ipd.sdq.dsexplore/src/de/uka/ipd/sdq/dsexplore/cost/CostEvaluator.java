package de.uka.ipd.sdq.dsexplore.cost;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.helper.EMFHelper;
import de.uka.ipd.sdq.identifier.Identifier;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.cost.ComponentCost;
import de.uka.ipd.sdq.pcm.cost.Cost;
import de.uka.ipd.sdq.pcm.cost.CostRepository;
import de.uka.ipd.sdq.pcm.cost.VariableProcessingResourceCost;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
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
			if (doesCostApply(cost,pcm)){
				sum += cost.getInitialCost();
			}
		}
		
		return sum;
	}

	/**
	 * Only checks uses in system (for components) and in the allocation (for processing resources)
	 * @param cost
	 * @param pcm
	 * @return
	 */
	private boolean doesCostApply(Cost cost, PCMInstance pcm) {
		if (VariableProcessingResourceCost.class.isInstance(cost)){
			VariableProcessingResourceCost vc = (VariableProcessingResourceCost)cost;
			ResourceContainer rc = (ResourceContainer)vc.getProcessingresourcespecification().eContainer();
			List<AllocationContext> alloc = pcm.getAllocation().getAllocationContexts_Allocation();
			for (AllocationContext allocationContext : alloc) {
				if (EMFHelper.checkIdentity(allocationContext.getResourceContainer_AllocationContext(), rc)){
					return true;
				}
			}
			//No usage of resource container found, return false. 
			return false;
		} else if (ComponentCost.class.isInstance(cost)){
			ComponentCost cc = (ComponentCost)cost;
			RepositoryComponent rc = cc.getRepositoryComponent();
			List<AssemblyContext> asctx = pcm.getSystem().getAssemblyContexts_ComposedStructure();
			for (AssemblyContext assemblyContext : asctx) {
				if (EMFHelper.checkIdentity(assemblyContext.getEncapsulatedComponent_AssemblyContext(), rc)){
					return true;
				}
			}
			return false;
		} else 
			return true;
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
