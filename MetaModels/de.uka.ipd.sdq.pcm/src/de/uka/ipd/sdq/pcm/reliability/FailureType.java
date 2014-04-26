/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.reliability;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.repository.Repository;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Failure Type</b></em>'. <!--
 * end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 *     Abstract super class that&nbsp;provides a type definition for&nbsp;any failure-on-demand occurrence during service
 *     execution.&nbsp;
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.reliability.FailureType#getRepository__FailureType <em>Repository Failure Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.reliability.ReliabilityPackage#getFailureType()
 * @model abstract="true"
 * @generated
 */
public interface FailureType extends Entity {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * Returns the value of the '<em><b>Repository Failure Type</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.repository.Repository#getFailureTypes__Repository <em>Failure Types Repository</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Repository Failure Type</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Repository Failure Type</em>' container reference.
     * @see #setRepository__FailureType(Repository)
     * @see de.uka.ipd.sdq.pcm.reliability.ReliabilityPackage#getFailureType_Repository__FailureType()
     * @see de.uka.ipd.sdq.pcm.repository.Repository#getFailureTypes__Repository
     * @model opposite="failureTypes__Repository" required="true" transient="false" ordered="false"
     * @generated
     */
    Repository getRepository__FailureType();

    /**
     * Sets the value of the '{@link de.uka.ipd.sdq.pcm.reliability.FailureType#getRepository__FailureType <em>Repository Failure Type</em>}' container reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @param value the new value of the '<em>Repository Failure Type</em>' container reference.
     * @see #getRepository__FailureType()
     * @generated
     */
    void setRepository__FailureType(Repository value);

} // FailureType
