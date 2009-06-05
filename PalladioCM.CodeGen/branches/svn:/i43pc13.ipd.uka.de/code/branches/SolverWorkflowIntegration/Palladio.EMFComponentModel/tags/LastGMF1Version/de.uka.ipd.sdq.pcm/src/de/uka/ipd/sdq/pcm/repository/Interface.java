
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
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.Interface#getAnchestorInterfaces_Interface <em>Anchestor Interfaces Interface</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.Interface#getProtocols__Interface <em>Protocols Interface</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.Interface#getSignatures__Interface <em>Signatures Interface</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.Interface#getRepository_Interface <em>Repository Interface</em>}</li>
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
	 * Returns the value of the '<em><b>Anchestor Interfaces Interface</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.repository.Interface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Anchestor Interfaces Interface</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Anchestor Interfaces Interface</em>' reference list.
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getInterface_AnchestorInterfaces_Interface()
	 * @model type="de.uka.ipd.sdq.pcm.repository.Interface" ordered="false"
	 * @generated
	 */
	EList getAnchestorInterfaces_Interface();

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
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.repository.Signature#getInterface_Signature <em>Interface Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signatures Interface</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signatures Interface</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getInterface_Signatures__Interface()
	 * @see de.uka.ipd.sdq.pcm.repository.Signature#getInterface_Signature
	 * @model type="de.uka.ipd.sdq.pcm.repository.Signature" opposite="interface_Signature" containment="true" ordered="false"
	 * @generated
	 */
	EList getSignatures__Interface();

	/**
	 * Returns the value of the '<em><b>Repository Interface</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.repository.Repository#getInterfaces__Repository <em>Interfaces Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repository Interface</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository Interface</em>' container reference.
	 * @see #setRepository_Interface(Repository)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getInterface_Repository_Interface()
	 * @see de.uka.ipd.sdq.pcm.repository.Repository#getInterfaces__Repository
	 * @model opposite="interfaces__Repository" required="true" ordered="false"
	 * @generated
	 */
	Repository getRepository_Interface();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.Interface#getRepository_Interface <em>Repository Interface</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repository Interface</em>' container reference.
	 * @see #getRepository_Interface()
	 * @generated
	 */
	void setRepository_Interface(Repository value);


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.protocols__Interface->forAll(p1, p2 |
	 * p1.protocolTypeID <> p2.protocolTypeID)
	 * 
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean NoProtocolTypeIDUsedTwice(DiagnosticChain diagnostics, Map context);


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
	 * self.signatures__Interface->collect(sig : Signature |
	 *  Tuple{
	 *   returnType : DataType = sig.returntype__Signature,
	 *   serviceName : String = sig.serviceName,
	 *   parameters : Sequence(DataType) = sig.parameters__Signature.datatype__Parameter
	 *  }
	 * )
	 * in
	 * sigs->forAll(s|sigs->isUnique(s))
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean SignaturesHaveToBeUniqueForAnInterface(DiagnosticChain diagnostics, Map context);

} // Interface