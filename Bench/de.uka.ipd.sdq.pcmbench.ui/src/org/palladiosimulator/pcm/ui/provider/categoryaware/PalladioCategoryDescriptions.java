/**
 * 
 */
package org.palladiosimulator.pcm.ui.provider.categoryaware;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;

import org.palladiosimulator.pcm.core.composition.AssemblyConnector;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.CompositionPackage;
import org.palladiosimulator.pcm.core.entity.EntityPackage;
import org.palladiosimulator.pcm.repository.BasicComponent;
import org.palladiosimulator.pcm.repository.CompositeComponent;
import org.palladiosimulator.pcm.repository.Interface;
import org.palladiosimulator.pcm.repository.ProvidedRole;
import org.palladiosimulator.pcm.repository.ProvidesComponentType;
import org.palladiosimulator.pcm.repository.Repository;
import org.palladiosimulator.pcm.repository.RepositoryPackage;
import org.palladiosimulator.pcm.repository.RequiredRole;
import org.palladiosimulator.pcm.seff.ServiceEffectSpecification;

/**
 * @author Snowball
 *
 */
public class PalladioCategoryDescriptions implements ICategoryDescriptions {

	/**
	 * 
	 */
	public PalladioCategoryDescriptions() {
	}

	public Collection<CategoryDescriptor> getCategoriesForObject(EObject object) {
		if (object instanceof Repository)
		{
			ArrayList<CategoryDescriptor> result = new ArrayList<CategoryDescriptor>();
			result.add(new CategoryDescriptor(Repository.class, Interface.class, 
					RepositoryPackage.eINSTANCE.getRepository_Interfaces__Repository(), "Interfaces" ));
			result.add(new CategoryDescriptor(Repository.class, ProvidesComponentType.class, 
					RepositoryPackage.eINSTANCE.getRepository_Components__Repository(), "Components" ));
			return Collections.unmodifiableCollection(result);
		}
		if (object instanceof ProvidesComponentType)
		{
			ArrayList<CategoryDescriptor> result = new ArrayList<CategoryDescriptor>();
			result.add(new CategoryDescriptor(ProvidesComponentType.class, ProvidedRole.class, 
					EntityPackage.eINSTANCE.getInterfaceProvidingEntity_ProvidedRoles_InterfaceProvidingEntity(), "Provided Roles" ));
			result.add(new CategoryDescriptor(ProvidesComponentType.class, RequiredRole.class, 
					EntityPackage.eINSTANCE.getInterfaceRequiringEntity_RequiredRoles_InterfaceRequiringEntity(), "Required Roles" ));
			if (object instanceof BasicComponent)
			{
				result.add(new CategoryDescriptor(BasicComponent.class, ServiceEffectSpecification.class, 
						RepositoryPackage.eINSTANCE.getBasicComponent_ServiceEffectSpecifications__BasicComponent(), "Service Effect Specifications" ));
			}
			if (object instanceof CompositeComponent)
			{
				result.add(new CategoryDescriptor(CompositeComponent.class, AssemblyContext.class, 
						CompositionPackage.eINSTANCE.getAssemblyContext_EncapsulatedComponent__AssemblyContext(), "Child Component Contexts" ));
				result.add(new CategoryDescriptor(CompositeComponent.class, AssemblyConnector.class, 
						CompositionPackage.eINSTANCE.getComposedStructure_Connectors__ComposedStructure(), "Assembly Connectors" ));
			}
			return Collections.unmodifiableCollection(result);
		}
		return Collections.EMPTY_LIST;
	}

	public boolean hasCategoriesForObject(EObject object) {
		return getCategoriesForObject(object).size() > 0;
	}
}
