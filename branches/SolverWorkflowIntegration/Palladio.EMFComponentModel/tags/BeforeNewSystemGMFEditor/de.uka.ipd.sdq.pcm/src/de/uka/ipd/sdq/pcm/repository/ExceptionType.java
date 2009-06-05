
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exception Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.ExceptionType#getExceptionName <em>Exception Name</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.ExceptionType#getExceptionMessage <em>Exception Message</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getExceptionType()
 * @model
 * @generated
 */
public interface ExceptionType extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * Returns the value of the '<em><b>Exception Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exception Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exception Name</em>' attribute.
	 * @see #setExceptionName(String)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getExceptionType_ExceptionName()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getExceptionName();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.ExceptionType#getExceptionName <em>Exception Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exception Name</em>' attribute.
	 * @see #getExceptionName()
	 * @generated
	 */
	void setExceptionName(String value);

	/**
	 * Returns the value of the '<em><b>Exception Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exception Message</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exception Message</em>' attribute.
	 * @see #setExceptionMessage(String)
	 * @see de.uka.ipd.sdq.pcm.repository.RepositoryPackage#getExceptionType_ExceptionMessage()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getExceptionMessage();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.repository.ExceptionType#getExceptionMessage <em>Exception Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exception Message</em>' attribute.
	 * @see #getExceptionMessage()
	 * @generated
	 */
	void setExceptionMessage(String value);

} // ExceptionType