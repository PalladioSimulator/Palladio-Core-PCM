package de.uka.ipd.sdq.pcm.transformations.builder.abstractbuilder;

import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.allocation.AllocationFactory;
import de.uka.ipd.sdq.pcm.core.composition.CompositionFactory;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.OperationInterface;
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
	private OperationInterface providedOperationInterface;
	private OperationInterface requiredOperationInterface;
	private AllocationContext myAllocationContext;
	protected ResourceContainer container;

	public BasicComponentBuilder(
			PCMAndCompletionModelHolder models,
			OperationInterface interf,
			ResourceContainer container, 
			String componentName) {
		this(models,interf,interf,container,componentName);
	}
	
	public BasicComponentBuilder(
			PCMAndCompletionModelHolder models,
			OperationInterface providedIf,
			OperationInterface requiredIf,
			ResourceContainer container,
			String componentName) {
		super(models, componentName);
		this.providedOperationInterface = providedIf;
		this.requiredOperationInterface = requiredIf;
		this.container = container;
	}

	protected abstract ISeffBuilder getSeffBuilder();
	
	@Override
	public void build() {
		super.build();
		
		myOperationProvidedRole = addOperationProvidedRole(providedOperationInterface,"ProvidedRole");
		myOperationRequiredRole = addOperationRequiredRole(requiredOperationInterface,"RequiredRole");

		ISeffBuilder seffBuilder = this.getSeffBuilder();
		seffBuilder.build();
		getBasicComponent().getServiceEffectSpecifications__BasicComponent().addAll(seffBuilder.getSeffs());
		
		this.myAssemblyContext = CompositionFactory.eINSTANCE.createAssemblyContext();
		this.myAssemblyContext.setEntityName("BCAssembly "+myComponent.getEntityName());
		this.myAssemblyContext.setEncapsulatedComponent__AssemblyContext(myComponent);

		this.myAllocationContext = AllocationFactory.eINSTANCE.createAllocationContext();
		myAllocationContext.setAssemblyContext_AllocationContext(myAssemblyContext);
		myAllocationContext.setResourceContainer_AllocationContext(this.container);
		
		myModels.getAllocation().getAllocationContexts_Allocation().add(myAllocationContext);
	}
	
	protected BasicComponent getBasicComponent() {
		return (BasicComponent)myComponent;
	}

	@Override
	protected RepositoryComponent createComponent(String componentName) {
		BasicComponent bc = RepositoryFactory.eINSTANCE.createBasicComponent();
		bc.setEntityName("InnerBasicComponent_"+componentName+getNextCounter());
		return bc;
	}
	
}
