/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
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
 * <!-- begin-model-doc -->
 * <p>
 *     This&nbsp;entity&nbsp;represents&nbsp;the&nbsp;signature&nbsp;of&nbsp;a&nbsp;method,&nbsp;i.e.,&nbsp;its&nbsp;parameters,&nbsp;exception&nbsp;declarations,&nbsp;return&nbsp;type,&nbsp;etc.<br />
 *     <br />
 *     Every&nbsp;service&nbsp;of&nbsp;an&nbsp;interface&nbsp;has&nbsp;a&nbsp;unique&nbsp;signature,&nbsp;like&nbsp;void&nbsp;doSomething(int&nbsp;a).&nbsp;A&nbsp;PCM&nbsp;signature&nbsp;is&nbsp;comparable&nbsp;to&nbsp;a&nbsp;method&nbsp;signature&nbsp;in&nbsp;programming&nbsp;languages&nbsp;like&nbsp;C#,&nbsp;Java&nbsp;or&nbsp;the&nbsp;OMG&nbsp;IDL.<br />
 *     <br />
 *     It&nbsp;contains:<br />
 *     <br />
 *     *&nbsp;A&nbsp;type&nbsp;of&nbsp;the&nbsp;return&nbsp;value&nbsp;or&nbsp;void&nbsp;(no&nbsp;return&nbsp;value),<br />
 *     <br />
 *     *&nbsp;an&nbsp;identifier&nbsp;naming&nbsp;the&nbsp;service,<br />
 *     <br />
 *     *&nbsp;an&nbsp;ordered&nbsp;set&nbsp;of&nbsp;parameters&nbsp;(0..*).Each&nbsp;parameter&nbsp;is&nbsp;a&nbsp;tuple&nbsp;of&nbsp;a&nbsp;datatype&nbsp;and&nbsp;an&nbsp;identifier&nbsp;(which&nbsp;is&nbsp;unique&nbsp;across&nbsp;the&nbsp;parameters).&nbsp;Additionally,&nbsp;the&nbsp;modifiers&nbsp;in,&nbsp;out,&nbsp;and&nbsp;inout&nbsp;(with&nbsp;its&nbsp;OMG<br />
 *     IDL&nbsp;semantics)&nbsp;can&nbsp;be&nbsp;used&nbsp;for&nbsp;parameters,&nbsp;and<br />
 *     <br />
 *     *&nbsp;an&nbsp;unordered&nbsp;set&nbsp;of&nbsp;exceptions.<br />
 *     <br />
 *     A&nbsp;signature&nbsp;has&nbsp;to&nbsp;be&nbsp;unique&nbsp;for&nbsp;an&nbsp;interface&nbsp;through&nbsp;the&nbsp;tupel&nbsp;(identifier,&nbsp;order&nbsp;of&nbsp;parameters).&nbsp;An&nbsp;interface&nbsp;has&nbsp;a&nbsp;list&nbsp;of&nbsp;1..*&nbsp;signatures&nbsp;(interfaces&nbsp;associate&nbsp;1..*&nbsp;signatures,&nbsp;not&nbsp;the&nbsp;other&nbsp;way&nbsp;around).&nbsp;A<br />
 *     signature&nbsp;is&nbsp;assigned&nbsp;to&nbsp;exactly&nbsp;one&nbsp;interface.&nbsp;However,&nbsp;different&nbsp;interfaces&nbsp;can&nbsp;define&nbsp;equally&nbsp;named&nbsp;signatures.&nbsp;If,&nbsp;for&nbsp;example,&nbsp;void&nbsp;doIt()&nbsp;is&nbsp;defined&nbsp;for&nbsp;interface&nbsp;A&nbsp;and&nbsp;B,&nbsp;void&nbsp;doIt()&nbsp;is&nbsp;not&nbsp;identical&nbsp;in&nbsp;both&nbsp;interfaces.
 * </p>
 * <p>
 *     Failure that may occur inside external services must be specified at the service signatures. This way components that
 *     use this services may implement failure handling without knowing the internal behaviour of the connected component.
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.Signature#getServiceName <em>Service Name</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.Signature#getParameters__Signature <em>Parameters Signature</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.Signature#getReturntype__Signature <em>Returntype Signature</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.Signature#getExceptions__Signature <em>Exceptions Signature</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.Signature#getFailureType <em>Failure Type</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.Signature#getInterface_Signature <em>Interface Signature</em>}</li>
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
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Service Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This property represents the service name realized by this method.
	 * <!-- end-model-doc -->
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
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.repository.Parameter#getSignature_Parameter <em>Signature Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters Signature</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This property represents the list of parameters of the corresponding method.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Parameters Signature</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getSignature_Parameters__Signature()
	 * @see de.uka.ipd.sdq.pcm.repository.Parameter#getSignature_Parameter
	 * @model opposite="signature_Parameter" containment="true"
	 * @generated
	 */
	EList<Parameter> getParameters__Signature();

	/**
	 * Returns the value of the '<em><b>Interface Signature</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.repository.Interface#getSignatures__Interface <em>Signatures Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interface Signature</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This property represents the interface that contains the method with this signature.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Interface Signature</em>' container reference.
	 * @see #setInterface_Signature(Interface)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getSignature_Interface_Signature()
	 * @see de.uka.ipd.sdq.pcm.repository.Interface#getSignatures__Interface
	 * @model opposite="signatures__Interface" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Interface getInterface_Signature();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.Signature#getInterface_Signature <em>Interface Signature</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface Signature</em>' container reference.
	 * @see #getInterface_Signature()
	 * @generated
	 */
	void setInterface_Signature(Interface value);

	/**
	 * Returns the value of the '<em><b>Returntype Signature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Returntype Signature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This property represents the return type of the corresponding method.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Returntype Signature</em>' reference.
	 * @see #setReturntype__Signature(DataType)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getSignature_Returntype__Signature()
	 * @model ordered="false"
	 * @generated
	 */
	DataType getReturntype__Signature();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.Signature#getReturntype__Signature <em>Returntype Signature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Returntype Signature</em>' reference.
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
	 * <!-- begin-model-doc -->
	 * This property represents the list of exceptions declared by this signature.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Exceptions Signature</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getSignature_Exceptions__Signature()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ExceptionType> getExceptions__Signature();

	/**
	 * Returns the value of the '<em><b>Failure Type</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.repository.FailureType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Failure Type</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Failure Type</em>' reference list.
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getSignature_FailureType()
	 * @model ordered="false"
	 * @generated
	 */
	EList<FailureType> getFailureType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.parameters__Signature->isUnique(p : Parameter |
	 * 	p.parameterName
	 * )
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.parameters__Signature->isUnique(p : Parameter |\r\n\tp.parameterName\r\n)'"
	 * @generated
	 */
	boolean ParameterNamesHaveToBeUniqueForASignature(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Signature
