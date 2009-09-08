/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData.impl;

import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage;
import de.uka.ipd.sdq.edp2.models.ExperimentData.CategoryIdentifier;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedCategory;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedNominalMeasurements;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Observed Nominal Measurements</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.ObservedNominalMeasurementsImpl#getObservedCategories <em>Observed Categories</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.ObservedNominalMeasurementsImpl#getUuid <em>Uuid</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ObservedNominalMeasurementsImpl extends EObjectImpl implements ObservedNominalMeasurements {
	/**
	 * The cached value of the '{@link #getObservedCategories() <em>Observed Categories</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObservedCategories()
	 * @generated
	 * @ordered
	 */
	protected EList<ObservedCategory> observedCategories;

	/**
	 * The default value of the '{@link #getUuid() <em>Uuid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUuid()
	 * @generated
	 * @ordered
	 */
	protected static final String UUID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUuid() <em>Uuid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUuid()
	 * @generated
	 * @ordered
	 */
	protected String uuid = UUID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObservedNominalMeasurementsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExperimentDataPackage.Literals.OBSERVED_NOMINAL_MEASUREMENTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ObservedCategory> getObservedCategories() {
		if (observedCategories == null) {
			observedCategories = new EObjectContainmentEList<ObservedCategory>(ObservedCategory.class, this, ExperimentDataPackage.OBSERVED_NOMINAL_MEASUREMENTS__OBSERVED_CATEGORIES);
		}
		return observedCategories;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUuid(String newUuid) {
		String oldUuid = uuid;
		uuid = newUuid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.OBSERVED_NOMINAL_MEASUREMENTS__UUID, oldUuid, uuid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExperimentDataPackage.OBSERVED_NOMINAL_MEASUREMENTS__OBSERVED_CATEGORIES:
				return ((InternalEList<?>)getObservedCategories()).basicRemove(otherEnd, msgs);
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
			case ExperimentDataPackage.OBSERVED_NOMINAL_MEASUREMENTS__OBSERVED_CATEGORIES:
				return getObservedCategories();
			case ExperimentDataPackage.OBSERVED_NOMINAL_MEASUREMENTS__UUID:
				return getUuid();
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
			case ExperimentDataPackage.OBSERVED_NOMINAL_MEASUREMENTS__OBSERVED_CATEGORIES:
				getObservedCategories().clear();
				getObservedCategories().addAll((Collection<? extends ObservedCategory>)newValue);
				return;
			case ExperimentDataPackage.OBSERVED_NOMINAL_MEASUREMENTS__UUID:
				setUuid((String)newValue);
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
			case ExperimentDataPackage.OBSERVED_NOMINAL_MEASUREMENTS__OBSERVED_CATEGORIES:
				getObservedCategories().clear();
				return;
			case ExperimentDataPackage.OBSERVED_NOMINAL_MEASUREMENTS__UUID:
				setUuid(UUID_EDEFAULT);
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
			case ExperimentDataPackage.OBSERVED_NOMINAL_MEASUREMENTS__OBSERVED_CATEGORIES:
				return observedCategories != null && !observedCategories.isEmpty();
			case ExperimentDataPackage.OBSERVED_NOMINAL_MEASUREMENTS__UUID:
				return UUID_EDEFAULT == null ? uuid != null : !UUID_EDEFAULT.equals(uuid);
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
		result.append(" (uuid: ");
		result.append(uuid);
		result.append(')');
		return result.toString();
	}

} //ObservedNominalMeasurementsImpl
