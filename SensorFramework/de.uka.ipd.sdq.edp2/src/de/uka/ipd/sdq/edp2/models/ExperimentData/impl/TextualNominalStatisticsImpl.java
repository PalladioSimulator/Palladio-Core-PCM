/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage;
import de.uka.ipd.sdq.edp2.models.ExperimentData.TextualMassDistribution;
import de.uka.ipd.sdq.edp2.models.ExperimentData.TextualNominalStatistics;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Textual Nominal Statistics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.TextualNominalStatisticsImpl#getNumberMeasurements <em>Number Measurements</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.TextualNominalStatisticsImpl#getMassDistribution <em>Mass Distribution</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.TextualNominalStatisticsImpl#getDataSeries <em>Data Series</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TextualNominalStatisticsImpl extends EObjectImpl implements TextualNominalStatistics {
	/**
     * The default value of the '{@link #getNumberMeasurements() <em>Number Measurements</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getNumberMeasurements()
     * @generated
     * @ordered
     */
	protected static final long NUMBER_MEASUREMENTS_EDEFAULT = 0L;

	/**
     * The cached value of the '{@link #getNumberMeasurements() <em>Number Measurements</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getNumberMeasurements()
     * @generated
     * @ordered
     */
	protected long numberMeasurements = NUMBER_MEASUREMENTS_EDEFAULT;

	/**
     * The cached value of the '{@link #getMassDistribution() <em>Mass Distribution</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getMassDistribution()
     * @generated
     * @ordered
     */
	protected EList<TextualMassDistribution> massDistribution;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected TextualNominalStatisticsImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExperimentDataPackage.Literals.TEXTUAL_NOMINAL_STATISTICS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public long getNumberMeasurements() {
        return numberMeasurements;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setNumberMeasurements(long newNumberMeasurements) {
        long oldNumberMeasurements = numberMeasurements;
        numberMeasurements = newNumberMeasurements;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.TEXTUAL_NOMINAL_STATISTICS__NUMBER_MEASUREMENTS, oldNumberMeasurements, numberMeasurements));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<TextualMassDistribution> getMassDistribution() {
        if (massDistribution == null) {
            massDistribution = new EObjectContainmentWithInverseEList<TextualMassDistribution>(TextualMassDistribution.class, this, ExperimentDataPackage.TEXTUAL_NOMINAL_STATISTICS__MASS_DISTRIBUTION, ExperimentDataPackage.TEXTUAL_MASS_DISTRIBUTION__TEXTUAL_NOMINAL_STATISTICS);
        }
        return massDistribution;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DataSeries getDataSeries() {
        if (eContainerFeatureID() != ExperimentDataPackage.TEXTUAL_NOMINAL_STATISTICS__DATA_SERIES) return null;
        return (DataSeries)eInternalContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetDataSeries(DataSeries newDataSeries, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newDataSeries, ExperimentDataPackage.TEXTUAL_NOMINAL_STATISTICS__DATA_SERIES, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setDataSeries(DataSeries newDataSeries) {
        if (newDataSeries != eInternalContainer() || (eContainerFeatureID() != ExperimentDataPackage.TEXTUAL_NOMINAL_STATISTICS__DATA_SERIES && newDataSeries != null)) {
            if (EcoreUtil.isAncestor(this, newDataSeries))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newDataSeries != null)
                msgs = ((InternalEObject)newDataSeries).eInverseAdd(this, ExperimentDataPackage.DATA_SERIES__TEXTUAL_STATISTICS, DataSeries.class, msgs);
            msgs = basicSetDataSeries(newDataSeries, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.TEXTUAL_NOMINAL_STATISTICS__DATA_SERIES, newDataSeries, newDataSeries));
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
            case ExperimentDataPackage.TEXTUAL_NOMINAL_STATISTICS__MASS_DISTRIBUTION:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getMassDistribution()).basicAdd(otherEnd, msgs);
            case ExperimentDataPackage.TEXTUAL_NOMINAL_STATISTICS__DATA_SERIES:
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
            case ExperimentDataPackage.TEXTUAL_NOMINAL_STATISTICS__MASS_DISTRIBUTION:
                return ((InternalEList<?>)getMassDistribution()).basicRemove(otherEnd, msgs);
            case ExperimentDataPackage.TEXTUAL_NOMINAL_STATISTICS__DATA_SERIES:
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
            case ExperimentDataPackage.TEXTUAL_NOMINAL_STATISTICS__DATA_SERIES:
                return eInternalContainer().eInverseRemove(this, ExperimentDataPackage.DATA_SERIES__TEXTUAL_STATISTICS, DataSeries.class, msgs);
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
            case ExperimentDataPackage.TEXTUAL_NOMINAL_STATISTICS__NUMBER_MEASUREMENTS:
                return getNumberMeasurements();
            case ExperimentDataPackage.TEXTUAL_NOMINAL_STATISTICS__MASS_DISTRIBUTION:
                return getMassDistribution();
            case ExperimentDataPackage.TEXTUAL_NOMINAL_STATISTICS__DATA_SERIES:
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
            case ExperimentDataPackage.TEXTUAL_NOMINAL_STATISTICS__NUMBER_MEASUREMENTS:
                setNumberMeasurements((Long)newValue);
                return;
            case ExperimentDataPackage.TEXTUAL_NOMINAL_STATISTICS__MASS_DISTRIBUTION:
                getMassDistribution().clear();
                getMassDistribution().addAll((Collection<? extends TextualMassDistribution>)newValue);
                return;
            case ExperimentDataPackage.TEXTUAL_NOMINAL_STATISTICS__DATA_SERIES:
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
            case ExperimentDataPackage.TEXTUAL_NOMINAL_STATISTICS__NUMBER_MEASUREMENTS:
                setNumberMeasurements(NUMBER_MEASUREMENTS_EDEFAULT);
                return;
            case ExperimentDataPackage.TEXTUAL_NOMINAL_STATISTICS__MASS_DISTRIBUTION:
                getMassDistribution().clear();
                return;
            case ExperimentDataPackage.TEXTUAL_NOMINAL_STATISTICS__DATA_SERIES:
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
            case ExperimentDataPackage.TEXTUAL_NOMINAL_STATISTICS__NUMBER_MEASUREMENTS:
                return numberMeasurements != NUMBER_MEASUREMENTS_EDEFAULT;
            case ExperimentDataPackage.TEXTUAL_NOMINAL_STATISTICS__MASS_DISTRIBUTION:
                return massDistribution != null && !massDistribution.isEmpty();
            case ExperimentDataPackage.TEXTUAL_NOMINAL_STATISTICS__DATA_SERIES:
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

} //TextualNominalStatisticsImpl
