package de.uka.ipd.sdq.pcm.transformations.builder.abstractbuilder;

import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.allocation.AllocationFactory;
import de.uka.ipd.sdq.pcm.core.composition.CompositionFactory;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.transformations.builder.seff.DelegatorComponentSeffBuilder;
import de.uka.ipd.sdq.pcm.transformations.builder.seff.ISeffBuilder;
import de.uka.ipd.sdq.pcm.transformations.builder.util.PCMAndCompletionModelHolder;

/**
 * A builder for creating basic components and their assembly and allocation context. The component has a single provided and required interface which
 * can be optionally the same (usefull if used with a delegating seff builder).
 * @author   Snowball
 */
public abstract class BasicComponentBuilder
extends AbstractComponentBuilder {

	protected DelegatorComponentSeffBuilder seffBuilder;
	private Interface providedInterface;
	private Interface requiredInterface;
	private AllocationContext myAllocationContext;
	protected ResourceContainer container;

	public BasicComponentBuilder(
			PCMAndCompletionModelHolder models,
			Interface interf,
			ResourceContainer container) {
		this(models,interf,interf,container);
	}
	
	public BasicComponentBuilder(
			PCMAndCompletionModelHolder models,
			Interface providedIf,
			Interface requiredIf,
			ResourceContainer container) {
		super(models);
		this.providedInterface = providedIf;
		this.requiredInterface = requiredIf;
		this.container = container;
	}

	protected abstract ISeffBuilder getSeffBuilder();
	
	@Override
	public void build() {
		super.build();
		
		myProvidedRole = addProvidedRole(providedInterface,"ProvidedRole");
		myRequiredRole = addRequiredRole(requiredInterface,"RequiredRole");

		ISeffBuilder seffBuilder = this.getSeffBuilder();
		seffBuilder.build();
		getBasicComponent().getServiceEffectSpecifications__BasicComponent().addAll(seffBuilder.getSeffs());
		
		this.myAssemblyContext = CompositionFactory.eINSTANCE.createAssemblyContext();
		this.myAssemblyContext.setEntityName("BCAssembly "+myComponent.getEntityName());
		this.myAssemblyContext.setEncapsulatedComponent_AssemblyContext(myComponent);

		this.myAllocationContext = AllocationFactory.eINSTANCE.createAllocationContext();
		myAllocationContext.setAssemblyContext_AllocationContext(myAssemblyContext);
		myAllocationContext.setResourceContainer_AllocationContext(this.container);
		
		myModels.getAllocation().getAllocationContexts_Allocation().add(myAllocationContext);
	}
	
	protected BasicComponent getBasicComponent() {
		return (BasicComponent)myComponent;
	}

	@Override
	protected RepositoryComponent createComponent() {
		BasicComponent bc = RepositoryFactory.eINSTANCE.createBasicComponent();
		bc.setEntityName("InnerBasicComponent"+getNextCounter());
		return bc;
	}
	
}
