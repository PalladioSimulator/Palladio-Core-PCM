/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

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
        return (PCMRandomVariable) this.eDynamicGet(
                QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__FROM,
                QualityAnnotationPackage.Literals.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__FROM, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetFrom(final PCMRandomVariable newFrom, NotificationChain msgs) {
        msgs = this.eDynamicInverseAdd((InternalEObject) newFrom,
                QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__FROM, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setFrom(final PCMRandomVariable newFrom) {
        this.eDynamicSet(QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__FROM,
                QualityAnnotationPackage.Literals.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__FROM, newFrom);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public PCMRandomVariable getTo() {
        return (PCMRandomVariable) this.eDynamicGet(
                QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__TO,
                QualityAnnotationPackage.Literals.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__TO, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetTo(final PCMRandomVariable newTo, NotificationChain msgs) {
        msgs = this.eDynamicInverseAdd((InternalEObject) newTo,
                QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__TO, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setTo(final PCMRandomVariable newTo) {
        this.eDynamicSet(QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__TO,
                QualityAnnotationPackage.Literals.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__TO, newTo);
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
            return this.getFrom() != null;
        case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_INTERVAL__TO:
            return this.getTo() != null;
        }
        return super.eIsSet(featureID);
    }

} // CharacterisedPCMParameterPartitionIntervalImpl
