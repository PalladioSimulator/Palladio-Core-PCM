/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import de.fzi.se.quality.parameters.ParameterPartition;
import de.fzi.se.quality.parameters.ParameterReference;
import de.fzi.se.quality.parameters.ParametersPackage;
import de.fzi.se.quality.qualityannotation.QualityAnnotation;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Parameter Partition</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.fzi.se.quality.parameters.impl.ParameterPartitionImpl#getQualityAnnotation <em>
 * Quality Annotation</em>}</li>
 * <li>{@link de.fzi.se.quality.parameters.impl.ParameterPartitionImpl#getParameterReference <em>
 * Parameter Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ParameterPartitionImpl extends IdentifierImpl implements ParameterPartition {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ParameterPartitionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ParametersPackage.Literals.PARAMETER_PARTITION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public QualityAnnotation getQualityAnnotation() {
        return (QualityAnnotation) this.eDynamicGet(ParametersPackage.PARAMETER_PARTITION__QUALITY_ANNOTATION,
                ParametersPackage.Literals.PARAMETER_PARTITION__QUALITY_ANNOTATION, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetQualityAnnotation(final QualityAnnotation newQualityAnnotation,
            NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newQualityAnnotation,
                ParametersPackage.PARAMETER_PARTITION__QUALITY_ANNOTATION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setQualityAnnotation(final QualityAnnotation newQualityAnnotation) {
        this.eDynamicSet(ParametersPackage.PARAMETER_PARTITION__QUALITY_ANNOTATION,
                ParametersPackage.Literals.PARAMETER_PARTITION__QUALITY_ANNOTATION, newQualityAnnotation);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ParameterReference getParameterReference() {
        return (ParameterReference) this.eDynamicGet(ParametersPackage.PARAMETER_PARTITION__PARAMETER_REFERENCE,
                ParametersPackage.Literals.PARAMETER_PARTITION__PARAMETER_REFERENCE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetParameterReference(final ParameterReference newParameterReference,
            NotificationChain msgs) {
        msgs = this.eDynamicInverseAdd((InternalEObject) newParameterReference,
                ParametersPackage.PARAMETER_PARTITION__PARAMETER_REFERENCE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setParameterReference(final ParameterReference newParameterReference) {
        this.eDynamicSet(ParametersPackage.PARAMETER_PARTITION__PARAMETER_REFERENCE,
                ParametersPackage.Literals.PARAMETER_PARTITION__PARAMETER_REFERENCE, newParameterReference);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case ParametersPackage.PARAMETER_PARTITION__QUALITY_ANNOTATION:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetQualityAnnotation((QualityAnnotation) otherEnd, msgs);
        case ParametersPackage.PARAMETER_PARTITION__PARAMETER_REFERENCE:
            final ParameterReference parameterReference = this.getParameterReference();
            if (parameterReference != null) {
                msgs = ((InternalEObject) parameterReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - ParametersPackage.PARAMETER_PARTITION__PARAMETER_REFERENCE, null, msgs);
            }
            return this.basicSetParameterReference((ParameterReference) otherEnd, msgs);
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
        case ParametersPackage.PARAMETER_PARTITION__QUALITY_ANNOTATION:
            return this.basicSetQualityAnnotation(null, msgs);
        case ParametersPackage.PARAMETER_PARTITION__PARAMETER_REFERENCE:
            return this.basicSetParameterReference(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(final NotificationChain msgs) {
        switch (this.eContainerFeatureID()) {
        case ParametersPackage.PARAMETER_PARTITION__QUALITY_ANNOTATION:
            return this.eInternalContainer().eInverseRemove(this,
                    QualityAnnotationPackage.QUALITY_ANNOTATION__VALID_FOR_PARAMETER_PARTITIONS,
                    QualityAnnotation.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case ParametersPackage.PARAMETER_PARTITION__QUALITY_ANNOTATION:
            return this.getQualityAnnotation();
        case ParametersPackage.PARAMETER_PARTITION__PARAMETER_REFERENCE:
            return this.getParameterReference();
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
        case ParametersPackage.PARAMETER_PARTITION__QUALITY_ANNOTATION:
            this.setQualityAnnotation((QualityAnnotation) newValue);
            return;
        case ParametersPackage.PARAMETER_PARTITION__PARAMETER_REFERENCE:
            this.setParameterReference((ParameterReference) newValue);
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
        case ParametersPackage.PARAMETER_PARTITION__QUALITY_ANNOTATION:
            this.setQualityAnnotation((QualityAnnotation) null);
            return;
        case ParametersPackage.PARAMETER_PARTITION__PARAMETER_REFERENCE:
            this.setParameterReference((ParameterReference) null);
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
        case ParametersPackage.PARAMETER_PARTITION__QUALITY_ANNOTATION:
            return this.getQualityAnnotation() != null;
        case ParametersPackage.PARAMETER_PARTITION__PARAMETER_REFERENCE:
            return this.getParameterReference() != null;
        }
        return super.eIsSet(featureID);
    }

} // ParameterPartitionImpl
