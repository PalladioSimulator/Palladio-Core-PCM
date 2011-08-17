/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink;

import de.fzi.gast.functions.Function;

import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.ParameterLink;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method Call Logging Position Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.MethodCallLoggingPositionLink#getLinkedServiceEffectSpecification <em>Linked Service Effect Specification</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.MethodCallLoggingPositionLink#getProvidedFunction <em>Provided Function</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.MethodCallLoggingPositionLink#getParameterLinks <em>Parameter Links</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage#getMethodCallLoggingPositionLink()
 * @model
 * @generated
 */
public interface MethodCallLoggingPositionLink extends InputLoggingPositionLink {
	/**
	 * Returns the value of the '<em><b>Linked Service Effect Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linked Service Effect Specification</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linked Service Effect Specification</em>' reference.
	 * @see #setLinkedServiceEffectSpecification(ResourceDemandingSEFF)
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage#getMethodCallLoggingPositionLink_LinkedServiceEffectSpecification()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ResourceDemandingSEFF getLinkedServiceEffectSpecification();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.MethodCallLoggingPositionLink#getLinkedServiceEffectSpecification <em>Linked Service Effect Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linked Service Effect Specification</em>' reference.
	 * @see #getLinkedServiceEffectSpecification()
	 * @generated
	 */
	void setLinkedServiceEffectSpecification(ResourceDemandingSEFF value);

	/**
	 * Returns the value of the '<em><b>Provided Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provided Function</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provided Function</em>' reference.
	 * @see #setProvidedFunction(Function)
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage#getMethodCallLoggingPositionLink_ProvidedFunction()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Function getProvidedFunction();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.MethodCallLoggingPositionLink#getProvidedFunction <em>Provided Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provided Function</em>' reference.
	 * @see #getProvidedFunction()
	 * @generated
	 */
	void setProvidedFunction(Function value);

	/**
	 * Returns the value of the '<em><b>Parameter Links</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.ParameterLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Links</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage#getMethodCallLoggingPositionLink_ParameterLinks()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ParameterLink> getParameterLinks();

} // MethodCallLoggingPositionLink
