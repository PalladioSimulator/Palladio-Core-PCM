/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scheduler.configuration.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import scheduler.configuration.ConfigurationPackage;
import scheduler.configuration.QueueingConfiguration;
import scheduler.configuration.ResourceInstanceSelection;
import scheduler.configuration.RunQueueType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Queueing Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scheduler.configuration.impl.QueueingConfigurationImpl#getInitialInstanceSelection <em>Initial Instance Selection</em>}</li>
 *   <li>{@link scheduler.configuration.impl.QueueingConfigurationImpl#getRunqueueType <em>Runqueue Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class QueueingConfigurationImpl extends EObjectImpl implements QueueingConfiguration {
	/**
	 * The default value of the '{@link #getInitialInstanceSelection() <em>Initial Instance Selection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialInstanceSelection()
	 * @generated
	 * @ordered
	 */
	protected static final ResourceInstanceSelection INITIAL_INSTANCE_SELECTION_EDEFAULT = ResourceInstanceSelection.ROUND_ROBIN;

	/**
	 * The cached value of the '{@link #getInitialInstanceSelection() <em>Initial Instance Selection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialInstanceSelection()
	 * @generated
	 * @ordered
	 */
	protected ResourceInstanceSelection initialInstanceSelection = INITIAL_INSTANCE_SELECTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getRunqueueType() <em>Runqueue Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRunqueueType()
	 * @generated
	 * @ordered
	 */
	protected static final RunQueueType RUNQUEUE_TYPE_EDEFAULT = RunQueueType.ACTIVE_AND_EXPIRED;

	/**
	 * The cached value of the '{@link #getRunqueueType() <em>Runqueue Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRunqueueType()
	 * @generated
	 * @ordered
	 */
	protected RunQueueType runqueueType = RUNQUEUE_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QueueingConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.QUEUEING_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceInstanceSelection getInitialInstanceSelection() {
		return initialInstanceSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialInstanceSelection(ResourceInstanceSelection newInitialInstanceSelection) {
		ResourceInstanceSelection oldInitialInstanceSelection = initialInstanceSelection;
		initialInstanceSelection = newInitialInstanceSelection == null ? INITIAL_INSTANCE_SELECTION_EDEFAULT : newInitialInstanceSelection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.QUEUEING_CONFIGURATION__INITIAL_INSTANCE_SELECTION, oldInitialInstanceSelection, initialInstanceSelection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RunQueueType getRunqueueType() {
		return runqueueType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRunqueueType(RunQueueType newRunqueueType) {
		RunQueueType oldRunqueueType = runqueueType;
		runqueueType = newRunqueueType == null ? RUNQUEUE_TYPE_EDEFAULT : newRunqueueType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.QUEUEING_CONFIGURATION__RUNQUEUE_TYPE, oldRunqueueType, runqueueType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigurationPackage.QUEUEING_CONFIGURATION__INITIAL_INSTANCE_SELECTION:
				return getInitialInstanceSelection();
			case ConfigurationPackage.QUEUEING_CONFIGURATION__RUNQUEUE_TYPE:
				return getRunqueueType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ConfigurationPackage.QUEUEING_CONFIGURATION__INITIAL_INSTANCE_SELECTION:
				setInitialInstanceSelection((ResourceInstanceSelection)newValue);
				return;
			case ConfigurationPackage.QUEUEING_CONFIGURATION__RUNQUEUE_TYPE:
				setRunqueueType((RunQueueType)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ConfigurationPackage.QUEUEING_CONFIGURATION__INITIAL_INSTANCE_SELECTION:
				setInitialInstanceSelection(INITIAL_INSTANCE_SELECTION_EDEFAULT);
				return;
			case ConfigurationPackage.QUEUEING_CONFIGURATION__RUNQUEUE_TYPE:
				setRunqueueType(RUNQUEUE_TYPE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ConfigurationPackage.QUEUEING_CONFIGURATION__INITIAL_INSTANCE_SELECTION:
				return initialInstanceSelection != INITIAL_INSTANCE_SELECTION_EDEFAULT;
			case ConfigurationPackage.QUEUEING_CONFIGURATION__RUNQUEUE_TYPE:
				return runqueueType != RUNQUEUE_TYPE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (initialInstanceSelection: ");
		result.append(initialInstanceSelection);
		result.append(", runqueueType: ");
		result.append(runqueueType);
		result.append(')');
		return result.toString();
	}

} //QueueingConfigurationImpl
