/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import edu.kit.ipd.sdq.mdsd.profiles.metamodelextension.EStereotypableObject;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Exception Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc --> This entity represents a type of an exception. <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.repository.ExceptionType#getExceptionName <em>Exception Name</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.repository.ExceptionType#getExceptionMessage <em>Exception Message
 * </em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getExceptionType()
 * @model
 * @extends EStereotypableObject
 * @generated
 */
public interface ExceptionType extends EStereotypableObject {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * Returns the value of the '<em><b>Exception Name</b></em>' attribute. <!-- begin-user-doc -->
     * <!-- end-user-doc --> <!-- begin-model-doc --> This property denotes the name of the
     * exception. In addition to the exception message, this is another piece of information that
     * can be used for identification of the exception that has appeared. <!-- end-model-doc -->
     *
     * @return the value of the '<em>Exception Name</em>' attribute.
     * @see #setExceptionName(String)
     * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getExceptionType_ExceptionName()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
    String getExceptionName();

    /**
     * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.ExceptionType#getExceptionName
     * <em>Exception Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Exception Name</em>' attribute.
     * @see #getExceptionName()
     * @generated
     */
    void setExceptionName(String value);

    /**
     * Returns the value of the '<em><b>Exception Message</b></em>' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc --> <!-- begin-model-doc --> This property holds the text message of
     * the exception. <!-- end-model-doc -->
     *
     * @return the value of the '<em>Exception Message</em>' attribute.
     * @see #setExceptionMessage(String)
     * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getExceptionType_ExceptionMessage()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
    String getExceptionMessage();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.pcm.repository.ExceptionType#getExceptionMessage
     * <em>Exception Message</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Exception Message</em>' attribute.
     * @see #getExceptionMessage()
     * @generated
     */
    void setExceptionMessage(String value);

} // ExceptionType
