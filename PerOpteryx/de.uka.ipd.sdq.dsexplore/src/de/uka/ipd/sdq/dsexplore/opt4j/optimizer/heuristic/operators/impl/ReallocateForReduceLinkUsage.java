package de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.opt4j.core.Objective;
import org.opt4j.core.problem.Genotype;
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
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividualBuilder;
import de.uka.ipd.sdq.dsexplore.opt4j.start.Opt4JStarter;
import de.uka.ipd.sdq.dsexplore.qml.handling.QMLConstantsContainer;
import de.uka.ipd.sdq.dsexplore.qml.reader.QMLDimensionReader;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.designdecision.AllocationDegree;
import de.uka.ipd.sdq.pcm.designdecision.Choice;
import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedom;
import de.uka.ipd.sdq.pcm.designdecision.EnumerationChoice;
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
			DSEIndividualBuilder individualBuilder,
			DSEWorkflowConfiguration configuration) {
		super(copy, individualBuilder, configuration, new String[] {QMLConstantsContainer.QUALITY_ATTRIBUTE_DIMENSION_RESPONSETIME_DEFINITION_PATH});
		
		//setHeuristicWeight(configuration.getReallocationForLinkWeight());
		//thresholdUtilisation = configuration.getReallocationForLinkUtilisationThreshold();
		
		try {
			Collection<Objective> objectives = Opt4JStarter.getDSEEvaluator()
					.getObjectives();
			for (Objective objective : objectives) {
				//XXX: Read the dimension name from definition rather than the constants container
				if (objective.getName().contains(
						new QMLDimensionReader().getDimension(QMLConstantsContainer.QUALITY_ATTRIBUTE_DIMENSION_RESPONSETIME_DEFINITION_PATH).getEntityName())) {
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
			List<ResourceContainer> connectedContainers = linkWithHighestUtil.getLinkingResource_LinkingResourceResults().getConnectedResourceContainers_LinkingResource();

			if (linkWithHighestUtil.getResourceUtilisation() > thresholdUtilisation){

				// group service results by component 
				List<ServiceResult> serviceResultList = resultRepo.getServiceResult_ResultDecoratorRepository();
				List<ComponentAndServiceResult> componentsAndServices = new ArrayList<ComponentAndServiceResult>();
				for (ServiceResult serviceResult : serviceResultList) {
					if (serviceResult instanceof AllocationServiceResult){

						AllocationServiceResult allocServiveResult = (AllocationServiceResult)serviceResult;
						AllocationContext component = allocServiveResult.getAllocationContext_AllocationServiceResult();

						ComponentAndServiceResult compReslt = null;
						for (ComponentAndServiceResult componentAndServiceResult : componentsAndServices) {
							if (componentAndServiceResult.getComponent().getId().equals(component.getId())){
								compReslt = componentAndServiceResult;
								break;
							}
						}
						if (compReslt == null){ 
							compReslt = new ComponentAndServiceResult(component);
						} 
						compReslt.addServiceResult(allocServiveResult);
					} else {
						logger.error("An unknown type of service results has been encountered, expected "+AllocationServiceResult.class.getName()+" only. Encountered type is "+serviceResult.getClass().getName());
					}
				}

				// group service dependency solver results by component
				// results for the services
				ComputedAggregatedUsage computedUsage = individual.getObjectives().getComputedAggregatedUsageFor(this.performance);
				List<ServiceExecutionContext> serviceContexts = computedUsage.getServiceExecutionContexts_ComputedAggregatedUsage();
				for (ServiceExecutionContext serviceExecutionContext : serviceContexts) {
					AllocationContext component = serviceExecutionContext.getAllocationContext_ServiceExecutionContext();

					ComponentAndServiceResult compReslt = null;
					for (ComponentAndServiceResult componentAndServiceResult : componentsAndServices) {
						if (componentAndServiceResult.getComponent().getId().equals(component.getId())){
							compReslt = componentAndServiceResult;
							break;
						}
					}
					if (compReslt == null){ 
						compReslt = new ComponentAndServiceResult(component);
					} 
					compReslt.addServiceResult(serviceExecutionContext);
				}

				for (ComponentAndServiceResult componentAndServiceResult : componentsAndServices) {
					componentAndServiceResult.countCalls();
				}

				Pair<ComponentAndServiceResult, ResourceContainerWithDoubleValue> componentWithTargetContainer = 
					getComponentWithHighestRatioToOneOfContainers(componentsAndServices, connectedContainers);

				return createCandidate(componentWithTargetContainer, individual);
			}
		}
		return Collections.emptyList();
	}

	private List<TacticsResultCandidate> createCandidate(
			Pair<ComponentAndServiceResult, ResourceContainerWithDoubleValue> componentWithTargetContainer, 
			DSEIndividual individual) {
		if (componentWithTargetContainer == null 
				|| componentWithTargetContainer.getFirst()  == null 
				|| componentWithTargetContainer.getSecond() == null){
			return Collections.emptyList();
		}
		
		List<TacticsResultCandidate> result = new ArrayList<TacticsResultCandidate>(1);
		
		TacticsResultCandidate candidate = individualBuilder.buildCandidate(copy.copy(individual.getGenotype()), individual, this, "");
		// find choice for the reallocated components degree
		for (Choice choice : candidate.getGenotype()) {
			if (choice instanceof EnumerationChoice 
					&& choice.getDegreeOfFreedom().equals(
							componentWithTargetContainer.getFirst().getAllocationDegree())){
				((EnumerationChoice)choice).setEntity(componentWithTargetContainer.getSecond().getFirst());
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
			ResourceContainerWithDoubleValue maxContainerOfComponent = componentResult.getMostPromisingContainerToReallocateTo(connectedContainers);
			if (componentWithTargetContainer == null 
					|| ( maxContainerOfComponent != null 
							&& maxContainerOfComponent.getSecond() > componentWithTargetContainer.getSecond().getSecond())){
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
	private List<AllocationServiceResult> serviceResultList;
	private List<ServiceExecutionContext> serviceExecutionContextList;
	
	private double frequencyLocalCalls = 0;
	
	private List<ResourceContainerWithDoubleValue> frequencyRemoteCalls = new ArrayList<ResourceContainerWithDoubleValue>();
	private List<ResourceContainerWithDoubleValue> ratioRemoteCalls = new ArrayList<ResourceContainerWithDoubleValue>();
	private AllocationDegree allocationDoF;
	
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
		filteredCandidateContainers.retainAll(this.allocationDoF.getDomainOfEntities());
		
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

	public void addServiceResult(ServiceExecutionContext serviceExecutionContext) {
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
			ResourceContainerWithDoubleValue rcRatio = new ResourceContainerWithDoubleValue(rcv.getFirst(), new Double(rcv.getSecond() / rcv.getSecond() + this.frequencyLocalCalls));
			this.ratioRemoteCalls.add(rcRatio);
		}
		
		// TODO: nur für remote calls über den Link of interest!!
		// TODO: calculate overall local vs remote ratio? No, sort these objects by which pair of component / RC has the highest ratio. Or any? 
		
	}

	private void countCallsOfCommunications(List<AggregatedCommunication> senderCommunication) {
		for (AggregatedCommunication aggregatedCommunication : senderCommunication) {
			ResourceContainer receivingContainer = aggregatedCommunication.getReceiver_AggregatedCommunication().getAllocationContext_ServiceExecutionContext().getResourceContainer_AllocationContext();
			
			if (receivingContainer != null){
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
			if (resourceContainerEntry.getFirst().getId().equals(receivingContainer.getId())){
				return resourceContainerEntry;
			}
		}
		ResourceContainerWithDoubleValue rcf = new ResourceContainerWithDoubleValue(receivingContainer, new Double(0));
		this.frequencyRemoteCalls.add(rcf);
		return rcf;
	}

	public List<AllocationServiceResult> getResult() {
		return serviceResultList;
	}

	public ComponentAndServiceResult(AllocationContext component) {
		super();
		this.allocationContextOfComponent = component;
		this.serviceResultList = new ArrayList<AllocationServiceResult>();
		
		this.allocationDoF = determineAllocationChoice(); 
	}
	
	private AllocationDegree determineAllocationChoice() {
		List<DegreeOfFreedom> dof = Opt4JStarter.getProblem().getDesignDecisions();
		for (DegreeOfFreedom degreeOfFreedom : dof) {
			if (degreeOfFreedom instanceof AllocationDegree){
				AllocationDegree allocDof = (AllocationDegree)degreeOfFreedom;
				if (allocDof.getChangeableEntity().getId().equals(this.allocationContextOfComponent.getId())){
					// this is the degree
					return allocDof;
				}
			}
		}
		return null;
	}

	public void addServiceResult(AllocationServiceResult result){
		this.serviceResultList.add(result);
	}
	
	@Override
	public boolean equals(Object o){
		if (o instanceof ComponentAndServiceResult){
			return this.allocationContextOfComponent.getId().equals(((ComponentAndServiceResult) o).getComponent().getId());
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