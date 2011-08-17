package de.uka.ipd.sdq.pcmsolver.visitors;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedCommunication;
import de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedResourceDemand;
import de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedUsageContextFactory;
import de.uka.ipd.sdq.context.aggregatedUsageContext.ComputedAggregatedUsage;
import de.uka.ipd.sdq.context.aggregatedUsageContext.ServiceExecutionContext;
import de.uka.ipd.sdq.context.computed_usage.BranchProbability;
import de.uka.ipd.sdq.context.computed_usage.LoopIteration;
import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.repository.CompositeComponent;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceType;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition;
import de.uka.ipd.sdq.pcm.seff.AbstractLoopAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.usagemodel.BranchTransition;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcmsolver.handler.AggregatedContextExternalCallActionHandler;
import de.uka.ipd.sdq.pcmsolver.handler.ExternalCallActionHandler;
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;
import de.uka.ipd.sdq.stoex.Expression;

/**
 * Visitor that builds up the context model including the aggregated usage context. 
 * Extends the {@link SeffVisitor} and adds the calculation of execution frequencies. 
 * Uses the {@link AggregatedContextExternalCallActionHandler} instead of the {@link ExternalCallActionHandler}.
 * @author martens
 *
 */
public class AggregatedContextSEFFVisitor extends SeffVisitor {

	private double currentFrequency;
	private ServiceExecutionContext computedAggregatedUsage;
	private UsageScenario usageScenario;
	
	public AggregatedContextSEFFVisitor(ContextWrapper ctxWrp, double frequency, ServiceEffectSpecification seff, UsageScenario currentScenario) {
		super(ctxWrp);
		this.currentFrequency = frequency;
		this.usageScenario = currentScenario;
		
		if (seff instanceof ResourceDemandingSEFF){
				ResourceDemandingSEFF rdSEFF = (ResourceDemandingSEFF)seff;
			//AssemblyContext assemblyContext = ctxWrp.getAssCtx();
			AllocationContext allocationContext = ctxWrp.getAllCtx();
			ctxWrp.getAllCtx();
			//check if context is already there for this system. If yes, use it
			this.computedAggregatedUsage = createOrReuseExecutionContext(rdSEFF, allocationContext, this.usageScenario, this.currentFrequency);
		}
		

		
	}

	/**
	 * Extends {@link SeffVisitor#caseResourceDemandingSEFF(ResourceDemandingSEFF)}: stores the described SEFF
	 * in the {@link ComputedAggregatedUsage}. 
	 * Then calls {@link SeffVisitor#caseResourceDemandingSEFF(ResourceDemandingSEFF)}. 
	 * 
	 * {@inheritDoc}.
	 */
	@Override
	public Object caseResourceDemandingSEFF(ResourceDemandingSEFF seff) {
		this.computedAggregatedUsage.setDescribedSEFF_ServiceExecutionContext(seff);
		Object object = super.caseResourceDemandingSEFF(seff);
		
		return object;
	}

	/**
	 * Overwrites the {@link SeffVisitor#caseExternalCallAction(ExternalCallAction)}. 
	 * Does the same, but uses an {@link AggregatedContextExternalCallActionHandler} to handle the call, 
	 * which in turn will instantiate an {@link AggregatedContextSEFFVisitor} for the next SEFF. 
	 */
	@Override
	public Object caseExternalCallAction(ExternalCallAction call) {
		
		
		AggregatedContextExternalCallActionHandler extCallAH = new AggregatedContextExternalCallActionHandler(this, this.usageScenario);
		extCallAH.handle(call);
	
		ServiceEffectSpecification seff = extCallAH.getCalledSEFF();
		if (seff instanceof ResourceDemandingSEFF){
			ResourceDemandingSEFF rdSEFF = (ResourceDemandingSEFF)seff;
			
			//AssemblyContext assemblyContext = extCallAH.getCalledAssemblyCtxt();
			AllocationContext allocationContext = extCallAH.getCalledAllocationContext();
			
			//frequency will be set by the next seff visitor that visits that seff.
			ServiceExecutionContext calleeComputedAggregatedUsage = createOrReuseExecutionContext(rdSEFF, allocationContext, this.usageScenario, 0.0);
					
			//the new usage is a communication partner, add communication info. 
			AggregatedCommunication communication = createOrReuseAggregatedCommunication(this.computedAggregatedUsage, calleeComputedAggregatedUsage);
			
			double oldFrequency = communication.getAverageMessageFrequency();
			communication.setAverageMessageFrequency(oldFrequency + this.currentFrequency);
			
			// get link on which the message is sent
			CommunicationLinkResourceSpecification link = findCommunicationLink(this.computedAggregatedUsage, calleeComputedAggregatedUsage);
			
			//link is null if this is a local
			if (link != null){
				communication.setUsedCommunicationLinkResourceSpecification_AggregatedCommunication(link);
			}
			
			//TODO add message size
			//XXX consider return call? there always is a return call so far.
		}
		
		doSwitch(call.getSuccessor_AbstractAction());
		return call;
	}

	/**
	 * Returns null if communication is local. 
	 * @param callerComputedAggregatedUsage
	 * @param calleeComputedAggregatedUsage
	 * @return
	 */
	private CommunicationLinkResourceSpecification findCommunicationLink(
			ServiceExecutionContext callerComputedAggregatedUsage,
			ServiceExecutionContext calleeComputedAggregatedUsage) {
		
		//AssemblyContext assemblyFrom = callerComputedAggregatedUsage.getAssemblyContext_ServiceExecutionContext();
		//AssemblyContext assemblyTo = calleeComputedAggregatedUsage.getAssemblyContext_ServiceExecutionContext();
		AllocationContext to = calleeComputedAggregatedUsage.getAllocationContext_ServiceExecutionContext();
		
		AllocationContext from = this.contextWrapper.getAllCtx();
		
		Allocation allocation = this.contextWrapper.getPcmInstance().getAllocation();
		
		/*AllocationContext to = null;
		for (AllocationContext allocationContext : allocation.getAllocationContexts_Allocation()) {
			
			AssemblyContext currentAssemblyContext = allocationContext.getAssemblyContext_AllocationContext();
			// look inside assembled component to see whether the search assembly context assemblyTo in contained
			if (isOrContainsAssemblyContext(currentAssemblyContext, assemblyTo)){
				to = allocationContext;
			} 
			if (to != null)
				break;
		}*/
		
		if (to != null){
			
			ResourceContainer fromResourceContainer = from.getResourceContainer_AllocationContext();
			ResourceContainer toResourceContainer = to.getResourceContainer_AllocationContext();
			
			//local communication? then return null.
			if (fromResourceContainer == toResourceContainer)
				return null;
			
			List<LinkingResource> linkingResourceList = this.contextWrapper.getPcmInstance().getResourceEnvironment().getLinkingResources__ResourceEnvironment();
			for (LinkingResource linkingResource : linkingResourceList) {
				if (linkingResource.getConnectedResourceContainers_LinkingResource().contains(fromResourceContainer)
						&& linkingResource.getConnectedResourceContainers_LinkingResource().contains(toResourceContainer)){
					return linkingResource.getCommunicationLinkResourceSpecifications_LinkingResource();
				}
			}
			throw new RuntimeException("The communication between allocation contexts "+to.getEntityName()+" and "+from.getEntityName()+" is remote, but there is no linking resource between them. Add a linking resource.");
			
		}
		throw new RuntimeException(this.getClass().getName()+": Could not determine allocation of "+calleeComputedAggregatedUsage.getDescribedSEFF_ServiceExecutionContext().getDescribedService__SEFF().getEntityName()+" to determine communication partners.");
		
	}

	private boolean isOrContainsAssemblyContext(AssemblyContext currenAssemblyContext, AssemblyContext targetAssembly) {
		
		if (currenAssemblyContext == targetAssembly)
			return true;
		
		RepositoryComponent component = currenAssemblyContext.getEncapsulatedComponent__AssemblyContext();
		if (component instanceof CompositeComponent){
			CompositeComponent composite = (CompositeComponent)component;
			for (AssemblyContext containedAssemblyContext : composite.getAssemblyContexts__ComposedStructure()) {
				boolean contained = isOrContainsAssemblyContext(containedAssemblyContext, targetAssembly);
				if (contained)
					return true;
			}
		}
		return false;
	}

	/**
	 * Extends {@link SeffVisitor#caseInternalAction(InternalAction)}. Adds the calculation 
	 * of a mean resource demand weighted by frequency of execution. Adds this information to the  
	 * {@link AggregatedResourceDemand}. Then calls {@link SeffVisitor#caseInternalAction(InternalAction)}.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public Object caseInternalAction(InternalAction action) {
		// add all types of resource demands. 
		for (ParametricResourceDemand demand : action.getResourceDemand_Action()) {
			String specification = demand.getSpecification_ParametericResourceDemand().getSpecification();
			
			Expression solvedExpr = ExpressionHelper.getSolvedExpression(specification, this.contextWrapper);
						
			ResourceType resourceType = demand.getRequiredResource_ParametricResourceDemand();
			
			double meanDemand = ExpressionHelper.meanValue(solvedExpr);
			
			addToAggregatedUsage(resourceType, meanDemand);
			
		}
		
		//to get the successor right and also fill the computed allocation. 
		Object object = super.caseInternalAction(action);
		//Object object = action.getSuccessor_AbstractAction();
		return object;
	}



	/**
	 * Weight the demand by frequency and add it to the {@link AggregatedResourceDemand}.
	 * @param resourceType
	 * @param demand
	 */
	private void addToAggregatedUsage(ResourceType resourceType, double demand) {
		
		//weight by probability
		double weightedDemand = demand * this.currentFrequency;
		
		AggregatedResourceDemand resourceDemandForType = null;
		
		List<AggregatedResourceDemand> existingResourceDemands = this.computedAggregatedUsage.getAggregatedResourceDemands_ServiceExecutionContext();
		for (AggregatedResourceDemand aggregatedResourceDemand : existingResourceDemands) {
			if (aggregatedResourceDemand.getResourceType_AggregatedResourceDemand().equals(resourceType)){
				resourceDemandForType = aggregatedResourceDemand;
				break;
			}
		}
		
		if (resourceDemandForType == null){
			resourceDemandForType = AggregatedUsageContextFactory.eINSTANCE.createAggregatedResourceDemand();
			resourceDemandForType.setResourceType_AggregatedResourceDemand(resourceType);
			this.computedAggregatedUsage.getAggregatedResourceDemands_ServiceExecutionContext().add(resourceDemandForType);
		}
		
		double newAggregatedValue = resourceDemandForType.getAggregatedResourceDemand()+weightedDemand;
		resourceDemandForType.setAggregatedResourceDemand(newAggregatedValue);
		
	}

	/**
	 * Gets the frequency to execute this {@link ResourceDemandingBehaviour} by checking the container.
	 * If it is a {@link BranchTransition} or {@link AbstractLoopAction}, update the frequency before calling 
	 * {@link SeffVisitor#caseExternalCallAction(ExternalCallAction)}. Then resets the frequency for the next action or trasition.
	 * Then calls {@link SeffVisitor#caseResourceDemandingBehaviour(ResourceDemandingBehaviour)}.
	 * 
	 * {@inheritDoc}.
	 */
	@Override
	public Object caseResourceDemandingBehaviour(
			ResourceDemandingBehaviour behaviour) {
		
		
		// to avoid rounding errors, reset probability after the call. 
		double oldProbability = this.currentFrequency;
		
		
		//determine container type
		EObject container = behaviour.eContainer();
		
		if (container instanceof AbstractBranchTransition){
			AbstractBranchTransition branchTransition = (AbstractBranchTransition)container;
			
			double branchProb = -1;
			List<BranchProbability> branchProbabilities = this.contextWrapper.getCompUsgCtx().getBranchProbabilities_ComputedUsageContext();
			for (BranchProbability branchProbability : branchProbabilities) {
				if (branchTransition.equals(branchProbability.getBranchtransition_BranchProbability())){
					branchProb = branchProbability.getProbability();
					break;
				}
			}
			if (branchProb == -1){
				throw new RuntimeException("Internal error: Found no branch transition probability for branch "+branchTransition.getEntityName()+" "+branchTransition.getId());
			}
			this.currentFrequency = this.currentFrequency * branchProb;
			
		} else if (container instanceof AbstractLoopAction){
			AbstractLoopAction loop = (AbstractLoopAction)container;
			double avgLoopIterationNumber = -1; 
			List<LoopIteration> loopIterations = this.contextWrapper.getCompUsgCtx().getLoopiterations_ComputedUsageContext();
			for (LoopIteration loopIteration : loopIterations) {
				if (loop.equals(loopIteration.getLoopaction_LoopIteration())){
					avgLoopIterationNumber = ExpressionHelper.meanValue(ExpressionHelper.getSolvedExpression(loopIteration.getSpecification_LoopIteration().getSpecification(), this.contextWrapper));
				}
			}
			if (avgLoopIterationNumber == -1){
				throw new RuntimeException("Internal error: Found no branch transition probability for loop "+loop.getEntityName()+" "+loop.getId());
			}
			this.currentFrequency = this.currentFrequency * avgLoopIterationNumber;
		}
		
		Object result = super.caseResourceDemandingBehaviour(behaviour);
		
		this.currentFrequency = oldProbability;
		
		return result;
		 
	}

	/**
	 * Get the current frequency of this object. This is <i>not</i> equal to the frequency 
	 * of this {@link ServiceEffectSpecification}, because the current frequency 
	 * reflects the frequency of the currently handled {@link AbstractAction}.
	 */
	public double getCurrentFrequency() {
		return this.currentFrequency;
	}
	
	private ServiceExecutionContext createOrReuseExecutionContext(ResourceDemandingSEFF rdSEFF, AllocationContext allocationContext, UsageScenario usageScenario, double frequency){
		
		ServiceExecutionContext computedAggregatedUsage = null;
		
		List<ServiceExecutionContext> aggrUsageContext = this.contextWrapper.getPcmInstance().getComputedAggregatedUsage().getServiceExecutionContexts_ComputedAggregatedUsage();
		for (ServiceExecutionContext serviceExecutionContext : aggrUsageContext) {
			if (serviceExecutionContext.getDescribedSEFF_ServiceExecutionContext() == rdSEFF
					&& serviceExecutionContext.getAllocationContext_ServiceExecutionContext() == allocationContext
					&& serviceExecutionContext.getUsageScenario_ServiceExecutionContext() == usageScenario){
				computedAggregatedUsage = serviceExecutionContext;
				double oldFrequency = computedAggregatedUsage.getGlobalExecutionFrequency();
				computedAggregatedUsage.setGlobalExecutionFrequency(frequency+oldFrequency);
				break;
			}
		}
		
		//If no context is yet there for this seff in this assembly context, create a new one. 
		if (computedAggregatedUsage == null){
		
			computedAggregatedUsage = AggregatedUsageContextFactory.eINSTANCE.createServiceExecutionContext();
			computedAggregatedUsage.setGlobalExecutionFrequency(currentFrequency);

			computedAggregatedUsage.setAllocationContext_ServiceExecutionContext(allocationContext);
			computedAggregatedUsage.setUsageScenario_ServiceExecutionContext(this.usageScenario);
			computedAggregatedUsage.setDescribedSEFF_ServiceExecutionContext(rdSEFF);
		
			this.contextWrapper.getPcmInstance().getComputedAggregatedUsage().getServiceExecutionContexts_ComputedAggregatedUsage().add(computedAggregatedUsage);
		}
		
		return computedAggregatedUsage;
	}
	
	private AggregatedCommunication createOrReuseAggregatedCommunication(ServiceExecutionContext fromService, ServiceExecutionContext toService){
		
		AggregatedCommunication communication = null;
		
		List<AggregatedCommunication> communications = fromService.getSentAggregatedCommunications_ServiceExecutionContext();
		for (AggregatedCommunication aggregatedCommunication : communications) {
			if (aggregatedCommunication.getReceiver_AggregatedCommunication() == toService){
				communication = aggregatedCommunication;
				break;
			}
		}
		
		if (communication == null){
			communication = AggregatedUsageContextFactory.eINSTANCE.createAggregatedCommunication();
			communication.setReceiver_AggregatedCommunication(toService);
			communications.add(communication);
		}
		
		return communication;
		
	}
	
	

	
}
