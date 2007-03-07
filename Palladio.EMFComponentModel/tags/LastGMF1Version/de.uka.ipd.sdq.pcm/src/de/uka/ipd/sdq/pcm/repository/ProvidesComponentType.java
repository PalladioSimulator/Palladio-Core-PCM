
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingRequiringEntity;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Provides Component Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.ProvidesComponentType#getRepository_ProvidesComponentType <em>Repository Provides Component Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getProvidesComponentType()
 * @model
 * @generated
 */
public interface ProvidesComponentType extends Entity, InterfaceProvidingRequiringEntity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * Returns the value of the '<em><b>Repository Provides Component Type</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.repository.Repository#getComponents__Repository <em>Components Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repository Provides Component Type</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository Provides Component Type</em>' container reference.
	 * @see #setRepository_ProvidesComponentType(Repository)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getProvidesComponentType_Repository_ProvidesComponentType()
	 * @see de.uka.ipd.sdq.pcm.repository.Repository#getComponents__Repository
	 * @model opposite="components__Repository" required="true" ordered="false"
	 * @generated
	 */
	Repository getRepository_ProvidesComponentType();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.ProvidesComponentType#getRepository_ProvidesComponentType <em>Repository Provides Component Type</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repository Provides Component Type</em>' container reference.
	 * @see #getRepository_ProvidesComponentType()
	 * @generated
	 */
	void setRepository_ProvidesComponentType(Repository value);


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.oclIsTypeOf(ProvidesComponentType)
	 * implies
	 * self.providedRoles_InterfaceProvidingEntity->size() >= 1
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean AtLeastOneInterfaceHasToBeProvidedByAUsefullProvidesComponentType(DiagnosticChain diagnostics, Map context);

} // ProvidesComponentType