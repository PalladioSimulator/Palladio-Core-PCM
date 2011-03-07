/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration Choice</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The EnumerationChoice represents a choice for a DegreeOfFreedom that has a domain of PCM Entities (i.e. a EnumerationDegree). 
 * 
 * TODO constraint:  The degreeOfFreedom of this Choice must be an EnumerationDegree
 * 
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.EnumerationChoice#getEntity <em>Entity</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getEnumerationChoice()
 * @model
 * @generated
 */
public interface EnumerationChoice extends Choice {
	/**
	 * Returns the value of the '<em><b>Entity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * TODO: constraint: Chosen entity must be in the domain of the EnumerationDegree;
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Entity</em>' reference.
	 * @see #setEntity(Entity)
	 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getEnumerationChoice_Entity()
	 * @model ordered="false"
	 * @generated
	 */
	Entity getEntity();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.designdecision.EnumerationChoice#getEntity <em>Entity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entity</em>' reference.
	 * @see #getEntity()
	 * @generated
	 */
	void setEntity(Entity value);

} // EnumerationChoice
