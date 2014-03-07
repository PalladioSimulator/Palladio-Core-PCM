/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData.impl;

import javax.measure.Measure;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage;
import de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalMassDistribution;
import de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalNominalStatistics;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Numerical Mass Distribution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.NumericalMassDistributionImpl#getFrequency <em>Frequency</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.NumericalMassDistributionImpl#getValue <em>Value</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.NumericalMassDistributionImpl#getNumericalNominalStatistics <em>Numerical Nominal Statistics</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NumericalMassDistributionImpl extends EObjectImpl implements NumericalMassDistribution {
	/**
     * The default value of the '{@link #getFrequency() <em>Frequency</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getFrequency()
     * @generated
     * @ordered
     */
	protected static final long FREQUENCY_EDEFAULT = 0L;

	/**
     * The cached value of the '{@link #getFrequency() <em>Frequency</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getFrequency()
     * @generated
     * @ordered
     */
	protected long frequency = FREQUENCY_EDEFAULT;

	/**
     * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getValue()
     * @generated
     * @ordered
     */
	protected Measure value;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected NumericalMassDistributionImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExperimentDataPackage.Literals.NUMERICAL_MASS_DISTRIBUTION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public long getFrequency() {
        return frequency;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setFrequency(long newFrequency) {
        long oldFrequency = frequency;
        frequency = newFrequency;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.NUMERICAL_MASS_DISTRIBUTION__FREQUENCY, oldFrequency, frequency));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Measure getValue() {
        return value;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setValue(Measure newValue) {
        Measure oldValue = value;
        value = newValue;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.NUMERICAL_MASS_DISTRIBUTION__VALUE, oldValue, value));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NumericalNominalStatistics getNumericalNominalStatistics() {
        if (eContainerFeatureID() != ExperimentDataPackage.NUMERICAL_MASS_DISTRIBUTION__NUMERICAL_NOMINAL_STATISTICS) return null;
        return (NumericalNominalStatistics)eInternalContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetNumericalNominalStatistics(NumericalNominalStatistics newNumericalNominalStatistics, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newNumericalNominalStatistics, ExperimentDataPackage.NUMERICAL_MASS_DISTRIBUTION__NUMERICAL_NOMINAL_STATISTICS, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setNumericalNominalStatistics(NumericalNominalStatistics newNumericalNominalStatistics) {
        if (newNumericalNominalStatistics != eInternalContainer() || (eContainerFeatureID() != ExperimentDataPackage.NUMERICAL_MASS_DISTRIBUTION__NUMERICAL_NOMINAL_STATISTICS && newNumericalNominalStatistics != null)) {
            if (EcoreUtil.isAncestor(this, newNumericalNominalStatistics))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newNumericalNominalStatistics != null)
                msgs = ((InternalEObject)newNumericalNominalStatistics).eInverseAdd(this, ExperimentDataPackage.NUMERICAL_NOMINAL_STATISTICS__NUMERICAL_MASS_DISTRIBUTION, NumericalNominalStatistics.class, msgs);
            msgs = basicSetNumericalNominalStatistics(newNumericalNominalStatistics, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.NUMERICAL_MASS_DISTRIBUTION__NUMERICAL_NOMINAL_STATISTICS, newNumericalNominalStatistics, newNumericalNominalStatistics));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ExperimentDataPackage.NUMERICAL_MASS_DISTRIBUTION__NUMERICAL_NOMINAL_STATISTICS:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetNumericalNominalStatistics((NumericalNominalStatistics)otherEnd, msgs);
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
            case ExperimentDataPackage.NUMERICAL_MASS_DISTRIBUTION__NUMERICAL_NOMINAL_STATISTICS:
                return basicSetNumericalNominalStatistics(null, msgs);
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
            case ExperimentDataPackage.NUMERICAL_MASS_DISTRIBUTION__NUMERICAL_NOMINAL_STATISTICS:
                return eInternalContainer().eInverseRemove(this, ExperimentDataPackage.NUMERICAL_NOMINAL_STATISTICS__NUMERICAL_MASS_DISTRIBUTION, NumericalNominalStatistics.class, msgs);
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
            case ExperimentDataPackage.NUMERICAL_MASS_DISTRIBUTION__FREQUENCY:
                return getFrequency();
            case ExperimentDataPackage.NUMERICAL_MASS_DISTRIBUTION__VALUE:
                return getValue();
            case ExperimentDataPackage.NUMERICAL_MASS_DISTRIBUTION__NUMERICAL_NOMINAL_STATISTICS:
                return getNumericalNominalStatistics();
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
            case ExperimentDataPackage.NUMERICAL_MASS_DISTRIBUTION__FREQUENCY:
                setFrequency((Long)newValue);
                return;
            case ExperimentDataPackage.NUMERICAL_MASS_DISTRIBUTION__VALUE:
                setValue((Measure)newValue);
                return;
            case ExperimentDataPackage.NUMERICAL_MASS_DISTRIBUTION__NUMERICAL_NOMINAL_STATISTICS:
                setNumericalNominalStatistics((NumericalNominalStatistics)newValue);
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
            case ExperimentDataPackage.NUMERICAL_MASS_DISTRIBUTION__FREQUENCY:
                setFrequency(FREQUENCY_EDEFAULT);
                return;
            case ExperimentDataPackage.NUMERICAL_MASS_DISTRIBUTION__VALUE:
                setValue((Measure)null);
                return;
            case ExperimentDataPackage.NUMERICAL_MASS_DISTRIBUTION__NUMERICAL_NOMINAL_STATISTICS:
                setNumericalNominalStatistics((NumericalNominalStatistics)null);
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
            case ExperimentDataPackage.NUMERICAL_MASS_DISTRIBUTION__FREQUENCY:
                return frequency != FREQUENCY_EDEFAULT;
            case ExperimentDataPackage.NUMERICAL_MASS_DISTRIBUTION__VALUE:
                return value != null;
            case ExperimentDataPackage.NUMERICAL_MASS_DISTRIBUTION__NUMERICAL_NOMINAL_STATISTICS:
                return getNumericalNominalStatistics() != null;
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
        result.append(" (frequency: ");
        result.append(frequency);
        result.append(", value: ");
        result.append(value);
        result.append(')');
        return result.toString();
    }

} //NumericalMassDistributionImpl
