
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

import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingRequiringEntity;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.system.System#getAllocation_System <em>Allocation System</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.system.SystemPackage#getSystem()
 * @model
 * @generated
 */
public interface System extends ComposedStructure, Entity, InterfaceProvidingRequiringEntity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

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

} // System