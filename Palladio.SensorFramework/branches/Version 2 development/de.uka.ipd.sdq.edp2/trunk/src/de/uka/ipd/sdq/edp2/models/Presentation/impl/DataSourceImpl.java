/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.Presentation.impl;

import de.uka.ipd.sdq.edp2.models.ExperimentData.BaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.DataType;
import de.uka.ipd.sdq.edp2.models.Presentation.DataSource;
import de.uka.ipd.sdq.edp2.models.Presentation.IDataSourceDescription;
import de.uka.ipd.sdq.edp2.models.Presentation.PresentationPackage;


import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Source</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.Presentation.impl.DataSourceImpl#getData <em>Data</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.Presentation.impl.DataSourceImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.Presentation.impl.DataSourceImpl#getMetricDescription <em>Metric Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataSourceImpl extends EObjectImpl implements DataSource {
	/**
	 * The default value of the '{@link #getData() <em>Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected static final DataType DATA_EDEFAULT = DataType.QUANTITATIVE;

	/**
	 * The cached value of the '{@link #getData() <em>Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected DataType data = DATA_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected IDataSourceDescription description;

	/**
	 * The cached value of the '{@link #getMetricDescription() <em>Metric Description</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricDescription()
	 * @generated
	 * @ordered
	 */
	protected BaseMetricDescription metricDescription;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataSourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PresentationPackage.Literals.DATA_SOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType getData() {
		return data;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setData(DataType newData) {
		DataType oldData = data;
		data = newData == null ? DATA_EDEFAULT : newData;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PresentationPackage.DATA_SOURCE__DATA, oldData, data));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IDataSourceDescription getDescription() {
		if (description != null && description.eIsProxy()) {
			InternalEObject oldDescription = (InternalEObject)description;
			description = (IDataSourceDescription)eResolveProxy(oldDescription);
			if (description != oldDescription) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PresentationPackage.DATA_SOURCE__DESCRIPTION, oldDescription, description));
			}
		}
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IDataSourceDescription basicGetDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(IDataSourceDescription newDescription) {
		IDataSourceDescription oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PresentationPackage.DATA_SOURCE__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseMetricDescription getMetricDescription() {
		if (metricDescription != null && metricDescription.eIsProxy()) {
			InternalEObject oldMetricDescription = (InternalEObject)metricDescription;
			metricDescription = (BaseMetricDescription)eResolveProxy(oldMetricDescription);
			if (metricDescription != oldMetricDescription) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PresentationPackage.DATA_SOURCE__METRIC_DESCRIPTION, oldMetricDescription, metricDescription));
			}
		}
		return metricDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseMetricDescription basicGetMetricDescription() {
		return metricDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetricDescription(BaseMetricDescription newMetricDescription) {
		BaseMetricDescription oldMetricDescription = metricDescription;
		metricDescription = newMetricDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PresentationPackage.DATA_SOURCE__METRIC_DESCRIPTION, oldMetricDescription, metricDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PresentationPackage.DATA_SOURCE__DATA:
				return getData();
			case PresentationPackage.DATA_SOURCE__DESCRIPTION:
				if (resolve) return getDescription();
				return basicGetDescription();
			case PresentationPackage.DATA_SOURCE__METRIC_DESCRIPTION:
				if (resolve) return getMetricDescription();
				return basicGetMetricDescription();
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
			case PresentationPackage.DATA_SOURCE__DATA:
				setData((DataType)newValue);
				return;
			case PresentationPackage.DATA_SOURCE__DESCRIPTION:
				setDescription((IDataSourceDescription)newValue);
				return;
			case PresentationPackage.DATA_SOURCE__METRIC_DESCRIPTION:
				setMetricDescription((BaseMetricDescription)newValue);
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
			case PresentationPackage.DATA_SOURCE__DATA:
				setData(DATA_EDEFAULT);
				return;
			case PresentationPackage.DATA_SOURCE__DESCRIPTION:
				setDescription((IDataSourceDescription)null);
				return;
			case PresentationPackage.DATA_SOURCE__METRIC_DESCRIPTION:
				setMetricDescription((BaseMetricDescription)null);
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
			case PresentationPackage.DATA_SOURCE__DATA:
				return data != DATA_EDEFAULT;
			case PresentationPackage.DATA_SOURCE__DESCRIPTION:
				return description != null;
			case PresentationPackage.DATA_SOURCE__METRIC_DESCRIPTION:
				return metricDescription != null;
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
		result.append(" (data: ");
		result.append(data);
		result.append(')');
		return result.toString();
	}

} //DataSourceImpl
