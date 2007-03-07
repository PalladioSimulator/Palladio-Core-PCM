
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.protocol;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Protocol</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.protocol.Protocol#getProtocolTypeID <em>Protocol Type ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.protocol.ProtocolPackage#getProtocol()
 * @model abstract="true"
 * @generated
 */
public interface Protocol extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * Returns the value of the '<em><b>Protocol Type ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Protocol Type ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Protocol Type ID</em>' attribute.
	 * @see #setProtocolTypeID(String)
	 * @see de.uka.ipd.sdq.pcm.protocol.ProtocolPackage#getProtocol_ProtocolTypeID()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getProtocolTypeID();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.protocol.Protocol#getProtocolTypeID <em>Protocol Type ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Protocol Type ID</em>' attribute.
	 * @see #getProtocolTypeID()
	 * @generated
	 */
	void setProtocolTypeID(String value);

} // Protocol