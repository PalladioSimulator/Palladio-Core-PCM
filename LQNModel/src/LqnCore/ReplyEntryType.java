/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package LqnCore;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reply Entry Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link LqnCore.ReplyEntryType#getReplyActivity <em>Reply Activity</em>}</li>
 *   <li>{@link LqnCore.ReplyEntryType#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see LqnCore.LqnCorePackage#getReplyEntryType()
 * @model extendedMetaData="name='reply-entry_._type' kind='elementOnly'"
 * @generated
 */
public interface ReplyEntryType extends EObject {
	/**
	 * Returns the value of the '<em><b>Reply Activity</b></em>' containment reference list.
	 * The list contents are of type {@link LqnCore.ReplyActivityType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reply Activity</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reply Activity</em>' containment reference list.
	 * @see LqnCore.LqnCorePackage#getReplyEntryType_ReplyActivity()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='reply-activity' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ReplyActivityType> getReplyActivity();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see LqnCore.LqnCorePackage#getReplyEntryType_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='name' namespace='##targetNamespace'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link LqnCore.ReplyEntryType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // ReplyEntryType
