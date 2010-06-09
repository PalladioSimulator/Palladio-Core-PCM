/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.parameter.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Signature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.OperationSignature#getParameters__OperationSignature <em>Parameters Operation Signature</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.OperationSignature#getReturntype__OperationSignature <em>Returntype Operation Signature</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.OperationSignature#getInterface__OperationSignature <em>Interface Operation Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getOperationSignature()
 * @model
 * @generated
 */
public interface OperationSignature extends Signature {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Parameters Operation Signature</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.parameter.Variable}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.parameter.Variable#getOperationSignature__Variable <em>Operation Signature Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This property represents the list of parameters of the corresponding method.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Parameters Operation Signature</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getOperationSignature_Parameters__OperationSignature()
	 * @see de.uka.ipd.sdq.pcm.parameter.Variable#getOperationSignature__Variable
	 * @model opposite="operationSignature__Variable" containment="true"
	 * @generated
	 */
	EList<Variable> getParameters__OperationSignature();

	/**
	 * Returns the value of the '<em><b>Returntype Operation Signature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This property represents the return type of the corresponding method.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Returntype Operation Signature</em>' reference.
	 * @see #setReturntype__OperationSignature(Variable)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getOperationSignature_Returntype__OperationSignature()
	 * @model ordered="false"
	 * @generated
	 */
	Variable getReturntype__OperationSignature();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.OperationSignature#getReturntype__OperationSignature <em>Returntype Operation Signature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Returntype Operation Signature</em>' reference.
	 * @see #getReturntype__OperationSignature()
	 * @generated
	 */
	void setReturntype__OperationSignature(Variable value);

	/**
	 * Returns the value of the '<em><b>Interface Operation Signature</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.repository.OperationInterface#getSignatures__OperationInterface <em>Signatures Operation Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This property represents the interface that contains the method with this signature.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Interface Operation Signature</em>' container reference.
	 * @see #setInterface__OperationSignature(OperationInterface)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getOperationSignature_Interface__OperationSignature()
	 * @see de.uka.ipd.sdq.pcm.repository.OperationInterface#getSignatures__OperationInterface
	 * @model opposite="signatures__OperationInterface" required="true" transient="false" ordered="false"
	 * @generated
	 */
	OperationInterface getInterface__OperationSignature();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.OperationSignature#getInterface__OperationSignature <em>Interface Operation Signature</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interface Operation Signature</em>' container reference.
	 * @see #getInterface__OperationSignature()
	 * @generated
	 */
	void setInterface__OperationSignature(OperationInterface value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.parameters__OperationSignature->isUnique(v : Variable |
	 * 	v.entityName
	 * )
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.parameters__OperationSignature->isUnique(v : Variable |\r\n\tv.entityName\r\n)'"
	 * @generated
	 */
	boolean ParameterNamesHaveToBeUniqueForASignature(DiagnosticChain diagnostics, Map<Object, Object> context);

} // OperationSignature
