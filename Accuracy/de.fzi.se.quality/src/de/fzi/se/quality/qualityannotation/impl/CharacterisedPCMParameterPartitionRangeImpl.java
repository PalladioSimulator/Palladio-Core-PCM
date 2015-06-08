/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartitionRange;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Characterised PCM Parameter Partition Range</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.impl.CharacterisedPCMParameterPartitionRangeImpl#getValues
 * <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CharacterisedPCMParameterPartitionRangeImpl extends CharacterisedPCMParameterPartitionImpl implements
        CharacterisedPCMParameterPartitionRange {

    /**
     * The cached value of the '{@link #getValues() <em>Values</em>}' containment reference list.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getValues()
     * @generated
     * @ordered
     */
    protected EList<PCMRandomVariable> values;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected CharacterisedPCMParameterPartitionRangeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return QualityAnnotationPackage.Literals.CHARACTERISED_PCM_PARAMETER_PARTITION_RANGE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<PCMRandomVariable> getValues() {
        if (this.values == null) {
            this.values = new EObjectContainmentEList<PCMRandomVariable>(PCMRandomVariable.class, this,
                    QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_RANGE__VALUES);
        }
        return this.values;
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
        case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_RANGE__VALUES:
            return ((InternalEList<?>) this.getValues()).basicRemove(otherEnd, msgs);
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
        case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_RANGE__VALUES:
            return this.getValues();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_RANGE__VALUES:
            this.getValues().clear();
            this.getValues().addAll((Collection<? extends PCMRandomVariable>) newValue);
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
        case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_RANGE__VALUES:
            this.getValues().clear();
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
        case QualityAnnotationPackage.CHARACTERISED_PCM_PARAMETER_PARTITION_RANGE__VALUES:
            return this.values != null && !this.values.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // CharacterisedPCMParameterPartitionRangeImpl
