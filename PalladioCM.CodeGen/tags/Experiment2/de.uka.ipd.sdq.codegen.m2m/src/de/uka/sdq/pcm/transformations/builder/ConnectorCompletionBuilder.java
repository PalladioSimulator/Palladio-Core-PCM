package de.uka.sdq.pcm.transformations.builder;

import java.util.ArrayList;

import de.uka.ipd.sdq.completions.Completion;
import de.uka.ipd.sdq.completions.CompletionsFactory;
import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector;
import de.uka.ipd.sdq.pcm.core.composition.CompositionFactory;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;

public class ConnectorCompletionBuilder {
	
	private static int counter = 0;
	private Completion completion;
	private ArrayList<BasicComponentBuilder> basicComponents = new ArrayList<BasicComponentBuilder>();
	
	public ConnectorCompletionBuilder(Repository completionRepository, AssemblyConnector connector) {
		this.completion = createCompletionFor(connector);
		completionRepository.getComponents__Repository().add(completion);
	}
	
	public BasicComponentBuilder addBasicComponentToChain(ResourceContainer container, Allocation allocation) {
		BasicComponentBuilder builder = new BasicComponentBuilder(this.completion, container, allocation);
		basicComponents.add(builder);
		return builder;
	}
	
	private Completion createCompletionFor(AssemblyConnector con) {
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
	
	public void build () {
		BasicComponentBuilder lastBuilder = basicComponents.get(0);
		lastBuilder.build();
		
		ProvidedDelegationConnector delCon = CompositionFactory.eINSTANCE.createProvidedDelegationConnector();
		delCon.setChildComponentContext_ProvidedDelegationConnector(lastBuilder.getAssemblyContext());
		delCon.setInnerProvidedRole_ProvidedDelegationConnector(lastBuilder.getProvidedRole());
		delCon.setOuterProvidedRole_ProvidedDelegationConnector(completion.getProvidedRoles_InterfaceProvidingEntity().get(0));

		for (int i=1; i<basicComponents.size(); i++) {
			BasicComponentBuilder currentBuilder = basicComponents.get(i);
			currentBuilder.build();
			
			AssemblyConnector acon = CompositionFactory.eINSTANCE.createAssemblyConnector();
			acon.setParentStructure_AssemblyConnector(completion);
			acon.setRequiredRole_CompositeAssemblyConnector(lastBuilder.getRequiredRole());
			acon.setRequiringChildComponentContext_CompositeAssemblyConnector(lastBuilder.getAssemblyContext());
			acon.setProvidedRole_CompositeAssemblyConnector(currentBuilder.getProvidedRole());
			acon.setProvidingChildComponentContext_CompositeAssemblyConnector(currentBuilder.getAssemblyContext());
			lastBuilder = currentBuilder;
		}

		RequiredDelegationConnector reqDelCon = CompositionFactory.eINSTANCE.createRequiredDelegationConnector();
		reqDelCon.setChildComponentContext_RequiredDelegationConnector(lastBuilder.getAssemblyContext());
		reqDelCon.setInnerRequiredRole_RequiredDelegationConnector(lastBuilder.getRequiredRole());
		reqDelCon.setOuterRequiredRole_RequiredDelegationConnector(completion.getRequiredRoles_InterfaceRequiringEntity().get(0));
		
		completion.getRequiredDelegationConnectors_ComposedStructure().add(reqDelCon);
		completion.getProvidedDelegationConnectors_ComposedStructure().add(delCon);
	}

	public Completion getCompletion() {
		return this.completion;
	}

	public boolean hasComponents() {
		return !this.basicComponents.isEmpty();
	}
}
