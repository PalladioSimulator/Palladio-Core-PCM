package de.uka.sdq.pcm.transformations;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
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
import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.CompositionFactory;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentFactory;
import de.uka.ipd.sdq.pcm.resourcetype.CommunicationLinkResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceType;
import de.uka.ipd.sdq.pcm.system.System;
import de.uka.sdq.pcm.transformations.BytesizeComputationForSignature.Modifier;
import de.uka.sdq.pcm.transformations.builder.BasicComponentBuilder;
import de.uka.sdq.pcm.transformations.builder.ConnectorCompletionBuilder;
import de.uka.sdq.pcm.transformations.builder.SeffBuilder;

public class TransformationWorkflowComponent 
	extends AbstractWorkflowComponent2 {

	System resource = null;
	Repository completionRepository = null;
	Allocation allocation = null;
	private boolean shouldProceed = true;
	private int counter = 0;
	private ResourceRepository resourceType;
	private boolean shouldCreateBrokerLookup = false;
	
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

		ConnectorCompletionBuilder builder = configureCompletion(con);
		if (builder.hasComponents()){
			builder.build();
			embedCompletionIntoSystem(con, builder.getCompletion());
		}
	}

	private ConnectorCompletionBuilder configureCompletion(AssemblyConnector con) {
		ConnectorCompletionBuilder completionBuilder = new ConnectorCompletionBuilder(completionRepository, con);

		if ( shouldCreateBrokerLookup ) {
			BasicComponentBuilder componentBuilder = completionBuilder.addBasicComponentToChain(
					findCallingComponentResourceContainer(con.getRequiringChildComponentContext_CompositeAssemblyConnector()),
					this.allocation);
			SeffBuilder seffBuilder = componentBuilder.getSeffBuilder();
			seffBuilder.appendPreInternalAction(findCPUResourceType(), "1000");
		}
		
		LinkingResource linkingRes = findLinkingResource(con);
		if (linkingRes != null) {
			ResourceContainer dummyContainer = ResourceenvironmentFactory.eINSTANCE.createResourceContainer();
			dummyContainer.setId(linkingRes.getId());
	
			BasicComponentBuilder linkingResourceControllerBuilder = completionBuilder.addBasicComponentToChain(
					dummyContainer,
					this.allocation);
			SeffBuilder seffBuilder = linkingResourceControllerBuilder.getSeffBuilder();
			seffBuilder.appendPreInternalAction(new ISignatureDependentDemand(){
				public String getDemand(Signature signature) {
					return BytesizeComputationForSignature.getBytesizeForSignature(signature,Modifier.IN);
				}
	
				public ProcessingResourceType getType() {
					return findNETResourceType();
				}
			});
			seffBuilder.appendPreInternalAction(new ISignatureDependentDemand(){
				public String getDemand(Signature signature) {
					return BytesizeComputationForSignature.getBytesizeForSignature(signature,Modifier.OUT);
				}
	
				public ProcessingResourceType getType() {
					return findNETResourceType();
				}
			});
		}
		return completionBuilder;
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

	private ResourceContainer findCallingComponentResourceContainer(
			AssemblyContext requiringChildComponentContext_CompositeAssemblyConnector) {
		for(AllocationContext context : allocation.getAllocationContexts_Allocation()) {
			if (requiringChildComponentContext_CompositeAssemblyConnector.getId().equals(
					context.getAssemblyContext_AllocationContext().getId()))
				return context.getResourceContainer_AllocationContext();
		}
		throw new RuntimeException("Component Allocation Context not found");
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

}
