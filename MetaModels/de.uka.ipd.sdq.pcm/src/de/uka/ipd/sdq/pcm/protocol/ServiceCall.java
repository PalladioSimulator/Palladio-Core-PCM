
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.protocol;

import de.uka.ipd.sdq.pcm.repository.Signature;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.protocol.ServiceCall#getSignature__ServiceCall <em>Signature Service Call</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.protocol.ProtocolPackage#getServiceCall()
 * @model abstract="true"
 * @generated
 */
public interface ServiceCall extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Signature Service Call</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signature Service Call</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signature Service Call</em>' reference.
	 * @see #setSignature__ServiceCall(Signature)
	 * @see de.uka.ipd.sdq.pcm.protocol.ProtocolPackage#getServiceCall_Signature__ServiceCall()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Signature getSignature__ServiceCall();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.protocol.ServiceCall#getSignature__ServiceCall <em>Signature Service Call</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signature Service Call</em>' reference.
	 * @see #getSignature__ServiceCall()
	 * @generated
	 */
	void setSignature__ServiceCall(Signature value);

} // ServiceCall
