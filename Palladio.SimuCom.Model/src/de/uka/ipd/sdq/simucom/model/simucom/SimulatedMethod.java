/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.simucom.model.simucom;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simulated Method</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.simucom.model.simucom.SimulatedMethod#getServiceEffect <em>Service Effect</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.simucom.model.simucom.SimulatedMethod#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.simucom.model.simucom.SimuComModelPackage#getSimulatedMethod()
 * @model
 * @generated
 */
public interface SimulatedMethod extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by Steffen Becker, 2006"; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Service Effect</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Effect</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Effect</em>' containment reference.
	 * @see #setServiceEffect(ServiceEffect)
	 * @see de.uka.ipd.sdq.simucom.model.simucom.SimuComModelPackage#getSimulatedMethod_ServiceEffect()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ServiceEffect getServiceEffect();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.simucom.model.simucom.SimulatedMethod#getServiceEffect <em>Service Effect</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Effect</em>' containment reference.
	 * @see #getServiceEffect()
	 * @generated
	 */
	void setServiceEffect(ServiceEffect value);

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
	 * @see de.uka.ipd.sdq.simucom.model.simucom.SimuComModelPackage#getSimulatedMethod_Name()
	 * @model default=""
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.simucom.model.simucom.SimulatedMethod#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // SimulatedMethod
