package de.uka.ipd.sdq.pcmbench.ui.provider.categoryaware;


import java.util.Collection;

import org.eclipse.emf.ecore.EObject;

/**
 * @author Snowball
 * Interface to characterise a set of category descriptions which is used to 
 * configure the generic category item provider / category aware item provider 
 * instances.
 */
public interface ICategoryDescriptions {

	/**
	 * Test wheter the given object has categories or not
	 * @param object The object to test for categories
	 * @return true if the given object should be displayed using categories - false otherwise
	 */
	boolean hasCategoriesForObject(EObject object);

	/**
	 * Return the list of category descriptors for the given object. 
	 * @param object The object for which the categories should be retrieved
	 * @return The set of category descriptors characterising the categories into which
	 * the children of the object are divided
	 */
	Collection<CategoryDescriptor> getCategoriesForObject(EObject object);

}
