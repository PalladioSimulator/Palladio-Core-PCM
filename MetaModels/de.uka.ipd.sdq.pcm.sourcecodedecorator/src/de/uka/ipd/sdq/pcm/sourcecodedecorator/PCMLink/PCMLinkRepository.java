/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.identifier.Identifier;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggingPositionIdLink;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkRepository#getComponentfilelink <em>Componentfilelink</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkRepository#getSeffmethodlink <em>Seffmethodlink</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkRepository#getActioncontrolflowlink <em>Actioncontrolflowlink</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkRepository#getLoggingPositionLinks <em>Logging Position Links</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkPackage#getPCMLinkRepository()
 * @model
 * @generated
 */
public interface PCMLinkRepository extends Identifier {
	/**
	 * Returns the value of the '<em><b>Componentfilelink</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.ComponentFileLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Componentfilelink</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Componentfilelink</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkPackage#getPCMLinkRepository_Componentfilelink()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ComponentFileLink> getComponentfilelink();

	/**
	 * Returns the value of the '<em><b>Seffmethodlink</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.SEFFMethodLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Seffmethodlink</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Seffmethodlink</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkPackage#getPCMLinkRepository_Seffmethodlink()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<SEFFMethodLink> getSeffmethodlink();

	/**
	 * Returns the value of the '<em><b>Actioncontrolflowlink</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.ActionControlFlowLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actioncontrolflowlink</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actioncontrolflowlink</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkPackage#getPCMLinkRepository_Actioncontrolflowlink()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ActionControlFlowLink> getActioncontrolflowlink();

	/**
	 * Returns the value of the '<em><b>Logging Position Links</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggingPositionIdLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Logging Position Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Logging Position Links</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkPackage#getPCMLinkRepository_LoggingPositionLinks()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<LoggingPositionIdLink> getLoggingPositionLinks();

} // PCMLinkRepository
