/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra;

import de.uka.ipd.sdq.capra.core.Identifier;
import de.uka.ipd.sdq.capra.core.ReplicatedProcess;

import de.uka.ipd.sdq.capra.measurement.Sensor;

import de.uka.ipd.sdq.capra.resources.Resource;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.CapraModel#getProcesses <em>Processes</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.CapraModel#getResources <em>Resources</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.CapraModel#getIdentifiers <em>Identifiers</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.CapraModel#getSensors <em>Sensors</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.CapraPackage#getCapraModel()
 * @model
 * @generated
 */
public interface CapraModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Processes</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.capra.core.ReplicatedProcess}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processes</em>' containment reference list.
	 * @see de.uka.ipd.sdq.capra.CapraPackage#getCapraModel_Processes()
	 * @model containment="true"
	 * @generated
	 */
	EList<ReplicatedProcess> getProcesses();

	/**
	 * Returns the value of the '<em><b>Resources</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.capra.resources.Resource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resources</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources</em>' containment reference list.
	 * @see de.uka.ipd.sdq.capra.CapraPackage#getCapraModel_Resources()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Resource> getResources();

	/**
	 * Returns the value of the '<em><b>Identifiers</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.capra.core.Identifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifiers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifiers</em>' containment reference list.
	 * @see de.uka.ipd.sdq.capra.CapraPackage#getCapraModel_Identifiers()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Identifier> getIdentifiers();

	/**
	 * Returns the value of the '<em><b>Sensors</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.capra.measurement.Sensor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sensors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sensors</em>' containment reference list.
	 * @see de.uka.ipd.sdq.capra.CapraPackage#getCapraModel_Sensors()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Sensor> getSensors();

} // CapraModel
