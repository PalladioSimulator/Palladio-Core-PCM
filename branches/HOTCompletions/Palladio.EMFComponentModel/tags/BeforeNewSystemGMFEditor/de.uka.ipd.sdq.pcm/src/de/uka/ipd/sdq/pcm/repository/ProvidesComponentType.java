
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Provides Component Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.ProvidesComponentType#getProvidedRoles__ProvidesComponentType <em>Provided Roles Provides Component Type</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.ProvidesComponentType#getRequiredRoles_ProvidesComponentType <em>Required Roles Provides Component Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getProvidesComponentType()
 * @model
 * @generated
 */
public interface ProvidesComponentType extends Entity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * Returns the value of the '<em><b>Provided Roles Provides Component Type</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.repository.ProvidedRole}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.repository.ProvidedRole#getProvidingComponent__ProvidedRole <em>Providing Component Provided Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provided Roles Provides Component Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provided Roles Provides Component Type</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getProvidesComponentType_ProvidedRoles__ProvidesComponentType()
	 * @see de.uka.ipd.sdq.pcm.repository.ProvidedRole#getProvidingComponent__ProvidedRole
	 * @model type="de.uka.ipd.sdq.pcm.repository.ProvidedRole" opposite="providingComponent__ProvidedRole" containment="true" ordered="false"
	 * @generated
	 */
	EList getProvidedRoles__ProvidesComponentType();

	/**
	 * Returns the value of the '<em><b>Required Roles Provides Component Type</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.repository.RequiredRole}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Roles Provides Component Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Roles Provides Component Type</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getProvidesComponentType_RequiredRoles_ProvidesComponentType()
	 * @model type="de.uka.ipd.sdq.pcm.repository.RequiredRole" containment="true" ordered="false"
	 * @generated
	 */
	EList getRequiredRoles_ProvidesComponentType();


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.oclIsTypeOf(ProvidesComponentType)
	 * implies
	 * self.providedRoles->size() >= 1
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean AtLeastOneInterfaceHasToBeProvidedByAUsefullProvidesComponentType(DiagnosticChain diagnostics, Map context);

} // ProvidesComponentType