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
import de.uka.ipd.sdq.completions.CompletionsFactory;
import de.uka.ipd.sdq.completions.CompletionsPackage;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.CompositionFactory;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SeffFactory;
import de.uka.ipd.sdq.pcm.system.System;

public class TransformationWorkflowComponent 
	extends AbstractWorkflowComponent2 {

	System resource = null;
	Repository completionRepository = null;
	private boolean shouldProceed = false;
	private static int counter = 0;
	
	@Override
	protected void checkConfigurationInternal(Issues arg0) {
	}

	@Override
	protected void invokeInternal(WorkflowContext context, ProgressMonitor monitor,
			Issues issues) {
		if (shouldProceed ) {
			this.resource = (de.uka.ipd.sdq.pcm.system.System) context.get("pcmmodel");
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
		
		configureCompletion(completion);
		
		embedCompletionIntoSystem(con, completion);
	}

	private void configureCompletion(Completion completion) {
		BasicComponent bc = RepositoryFactory.eINSTANCE.createBasicComponent();
		bc.getProvidedRoles_InterfaceProvidingEntity().add(completion.getProvidedRoles_InterfaceProvidingEntity().get(0));
		bc.getRequiredRoles_InterfaceRequiringEntity().add(completion.getRequiredRoles_InterfaceRequiringEntity().get(0));
		for (Signature providedService : bc.getProvidedRoles_InterfaceProvidingEntity().get(0).getProvidedInterface__ProvidedRole().getSignatures__Interface()){
			ResourceDemandingSEFF seff = createDelegatingSEFF(providedService);
			bc.getServiceEffectSpecifications__BasicComponent().add(seff);
		}
	}

	private ResourceDemandingSEFF createDelegatingSEFF(Signature providedService) {
		ResourceDemandingSEFF seff = SeffFactory.eINSTANCE.createResourceDemandingSEFF();
		seff.setDescribedService__SEFF(providedService);
		
		return seff;
	}

	private void embedCompletionIntoSystem(AssemblyConnector con,
			Completion completion) {
		AssemblyContext completionContext = CompositionFactory.eINSTANCE.createAssemblyContext();
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
		completion.setEntityName("ConnectorCompletion"+counter);

		ProvidedRole provRole = RepositoryFactory.eINSTANCE.createProvidedRole();
		provRole.setProvidedInterface__ProvidedRole(con.getRequiredRole_CompositeAssemblyConnector().getRequiredInterface__RequiredRole());
		completion.getProvidedRoles_InterfaceProvidingEntity().add(provRole);
		
		RequiredRole reqRole = RepositoryFactory.eINSTANCE.createRequiredRole();
		reqRole.setRequiredInterface__RequiredRole(con.getProvidedRole_CompositeAssemblyConnector().getProvidedInterface__ProvidedRole());
		completion.getRequiredRoles_InterfaceRequiringEntity().add(reqRole);
		return completion;
	}

}
