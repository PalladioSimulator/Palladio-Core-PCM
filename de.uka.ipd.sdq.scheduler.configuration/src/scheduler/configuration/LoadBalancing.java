/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scheduler.configuration;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Load Balancing</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scheduler.configuration.LoadBalancing#getBalancingType <em>Balancing Type</em>}</li>
 *   <li>{@link scheduler.configuration.LoadBalancing#getPreferredWaitingTime <em>Preferred Waiting Time</em>}</li>
 *   <li>{@link scheduler.configuration.LoadBalancing#getPreferredPriority <em>Preferred Priority</em>}</li>
 *   <li>{@link scheduler.configuration.LoadBalancing#getInstances <em>Instances</em>}</li>
 *   <li>{@link scheduler.configuration.LoadBalancing#getThreshold <em>Threshold</em>}</li>
 *   <li>{@link scheduler.configuration.LoadBalancing#getMaxIterations <em>Max Iterations</em>}</li>
 *   <li>{@link scheduler.configuration.LoadBalancing#getBalancingInterval <em>Balancing Interval</em>}</li>
 * </ul>
 * </p>
 *
 * @see scheduler.configuration.ConfigurationPackage#getLoadBalancing()
 * @model
 * @generated
 */
public interface LoadBalancing extends EObject {
	/**
	 * Returns the value of the '<em><b>Balancing Type</b></em>' attribute.
	 * The literals are from the enumeration {@link scheduler.configuration.LoadBalancingType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Balancing Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Balancing Type</em>' attribute.
	 * @see scheduler.configuration.LoadBalancingType
	 * @see #setBalancingType(LoadBalancingType)
	 * @see scheduler.configuration.ConfigurationPackage#getLoadBalancing_BalancingType()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	LoadBalancingType getBalancingType();

	/**
	 * Sets the value of the '{@link scheduler.configuration.LoadBalancing#getBalancingType <em>Balancing Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Balancing Type</em>' attribute.
	 * @see scheduler.configuration.LoadBalancingType
	 * @see #getBalancingType()
	 * @generated
	 */
	void setBalancingType(LoadBalancingType value);

	/**
	 * Returns the value of the '<em><b>Preferred Waiting Time</b></em>' attribute.
	 * The literals are from the enumeration {@link scheduler.configuration.PreferredWaitingTime}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Preferred Waiting Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Preferred Waiting Time</em>' attribute.
	 * @see scheduler.configuration.PreferredWaitingTime
	 * @see #setPreferredWaitingTime(PreferredWaitingTime)
	 * @see scheduler.configuration.ConfigurationPackage#getLoadBalancing_PreferredWaitingTime()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	PreferredWaitingTime getPreferredWaitingTime();

	/**
	 * Sets the value of the '{@link scheduler.configuration.LoadBalancing#getPreferredWaitingTime <em>Preferred Waiting Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Preferred Waiting Time</em>' attribute.
	 * @see scheduler.configuration.PreferredWaitingTime
	 * @see #getPreferredWaitingTime()
	 * @generated
	 */
	void setPreferredWaitingTime(PreferredWaitingTime value);

	/**
	 * Returns the value of the '<em><b>Preferred Priority</b></em>' attribute.
	 * The literals are from the enumeration {@link scheduler.configuration.PreferredPriority}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Preferred Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Preferred Priority</em>' attribute.
	 * @see scheduler.configuration.PreferredPriority
	 * @see #setPreferredPriority(PreferredPriority)
	 * @see scheduler.configuration.ConfigurationPackage#getLoadBalancing_PreferredPriority()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	PreferredPriority getPreferredPriority();

	/**
	 * Sets the value of the '{@link scheduler.configuration.LoadBalancing#getPreferredPriority <em>Preferred Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Preferred Priority</em>' attribute.
	 * @see scheduler.configuration.PreferredPriority
	 * @see #getPreferredPriority()
	 * @generated
	 */
	void setPreferredPriority(PreferredPriority value);

	/**
	 * Returns the value of the '<em><b>Instances</b></em>' attribute.
	 * The literals are from the enumeration {@link scheduler.configuration.InstanceToBalance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instances</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instances</em>' attribute.
	 * @see scheduler.configuration.InstanceToBalance
	 * @see #setInstances(InstanceToBalance)
	 * @see scheduler.configuration.ConfigurationPackage#getLoadBalancing_Instances()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	InstanceToBalance getInstances();

	/**
	 * Sets the value of the '{@link scheduler.configuration.LoadBalancing#getInstances <em>Instances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instances</em>' attribute.
	 * @see scheduler.configuration.InstanceToBalance
	 * @see #getInstances()
	 * @generated
	 */
	void setInstances(InstanceToBalance value);

	/**
	 * Returns the value of the '<em><b>Threshold</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Threshold</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Threshold</em>' attribute.
	 * @see #setThreshold(double)
	 * @see scheduler.configuration.ConfigurationPackage#getLoadBalancing_Threshold()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getThreshold();

	/**
	 * Sets the value of the '{@link scheduler.configuration.LoadBalancing#getThreshold <em>Threshold</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Threshold</em>' attribute.
	 * @see #getThreshold()
	 * @generated
	 */
	void setThreshold(double value);

	/**
	 * Returns the value of the '<em><b>Max Iterations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Iterations</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Iterations</em>' attribute.
	 * @see #setMaxIterations(int)
	 * @see scheduler.configuration.ConfigurationPackage#getLoadBalancing_MaxIterations()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getMaxIterations();

	/**
	 * Sets the value of the '{@link scheduler.configuration.LoadBalancing#getMaxIterations <em>Max Iterations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Iterations</em>' attribute.
	 * @see #getMaxIterations()
	 * @generated
	 */
	void setMaxIterations(int value);

	/**
	 * Returns the value of the '<em><b>Balancing Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Balancing Interval</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Balancing Interval</em>' attribute.
	 * @see #setBalancingInterval(double)
	 * @see scheduler.configuration.ConfigurationPackage#getLoadBalancing_BalancingInterval()
	 * @model
	 * @generated
	 */
	double getBalancingInterval();

	/**
	 * Sets the value of the '{@link scheduler.configuration.LoadBalancing#getBalancingInterval <em>Balancing Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Balancing Interval</em>' attribute.
	 * @see #getBalancingInterval()
	 * @generated
	 */
	void setBalancingInterval(double value);

} // LoadBalancing
