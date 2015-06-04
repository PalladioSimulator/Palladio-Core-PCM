/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

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
     * The cached value of the '{@link #getParameterReference() <em>Parameter Reference</em>}'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getParameterReference()
     * @generated
     * @ordered
     */
    protected ParameterReference parameterReference;

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
        if (this.eContainerFeatureID() != ParametersPackage.PARAMETER_PARTITION__QUALITY_ANNOTATION) {
            return null;
        }
        return (QualityAnnotation) this.eInternalContainer();
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
        if (newQualityAnnotation != this.eInternalContainer()
                || (this.eContainerFeatureID() != ParametersPackage.PARAMETER_PARTITION__QUALITY_ANNOTATION && newQualityAnnotation != null)) {
            if (EcoreUtil.isAncestor(this, newQualityAnnotation)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newQualityAnnotation != null) {
                msgs = ((InternalEObject) newQualityAnnotation).eInverseAdd(this,
                        QualityAnnotationPackage.QUALITY_ANNOTATION__VALID_FOR_PARAMETER_PARTITIONS,
                        QualityAnnotation.class, msgs);
            }
            msgs = this.basicSetQualityAnnotation(newQualityAnnotation, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ParametersPackage.PARAMETER_PARTITION__QUALITY_ANNOTATION, newQualityAnnotation,
                    newQualityAnnotation));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ParameterReference getParameterReference() {
        return this.parameterReference;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetParameterReference(final ParameterReference newParameterReference,
            NotificationChain msgs) {
        final ParameterReference oldParameterReference = this.parameterReference;
        this.parameterReference = newParameterReference;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    ParametersPackage.PARAMETER_PARTITION__PARAMETER_REFERENCE, oldParameterReference,
                    newParameterReference);
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
    public void setParameterReference(final ParameterReference newParameterReference) {
        if (newParameterReference != this.parameterReference) {
            NotificationChain msgs = null;
            if (this.parameterReference != null) {
                msgs = ((InternalEObject) this.parameterReference).eInverseRemove(this,
                        ParametersPackage.PARAMETER_REFERENCE__PARAMETER_PARTITION, ParameterReference.class, msgs);
            }
            if (newParameterReference != null) {
                msgs = ((InternalEObject) newParameterReference).eInverseAdd(this,
                        ParametersPackage.PARAMETER_REFERENCE__PARAMETER_PARTITION, ParameterReference.class, msgs);
            }
            msgs = this.basicSetParameterReference(newParameterReference, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ParametersPackage.PARAMETER_PARTITION__PARAMETER_REFERENCE, newParameterReference,
                    newParameterReference));
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
        case ParametersPackage.PARAMETER_PARTITION__QUALITY_ANNOTATION:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetQualityAnnotation((QualityAnnotation) otherEnd, msgs);
        case ParametersPackage.PARAMETER_PARTITION__PARAMETER_REFERENCE:
            if (this.parameterReference != null) {
                msgs = ((InternalEObject) this.parameterReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
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
            return this.parameterReference != null;
        }
        return super.eIsSet(featureID);
    }

} // ParameterPartitionImpl
