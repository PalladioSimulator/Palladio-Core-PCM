/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.measurements;

import de.uka.ipd.sdq.identifier.Identifier;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Machine Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.measurements.MachineDescription#getName <em>Name</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.measurements.MachineDescription#getIp <em>Ip</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.measurements.MachineDescription#getMachineMappings <em>Machine Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.measurements.MeasurementsPackage#getMachineDescription()
 * @model
 * @generated
 */
public interface MachineDescription extends Identifier {
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
	 * @see de.uka.ipd.sdq.measurements.MeasurementsPackage#getMachineDescription_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.measurements.MachineDescription#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Ip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ip</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ip</em>' attribute.
	 * @see #setIp(String)
	 * @see de.uka.ipd.sdq.measurements.MeasurementsPackage#getMachineDescription_Ip()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getIp();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.measurements.MachineDescription#getIp <em>Ip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ip</em>' attribute.
	 * @see #getIp()
	 * @generated
	 */
	void setIp(String value);

	/**
	 * Returns the value of the '<em><b>Machine Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.measurements.MachineMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Machine Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Machine Mappings</em>' containment reference list.
	 * @see de.uka.ipd.sdq.measurements.MeasurementsPackage#getMachineDescription_MachineMappings()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<MachineMapping> getMachineMappings();

} // MachineDescription
