package de.uka.ipd.sdq.dsexplore.analysis.cost;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.opt4j.core.Constraint;
import org.opt4j.core.Criterion;
import org.opt4j.core.Objective;

import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysis;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.dsexplore.analysis.PCMPhenotype;
import de.uka.ipd.sdq.dsexplore.helper.EMFHelper;
import de.uka.ipd.sdq.dsexplore.launch.DSEConstantsContainer;
import de.uka.ipd.sdq.dsexplore.launch.DSEWorkflowConfiguration;
import de.uka.ipd.sdq.dsexplore.launch.DSEConstantsContainer.QualityAttribute;
import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EvaluationAspect;
import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Dimension;
import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.EvaluationAspectWithContext;
import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.builder.InfeasibilityConstraintBuilder;
import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.builder.ObjectiveBuilder;
import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.builder.SatisfactionConstraintBuilder;
import de.uka.ipd.sdq.dsexplore.qml.pcm.reader.PCMDeclarationsReader;
import de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.UsageScenarioRequirement;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.cost.ComponentCostPerInstance;
import de.uka.ipd.sdq.pcm.cost.ComponentCostPerType;
import de.uka.ipd.sdq.pcm.cost.Cost;
import de.uka.ipd.sdq.pcm.cost.CostRepository;
import de.uka.ipd.sdq.pcm.cost.FixedProcessingResourceCost;
import de.uka.ipd.sdq.pcm.cost.ProcessingResourceCost;
import de.uka.ipd.sdq.pcm.cost.VariableProcessingResourceCost;
import de.uka.ipd.sdq.pcm.cost.helper.CostUtil;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.pcm.blackboard.PCMResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadPCMModelsIntoBlackboardJob;

public class CostEvaluator implements IAnalysis{

	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore.analysis.cost");
	
	private CostRepository costModel;
	private MDSDBlackboard blackboard;
	
	private CostSolverQualityAttributeDeclaration costQualityAttribute = new CostSolverQualityAttributeDeclaration();

	//Constraint handling
	private List<Criterion> criteria = new ArrayList<Criterion>();
	private Map<Criterion, EvaluationAspectWithContext> criterionToAspect = new HashMap<Criterion, EvaluationAspectWithContext>(); //This is needed to determine, what THE result is (Mean,  Variance, ...)
	
	private Map<Long, CostAnalysisResult> previousCostResults = new HashMap<Long, CostAnalysisResult>();
	
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
		} else if (cost instanceof ComponentCostPerType){
			ComponentCostPerType cc = (ComponentCostPerType)cost;
			RepositoryComponent rc = cc.getRepositoryComponent();
			//List<AssemblyContext> asctx = pcmInstance.getSystem().getAssemblyContexts__ComposedStructure();
			//TODO: also retrieve inner assembly contexts of deployed composite components. Cost currently need to be specified separately.
			
			List<AssemblyContext> asctx =  getAllContainedAssemblyContexts(pcmInstance.getSystem().getAssemblyContexts__ComposedStructure());
			
			
			for (AssemblyContext assemblyContext : asctx) {
				if (EMFHelper.checkIdentity(assemblyContext.getEncapsulatedComponent__AssemblyContext(), rc)){
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

	/** 
	 * Get all contained ones recursively
	 * @param assemblyContextsComposedStructure
	 * @return
	 */
	private List<AssemblyContext> getAllContainedAssemblyContexts(
			EList<AssemblyContext> assemblyContextsComposedStructure) {
		List<AssemblyContext> list = new ArrayList<AssemblyContext>();
		list.addAll(assemblyContextsComposedStructure);
		for (AssemblyContext assemblyContext : assemblyContextsComposedStructure) {
			if (assemblyContext.getEncapsulatedComponent__AssemblyContext() instanceof ComposedStructure){
				ComposedStructure composite = (ComposedStructure)assemblyContext.getEncapsulatedComponent__AssemblyContext();
				list.addAll(getAllContainedAssemblyContexts(composite.getAssemblyContexts__ComposedStructure()));
			}
		}
		return list;
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
		List<Cost> costs = costModel.getCost();
		double sum = 0;
		for (Iterator<Cost> iterator = costs.iterator(); iterator.hasNext();) {
			Cost cost = iterator.next();
			if (doesCostApply(cost,pcmInstance)){
				sum += cost.getOperatingCost();
			}
		}
		
		return sum;
	}
	
	/**
	 * This calculates the perpetuity (see http://en.wikipedia.org/wiki/Present_value) cost.
	 * @param pcmInstance
	 * @param interest If interest <= 0, no operating cost are taken into account.
	 * @param numberOfYears 
	 * @return
	 */
	private double getTotalCost(double initialCost, double operatingCost, double interest, int numberOfYears){
		
		double operatingCostWithInterest = 0;
		
		if (interest < 0 ){
			logger.error("Negative interest rate not supported by cost evaluator");
			return Double.NaN;
		}
		
		if (numberOfYears == 0){
			if (interest == 0 ){
				logger.warn("Interest rate of 0 and no time period lead to infinite costs over time ");
				return Double.POSITIVE_INFINITY;
			} else {
				operatingCostWithInterest = operatingCost/interest;
			}
		} else {
			if (interest == 0){
				operatingCostWithInterest = operatingCost * numberOfYears;

			} else {
				// FIXME: Fix this calculation, results of course in negative values!
				//operatingCostWithInterest = operatingCost * Math.pow( 1- (1 + interest), -1*numberOfYears);
				throw new UnsupportedOperationException("Perpetuity for a number of years not yet implemented. Contact developers.");
			}
		}
		return initialCost + operatingCostWithInterest;
	}

	private void updateCostModel(PCMInstance pcmInstance) {

		List<Cost> allCosts = this.costModel.getCost();
		
		createCostsForReplicas(allCosts, pcmInstance);
		
		for (Cost cost : allCosts) {

			// fix links between model elements (maybe this is not needed anymore...)
			if (cost instanceof ComponentCostPerInstance){
				((ComponentCostPerInstance) cost).setAllocation(pcmInstance.getAllocation());
			} else 	if (VariableProcessingResourceCost.class.isInstance(cost)) {
				
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
	
	/**
	 * FIXME: this should be more elegantly handled by separating a resource repository with costs specification from 
	 * the actually used resources
	 * @param allCosts
	 * @param pcmInstance
	 */
	private void createCostsForReplicas(List<Cost> allCosts,
			PCMInstance pcmInstance) {
		
		List<ResourceContainer> containers = pcmInstance.getResourceEnvironment().getResourceContainer_ResourceEnvironment();
		List<Cost> replicaCosts = new ArrayList<Cost>(); 
		
		// also remove old replica costs from previous candidates
		List<Cost> oldReplicaCosts = new ArrayList<Cost>();
		
		for (Cost anyCost : allCosts) {
			
			// iterate through costs, look at all VariableProcessingResourceCost or FixedProcessingResourceCost and in particular at their resourcecontainer.
			ResourceContainer originalContainer = null;
			ProcessingResourceType procResourceType = null;
			ProcessingResourceCost cost = null;
			if (anyCost instanceof ProcessingResourceCost){
				cost = ((ProcessingResourceCost)anyCost);
				originalContainer = cost.getProcessingresourcespecification().getResourceContainer_ProcessingResourceSpecification();
				procResourceType = cost.getProcessingresourcespecification().getActiveResourceType_ActiveResourceSpecification();
			} else {
				// look at next cost model element
				continue;
			}
			
			// check if this is a cost model element for a replica, if yes delete it if its server is no longer in the resource environment
			if (originalContainer.getEntityName().contains("Replica")  && !containers.contains(originalContainer)){
				oldReplicaCosts.add(cost);
			}

			// find replicated servers and their original
			for (ResourceContainer resourceContainer : containers) {
				if (resourceContainer.getEntityName().contains("Replica") && resourceContainer.getId().contains(originalContainer.getId())){
					// resourceContainer is a replica of originalResourceContainer
					
					// check if there already is a cost model element for the replica. If not, create a new one.
					boolean replicaAlreadyAnnotated = false;
					for (Cost existingCost : allCosts) {
						if (existingCost instanceof ProcessingResourceCost){
							ProcessingResourceCost existingProcRateCost = (ProcessingResourceCost)existingCost;
							if (existingProcRateCost.getProcessingresourcespecification().getResourceContainer_ProcessingResourceSpecification().getId()
								.equals(resourceContainer.getId())){
								// there already is a cost model element annotating this replica, so continue;
								replicaAlreadyAnnotated = true;
								break; // inner for loop 
							}
						}
					}
					if (replicaAlreadyAnnotated){
						continue;
					}
					
					// get the processing resource spec that corresponds to the annotated one
					ProcessingResourceSpecification replicaProcSpec = null;
					for (ProcessingResourceSpecification procRes : resourceContainer.getActiveResourceSpecifications_ResourceContainer()) {
						if (procRes.getActiveResourceType_ActiveResourceSpecification().getId().equals(procResourceType.getId())){
							replicaProcSpec = procRes;
							break;
						}
					}
					if (replicaProcSpec == null){
						logger.warn("Could not find processing resource type "+procResourceType.getEntityName()+" in container "+resourceContainer.getEntityName()+", assuming that there are no costs for it in this replica");
						return;
					}

					// replicate cost element, too.
					ProcessingResourceCost replicaCost = (ProcessingResourceCost)EcoreUtil.copy(cost);
					replicaCost.setProcessingresourcespecification(replicaProcSpec);
					replicaCosts.add(replicaCost);
				}
			}
		}
		allCosts.removeAll(oldReplicaCosts);
		allCosts.addAll(replicaCosts);
	}



	@Override
	public void analyse(PCMPhenotype pheno, IProgressMonitor monitor)
			throws CoreException, UserCanceledException, JobFailedException,
			AnalysisFailedException {
		PCMInstance pcm = pheno.getPCMInstance();
		//Important: "Read in" the right PCM instance first.  
		updateCostModel(pcm);
		
		double initialCost = getInitialCost(pcm);
		double operatingCost = getOperatingCost(pcm);
		this.previousCostResults.put(pheno.getNumericID(), new CostAnalysisResult(
				getTotalCost(initialCost, operatingCost, costModel.getInterest(), costModel.getTimePeriodYears()), initialCost, operatingCost, 
				pcm, this.criterionToAspect, this.costQualityAttribute));
		CostUtil.getInstance().resetCache();
	}
	
	@Override
	public QualityAttribute getQualityAttribute() throws CoreException {
		//return DSEConstantsContainer.COST_QUALITY;
		return costQualityAttribute.getQualityAttribute();
	}

	@Override
	public void initialise(DSEWorkflowConfiguration configuration) throws CoreException {
		
		CostRepository costs = getCostModel(configuration);
		this.costModel = costs;
		
		initialiseCriteria(configuration);
    }
	
	
	private void initialiseCriteria(DSEWorkflowConfiguration configuration) throws CoreException{
		
		PCMInstance pcmInstance = getPCMInstance();
		UsageModel usageModel = pcmInstance.getUsageModel();
		
		PCMDeclarationsReader reader = new PCMDeclarationsReader(
				configuration.getRawConfiguration().getAttribute("qmlDefinitionFile", ""));
		
		List<Dimension> dimensions = this.costQualityAttribute.getDimensions();
		
		List<EvaluationAspectWithContext> costAspects = new ArrayList<EvaluationAspectWithContext>(6);
		for (Dimension dimension : dimensions) {
			costAspects.addAll(reader.getDimensionConstraintContextsForUsageModel(usageModel, dimension.getId()));
			costAspects.addAll(reader.getDimensionObjectiveContextsForUsageModel(usageModel, dimension.getId()));
		}
		
		
		//Check constraint aspects and create Constraint-Objects for every Aspect
		for (Iterator<EvaluationAspectWithContext> iterator = costAspects.iterator(); iterator.hasNext();) {
			EvaluationAspectWithContext aspectContext = iterator
					.next();
			
			if(aspectContext.getRequirement() instanceof UsageScenarioRequirement) {				
	
						//Handle possible aspects here
						if (canEvaluateAspect(aspectContext.getEvaluationAspect(), aspectContext.getDimension())) { 
							
							if(aspectContext.getCriterion() instanceof de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Constraint) {
								Constraint c = reader.translateEvalAspectToInfeasibilityConstraint(aspectContext, new InfeasibilityConstraintBuilder());
								criteria.add(c);
								criterionToAspect.put(c, aspectContext);
							} else {
								//instanceof Objective
								Objective o = reader.translateEvalAspectToObjective(this.getQualityAttribute().getName(), aspectContext, new ObjectiveBuilder());
								criteria.add(o);
								criterionToAspect.put(o, aspectContext);
								
								Constraint c = reader.translateEvalAspectToSatisfactionConstraint(aspectContext, o, new SatisfactionConstraintBuilder()); 
								criteria.add(c);
								criterionToAspect.put(c, aspectContext);
							}
						} else {
							//XXX: This should never be the case if the optimization is started with the LaunchConfig the aspect is checked there as well
							throw new RuntimeException("Evaluation aspect not supported("+aspectContext.getEvaluationAspect()+")!");
						}
					
				
			} else {
				throw new RuntimeException("Unsupported Requirement!");
			}
			
		}
	}
	
	private boolean canEvaluateAspect(EvaluationAspect aspect, Dimension dimension){
		return costQualityAttribute.canEvaluateAspectForDimension(aspect, dimension);
	}
	

	/**
	 * returns a cost model or throws an exception. 
	 * @param configuration.getRawConfiguration()
	 * @return a CostRepository which is not null
	 * @throws CoreException if the model could not be loaded.  
	 */
	private CostRepository getCostModel(DSEWorkflowConfiguration configuration) throws CoreException {
		String costModelFileName = configuration.getRawConfiguration().getAttribute(DSEConstantsContainer.COST_FILE, "");
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
	public List<Criterion> getCriterions() throws CoreException {
		List<Criterion> criterions = new ArrayList<Criterion>();
		 
		criterions.addAll(criteria);

		return criterions;
	}

	@Override
	public IAnalysisResult retrieveResultsFor(PCMPhenotype pheno, Criterion criterion)
			throws CoreException, AnalysisFailedException {
		//It is always the cost value, i.e. objective and constraint always have to refer to the SimpleValue (-> no statistical requirements atm)
		//If more possible aspects are added, the criterion needs to be examined here
		
		return this.previousCostResults.get(pheno.getNumericID());
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
