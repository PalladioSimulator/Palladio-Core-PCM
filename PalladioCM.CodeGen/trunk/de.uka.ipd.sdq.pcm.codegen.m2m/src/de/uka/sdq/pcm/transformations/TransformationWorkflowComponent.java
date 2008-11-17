package de.uka.sdq.pcm.transformations;

import org.openarchitectureware.workflow.WorkflowContext;
import org.openarchitectureware.workflow.issues.Issues;
import org.openarchitectureware.workflow.lib.AbstractWorkflowComponent2;
import org.openarchitectureware.workflow.monitor.ProgressMonitor;

import de.uka.ipd.sdq.featureconfig.Configuration;
import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.allocation.AllocationFactory;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.CompositionFactory;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository;
import de.uka.sdq.pcm.transformations.builder.connectors.ConnectorReplacingBuilder;
import de.uka.sdq.pcm.transformations.builder.util.PCMAndCompletionModelHolder;

public class TransformationWorkflowComponent 
	extends AbstractWorkflowComponent2 {

	private boolean respectLinkingResources = false;
	private PCMAndCompletionModelHolder models;
	private Configuration featureConfiguration;
		
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
		
		featureConfiguration = (Configuration) context.get("featureConfig");
		
		new AllInstancesTransformer<ResourceContainer>(
				ResourceenvironmentPackage.eINSTANCE.getResourceContainer(),
				models.getAllocation().getTargetResourceEnvironment_Allocation()) {

					@Override
					protected void transform(ResourceContainer object) {
						addMiddleware(object);
					}
			
		}.transform(issues);
		
		new AllInstancesTransformer<AssemblyConnector>(
				CompositionPackage.eINSTANCE.getAssemblyConnector(),
				models.getSystem()) {

					@Override
					protected void transform(AssemblyConnector connector) {
						if ( respectLinkingResources ) {
							ConnectorReplacingBuilder replacer = new ConnectorReplacingBuilder(models,connector,featureConfiguration.getDefaultConfig());
							replacer.build();
						}
					}
			
		}.transform(issues);
	}

	/**
	 * Creates a middleware component instance and allocates it to the given resource container
	 */
	private void addMiddleware(ResourceContainer resContainer) {
		AssemblyContext ctx = CompositionFactory.eINSTANCE.createAssemblyContext();
		ctx.setEntityName("AssCtx Middleware "+resContainer.getEntityName());
		ctx.setEncapsulatedComponent_AssemblyContext(models.getMiddlewareRepository().getComponents__Repository().get(0)); // TODO: Parameterise me!
		models.getSystem().getAssemblyContexts_ComposedStructure().add(ctx);
		
		models.getSystem().getAssemblyContexts_ComposedStructure().add(ctx);
		AllocationContext allocCtx = AllocationFactory.eINSTANCE.createAllocationContext();
		allocCtx.setEntityName("AllocCtx Middleware "+resContainer.getEntityName());
		allocCtx.setAssemblyContext_AllocationContext(ctx);
		allocCtx.setResourceContainer_AllocationContext(resContainer);
		models.getAllocation().getAllocationContexts_Allocation().add(allocCtx);
	}
}
