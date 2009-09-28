package de.uka.ipd.sdq.dsexplore.cost;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysis;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.dsexplore.helper.EMFHelper;
import de.uka.ipd.sdq.dsexplore.launch.DSEConstantsContainer;
import de.uka.ipd.sdq.identifier.Identifier;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.cost.ComponentCost;
import de.uka.ipd.sdq.pcm.cost.Cost;
import de.uka.ipd.sdq.pcm.cost.CostRepository;
import de.uka.ipd.sdq.pcm.cost.FixedProcessingResourceCost;
import de.uka.ipd.sdq.pcm.cost.VariableProcessingResourceCost;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;

public class CostEvaluator implements IAnalysis{

	private CostRepository costModel;

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
			return checkWhetherResourceContainerIsUsed(pcm, rc);
			//No usage of resource container found, return false. 
		} else if (ComponentCost.class.isInstance(cost)){
			ComponentCost cc = (ComponentCost)cost;
			RepositoryComponent rc = cc.getRepositoryComponent();
			List<AssemblyContext> asctx = pcm.getSystem().getAssemblyContexts_ComposedStructure();
			//TODO: also retrieve inner assembly contexts of deployed composite components. Cost currently need to be specified separately. 
			for (AssemblyContext assemblyContext : asctx) {
				if (EMFHelper.checkIdentity(assemblyContext.getEncapsulatedComponent_AssemblyContext(), rc)){
					return true;
				}
			}
			return false;
		} else if (cost instanceof FixedProcessingResourceCost){
			FixedProcessingResourceCost fc = (FixedProcessingResourceCost)cost;
			ResourceContainer rc = (ResourceContainer)fc.getProcessingresourcespecification().eContainer();
			return checkWhetherResourceContainerIsUsed(pcm, rc);
		} else 
			return true;
	}

	private boolean checkWhetherResourceContainerIsUsed(PCMInstance pcm,
			ResourceContainer rc) {
		List<AllocationContext> alloc = pcm.getAllocation().getAllocationContexts_Allocation();
		for (AllocationContext allocationContext : alloc) {
			if (EMFHelper.checkIdentity(allocationContext.getResourceContainer_AllocationContext(), rc)){
				return true;
			}
		}
		return false;
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

	@Override
	public IAnalysisResult analyse(PCMInstance pcmInstance)
			throws CoreException, UserCanceledException, JobFailedException,
			AnalysisFailedException {
		return new CostAnalysisResult(getTotalCost(pcmInstance, 0), pcmInstance);
	}

	@Override
	public String getQualityAttribute() throws CoreException {
		return "cost";
	}

	@Override
	public void initialise(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {
		
		CostRepository costs = getCostModel(configuration);
		this.costModel = costs;
		
	}

	@Override
	public IAnalysisResult retrieveLastResults(PCMInstance pcmInstance)
			throws CoreException, AnalysisFailedException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * returns a cost model or throws an exception. 
	 * @param configuration
	 * @return a CostRepository which is not null
	 * @throws CoreException if the model could not be loaded.  
	 */
	private CostRepository getCostModel(ILaunchConfiguration configuration) throws CoreException {
		String costModelFileName = configuration.getAttribute(DSEConstantsContainer.COST_FILE, "");
		CostRepository cr =  (CostRepository)EMFHelper.loadFromXMIFile(costModelFileName);
		if (cr == null){
			throw new CoreException(new Status(Status.ERROR, "de.uka.ipd.sdq.dsexplore", 0, "Cost model "+costModelFileName+" could not be loaded.", null));
		}
		return cr;
	}
	
	

}
