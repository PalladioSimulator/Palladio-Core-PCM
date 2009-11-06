/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package measurements;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link measurements.SequenceTask#getTasks <em>Tasks</em>}</li>
 * </ul>
 * </p>
 *
 * @see measurements.MeasurementsPackage#getSequenceTask()
 * @model
 * @generated
 */
public interface SequenceTask extends AbstractTask {
	/**
	 * Returns the value of the '<em><b>Tasks</b></em>' containment reference list.
	 * The list contents are of type {@link measurements.AbstractTask}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tasks</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tasks</em>' containment reference list.
	 * @see measurements.MeasurementsPackage#getSequenceTask_Tasks()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<AbstractTask> getTasks();

} // SequenceTask
