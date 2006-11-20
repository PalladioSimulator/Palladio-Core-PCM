/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa.resourcemodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Delay Resource Usage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.spa.resourcemodel.DelayResourceUsage#getDelayResource <em>Delay Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.spa.resourcemodel.ResourceModelPackage#getDelayResourceUsage()
 * @model
 * @generated
 */
public interface DelayResourceUsage extends ResourceUsage {
	/**
	 * Returns the value of the '<em><b>Delay Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delay Resource</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delay Resource</em>' reference.
	 * @see #setDelayResource(DelayResource)
	 * @see de.uka.ipd.sdq.spa.resourcemodel.ResourceModelPackage#getDelayResourceUsage_DelayResource()
	 * @model required="true"
	 * @generated
	 */
	DelayResource getDelayResource();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.spa.resourcemodel.DelayResourceUsage#getDelayResource <em>Delay Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delay Resource</em>' reference.
	 * @see #getDelayResource()
	 * @generated
	 */
	void setDelayResource(DelayResource value);

} // DelayResourceUsage