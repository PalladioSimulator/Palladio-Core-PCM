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
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataPackage;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Identifier;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedIdentifier;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedIdentifierBasedMeasurements;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Observed Identifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.ObservedIdentifierImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.edp2.models.ExperimentData.impl.ObservedIdentifierImpl#getObservedIdentifierBasedMeasurements <em>Observed Identifier Based Measurements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ObservedIdentifierImpl extends IdentifiableImpl implements ObservedIdentifier {
	/**
     * The cached value of the '{@link #getIdentifier() <em>Identifier</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getIdentifier()
     * @generated
     * @ordered
     */
	protected Identifier identifier;
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ObservedIdentifierImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return ExperimentDataPackage.Literals.OBSERVED_IDENTIFIER;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Identifier getIdentifier() {
        if (identifier != null && identifier.eIsProxy()) {
            InternalEObject oldIdentifier = (InternalEObject)identifier;
            identifier = (Identifier)eResolveProxy(oldIdentifier);
            if (identifier != oldIdentifier) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExperimentDataPackage.OBSERVED_IDENTIFIER__IDENTIFIER, oldIdentifier, identifier));
            }
        }
        return identifier;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Identifier basicGetIdentifier() {
        return identifier;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setIdentifier(Identifier newIdentifier) {
        Identifier oldIdentifier = identifier;
        identifier = newIdentifier;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.OBSERVED_IDENTIFIER__IDENTIFIER, oldIdentifier, identifier));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ObservedIdentifierBasedMeasurements getObservedIdentifierBasedMeasurements() {
        if (eContainerFeatureID() != ExperimentDataPackage.OBSERVED_IDENTIFIER__OBSERVED_IDENTIFIER_BASED_MEASUREMENTS) return null;
        return (ObservedIdentifierBasedMeasurements)eInternalContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetObservedIdentifierBasedMeasurements(ObservedIdentifierBasedMeasurements newObservedIdentifierBasedMeasurements, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newObservedIdentifierBasedMeasurements, ExperimentDataPackage.OBSERVED_IDENTIFIER__OBSERVED_IDENTIFIER_BASED_MEASUREMENTS, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setObservedIdentifierBasedMeasurements(ObservedIdentifierBasedMeasurements newObservedIdentifierBasedMeasurements) {
        if (newObservedIdentifierBasedMeasurements != eInternalContainer() || (eContainerFeatureID() != ExperimentDataPackage.OBSERVED_IDENTIFIER__OBSERVED_IDENTIFIER_BASED_MEASUREMENTS && newObservedIdentifierBasedMeasurements != null)) {
            if (EcoreUtil.isAncestor(this, newObservedIdentifierBasedMeasurements))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newObservedIdentifierBasedMeasurements != null)
                msgs = ((InternalEObject)newObservedIdentifierBasedMeasurements).eInverseAdd(this, ExperimentDataPackage.OBSERVED_IDENTIFIER_BASED_MEASUREMENTS__OBSERVED_IDENTIFIERS, ObservedIdentifierBasedMeasurements.class, msgs);
            msgs = basicSetObservedIdentifierBasedMeasurements(newObservedIdentifierBasedMeasurements, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, ExperimentDataPackage.OBSERVED_IDENTIFIER__OBSERVED_IDENTIFIER_BASED_MEASUREMENTS, newObservedIdentifierBasedMeasurements, newObservedIdentifierBasedMeasurements));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case ExperimentDataPackage.OBSERVED_IDENTIFIER__OBSERVED_IDENTIFIER_BASED_MEASUREMENTS:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetObservedIdentifierBasedMeasurements((ObservedIdentifierBasedMeasurements)otherEnd, msgs);
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
            case ExperimentDataPackage.OBSERVED_IDENTIFIER__OBSERVED_IDENTIFIER_BASED_MEASUREMENTS:
                return basicSetObservedIdentifierBasedMeasurements(null, msgs);
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
            case ExperimentDataPackage.OBSERVED_IDENTIFIER__OBSERVED_IDENTIFIER_BASED_MEASUREMENTS:
                return eInternalContainer().eInverseRemove(this, ExperimentDataPackage.OBSERVED_IDENTIFIER_BASED_MEASUREMENTS__OBSERVED_IDENTIFIERS, ObservedIdentifierBasedMeasurements.class, msgs);
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
            case ExperimentDataPackage.OBSERVED_IDENTIFIER__IDENTIFIER:
                if (resolve) return getIdentifier();
                return basicGetIdentifier();
            case ExperimentDataPackage.OBSERVED_IDENTIFIER__OBSERVED_IDENTIFIER_BASED_MEASUREMENTS:
                return getObservedIdentifierBasedMeasurements();
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
            case ExperimentDataPackage.OBSERVED_IDENTIFIER__IDENTIFIER:
                setIdentifier((Identifier)newValue);
                return;
            case ExperimentDataPackage.OBSERVED_IDENTIFIER__OBSERVED_IDENTIFIER_BASED_MEASUREMENTS:
                setObservedIdentifierBasedMeasurements((ObservedIdentifierBasedMeasurements)newValue);
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
            case ExperimentDataPackage.OBSERVED_IDENTIFIER__IDENTIFIER:
                setIdentifier((Identifier)null);
                return;
            case ExperimentDataPackage.OBSERVED_IDENTIFIER__OBSERVED_IDENTIFIER_BASED_MEASUREMENTS:
                setObservedIdentifierBasedMeasurements((ObservedIdentifierBasedMeasurements)null);
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
            case ExperimentDataPackage.OBSERVED_IDENTIFIER__IDENTIFIER:
                return identifier != null;
            case ExperimentDataPackage.OBSERVED_IDENTIFIER__OBSERVED_IDENTIFIER_BASED_MEASUREMENTS:
                return getObservedIdentifierBasedMeasurements() != null;
        }
        return super.eIsSet(featureID);
    }

} //ObservedIdentifierImpl
