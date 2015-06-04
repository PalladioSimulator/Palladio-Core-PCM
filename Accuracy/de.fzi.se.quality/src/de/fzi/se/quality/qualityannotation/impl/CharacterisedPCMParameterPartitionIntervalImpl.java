/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartitionInterval;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Characterised PCM Parameter Partition Interval</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.impl.CharacterisedPCMParameterPartitionIntervalImpl#getFrom
 * <em>From</em>}</li>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.impl.CharacterisedPCMParameterPartitionIntervalImpl#getTo
 * <em>To</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CharacterisedPCMParameterPartitionIntervalImpl extends CharacterisedPCMParameterPartitionImpl implements
CharacterisedPCMParameterPartitionInterval {

    /**
     * The cached value of the '{@link #getFrom() <em>From</em>}' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getFrom()
     * @generated
     * @ordered
     */
    protected PCMRandomVariable from;

    /**
     * The cached value of the '{@link #getTo() <em>To</em>}' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getTo()
     * @generated
     * @ordered
     */
    protected PCMRandomVariable to;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected CharacterisedPCMParameterPartitionIntervalImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return QualityAnnotationPackage.Literals.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public PCMRandomVariable getFrom() {
        return this.from;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetFrom(final PCMRandomVariable newFrom, NotificationChain msgs) {
        final PCMRandomVariable oldFrom = this.from;
        this.from = newFrom;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__FROM, oldFrom, newFrom);
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
    public void setFrom(final PCMRandomVariable newFrom) {
        if (newFrom != this.from) {
            NotificationChain msgs = null;
            if (this.from != null) {
                msgs = ((InternalEObject) this.from).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__FROM, null, msgs);
            }
            if (newFrom != null) {
                msgs = ((InternalEObject) newFrom).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
                        - QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__FROM, null, msgs);
            }
            msgs = this.basicSetFrom(newFrom, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__FROM, newFrom, newFrom));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public PCMRandomVariable getTo() {
        return this.to;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetTo(final PCMRandomVariable newTo, NotificationChain msgs) {
        final PCMRandomVariable oldTo = this.to;
        this.to = newTo;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__TO, oldTo, newTo);
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
    public void setTo(final PCMRandomVariable newTo) {
        if (newTo != this.to) {
            NotificationChain msgs = null;
            if (this.to != null) {
                msgs = ((InternalEObject) this.to).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__TO, null, msgs);
            }
            if (newTo != null) {
                msgs = ((InternalEObject) newTo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
                        - QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__TO, null, msgs);
            }
            msgs = this.basicSetTo(newTo, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__TO, newTo, newTo));
        }
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
        case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__FROM:
            return this.basicSetFrom(null, msgs);
        case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__TO:
            return this.basicSetTo(null, msgs);
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
        case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__FROM:
            return this.getFrom();
        case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__TO:
            return this.getTo();
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
        case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__FROM:
            this.setFrom((PCMRandomVariable) newValue);
            return;
        case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__TO:
            this.setTo((PCMRandomVariable) newValue);
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
        case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__FROM:
            this.setFrom((PCMRandomVariable) null);
            return;
        case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__TO:
            this.setTo((PCMRandomVariable) null);
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
        case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__FROM:
            return this.from != null;
        case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__TO:
            return this.to != null;
        }
        return super.eIsSet(featureID);
    }

} // CharacterisedPCMParameterPartitionIntervalImpl
