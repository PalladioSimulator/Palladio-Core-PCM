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
 * A representation of the model object '<em><b>Service Effect</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.simucom.model.simucom.ServiceEffect#getActivity <em>Activity</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.simucom.model.simucom.SimuComModelPackage#getServiceEffect()
 * @model
 * @generated
 */
public interface ServiceEffect extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by Steffen Becker, 2006"; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Activity</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.Activity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activity</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activity</em>' reference list.
	 * @see de.uka.ipd.sdq.simucom.model.simucom.SimuComModelPackage#getServiceEffect_Activity()
	 * @model type="org.eclipse.uml2.Activity"
	 * @generated
	 */
	EList getActivity();

} // ServiceEffect
