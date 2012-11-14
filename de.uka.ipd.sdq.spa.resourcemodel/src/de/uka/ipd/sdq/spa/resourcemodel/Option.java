/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa.resourcemodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Option</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.spa.resourcemodel.Option#getProbability <em>Probability</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.spa.resourcemodel.Option#getResourceUsage <em>Resource Usage</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.spa.resourcemodel.ResourceModelPackage#getOption()
 * @model
 * @generated
 */
public interface Option extends EObject {
	/**
	 * Returns the value of the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Probability</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Probability</em>' attribute.
	 * @see #setProbability(double)
	 * @see de.uka.ipd.sdq.spa.resourcemodel.ResourceModelPackage#getOption_Probability()
	 * @model unique="false" required="true"
	 * @generated
	 */
	double getProbability();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.spa.resourcemodel.Option#getProbability <em>Probability</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Probability</em>' attribute.
	 * @see #getProbability()
	 * @generated
	 */
	void setProbability(double value);

	/**
	 * Returns the value of the '<em><b>Resource Usage</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Usage</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Usage</em>' containment reference.
	 * @see #setResourceUsage(AbstractResourceUsage)
	 * @see de.uka.ipd.sdq.spa.resourcemodel.ResourceModelPackage#getOption_ResourceUsage()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AbstractResourceUsage getResourceUsage();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.spa.resourcemodel.Option#getResourceUsage <em>Resource Usage</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Usage</em>' containment reference.
	 * @see #getResourceUsage()
	 * @generated
	 */
	void setResourceUsage(AbstractResourceUsage value);

} // Option
