/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.resources;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contention Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.resources.ContentionResource#getCapacity <em>Capacity</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.resources.ResourcesPackage#getContentionResource()
 * @model abstract="true"
 * @generated
 */
public interface ContentionResource extends Resource {
	/**
	 * Returns the value of the '<em><b>Capacity</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capacity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capacity</em>' attribute.
	 * @see #setCapacity(int)
	 * @see de.uka.ipd.sdq.capra.resources.ResourcesPackage#getContentionResource_Capacity()
	 * @model default="1" required="true" ordered="false"
	 * @generated
	 */
	int getCapacity();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.resources.ContentionResource#getCapacity <em>Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capacity</em>' attribute.
	 * @see #getCapacity()
	 * @generated
	 */
	void setCapacity(int value);

} // ContentionResource
