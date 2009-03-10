/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package eu.qimpress.commonmodel.commonmodel.StaticStructure;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The entity event port allows to model event-based communication. 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.EventPort#isIsSource <em>Is Source</em>}</li>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.EventPort#getMessage <em>Message</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage#getEventPort()
 * @model
 * @generated
 */
public interface EventPort extends Port {
	/**
	 * Returns the value of the '<em><b>Is Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Derived attribute isSource specifies type of EventPort (source or sink), is based on Port provided or required associations. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Source</em>' attribute.
	 * @see #setIsSource(boolean)
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage#getEventPort_IsSource()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean isIsSource();

	/**
	 * Sets the value of the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.EventPort#isIsSource <em>Is Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Source</em>' attribute.
	 * @see #isIsSource()
	 * @generated
	 */
	void setIsSource(boolean value);

	/**
	 * Returns the value of the '<em><b>Message</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The property message defines message type that fires the event.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Message</em>' reference.
	 * @see #setMessage(Message)
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage#getEventPort_Message()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Message getMessage();

	/**
	 * Sets the value of the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.EventPort#getMessage <em>Message</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' reference.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(Message value);

} // EventPort
