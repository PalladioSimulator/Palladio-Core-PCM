/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.GDoF;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.GDoF.GDoFRepository#getGdofs <em>Gdofs</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.GDoF.GDoFPackage#getGDoFRepository()
 * @model
 * @generated
 */
public interface GDoFRepository extends EObject {
	/**
	 * Returns the value of the '<em><b>Gdofs</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.designdecision.GDoF.GenericDegreeOfFreedom}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gdofs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gdofs</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.designdecision.GDoF.GDoFPackage#getGDoFRepository_Gdofs()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<GenericDegreeOfFreedom> getGdofs();

} // GDoFRepository
