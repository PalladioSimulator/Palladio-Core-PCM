/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package measurements;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link measurements.LoopTask#getNumberOfIterations <em>Number Of Iterations</em>}</li>
 *   <li>{@link measurements.LoopTask#getTask <em>Task</em>}</li>
 * </ul>
 * </p>
 *
 * @see measurements.MeasurementsPackage#getLoopTask()
 * @model
 * @generated
 */
public interface LoopTask extends AbstractTask {
	/**
	 * Returns the value of the '<em><b>Number Of Iterations</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Iterations</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Iterations</em>' attribute.
	 * @see #setNumberOfIterations(int)
	 * @see measurements.MeasurementsPackage#getLoopTask_NumberOfIterations()
	 * @model default="1" required="true" ordered="false"
	 * @generated
	 */
	int getNumberOfIterations();

	/**
	 * Sets the value of the '{@link measurements.LoopTask#getNumberOfIterations <em>Number Of Iterations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Iterations</em>' attribute.
	 * @see #getNumberOfIterations()
	 * @generated
	 */
	void setNumberOfIterations(int value);

	/**
	 * Returns the value of the '<em><b>Task</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task</em>' containment reference.
	 * @see #setTask(AbstractTask)
	 * @see measurements.MeasurementsPackage#getLoopTask_Task()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	AbstractTask getTask();

	/**
	 * Sets the value of the '{@link measurements.LoopTask#getTask <em>Task</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task</em>' containment reference.
	 * @see #getTask()
	 * @generated
	 */
	void setTask(AbstractTask value);

} // LoopTask
