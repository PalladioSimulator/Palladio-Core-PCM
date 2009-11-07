/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.measurements;

import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Machine Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.measurements.MachineMapping#getMachineReference <em>Machine Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.measurements.MeasurementsPackage#getMachineMapping()
 * @model
 * @generated
 */
public interface MachineMapping extends Identifier {
	/**
	 * Returns the value of the '<em><b>Machine Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Machine Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Machine Reference</em>' reference.
	 * @see #setMachineReference(MachineReference)
	 * @see de.uka.ipd.sdq.measurements.MeasurementsPackage#getMachineMapping_MachineReference()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	MachineReference getMachineReference();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.measurements.MachineMapping#getMachineReference <em>Machine Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Machine Reference</em>' reference.
	 * @see #getMachineReference()
	 * @generated
	 */
	void setMachineReference(MachineReference value);

} // MachineMapping
