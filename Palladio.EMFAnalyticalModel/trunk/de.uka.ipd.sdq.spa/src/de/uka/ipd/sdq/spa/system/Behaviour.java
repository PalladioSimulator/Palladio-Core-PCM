/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa.system;

import de.uka.ipd.sdq.spa.expression.RegularExpression;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behaviour</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.spa.system.Behaviour#getNumReplicas <em>Num Replicas</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.spa.system.Behaviour#getName <em>Name</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.spa.system.Behaviour#getBehaviour <em>Behaviour</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.spa.system.SystemPackage#getBehaviour()
 * @model
 * @generated
 */
public interface Behaviour extends EObject {
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
	 * @see de.uka.ipd.sdq.spa.system.SystemPackage#getBehaviour_NumReplicas()
	 * @model
	 * @generated
	 */
	int getNumReplicas();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.spa.system.Behaviour#getNumReplicas <em>Num Replicas</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Num Replicas</em>' attribute.
	 * @see #getNumReplicas()
	 * @generated
	 */
	void setNumReplicas(int value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.uka.ipd.sdq.spa.system.SystemPackage#getBehaviour_Name()
	 * @model default=""
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.spa.system.Behaviour#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Behaviour</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behaviour</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behaviour</em>' containment reference.
	 * @see #setBehaviour(RegularExpression)
	 * @see de.uka.ipd.sdq.spa.system.SystemPackage#getBehaviour_Behaviour()
	 * @model containment="true"
	 * @generated
	 */
	RegularExpression getBehaviour();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.spa.system.Behaviour#getBehaviour <em>Behaviour</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Behaviour</em>' containment reference.
	 * @see #getBehaviour()
	 * @generated
	 */
	void setBehaviour(RegularExpression value);

} // Behaviour