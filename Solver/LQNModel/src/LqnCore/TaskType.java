/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package LqnCore;

import java.math.BigInteger;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link LqnCore.TaskType#getResultTask <em>Result Task</em>}</li>
 *   <li>{@link LqnCore.TaskType#getEntry <em>Entry</em>}</li>
 *   <li>{@link LqnCore.TaskType#getService <em>Service</em>}</li>
 *   <li>{@link LqnCore.TaskType#getTaskActivities <em>Task Activities</em>}</li>
 *   <li>{@link LqnCore.TaskType#getActivityGraph <em>Activity Graph</em>}</li>
 *   <li>{@link LqnCore.TaskType#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link LqnCore.TaskType#getName <em>Name</em>}</li>
 *   <li>{@link LqnCore.TaskType#getPriority <em>Priority</em>}</li>
 *   <li>{@link LqnCore.TaskType#getQueueLength <em>Queue Length</em>}</li>
 *   <li>{@link LqnCore.TaskType#getReplication <em>Replication</em>}</li>
 *   <li>{@link LqnCore.TaskType#getScheduling <em>Scheduling</em>}</li>
 *   <li>{@link LqnCore.TaskType#getThinkTime <em>Think Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see LqnCore.LqnCorePackage#getTaskType()
 * @model extendedMetaData="name='TaskType' kind='elementOnly'"
 * @generated
 */
public interface TaskType extends EObject {
	/**
	 * Returns the value of the '<em><b>Result Task</b></em>' containment reference list.
	 * The list contents are of type {@link LqnCore.OutputResultType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Task</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Task</em>' containment reference list.
	 * @see LqnCore.LqnCorePackage#getTaskType_ResultTask()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='result-task' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<OutputResultType> getResultTask();

	/**
	 * Returns the value of the '<em><b>Entry</b></em>' containment reference list.
	 * The list contents are of type {@link LqnCore.EntryType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry</em>' containment reference list.
	 * @see LqnCore.LqnCorePackage#getTaskType_Entry()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='entry' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<EntryType> getEntry();

	/**
	 * Returns the value of the '<em><b>Service</b></em>' containment reference list.
	 * The list contents are of type {@link LqnCore.ServiceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service</em>' containment reference list.
	 * @see LqnCore.LqnCorePackage#getTaskType_Service()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='service' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ServiceType> getService();

	/**
	 * Returns the value of the '<em><b>Task Activities</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task Activities</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Activities</em>' containment reference.
	 * @see #setTaskActivities(TaskActivityGraph)
	 * @see LqnCore.LqnCorePackage#getTaskType_TaskActivities()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='task-activities' namespace='##targetNamespace'"
	 * @generated
	 */
	TaskActivityGraph getTaskActivities();

	/**
	 * Sets the value of the '{@link LqnCore.TaskType#getTaskActivities <em>Task Activities</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task Activities</em>' containment reference.
	 * @see #getTaskActivities()
	 * @generated
	 */
	void setTaskActivities(TaskActivityGraph value);

	/**
	 * Returns the value of the '<em><b>Activity Graph</b></em>' attribute.
	 * The default value is <code>"YES"</code>.
	 * The literals are from the enumeration {@link LqnCore.TaskOptionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activity Graph</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activity Graph</em>' attribute.
	 * @see LqnCore.TaskOptionType
	 * @see #isSetActivityGraph()
	 * @see #unsetActivityGraph()
	 * @see #setActivityGraph(TaskOptionType)
	 * @see LqnCore.LqnCorePackage#getTaskType_ActivityGraph()
	 * @model default="YES" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='activity-graph' namespace='##targetNamespace'"
	 * @generated
	 */
	TaskOptionType getActivityGraph();

	/**
	 * Sets the value of the '{@link LqnCore.TaskType#getActivityGraph <em>Activity Graph</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Activity Graph</em>' attribute.
	 * @see LqnCore.TaskOptionType
	 * @see #isSetActivityGraph()
	 * @see #unsetActivityGraph()
	 * @see #getActivityGraph()
	 * @generated
	 */
	void setActivityGraph(TaskOptionType value);

	/**
	 * Unsets the value of the '{@link LqnCore.TaskType#getActivityGraph <em>Activity Graph</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetActivityGraph()
	 * @see #getActivityGraph()
	 * @see #setActivityGraph(TaskOptionType)
	 * @generated
	 */
	void unsetActivityGraph();

	/**
	 * Returns whether the value of the '{@link LqnCore.TaskType#getActivityGraph <em>Activity Graph</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Activity Graph</em>' attribute is set.
	 * @see #unsetActivityGraph()
	 * @see #getActivityGraph()
	 * @see #setActivityGraph(TaskOptionType)
	 * @generated
	 */
	boolean isSetActivityGraph();

	/**
	 * Returns the value of the '<em><b>Multiplicity</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiplicity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiplicity</em>' attribute.
	 * @see #isSetMultiplicity()
	 * @see #unsetMultiplicity()
	 * @see #setMultiplicity(BigInteger)
	 * @see LqnCore.LqnCorePackage#getTaskType_Multiplicity()
	 * @model default="1" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.NonNegativeInteger"
	 *        extendedMetaData="kind='attribute' name='multiplicity' namespace='##targetNamespace'"
	 * @generated
	 */
	BigInteger getMultiplicity();

	/**
	 * Sets the value of the '{@link LqnCore.TaskType#getMultiplicity <em>Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multiplicity</em>' attribute.
	 * @see #isSetMultiplicity()
	 * @see #unsetMultiplicity()
	 * @see #getMultiplicity()
	 * @generated
	 */
	void setMultiplicity(BigInteger value);

	/**
	 * Unsets the value of the '{@link LqnCore.TaskType#getMultiplicity <em>Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMultiplicity()
	 * @see #getMultiplicity()
	 * @see #setMultiplicity(BigInteger)
	 * @generated
	 */
	void unsetMultiplicity();

	/**
	 * Returns whether the value of the '{@link LqnCore.TaskType#getMultiplicity <em>Multiplicity</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Multiplicity</em>' attribute is set.
	 * @see #unsetMultiplicity()
	 * @see #getMultiplicity()
	 * @see #setMultiplicity(BigInteger)
	 * @generated
	 */
	boolean isSetMultiplicity();

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
	 * @see LqnCore.LqnCorePackage#getTaskType_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='name' namespace='##targetNamespace'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link LqnCore.TaskType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see #isSetPriority()
	 * @see #unsetPriority()
	 * @see #setPriority(BigInteger)
	 * @see LqnCore.LqnCorePackage#getTaskType_Priority()
	 * @model default="0" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.NonNegativeInteger"
	 *        extendedMetaData="kind='attribute' name='priority' namespace='##targetNamespace'"
	 * @generated
	 */
	BigInteger getPriority();

	/**
	 * Sets the value of the '{@link LqnCore.TaskType#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see #isSetPriority()
	 * @see #unsetPriority()
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(BigInteger value);

	/**
	 * Unsets the value of the '{@link LqnCore.TaskType#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPriority()
	 * @see #getPriority()
	 * @see #setPriority(BigInteger)
	 * @generated
	 */
	void unsetPriority();

	/**
	 * Returns whether the value of the '{@link LqnCore.TaskType#getPriority <em>Priority</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Priority</em>' attribute is set.
	 * @see #unsetPriority()
	 * @see #getPriority()
	 * @see #setPriority(BigInteger)
	 * @generated
	 */
	boolean isSetPriority();

	/**
	 * Returns the value of the '<em><b>Queue Length</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queue Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queue Length</em>' attribute.
	 * @see #isSetQueueLength()
	 * @see #unsetQueueLength()
	 * @see #setQueueLength(BigInteger)
	 * @see LqnCore.LqnCorePackage#getTaskType_QueueLength()
	 * @model default="0" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.NonNegativeInteger"
	 *        extendedMetaData="kind='attribute' name='queue-length' namespace='##targetNamespace'"
	 * @generated
	 */
	BigInteger getQueueLength();

	/**
	 * Sets the value of the '{@link LqnCore.TaskType#getQueueLength <em>Queue Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Queue Length</em>' attribute.
	 * @see #isSetQueueLength()
	 * @see #unsetQueueLength()
	 * @see #getQueueLength()
	 * @generated
	 */
	void setQueueLength(BigInteger value);

	/**
	 * Unsets the value of the '{@link LqnCore.TaskType#getQueueLength <em>Queue Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetQueueLength()
	 * @see #getQueueLength()
	 * @see #setQueueLength(BigInteger)
	 * @generated
	 */
	void unsetQueueLength();

	/**
	 * Returns whether the value of the '{@link LqnCore.TaskType#getQueueLength <em>Queue Length</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Queue Length</em>' attribute is set.
	 * @see #unsetQueueLength()
	 * @see #getQueueLength()
	 * @see #setQueueLength(BigInteger)
	 * @generated
	 */
	boolean isSetQueueLength();

	/**
	 * Returns the value of the '<em><b>Replication</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Replication</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Replication</em>' attribute.
	 * @see #isSetReplication()
	 * @see #unsetReplication()
	 * @see #setReplication(BigInteger)
	 * @see LqnCore.LqnCorePackage#getTaskType_Replication()
	 * @model default="1" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.NonNegativeInteger"
	 *        extendedMetaData="kind='attribute' name='replication' namespace='##targetNamespace'"
	 * @generated
	 */
	BigInteger getReplication();

	/**
	 * Sets the value of the '{@link LqnCore.TaskType#getReplication <em>Replication</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Replication</em>' attribute.
	 * @see #isSetReplication()
	 * @see #unsetReplication()
	 * @see #getReplication()
	 * @generated
	 */
	void setReplication(BigInteger value);

	/**
	 * Unsets the value of the '{@link LqnCore.TaskType#getReplication <em>Replication</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetReplication()
	 * @see #getReplication()
	 * @see #setReplication(BigInteger)
	 * @generated
	 */
	void unsetReplication();

	/**
	 * Returns whether the value of the '{@link LqnCore.TaskType#getReplication <em>Replication</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Replication</em>' attribute is set.
	 * @see #unsetReplication()
	 * @see #getReplication()
	 * @see #setReplication(BigInteger)
	 * @generated
	 */
	boolean isSetReplication();

	/**
	 * Returns the value of the '<em><b>Scheduling</b></em>' attribute.
	 * The default value is <code>"fcfs"</code>.
	 * The literals are from the enumeration {@link LqnCore.TaskSchedulingType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scheduling</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scheduling</em>' attribute.
	 * @see LqnCore.TaskSchedulingType
	 * @see #isSetScheduling()
	 * @see #unsetScheduling()
	 * @see #setScheduling(TaskSchedulingType)
	 * @see LqnCore.LqnCorePackage#getTaskType_Scheduling()
	 * @model default="fcfs" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='scheduling' namespace='##targetNamespace'"
	 * @generated
	 */
	TaskSchedulingType getScheduling();

	/**
	 * Sets the value of the '{@link LqnCore.TaskType#getScheduling <em>Scheduling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scheduling</em>' attribute.
	 * @see LqnCore.TaskSchedulingType
	 * @see #isSetScheduling()
	 * @see #unsetScheduling()
	 * @see #getScheduling()
	 * @generated
	 */
	void setScheduling(TaskSchedulingType value);

	/**
	 * Unsets the value of the '{@link LqnCore.TaskType#getScheduling <em>Scheduling</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetScheduling()
	 * @see #getScheduling()
	 * @see #setScheduling(TaskSchedulingType)
	 * @generated
	 */
	void unsetScheduling();

	/**
	 * Returns whether the value of the '{@link LqnCore.TaskType#getScheduling <em>Scheduling</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Scheduling</em>' attribute is set.
	 * @see #unsetScheduling()
	 * @see #getScheduling()
	 * @see #setScheduling(TaskSchedulingType)
	 * @generated
	 */
	boolean isSetScheduling();

	/**
	 * Returns the value of the '<em><b>Think Time</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Think Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Think Time</em>' attribute.
	 * @see #isSetThinkTime()
	 * @see #unsetThinkTime()
	 * @see #setThinkTime(Object)
	 * @see LqnCore.LqnCorePackage#getTaskType_ThinkTime()
	 * @model default="0" unsettable="true" dataType="LqnCore.SrvnFloat"
	 *        extendedMetaData="kind='attribute' name='think-time' namespace='##targetNamespace'"
	 * @generated
	 */
	Object getThinkTime();

	/**
	 * Sets the value of the '{@link LqnCore.TaskType#getThinkTime <em>Think Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Think Time</em>' attribute.
	 * @see #isSetThinkTime()
	 * @see #unsetThinkTime()
	 * @see #getThinkTime()
	 * @generated
	 */
	void setThinkTime(Object value);

	/**
	 * Unsets the value of the '{@link LqnCore.TaskType#getThinkTime <em>Think Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetThinkTime()
	 * @see #getThinkTime()
	 * @see #setThinkTime(Object)
	 * @generated
	 */
	void unsetThinkTime();

	/**
	 * Returns whether the value of the '{@link LqnCore.TaskType#getThinkTime <em>Think Time</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Think Time</em>' attribute is set.
	 * @see #unsetThinkTime()
	 * @see #getThinkTime()
	 * @see #setThinkTime(Object)
	 * @generated
	 */
	boolean isSetThinkTime();

} // TaskType
