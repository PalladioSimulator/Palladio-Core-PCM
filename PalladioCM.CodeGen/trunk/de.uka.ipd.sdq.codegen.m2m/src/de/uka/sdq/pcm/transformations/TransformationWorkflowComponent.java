package de.uka.sdq.pcm.transformations;

import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.query.ocl.conditions.BooleanOCLCondition;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
import org.eclipse.ocl.OCL;
import org.openarchitectureware.workflow.WorkflowContext;
import org.openarchitectureware.workflow.issues.Issues;
import org.openarchitectureware.workflow.lib.AbstractWorkflowComponent2;
import org.openarchitectureware.workflow.monitor.ProgressMonitor;

import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.allocation.AllocationFactory;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.CompositionFactory;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository;
import de.uka.sdq.pcm.transformations.builder.IComponentBuilder;
import de.uka.sdq.pcm.transformations.builder.connectors.ConnectorReplacingBuilder;
import de.uka.sdq.pcm.transformations.builder.connectors.IClientServerConnectorCompletionComponentBuilder;
import de.uka.sdq.pcm.transformations.builder.connectors.InnerConnectorCompletionBuilder;
import de.uka.sdq.pcm.transformations.builder.resourceconsumer.NetworkLoadingComponentBuilder;
import de.uka.sdq.pcm.transformations.builder.util.PCMAndCompletionModelHolder;

public class TransformationWorkflowComponent 
	extends AbstractWorkflowComponent2 {

	private boolean respectLinkingResources = false;
	private PCMAndCompletionModelHolder models;
		
	public void setRespectLinkingResources(String value){
		if (value.equals("true")) {
			respectLinkingResources  = true;
		}
	}
	
	@Override
	protected void checkConfigurationInternal(Issues arg0) {
		// nothing to do here
	}

	@Override
	protected void invokeInternal(WorkflowContext context, ProgressMonitor monitor,
			Issues issues) {

		Repository completionRepository = RepositoryFactory.eINSTANCE.createRepository();
		context.set("completionRepository",completionRepository);
		completionRepository.setEntityName("CompletionsRepository");
		models = new PCMAndCompletionModelHolder(
				(ResourceRepository)context.get("resourceType"),
				null,
				(de.uka.ipd.sdq.pcm.system.System) context.get("pcmmodel"),
				(Allocation)context.get("allocation"),
				null,
				completionRepository,
				(Repository)context.get("middleware")
				);

		addMiddlewareToEachResourceContainer(issues);
		replaceConnectorsWithCompletions(issues);
	}

	@SuppressWarnings("unchecked")
	private void addMiddlewareToEachResourceContainer(final Issues issues) {
		OCL ocl = org.eclipse.ocl.ecore.OCL.newInstance();

		try {
			Set<EObject> result = new SELECT(
				    new FROM(models.getAllocation().getTargetResourceEnvironment_Allocation()),
				    new WHERE(new BooleanOCLCondition<EClassifier, EClass, EObject>(
				    	ocl.getEnvironment(),
				        "true",
				        ResourceenvironmentPackage.eINSTANCE.getResourceContainer()))).getEObjects();
			for(EObject eObject : result) {
        		addMiddleware((ResourceContainer)eObject);
			}
    	} catch (Exception ex) {
			issues.addError("Exception during M2M transformation: "+ex.getMessage());
    	}
	}
	
	/**
	 * Creates a middleware component instance and allocates it to the given resource container
	 */
	private void addMiddleware(ResourceContainer resContainer) {
		AssemblyContext ctx = CompositionFactory.eINSTANCE.createAssemblyContext();
		ctx.setEntityName("AssCtx Middleware "+resContainer.getEntityName());
		ctx.setEncapsulatedComponent_ChildComponentContext(models.getMiddlewareRepository().getComponents__Repository().get(0)); // TODO: Parameterise me!
		models.getSystem().getChildComponentContexts_ComposedStructure().add(ctx);
		
		models.getSystem().getChildComponentContexts_ComposedStructure().add(ctx);
		AllocationContext allocCtx = AllocationFactory.eINSTANCE.createAllocationContext();
		allocCtx.setEntityName("AllocCtx Middleware "+resContainer.getEntityName());
		allocCtx.setAssemblyContext_AllocationContext(ctx);
		allocCtx.setResourceContainer_AllocationContext(resContainer);
		models.getAllocation().getAllocationContexts_Allocation().add(allocCtx);
	}

	@SuppressWarnings("unchecked")
	private void replaceConnectorsWithCompletions(final Issues issues) {
		OCL ocl = org.eclipse.ocl.ecore.OCL.newInstance();

		try {
			Set<EObject> result = new SELECT(
				    new FROM(models.getSystem()),
				    new WHERE(new BooleanOCLCondition<EClassifier, EClass, EObject>(
				    	ocl.getEnvironment(),
				        "true",
				        CompositionPackage.eINSTANCE.getAssemblyConnector()))).getEObjects();
			for(EObject connector : result) {
        		transformConnector((AssemblyConnector) connector);
			}
    	} catch (Exception ex) {
			issues.addError("Exception during M2M transformation: "+ex.getMessage());
    	}
	}

	protected void transformConnector(AssemblyConnector connector) {
		if ( respectLinkingResources ) {
			LinkingResource linkingRes = findLinkingResource(connector);
			if (linkingRes != null) { // Is there a linking resource between the components?
				java.lang.System.out.println("Expanding a completion for connector "+connector.getEntityName());

				IComponentBuilder networkSimulator = new NetworkLoadingComponentBuilder(models, connector.getRequiredRole_CompositeAssemblyConnector().getRequiredInterface__RequiredRole(),linkingRes);
				IClientServerConnectorCompletionComponentBuilder builder = new InnerConnectorCompletionBuilder(models,connector,linkingRes,networkSimulator);
				ConnectorReplacingBuilder replacer = new ConnectorReplacingBuilder(connector,builder);
				replacer.build();

				// Only support point-to-point connections
				AllocationContext clientMWContext = findAllocationContext(linkingRes.getFromResourceContainer_LinkingResource().get(0),models.getMiddlewareRepository().getInterfaces__Repository().get(0));
				addAssemblyConnector(builder.getClientSideMiddlewareRole(), builder.getAssemblyContext(),
						clientMWContext.getAssemblyContext_AllocationContext().getEncapsulatedComponent_ChildComponentContext().getProvidedRoles_InterfaceProvidingEntity().get(0),
						clientMWContext.getAssemblyContext_AllocationContext());
				AllocationContext serverMWContext = findAllocationContext(linkingRes.getToResourceContainer_LinkingResource().get(0),models.getMiddlewareRepository().getInterfaces__Repository().get(0));
				addAssemblyConnector(builder.getServerSideMiddlewareRole(), builder.getAssemblyContext(),
						serverMWContext.getAssemblyContext_AllocationContext().getEncapsulatedComponent_ChildComponentContext().getProvidedRoles_InterfaceProvidingEntity().get(0),
						serverMWContext.getAssemblyContext_AllocationContext());
			}
		}
	}

	private AllocationContext findAllocationContext(
			ResourceContainer resourceContainer, Interface interfaceToSearch) {
		for (AllocationContext context : models.getAllocation().getAllocationContexts_Allocation())
			if (context.getResourceContainer_AllocationContext() == resourceContainer && 
				context.getAssemblyContext_AllocationContext().getEncapsulatedComponent_ChildComponentContext().getProvidedRoles_InterfaceProvidingEntity().get(0).getProvidedInterface__ProvidedRole() == interfaceToSearch)
				return context;
		throw new RuntimeException("Model invalid, unable to find middleware component for resource container "+resourceContainer.getEntityName());
	}	
	
	protected void addAssemblyConnector(RequiredRole from, AssemblyContext fromContext, ProvidedRole to, AssemblyContext toContext){
		AssemblyConnector acon = CompositionFactory.eINSTANCE.createAssemblyConnector();
		acon.setParentStructure_AssemblyConnector(models.getSystem());
		acon.setRequiredRole_CompositeAssemblyConnector(from);
		acon.setRequiringChildComponentContext_CompositeAssemblyConnector(fromContext);
		acon.setProvidedRole_CompositeAssemblyConnector(to);
		acon.setProvidingChildComponentContext_CompositeAssemblyConnector(toContext);
	}

	private LinkingResource findLinkingResource(AssemblyConnector con) {
		for (LinkingResource lr : models.getAllocation().getTargetResourceEnvironment_Allocation().getLinkingresource()){
			if (lr.getFromResourceContainer_LinkingResource().contains(findContainer(con.getRequiringChildComponentContext_CompositeAssemblyConnector())) &&
					lr.getToResourceContainer_LinkingResource().contains(findContainer(con.getProvidingChildComponentContext_CompositeAssemblyConnector())))
				return lr;
		}
		if (findContainer(con.getRequiringChildComponentContext_CompositeAssemblyConnector()) != findContainer(con.getProvidingChildComponentContext_CompositeAssemblyConnector()))
			throw new RuntimeException("AssemblyConnector "+con.getEntityName()+" links different ResourceContainer, but there is no linking resource between the containers!");
		return null;
	}

	private ResourceContainer findContainer(
			AssemblyContext requiringChildComponentContext_CompositeAssemblyConnector) {
		for(AllocationContext ac : this.models.getAllocation().getAllocationContexts_Allocation()) {
			if (ac.getAssemblyContext_AllocationContext().getId().equals(requiringChildComponentContext_CompositeAssemblyConnector.getId()))
				return ac.getResourceContainer_AllocationContext();
		}
		return null;
	}

}
