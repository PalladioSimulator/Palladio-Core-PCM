/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData.impl;

import java.util.Collection;

import javax.measure.Measure;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage;
import de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalMassDistribution;
import de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalNominalStatistics;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Numerical Nominal Statistics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.NumericalNominalStatisticsImpl#getNumberMeasurements <em>Number Measurements</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.NumericalNominalStatisticsImpl#getNumericalMassDistribution <em>Numerical Mass Distribution</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.NumericalNominalStatisticsImpl#getDataSeries <em>Data Series</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NumericalNominalStatisticsImpl extends IdentifiableImpl implements NumericalNominalStatistics {
	/**
     * The cached value of the '{@link #getNumberMeasurements() <em>Number Measurements</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getNumberMeasurements()
     * @generated
     * @ordered
     */
	protected Measure numberMeasurements;

	/**
     * The cached value of the '{@link #getNumericalMassDistribution() <em>Numerical Mass Distribution</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getNumericalMassDistribution()
     * @generated
     * @ordered
     */
	protected EList<NumericalMassDistribution> numericalMassDistribution;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected NumericalNominalStatisticsImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExperimentDataPackage.Literals.NUMERICAL_NOMINAL_STATISTICS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Measure getNumberMeasurements() {
        return numberMeasurements;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setNumberMeasurements(Measure newNumberMeasurements) {
        Measure oldNumberMeasurements = numberMeasurements;
        numberMeasurements = newNumberMeasurements;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.NUMERICAL_NOMINAL_STATISTICS__NUMBER_MEASUREMENTS, oldNumberMeasurements, numberMeasurements));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<NumericalMassDistribution> getNumericalMassDistribution() {
        if (numericalMassDistribution == null) {
            numericalMassDistribution = new EObjectContainmentWithInverseEList<NumericalMassDistribution>(NumericalMassDistribution.class, this, ExperimentDataPackage.NUMERICAL_NOMINAL_STATISTICS__NUMERICAL_MASS_DISTRIBUTION, ExperimentDataPackage.NUMERICAL_MASS_DISTRIBUTION__NUMERICAL_NOMINAL_STATISTICS);
        }
        return numericalMassDistribution;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DataSeries getDataSeries() {
        if (eContainerFeatureID() != ExperimentDataPackage.NUMERICAL_NOMINAL_STATISTICS__DATA_SERIES) return null;
        return (DataSeries)eInternalContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetDataSeries(DataSeries newDataSeries, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newDataSeries, ExperimentDataPackage.NUMERICAL_NOMINAL_STATISTICS__DATA_SERIES, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setDataSeries(DataSeries newDataSeries) {
        if (newDataSeries != eInternalContainer() || (eContainerFeatureID() != ExperimentDataPackage.NUMERICAL_NOMINAL_STATISTICS__DATA_SERIES && newDataSeries != null)) {
            if (EcoreUtil.isAncestor(this, newDataSeries))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newDataSeries != null)
                msgs = ((InternalEObject)newDataSeries).eInverseAdd(this, ExperimentDataPackage.DATA_SERIES__NUMERICAL_STATISTICS, DataSeries.class, msgs);
            msgs = basicSetDataSeries(newDataSeries, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.NUMERICAL_NOMINAL_STATISTICS__DATA_SERIES, newDataSeries, newDataSeries));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ExperimentDataPackage.NUMERICAL_NOMINAL_STATISTICS__NUMERICAL_MASS_DISTRIBUTION:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getNumericalMassDistribution()).basicAdd(otherEnd, msgs);
            case ExperimentDataPackage.NUMERICAL_NOMINAL_STATISTICS__DATA_SERIES:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetDataSeries((DataSeries)otherEnd, msgs);
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
            case ExperimentDataPackage.NUMERICAL_NOMINAL_STATISTICS__NUMERICAL_MASS_DISTRIBUTION:
                return ((InternalEList<?>)getNumericalMassDistribution()).basicRemove(otherEnd, msgs);
            case ExperimentDataPackage.NUMERICAL_NOMINAL_STATISTICS__DATA_SERIES:
                return basicSetDataSeries(null, msgs);
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
            case ExperimentDataPackage.NUMERICAL_NOMINAL_STATISTICS__DATA_SERIES:
                return eInternalContainer().eInverseRemove(this, ExperimentDataPackage.DATA_SERIES__NUMERICAL_STATISTICS, DataSeries.class, msgs);
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
            case ExperimentDataPackage.NUMERICAL_NOMINAL_STATISTICS__NUMBER_MEASUREMENTS:
                return getNumberMeasurements();
            case ExperimentDataPackage.NUMERICAL_NOMINAL_STATISTICS__NUMERICAL_MASS_DISTRIBUTION:
                return getNumericalMassDistribution();
            case ExperimentDataPackage.NUMERICAL_NOMINAL_STATISTICS__DATA_SERIES:
                return getDataSeries();
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
            case ExperimentDataPackage.NUMERICAL_NOMINAL_STATISTICS__NUMBER_MEASUREMENTS:
                setNumberMeasurements((Measure)newValue);
                return;
            case ExperimentDataPackage.NUMERICAL_NOMINAL_STATISTICS__NUMERICAL_MASS_DISTRIBUTION:
                getNumericalMassDistribution().clear();
                getNumericalMassDistribution().addAll((Collection<? extends NumericalMassDistribution>)newValue);
                return;
            case ExperimentDataPackage.NUMERICAL_NOMINAL_STATISTICS__DATA_SERIES:
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
            case ExperimentDataPackage.NUMERICAL_NOMINAL_STATISTICS__NUMBER_MEASUREMENTS:
                setNumberMeasurements((Measure)null);
                return;
            case ExperimentDataPackage.NUMERICAL_NOMINAL_STATISTICS__NUMERICAL_MASS_DISTRIBUTION:
                getNumericalMassDistribution().clear();
                return;
            case ExperimentDataPackage.NUMERICAL_NOMINAL_STATISTICS__DATA_SERIES:
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
            case ExperimentDataPackage.NUMERICAL_NOMINAL_STATISTICS__NUMBER_MEASUREMENTS:
                return numberMeasurements != null;
            case ExperimentDataPackage.NUMERICAL_NOMINAL_STATISTICS__NUMERICAL_MASS_DISTRIBUTION:
                return numericalMassDistribution != null && !numericalMassDistribution.isEmpty();
            case ExperimentDataPackage.NUMERICAL_NOMINAL_STATISTICS__DATA_SERIES:
                return getDataSeries() != null;
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
        result.append(" (numberMeasurements: ");
        result.append(numberMeasurements);
        result.append(')');
        return result.toString();
    }

} //NumericalNominalStatisticsImpl
