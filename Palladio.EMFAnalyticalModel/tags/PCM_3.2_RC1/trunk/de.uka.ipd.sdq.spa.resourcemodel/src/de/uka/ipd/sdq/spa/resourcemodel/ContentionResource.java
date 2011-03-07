/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa.resourcemodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contention Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.spa.resourcemodel.ContentionResource#getNumReplicas <em>Num Replicas</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.spa.resourcemodel.ResourceModelPackage#getContentionResource()
 * @model abstract="true"
 * @generated
 */
public interface ContentionResource extends Resource {
	/**
	 * Returns the value of the '<em><b>Num Replicas</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Num Replicas</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Num Replicas</em>' attribute.
	 * @see #setNumReplicas(int)
	 * @see de.uka.ipd.sdq.spa.resourcemodel.ResourceModelPackage#getContentionResource_NumReplicas()
	 * @model required="true"
	 * @generated
	 */
	int getNumReplicas();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.spa.resourcemodel.ContentionResource#getNumReplicas <em>Num Replicas</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Num Replicas</em>' attribute.
	 * @see #getNumReplicas()
	 * @generated
	 */
	void setNumReplicas(int value);

} // ContentionResource
