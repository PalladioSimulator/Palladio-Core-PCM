/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.emfmodel.impl;

import de.uka.ipd.sdq.edp2.models.emfmodel.DataSeries;
import de.uka.ipd.sdq.edp2.models.emfmodel.EmfmodelPackage;
import de.uka.ipd.sdq.edp2.models.emfmodel.FixedWidthAggregatedMeasurements;
import de.uka.ipd.sdq.edp2.models.emfmodel.NominalStatistics;
import de.uka.ipd.sdq.edp2.models.emfmodel.RawMeasurements;

import de.uka.ipd.sdq.edp2.models.emfmodel.util.EmfmodelValidator;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Series</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.DataSeriesImpl#getStatistics <em>Statistics</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.DataSeriesImpl#getAggregatedMeasurements <em>Aggregated Measurements</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.DataSeriesImpl#getValuesUuid <em>Values Uuid</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.emfmodel.impl.DataSeriesImpl#getRawMeasurements <em>Raw Measurements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DataSeriesImpl extends EObjectImpl implements DataSeries {
	/**
	 * The cached value of the '{@link #getStatistics() <em>Statistics</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatistics()
	 * @generated
	 * @ordered
	 */
	protected NominalStatistics statistics;

	/**
	 * The default value of the '{@link #getValuesUuid() <em>Values Uuid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValuesUuid()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUES_UUID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValuesUuid() <em>Values Uuid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValuesUuid()
	 * @generated
	 * @ordered
	 */
	protected String valuesUuid = VALUES_UUID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataSeriesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EmfmodelPackage.Literals.DATA_SERIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NominalStatistics getStatistics() {
		return statistics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStatistics(NominalStatistics newStatistics, NotificationChain msgs) {
		NominalStatistics oldStatistics = statistics;
		statistics = newStatistics;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfmodelPackage.DATA_SERIES__STATISTICS, oldStatistics, newStatistics);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatistics(NominalStatistics newStatistics) {
		if (newStatistics != statistics) {
			NotificationChain msgs = null;
			if (statistics != null)
				msgs = ((InternalEObject)statistics).eInverseRemove(this, EmfmodelPackage.NOMINAL_STATISTICS__RAW_YSERIES, NominalStatistics.class, msgs);
			if (newStatistics != null)
				msgs = ((InternalEObject)newStatistics).eInverseAdd(this, EmfmodelPackage.NOMINAL_STATISTICS__RAW_YSERIES, NominalStatistics.class, msgs);
			msgs = basicSetStatistics(newStatistics, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.DATA_SERIES__STATISTICS, newStatistics, newStatistics));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FixedWidthAggregatedMeasurements getAggregatedMeasurements() {
		if (eContainerFeatureID() != EmfmodelPackage.DATA_SERIES__AGGREGATED_MEASUREMENTS) return null;
		return (FixedWidthAggregatedMeasurements)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAggregatedMeasurements(FixedWidthAggregatedMeasurements newAggregatedMeasurements, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newAggregatedMeasurements, EmfmodelPackage.DATA_SERIES__AGGREGATED_MEASUREMENTS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAggregatedMeasurements(FixedWidthAggregatedMeasurements newAggregatedMeasurements) {
		if (newAggregatedMeasurements != eInternalContainer() || (eContainerFeatureID() != EmfmodelPackage.DATA_SERIES__AGGREGATED_MEASUREMENTS && newAggregatedMeasurements != null)) {
			if (EcoreUtil.isAncestor(this, newAggregatedMeasurements))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newAggregatedMeasurements != null)
				msgs = ((InternalEObject)newAggregatedMeasurements).eInverseAdd(this, EmfmodelPackage.FIXED_WIDTH_AGGREGATED_MEASUREMENTS__DATA_SERIES, FixedWidthAggregatedMeasurements.class, msgs);
			msgs = basicSetAggregatedMeasurements(newAggregatedMeasurements, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.DATA_SERIES__AGGREGATED_MEASUREMENTS, newAggregatedMeasurements, newAggregatedMeasurements));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValuesUuid() {
		return valuesUuid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValuesUuid(String newValuesUuid) {
		String oldValuesUuid = valuesUuid;
		valuesUuid = newValuesUuid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.DATA_SERIES__VALUES_UUID, oldValuesUuid, valuesUuid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RawMeasurements getRawMeasurements() {
		if (eContainerFeatureID() != EmfmodelPackage.DATA_SERIES__RAW_MEASUREMENTS) return null;
		return (RawMeasurements)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRawMeasurements(RawMeasurements newRawMeasurements, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRawMeasurements, EmfmodelPackage.DATA_SERIES__RAW_MEASUREMENTS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRawMeasurements(RawMeasurements newRawMeasurements) {
		if (newRawMeasurements != eInternalContainer() || (eContainerFeatureID() != EmfmodelPackage.DATA_SERIES__RAW_MEASUREMENTS && newRawMeasurements != null)) {
			if (EcoreUtil.isAncestor(this, newRawMeasurements))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRawMeasurements != null)
				msgs = ((InternalEObject)newRawMeasurements).eInverseAdd(this, EmfmodelPackage.RAW_MEASUREMENTS__DATA_SERIES, RawMeasurements.class, msgs);
			msgs = basicSetRawMeasurements(newRawMeasurements, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfmodelPackage.DATA_SERIES__RAW_MEASUREMENTS, newRawMeasurements, newRawMeasurements));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean Statisticsonlyformeasurablevalues(DiagnosticChain diagnostics, Map context) {
		// TODO: implement this method
		// -> specify the condition that violates the invariant
		// -> verify the details of the diagnostic, including severity and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(new BasicDiagnostic
						(Diagnostic.ERROR,
						 EmfmodelValidator.DIAGNOSTIC_SOURCE,
						 EmfmodelValidator.DATA_SERIES__STATISTICSONLYFORMEASURABLEVALUES,
						 EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "Statisticsonlyformeasurablevalues", EObjectValidator.getObjectLabel(this, context) }),
						 new Object [] { this }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EmfmodelPackage.DATA_SERIES__STATISTICS:
				if (statistics != null)
					msgs = ((InternalEObject)statistics).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmfmodelPackage.DATA_SERIES__STATISTICS, null, msgs);
				return basicSetStatistics((NominalStatistics)otherEnd, msgs);
			case EmfmodelPackage.DATA_SERIES__AGGREGATED_MEASUREMENTS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetAggregatedMeasurements((FixedWidthAggregatedMeasurements)otherEnd, msgs);
			case EmfmodelPackage.DATA_SERIES__RAW_MEASUREMENTS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRawMeasurements((RawMeasurements)otherEnd, msgs);
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
			case EmfmodelPackage.DATA_SERIES__STATISTICS:
				return basicSetStatistics(null, msgs);
			case EmfmodelPackage.DATA_SERIES__AGGREGATED_MEASUREMENTS:
				return basicSetAggregatedMeasurements(null, msgs);
			case EmfmodelPackage.DATA_SERIES__RAW_MEASUREMENTS:
				return basicSetRawMeasurements(null, msgs);
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
		switch (eContainerFeatureID()) {
			case EmfmodelPackage.DATA_SERIES__AGGREGATED_MEASUREMENTS:
				return eInternalContainer().eInverseRemove(this, EmfmodelPackage.FIXED_WIDTH_AGGREGATED_MEASUREMENTS__DATA_SERIES, FixedWidthAggregatedMeasurements.class, msgs);
			case EmfmodelPackage.DATA_SERIES__RAW_MEASUREMENTS:
				return eInternalContainer().eInverseRemove(this, EmfmodelPackage.RAW_MEASUREMENTS__DATA_SERIES, RawMeasurements.class, msgs);
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
			case EmfmodelPackage.DATA_SERIES__STATISTICS:
				return getStatistics();
			case EmfmodelPackage.DATA_SERIES__AGGREGATED_MEASUREMENTS:
				return getAggregatedMeasurements();
			case EmfmodelPackage.DATA_SERIES__VALUES_UUID:
				return getValuesUuid();
			case EmfmodelPackage.DATA_SERIES__RAW_MEASUREMENTS:
				return getRawMeasurements();
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
			case EmfmodelPackage.DATA_SERIES__STATISTICS:
				setStatistics((NominalStatistics)newValue);
				return;
			case EmfmodelPackage.DATA_SERIES__AGGREGATED_MEASUREMENTS:
				setAggregatedMeasurements((FixedWidthAggregatedMeasurements)newValue);
				return;
			case EmfmodelPackage.DATA_SERIES__VALUES_UUID:
				setValuesUuid((String)newValue);
				return;
			case EmfmodelPackage.DATA_SERIES__RAW_MEASUREMENTS:
				setRawMeasurements((RawMeasurements)newValue);
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
			case EmfmodelPackage.DATA_SERIES__STATISTICS:
				setStatistics((NominalStatistics)null);
				return;
			case EmfmodelPackage.DATA_SERIES__AGGREGATED_MEASUREMENTS:
				setAggregatedMeasurements((FixedWidthAggregatedMeasurements)null);
				return;
			case EmfmodelPackage.DATA_SERIES__VALUES_UUID:
				setValuesUuid(VALUES_UUID_EDEFAULT);
				return;
			case EmfmodelPackage.DATA_SERIES__RAW_MEASUREMENTS:
				setRawMeasurements((RawMeasurements)null);
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
			case EmfmodelPackage.DATA_SERIES__STATISTICS:
				return statistics != null;
			case EmfmodelPackage.DATA_SERIES__AGGREGATED_MEASUREMENTS:
				return getAggregatedMeasurements() != null;
			case EmfmodelPackage.DATA_SERIES__VALUES_UUID:
				return VALUES_UUID_EDEFAULT == null ? valuesUuid != null : !VALUES_UUID_EDEFAULT.equals(valuesUuid);
			case EmfmodelPackage.DATA_SERIES__RAW_MEASUREMENTS:
				return getRawMeasurements() != null;
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
		result.append(" (valuesUuid: ");
		result.append(valuesUuid);
		result.append(')');
		return result.toString();
	}

} //DataSeriesImpl
