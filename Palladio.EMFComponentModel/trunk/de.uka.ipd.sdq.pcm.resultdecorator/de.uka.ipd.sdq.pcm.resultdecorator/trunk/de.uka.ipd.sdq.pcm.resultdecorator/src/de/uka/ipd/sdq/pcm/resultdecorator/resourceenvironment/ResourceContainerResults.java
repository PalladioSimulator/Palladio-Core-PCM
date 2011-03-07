/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironment;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Container Results</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironment.ResourceContainerResults#getResourcecontainer <em>Resourcecontainer</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironment.resourceenvironmentdecoratorPackage#getResourceContainerResults()
 * @model
 * @generated
 */
public interface ResourceContainerResults extends UtilisationResult {
	/**
	 * Returns the value of the '<em><b>Resourcecontainer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resourcecontainer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resourcecontainer</em>' reference.
	 * @see #setResourcecontainer(ResourceContainer)
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironment.resourceenvironmentdecoratorPackage#getResourceContainerResults_Resourcecontainer()
	 * @model ordered="false"
	 * @generated
	 */
	ResourceContainer getResourcecontainer();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironment.ResourceContainerResults#getResourcecontainer <em>Resourcecontainer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resourcecontainer</em>' reference.
	 * @see #getResourcecontainer()
	 * @generated
	 */
	void setResourcecontainer(ResourceContainer value);

} // ResourceContainerResults
