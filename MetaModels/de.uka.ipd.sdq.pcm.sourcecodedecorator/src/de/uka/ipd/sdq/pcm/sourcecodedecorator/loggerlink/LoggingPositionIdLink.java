/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink;

import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Logging Position Id Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggingPositionIdLink#getLoggingPositionId <em>Logging Position Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage#getLoggingPositionIdLink()
 * @model abstract="true"
 * @generated
 */
public interface LoggingPositionIdLink extends Identifier {
	/**
	 * Returns the value of the '<em><b>Logging Position Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Logging Position Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Logging Position Id</em>' attribute.
	 * @see #setLoggingPositionId(String)
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage#getLoggingPositionIdLink_LoggingPositionId()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getLoggingPositionId();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggingPositionIdLink#getLoggingPositionId <em>Logging Position Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Logging Position Id</em>' attribute.
	 * @see #getLoggingPositionId()
	 * @generated
	 */
	void setLoggingPositionId(String value);

} // LoggingPositionIdLink
