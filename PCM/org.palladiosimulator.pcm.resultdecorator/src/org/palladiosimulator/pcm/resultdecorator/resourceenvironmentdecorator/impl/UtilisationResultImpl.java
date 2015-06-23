/**
 */
package org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult;

import de.uka.ipd.sdq.pcm.core.entity.impl.NamedElementImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Utilisation Result</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.UtilisationResultImpl#getNormalisedResourceUtilisation
 * <em>Normalised Resource Utilisation</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.UtilisationResultImpl#getNormalisedWaitTime
 * <em>Normalised Wait Time</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.UtilisationResultImpl#getResourceUtilisation
 * <em>Resource Utilisation</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.UtilisationResultImpl#getAverageWaitTime
 * <em>Average Wait Time</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.UtilisationResultImpl#getAverageQueueLength
 * <em>Average Queue Length</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.UtilisationResultImpl#getMaxQueueLength
 * <em>Max Queue Length</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class UtilisationResultImpl extends NamedElementImpl implements UtilisationResult {

    /**
     * The default value of the '{@link #getNormalisedResourceUtilisation()
     * <em>Normalised Resource Utilisation</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getNormalisedResourceUtilisation()
     * @generated
     * @ordered
     */
    protected static final double NORMALISED_RESOURCE_UTILISATION_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getNormalisedResourceUtilisation()
     * <em>Normalised Resource Utilisation</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getNormalisedResourceUtilisation()
     * @generated
     * @ordered
     */
    protected double normalisedResourceUtilisation = NORMALISED_RESOURCE_UTILISATION_EDEFAULT;

    /**
     * The default value of the '{@link #getNormalisedWaitTime() <em>Normalised Wait Time</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getNormalisedWaitTime()
     * @generated
     * @ordered
     */
    protected static final double NORMALISED_WAIT_TIME_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getNormalisedWaitTime() <em>Normalised Wait Time</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getNormalisedWaitTime()
     * @generated
     * @ordered
     */
    protected double normalisedWaitTime = NORMALISED_WAIT_TIME_EDEFAULT;

    /**
     * The default value of the '{@link #getResourceUtilisation() <em>Resource Utilisation</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getResourceUtilisation()
     * @generated
     * @ordered
     */
    protected static final double RESOURCE_UTILISATION_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getResourceUtilisation() <em>Resource Utilisation</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getResourceUtilisation()
     * @generated
     * @ordered
     */
    protected double resourceUtilisation = RESOURCE_UTILISATION_EDEFAULT;

    /**
     * The default value of the '{@link #getAverageWaitTime() <em>Average Wait Time</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getAverageWaitTime()
     * @generated
     * @ordered
     */
    protected static final double AVERAGE_WAIT_TIME_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getAverageWaitTime() <em>Average Wait Time</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getAverageWaitTime()
     * @generated
     * @ordered
     */
    protected double averageWaitTime = AVERAGE_WAIT_TIME_EDEFAULT;

    /**
     * The default value of the '{@link #getAverageQueueLength() <em>Average Queue Length</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getAverageQueueLength()
     * @generated
     * @ordered
     */
    protected static final double AVERAGE_QUEUE_LENGTH_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getAverageQueueLength() <em>Average Queue Length</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getAverageQueueLength()
     * @generated
     * @ordered
     */
    protected double averageQueueLength = AVERAGE_QUEUE_LENGTH_EDEFAULT;

    /**
     * The default value of the '{@link #getMaxQueueLength() <em>Max Queue Length</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getMaxQueueLength()
     * @generated
     * @ordered
     */
    protected static final int MAX_QUEUE_LENGTH_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getMaxQueueLength() <em>Max Queue Length</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getMaxQueueLength()
     * @generated
     * @ordered
     */
    protected int maxQueueLength = MAX_QUEUE_LENGTH_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected UtilisationResultImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ResourceenvironmentdecoratorPackage.Literals.UTILISATION_RESULT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public double getNormalisedResourceUtilisation() {
        return this.normalisedResourceUtilisation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setNormalisedResourceUtilisation(final double newNormalisedResourceUtilisation) {
        final double oldNormalisedResourceUtilisation = this.normalisedResourceUtilisation;
        this.normalisedResourceUtilisation = newNormalisedResourceUtilisation;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__NORMALISED_RESOURCE_UTILISATION,
                    oldNormalisedResourceUtilisation, this.normalisedResourceUtilisation));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public double getNormalisedWaitTime() {
        return this.normalisedWaitTime;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setNormalisedWaitTime(final double newNormalisedWaitTime) {
        final double oldNormalisedWaitTime = this.normalisedWaitTime;
        this.normalisedWaitTime = newNormalisedWaitTime;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__NORMALISED_WAIT_TIME, oldNormalisedWaitTime,
                    this.normalisedWaitTime));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public double getResourceUtilisation() {
        return this.resourceUtilisation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setResourceUtilisation(final double newResourceUtilisation) {
        final double oldResourceUtilisation = this.resourceUtilisation;
        this.resourceUtilisation = newResourceUtilisation;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__RESOURCE_UTILISATION,
                    oldResourceUtilisation, this.resourceUtilisation));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public double getAverageWaitTime() {
        return this.averageWaitTime;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setAverageWaitTime(final double newAverageWaitTime) {
        final double oldAverageWaitTime = this.averageWaitTime;
        this.averageWaitTime = newAverageWaitTime;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__AVERAGE_WAIT_TIME, oldAverageWaitTime,
                    this.averageWaitTime));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public double getAverageQueueLength() {
        return this.averageQueueLength;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setAverageQueueLength(final double newAverageQueueLength) {
        final double oldAverageQueueLength = this.averageQueueLength;
        this.averageQueueLength = newAverageQueueLength;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__AVERAGE_QUEUE_LENGTH, oldAverageQueueLength,
                    this.averageQueueLength));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getMaxQueueLength() {
        return this.maxQueueLength;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setMaxQueueLength(final int newMaxQueueLength) {
        final int oldMaxQueueLength = this.maxQueueLength;
        this.maxQueueLength = newMaxQueueLength;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__MAX_QUEUE_LENGTH, oldMaxQueueLength,
                    this.maxQueueLength));
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
        case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__NORMALISED_RESOURCE_UTILISATION:
            return this.getNormalisedResourceUtilisation();
        case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__NORMALISED_WAIT_TIME:
            return this.getNormalisedWaitTime();
        case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__RESOURCE_UTILISATION:
            return this.getResourceUtilisation();
        case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__AVERAGE_WAIT_TIME:
            return this.getAverageWaitTime();
        case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__AVERAGE_QUEUE_LENGTH:
            return this.getAverageQueueLength();
        case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__MAX_QUEUE_LENGTH:
            return this.getMaxQueueLength();
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
        case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__NORMALISED_RESOURCE_UTILISATION:
            this.setNormalisedResourceUtilisation((Double) newValue);
            return;
        case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__NORMALISED_WAIT_TIME:
            this.setNormalisedWaitTime((Double) newValue);
            return;
        case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__RESOURCE_UTILISATION:
            this.setResourceUtilisation((Double) newValue);
            return;
        case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__AVERAGE_WAIT_TIME:
            this.setAverageWaitTime((Double) newValue);
            return;
        case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__AVERAGE_QUEUE_LENGTH:
            this.setAverageQueueLength((Double) newValue);
            return;
        case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__MAX_QUEUE_LENGTH:
            this.setMaxQueueLength((Integer) newValue);
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
        case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__NORMALISED_RESOURCE_UTILISATION:
            this.setNormalisedResourceUtilisation(NORMALISED_RESOURCE_UTILISATION_EDEFAULT);
            return;
        case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__NORMALISED_WAIT_TIME:
            this.setNormalisedWaitTime(NORMALISED_WAIT_TIME_EDEFAULT);
            return;
        case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__RESOURCE_UTILISATION:
            this.setResourceUtilisation(RESOURCE_UTILISATION_EDEFAULT);
            return;
        case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__AVERAGE_WAIT_TIME:
            this.setAverageWaitTime(AVERAGE_WAIT_TIME_EDEFAULT);
            return;
        case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__AVERAGE_QUEUE_LENGTH:
            this.setAverageQueueLength(AVERAGE_QUEUE_LENGTH_EDEFAULT);
            return;
        case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__MAX_QUEUE_LENGTH:
            this.setMaxQueueLength(MAX_QUEUE_LENGTH_EDEFAULT);
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
        case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__NORMALISED_RESOURCE_UTILISATION:
            return this.normalisedResourceUtilisation != NORMALISED_RESOURCE_UTILISATION_EDEFAULT;
        case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__NORMALISED_WAIT_TIME:
            return this.normalisedWaitTime != NORMALISED_WAIT_TIME_EDEFAULT;
        case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__RESOURCE_UTILISATION:
            return this.resourceUtilisation != RESOURCE_UTILISATION_EDEFAULT;
        case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__AVERAGE_WAIT_TIME:
            return this.averageWaitTime != AVERAGE_WAIT_TIME_EDEFAULT;
        case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__AVERAGE_QUEUE_LENGTH:
            return this.averageQueueLength != AVERAGE_QUEUE_LENGTH_EDEFAULT;
        case ResourceenvironmentdecoratorPackage.UTILISATION_RESULT__MAX_QUEUE_LENGTH:
            return this.maxQueueLength != MAX_QUEUE_LENGTH_EDEFAULT;
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
        result.append(" (normalisedResourceUtilisation: ");
        result.append(this.normalisedResourceUtilisation);
        result.append(", normalisedWaitTime: ");
        result.append(this.normalisedWaitTime);
        result.append(", resourceUtilisation: ");
        result.append(this.resourceUtilisation);
        result.append(", averageWaitTime: ");
        result.append(this.averageWaitTime);
        result.append(", averageQueueLength: ");
        result.append(this.averageQueueLength);
        result.append(", maxQueueLength: ");
        result.append(this.maxQueueLength);
        result.append(')');
        return result.toString();
    }

} // UtilisationResultImpl
