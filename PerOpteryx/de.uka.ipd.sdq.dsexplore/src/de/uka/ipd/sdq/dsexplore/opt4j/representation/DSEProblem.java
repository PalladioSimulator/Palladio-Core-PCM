package de.uka.ipd.sdq.dsexplore.opt4j.representation;


import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.dsexplore.designdecisions.alternativecomponents.AlternativeComponent;
import de.uka.ipd.sdq.dsexplore.exception.ChoiceOutOfBoundsException;
import de.uka.ipd.sdq.dsexplore.helper.DegreeOfFreedomHelper;
import de.uka.ipd.sdq.dsexplore.helper.EMFHelper;
import de.uka.ipd.sdq.dsexplore.helper.FixDesignDecisionReferenceSwitch;
import de.uka.ipd.sdq.dsexplore.launch.DSEWorkflowConfiguration;
import de.uka.ipd.sdq.dsexplore.opt4j.genotype.DesignDecisionGenotype;
import de.uka.ipd.sdq.dsexplore.opt4j.start.Opt4JStarter;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.cost.helper.CostUtil;
import de.uka.ipd.sdq.pcm.designdecision.AllocationDegree;
import de.uka.ipd.sdq.pcm.designdecision.AssembledComponentDegree;
import de.uka.ipd.sdq.pcm.designdecision.CapacityDegree;
import de.uka.ipd.sdq.pcm.designdecision.ClassChoice;
import de.uka.ipd.sdq.pcm.designdecision.ClassDegree;
import de.uka.ipd.sdq.pcm.designdecision.ContinousRangeChoice;
import de.uka.ipd.sdq.pcm.designdecision.ContinuousProcessingRateDegree;
import de.uka.ipd.sdq.pcm.designdecision.ContinuousRangeDegree;
import de.uka.ipd.sdq.pcm.designdecision.DecisionSpace;
import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedomInstance;
import de.uka.ipd.sdq.pcm.designdecision.DiscreteDegree;
import de.uka.ipd.sdq.pcm.designdecision.DiscreteProcessingRateDegree;
import de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeChoice;
import de.uka.ipd.sdq.pcm.designdecision.NumberOfCoresDegree;
import de.uka.ipd.sdq.pcm.designdecision.ProcessingResourceDegree;
import de.uka.ipd.sdq.pcm.designdecision.ResourceContainerReplicationDegree;
import de.uka.ipd.sdq.pcm.designdecision.SchedulingPolicyDegree;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionFactory;
import de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionFactoryImpl;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.SchedulingPolicy;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;

/**
 * The {@link DSEProblem} defines the problem. Therefore, it reads in the 
 * current PCM instances and identifies the available design options to define 
 * the design space. 
 * 
 * @author Anne
 *
 */
public class DSEProblem {
	
	/**
	 * Is changed during the evaluation, as the decisions refer to it.
	 */
	private PCMInstance initialInstance;
	
	private DecisionSpace pcmProblem;
	private designdecisionFactory designDecisionFactory;
	

	private List<DesignDecisionGenotype> initialGenotypeList = null;

	private DSEWorkflowConfiguration dseConfig;

	private DesignDecisionGenotype initialGenotype;

	
	/**
	 * @param pcmInstance
	 * @throws CoreException 
	 */
	public DSEProblem(DSEWorkflowConfiguration dseConfig, PCMInstance pcmInstance) throws CoreException{
		this.dseConfig = dseConfig;
		
		boolean newProblem = dseConfig.isNewProblem();
		this.initialInstance = pcmInstance;
		
		this.designDecisionFactory = designdecisionFactoryImpl.init();
		
		if (newProblem){
			initialiseProblem();
		} else {
			//Alternative Component has to be called to create the mapping for all AssemblyContexts and their roles, 
			//in order to be able to exchange implementations later. The design decisions calculated here are not kept, only
			//the mapping inside AlternativeComponent.getInstance()
			AlternativeComponent.getInstance().generateDesignDecisions(pcmInstance);
			DecisionSpace problem = loadProblem();
			this.pcmProblem = problem;
			this.initialGenotypeList = determineInitialGenotype(problem);
		}
		
		//TODO: mapping of design decisions to bounds. 
		/*
		 * Meta model design decisions?? Each design decision would know its
		 * bounds and the annotated element or more specific the annotated
		 * property of this element that is exactly the value range than the
		 * bound of the decision. 
		 * 
		 * But what about the genotype? With a ordered list
		 * of design decisions, I can map the genotype entry to a design
		 * decisions. Better group in integer and double, then. -> require CompositeGenotype
		 * 
		 * Also meta-model the genotype as a choice within the range.
		 */		
	}
	
	private DecisionSpace loadProblem() throws CoreException {
		String filename = this.dseConfig.getDesignDecisionFileName();
		return this.loadProblem(filename);
	}
	
	private DecisionSpace loadProblem(String filename) throws CoreException{
		ResourceSet pcmResourceSet = this.initialInstance.getAllocation().eResource().getResourceSet();
		
		EObject eproblem = EMFHelper.loadFromXMIFile(filename, pcmResourceSet);
		if (!(eproblem instanceof DecisionSpace)){
			throw new CoreException(new Status(Status.ERROR, "de.uka.ipd.sdq.dsexplore", 0, "Cannot read design decision file "+filename+". Please create a new one.", null));
		}
		DecisionSpace problem = (DecisionSpace)eproblem;
		//Adjust references with the right loaded model objects in memory?

		FixDesignDecisionReferenceSwitch visitor = new FixDesignDecisionReferenceSwitch(this.initialInstance);
		visitor.doSwitch(problem);
		
		EcoreUtil.resolveAll(eproblem);
		
		return problem;
	}


	private List<DesignDecisionGenotype> determineInitialGenotype(DecisionSpace problem) {
		DesignDecisionGenotype genotype = new DesignDecisionGenotype();
		
		for (DegreeOfFreedomInstance dd : problem.getDegreesOfFreedom()) {
			if (dd instanceof ClassDegree){

				ClassChoice choice = this.designDecisionFactory.createClassChoice();
				choice.setDegreeOfFreedomInstance(dd);

				if (dd instanceof AssembledComponentDegree){
					AssembledComponentDegree acd = (AssembledComponentDegree)dd;
					AssemblyContext ac = (AssemblyContext)acd.getPrimaryChanged();
					RepositoryComponent rc = ac.getEncapsulatedComponent__AssemblyContext();
					choice.setChosenValue(rc);
				} else if (dd instanceof AllocationDegree){
					AllocationDegree ad = (AllocationDegree)dd;
					AllocationContext ac = (AllocationContext)ad.getPrimaryChanged();
					ResourceContainer rc = ac.getResourceContainer_AllocationContext();
					choice.setChosenValue(rc);
				} else throwUnknownDegreeException(dd);
				
				//check if entity is in the domain
				if (!EMFHelper.contains(((ClassDegree) dd).getClassDesignOptions(), choice.getChosenValue())){
					throw new ChoiceOutOfBoundsException(choice, "Error when determining initial genotype"); 
				}
				
				genotype.add(choice);
			} else if (dd instanceof ContinuousRangeDegree){
				
				ContinousRangeChoice choice = this.designDecisionFactory.createContinousRangeChoice();
				choice.setDegreeOfFreedomInstance(dd);
				
				if (dd instanceof ContinuousProcessingRateDegree){
					ContinuousProcessingRateDegree prd = (ContinuousProcessingRateDegree)dd;
					
					ProcessingResourceSpecification rightPrs = getProcessingResourceSpec(prd);

					if (rightPrs != null){
						double rate = CostUtil.getInstance().getDoubleFromSpecification(rightPrs.getProcessingRate_ProcessingResourceSpecification().getSpecification());
						choice.setChosenValue(rate);
					} else 
						throw new RuntimeException("Invalid degree of freedom "+dd.toString()+". The referenced ProcessingResourceType is not available in the given ResourceContainer.");
				} else throwUnknownDegreeException(dd);
				
				genotype.add(choice);
			} else if (dd instanceof SchedulingPolicyDegree){
				
				ClassChoice schedChoice = this.designDecisionFactory.createClassChoice();
				schedChoice.setDegreeOfFreedomInstance(dd);
				
				ProcessingResourceType procType = ((SchedulingPolicyDegree)dd).getProcessingresourcetype();
				ResourceContainer rc = (ResourceContainer)dd.getPrimaryChanged();
				
				SchedulingPolicy policy = null;
				
				for (ProcessingResourceSpecification proc : rc.getActiveResourceSpecifications_ResourceContainer()) {
					if (EMFHelper.checkIdentity(proc.getActiveResourceType_ActiveResourceSpecification(),procType)){
						policy = proc.getSchedulingPolicy();
						break;
					}
				}
				if (policy == null){
					throw new RuntimeException("Invalid degree of freedom "+dd.toString()+". The referenced ProcessingResourceType is not available in the given ResourceContainer.");
				}
				schedChoice.setChosenValue(policy);
				genotype.add(schedChoice);
				
			} else if (dd instanceof DiscreteDegree){
				DiscreteDegree degree = (DiscreteDegree)dd;
				
				DiscreteRangeChoice choice = this.designDecisionFactory.createDiscreteRangeChoice();
				choice.setDegreeOfFreedomInstance(degree);
				
				EObject entity = degree.getPrimaryChanged();
				
				if (degree instanceof CapacityDegree){
					PassiveResource pr = (PassiveResource)entity;
					choice.setChosenValue(Integer.valueOf(pr.getCapacity_PassiveResource().getSpecification()));
				} else if (degree instanceof NumberOfCoresDegree) {
					ProcessingResourceSpecification prd = getProcessingResourceSpec((ProcessingResourceDegree)degree);
					choice.setChosenValue(prd.getNumberOfReplicas());
				} else if (degree instanceof DiscreteProcessingRateDegree){
					
					DiscreteProcessingRateDegree prd = (DiscreteProcessingRateDegree)dd;
					
					ProcessingResourceSpecification rightPrs = getProcessingResourceSpec(prd);

					if (rightPrs != null){
						if (!prd.isLowerBoundIncluded() || !prd.isUpperBoundIncluded()){
							throw new RuntimeException("Only DiscreteProcessingRateDegrees with upper and lower bound included are supported so far, sorry. ");
						}
						double rate = CostUtil.getInstance().getDoubleFromSpecification(rightPrs.getProcessingRate_ProcessingResourceSpecification().getSpecification());
						double startStep = prd.getFrom();
						double endStep = prd.getTo();
						double stepwidth = (endStep - startStep) / prd.getNumberOfSteps();
						
						double chosenStep = (rate - startStep) / stepwidth;  
						choice.setChosenValue((int)chosenStep);
					} else 
						throw new RuntimeException("Invalid degree of freedom "+dd.toString()+". The referenced ProcessingResourceType is not available in the given ResourceContainer.");
				} else if (degree instanceof ResourceContainerReplicationDegree){
					choice.setChosenValue(1);
					
				} else throwUnknownDegreeException(dd);
				genotype.add(choice);
			} else throwUnknownDegreeException(dd);
		};

		//determineProcessingRateDecisions(new ArrayList<DesignDecision>(), genotype);
		//determineAssembledComponentsDecisions(new ArrayList<DesignDecision>(), genotype);
		//determineAllocationDecisions(new ArrayList<DesignDecision>(), genotype);
		List<DesignDecisionGenotype> result = new ArrayList<DesignDecisionGenotype>();
		result.add(genotype);
		this.initialGenotype = genotype;
		return result;
	}

	private ProcessingResourceSpecification getProcessingResourceSpec(
			ProcessingResourceDegree prd) {
		ResourceContainer rc = (ResourceContainer)prd.getPrimaryChanged();
		List<ProcessingResourceSpecification> prsList = rc.getActiveResourceSpecifications_ResourceContainer();
		ProcessingResourceType prt = prd.getProcessingresourcetype();

		ProcessingResourceSpecification rightPrs = null;
		for (ProcessingResourceSpecification prs : prsList) {
			if (EMFHelper.checkIdentity(prs.getActiveResourceType_ActiveResourceSpecification(),prt)){
				rightPrs = prs;
				break;
			}
		}
		return rightPrs;
	}


	private void throwUnknownDegreeException(DegreeOfFreedomInstance dd) {
		throw new RuntimeException("Unknown degree of freedom "+dd.toString()+".");		
	}

	/**
	 * Initialises the degrees of freedoms and at the same time determines the initial genotype. 
	 */
	private void initialiseProblem() {
		this.pcmProblem = this.designDecisionFactory.createDecisionSpace();
		List<DegreeOfFreedomInstance> dds = this.pcmProblem.getDegreesOfFreedom();
		//analyse PCM Instance and create design decisions
		//TODO: could this be possible with a M2M transformation? 
		//First, only get design decisions for making resources faster. 
		this.initialGenotypeList = new ArrayList<DesignDecisionGenotype>();
		DesignDecisionGenotype initialCandidate = new DesignDecisionGenotype();
		determineProcessingRateDecisions(dds,initialCandidate);
		//find equivalent components
		determineAssembledComponentsDecisions(dds,initialCandidate);
		determineAllocationDecisions(dds,initialCandidate);
		//Quickfix: Add a Soap or RMI decision. This is not meta modelled. 
		//determineSOAPOrRMIDecisions();
		determineCapacityDecisions(dds,initialCandidate);
		
		//TODO: Check if the initial genotype is actually a valid genotype? 
		//(this may not be the case if the degrees of freedom have been reduced for the optimisation?)
		
		
		this.initialGenotypeList.add(initialCandidate);

	}



	/**
	 * Determine Capacity options based on {@link Repository}.
	 * Thus, this may detect {@link PassiveResource}s of components that are not used 
	 * in the system. These need to be deleted manually. 
	 * 
	 * Otherwise, I would have to descend in all composed structures to find all {@link BasicComponent}s.
	 * @param dds
	 * @param initialCandidate
	 */
	private void determineCapacityDecisions(List<DegreeOfFreedomInstance> dds,
			DesignDecisionGenotype genotype) {
		
		List<Repository> repositories = this.initialInstance.getRepositories();
		for (Repository repository : repositories) {
			List<RepositoryComponent> components = repository.getComponents__Repository();
			for (RepositoryComponent repositoryComponent : components) {
				if (repositoryComponent instanceof BasicComponent){
					
					BasicComponent basicComponent = (BasicComponent)repositoryComponent;
					List<PassiveResource> passiveResources = basicComponent.getPassiveResource_BasicComponent();
					for (PassiveResource passiveResource : passiveResources) {
						CapacityDegree capacityDegree = this.designDecisionFactory.createCapacityDegree();
						capacityDegree.setPrimaryChanged(passiveResource);
						capacityDegree.setFrom(1);
						capacityDegree.setTo(Integer.valueOf(passiveResource.getCapacity_PassiveResource().getSpecification()));
						dds.add(capacityDegree);
						
						DiscreteRangeChoice choice = this.designDecisionFactory.createDiscreteRangeChoice();
						choice.setDegreeOfFreedomInstance(capacityDegree);
						choice.setChosenValue(Integer.valueOf(passiveResource.getCapacity_PassiveResource().getSpecification()));
						
						genotype.add(choice);
					}
				}
			}
		}
		
	}

	/**
	 * XXX: This is not meta modelled and just a quick fix
	 * 
	 */
//	private void determineSOAPOrRMIDecisions(List<DesignDecision> dds, DesignDecisionGenotype genotype) {
//		
//		Configuration connectorConfig = this.initialInstance.getConnectorConfig();
//		FeatureConfig featureConfig = connectorConfig.getDefaultConfig();
//		
//		ConnectorConfigDecision cd = this.designDecisionFactory.createConnectorConfigDecision();
//		SoapOrRmi domain = this.designDecisionFactory.createSoapOrRmi();
//		
//		cd.setDomain(domain);
//		cd.setFeatureconfig(featureConfig);
//		
//		dds.add(cd);
//		
//		//0.0 stands for SOAP, 1.0 for RMI
//		genotype.add(0.0);
//		
//	}

	//TODO: change this to two visitors that either create the design decision and initial genotype or just initial genotype.  
	private void determineAllocationDecisions(List<DegreeOfFreedomInstance> dds, DesignDecisionGenotype genotype) {
		List<AllocationContext> acs = this.initialInstance.getAllocation().getAllocationContexts_Allocation();
		List<ResourceContainer> rcs = this.initialInstance.getResourceEnvironment().getResourceContainer_ResourceEnvironment();
		
		
		
		//each allocation context could be allocated on each container.
		for (AllocationContext ac : acs) {
			AllocationDegree ad = this.designDecisionFactory.createAllocationDegree();
			ad.setPrimaryChanged(ac);
			ad.getClassDesignOptions().addAll(rcs);
			dds.add(ad);
			
			ClassChoice choice = this.designDecisionFactory.createClassChoice();
			choice.setDegreeOfFreedomInstance(ad);
			choice.setChosenValue(ac.getResourceContainer_AllocationContext());
			
			genotype.add(choice);
		}
		
		
		
	}


	/**
	 * Be sure to add one design decision and one gene in the initial genotype at once. The index is important.
	 * @param genotypeIndex
	 */
	private void determineAssembledComponentsDecisions(List<DegreeOfFreedomInstance> dds, DesignDecisionGenotype genotype) {
		AlternativeComponent ac = AlternativeComponent.getInstance();
		List<AssembledComponentDegree> decisions = ac.generateDesignDecisions(this.initialInstance);
		
		for (AssembledComponentDegree designDecision : decisions) {
			dds.add(designDecision);
			RepositoryComponent currentlyAssembledComponent = ((AssemblyContext)designDecision.getPrimaryChanged()).getEncapsulatedComponent__AssemblyContext();
			
			ClassChoice choice = this.designDecisionFactory.createClassChoice();
			choice.setDegreeOfFreedomInstance(designDecision);
			choice.setChosenValue(currentlyAssembledComponent);
			genotype.add(choice);
			
		}

	}

	/**
	 * Be sure to add one design decision and one gene in the initial genotype at once. The index is important.
	 * Creates {@link ContinuousProcessingRateDegree} decisions for each found processing resource.
	 * 
	 * Also determines {@link SchedulingPolicyDegree}s.
	 * 
	 * TODO: make configurable to also add {@link DiscreteProcessingRateDegree}s.
	 */
	private void determineProcessingRateDecisions(List<DegreeOfFreedomInstance> dds, DesignDecisionGenotype genotype) {
		List<ResourceContainer> resourceContainers = this.initialInstance.getResourceEnvironment().getResourceContainer_ResourceEnvironment();
		for (ResourceContainer resourceContainer : resourceContainers) {
			List<ProcessingResourceSpecification> resources = resourceContainer.getActiveResourceSpecifications_ResourceContainer();
			for (ProcessingResourceSpecification resource : resources) {
				
				//Create ContinuousProcessingRateDegree
				ContinuousProcessingRateDegree decision = this.designDecisionFactory.createContinuousProcessingRateDegree();
				decision.setLowerBoundIncluded(false);
				double currentRate = CostUtil.getInstance().getDoubleFromSpecification(resource.getProcessingRate_ProcessingResourceSpecification().getSpecification());
				//XXX initial assumption: the highest possible processingRate is 10 times the current one.
				decision.setTo(currentRate * 2.0);
				decision.setFrom(currentRate * 0.5);
				decision.setPrimaryChanged(resourceContainer);
				decision.setProcessingresourcetype(resource.getActiveResourceType_ActiveResourceSpecification());
				dds.add(decision);
				
				ContinousRangeChoice choice = this.designDecisionFactory.createContinousRangeChoice();
				choice.setDegreeOfFreedomInstance(decision);
				choice.setChosenValue(currentRate);
				
				genotype.add(choice);
				
				//Create SchedulingPolicyDegree (excluded here, not in default problem, can be modelled manually).
				/*SchedulingPolicyDegree schedulingDecision = this.designDecisionFactory.createSchedulingPolicyDegree();
				SchedulingPolicy currentPolicy = resource.getSchedulingPolicy();
				
				schedulingDecision.getDomainOfAllowedSchedulingPolicies().add(SchedulingPolicy.FCFS);
				schedulingDecision.getDomainOfAllowedSchedulingPolicies().add(SchedulingPolicy.PROCESSOR_SHARING);
				schedulingDecision.setPrimaryChanged(resourceContainer);
				schedulingDecision.setProcessingresourcetype(resource.getActiveResourceType_ActiveResourceSpecification());
				dds.add(schedulingDecision);
				
				SchedulingPolicyChoice schedulingChoice = this.designDecisionFactory.createSchedulingPolicyChoice();
				schedulingChoice.setDegreeOfFreedomInstance(schedulingDecision);
				schedulingChoice.setChosenValue(currentPolicy);
				
				genotype.add(schedulingChoice);*/
				
				
				;
			}
		}
	}


	protected DegreeOfFreedomInstance getDesignDecision(int index){
		return this.pcmProblem.getDegreesOfFreedom().get(index);
	}

	public List<DegreeOfFreedomInstance> getDesignDecisions(){
		return this.pcmProblem.getDegreesOfFreedom();
	}


	public PCMInstance getInitialInstance() {
		return this.initialInstance;
	}
	
	public DesignDecisionGenotype getGenotypeOfInitialPCMInstance(){
		return this.initialGenotype;
	}
	
	protected List<DesignDecisionGenotype> getInitialGenotypeList(){
		return this.initialGenotypeList;
	}


	public void saveProblem() {

		String filename = this.dseConfig.getDesignDecisionFileName();
		
//		resourceSet.getPackageRegistry().put
//		(designdecisionPackage.eNS_URI, 
//		 designdecisionPackage.eINSTANCE);
		
		EMFHelper.saveToXMIFile(this.pcmProblem, filename);
		
	}

	
	@Override
	public String toString(){
		
		String result = "";
		
		List<DegreeOfFreedomInstance> decisions = this.pcmProblem.getDegreesOfFreedom();
		for (DegreeOfFreedomInstance designDecision : decisions) {
			result += DegreeOfFreedomHelper.getDegreeDescription(designDecision)+";";
		}
		
		return result;
		
	}

	
	public void setInitialPopulation(List<DesignDecisionGenotype> population) throws CoreException{
		this.initialGenotypeList = population;
		Opt4JStarter.getDSECreator().setNumberOfNotEvaluatedPredefinedOnes(population.size());
	}

	/**
	 * Returns the degree of freedom of the type (or subtype) that has the given 
	 * entity as the changeableEntity.  
	 * @param entity
	 * @param degreeClass
	 * @return The matching DegreeOfFreedomInstance from this problem. 
	 */
	public DegreeOfFreedomInstance getDegree(Entity entity, Class<? extends DegreeOfFreedomInstance> degreeClass){
		List<DegreeOfFreedomInstance> degrees = this.pcmProblem.getDegreesOfFreedom();
		for (DegreeOfFreedomInstance DegreeOfFreedomInstance : degrees) {
			 
			if (degreeClass.isInstance(DegreeOfFreedomInstance) && DegreeOfFreedomInstance.getPrimaryChanged().equals(entity)){
				return DegreeOfFreedomInstance;
			}
		}
		return null;
	}
	
	public DecisionSpace getEMFProblem(){
		return this.pcmProblem;
	}
	
	
}
