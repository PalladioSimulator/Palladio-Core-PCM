package de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.opt4j.core.Objective;
import org.opt4j.core.Genotype;
import org.opt4j.operator.copy.Copy;

import de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedCommunication;
import de.uka.ipd.sdq.context.aggregatedUsageContext.ComputedAggregatedUsage;
import de.uka.ipd.sdq.context.aggregatedUsageContext.ServiceExecutionContext;
import de.uka.ipd.sdq.dsexplore.helper.EMFHelper;
import de.uka.ipd.sdq.dsexplore.helper.Pair;
import de.uka.ipd.sdq.dsexplore.launch.DSEWorkflowConfiguration;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.AbstractTactic;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.TacticsResultCandidate;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.UtilisationResultCacheAndHelper;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividual;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividualFactory;
import de.uka.ipd.sdq.dsexplore.opt4j.start.Opt4JStarter;
import de.uka.ipd.sdq.dsexplore.qml.handling.QMLConstantsContainer;
import de.uka.ipd.sdq.dsexplore.qml.reader.QMLDimensionReader;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.designdecision.AllocationDegree;
import de.uka.ipd.sdq.pcm.designdecision.Choice;
import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedomInstance;
import de.uka.ipd.sdq.pcm.designdecision.ClassChoice;
import de.uka.ipd.sdq.pcm.designdecision.ClassDegree;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resultdecorator.ResultDecoratorRepository;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.AllocationServiceResult;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.ServiceResult;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.LinkingResourceResults;

public class ReallocateForReduceLinkUsage extends AbstractTactic {

	private double thresholdUtilisation;
	private Objective performance;
	
	protected static Logger logger = Logger.getLogger(ReallocateForReduceLinkUsage.class.getName());


	public ReallocateForReduceLinkUsage(Copy<Genotype> copy,
			DSEIndividualFactory individualFactory,
			DSEWorkflowConfiguration configuration) {
		super(copy, individualFactory, configuration, new String[] {QMLConstantsContainer.QUALITY_ATTRIBUTE_DIMENSION_RESPONSETIME_DEFINITION_PATH,
				QMLConstantsContainer.QUALITY_ATTRIBUTE_DIMENSION_THROUGHPUT_DEFINITION_PATH});
		
		//setHeuristicWeight(configuration.getReallocationForLinkWeight());
		setHeuristicWeight(1);
		//thresholdUtilisation = configuration.getReallocationForLinkUtilisationThreshold();
		thresholdUtilisation = 0.8;
		
		try {
			Collection<Objective> objectives = Opt4JStarter.getDSEEvaluator()
					.getObjectives();
			for (Objective objective : objectives) {
				//XXX: Read the dimension name from definition rather than the constants container
				if (objective.getName().contains(
						new QMLDimensionReader().getDimension(QMLConstantsContainer.QUALITY_ATTRIBUTE_DIMENSION_RESPONSETIME_DEFINITION_PATH).getEntityName())
						|| objective.getName().contains(
								new QMLDimensionReader().getDimension(QMLConstantsContainer.QUALITY_ATTRIBUTE_DIMENSION_THROUGHPUT_DEFINITION_PATH).getEntityName())) {
						//DSEConstantsContainer.MEAN_RESPONSE_TIME_QUALITY)) {
					this.performance = objective;
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public List<TacticsResultCandidate> getHeuristicCandidates(DSEIndividual individual,
			UtilisationResultCacheAndHelper resultsCache) {
		if (performance != null && individual.getObjectives().getResultDecoratorFor(this.performance) != null) {

			ResultDecoratorRepository resultRepo = individual.getObjectives().getResultDecoratorFor(this.performance);

			// 1. check whether a link is used beyond the threshold. 
			// find Linking Resource with highest Utilisation to move components along it.
			LinkingResourceResults linkWithHighestUtil = resultsCache.getMaxLinkUtilisationResult(individual);
			
			// check if there is a link with highest util, maybe this candidate does not use any link
			if (linkWithHighestUtil != null){
				List<ResourceContainer> connectedContainers = linkWithHighestUtil.getLinkingResource_LinkingResourceResults().getConnectedResourceContainers_LinkingResource();

				if (linkWithHighestUtil.getResourceUtilisation() > thresholdUtilisation){

					// group service results by component 
					List<ServiceResult> serviceResultList = resultRepo.getServiceResult_ResultDecoratorRepository();
					
					if (serviceResultList.size() == 0){
						/* Does not matter at this time because this tactics does not yet use the information
						 * about service response time and throughput (could use that to compare with demanded time somehow). 
						 * logger.warn("No service results found for candidate "+individual.getNumericID()+". " +
								"Cannot apply "+this.getClass().getName()+" tactic. Note that the service result " +
										"data is not available for results that have been read in from a predefined population file.");
						*/
					}
					
					List<ComponentAndServiceResult> componentsAndServices = new ArrayList<ComponentAndServiceResult>();
					for (ServiceResult serviceResult : serviceResultList) {
						if (serviceResult instanceof AllocationServiceResult){

							AllocationServiceResult allocServiceResult = (AllocationServiceResult)serviceResult;
							AllocationContext component = allocServiceResult.getAllocationContext_AllocationServiceResult();

							// check whether this is the result for a component. 
							// if it is the result of e.g. a usage scenario, then the component is null.  
							if (component != null){

								ComponentAndServiceResult compReslt = null;
								for (ComponentAndServiceResult componentAndServiceResult : componentsAndServices) {
									if (EMFHelper.checkIdentity(componentAndServiceResult.getComponent(),component)){
										compReslt = componentAndServiceResult;
										break;
									}
								}
								if (compReslt == null){ 
									compReslt = new ComponentAndServiceResult(component, individual);
								} 
								compReslt.addAllocationServiceResult(allocServiceResult);
							}
						} else {
							logger.error("An unknown type of service results has been encountered, expected "+AllocationServiceResult.class.getName()+" only. Encountered type is "+serviceResult.getClass().getName());
						}
					}

					// group service dependency solver results by component
					// results for the services
					ComputedAggregatedUsage computedUsage = individual.getObjectives().getComputedAggregatedUsageFor(this.performance);
					
					if (computedUsage != null){
						List<ServiceExecutionContext> serviceContexts = computedUsage.getServiceExecutionContexts_ComputedAggregatedUsage();
						for (ServiceExecutionContext serviceExecutionContext : serviceContexts) {
							AllocationContext component = serviceExecutionContext.getAllocationContext_ServiceExecutionContext();

							ComponentAndServiceResult compReslt = null;
							for (ComponentAndServiceResult componentAndServiceResult : componentsAndServices) {
								if (EMFHelper.checkIdentity(componentAndServiceResult.getComponent(),component)){
									compReslt = componentAndServiceResult;
									break;
								}
							}
							if (compReslt == null){ 
								compReslt = new ComponentAndServiceResult(component, individual);
								componentsAndServices.add(compReslt);
							} 
							compReslt.addServiceExecutionContext(serviceExecutionContext);
						}

						// count the remote and local calls of each component.
						for (ComponentAndServiceResult componentAndServiceResult : componentsAndServices) {
							componentAndServiceResult.countCalls();
						}

						// get the component that has the highest ratio of calls to one remote server compared to its local calls. 
						Pair<ComponentAndServiceResult, ResourceContainerWithDoubleValue> componentWithTargetContainer = 
							getComponentWithHighestRatioToOneOfContainers(componentsAndServices, connectedContainers);

						return createCandidate(componentWithTargetContainer, individual, linkWithHighestUtil.getResourceUtilisation());
					} else {
						logger.warn("No ComputedUsage found for candidate "+individual.getNumericID()+" , cannot apply linking resource tactic.");
					}
				}
			}
		}
		return Collections.emptyList();
	}

	private List<TacticsResultCandidate> createCandidate(
			Pair<ComponentAndServiceResult, ResourceContainerWithDoubleValue> componentWithTargetContainer, 
			DSEIndividual individual , double highestUtil) {
		if (componentWithTargetContainer == null 
				|| componentWithTargetContainer.getFirst()  == null 
				|| componentWithTargetContainer.getSecond() == null){
			return Collections.emptyList();
		}
		double candidateWeight = Math.max(1, componentWithTargetContainer.getSecond().getSecond() * ((highestUtil - thresholdUtilisation) / (1-thresholdUtilisation)));
		
		
		List<TacticsResultCandidate> result = new ArrayList<TacticsResultCandidate>(1);
		
		TacticsResultCandidate candidate = individualFactory.buildCandidate(copy.copy(individual.getGenotype()), individual);
		candidate.setHeuristic(this);
		candidate.setCandidateWeight(candidateWeight);
		// find choice for the reallocated components degree
		for (Choice choice : candidate.getGenotype()) {
			if (choice instanceof ClassChoice 
					&& EcoreUtil.equals(choice.getDegreeOfFreedomInstance(), 
							componentWithTargetContainer.getFirst().getAllocationDegree())){
				((ClassChoice)choice).setChosenValue(
						EMFHelper.retrieveEntityByID(
								((ClassDegree)choice.getDegreeOfFreedomInstance()).getClassDesignOptions(), 
								componentWithTargetContainer.getSecond().getFirst()));
				result.add(candidate);
				break;
			}
		}
		
		return result;
	}

	/**
	 * @param componentsAndServices
	 * @param connectedContainers
	 * @return May be null or may contain null values if no matching component is found. 
	 */
	private Pair<ComponentAndServiceResult, ResourceContainerWithDoubleValue> getComponentWithHighestRatioToOneOfContainers(
			List<ComponentAndServiceResult> componentsAndServices,
			List<ResourceContainer> connectedContainers) {
		
		Pair<ComponentAndServiceResult, ResourceContainerWithDoubleValue> componentWithTargetContainer = null;
		
		for (ComponentAndServiceResult componentResult : componentsAndServices) {
			// get the ratio of remote calls to the most promising server vs local calls of this component. 
			// the maxContainerOfComponent.getSecond() denotes this ratio. It should be larger than 0.5 for the reallocation to be useful.
			ResourceContainerWithDoubleValue maxContainerOfComponent = componentResult.getMostPromisingContainerToReallocateTo(connectedContainers);
			if (maxContainerOfComponent != null && maxContainerOfComponent.getSecond() > 0.5 &&
					( componentWithTargetContainer == null 
					|| ( maxContainerOfComponent.getSecond() > componentWithTargetContainer.getSecond().getSecond()))){
				//XXX: If two components have the same ratio, we could look at the demanded time and the container utilisation here and decide
				// to either reallocate a "small" component or a "large" component
				//XXX: Maybe do not always return the best, but vary a bit randomly? Weighted based on ratio (if > 0.5?) 
				componentWithTargetContainer = new Pair<ComponentAndServiceResult, ResourceContainerWithDoubleValue>(
						componentResult, 
						maxContainerOfComponent);
			}
		}
		
		
		return componentWithTargetContainer;
		
	}

}

class ComponentAndServiceResult {
	
	private AllocationContext allocationContextOfComponent;
	private List<AllocationServiceResult> allocationServiceResultList = new ArrayList<AllocationServiceResult>();
	private List<ServiceExecutionContext> serviceExecutionContextList = new ArrayList<ServiceExecutionContext>();
	
	private double frequencyLocalCalls = 0;
	
	private List<ResourceContainerWithDoubleValue> frequencyRemoteCalls = new ArrayList<ResourceContainerWithDoubleValue>();
	private List<ResourceContainerWithDoubleValue> ratioRemoteCalls = new ArrayList<ResourceContainerWithDoubleValue>();
	private AllocationDegree allocationDoF;
	private ClassChoice allocationChoice;
	
	public ComponentAndServiceResult(AllocationContext component, DSEIndividual individual) {
		super();
		this.allocationContextOfComponent = component;
		this.allocationDoF = determineAllocationDoF(); 
		this.allocationChoice = determineAllocationChoice(individual);
	}

	public AllocationContext getComponent() {
		return allocationContextOfComponent;
	}

	public AllocationDegree getAllocationDegree() {
		return this.allocationDoF;
	}

	/**
	 * Return the {@link ResourceContainerWithDoubleValue} from the internal list of 
	 * frequency ratios that has the highest value among the containers that this component 
	 * could be deployed to.
	 * 
	 * This means that the internal list is filtered for the passed resource container list
	 * and filtered for the containers that this component may be allocated to 
	 * according to the design decisions.
	 * 
	 * @param candidateContainers
	 * @return The most promising resource container of the passed containers 
	 *         to reallocate this component to. 
	 *         Can be null if this component must not be reallocated or cannot be 
	 *         reallocated to any of the passed candidateContainers.
	 */
	public ResourceContainerWithDoubleValue getMostPromisingContainerToReallocateTo(
			List<ResourceContainer> candidateContainers) {
		
		// filter and retain only the containers to which this component can be allocated.   
		List<ResourceContainer> filteredCandidateContainers = new ArrayList<ResourceContainer>(candidateContainers.size());
		filteredCandidateContainers.addAll(candidateContainers);
		EMFHelper.retainAll(filteredCandidateContainers, this.allocationDoF.getClassDesignOptions());
		
		ResourceContainerWithDoubleValue maxRatioContainer = null;
		for (ResourceContainerWithDoubleValue resourceContainer : this.ratioRemoteCalls) {
			if (EMFHelper.contains(filteredCandidateContainers, resourceContainer.getFirst())
					&& ( maxRatioContainer == null 
							|| resourceContainer.getSecond() > maxRatioContainer.getSecond())){
				maxRatioContainer = resourceContainer;
			}
		}
		return maxRatioContainer;
	}

	public void addServiceExecutionContext(ServiceExecutionContext serviceExecutionContext) {
		this.serviceExecutionContextList.add(serviceExecutionContext);
	}

	public void countCalls() {
		
		for (ServiceExecutionContext serviceExecutionContext : this.serviceExecutionContextList) {
			List<AggregatedCommunication> senderCommunication = serviceExecutionContext.getSentAggregatedCommunications_ServiceExecutionContext();
			List<AggregatedCommunication> receiverCommunication = serviceExecutionContext.getReceivedAggregatedCommunication_AggregatedCommunication();
			countCallsOfCommunications(senderCommunication);
			countCallsOfCommunications(receiverCommunication);
		}
				
		for (ResourceContainerWithDoubleValue rcv : this.frequencyRemoteCalls) {
			ResourceContainerWithDoubleValue rcRatio = new ResourceContainerWithDoubleValue(rcv.getFirst(), new Double(rcv.getSecond() / (rcv.getSecond() + this.frequencyLocalCalls)));
			this.ratioRemoteCalls.add(rcRatio);
		}
		
		// TODO: nur für remote calls über den Link of interest!!
		// TODO: calculate overall local vs remote ratio? No, sort these objects by which pair of component / RC has the highest ratio. Or any? 
		
	}

	private void countCallsOfCommunications(List<AggregatedCommunication> senderCommunication) {
		for (AggregatedCommunication aggregatedCommunication : senderCommunication) {
			ResourceContainer receivingContainer = aggregatedCommunication.getReceiver_AggregatedCommunication().getAllocationContext_ServiceExecutionContext().getResourceContainer_AllocationContext();
			
			// must not access this.allocationContextOfComponent.getResourceContainer_AllocationContext() because the PCM instance may have been manipulated in the mean time. 
			//Check genome instead. If the component cannot be reallocated (no design decision for it, then we can abort anyway)
			if (!EMFHelper.checkIdentity(receivingContainer, this.allocationChoice.getChosenValue())){
				ResourceContainerWithDoubleValue remoteContainer = createOrReuseResourceContainerEntryInList(receivingContainer);
				remoteContainer.setSecond(remoteContainer.getSecond()+aggregatedCommunication.getAverageMessageFrequency());
			} else {
				this.frequencyLocalCalls += aggregatedCommunication.getAverageMessageFrequency();
			}
			
		}
	}

	private ResourceContainerWithDoubleValue createOrReuseResourceContainerEntryInList(
			ResourceContainer receivingContainer) {
		for (ResourceContainerWithDoubleValue resourceContainerEntry : this.frequencyRemoteCalls) {
			if (EMFHelper.checkIdentity(resourceContainerEntry.getFirst(), receivingContainer)){
				return resourceContainerEntry;
			}
		}
		ResourceContainerWithDoubleValue rcf = new ResourceContainerWithDoubleValue(receivingContainer, new Double(0));
		this.frequencyRemoteCalls.add(rcf);
		return rcf;
	}

	public List<AllocationServiceResult> getResult() {
		return allocationServiceResultList;
	}

	private AllocationDegree determineAllocationDoF() {
		List<DegreeOfFreedomInstance> dof = Opt4JStarter.getProblem().getDesignDecisions();
		for (DegreeOfFreedomInstance DegreeOfFreedomInstance : dof) {
			if (DegreeOfFreedomInstance instanceof AllocationDegree){
				AllocationDegree allocDof = (AllocationDegree)DegreeOfFreedomInstance;
				if (EMFHelper.checkIdentity(allocDof.getPrimaryChanged(), this.allocationContextOfComponent)){
					// this is the degree
					return allocDof;
				}
			}
		}
		return null;
	}
		
	private ClassChoice determineAllocationChoice(DSEIndividual individual) {
		for (Choice choice : individual.getGenotype()) {
			if (EcoreUtil.equals(choice.getDegreeOfFreedomInstance(), this.allocationDoF)){
				return (ClassChoice) choice;
			}
		}
		return null;
	}

	public void addAllocationServiceResult(AllocationServiceResult result){
		this.allocationServiceResultList.add(result);
	}
	
	@Override
	public boolean equals(Object o){
		if (o instanceof ComponentAndServiceResult){
			return EMFHelper.checkIdentity(this.allocationContextOfComponent,((ComponentAndServiceResult) o).getComponent());
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return this.allocationContextOfComponent.getId().hashCode();
		
	}
}

class ResourceContainerWithDoubleValue extends Pair<ResourceContainer, Double> {

	public ResourceContainerWithDoubleValue(ResourceContainer receivingContainer,
			Double double1) {
		super(receivingContainer, double1);
	}}