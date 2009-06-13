package de.uka.ipd.sdq.dsexplore.opt4j.representation;


import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.opt4j.genotype.DoubleGenotype;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.designdecisions.alternativecomponents.AlternativeComponent;
import de.uka.ipd.sdq.dsexplore.helper.EMFHelper;
import de.uka.ipd.sdq.featureconfig.Configuration;
import de.uka.ipd.sdq.featureconfig.FeatureConfig;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.cost.util.CostUtil;
import de.uka.ipd.sdq.pcm.designdecision.AllocationDecision;
import de.uka.ipd.sdq.pcm.designdecision.AssembledComponentDecision;
import de.uka.ipd.sdq.pcm.designdecision.AvailableServers;
import de.uka.ipd.sdq.pcm.designdecision.ConnectorConfigDecision;
import de.uka.ipd.sdq.pcm.designdecision.DesignDecision;
import de.uka.ipd.sdq.pcm.designdecision.DoubleRange;
import de.uka.ipd.sdq.pcm.designdecision.EquivalentComponents;
import de.uka.ipd.sdq.pcm.designdecision.Problem;
import de.uka.ipd.sdq.pcm.designdecision.ProcessingRateDecision;
import de.uka.ipd.sdq.pcm.designdecision.SoapOrRmi;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionFactory;
import de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionFactoryImpl;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;

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
	
	private DoubleGenotype initialGenotype = null;
	
	/**
	 * @param initialInstance
	 */
	public DSEProblem(PCMInstance initialInstance){
		this.initialInstance = initialInstance;
		
		this.designDecisionFactory = designdecisionFactoryImpl.init();
		
		this.pcmProblem = this.designDecisionFactory.createProblem();
		
		//analyse PCM Instance and create design decisions
		//TODO: could this be possible with a M2M transformation? 
		//First, only get design decisions for making resources faster. 

		this.initialGenotype = new DoubleGenotype();
		
		determineProcessingRateDecisions();
		
		//find equivalent components
		determineAssembledComponentsDecisions();
		
		determineAllocationDecisions();
		
		//Quickfix: Add a Soap or RMI decision. This is not meta modelled. 
		//determineSOAPOrRMIDecisions();
		
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


	/**
	 * XXX: This is not meta modelled and just a quick fix
	 * 
	 */
	private void determineSOAPOrRMIDecisions() {
		
		Configuration connectorConfig = this.initialInstance.getConnectorConfig();
		FeatureConfig featureConfig = connectorConfig.getDefaultConfig();
		
		ConnectorConfigDecision cd = this.designDecisionFactory.createConnectorConfigDecision();
		SoapOrRmi domain = this.designDecisionFactory.createSoapOrRmi();
		
		cd.setDomain(domain);
		cd.setFeatureconfig(featureConfig);
		
		this.pcmProblem.getDesigndecision().add(cd);
		
		//0.0 stands for SOAP, 1.0 for RMI
		this.initialGenotype.add(0.0);
		
	}


	private void determineAllocationDecisions() {
		List<AllocationContext> acs = this.initialInstance.getAllocation().getAllocationContexts_Allocation();
		List<ResourceContainer> rcs = this.initialInstance.getResourceenvironment().getResourceContainer_ResourceEnvironment();
		
		
		
		//each allocation context could be allocated on each container.
		for (AllocationContext ac : acs) {
			AllocationDecision ad = this.designDecisionFactory.createAllocationDecision();
			ad.setAllocationcontext(ac);
			AvailableServers servers = this.designDecisionFactory.createAvailableServers();
			servers.getResourcecontainer().addAll(rcs);
			ad.setDomain(servers);
			this.pcmProblem.getDesigndecision().add(ad);
			this.initialGenotype.add(new Double(servers.getResourcecontainer().indexOf(ac.getResourceContainer_AllocationContext())));
		}
		
		
		
	}


	/**
	 * Be sure to add one design decision and one gene in the initial genotype at once. The index is important.
	 * @param genotypeIndex
	 */
	private void determineAssembledComponentsDecisions() {
		AlternativeComponent ac = AlternativeComponent.getInstance();
		List<AssembledComponentDecision> decisions = ac.generateDesignDecisions(this.initialInstance);
		
		for (AssembledComponentDecision designDecision : decisions) {
			this.pcmProblem.getDesigndecision().add(designDecision);
			EList<RepositoryComponent> ec = ((EquivalentComponents) designDecision.getDomain()).getRepositorycomponent();
			RepositoryComponent currentlyAssembledComponent = designDecision.getAssemblycontext().getEncapsulatedComponent_AssemblyContext();
			
			//determine where the original component is in the map
			boolean foundInitialRepoComponent = false;
			for (RepositoryComponent repositoryComponent : ec) {
				if (EMFHelper.checkIdentity(repositoryComponent, currentlyAssembledComponent)){
					this.initialGenotype.add(new Double(ec.indexOf(repositoryComponent)));
					foundInitialRepoComponent = true;
					break;
				}
			}
			if (!foundInitialRepoComponent){
				this.initialGenotype.add(0.0);
			}
			
		}

	}

	/**
	 * Be sure to add one design decision and one gene in the initial genotype at once. The index is important.
	 */
	private void determineProcessingRateDecisions() {
		List<ResourceContainer> resourceContainers = this.initialInstance.getAllResourceContainers();
		for (ResourceContainer resourceContainer : resourceContainers) {
			List<ProcessingResourceSpecification> resources = resourceContainer.getActiveResourceSpecifications_ResourceContainer();
			for (ProcessingResourceSpecification resource : resources) {
				ProcessingRateDecision decision = this.designDecisionFactory.createProcessingRateDecision();
				DoubleRange range = this.designDecisionFactory.createDoubleRange();
				range.setLowerBoundIncluded(false);
				double currentRate = CostUtil.getDoubleFromSpecification(resource.getProcessingRate_ProcessingResourceSpecification().getSpecification());
				//XXX initial assumption: the highest possible processingRate is 10 times the current one.
				range.setTo(currentRate * 2.0);
				range.setFrom(currentRate * 0.5);
				decision.setDomain(range);
				decision.setProcessingresourcespecification(resource);
				decision.setResourcecontainer(resourceContainer);
				this.pcmProblem.getDesigndecision().add(decision);
				this.initialGenotype.add(currentRate);
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


	protected DesignDecision getDesignDecision(int index){
		return this.pcmProblem.getDesigndecision().get(index);
	}


	protected PCMInstance getInitialInstance() {
		return this.initialInstance;
	}
	
	protected DoubleGenotype getInitialGenotype(){
		return this.initialGenotype;
	}


	public void saveProblem() {

		int index = this.initialInstance.getRepositoryFileName().lastIndexOf("\\");
		String filename = this.initialInstance.getRepositoryFileName().substring(0,index+1)
		+ this.initialInstance.getName()+".designdecision";
		
//		resourceSet.getPackageRegistry().put
//		(designdecisionPackage.eNS_URI, 
//		 designdecisionPackage.eINSTANCE);
		
		EMFHelper.saveToXMIFile(this.pcmProblem, filename);
		
	}
	
	@Override
	public String toString(){
		
		String result = "";
		
		List<DesignDecision> decisions = this.pcmProblem.getDesigndecision();
		for (DesignDecision designDecision : decisions) {
			result += designDecision.toString()+";";
		}
		
		return result;
		
	}

	
}
