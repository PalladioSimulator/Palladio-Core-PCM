/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scheduler.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import scheduler.SchedulerLibrary;
import scheduler.SchedulerPackage;

import scheduler.configuration.SchedulerConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scheduler.impl.SchedulerLibraryImpl#getSchedulerConfiguration <em>Scheduler Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SchedulerLibraryImpl extends EObjectImpl implements SchedulerLibrary {
	/**
	 * The cached value of the '{@link #getSchedulerConfiguration() <em>Scheduler Configuration</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchedulerConfiguration()
	 * @generated
	 * @ordered
	 */
	protected EList<SchedulerConfiguration> schedulerConfiguration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SchedulerLibraryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulerPackage.Literals.SCHEDULER_LIBRARY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SchedulerConfiguration> getSchedulerConfiguration() {
		if (schedulerConfiguration == null) {
			schedulerConfiguration = new EObjectContainmentEList<SchedulerConfiguration>(SchedulerConfiguration.class, this, SchedulerPackage.SCHEDULER_LIBRARY__SCHEDULER_CONFIGURATION);
		}
		return schedulerConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SchedulerPackage.SCHEDULER_LIBRARY__SCHEDULER_CONFIGURATION:
				return ((InternalEList<?>)getSchedulerConfiguration()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SchedulerPackage.SCHEDULER_LIBRARY__SCHEDULER_CONFIGURATION:
				return getSchedulerConfiguration();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SchedulerPackage.SCHEDULER_LIBRARY__SCHEDULER_CONFIGURATION:
				getSchedulerConfiguration().clear();
				getSchedulerConfiguration().addAll((Collection<? extends SchedulerConfiguration>)newValue);
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
			case SchedulerPackage.SCHEDULER_LIBRARY__SCHEDULER_CONFIGURATION:
				getSchedulerConfiguration().clear();
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
			case SchedulerPackage.SCHEDULER_LIBRARY__SCHEDULER_CONFIGURATION:
				return schedulerConfiguration != null && !schedulerConfiguration.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SchedulerLibraryImpl
