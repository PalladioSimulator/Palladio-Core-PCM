
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingRequiringEntity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Provides Component Type</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getProvidesComponentType()
 * @model
 * @generated
 */
public interface ProvidesComponentType extends InterfaceProvidingRequiringEntity, Entity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

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