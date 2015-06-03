/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.qosannotations.qos_performance.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.core.CorePackage;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.qosannotations.impl.SpecifiedQoSAnnotationImpl;
import de.uka.ipd.sdq.pcm.qosannotations.qos_performance.QosPerformancePackage;
import de.uka.ipd.sdq.pcm.qosannotations.qos_performance.SpecifiedExecutionTime;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Specified Execution Time</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.qosannotations.qos_performance.impl.SpecifiedExecutionTimeImpl#getSpecification_SpecifiedExecutionTime
 * <em>Specification Specified Execution Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SpecifiedExecutionTimeImpl extends SpecifiedQoSAnnotationImpl implements SpecifiedExecutionTime {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getSpecification_SpecifiedExecutionTime()
     * <em>Specification Specified Execution Time</em>}' containment reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @see #getSpecification_SpecifiedExecutionTime()
     * @generated
     * @ordered
     */
    protected PCMRandomVariable specification_SpecifiedExecutionTime;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected SpecifiedExecutionTimeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return QosPerformancePackage.Literals.SPECIFIED_EXECUTION_TIME;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public PCMRandomVariable getSpecification_SpecifiedExecutionTime() {
        return this.specification_SpecifiedExecutionTime;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetSpecification_SpecifiedExecutionTime(
            final PCMRandomVariable newSpecification_SpecifiedExecutionTime, NotificationChain msgs) {
        final PCMRandomVariable oldSpecification_SpecifiedExecutionTime = this.specification_SpecifiedExecutionTime;
        this.specification_SpecifiedExecutionTime = newSpecification_SpecifiedExecutionTime;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    QosPerformancePackage.SPECIFIED_EXECUTION_TIME__SPECIFICATION_SPECIFIED_EXECUTION_TIME,
                    oldSpecification_SpecifiedExecutionTime, newSpecification_SpecifiedExecutionTime);
            if (msgs == null) {
                msgs = notification;
            } else {
                msgs.add(notification);
            }
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setSpecification_SpecifiedExecutionTime(final PCMRandomVariable newSpecification_SpecifiedExecutionTime) {
        if (newSpecification_SpecifiedExecutionTime != this.specification_SpecifiedExecutionTime) {
            NotificationChain msgs = null;
            if (this.specification_SpecifiedExecutionTime != null) {
                msgs = ((InternalEObject) this.specification_SpecifiedExecutionTime).eInverseRemove(this,
                        CorePackage.PCM_RANDOM_VARIABLE__SPECIFIED_EXECUTION_TIME_PCM_RANDOM_VARIABLE,
                        PCMRandomVariable.class, msgs);
            }
            if (newSpecification_SpecifiedExecutionTime != null) {
                msgs = ((InternalEObject) newSpecification_SpecifiedExecutionTime).eInverseAdd(this,
                        CorePackage.PCM_RANDOM_VARIABLE__SPECIFIED_EXECUTION_TIME_PCM_RANDOM_VARIABLE,
                        PCMRandomVariable.class, msgs);
            }
            msgs = this.basicSetSpecification_SpecifiedExecutionTime(newSpecification_SpecifiedExecutionTime, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    QosPerformancePackage.SPECIFIED_EXECUTION_TIME__SPECIFICATION_SPECIFIED_EXECUTION_TIME,
                    newSpecification_SpecifiedExecutionTime, newSpecification_SpecifiedExecutionTime));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case QosPerformancePackage.SPECIFIED_EXECUTION_TIME__SPECIFICATION_SPECIFIED_EXECUTION_TIME:
            if (this.specification_SpecifiedExecutionTime != null) {
                msgs = ((InternalEObject) this.specification_SpecifiedExecutionTime)
                        .eInverseRemove(
                                this,
                                EOPPOSITE_FEATURE_BASE
                                - QosPerformancePackage.SPECIFIED_EXECUTION_TIME__SPECIFICATION_SPECIFIED_EXECUTION_TIME,
                                null, msgs);
            }
            return this.basicSetSpecification_SpecifiedExecutionTime((PCMRandomVariable) otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case QosPerformancePackage.SPECIFIED_EXECUTION_TIME__SPECIFICATION_SPECIFIED_EXECUTION_TIME:
            return this.basicSetSpecification_SpecifiedExecutionTime(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case QosPerformancePackage.SPECIFIED_EXECUTION_TIME__SPECIFICATION_SPECIFIED_EXECUTION_TIME:
            return this.getSpecification_SpecifiedExecutionTime();
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
        case QosPerformancePackage.SPECIFIED_EXECUTION_TIME__SPECIFICATION_SPECIFIED_EXECUTION_TIME:
            this.setSpecification_SpecifiedExecutionTime((PCMRandomVariable) newValue);
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
        case QosPerformancePackage.SPECIFIED_EXECUTION_TIME__SPECIFICATION_SPECIFIED_EXECUTION_TIME:
            this.setSpecification_SpecifiedExecutionTime((PCMRandomVariable) null);
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
        case QosPerformancePackage.SPECIFIED_EXECUTION_TIME__SPECIFICATION_SPECIFIED_EXECUTION_TIME:
            return this.specification_SpecifiedExecutionTime != null;
        }
        return super.eIsSet(featureID);
    }

} // SpecifiedExecutionTimeImpl
