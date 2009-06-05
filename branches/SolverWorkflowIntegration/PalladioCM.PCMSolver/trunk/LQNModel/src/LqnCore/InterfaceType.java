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
 * A representation of the model object '<em><b>Interface Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link LqnCore.InterfaceType#getInPort <em>In Port</em>}</li>
 *   <li>{@link LqnCore.InterfaceType#getOutPort <em>Out Port</em>}</li>
 * </ul>
 * </p>
 *
 * @see LqnCore.LqnCorePackage#getInterfaceType()
 * @model extendedMetaData="name='Interface_._type' kind='elementOnly'"
 * @generated
 */
public interface InterfaceType extends EObject {
	/**
	 * Returns the value of the '<em><b>In Port</b></em>' containment reference list.
	 * The list contents are of type {@link LqnCore.InPortType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Port</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Port</em>' containment reference list.
	 * @see LqnCore.LqnCorePackage#getInterfaceType_InPort()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='in-port' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<InPortType> getInPort();

	/**
	 * Returns the value of the '<em><b>Out Port</b></em>' containment reference list.
	 * The list contents are of type {@link LqnCore.OutPortType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Port</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Port</em>' containment reference list.
	 * @see LqnCore.LqnCorePackage#getInterfaceType_OutPort()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='out-port' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<OutPortType> getOutPort();

} // InterfaceType
