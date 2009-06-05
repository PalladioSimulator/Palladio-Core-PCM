package de.uka.sdq.pcm.transformations.builder;

import de.uka.ipd.sdq.completions.Completion;
import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.allocation.AllocationFactory;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.CompositionFactory;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;

public class BasicComponentBuilder {

	private static int counter = 0;
	private BasicComponent basicComponent;
	private SeffBuilder seffBuilder;
	private ResourceContainer container;
	private Completion completion;
	private Allocation allocation;
	private AssemblyContext myAssemblyContext;
	private AllocationContext myAllocationContext;
	
	public BasicComponentBuilder(Completion completion, ResourceContainer container, Allocation allocation) {
		this.container = container;
		this.completion = completion;
		this.allocation = allocation;
		this.seffBuilder = new SeffBuilder();
	}

	private BasicComponent createBasicComponent(Completion completion) {
		BasicComponent bc = RepositoryFactory.eINSTANCE.createBasicComponent();
		bc.setEntityName("InnerComponent"+counter); 
		counter++;
		
		ProvidedRole provRole = RepositoryFactory.eINSTANCE.createProvidedRole();
		provRole.setProvidedInterface__ProvidedRole(completion.getProvidedRoles_InterfaceProvidingEntity().get(0).getProvidedInterface__ProvidedRole());
		bc.getProvidedRoles_InterfaceProvidingEntity().add(provRole);
		
		RequiredRole reqRole = RepositoryFactory.eINSTANCE.createRequiredRole();
		reqRole.setRequiredInterface__RequiredRole(completion.getRequiredRoles_InterfaceRequiringEntity().get(0).getRequiredInterface__RequiredRole());
		bc.getRequiredRoles_InterfaceRequiringEntity().add(reqRole);

		completion.getRepository_ProvidesComponentType().getComponents__Repository().add(bc);
		return bc;
	}
	
	public SeffBuilder getSeffBuilder() {
		return seffBuilder;
	}
	
	public void build() {
		this.basicComponent = createBasicComponent(this.completion);
		this.seffBuilder.build(basicComponent);

		this.myAssemblyContext = CompositionFactory.eINSTANCE.createAssemblyContext();
		myAssemblyContext.setEntityName("AssemblyContext"+counter); counter++;
		myAssemblyContext.setEncapsulatedComponent_ChildComponentContext(this.basicComponent);
		this.completion.getChildComponentContexts_ComposedStructure().add(myAssemblyContext);

		this.myAllocationContext = AllocationFactory.eINSTANCE.createAllocationContext();
		myAllocationContext.setAssemblyContext_AllocationContext(myAssemblyContext);
		myAllocationContext.setResourceContainer_AllocationContext(this.container);
		
		allocation.getAllocationContexts_Allocation().add(myAllocationContext);
	}
	
	public AssemblyContext getAssemblyContext() {
		return myAssemblyContext;
	}
		
	public ProvidedRole getProvidedRole() {
		return this.basicComponent.getProvidedRoles_InterfaceProvidingEntity().get(0);
	}

	public RequiredRole getRequiredRole() {
		return this.basicComponent.getRequiredRoles_InterfaceRequiringEntity().get(0);
	}
	
}
