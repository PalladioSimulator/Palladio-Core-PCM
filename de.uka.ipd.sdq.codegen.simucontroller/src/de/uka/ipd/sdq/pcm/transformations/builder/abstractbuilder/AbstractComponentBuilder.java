package de.uka.ipd.sdq.pcm.transformations.builder.abstractbuilder;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceType;
import de.uka.ipd.sdq.pcm.transformations.builder.IComponentBuilder;
import de.uka.ipd.sdq.pcm.transformations.builder.util.PCMAndCompletionModelHolder;

/**
 * Replaces the passed AssemblyConnector with a completion
 * @author  Snowball
 */
public abstract class AbstractComponentBuilder
implements IComponentBuilder {
	
	/**
	 */
	protected RepositoryComponent myComponent;
	protected OperationProvidedRole myOperationProvidedRole;
	protected OperationRequiredRole myOperationRequiredRole;
	protected AssemblyContext myAssemblyContext;
	protected PCMAndCompletionModelHolder myModels;
	
	private static int counter = 0;

	public AbstractComponentBuilder(PCMAndCompletionModelHolder models, String componentName) {
		this.myComponent = createComponent(componentName);
		this.myModels = models;
	}
	
	protected abstract RepositoryComponent createComponent(String componentName);
	
	public AssemblyContext getAssemblyContext() {
		return myAssemblyContext;
	}

	protected OperationProvidedRole addOperationProvidedRole(OperationInterface interf, String roleName) {
		OperationProvidedRole result = RepositoryFactory.eINSTANCE.createOperationProvidedRole();
		result.setProvidedInterface__OperationProvidedRole(interf);
		result.setEntityName(roleName);
		myComponent.getProvidedRoles_InterfaceProvidingEntity().add(result);
		return result;
	}

	protected OperationRequiredRole addOperationRequiredRole(OperationInterface interf, String roleName) {
		OperationRequiredRole result = RepositoryFactory.eINSTANCE.createOperationRequiredRole();
		result.setRequiredInterface__OperationRequiredRole(interf);
		result.setEntityName(roleName);
		myComponent.getRequiredRoles_InterfaceRequiringEntity().add(result);
		return result;
	}

	public OperationProvidedRole getOperationProvidedRole() {
		return myOperationProvidedRole;
	}

	public OperationRequiredRole getOperationRequiredRole() {
		return myOperationRequiredRole;
	}
	
	protected int getNextCounter(){
		counter++;
		return counter;
	}

	public RepositoryComponent getComponent() {
		return myComponent;
	}

	public void build() {
		myModels.getCompletionRepository().getComponents__Repository().add(myComponent);
	}
	
	protected ProcessingResourceType findResourceType(String nameFragment) {
		for (ResourceType type : myModels.getResourceRepository().getAvailableResourceTypes_ResourceRepository()){
			if (type instanceof ProcessingResourceType && type.getEntityName().toLowerCase().contains(nameFragment.toLowerCase()))
				return (ProcessingResourceType) type;
		}
		throw new RuntimeException("Neccessary resourcetype "+nameFragment+" not found");
	}
}
