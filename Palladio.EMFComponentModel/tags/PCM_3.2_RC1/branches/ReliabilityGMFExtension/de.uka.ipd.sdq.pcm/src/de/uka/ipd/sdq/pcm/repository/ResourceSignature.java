/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Signature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * TODO: This structure still has to be finalized by Henning. There is no influence on other model elements yet. so this can be done later on.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.ResourceSignature#getParameter__ResourceSignature <em>Parameter Resource Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getResourceSignature()
 * @model
 * @generated
 */
public interface ResourceSignature extends Signature {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Parameter Resource Signature</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.repository.Parameter#getResourceSignature__Parameter <em>Resource Signature Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Resource Signature</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Resource Signature</em>' containment reference.
	 * @see #setParameter__ResourceSignature(Parameter)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getResourceSignature_Parameter__ResourceSignature()
	 * @see de.uka.ipd.sdq.pcm.repository.Parameter#getResourceSignature__Parameter
	 * @model opposite="resourceSignature__Parameter" containment="true" required="true" ordered="false"
	 * @generated
	 */
	Parameter getParameter__ResourceSignature();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.ResourceSignature#getParameter__ResourceSignature <em>Parameter Resource Signature</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Resource Signature</em>' containment reference.
	 * @see #getParameter__ResourceSignature()
	 * @generated
	 */
	void setParameter__ResourceSignature(Parameter value);

} // ResourceSignature
