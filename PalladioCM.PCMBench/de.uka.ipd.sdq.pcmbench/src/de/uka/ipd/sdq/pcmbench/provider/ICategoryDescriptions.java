package de.uka.ipd.sdq.pcmbench.provider;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;

public interface ICategoryDescriptions {

	boolean hasCategoriesForObject(EObject object);

	Collection<CategoryDescriptor> getCategoriesForObject(EObject object);

}
