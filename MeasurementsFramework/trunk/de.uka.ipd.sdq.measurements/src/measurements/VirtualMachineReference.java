/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package measurements;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Virtual Machine Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link measurements.VirtualMachineReference#getHostMachine <em>Host Machine</em>}</li>
 * </ul>
 * </p>
 *
 * @see measurements.MeasurementsPackage#getVirtualMachineReference()
 * @model
 * @generated
 */
public interface VirtualMachineReference extends MachineReference {
	/**
	 * Returns the value of the '<em><b>Host Machine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Host Machine</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Host Machine</em>' reference.
	 * @see #setHostMachine(PlainMachineReference)
	 * @see measurements.MeasurementsPackage#getVirtualMachineReference_HostMachine()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	PlainMachineReference getHostMachine();

	/**
	 * Sets the value of the '{@link measurements.VirtualMachineReference#getHostMachine <em>Host Machine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Host Machine</em>' reference.
	 * @see #getHostMachine()
	 * @generated
	 */
	void setHostMachine(PlainMachineReference value);

} // VirtualMachineReference
