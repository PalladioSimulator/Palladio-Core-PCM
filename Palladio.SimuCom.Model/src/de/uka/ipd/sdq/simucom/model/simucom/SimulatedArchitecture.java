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
 * A representation of the model object '<em><b>Simulated Architecture</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.simucom.model.simucom.SimulatedArchitecture#getComponents <em>Components</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.simucom.model.simucom.SimuComModelPackage#getSimulatedArchitecture()
 * @model
 * @generated
 */
public interface SimulatedArchitecture extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by Steffen Becker, 2006"; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Components</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.simucom.model.simucom.SimulatedComponent}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Components</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Components</em>' containment reference list.
	 * @see de.uka.ipd.sdq.simucom.model.simucom.SimuComModelPackage#getSimulatedArchitecture_Components()
	 * @model type="de.uka.ipd.sdq.simucom.model.simucom.SimulatedComponent" containment="true"
	 * @generated
	 */
	EList getComponents();

} // SimulatedArchitecture
