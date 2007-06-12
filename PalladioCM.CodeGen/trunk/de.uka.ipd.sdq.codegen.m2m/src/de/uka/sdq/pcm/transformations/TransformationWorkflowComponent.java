package de.uka.sdq.pcm.transformations;

import java.util.Collections;

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

public class TransformationWorkflowComponent 
	extends AbstractWorkflowComponent2 {

	System resource = null;
	Repository completionRepository = null;
	Allocation allocation = null;
	private boolean shouldProceed = true;
	private int counter = 0;
	
	@Override
	protected void checkConfigurationInternal(Issues arg0) {
	}

	@Override
	protected void invokeInternal(WorkflowContext context, ProgressMonitor monitor,
			Issues issues) {
		if (shouldProceed) {
			this.resource = (de.uka.ipd.sdq.pcm.system.System) context.get("pcmmodel");
			this.allocation = (Allocation)context.get("allocation");
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
		BasicComponent bc = createBasicComponent(completion);
		AllocationContext callingComponentAllocContext = findCallingComponentAllocationContext(con.getRequiringChildComponentContext_CompositeAssemblyConnector());
		AllocationContext newContext = AllocationFactory.eINSTANCE.createAllocationContext();
		
		AssemblyContext assCtx = CompositionFactory.eINSTANCE.createAssemblyContext();
		assCtx.setEncapsulatedComponent_ChildComponentContext(bc);
		completion.getChildComponentContexts_ComposedStructure().add(assCtx);

		newContext.setAssemblyContext_AllocationContext(assCtx);
		newContext.setResourceContainer_AllocationContext(callingComponentAllocContext.getResourceContainer_AllocationContext());
		allocation.getAllocationContexts_Allocation().add(newContext);
		
		ProvidedDelegationConnector delCon = CompositionFactory.eINSTANCE.createProvidedDelegationConnector();
		delCon.setChildComponentContext_ProvidedDelegationConnector(assCtx);
		delCon.setInnerProvidedRole_ProvidedDelegationConnector(bc.getProvidedRoles_InterfaceProvidingEntity().get(0));
		delCon.setOuterProvidedRole_ProvidedDelegationConnector(completion.getProvidedRoles_InterfaceProvidingEntity().get(0));
		
		RequiredDelegationConnector reqDelCon = CompositionFactory.eINSTANCE.createRequiredDelegationConnector();
		reqDelCon.setChildComponentContext_RequiredDelegationConnector(assCtx);
		reqDelCon.setInnerRequiredRole_RequiredDelegationConnector(bc.getRequiredRoles_InterfaceRequiringEntity().get(0));
		reqDelCon.setOuterRequiredRole_RequiredDelegationConnector(completion.getRequiredRoles_InterfaceRequiringEntity().get(0));
		
		completion.getRequiredDelegationConnectors_ComposedStructure().add(reqDelCon);
		completion.getProvidedDelegationConnectors_ComposedStructure().add(delCon);
	}

	private AllocationContext findCallingComponentAllocationContext(
			AssemblyContext requiringChildComponentContext_CompositeAssemblyConnector) {
		for(AllocationContext context : allocation.getAllocationContexts_Allocation()) {
			if (requiringChildComponentContext_CompositeAssemblyConnector.getId().equals(
					context.getAssemblyContext_AllocationContext()))
				return context;
		}
		return null;
	}

	private BasicComponent createBasicComponent(Completion completion) {
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

	private ProcessingResourceType findCPUResourceType() {
		ResourceSet set = allocation.eResource().getResourceSet();
		for (Resource r : set.getResources()) {
			if (r.getContents().get(0) instanceof ResourceRepository) {
				ResourceRepository resRep = (ResourceRepository) r.getContents().get(0);
				for (ResourceType rt : resRep.getAvailableResourceTypes_ResourceRepository())
				{
					if (rt.getEntityName().toLowerCase().equals("cpu"))
						return (ProcessingResourceType)rt;
				}
			}
		}
		return null;
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
