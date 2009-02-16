/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package LqnCore;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Out Port Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link LqnCore.OutPortType#getConnectTo <em>Connect To</em>}</li>
 *   <li>{@link LqnCore.OutPortType#getDescription <em>Description</em>}</li>
 *   <li>{@link LqnCore.OutPortType#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see LqnCore.LqnCorePackage#getOutPortType()
 * @model extendedMetaData="name='out-port_._type' kind='empty'"
 * @generated
 */
public interface OutPortType extends EObject {
	/**
	 * Returns the value of the '<em><b>Connect To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connect To</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connect To</em>' attribute.
	 * @see #setConnectTo(List)
	 * @see LqnCore.LqnCorePackage#getOutPortType_ConnectTo()
	 * @model dataType="LqnCore.ConnectToType" many="false"
	 *        extendedMetaData="kind='attribute' name='connect-to' namespace='##targetNamespace'"
	 * @generated
	 */
	List<String> getConnectTo();

	/**
	 * Sets the value of the '{@link LqnCore.OutPortType#getConnectTo <em>Connect To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connect To</em>' attribute.
	 * @see #getConnectTo()
	 * @generated
	 */
	void setConnectTo(List<String> value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see LqnCore.LqnCorePackage#getOutPortType_Description()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='description' namespace='##targetNamespace'"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link LqnCore.OutPortType#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

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
	 * @see LqnCore.LqnCorePackage#getOutPortType_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='name' namespace='##targetNamespace'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link LqnCore.OutPortType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // OutPortType
