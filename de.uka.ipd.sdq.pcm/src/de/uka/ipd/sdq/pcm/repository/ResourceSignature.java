/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import de.uka.ipd.sdq.pcm.parameter.Variable;

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
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.ResourceSignature#getResourceInterface__ResourceSignature <em>Resource Interface Resource Signature</em>}</li>
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
	 * Returns the value of the '<em><b>Resource Interface Resource Signature</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.repository.ResourceInterface#getResourceSignatures__ResourceInterface <em>Resource Signatures Resource Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Interface Resource Signature</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Interface Resource Signature</em>' container reference.
	 * @see #setResourceInterface__ResourceSignature(ResourceInterface)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getResourceSignature_ResourceInterface__ResourceSignature()
	 * @see de.uka.ipd.sdq.pcm.repository.ResourceInterface#getResourceSignatures__ResourceInterface
	 * @model opposite="resourceSignatures__ResourceInterface" required="true" transient="false" ordered="false"
	 * @generated
	 */
	ResourceInterface getResourceInterface__ResourceSignature();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.ResourceSignature#getResourceInterface__ResourceSignature <em>Resource Interface Resource Signature</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Interface Resource Signature</em>' container reference.
	 * @see #getResourceInterface__ResourceSignature()
	 * @generated
	 */
	void setResourceInterface__ResourceSignature(ResourceInterface value);

	/**
	 * Returns the value of the '<em><b>Parameter Resource Signature</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.parameter.Variable#getResourceSignature__Variable <em>Resource Signature Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Resource Signature</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Resource Signature</em>' containment reference.
	 * @see #setParameter__ResourceSignature(Variable)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getResourceSignature_Parameter__ResourceSignature()
	 * @see de.uka.ipd.sdq.pcm.parameter.Variable#getResourceSignature__Variable
	 * @model opposite="resourceSignature__Variable" containment="true" required="true" ordered="false"
	 * @generated
	 */
	Variable getParameter__ResourceSignature();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.ResourceSignature#getParameter__ResourceSignature <em>Parameter Resource Signature</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Resource Signature</em>' containment reference.
	 * @see #getParameter__ResourceSignature()
	 * @generated
	 */
	void setParameter__ResourceSignature(Variable value);

} // ResourceSignature
