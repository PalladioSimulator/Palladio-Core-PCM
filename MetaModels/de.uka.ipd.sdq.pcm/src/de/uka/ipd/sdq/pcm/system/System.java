
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.system;

import de.uka.ipd.sdq.pcm.allocation.Allocation;

import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.System#getSystemProvidedRole_System <em>System Provided Role System</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.System#getAllocation_System <em>Allocation System</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.System#getSystemRequiredRole_System <em>System Required Role System</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.system.SystemPackage#getSystem()
 * @model
 * @generated
 */
public interface System extends ComposedStructure, Entity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * Returns the value of the '<em><b>System Provided Role System</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.system.SystemProvidedRole}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.system.SystemProvidedRole#getSystem_SystemProvidedRole <em>System System Provided Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System Provided Role System</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System Provided Role System</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.system.SystemPackage#getSystem_SystemProvidedRole_System()
	 * @see de.uka.ipd.sdq.pcm.system.SystemProvidedRole#getSystem_SystemProvidedRole
	 * @model type="de.uka.ipd.sdq.pcm.system.SystemProvidedRole" opposite="system_SystemProvidedRole" containment="true" ordered="false"
	 * @generated
	 */
	EList getSystemProvidedRole_System();

	/**
	 * Returns the value of the '<em><b>Allocation System</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allocation System</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allocation System</em>' reference.
	 * @see #setAllocation_System(Allocation)
	 * @see de.uka.ipd.sdq.pcm.system.SystemPackage#getSystem_Allocation_System()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Allocation getAllocation_System();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.system.System#getAllocation_System <em>Allocation System</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allocation System</em>' reference.
	 * @see #getAllocation_System()
	 * @generated
	 */
	void setAllocation_System(Allocation value);

	/**
	 * Returns the value of the '<em><b>System Required Role System</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.system.SystemRequiredRole}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.system.SystemRequiredRole#getSystem_SystemRequiredRole <em>System System Required Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System Required Role System</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System Required Role System</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.system.SystemPackage#getSystem_SystemRequiredRole_System()
	 * @see de.uka.ipd.sdq.pcm.system.SystemRequiredRole#getSystem_SystemRequiredRole
	 * @model type="de.uka.ipd.sdq.pcm.system.SystemRequiredRole" opposite="system_SystemRequiredRole" containment="true" ordered="false"
	 * @generated
	 */
	EList getSystemRequiredRole_System();

} // System