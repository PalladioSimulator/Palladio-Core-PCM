/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository;

import de.uka.ipd.sdq.identifier.Identifier;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.InternalActionLink;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.ParameterLink;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggingPositionIdLink;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>PCM Link Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository.PCMLinkRepository#getLoggingPositionLinks <em>Logging Position Links</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository.PCMLinkRepository#getInternalActionLinks <em>Internal Action Links</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository.PCMLinkRepository#getInputParameterLinks <em>Input Parameter Links</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository.PCMLinkRepositoryPackage#getPCMLinkRepository()
 * @model
 * @generated
 */
public interface PCMLinkRepository extends Identifier {
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
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository.PCMLinkRepositoryPackage#getPCMLinkRepository_LoggingPositionLinks()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<LoggingPositionIdLink> getLoggingPositionLinks();

	/**
	 * Returns the value of the '<em><b>Internal Action Links</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.InternalActionLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Internal Action Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Internal Action Links</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository.PCMLinkRepositoryPackage#getPCMLinkRepository_InternalActionLinks()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<InternalActionLink> getInternalActionLinks();

	/**
	 * Returns the value of the '<em><b>Input Parameter Links</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.ParameterLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Parameter Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Parameter Links</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository.PCMLinkRepositoryPackage#getPCMLinkRepository_InputParameterLinks()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ParameterLink> getInputParameterLinks();

} // PCMLinkRepository
