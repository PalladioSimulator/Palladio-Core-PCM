/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.impl;

import de.uka.ipd.sdq.edp2.models.emfmodel.DataSeries;
import de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage;
import de.uka.ipd.sdq.edp2.models.emfmodel.NominalStatistics;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Nominal Statistics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.NominalStatisticsImpl#getCount <em>Count</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.NominalStatisticsImpl#getRawYSeries <em>Raw YSeries</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NominalStatisticsImpl extends EObjectImpl implements NominalStatistics {
	/**
	 * The default value of the '{@link #getCount() <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCount()
	 * @generated
	 * @ordered
	 */
	protected static final long COUNT_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getCount() <em>Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCount()
	 * @generated
	 * @ordered
	 */
	protected long count = COUNT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NominalStatisticsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfmodelPackage.Literals.NOMINAL_STATISTICS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getCount() {
		return count;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCount(long newCount) {
		long oldCount = count;
		count = newCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.NOMINAL_STATISTICS__COUNT, oldCount, count));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataSeries getRawYSeries() {
		if (eContainerFeatureID != EmfmodelPackage.NOMINAL_STATISTICS__RAW_YSERIES) return null;
		return (DataSeries)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRawYSeries(DataSeries newRawYSeries, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRawYSeries, EmfmodelPackage.NOMINAL_STATISTICS__RAW_YSERIES, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRawYSeries(DataSeries newRawYSeries) {
		if (newRawYSeries != eInternalContainer() || (eContainerFeatureID != EmfmodelPackage.NOMINAL_STATISTICS__RAW_YSERIES && newRawYSeries != null)) {
			if (EcoreUtil.isAncestor(this, newRawYSeries))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRawYSeries != null)
				msgs = ((InternalEObject)newRawYSeries).eInverseAdd(this, EmfmodelPackage.DATA_SERIES__STATISTICS, DataSeries.class, msgs);
			msgs = basicSetRawYSeries(newRawYSeries, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.NOMINAL_STATISTICS__RAW_YSERIES, newRawYSeries, newRawYSeries));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfmodelPackage.NOMINAL_STATISTICS__RAW_YSERIES:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRawYSeries((DataSeries)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfmodelPackage.NOMINAL_STATISTICS__RAW_YSERIES:
				return basicSetRawYSeries(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case EmfmodelPackage.NOMINAL_STATISTICS__RAW_YSERIES:
				return eInternalContainer().eInverseRemove(this, EmfmodelPackage.DATA_SERIES__STATISTICS, DataSeries.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmfmodelPackage.NOMINAL_STATISTICS__COUNT:
				return new Long(getCount());
			case EmfmodelPackage.NOMINAL_STATISTICS__RAW_YSERIES:
				return getRawYSeries();
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
			case EmfmodelPackage.NOMINAL_STATISTICS__COUNT:
				setCount(((Long)newValue).longValue());
				return;
			case EmfmodelPackage.NOMINAL_STATISTICS__RAW_YSERIES:
				setRawYSeries((DataSeries)newValue);
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
			case EmfmodelPackage.NOMINAL_STATISTICS__COUNT:
				setCount(COUNT_EDEFAULT);
				return;
			case EmfmodelPackage.NOMINAL_STATISTICS__RAW_YSERIES:
				setRawYSeries((DataSeries)null);
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
			case EmfmodelPackage.NOMINAL_STATISTICS__COUNT:
				return count != COUNT_EDEFAULT;
			case EmfmodelPackage.NOMINAL_STATISTICS__RAW_YSERIES:
				return getRawYSeries() != null;
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
		result.append(" (count: ");
		result.append(count);
		result.append(')');
		return result.toString();
	}

} //NominalStatisticsImpl
