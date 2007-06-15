package de.uka.sdq.pcm.transformations;

import java.util.Collections;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.query.ocl.conditions.BooleanOCLCondition;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.SET;
import org.eclipse.emf.query.statements.UPDATE;
import org.eclipse.emf.query.statements.WHERE;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.ParserException;
import org.openarchitectureware.workflow.WorkflowContext;
import org.openarchitectureware.workflow.issues.Issues;
import org.openarchitectureware.workflow.lib.AbstractWorkflowComponent2;
import org.openarchitectureware.workflow.monitor.ProgressMonitor;

import de.uka.ipd.sdq.completions.Completion;
import de.uka.ipd.sdq.completions.CompletionsFactory;
import de.uka.ipd.sdq.completions.CompletionsPackage;
import de.uka.ipd.sdq.completions.DelegatingExternalCallAction;
import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.allocation.AllocationFactory;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionFactory;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentFactory;
import de.uka.ipd.sdq.pcm.resourcetype.CommunicationLinkResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceType;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SeffFactory;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.seff.StopAction;
import de.uka.ipd.sdq.pcm.system.System;
import de.uka.sdq.pcm.transformations.BytesizeComputationForSignature.Modifier;

public class TransformationWorkflowComponent 
	extends AbstractWorkflowComponent2 {

	System resource = null;
	Repository completionRepository = null;
	Allocation allocation = null;
	private boolean shouldProceed = true;
	private int counter = 0;
	private ResourceRepository resourceType;
	
	@Override
	protected void checkConfigurationInternal(Issues arg0) {
	}

	@Override
	protected void invokeInternal(WorkflowContext context, ProgressMonitor monitor,
			Issues issues) {
		if (shouldProceed) {
			this.resource = (de.uka.ipd.sdq.pcm.system.System) context.get("pcmmodel");
			this.allocation = (Allocation)context.get("allocation");
			this.resourceType = (ResourceRepository)context.get("resourceType");
			completionRepository = RepositoryFactory.eINSTANCE.createRepository();
			completionRepository.setEntityName("CompletionsRepository");
			performTransformation(issues);
			context.set("completionRepository",completionRepository);
		}
	}

	@SuppressWarnings("unchecked")
	private void performTransformation(Issues issues) {
		OCL ocl = org.eclipse.ocl.ecore.OCL.newInstance();

		try {
			new UPDATE(
				    new FROM(resource),
				    new WHERE(new BooleanOCLCondition<EClassifier, EClass, EObject>(
				    	ocl.getEnvironment(),
				        "true",
				        CompositionPackage.eINSTANCE.getAssemblyConnector())),
				    new SET() {
				        public boolean set(EObject eObject) {
				        	transform(eObject);
							return true;
				        }}).execute();
		} catch (ParserException e) {
			issues.addError("Parser error on OCL: "+e.getMessage());
		}
	}

	protected void transform(EObject object) {
		AssemblyConnector con = (AssemblyConnector) object;
		java.lang.System.out.println("Expanding a completion for connector "+con.getEntityName());
		counter++;

		Completion completion = createCompletionFor(con,counter);
		completionRepository.getComponents__Repository().add(completion);
		embedCompletionIntoSystem(con, completion);
		
		configureCompletion(con, completion);
	}

	private void configureCompletion(AssemblyConnector con, Completion completion) {
		BasicComponent bc = createBrokerControllerBasicComponent(completion);
		BasicComponent bc2 = createLinkingResourceControllerBasicComponent(completion);
		AllocationContext callingComponentAllocContext = findCallingComponentAllocationContext(con.getRequiringChildComponentContext_CompositeAssemblyConnector());
		AllocationContext newAllocationContext = AllocationFactory.eINSTANCE.createAllocationContext();
		
		LinkingResource linkingRes = findLinkingResource(con);
		
		AssemblyContext assCtx = CompositionFactory.eINSTANCE.createAssemblyContext();
		assCtx.setEncapsulatedComponent_ChildComponentContext(bc);
		completion.getChildComponentContexts_ComposedStructure().add(assCtx);

		AssemblyContext assCtx2 = CompositionFactory.eINSTANCE.createAssemblyContext();
		assCtx2.setEntityName("LinkingResourceContext");
		assCtx2.setEncapsulatedComponent_ChildComponentContext(bc2);
		completion.getChildComponentContexts_ComposedStructure().add(assCtx2);
		AllocationContext newAllocationContext2 = AllocationFactory.eINSTANCE.createAllocationContext();
		newAllocationContext2.setAssemblyContext_AllocationContext(assCtx2);
		ResourceContainer dummyContainer = ResourceenvironmentFactory.eINSTANCE.createResourceContainer();
		dummyContainer.setId(linkingRes.getId());
		newAllocationContext2.setResourceContainer_AllocationContext(dummyContainer);
		allocation.getAllocationContexts_Allocation().add(newAllocationContext2);
		
		newAllocationContext.setAssemblyContext_AllocationContext(assCtx);
		newAllocationContext.setResourceContainer_AllocationContext(callingComponentAllocContext.getResourceContainer_AllocationContext());
		allocation.getAllocationContexts_Allocation().add(newAllocationContext);
		
		ProvidedDelegationConnector delCon = CompositionFactory.eINSTANCE.createProvidedDelegationConnector();
		delCon.setChildComponentContext_ProvidedDelegationConnector(assCtx);
		delCon.setInnerProvidedRole_ProvidedDelegationConnector(bc.getProvidedRoles_InterfaceProvidingEntity().get(0));
		delCon.setOuterProvidedRole_ProvidedDelegationConnector(completion.getProvidedRoles_InterfaceProvidingEntity().get(0));
		
		RequiredDelegationConnector reqDelCon = CompositionFactory.eINSTANCE.createRequiredDelegationConnector();
		reqDelCon.setChildComponentContext_RequiredDelegationConnector(assCtx2);
		reqDelCon.setInnerRequiredRole_RequiredDelegationConnector(bc2.getRequiredRoles_InterfaceRequiringEntity().get(0));
		reqDelCon.setOuterRequiredRole_RequiredDelegationConnector(completion.getRequiredRoles_InterfaceRequiringEntity().get(0));
		
		AssemblyConnector acon = CompositionFactory.eINSTANCE.createAssemblyConnector();
		acon.setParentStructure_AssemblyConnector(completion);
		acon.setRequiredRole_CompositeAssemblyConnector(bc.getRequiredRoles_InterfaceRequiringEntity().get(0));
		acon.setRequiringChildComponentContext_CompositeAssemblyConnector(assCtx);
		acon.setProvidedRole_CompositeAssemblyConnector(bc.getProvidedRoles_InterfaceProvidingEntity().get(0));
		acon.setProvidingChildComponentContext_CompositeAssemblyConnector(assCtx2);
		
		completion.getRequiredDelegationConnectors_ComposedStructure().add(reqDelCon);
		completion.getProvidedDelegationConnectors_ComposedStructure().add(delCon);
	}

	private LinkingResource findLinkingResource(AssemblyConnector con) {
		for (LinkingResource lr : this.allocation.getTargetResourceEnvironment_Allocation().getLinkingresource()){
			if (lr.getFromResourceContainer_LinkingResource().contains(findContainer(con.getRequiringChildComponentContext_CompositeAssemblyConnector())) &&
					lr.getToResourceContainer_LinkingResource().contains(findContainer(con.getProvidingChildComponentContext_CompositeAssemblyConnector())))
				return lr;
		}
		return null;
	}

	private ResourceContainer findContainer(
			AssemblyContext requiringChildComponentContext_CompositeAssemblyConnector) {
		for(AllocationContext ac : this.allocation.getAllocationContexts_Allocation()) {
			if (ac.getAssemblyContext_AllocationContext().getId().equals(requiringChildComponentContext_CompositeAssemblyConnector.getId()))
				return ac.getResourceContainer_AllocationContext();
		}
		return null;
	}

	private AllocationContext findCallingComponentAllocationContext(
			AssemblyContext requiringChildComponentContext_CompositeAssemblyConnector) {
		for(AllocationContext context : allocation.getAllocationContexts_Allocation()) {
			if (requiringChildComponentContext_CompositeAssemblyConnector.getId().equals(
					context.getAssemblyContext_AllocationContext().getId()))
				return context;
		}
		throw new RuntimeException("Component Allocation Context not found");
	}

	private BasicComponent createLinkingResourceControllerBasicComponent(Completion completion) {
		BasicComponent bc = RepositoryFactory.eINSTANCE.createBasicComponent();
		bc.setEntityName("CompletionComponentLinkingController"+counter); counter++;
		
		ProvidedRole provRole = RepositoryFactory.eINSTANCE.createProvidedRole();
		provRole.setProvidedInterface__ProvidedRole(completion.getProvidedRoles_InterfaceProvidingEntity().get(0).getProvidedInterface__ProvidedRole());
		bc.getProvidedRoles_InterfaceProvidingEntity().add(provRole);
		
		RequiredRole reqRole = RepositoryFactory.eINSTANCE.createRequiredRole();
		reqRole.setRequiredInterface__RequiredRole(completion.getRequiredRoles_InterfaceRequiringEntity().get(0).getRequiredInterface__RequiredRole());
		bc.getRequiredRoles_InterfaceRequiringEntity().add(reqRole);
		
		for (Signature providedService : bc.getProvidedRoles_InterfaceProvidingEntity().get(0).getProvidedInterface__ProvidedRole().getSignatures__Interface()){
			ResourceDemandingSEFF seff = createDelegatingLinkingResourceSEFF(providedService);
			bc.getServiceEffectSpecifications__BasicComponent().add(seff);
		}
		this.completionRepository.getComponents__Repository().add(bc);
		return bc;
	}
	
	private BasicComponent createBrokerControllerBasicComponent(Completion completion) {
		BasicComponent bc = RepositoryFactory.eINSTANCE.createBasicComponent();
		bc.setEntityName("CompletionComponent"+counter); counter++;
		
		ProvidedRole provRole = RepositoryFactory.eINSTANCE.createProvidedRole();
		provRole.setProvidedInterface__ProvidedRole(completion.getProvidedRoles_InterfaceProvidingEntity().get(0).getProvidedInterface__ProvidedRole());
		bc.getProvidedRoles_InterfaceProvidingEntity().add(provRole);
		
		RequiredRole reqRole = RepositoryFactory.eINSTANCE.createRequiredRole();
		reqRole.setRequiredInterface__RequiredRole(completion.getRequiredRoles_InterfaceRequiringEntity().get(0).getRequiredInterface__RequiredRole());
		bc.getRequiredRoles_InterfaceRequiringEntity().add(reqRole);
		
		for (Signature providedService : bc.getProvidedRoles_InterfaceProvidingEntity().get(0).getProvidedInterface__ProvidedRole().getSignatures__Interface()){
			ResourceDemandingSEFF seff = createDelegatingSEFF(providedService);
			bc.getServiceEffectSpecifications__BasicComponent().add(seff);
		}
		this.completionRepository.getComponents__Repository().add(bc);
		return bc;
	}

	private ResourceDemandingSEFF createDelegatingSEFF(Signature providedService) {
		ResourceDemandingSEFF seff = SeffFactory.eINSTANCE.createResourceDemandingSEFF();
		seff.setDescribedService__SEFF(providedService);
		StartAction start = SeffFactory.eINSTANCE.createStartAction();
		DelegatingExternalCallAction delegatingCall = CompletionsFactory.eINSTANCE.createDelegatingExternalCallAction();
		delegatingCall.setCalledService_ExternalService(providedService);
		
		InternalAction brokerCall = SeffFactory.eINSTANCE.createInternalAction();
		ParametricResourceDemand d = SeffFactory.eINSTANCE.createParametricResourceDemand();
		d.setRequiredResource_ParametricResourceDemand(findCPUResourceType());
		d.setSpecification("1000");
		d.setUnit("Workunits");
		brokerCall.getResourceDemand_Action().add(d);
		
		createControlFlow(start,brokerCall);
		createControlFlow(brokerCall, delegatingCall);
		StopAction stop = SeffFactory.eINSTANCE.createStopAction();
		createControlFlow(delegatingCall, stop);
		
		Collections.addAll(seff.getSteps_Behaviour(), start,stop,delegatingCall);
		
		return seff;
	}

	private ResourceDemandingSEFF createDelegatingLinkingResourceSEFF(Signature providedService) {
		ResourceDemandingSEFF seff = SeffFactory.eINSTANCE.createResourceDemandingSEFF();
		seff.setDescribedService__SEFF(providedService);
		StartAction start = SeffFactory.eINSTANCE.createStartAction();
		DelegatingExternalCallAction delegatingCall = CompletionsFactory.eINSTANCE.createDelegatingExternalCallAction();
		delegatingCall.setCalledService_ExternalService(providedService);
		
		InternalAction linkingResCall = SeffFactory.eINSTANCE.createInternalAction();
		ParametricResourceDemand d = SeffFactory.eINSTANCE.createParametricResourceDemand();
		d.setRequiredResource_ParametricResourceDemand(findNETResourceType());
		d.setSpecification(BytesizeComputationForSignature.getBytesizeForSignature(providedService, Modifier.IN));
		d.setUnit("bytes");
		linkingResCall.getResourceDemand_Action().add(d);
		
		createControlFlow(start,linkingResCall);
		createControlFlow(linkingResCall, delegatingCall);
		StopAction stop = SeffFactory.eINSTANCE.createStopAction();
		createControlFlow(delegatingCall, stop);
		
		Collections.addAll(seff.getSteps_Behaviour(), start,stop,delegatingCall);
		
		return seff;
	}

	
	private ProcessingResourceType findCPUResourceType() {
		for (ResourceType r : resourceType.getAvailableResourceTypes_ResourceRepository()) {
			if (r.getEntityName().toLowerCase().equals("cpu"))
				return (ProcessingResourceType)r;
		}
		throw new RuntimeException("Unable to find CPU resource type");
	}

	private CommunicationLinkResourceType findNETResourceType() {
		for (ResourceType r : resourceType.getAvailableResourceTypes_ResourceRepository()) {
			if (r.getEntityName().toLowerCase().equals("net"))
				return (CommunicationLinkResourceType)r;
		}
		throw new RuntimeException("Unable to find NET resource type");
	}
	
	private void createControlFlow(AbstractAction a,
			AbstractAction b) {
		a.setSuccessor_AbstractAction(b);
	}

	private void embedCompletionIntoSystem(AssemblyConnector con,
			Completion completion) {
		AssemblyContext completionContext = CompositionFactory.eINSTANCE.createAssemblyContext();
		completionContext.setEntityName("CompletionContext"+counter); counter++;
		completionContext.setEncapsulatedComponent_ChildComponentContext(completion);
		
		AssemblyConnector toCompletionConnector = CompositionFactory.eINSTANCE.createAssemblyConnector();
		AssemblyConnector fromCompletionConnector = CompositionFactory.eINSTANCE.createAssemblyConnector();
		
		toCompletionConnector.setRequiredRole_CompositeAssemblyConnector(con.getRequiredRole_CompositeAssemblyConnector());
		toCompletionConnector.setRequiringChildComponentContext_CompositeAssemblyConnector(con.getRequiringChildComponentContext_CompositeAssemblyConnector());
		toCompletionConnector.setProvidedRole_CompositeAssemblyConnector(completion.getProvidedRoles_InterfaceProvidingEntity().get(0));
		toCompletionConnector.setProvidingChildComponentContext_CompositeAssemblyConnector(completionContext);

		fromCompletionConnector.setRequiredRole_CompositeAssemblyConnector(completion.getRequiredRoles_InterfaceRequiringEntity().get(0));
		fromCompletionConnector.setRequiringChildComponentContext_CompositeAssemblyConnector(completionContext);
		fromCompletionConnector.setProvidedRole_CompositeAssemblyConnector(con.getProvidedRole_CompositeAssemblyConnector());
		fromCompletionConnector.setProvidingChildComponentContext_CompositeAssemblyConnector(con.getProvidingChildComponentContext_CompositeAssemblyConnector());
		
		this.resource.getChildComponentContexts_ComposedStructure().add(completionContext);
		this.resource.getCompositeAssemblyConnectors_ComposedStructure().add(toCompletionConnector);
		this.resource.getCompositeAssemblyConnectors_ComposedStructure().add(fromCompletionConnector);
		this.resource.getCompositeAssemblyConnectors_ComposedStructure().remove(con);
	}

	private Completion createCompletionFor(AssemblyConnector con, int counter) {
		Completion completion = CompletionsFactory.eINSTANCE.createCompletion();
		completion.setEntityName("ConnectorCompletion"+counter); counter++;

		ProvidedRole provRole = RepositoryFactory.eINSTANCE.createProvidedRole();
		provRole.setProvidedInterface__ProvidedRole(con.getRequiredRole_CompositeAssemblyConnector().getRequiredInterface__RequiredRole());
		completion.getProvidedRoles_InterfaceProvidingEntity().add(provRole);
		
		RequiredRole reqRole = RepositoryFactory.eINSTANCE.createRequiredRole();
		reqRole.setRequiredInterface__RequiredRole(con.getProvidedRole_CompositeAssemblyConnector().getProvidedInterface__ProvidedRole());
		completion.getRequiredRoles_InterfaceRequiringEntity().add(reqRole);
		return completion;
	}

}
