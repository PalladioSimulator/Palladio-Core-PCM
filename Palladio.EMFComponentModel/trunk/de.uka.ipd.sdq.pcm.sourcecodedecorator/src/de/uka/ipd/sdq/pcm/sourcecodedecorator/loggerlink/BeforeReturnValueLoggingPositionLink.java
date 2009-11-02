/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink;

import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Before Return Value Logging Position Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BeforeReturnValueLoggingPositionLink#getServiceEffectSpecification <em>Service Effect Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage#getBeforeReturnValueLoggingPositionLink()
 * @model
 * @generated
 */
public interface BeforeReturnValueLoggingPositionLink extends OutputLoggingPositionLink {
	/**
	 * Returns the value of the '<em><b>Service Effect Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Effect Specification</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Effect Specification</em>' reference.
	 * @see #setServiceEffectSpecification(ServiceEffectSpecification)
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage#getBeforeReturnValueLoggingPositionLink_ServiceEffectSpecification()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ServiceEffectSpecification getServiceEffectSpecification();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BeforeReturnValueLoggingPositionLink#getServiceEffectSpecification <em>Service Effect Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Effect Specification</em>' reference.
	 * @see #getServiceEffectSpecification()
	 * @generated
	 */
	void setServiceEffectSpecification(ServiceEffectSpecification value);

} // BeforeReturnValueLoggingPositionLink
