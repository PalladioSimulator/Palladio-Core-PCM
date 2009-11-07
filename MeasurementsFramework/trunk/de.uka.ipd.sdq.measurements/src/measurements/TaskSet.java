/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package measurements;

import de.uka.ipd.sdq.identifier.Identifier;

import de.uka.ipd.sdq.probespec.ProbeSpecRepository;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link measurements.TaskSet#getName <em>Name</em>}</li>
 *   <li>{@link measurements.TaskSet#getRootTask <em>Root Task</em>}</li>
 *   <li>{@link measurements.TaskSet#getProbeSpecRepository <em>Probe Spec Repository</em>}</li>
 *   <li>{@link measurements.TaskSet#getMachineReferences <em>Machine References</em>}</li>
 * </ul>
 * </p>
 *
 * @see measurements.MeasurementsPackage#getTaskSet()
 * @model
 * @generated
 */
public interface TaskSet extends Identifier {
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
	 * @see measurements.MeasurementsPackage#getTaskSet_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link measurements.TaskSet#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Root Task</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Task</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root Task</em>' containment reference.
	 * @see #setRootTask(AbstractTask)
	 * @see measurements.MeasurementsPackage#getTaskSet_RootTask()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	AbstractTask getRootTask();

	/**
	 * Sets the value of the '{@link measurements.TaskSet#getRootTask <em>Root Task</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root Task</em>' containment reference.
	 * @see #getRootTask()
	 * @generated
	 */
	void setRootTask(AbstractTask value);

	/**
	 * Returns the value of the '<em><b>Probe Spec Repository</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Probe Spec Repository</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Probe Spec Repository</em>' containment reference.
	 * @see #setProbeSpecRepository(ProbeSpecRepository)
	 * @see measurements.MeasurementsPackage#getTaskSet_ProbeSpecRepository()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	ProbeSpecRepository getProbeSpecRepository();

	/**
	 * Sets the value of the '{@link measurements.TaskSet#getProbeSpecRepository <em>Probe Spec Repository</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Probe Spec Repository</em>' containment reference.
	 * @see #getProbeSpecRepository()
	 * @generated
	 */
	void setProbeSpecRepository(ProbeSpecRepository value);

	/**
	 * Returns the value of the '<em><b>Machine References</b></em>' containment reference list.
	 * The list contents are of type {@link measurements.MachineReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Machine References</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Machine References</em>' containment reference list.
	 * @see measurements.MeasurementsPackage#getTaskSet_MachineReferences()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<MachineReference> getMachineReferences();

} // TaskSet
