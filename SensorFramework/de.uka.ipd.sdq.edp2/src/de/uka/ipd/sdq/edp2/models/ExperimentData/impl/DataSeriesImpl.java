/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage;
import de.uka.ipd.sdq.edp2.models.ExperimentData.FixedWidthAggregatedMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalNominalStatistics;
import de.uka.ipd.sdq.edp2.models.ExperimentData.RawMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.TextualNominalStatistics;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Series</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.DataSeriesImpl#getNumericalStatistics <em>Numerical Statistics</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.DataSeriesImpl#getAggregatedMeasurements <em>Aggregated Measurements</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.DataSeriesImpl#getValuesUuid <em>Values Uuid</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.DataSeriesImpl#getTextualStatistics <em>Textual Statistics</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.DataSeriesImpl#getRawMeasurements <em>Raw Measurements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DataSeriesImpl extends EObjectImpl implements DataSeries {
	/**
     * The cached value of the '{@link #getNumericalStatistics() <em>Numerical Statistics</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getNumericalStatistics()
     * @generated
     * @ordered
     */
	protected NumericalNominalStatistics numericalStatistics;

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
     * The cached value of the '{@link #getTextualStatistics() <em>Textual Statistics</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTextualStatistics()
     * @generated
     * @ordered
     */
	protected TextualNominalStatistics textualStatistics;

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
        return ExperimentDataPackage.Literals.DATA_SERIES;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NumericalNominalStatistics getNumericalStatistics() {
        return numericalStatistics;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetNumericalStatistics(NumericalNominalStatistics newNumericalStatistics, NotificationChain msgs) {
        NumericalNominalStatistics oldNumericalStatistics = numericalStatistics;
        numericalStatistics = newNumericalStatistics;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.DATA_SERIES__NUMERICAL_STATISTICS, oldNumericalStatistics, newNumericalStatistics);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setNumericalStatistics(NumericalNominalStatistics newNumericalStatistics) {
        if (newNumericalStatistics != numericalStatistics) {
            NotificationChain msgs = null;
            if (numericalStatistics != null)
                msgs = ((InternalEObject)numericalStatistics).eInverseRemove(this, ExperimentDataPackage.NUMERICAL_NOMINAL_STATISTICS__DATA_SERIES, NumericalNominalStatistics.class, msgs);
            if (newNumericalStatistics != null)
                msgs = ((InternalEObject)newNumericalStatistics).eInverseAdd(this, ExperimentDataPackage.NUMERICAL_NOMINAL_STATISTICS__DATA_SERIES, NumericalNominalStatistics.class, msgs);
            msgs = basicSetNumericalStatistics(newNumericalStatistics, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.DATA_SERIES__NUMERICAL_STATISTICS, newNumericalStatistics, newNumericalStatistics));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public FixedWidthAggregatedMeasurements getAggregatedMeasurements() {
        if (eContainerFeatureID() != ExperimentDataPackage.DATA_SERIES__AGGREGATED_MEASUREMENTS) return null;
        return (FixedWidthAggregatedMeasurements)eInternalContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetAggregatedMeasurements(FixedWidthAggregatedMeasurements newAggregatedMeasurements, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newAggregatedMeasurements, ExperimentDataPackage.DATA_SERIES__AGGREGATED_MEASUREMENTS, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setAggregatedMeasurements(FixedWidthAggregatedMeasurements newAggregatedMeasurements) {
        if (newAggregatedMeasurements != eInternalContainer() || (eContainerFeatureID() != ExperimentDataPackage.DATA_SERIES__AGGREGATED_MEASUREMENTS && newAggregatedMeasurements != null)) {
            if (EcoreUtil.isAncestor(this, newAggregatedMeasurements))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newAggregatedMeasurements != null)
                msgs = ((InternalEObject)newAggregatedMeasurements).eInverseAdd(this, ExperimentDataPackage.FIXED_WIDTH_AGGREGATED_MEASUREMENTS__DATA_SERIES, FixedWidthAggregatedMeasurements.class, msgs);
            msgs = basicSetAggregatedMeasurements(newAggregatedMeasurements, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.DATA_SERIES__AGGREGATED_MEASUREMENTS, newAggregatedMeasurements, newAggregatedMeasurements));
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
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.DATA_SERIES__VALUES_UUID, oldValuesUuid, valuesUuid));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public TextualNominalStatistics getTextualStatistics() {
        return textualStatistics;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetTextualStatistics(TextualNominalStatistics newTextualStatistics, NotificationChain msgs) {
        TextualNominalStatistics oldTextualStatistics = textualStatistics;
        textualStatistics = newTextualStatistics;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.DATA_SERIES__TEXTUAL_STATISTICS, oldTextualStatistics, newTextualStatistics);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setTextualStatistics(TextualNominalStatistics newTextualStatistics) {
        if (newTextualStatistics != textualStatistics) {
            NotificationChain msgs = null;
            if (textualStatistics != null)
                msgs = ((InternalEObject)textualStatistics).eInverseRemove(this, ExperimentDataPackage.TEXTUAL_NOMINAL_STATISTICS__DATA_SERIES, TextualNominalStatistics.class, msgs);
            if (newTextualStatistics != null)
                msgs = ((InternalEObject)newTextualStatistics).eInverseAdd(this, ExperimentDataPackage.TEXTUAL_NOMINAL_STATISTICS__DATA_SERIES, TextualNominalStatistics.class, msgs);
            msgs = basicSetTextualStatistics(newTextualStatistics, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.DATA_SERIES__TEXTUAL_STATISTICS, newTextualStatistics, newTextualStatistics));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public RawMeasurements getRawMeasurements() {
        if (eContainerFeatureID() != ExperimentDataPackage.DATA_SERIES__RAW_MEASUREMENTS) return null;
        return (RawMeasurements)eInternalContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetRawMeasurements(RawMeasurements newRawMeasurements, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newRawMeasurements, ExperimentDataPackage.DATA_SERIES__RAW_MEASUREMENTS, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setRawMeasurements(RawMeasurements newRawMeasurements) {
        if (newRawMeasurements != eInternalContainer() || (eContainerFeatureID() != ExperimentDataPackage.DATA_SERIES__RAW_MEASUREMENTS && newRawMeasurements != null)) {
            if (EcoreUtil.isAncestor(this, newRawMeasurements))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newRawMeasurements != null)
                msgs = ((InternalEObject)newRawMeasurements).eInverseAdd(this, ExperimentDataPackage.RAW_MEASUREMENTS__DATA_SERIES, RawMeasurements.class, msgs);
            msgs = basicSetRawMeasurements(newRawMeasurements, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.DATA_SERIES__RAW_MEASUREMENTS, newRawMeasurements, newRawMeasurements));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ExperimentDataPackage.DATA_SERIES__NUMERICAL_STATISTICS:
                if (numericalStatistics != null)
                    msgs = ((InternalEObject)numericalStatistics).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExperimentDataPackage.DATA_SERIES__NUMERICAL_STATISTICS, null, msgs);
                return basicSetNumericalStatistics((NumericalNominalStatistics)otherEnd, msgs);
            case ExperimentDataPackage.DATA_SERIES__AGGREGATED_MEASUREMENTS:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetAggregatedMeasurements((FixedWidthAggregatedMeasurements)otherEnd, msgs);
            case ExperimentDataPackage.DATA_SERIES__TEXTUAL_STATISTICS:
                if (textualStatistics != null)
                    msgs = ((InternalEObject)textualStatistics).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExperimentDataPackage.DATA_SERIES__TEXTUAL_STATISTICS, null, msgs);
                return basicSetTextualStatistics((TextualNominalStatistics)otherEnd, msgs);
            case ExperimentDataPackage.DATA_SERIES__RAW_MEASUREMENTS:
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
            case ExperimentDataPackage.DATA_SERIES__NUMERICAL_STATISTICS:
                return basicSetNumericalStatistics(null, msgs);
            case ExperimentDataPackage.DATA_SERIES__AGGREGATED_MEASUREMENTS:
                return basicSetAggregatedMeasurements(null, msgs);
            case ExperimentDataPackage.DATA_SERIES__TEXTUAL_STATISTICS:
                return basicSetTextualStatistics(null, msgs);
            case ExperimentDataPackage.DATA_SERIES__RAW_MEASUREMENTS:
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
            case ExperimentDataPackage.DATA_SERIES__AGGREGATED_MEASUREMENTS:
                return eInternalContainer().eInverseRemove(this, ExperimentDataPackage.FIXED_WIDTH_AGGREGATED_MEASUREMENTS__DATA_SERIES, FixedWidthAggregatedMeasurements.class, msgs);
            case ExperimentDataPackage.DATA_SERIES__RAW_MEASUREMENTS:
                return eInternalContainer().eInverseRemove(this, ExperimentDataPackage.RAW_MEASUREMENTS__DATA_SERIES, RawMeasurements.class, msgs);
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
            case ExperimentDataPackage.DATA_SERIES__NUMERICAL_STATISTICS:
                return getNumericalStatistics();
            case ExperimentDataPackage.DATA_SERIES__AGGREGATED_MEASUREMENTS:
                return getAggregatedMeasurements();
            case ExperimentDataPackage.DATA_SERIES__VALUES_UUID:
                return getValuesUuid();
            case ExperimentDataPackage.DATA_SERIES__TEXTUAL_STATISTICS:
                return getTextualStatistics();
            case ExperimentDataPackage.DATA_SERIES__RAW_MEASUREMENTS:
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
            case ExperimentDataPackage.DATA_SERIES__NUMERICAL_STATISTICS:
                setNumericalStatistics((NumericalNominalStatistics)newValue);
                return;
            case ExperimentDataPackage.DATA_SERIES__AGGREGATED_MEASUREMENTS:
                setAggregatedMeasurements((FixedWidthAggregatedMeasurements)newValue);
                return;
            case ExperimentDataPackage.DATA_SERIES__VALUES_UUID:
                setValuesUuid((String)newValue);
                return;
            case ExperimentDataPackage.DATA_SERIES__TEXTUAL_STATISTICS:
                setTextualStatistics((TextualNominalStatistics)newValue);
                return;
            case ExperimentDataPackage.DATA_SERIES__RAW_MEASUREMENTS:
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
            case ExperimentDataPackage.DATA_SERIES__NUMERICAL_STATISTICS:
                setNumericalStatistics((NumericalNominalStatistics)null);
                return;
            case ExperimentDataPackage.DATA_SERIES__AGGREGATED_MEASUREMENTS:
                setAggregatedMeasurements((FixedWidthAggregatedMeasurements)null);
                return;
            case ExperimentDataPackage.DATA_SERIES__VALUES_UUID:
                setValuesUuid(VALUES_UUID_EDEFAULT);
                return;
            case ExperimentDataPackage.DATA_SERIES__TEXTUAL_STATISTICS:
                setTextualStatistics((TextualNominalStatistics)null);
                return;
            case ExperimentDataPackage.DATA_SERIES__RAW_MEASUREMENTS:
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
            case ExperimentDataPackage.DATA_SERIES__NUMERICAL_STATISTICS:
                return numericalStatistics != null;
            case ExperimentDataPackage.DATA_SERIES__AGGREGATED_MEASUREMENTS:
                return getAggregatedMeasurements() != null;
            case ExperimentDataPackage.DATA_SERIES__VALUES_UUID:
                return VALUES_UUID_EDEFAULT == null ? valuesUuid != null : !VALUES_UUID_EDEFAULT.equals(valuesUuid);
            case ExperimentDataPackage.DATA_SERIES__TEXTUAL_STATISTICS:
                return textualStatistics != null;
            case ExperimentDataPackage.DATA_SERIES__RAW_MEASUREMENTS:
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
