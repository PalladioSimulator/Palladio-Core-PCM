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

import scheduler.configuration.ConfigurationPackage;
import scheduler.configuration.ProcessSelection;
import scheduler.configuration.SingleQueueConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Single Queue Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scheduler.configuration.impl.SingleQueueConfigurationImpl#getProcessSelection <em>Process Selection</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SingleQueueConfigurationImpl extends QueueingConfigurationImpl implements SingleQueueConfiguration {
	/**
	 * The default value of the '{@link #getProcessSelection() <em>Process Selection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessSelection()
	 * @generated
	 * @ordered
	 */
	protected static final ProcessSelection PROCESS_SELECTION_EDEFAULT = ProcessSelection.PREFER_IDEAL_AND_LAST;

	/**
	 * The cached value of the '{@link #getProcessSelection() <em>Process Selection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessSelection()
	 * @generated
	 * @ordered
	 */
	protected ProcessSelection processSelection = PROCESS_SELECTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SingleQueueConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.SINGLE_QUEUE_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessSelection getProcessSelection() {
		return processSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessSelection(ProcessSelection newProcessSelection) {
		ProcessSelection oldProcessSelection = processSelection;
		processSelection = newProcessSelection == null ? PROCESS_SELECTION_EDEFAULT : newProcessSelection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ConfigurationPackage.SINGLE_QUEUE_CONFIGURATION__PROCESS_SELECTION, oldProcessSelection, processSelection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigurationPackage.SINGLE_QUEUE_CONFIGURATION__PROCESS_SELECTION:
				return getProcessSelection();
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
			case ConfigurationPackage.SINGLE_QUEUE_CONFIGURATION__PROCESS_SELECTION:
				setProcessSelection((ProcessSelection)newValue);
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
			case ConfigurationPackage.SINGLE_QUEUE_CONFIGURATION__PROCESS_SELECTION:
				setProcessSelection(PROCESS_SELECTION_EDEFAULT);
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
			case ConfigurationPackage.SINGLE_QUEUE_CONFIGURATION__PROCESS_SELECTION:
				return processSelection != PROCESS_SELECTION_EDEFAULT;
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
		result.append(" (processSelection: ");
		result.append(processSelection);
		result.append(')');
		return result.toString();
	}

} //SingleQueueConfigurationImpl
