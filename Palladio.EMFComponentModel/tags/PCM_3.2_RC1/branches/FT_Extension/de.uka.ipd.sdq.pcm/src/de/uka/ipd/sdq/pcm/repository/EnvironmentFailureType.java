/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Environment Failure Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.EnvironmentFailureType#getProcessingresourcetype <em>Processingresourcetype</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getEnvironmentFailureType()
 * @model
 * @generated
 */
public interface EnvironmentFailureType extends StopFailureType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Processingresourcetype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processingresourcetype</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processingresourcetype</em>' reference.
	 * @see #setProcessingresourcetype(ProcessingResourceType)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getEnvironmentFailureType_Processingresourcetype()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ProcessingResourceType getProcessingresourcetype();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.EnvironmentFailureType#getProcessingresourcetype <em>Processingresourcetype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Processingresourcetype</em>' reference.
	 * @see #getProcessingresourcetype()
	 * @generated
	 */
	void setProcessingresourcetype(ProcessingResourceType value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.processingresourcetype <> null
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.processingresourcetype <> null'"
	 * @generated
	 */
	boolean ExactlyOneType(DiagnosticChain diagnostics, Map<Object, Object> context);

} // EnvironmentFailureType
