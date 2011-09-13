/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision;

import org.eclipse.emf.ecore.EEnum;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Degree</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Construct to model a special type of enumerated degree of freedom where the domain of values is a subset of an enumeration in the metamodel. Each concrete subclass of EnumDegree must model the domain explicitly (refer to the concrete Enum to choose from). 
 * 
 * This class is actually superflous as it does not add any properties to its subclasses. It is just used to conceptually group this type of degree of freedom. Maybe it can be used to implement some OCL checks (with reflection?). 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.EnumDegree#getEnumeration <em>Enumeration</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getEnumDegree()
 * @model abstract="true"
 * @generated
 */
public interface EnumDegree extends UnorderedDegree {

	/**
	 * Returns the value of the '<em><b>Enumeration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enumeration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enumeration</em>' reference.
	 * @see #setEnumeration(EEnum)
	 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getEnumDegree_Enumeration()
	 * @model ordered="false"
	 * @generated
	 */
	EEnum getEnumeration();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.designdecision.EnumDegree#getEnumeration <em>Enumeration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enumeration</em>' reference.
	 * @see #getEnumeration()
	 * @generated
	 */
	void setEnumeration(EEnum value);
} // EnumDegree
