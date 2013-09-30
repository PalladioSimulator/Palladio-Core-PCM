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
 * A representation of the model object '<em><b>Bind Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link LqnCore.BindType#getParameter <em>Parameter</em>}</li>
 *   <li>{@link LqnCore.BindType#getProcessorBinding <em>Processor Binding</em>}</li>
 *   <li>{@link LqnCore.BindType#getPortBinding <em>Port Binding</em>}</li>
 * </ul>
 * </p>
 *
 * @see LqnCore.LqnCorePackage#getBindType()
 * @model extendedMetaData="name='BindType' kind='elementOnly'"
 * @generated
 */
public interface BindType extends EObject {
	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' containment reference list.
	 * The list contents are of type {@link LqnCore.ParameterType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' containment reference list.
	 * @see LqnCore.LqnCorePackage#getBindType_Parameter()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='parameter' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ParameterType> getParameter();

	/**
	 * Returns the value of the '<em><b>Processor Binding</b></em>' containment reference list.
	 * The list contents are of type {@link LqnCore.ProcessorBindingType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processor Binding</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processor Binding</em>' containment reference list.
	 * @see LqnCore.LqnCorePackage#getBindType_ProcessorBinding()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='processor-binding' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ProcessorBindingType> getProcessorBinding();

	/**
	 * Returns the value of the '<em><b>Port Binding</b></em>' containment reference list.
	 * The list contents are of type {@link LqnCore.PortBindingType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port Binding</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port Binding</em>' containment reference list.
	 * @see LqnCore.LqnCorePackage#getBindType_PortBinding()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='port-binding' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<PortBindingType> getPortBinding();

} // BindType
