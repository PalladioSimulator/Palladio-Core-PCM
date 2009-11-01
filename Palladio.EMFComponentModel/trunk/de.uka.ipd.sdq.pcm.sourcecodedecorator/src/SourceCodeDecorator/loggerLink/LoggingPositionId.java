/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SourceCodeDecorator.loggerLink;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Logging Position Id</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link SourceCodeDecorator.loggerLink.LoggingPositionId#getLoggingPositionId <em>Logging Position Id</em>}</li>
 *   <li>{@link SourceCodeDecorator.loggerLink.LoggingPositionId#getServiceEffectSpecification <em>Service Effect Specification</em>}</li>
 *   <li>{@link SourceCodeDecorator.loggerLink.LoggingPositionId#getAbstractAction <em>Abstract Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see SourceCodeDecorator.loggerLink.LoggerLinkPackage#getLoggingPositionId()
 * @model
 * @generated
 */
public interface LoggingPositionId extends EObject {
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
	 * @see SourceCodeDecorator.loggerLink.LoggerLinkPackage#getLoggingPositionId_LoggingPositionId()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getLoggingPositionId();

	/**
	 * Sets the value of the '{@link SourceCodeDecorator.loggerLink.LoggingPositionId#getLoggingPositionId <em>Logging Position Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Logging Position Id</em>' attribute.
	 * @see #getLoggingPositionId()
	 * @generated
	 */
	void setLoggingPositionId(String value);

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
	 * @see SourceCodeDecorator.loggerLink.LoggerLinkPackage#getLoggingPositionId_ServiceEffectSpecification()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ServiceEffectSpecification getServiceEffectSpecification();

	/**
	 * Sets the value of the '{@link SourceCodeDecorator.loggerLink.LoggingPositionId#getServiceEffectSpecification <em>Service Effect Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Effect Specification</em>' reference.
	 * @see #getServiceEffectSpecification()
	 * @generated
	 */
	void setServiceEffectSpecification(ServiceEffectSpecification value);

	/**
	 * Returns the value of the '<em><b>Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract Action</em>' reference.
	 * @see #setAbstractAction(AbstractAction)
	 * @see SourceCodeDecorator.loggerLink.LoggerLinkPackage#getLoggingPositionId_AbstractAction()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AbstractAction getAbstractAction();

	/**
	 * Sets the value of the '{@link SourceCodeDecorator.loggerLink.LoggingPositionId#getAbstractAction <em>Abstract Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract Action</em>' reference.
	 * @see #getAbstractAction()
	 * @generated
	 */
	void setAbstractAction(AbstractAction value);

} // LoggingPositionId
