/**
 */
package org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.palladiosimulator.pcm.core.entity.impl.NamedElementImpl;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ComponentResult;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Component Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.ComponentResultImpl#getNormalisedResourceDemand
 * <em>Normalised Resource Demand</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.ComponentResultImpl#getNormalisedResponseTime
 * <em>Normalised Response Time</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.ComponentResultImpl#getAverageResourceDemand
 * <em>Average Resource Demand</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.ComponentResultImpl#getMeanResponseTime
 * <em>Mean Response Time</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.ComponentResultImpl#getAverageNumberOfSentMessages
 * <em>Average Number Of Sent Messages</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ComponentResultImpl extends NamedElementImpl implements ComponentResult {

    /**
     * The default value of the '{@link #getNormalisedResourceDemand()
     * <em>Normalised Resource Demand</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @see #getNormalisedResourceDemand()
     * @generated
     * @ordered
     */
    protected static final double NORMALISED_RESOURCE_DEMAND_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getNormalisedResourceDemand()
     * <em>Normalised Resource Demand</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @see #getNormalisedResourceDemand()
     * @generated
     * @ordered
     */
    protected double normalisedResourceDemand = NORMALISED_RESOURCE_DEMAND_EDEFAULT;

    /**
     * The default value of the '{@link #getNormalisedResponseTime()
     * <em>Normalised Response Time</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getNormalisedResponseTime()
     * @generated
     * @ordered
     */
    protected static final double NORMALISED_RESPONSE_TIME_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getNormalisedResponseTime()
     * <em>Normalised Response Time</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getNormalisedResponseTime()
     * @generated
     * @ordered
     */
    protected double normalisedResponseTime = NORMALISED_RESPONSE_TIME_EDEFAULT;

    /**
     * The default value of the '{@link #getAverageResourceDemand() <em>Average Resource Demand</em>
     * }' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getAverageResourceDemand()
     * @generated
     * @ordered
     */
    protected static final double AVERAGE_RESOURCE_DEMAND_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getAverageResourceDemand() <em>Average Resource Demand</em>}
     * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getAverageResourceDemand()
     * @generated
     * @ordered
     */
    protected double averageResourceDemand = AVERAGE_RESOURCE_DEMAND_EDEFAULT;

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
     * The default value of the '{@link #getAverageNumberOfSentMessages()
     * <em>Average Number Of Sent Messages</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getAverageNumberOfSentMessages()
     * @generated
     * @ordered
     */
    protected static final double AVERAGE_NUMBER_OF_SENT_MESSAGES_EDEFAULT = 0.0;

    /**
     * The cached value of the '{@link #getAverageNumberOfSentMessages()
     * <em>Average Number Of Sent Messages</em>}' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getAverageNumberOfSentMessages()
     * @generated
     * @ordered
     */
    protected double averageNumberOfSentMessages = AVERAGE_NUMBER_OF_SENT_MESSAGES_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ComponentResultImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RepositorydecoratorPackage.Literals.COMPONENT_RESULT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public double getNormalisedResourceDemand() {
        return this.normalisedResourceDemand;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setNormalisedResourceDemand(final double newNormalisedResourceDemand) {
        final double oldNormalisedResourceDemand = this.normalisedResourceDemand;
        this.normalisedResourceDemand = newNormalisedResourceDemand;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    RepositorydecoratorPackage.COMPONENT_RESULT__NORMALISED_RESOURCE_DEMAND,
                    oldNormalisedResourceDemand, this.normalisedResourceDemand));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public double getNormalisedResponseTime() {
        return this.normalisedResponseTime;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setNormalisedResponseTime(final double newNormalisedResponseTime) {
        final double oldNormalisedResponseTime = this.normalisedResponseTime;
        this.normalisedResponseTime = newNormalisedResponseTime;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    RepositorydecoratorPackage.COMPONENT_RESULT__NORMALISED_RESPONSE_TIME, oldNormalisedResponseTime,
                    this.normalisedResponseTime));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public double getAverageResourceDemand() {
        return this.averageResourceDemand;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setAverageResourceDemand(final double newAverageResourceDemand) {
        final double oldAverageResourceDemand = this.averageResourceDemand;
        this.averageResourceDemand = newAverageResourceDemand;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    RepositorydecoratorPackage.COMPONENT_RESULT__AVERAGE_RESOURCE_DEMAND, oldAverageResourceDemand,
                    this.averageResourceDemand));
        }
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
                    RepositorydecoratorPackage.COMPONENT_RESULT__MEAN_RESPONSE_TIME, oldMeanResponseTime,
                    this.meanResponseTime));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public double getAverageNumberOfSentMessages() {
        return this.averageNumberOfSentMessages;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setAverageNumberOfSentMessages(final double newAverageNumberOfSentMessages) {
        final double oldAverageNumberOfSentMessages = this.averageNumberOfSentMessages;
        this.averageNumberOfSentMessages = newAverageNumberOfSentMessages;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    RepositorydecoratorPackage.COMPONENT_RESULT__AVERAGE_NUMBER_OF_SENT_MESSAGES,
                    oldAverageNumberOfSentMessages, this.averageNumberOfSentMessages));
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
        case RepositorydecoratorPackage.COMPONENT_RESULT__NORMALISED_RESOURCE_DEMAND:
            return this.getNormalisedResourceDemand();
        case RepositorydecoratorPackage.COMPONENT_RESULT__NORMALISED_RESPONSE_TIME:
            return this.getNormalisedResponseTime();
        case RepositorydecoratorPackage.COMPONENT_RESULT__AVERAGE_RESOURCE_DEMAND:
            return this.getAverageResourceDemand();
        case RepositorydecoratorPackage.COMPONENT_RESULT__MEAN_RESPONSE_TIME:
            return this.getMeanResponseTime();
        case RepositorydecoratorPackage.COMPONENT_RESULT__AVERAGE_NUMBER_OF_SENT_MESSAGES:
            return this.getAverageNumberOfSentMessages();
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
        case RepositorydecoratorPackage.COMPONENT_RESULT__NORMALISED_RESOURCE_DEMAND:
            this.setNormalisedResourceDemand((Double) newValue);
            return;
        case RepositorydecoratorPackage.COMPONENT_RESULT__NORMALISED_RESPONSE_TIME:
            this.setNormalisedResponseTime((Double) newValue);
            return;
        case RepositorydecoratorPackage.COMPONENT_RESULT__AVERAGE_RESOURCE_DEMAND:
            this.setAverageResourceDemand((Double) newValue);
            return;
        case RepositorydecoratorPackage.COMPONENT_RESULT__MEAN_RESPONSE_TIME:
            this.setMeanResponseTime((Double) newValue);
            return;
        case RepositorydecoratorPackage.COMPONENT_RESULT__AVERAGE_NUMBER_OF_SENT_MESSAGES:
            this.setAverageNumberOfSentMessages((Double) newValue);
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
        case RepositorydecoratorPackage.COMPONENT_RESULT__NORMALISED_RESOURCE_DEMAND:
            this.setNormalisedResourceDemand(NORMALISED_RESOURCE_DEMAND_EDEFAULT);
            return;
        case RepositorydecoratorPackage.COMPONENT_RESULT__NORMALISED_RESPONSE_TIME:
            this.setNormalisedResponseTime(NORMALISED_RESPONSE_TIME_EDEFAULT);
            return;
        case RepositorydecoratorPackage.COMPONENT_RESULT__AVERAGE_RESOURCE_DEMAND:
            this.setAverageResourceDemand(AVERAGE_RESOURCE_DEMAND_EDEFAULT);
            return;
        case RepositorydecoratorPackage.COMPONENT_RESULT__MEAN_RESPONSE_TIME:
            this.setMeanResponseTime(MEAN_RESPONSE_TIME_EDEFAULT);
            return;
        case RepositorydecoratorPackage.COMPONENT_RESULT__AVERAGE_NUMBER_OF_SENT_MESSAGES:
            this.setAverageNumberOfSentMessages(AVERAGE_NUMBER_OF_SENT_MESSAGES_EDEFAULT);
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
        case RepositorydecoratorPackage.COMPONENT_RESULT__NORMALISED_RESOURCE_DEMAND:
            return this.normalisedResourceDemand != NORMALISED_RESOURCE_DEMAND_EDEFAULT;
        case RepositorydecoratorPackage.COMPONENT_RESULT__NORMALISED_RESPONSE_TIME:
            return this.normalisedResponseTime != NORMALISED_RESPONSE_TIME_EDEFAULT;
        case RepositorydecoratorPackage.COMPONENT_RESULT__AVERAGE_RESOURCE_DEMAND:
            return this.averageResourceDemand != AVERAGE_RESOURCE_DEMAND_EDEFAULT;
        case RepositorydecoratorPackage.COMPONENT_RESULT__MEAN_RESPONSE_TIME:
            return this.meanResponseTime != MEAN_RESPONSE_TIME_EDEFAULT;
        case RepositorydecoratorPackage.COMPONENT_RESULT__AVERAGE_NUMBER_OF_SENT_MESSAGES:
            return this.averageNumberOfSentMessages != AVERAGE_NUMBER_OF_SENT_MESSAGES_EDEFAULT;
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
        result.append(" (normalisedResourceDemand: ");
        result.append(this.normalisedResourceDemand);
        result.append(", normalisedResponseTime: ");
        result.append(this.normalisedResponseTime);
        result.append(", averageResourceDemand: ");
        result.append(this.averageResourceDemand);
        result.append(", meanResponseTime: ");
        result.append(this.meanResponseTime);
        result.append(", averageNumberOfSentMessages: ");
        result.append(this.averageNumberOfSentMessages);
        result.append(')');
        return result.toString();
    }

} // ComponentResultImpl
