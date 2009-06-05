/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.stoex;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Random Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.stoex.RandomVariable#getSpecification <em>Specification</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.stoex.RandomVariable#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.stoex.StoexPackage#getRandomVariable()
 * @model
 * @generated
 */
public interface RandomVariable extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007-2009, SDQ, IPD, U Karlsruhe";

	/**
	 * Returns the value of the '<em><b>Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specification</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specification</em>' attribute.
	 * @see #setSpecification(String)
	 * @see de.uka.ipd.sdq.stoex.StoexPackage#getRandomVariable_Specification()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getSpecification();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.stoex.RandomVariable#getSpecification <em>Specification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specification</em>' attribute.
	 * @see #getSpecification()
	 * @generated
	 */
	void setSpecification(String value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' reference.
	 * @see de.uka.ipd.sdq.stoex.StoexPackage#getRandomVariable_Expression()
	 * @model unsettable="true" required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false" suppressedIsSetVisibility="true"
	 *        extendedMetaData="name='' namespace=''"
	 * @generated
	 */
	Expression getExpression();

} // RandomVariable
