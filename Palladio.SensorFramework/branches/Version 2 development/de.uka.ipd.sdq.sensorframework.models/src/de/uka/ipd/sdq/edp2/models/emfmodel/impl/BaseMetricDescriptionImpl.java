/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.impl;

import de.uka.ipd.sdq.edp2.models.emfmodel.BaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.emfmodel.CaptureType;
import de.uka.ipd.sdq.edp2.models.emfmodel.DataType;
import de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage;
import de.uka.ipd.sdq.edp2.models.emfmodel.Scale;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Base Metric Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.BaseMetricDescriptionImpl#getCaptureType <em>Capture Type</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.BaseMetricDescriptionImpl#getDataType <em>Data Type</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.BaseMetricDescriptionImpl#getScale <em>Scale</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BaseMetricDescriptionImpl extends MetricDescriptionImpl implements BaseMetricDescription {
	/**
	 * The default value of the '{@link #getCaptureType() <em>Capture Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCaptureType()
	 * @generated
	 * @ordered
	 */
	protected static final CaptureType CAPTURE_TYPE_EDEFAULT = CaptureType.IDENTIFIER;

	/**
	 * The cached value of the '{@link #getCaptureType() <em>Capture Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCaptureType()
	 * @generated
	 * @ordered
	 */
	protected CaptureType captureType = CAPTURE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDataType() <em>Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataType()
	 * @generated
	 * @ordered
	 */
	protected static final DataType DATA_TYPE_EDEFAULT = DataType.QUANTITATIVE;

	/**
	 * The cached value of the '{@link #getDataType() <em>Data Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataType()
	 * @generated
	 * @ordered
	 */
	protected DataType dataType = DATA_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getScale() <em>Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScale()
	 * @generated
	 * @ordered
	 */
	protected static final Scale SCALE_EDEFAULT = Scale.NOMINAL;

	/**
	 * The cached value of the '{@link #getScale() <em>Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScale()
	 * @generated
	 * @ordered
	 */
	protected Scale scale = SCALE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BaseMetricDescriptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfmodelPackage.Literals.BASE_METRIC_DESCRIPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CaptureType getCaptureType() {
		return captureType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCaptureType(CaptureType newCaptureType) {
		CaptureType oldCaptureType = captureType;
		captureType = newCaptureType == null ? CAPTURE_TYPE_EDEFAULT : newCaptureType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.BASE_METRIC_DESCRIPTION__CAPTURE_TYPE, oldCaptureType, captureType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType getDataType() {
		return dataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataType(DataType newDataType) {
		DataType oldDataType = dataType;
		dataType = newDataType == null ? DATA_TYPE_EDEFAULT : newDataType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.BASE_METRIC_DESCRIPTION__DATA_TYPE, oldDataType, dataType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scale getScale() {
		return scale;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScale(Scale newScale) {
		Scale oldScale = scale;
		scale = newScale == null ? SCALE_EDEFAULT : newScale;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.BASE_METRIC_DESCRIPTION__SCALE, oldScale, scale));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmfmodelPackage.BASE_METRIC_DESCRIPTION__CAPTURE_TYPE:
				return getCaptureType();
			case EmfmodelPackage.BASE_METRIC_DESCRIPTION__DATA_TYPE:
				return getDataType();
			case EmfmodelPackage.BASE_METRIC_DESCRIPTION__SCALE:
				return getScale();
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
			case EmfmodelPackage.BASE_METRIC_DESCRIPTION__CAPTURE_TYPE:
				setCaptureType((CaptureType)newValue);
				return;
			case EmfmodelPackage.BASE_METRIC_DESCRIPTION__DATA_TYPE:
				setDataType((DataType)newValue);
				return;
			case EmfmodelPackage.BASE_METRIC_DESCRIPTION__SCALE:
				setScale((Scale)newValue);
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
			case EmfmodelPackage.BASE_METRIC_DESCRIPTION__CAPTURE_TYPE:
				setCaptureType(CAPTURE_TYPE_EDEFAULT);
				return;
			case EmfmodelPackage.BASE_METRIC_DESCRIPTION__DATA_TYPE:
				setDataType(DATA_TYPE_EDEFAULT);
				return;
			case EmfmodelPackage.BASE_METRIC_DESCRIPTION__SCALE:
				setScale(SCALE_EDEFAULT);
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
			case EmfmodelPackage.BASE_METRIC_DESCRIPTION__CAPTURE_TYPE:
				return captureType != CAPTURE_TYPE_EDEFAULT;
			case EmfmodelPackage.BASE_METRIC_DESCRIPTION__DATA_TYPE:
				return dataType != DATA_TYPE_EDEFAULT;
			case EmfmodelPackage.BASE_METRIC_DESCRIPTION__SCALE:
				return scale != SCALE_EDEFAULT;
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
		result.append(" (captureType: ");
		result.append(captureType);
		result.append(", dataType: ");
		result.append(dataType);
		result.append(", scale: ");
		result.append(scale);
		result.append(')');
		return result.toString();
	}

} //BaseMetricDescriptionImpl
