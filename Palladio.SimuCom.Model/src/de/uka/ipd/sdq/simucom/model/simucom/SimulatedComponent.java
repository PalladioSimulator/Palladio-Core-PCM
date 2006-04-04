/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.simucom.model.simucom;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simulated Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.simucom.model.simucom.SimulatedComponent#getMethods <em>Methods</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.simucom.model.simucom.SimulatedComponent#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.simucom.model.simucom.SimuComModelPackage#getSimulatedComponent()
 * @model
 * @generated
 */
public interface SimulatedComponent extends EObject{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by Steffen Becker, 2006"; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Methods</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.simucom.model.simucom.SimulatedMethod}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Methods</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Methods</em>' containment reference list.
	 * @see de.uka.ipd.sdq.simucom.model.simucom.SimuComModelPackage#getSimulatedComponent_Methods()
	 * @model type="de.uka.ipd.sdq.simucom.model.simucom.SimulatedMethod" containment="true"
	 * @generated
	 */
	EList getMethods();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.uka.ipd.sdq.simucom.model.simucom.SimuComModelPackage#getSimulatedComponent_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.simucom.model.simucom.SimulatedComponent#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // SimulatedComponent
