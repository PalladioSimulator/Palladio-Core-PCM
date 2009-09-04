/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.Presentation.impl;

import de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries;
import de.uka.ipd.sdq.edp2.models.Presentation.EDP2DataSourceDescription;
import de.uka.ipd.sdq.edp2.models.Presentation.PresentationPackage;


import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EDP2 Data Source Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.Presentation.impl.EDP2DataSourceDescriptionImpl#getDataSeries <em>Data Series</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EDP2DataSourceDescriptionImpl extends EObjectImpl implements EDP2DataSourceDescription {
	/**
	 * The cached value of the '{@link #getDataSeries() <em>Data Series</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataSeries()
	 * @generated
	 * @ordered
	 */
	protected DataSeries dataSeries;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EDP2DataSourceDescriptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PresentationPackage.Literals.EDP2_DATA_SOURCE_DESCRIPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataSeries getDataSeries() {
		if (dataSeries != null && dataSeries.eIsProxy()) {
			InternalEObject oldDataSeries = (InternalEObject)dataSeries;
			dataSeries = (DataSeries)eResolveProxy(oldDataSeries);
			if (dataSeries != oldDataSeries) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PresentationPackage.EDP2_DATA_SOURCE_DESCRIPTION__DATA_SERIES, oldDataSeries, dataSeries));
			}
		}
		return dataSeries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataSeries basicGetDataSeries() {
		return dataSeries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataSeries(DataSeries newDataSeries) {
		DataSeries oldDataSeries = dataSeries;
		dataSeries = newDataSeries;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PresentationPackage.EDP2_DATA_SOURCE_DESCRIPTION__DATA_SERIES, oldDataSeries, dataSeries));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PresentationPackage.EDP2_DATA_SOURCE_DESCRIPTION__DATA_SERIES:
				if (resolve) return getDataSeries();
				return basicGetDataSeries();
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
			case PresentationPackage.EDP2_DATA_SOURCE_DESCRIPTION__DATA_SERIES:
				setDataSeries((DataSeries)newValue);
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
			case PresentationPackage.EDP2_DATA_SOURCE_DESCRIPTION__DATA_SERIES:
				setDataSeries((DataSeries)null);
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
			case PresentationPackage.EDP2_DATA_SOURCE_DESCRIPTION__DATA_SERIES:
				return dataSeries != null;
		}
		return super.eIsSet(featureID);
	}

} //EDP2DataSourceDescriptionImpl
