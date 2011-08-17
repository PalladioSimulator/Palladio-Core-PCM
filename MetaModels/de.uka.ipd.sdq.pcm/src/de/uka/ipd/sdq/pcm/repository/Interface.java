
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
 * A representation of the model object '<em><b>Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.Interface#getParentInterface__Interface <em>Parent Interface Interface</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.Interface#getAnchestorInterfaces <em>Anchestor Interfaces</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.Interface#getProtocols__Interface <em>Protocols Interface</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.Interface#getSignatures__Interface <em>Signatures Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getInterface()
 * @model
 * @generated
 */
public interface Interface extends Entity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * Returns the value of the '<em><b>Parent Interface Interface</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.repository.Interface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Interface Interface</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Interface Interface</em>' reference list.
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getInterface_ParentInterface__Interface()
	 * @model type="de.uka.ipd.sdq.pcm.repository.Interface" ordered="false"
	 * @generated
	 */
	EList getParentInterface__Interface();

	/**
	 * Returns the value of the '<em><b>Anchestor Interfaces</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.repository.Interface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Anchestor Interfaces</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Anchestor Interfaces</em>' reference list.
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getInterface_AnchestorInterfaces()
	 * @model type="de.uka.ipd.sdq.pcm.repository.Interface" ordered="false"
	 * @generated
	 */
	EList getAnchestorInterfaces();

	/**
	 * Returns the value of the '<em><b>Protocols Interface</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.protocol.Protocol}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Protocols Interface</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Protocols Interface</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getInterface_Protocols__Interface()
	 * @model type="de.uka.ipd.sdq.pcm.protocol.Protocol" containment="true" ordered="false"
	 * @generated
	 */
	EList getProtocols__Interface();

	/**
	 * Returns the value of the '<em><b>Signatures Interface</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.repository.Signature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signatures Interface</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signatures Interface</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getInterface_Signatures__Interface()
	 * @model type="de.uka.ipd.sdq.pcm.repository.Signature" containment="true" ordered="false"
	 * @generated
	 */
	EList getSignatures__Interface();


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.protocols->forAll(p1, p2 |
	 * p1.protocolTypeID <> p2.protocolTypeID)
	 * 
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean noProtocolTypeIDUsedTwice(DiagnosticChain diagnostics, Map context);


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * -- full signature has to be unique 
	 * -- (use of ocl-tupels) #
	 * let sigs : Bag(
	 *  -- parameters: Sequence of DataType, NOT name #
	 *  -- exceptions have not to be considered #
	 *  Tuple(returnType : DataType, serviceName : String, parameters : Sequence(DataType) ) 
	 * ) = 
	 * self.signatures->collect(sig : Signature |
	 *  Tuple{
	 *   returnType : DataType = sig.returntype,
	 *   serviceName : String = sig.serviceName,
	 *   parameters : Sequence(DataType) = sig.parameters.datatype
	 *  }
	 * )
	 * in
	 * sigs->isUnique(sigs)
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean SignaturesHaveToBeUniqueForAnInterface(DiagnosticChain diagnostics, Map context);

} // Interface