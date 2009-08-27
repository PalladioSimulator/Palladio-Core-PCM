/**
 * 
 */
package de.uka.ipd.sdq.edp2.impl;

import org.eclipse.emf.ecore.resource.ResourceSet;

/**Interface for all EMF-model handling DAOs.
 * Ensures that a common resource set can be used for all models which allow cross references.
 * @author groenda
 */
public interface EmfResourceDao {
	/**Sets the EMF resource set for the DAO.
	 * Can only be set once.
	 * @param newResourceSet The new resource set.
	 */
	public void setResourceSet(ResourceSet newResourceSet);
	
	/**Gets the resource set in use.
	 * @return the resource set.
	 */
	public ResourceSet getResourceSet();

}
