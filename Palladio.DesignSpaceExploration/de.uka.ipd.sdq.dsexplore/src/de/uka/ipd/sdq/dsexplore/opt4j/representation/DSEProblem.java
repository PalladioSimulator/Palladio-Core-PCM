package de.uka.ipd.sdq.dsexplore.opt4j.representation;


import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.opt4j.genotype.DoubleGenotype;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.designdecisions.alternativecomponents.AlternativeComponent;
import de.uka.ipd.sdq.dsexplore.helper.EMFHelper;
import de.uka.ipd.sdq.dsexplore.helper.FixDesignDecisionReferenceSwitch;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.cost.util.CostUtil;
import de.uka.ipd.sdq.pcm.designdecision.AllocationDegree;
import de.uka.ipd.sdq.pcm.designdecision.AssembledComponentDegree;
import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedom;
import de.uka.ipd.sdq.pcm.designdecision.Problem;
import de.uka.ipd.sdq.pcm.designdecision.ProcessingRateDegree;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionFactory;
import de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionFactoryImpl;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;

/**
 * The {@link DSEProblem} defines the problem. Therefore, it reads in the 
 * current PCM instances and identifies the available design options to define 
 * the design space. 
 * 
 * @author Anne
 *
 */
public class DSEProblem {
	
	private DimensionBounds bounds;
	
	/**
	 * Is changed during the evaluation, as the decisions refer to it.
	 */
	private PCMInstance initialInstance;
	
	private Problem pcmProblem;
	private designdecisionFactory designDecisionFactory;
	
	private List<DoubleGenotype> initialGenotypeList = null;
	
	/**
	 * @param initialInstance
	 * @throws CoreException 
	 */
	public DSEProblem(PCMInstance initialInstance, boolean newProblem) throws CoreException{
		this.initialInstance = initialInstance;
		
		this.designDecisionFactory = designdecisionFactoryImpl.init();
		
		if (newProblem){
			initialiseProblem();
		} else {
			AlternativeComponent.getInstance().generateDesignDecisions(initialInstance);
			Problem problem = readInProblem();
			this.pcmProblem = problem;
			this.initialGenotypeList = determineInitialGenotype(problem);
		}
		
		this.bounds = new DimensionBounds(this.pcmProblem);

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


	private List<DoubleGenotype> determineInitialGenotype(Problem problem) {
		DoubleGenotype genotype = new DoubleGenotype();
		
		for (DegreeOfFreedom dd : problem.getDesigndecision()) {
			if (dd instanceof AssembledComponentDegree){
				AssembledComponentDegree acd = (AssembledComponentDegree)dd;
				AssemblyContext ac = (AssemblyContext)acd.getChangeableEntity();
				RepositoryComponent rc = ac.getEncapsulatedComponent_AssemblyContext();
				List<Entity> listInMemory = acd.getDomainOfEntities();
				int index = EMFHelper.indexOfByID(listInMemory, rc.getId());
				genotype.add(new Double(index));
			} else if (dd instanceof AllocationDegree){
				AllocationDegree ad = (AllocationDegree)dd;
				AllocationContext ac = (AllocationContext)ad.getChangeableEntity();
				ResourceContainer rc = ac.getResourceContainer_AllocationContext();
				List<Entity> listInMemory = ad.getDomainOfEntities();
				int index = EMFHelper.indexOfByID(listInMemory, rc.getId());
				genotype.add(new Double(index));
			} else if (dd instanceof ProcessingRateDegree){
				ProcessingRateDegree prd = (ProcessingRateDegree)dd;
				ResourceContainer rc = (ResourceContainer)prd.getChangeableEntity();
				List<ProcessingResourceSpecification> prsList = rc.getActiveResourceSpecifications_ResourceContainer();
				ProcessingResourceType prt = prd.getProcessingresourcetype();
				
				ProcessingResourceSpecification rightPrs = null;
				for (ProcessingResourceSpecification prs : prsList) {
					if (EMFHelper.checkIdentity(prs.getActiveResourceType_ActiveResourceSpecification(),prt)){
						rightPrs = prs;
						break;
					}
				}
				
				if (rightPrs != null){
					genotype.add(new Double(CostUtil.getDoubleFromSpecification(rightPrs.getProcessingRate_ProcessingResourceSpecification().getSpecification())));
				} else 
					throw new RuntimeException("Invalid degree of freedom "+dd.toString()+". The references ProcessingResourceType is not available in the given ResourceContainer.");
				}
		};

		//determineProcessingRateDecisions(new ArrayList<DesignDecision>(), genotype);
		//determineAssembledComponentsDecisions(new ArrayList<DesignDecision>(), genotype);
		//determineAllocationDecisions(new ArrayList<DesignDecision>(), genotype);
		List<DoubleGenotype> result = new ArrayList<DoubleGenotype>();
		result.add(genotype);
		return result;
	}


	private void initialiseProblem() {
		this.pcmProblem = this.designDecisionFactory.createProblem();
		List<DegreeOfFreedom> dds = this.pcmProblem.getDesigndecision();
		//analyse PCM Instance and create design decisions
		//TODO: could this be possible with a M2M transformation? 
		//First, only get design decisions for making resources faster. 
		this.initialGenotypeList = new ArrayList<DoubleGenotype>();
		DoubleGenotype initialCandidate = new DoubleGenotype();
		determineProcessingRateDecisions(dds,initialCandidate);
		//find equivalent components
		determineAssembledComponentsDecisions(dds,initialCandidate);
		determineAllocationDecisions(dds,initialCandidate);
		//Quickfix: Add a Soap or RMI decision. This is not meta modelled. 
		//determineSOAPOrRMIDecisions();
	}


	public DSEProblem(PCMInstance pcmInstance) throws CoreException {
		this(pcmInstance, true);
	}


	/**
	 * XXX: This is not meta modelled and just a quick fix
	 * 
	 */
//	private void determineSOAPOrRMIDecisions(List<DesignDecision> dds, DoubleGenotype genotype) {
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
	private void determineAllocationDecisions(List<DegreeOfFreedom> dds, DoubleGenotype genotype) {
		List<AllocationContext> acs = this.initialInstance.getAllocation().getAllocationContexts_Allocation();
		List<ResourceContainer> rcs = this.initialInstance.getResourceenvironment().getResourceContainer_ResourceEnvironment();
		
		
		
		//each allocation context could be allocated on each container.
		for (AllocationContext ac : acs) {
			AllocationDegree ad = this.designDecisionFactory.createAllocationDegree();
			ad.setChangeableEntity(ac);
			ad.getDomainOfEntities().addAll(rcs);
			dds.add(ad);
			genotype.add(new Double(ad.getDomainOfEntities().indexOf(ac.getResourceContainer_AllocationContext())));
		}
		
		
		
	}


	/**
	 * Be sure to add one design decision and one gene in the initial genotype at once. The index is important.
	 * @param genotypeIndex
	 */
	private void determineAssembledComponentsDecisions(List<DegreeOfFreedom> dds, DoubleGenotype genotype) {
		AlternativeComponent ac = AlternativeComponent.getInstance();
		List<AssembledComponentDegree> decisions = ac.generateDesignDecisions(this.initialInstance);
		
		for (AssembledComponentDegree designDecision : decisions) {
			dds.add(designDecision);
			EList<Entity> ec = designDecision.getDomainOfEntities();
			RepositoryComponent currentlyAssembledComponent = ((AssemblyContext)designDecision.getChangeableEntity()).getEncapsulatedComponent_AssemblyContext();
			
			//determine where the original component is in the map
			boolean foundInitialRepoComponent = false;
			for (Entity repositoryComponent : ec) {
				if (EMFHelper.checkIdentity(repositoryComponent, currentlyAssembledComponent)){
					genotype.add(new Double(ec.indexOf(repositoryComponent)));
					foundInitialRepoComponent = true;
					break;
				}
			}
			if (!foundInitialRepoComponent){
				genotype.add(0.0);
			}
			
		}

	}

	/**
	 * Be sure to add one design decision and one gene in the initial genotype at once. The index is important.
	 */
	private void determineProcessingRateDecisions(List<DegreeOfFreedom> dds, DoubleGenotype genotype) {
		List<ResourceContainer> resourceContainers = this.initialInstance.getAllResourceContainers();
		for (ResourceContainer resourceContainer : resourceContainers) {
			List<ProcessingResourceSpecification> resources = resourceContainer.getActiveResourceSpecifications_ResourceContainer();
			for (ProcessingResourceSpecification resource : resources) {
				ProcessingRateDegree decision = this.designDecisionFactory.createProcessingRateDegree();
				decision.setLowerBoundIncluded(false);
				double currentRate = CostUtil.getDoubleFromSpecification(resource.getProcessingRate_ProcessingResourceSpecification().getSpecification());
				//XXX initial assumption: the highest possible processingRate is 10 times the current one.
				decision.setTo(currentRate * 2.0);
				decision.setFrom(currentRate * 0.5);
				decision.setChangeableEntity(resourceContainer);
				decision.setProcessingresourcetype(resource.getActiveResourceType_ActiveResourceSpecification());
				dds.add(decision);
				genotype.add(currentRate);
				;
			}
		}
}


	public int getNumberOfDimensions(){
		return bounds.numberOfDimensions();
	}
	
	public DimensionBounds getBounds(){
		return this.bounds;
	}


	protected DegreeOfFreedom getDesignDecision(int index){
		return this.pcmProblem.getDesigndecision().get(index);
	}

	public List<DegreeOfFreedom> getDesignDecisions(){
		return this.pcmProblem.getDesigndecision();
	}


	protected PCMInstance getInitialInstance() {
		return this.initialInstance;
	}
	
	protected List<DoubleGenotype> getInitialGenotypeList(){
		return this.initialGenotypeList;
	}


	public void saveProblem() {

		String filename = getDesignDecisionFileName();
		
//		resourceSet.getPackageRegistry().put
//		(designdecisionPackage.eNS_URI, 
//		 designdecisionPackage.eINSTANCE);
		
		EMFHelper.saveToXMIFile(this.pcmProblem, filename);
		
	}
	

	private String getDesignDecisionFileName() {
		int index = this.initialInstance.getRepositoryFileName().lastIndexOf("\\");
		String filename = this.initialInstance.getRepositoryFileName().substring(0,index+1)
		+ this.initialInstance.getName()+".designdecision";
		return filename;
	}
	
	@Override
	public String toString(){
		
		String result = "";
		
		List<DegreeOfFreedom> decisions = this.pcmProblem.getDesigndecision();
		for (DegreeOfFreedom designDecision : decisions) {
			result += designDecision.toString()+";";
		}
		
		return result;
		
	}

	
	public Problem readInProblem() throws CoreException {
		String filename = getDesignDecisionFileName();
		EObject eproblem = EMFHelper.loadFromXMIFile(filename);
		if (!(eproblem instanceof Problem)){
			throw new CoreException(new Status(Status.ERROR, "de.uka.ipd.sdq.dsexplore", 0, "Cannot read design decision file "+filename+". Please create a new one.", null));
}
		Problem problem = (Problem)eproblem;
		//Adjust references with the right loaded model objects in memory?

		FixDesignDecisionReferenceSwitch visitor = new FixDesignDecisionReferenceSwitch(this.initialInstance);
		visitor.doSwitch(problem);
		 
		return problem;
	}
	
	public void setInitialPopulation(List<DoubleGenotype> population){
		this.initialGenotypeList = population;
	}

	
}
