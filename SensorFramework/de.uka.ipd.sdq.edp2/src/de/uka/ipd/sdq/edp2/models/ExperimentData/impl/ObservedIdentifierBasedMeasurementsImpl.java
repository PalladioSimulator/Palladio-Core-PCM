/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.ExperimentData.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedIdentifier;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedIdentifierBasedMeasurements;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Observed Identifier Based Measurements</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.ObservedIdentifierBasedMeasurementsImpl#getObservedIdentifiers <em>Observed Identifiers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ObservedIdentifierBasedMeasurementsImpl extends IdentifiableImpl implements ObservedIdentifierBasedMeasurements {
	/**
     * The cached value of the '{@link #getObservedIdentifiers() <em>Observed Identifiers</em>}' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getObservedIdentifiers()
     * @generated
     * @ordered
     */
	protected EList<ObservedIdentifier> observedIdentifiers;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ObservedIdentifierBasedMeasurementsImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExperimentDataPackage.Literals.OBSERVED_IDENTIFIER_BASED_MEASUREMENTS;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<ObservedIdentifier> getObservedIdentifiers() {
        if (observedIdentifiers == null) {
            observedIdentifiers = new EObjectContainmentWithInverseEList<ObservedIdentifier>(ObservedIdentifier.class, this, ExperimentDataPackage.OBSERVED_IDENTIFIER_BASED_MEASUREMENTS__OBSERVED_IDENTIFIERS, ExperimentDataPackage.OBSERVED_IDENTIFIER__OBSERVED_IDENTIFIER_BASED_MEASUREMENTS);
        }
        return observedIdentifiers;
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
            case ExperimentDataPackage.OBSERVED_IDENTIFIER_BASED_MEASUREMENTS__OBSERVED_IDENTIFIERS:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getObservedIdentifiers()).basicAdd(otherEnd, msgs);
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
            case ExperimentDataPackage.OBSERVED_IDENTIFIER_BASED_MEASUREMENTS__OBSERVED_IDENTIFIERS:
                return ((InternalEList<?>)getObservedIdentifiers()).basicRemove(otherEnd, msgs);
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
            case ExperimentDataPackage.OBSERVED_IDENTIFIER_BASED_MEASUREMENTS__OBSERVED_IDENTIFIERS:
                return getObservedIdentifiers();
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
            case ExperimentDataPackage.OBSERVED_IDENTIFIER_BASED_MEASUREMENTS__OBSERVED_IDENTIFIERS:
                getObservedIdentifiers().clear();
                getObservedIdentifiers().addAll((Collection<? extends ObservedIdentifier>)newValue);
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
            case ExperimentDataPackage.OBSERVED_IDENTIFIER_BASED_MEASUREMENTS__OBSERVED_IDENTIFIERS:
                getObservedIdentifiers().clear();
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
            case ExperimentDataPackage.OBSERVED_IDENTIFIER_BASED_MEASUREMENTS__OBSERVED_IDENTIFIERS:
                return observedIdentifiers != null && !observedIdentifiers.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //ObservedIdentifierBasedMeasurementsImpl
