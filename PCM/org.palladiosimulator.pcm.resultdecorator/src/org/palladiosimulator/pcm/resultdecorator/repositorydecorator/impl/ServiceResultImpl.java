/**
 */
package org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ServiceResult;
import org.palladiosimulator.pcm.seff.ServiceEffectSpecification;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Service Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.ServiceResultImpl#getMeanResponseTime
 * <em>Mean Response Time</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.ServiceResultImpl#getThroughput
 * <em>Throughput</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.ServiceResultImpl#getServiceEffectSpecification_ServiceResult
 * <em>Service Effect Specification Service Result</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ServiceResultImpl extends EObjectImpl implements ServiceResult {

    /**
     * The default value of the '{@link #getMeanResponseTime() <em>Mean Response Time</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getMeanResponseTime()
     * @generated
     * @ordered
     */
    protected static final double MEAN_RESPONSE_TIME_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getMeanResponseTime() <em>Mean Response Time</em>}'
     * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getMeanResponseTime()
     * @generated
     * @ordered
     */
    protected double meanResponseTime = MEAN_RESPONSE_TIME_EDEFAULT;

    /**
     * The default value of the '{@link #getThroughput() <em>Throughput</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getThroughput()
     * @generated
     * @ordered
     */
    protected static final double THROUGHPUT_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getThroughput() <em>Throughput</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getThroughput()
     * @generated
     * @ordered
     */
    protected double throughput = THROUGHPUT_EDEFAULT;

    /**
     * The cached value of the '{@link #getServiceEffectSpecification_ServiceResult()
     * <em>Service Effect Specification Service Result</em>}' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getServiceEffectSpecification_ServiceResult()
     * @generated
     * @ordered
     */
    protected ServiceEffectSpecification serviceEffectSpecification_ServiceResult;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ServiceResultImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RepositorydecoratorPackage.Literals.SERVICE_RESULT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public double getMeanResponseTime() {
        return this.meanResponseTime;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setMeanResponseTime(final double newMeanResponseTime) {
        final double oldMeanResponseTime = this.meanResponseTime;
        this.meanResponseTime = newMeanResponseTime;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    RepositorydecoratorPackage.SERVICE_RESULT__MEAN_RESPONSE_TIME, oldMeanResponseTime,
                    this.meanResponseTime));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public double getThroughput() {
        return this.throughput;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setThroughput(final double newThroughput) {
        final double oldThroughput = this.throughput;
        this.throughput = newThroughput;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    RepositorydecoratorPackage.SERVICE_RESULT__THROUGHPUT, oldThroughput, this.throughput));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ServiceEffectSpecification getServiceEffectSpecification_ServiceResult() {
        if (this.serviceEffectSpecification_ServiceResult != null
                && ((EObject) this.serviceEffectSpecification_ServiceResult).eIsProxy()) {
            final InternalEObject oldServiceEffectSpecification_ServiceResult = (InternalEObject) this.serviceEffectSpecification_ServiceResult;
            this.serviceEffectSpecification_ServiceResult = (ServiceEffectSpecification) this
                    .eResolveProxy(oldServiceEffectSpecification_ServiceResult);
            if (this.serviceEffectSpecification_ServiceResult != oldServiceEffectSpecification_ServiceResult) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            RepositorydecoratorPackage.SERVICE_RESULT__SERVICE_EFFECT_SPECIFICATION_SERVICE_RESULT,
                            oldServiceEffectSpecification_ServiceResult,
                            this.serviceEffectSpecification_ServiceResult));
                }
            }
        }
        return this.serviceEffectSpecification_ServiceResult;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ServiceEffectSpecification basicGetServiceEffectSpecification_ServiceResult() {
        return this.serviceEffectSpecification_ServiceResult;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setServiceEffectSpecification_ServiceResult(
            final ServiceEffectSpecification newServiceEffectSpecification_ServiceResult) {
        final ServiceEffectSpecification oldServiceEffectSpecification_ServiceResult = this.serviceEffectSpecification_ServiceResult;
        this.serviceEffectSpecification_ServiceResult = newServiceEffectSpecification_ServiceResult;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    RepositorydecoratorPackage.SERVICE_RESULT__SERVICE_EFFECT_SPECIFICATION_SERVICE_RESULT,
                    oldServiceEffectSpecification_ServiceResult, this.serviceEffectSpecification_ServiceResult));
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
        case RepositorydecoratorPackage.SERVICE_RESULT__MEAN_RESPONSE_TIME:
            return this.getMeanResponseTime();
        case RepositorydecoratorPackage.SERVICE_RESULT__THROUGHPUT:
            return this.getThroughput();
        case RepositorydecoratorPackage.SERVICE_RESULT__SERVICE_EFFECT_SPECIFICATION_SERVICE_RESULT:
            if (resolve) {
                return this.getServiceEffectSpecification_ServiceResult();
            }
            return this.basicGetServiceEffectSpecification_ServiceResult();
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
        case RepositorydecoratorPackage.SERVICE_RESULT__MEAN_RESPONSE_TIME:
            this.setMeanResponseTime((Double) newValue);
            return;
        case RepositorydecoratorPackage.SERVICE_RESULT__THROUGHPUT:
            this.setThroughput((Double) newValue);
            return;
        case RepositorydecoratorPackage.SERVICE_RESULT__SERVICE_EFFECT_SPECIFICATION_SERVICE_RESULT:
            this.setServiceEffectSpecification_ServiceResult((ServiceEffectSpecification) newValue);
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
        case RepositorydecoratorPackage.SERVICE_RESULT__MEAN_RESPONSE_TIME:
            this.setMeanResponseTime(MEAN_RESPONSE_TIME_EDEFAULT);
            return;
        case RepositorydecoratorPackage.SERVICE_RESULT__THROUGHPUT:
            this.setThroughput(THROUGHPUT_EDEFAULT);
            return;
        case RepositorydecoratorPackage.SERVICE_RESULT__SERVICE_EFFECT_SPECIFICATION_SERVICE_RESULT:
            this.setServiceEffectSpecification_ServiceResult((ServiceEffectSpecification) null);
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
        case RepositorydecoratorPackage.SERVICE_RESULT__MEAN_RESPONSE_TIME:
            return this.meanResponseTime != MEAN_RESPONSE_TIME_EDEFAULT;
        case RepositorydecoratorPackage.SERVICE_RESULT__THROUGHPUT:
            return this.throughput != THROUGHPUT_EDEFAULT;
        case RepositorydecoratorPackage.SERVICE_RESULT__SERVICE_EFFECT_SPECIFICATION_SERVICE_RESULT:
            return this.serviceEffectSpecification_ServiceResult != null;
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
        result.append(" (meanResponseTime: ");
        result.append(this.meanResponseTime);
        result.append(", throughput: ");
        result.append(this.throughput);
        result.append(')');
        return result.toString();
    }

} // ServiceResultImpl
