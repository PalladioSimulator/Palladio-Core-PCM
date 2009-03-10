/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package eu.qimpress.commonmodel.commonmodel.StaticStructure;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exception</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The entity exception defines thrown exception by operation. Each Operation can throw a Exceptions. 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Exception#getExceptionMessage <em>Exception Message</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage#getException()
 * @model
 * @generated
 */
public interface Exception extends NamedEntity {
	/**
	 * Returns the value of the '<em><b>Exception Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The property defines Error message.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Exception Message</em>' attribute.
	 * @see #setExceptionMessage(String)
	 * @see eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage#getException_ExceptionMessage()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getExceptionMessage();

	/**
	 * Sets the value of the '{@link eu.qimpress.commonmodel.commonmodel.StaticStructure.Exception#getExceptionMessage <em>Exception Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exception Message</em>' attribute.
	 * @see #getExceptionMessage()
	 * @generated
	 */
	void setExceptionMessage(String value);

} // Exception
