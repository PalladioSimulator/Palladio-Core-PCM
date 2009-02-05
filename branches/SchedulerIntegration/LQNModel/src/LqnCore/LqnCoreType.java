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
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link LqnCore.LqnCoreType#getProcessor <em>Processor</em>}</li>
 *   <li>{@link LqnCore.LqnCoreType#getSlot <em>Slot</em>}</li>
 * </ul>
 * </p>
 *
 * @see LqnCore.LqnCorePackage#getLqnCoreType()
 * @model extendedMetaData="name='Lqn-CoreType' kind='elementOnly'"
 * @generated
 */
public interface LqnCoreType extends EObject {
	/**
	 * Returns the value of the '<em><b>Processor</b></em>' containment reference list.
	 * The list contents are of type {@link LqnCore.ProcessorType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processor</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processor</em>' containment reference list.
	 * @see LqnCore.LqnCorePackage#getLqnCoreType_Processor()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='processor' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ProcessorType> getProcessor();

	/**
	 * Returns the value of the '<em><b>Slot</b></em>' containment reference list.
	 * The list contents are of type {@link LqnCore.SlotType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slot</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slot</em>' containment reference list.
	 * @see LqnCore.LqnCorePackage#getLqnCoreType_Slot()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='slot' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<SlotType> getSlot();

} // LqnCoreType
