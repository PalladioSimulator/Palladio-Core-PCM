/**
 */
package org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ActiveResourceUtilisationResult;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Active Resource Utilisation Result</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.ActiveResourceUtilisationResultImpl#getNormalisedDemandedTime
 * <em>Normalised Demanded Time</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.ActiveResourceUtilisationResultImpl#getDemandedTime
 * <em>Demanded Time</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ActiveResourceUtilisationResultImpl extends UtilisationResultImpl
        implements ActiveResourceUtilisationResult {

    /**
     * The default value of the '{@link #getNormalisedDemandedTime()
     * <em>Normalised Demanded Time</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getNormalisedDemandedTime()
     * @generated
     * @ordered
     */
    protected static final double NORMALISED_DEMANDED_TIME_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getNormalisedDemandedTime()
     * <em>Normalised Demanded Time</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getNormalisedDemandedTime()
     * @generated
     * @ordered
     */
    protected double normalisedDemandedTime = NORMALISED_DEMANDED_TIME_EDEFAULT;

    /**
     * The default value of the '{@link #getDemandedTime() <em>Demanded Time</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getDemandedTime()
     * @generated
     * @ordered
     */
    protected static final double DEMANDED_TIME_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getDemandedTime() <em>Demanded Time</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getDemandedTime()
     * @generated
     * @ordered
     */
    protected double demandedTime = DEMANDED_TIME_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ActiveResourceUtilisationResultImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ResourceenvironmentdecoratorPackage.Literals.ACTIVE_RESOURCE_UTILISATION_RESULT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public double getNormalisedDemandedTime() {
        return this.normalisedDemandedTime;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setNormalisedDemandedTime(final double newNormalisedDemandedTime) {
        final double oldNormalisedDemandedTime = this.normalisedDemandedTime;
        this.normalisedDemandedTime = newNormalisedDemandedTime;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ResourceenvironmentdecoratorPackage.ACTIVE_RESOURCE_UTILISATION_RESULT__NORMALISED_DEMANDED_TIME,
                    oldNormalisedDemandedTime, this.normalisedDemandedTime));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public double getDemandedTime() {
        return this.demandedTime;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setDemandedTime(final double newDemandedTime) {
        final double oldDemandedTime = this.demandedTime;
        this.demandedTime = newDemandedTime;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ResourceenvironmentdecoratorPackage.ACTIVE_RESOURCE_UTILISATION_RESULT__DEMANDED_TIME,
                    oldDemandedTime, this.demandedTime));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case ResourceenvironmentdecoratorPackage.ACTIVE_RESOURCE_UTILISATION_RESULT__NORMALISED_DEMANDED_TIME:
            return this.getNormalisedDemandedTime();
        case ResourceenvironmentdecoratorPackage.ACTIVE_RESOURCE_UTILISATION_RESULT__DEMANDED_TIME:
            return this.getDemandedTime();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case ResourceenvironmentdecoratorPackage.ACTIVE_RESOURCE_UTILISATION_RESULT__NORMALISED_DEMANDED_TIME:
            this.setNormalisedDemandedTime((Double) newValue);
            return;
        case ResourceenvironmentdecoratorPackage.ACTIVE_RESOURCE_UTILISATION_RESULT__DEMANDED_TIME:
            this.setDemandedTime((Double) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eUnset(final int featureID) {
        switch (featureID) {
        case ResourceenvironmentdecoratorPackage.ACTIVE_RESOURCE_UTILISATION_RESULT__NORMALISED_DEMANDED_TIME:
            this.setNormalisedDemandedTime(NORMALISED_DEMANDED_TIME_EDEFAULT);
            return;
        case ResourceenvironmentdecoratorPackage.ACTIVE_RESOURCE_UTILISATION_RESULT__DEMANDED_TIME:
            this.setDemandedTime(DEMANDED_TIME_EDEFAULT);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case ResourceenvironmentdecoratorPackage.ACTIVE_RESOURCE_UTILISATION_RESULT__NORMALISED_DEMANDED_TIME:
            return this.normalisedDemandedTime != NORMALISED_DEMANDED_TIME_EDEFAULT;
        case ResourceenvironmentdecoratorPackage.ACTIVE_RESOURCE_UTILISATION_RESULT__DEMANDED_TIME:
            return this.demandedTime != DEMANDED_TIME_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String toString() {
        if (this.eIsProxy()) {
            return super.toString();
        }

        final StringBuffer result = new StringBuffer(super.toString());
        result.append(" (normalisedDemandedTime: ");
        result.append(this.normalisedDemandedTime);
        result.append(", demandedTime: ");
        result.append(this.demandedTime);
        result.append(')');
        return result.toString();
    }

} // ActiveResourceUtilisationResultImpl
