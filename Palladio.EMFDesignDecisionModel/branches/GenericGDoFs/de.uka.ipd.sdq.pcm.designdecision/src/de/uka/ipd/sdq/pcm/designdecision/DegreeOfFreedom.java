/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

import de.uka.ipd.sdq.pcm.designdecision.GDoF.GenericDegreeOfFreedom;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Degree Of Freedom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Each degree of freedom of the system architecture can be represented by a DegreeOfFreedom element. Each DegreeOfFreedom has two parts: It links a model element that is the changeable entity in this DegreeOfFreedom, and it specifies a domain of possible values that the model element can take. 
 * 
 * The domain is defined in subclasses, because it may be either a set of PCM Entities (in the EnumerationDegree) or integer or double ranges (in the RangeDegree and its subclasses). 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedom#getPrimaryChanged <em>Primary Changed</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedom#getGdof <em>Gdof</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getDegreeOfFreedom()
 * @model abstract="true"
 * @generated
 */
public interface DegreeOfFreedom extends EObject {
	/**
	 * Returns the value of the '<em><b>Primary Changed</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Changed</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Changed</em>' reference.
	 * @see #setPrimaryChanged(Entity)
	 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getDegreeOfFreedom_PrimaryChanged()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Entity getPrimaryChanged();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedom#getPrimaryChanged <em>Primary Changed</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Changed</em>' reference.
	 * @see #getPrimaryChanged()
	 * @generated
	 */
	void setPrimaryChanged(Entity value);

	/**
	 * Returns the value of the '<em><b>Gdof</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gdof</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gdof</em>' reference.
	 * @see #setGdof(GenericDegreeOfFreedom)
	 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getDegreeOfFreedom_Gdof()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	GenericDegreeOfFreedom getGdof();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedom#getGdof <em>Gdof</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gdof</em>' reference.
	 * @see #getGdof()
	 * @generated
	 */
	void setGdof(GenericDegreeOfFreedom value);

} // DegreeOfFreedom
