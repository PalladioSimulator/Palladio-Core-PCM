
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Signature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.Signature#getServiceName <em>Service Name</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.Signature#getParameters__Signature <em>Parameters Signature</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.Signature#getReturntype__Signature <em>Returntype Signature</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.Signature#getExceptions__Signature <em>Exceptions Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getSignature()
 * @model
 * @generated
 */
public interface Signature extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * Returns the value of the '<em><b>Service Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Name</em>' attribute.
	 * @see #setServiceName(String)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getSignature_ServiceName()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getServiceName();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.Signature#getServiceName <em>Service Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Name</em>' attribute.
	 * @see #getServiceName()
	 * @generated
	 */
	void setServiceName(String value);

	/**
	 * Returns the value of the '<em><b>Parameters Signature</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.repository.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters Signature</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters Signature</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getSignature_Parameters__Signature()
	 * @model type="de.uka.ipd.sdq.pcm.repository.Parameter" containment="true"
	 * @generated
	 */
	EList getParameters__Signature();

	/**
	 * Returns the value of the '<em><b>Returntype Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Returntype Signature</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Returntype Signature</em>' containment reference.
	 * @see #setReturntype__Signature(DataType)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getSignature_Returntype__Signature()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	DataType getReturntype__Signature();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.Signature#getReturntype__Signature <em>Returntype Signature</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Returntype Signature</em>' containment reference.
	 * @see #getReturntype__Signature()
	 * @generated
	 */
	void setReturntype__Signature(DataType value);

	/**
	 * Returns the value of the '<em><b>Exceptions Signature</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.repository.ExceptionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exceptions Signature</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exceptions Signature</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getSignature_Exceptions__Signature()
	 * @model type="de.uka.ipd.sdq.pcm.repository.ExceptionType" containment="true" ordered="false"
	 * @generated
	 */
	EList getExceptions__Signature();


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.parameters__Signature->isUnique(p : Parameter |
	 *  p.parameterName
	 * )
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean ParameterNamesHaveToBeUniqueForASignature(DiagnosticChain diagnostics, Map context);

} // Signature