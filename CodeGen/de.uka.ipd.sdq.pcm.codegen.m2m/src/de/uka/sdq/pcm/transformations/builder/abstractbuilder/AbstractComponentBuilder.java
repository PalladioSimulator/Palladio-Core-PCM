package de.uka.sdq.pcm.transformations.builder.abstractbuilder;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceInterface;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRequiredRole;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceProvidedRole;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceService;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypeFactory;
import de.uka.sdq.pcm.transformations.builder.IComponentBuilder;
import de.uka.sdq.pcm.transformations.builder.util.PCMAndCompletionModelHolder;

/**
 * Replaces the passed AssemblyConnector with a completion
 * @author  Snowball
 */
public abstract class AbstractComponentBuilder
implements IComponentBuilder {
	
	/**
	 */
	protected RepositoryComponent myComponent;
	protected ProvidedRole myProvidedRole;
	protected RequiredRole myRequiredRole;
	protected ResourceRequiredRole myResourceRequiredRole;
	protected AssemblyContext myAssemblyContext;
	protected PCMAndCompletionModelHolder myModels;
	private static int counter = 0;

	public AbstractComponentBuilder(PCMAndCompletionModelHolder models) {
		this.myComponent = createComponent();
		this.myModels = models;
	}
	
	protected abstract RepositoryComponent createComponent();
	
	public AssemblyContext getAssemblyContext() {
		return myAssemblyContext;
	}

	protected ProvidedRole addProvidedRole(Interface interf, String roleName) {
		ProvidedRole result = RepositoryFactory.eINSTANCE.createProvidedRole();
		result.setProvidedInterface__ProvidedRole(interf);
		result.setEntityName(roleName);
		myComponent.getProvidedRoles_InterfaceProvidingEntity().add(result);
		return result;
	}

	protected RequiredRole addRequiredRole(Interface interf, String roleName) {
		RequiredRole result = RepositoryFactory.eINSTANCE.createRequiredRole();
		result.setRequiredInterface__RequiredRole(interf);
		result.setEntityName(roleName);
		myComponent.getRequiredRoles_InterfaceRequiringEntity().add(result);
		return result;
	}
	
	protected ResourceRequiredRole addResourceRequiredRole(ResourceInterface resourceInterf, String roleName) {
		ResourceRequiredRole result = ResourcetypeFactory.eINSTANCE.createResourceRequiredRole();
		result.setRequiredResourceInterface_ResourceRequiredRole(resourceInterf);
		result.setEntityName(roleName);
		myComponent.getResourceRequiredRoles_ResourceInterfaceRequiringEntity().add(result);
		return result;
	}

	public ProvidedRole getProvidedRole() {
		return myProvidedRole;
	}

	public RequiredRole getRequiredRole() {
		return myRequiredRole;
	}
	
	public ResourceRequiredRole getResourceRequiredRole() {
		return myResourceRequiredRole;
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
	
	// Hauck 2008.12.23: New lookup method for resource service
	protected ResourceService findResourceService(ProcessingResourceType resourceType, String nameFragment) {
		for (ResourceProvidedRole role: resourceType.getResourceProvidedRoles_ResourceInterfaceProvidingEntity()) {
			for (ResourceService service: role.getProvidedResourceInterface_ResourceProvidedRole().getResourceServices_ResourceInterface()) {
				if (service.getServiceName().toLowerCase().contains(nameFragment.toLowerCase())) {
					return service;
				}
			}
		}
		throw new RuntimeException("Neccessary resourceservice "+nameFragment+" not found");
	}
	
	// Hauck 2008.12.23: New lookup method for resource required role
	protected ResourceRequiredRole findResourceRequiredRole(ProcessingResourceType resourceType) {
		for (ResourceProvidedRole role: resourceType.getResourceProvidedRoles_ResourceInterfaceProvidingEntity()) {
			if (myResourceRequiredRole.getRequiredResourceInterface_ResourceRequiredRole().equals(role.getProvidedResourceInterface_ResourceProvidedRole())) {
				return myResourceRequiredRole;
			}	
		}
		throw new RuntimeException("Neccessary resourcerequiredrole for resource "+resourceType.getEntityName()+" not found");
	}
}
