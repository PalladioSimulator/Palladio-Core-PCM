package de.uka.ipd.sdq.dsexplore.analysis.cost;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.opt4j.core.Objective;

import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysis;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.dsexplore.helper.EMFHelper;
import de.uka.ipd.sdq.dsexplore.launch.DSEConstantsContainer;
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
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.pcm.blackboard.PCMResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadPCMModelsIntoBlackboardJob;

public class CostEvaluator implements IAnalysis{

	private CostRepository costModel;
	private MDSDBlackboard blackboard;
	private CostAnalysisResult lastCostResult;

	/** 
	 * Sums up the initial cost of the PCM elements present in the given PCM instance.
	 * TODO For now, all cost in the internal costRepository are considered. Thus, only 
	 * variable cost lead to a change in cost, e.g. the variable cost for 
	 * changing processing rates. 
	 * 
	 * Careful: This must point to the right pcm instance first. 
	 * @param pcmInstance the PCM instance
	 * @return 
	 */
	private double getInitialCost(PCMInstance pcmInstance){
		List<Cost> costs = costModel.getCost();
		double sum = 0;
		for (Iterator<Cost> iterator = costs.iterator(); iterator.hasNext();) {
			Cost cost = iterator.next();
			if (doesCostApply(cost,pcmInstance)){
				sum += cost.getInitialCost();
			}
		}
		
		return sum;
	}

	/**
	 * Only checks uses in system (for components) and in the allocation (for processing resources)
	 * @param cost
	 * @param pcmInstance
	 * @return
	 */
	private boolean doesCostApply(Cost cost, PCMInstance pcmInstance) {
		if (VariableProcessingResourceCost.class.isInstance(cost)){
			VariableProcessingResourceCost vc = (VariableProcessingResourceCost)cost;
			ResourceContainer rc = (ResourceContainer)vc.getProcessingresourcespecification().eContainer();
			return checkWhetherResourceContainerIsUsed(pcmInstance, rc);
			//No usage of resource container found, return false. 
		} else if (ComponentCost.class.isInstance(cost)){
			ComponentCost cc = (ComponentCost)cost;
			RepositoryComponent rc = cc.getRepositoryComponent();
			List<AssemblyContext> asctx = pcmInstance.getSystem().getAssemblyContexts_ComposedStructure();
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
			return checkWhetherResourceContainerIsUsed(pcmInstance, rc);
		} else 
			return true;
	}

	private boolean checkWhetherResourceContainerIsUsed(PCMInstance pcmInstance,
			ResourceContainer rc) {
		List<AllocationContext> alloc = pcmInstance.getAllocation().getAllocationContexts_Allocation();
		for (AllocationContext allocationContext : alloc) {
			if (EMFHelper.checkIdentity(allocationContext.getResourceContainer_AllocationContext(), rc)){
				return true;
			}
		}
		return false;
	}

	/**
	 * Careful: This must point to the right pcm instance first. 
	 * @param pcmInstance
	 * @return
	 */
	private double getOperatingCost(PCMInstance pcmInstance){
		return 0.0;
	}
	
	/**
	 * This calculates the perpetuity (see http://en.wikipedia.org/wiki/Present_value) cost.
	 * @param pcmInstance
	 * @param interest If interest <= 0, no operating cost are taken into account.
	 * @return
	 */
	public double getTotalCost(PCMInstance pcmInstance, double interest){
		
		//Important: "Read in" the right PCM instance first.  
		updateCostModel(pcmInstance);
		
		double operatingCost = 0;
		if (interest > 0){
			operatingCost = this.getOperatingCost(pcmInstance)/interest;
		}
		return this.getInitialCost(pcmInstance) + operatingCost;
	}

	private void updateCostModel(PCMInstance pcmInstance) {

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

				List<ResourceContainer> all_new_rcs = pcmInstance.getResourceEnvironment()
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
	public void analyse(IProgressMonitor monitor)
			throws CoreException, UserCanceledException, JobFailedException,
			AnalysisFailedException {
		this.lastCostResult = new CostAnalysisResult(getTotalCost(getPCMInstance(), 0), getPCMInstance());
	}
	
	@Override
	public String getQualityAttribute() throws CoreException {
		return DSEConstantsContainer.COST_QUALITY;
	}

	@Override
	public void initialise(ILaunchConfiguration configuration) throws CoreException {
		
		CostRepository costs = getCostModel(configuration);
		this.costModel = costs;
		
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
	
	private PCMInstance getPCMInstance(){
		return new PCMInstance((PCMResourceSetPartition)this.blackboard.getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID));
	}

	@Override
	public boolean hasStatisticResults() throws CoreException {
		return false;
	}

	@Override
	public List<Objective> getObjectives() throws CoreException {
		List<Objective> objectives = new ArrayList<Objective>(1);
		Objective o = new Objective(this.getQualityAttribute(), Objective.Sign.MIN);
		objectives.add(o);
		
		return objectives;
	}

	@Override
	public IAnalysisResult retrieveLastResultsForObjective(Objective objective)
			throws CoreException, AnalysisFailedException {
		return this.lastCostResult;
	}

	@Override
	public boolean hasObjectivePerUsageScenario() throws CoreException {
		return false;
	}


	@Override
	public void setBlackboard(MDSDBlackboard blackboard) {
		this.blackboard = blackboard;
	}

}
