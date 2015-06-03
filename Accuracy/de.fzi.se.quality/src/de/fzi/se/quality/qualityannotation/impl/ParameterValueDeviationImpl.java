/**
 */
package de.fzi.se.quality.qualityannotation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.fzi.se.quality.parameters.ParameterReference;
import de.fzi.se.quality.parameters.ParameterValue;
import de.fzi.se.quality.parameters.ParametersPackage;
import de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation;
import de.fzi.se.quality.qualityannotation.ParameterValueDeviation;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.fzi.se.quality.qualityannotation.RequiredElementDeviation;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Parameter Value Deviation</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.impl.ParameterValueDeviationImpl#getParameterReference
 * <em>Parameter Reference</em>}</li>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.impl.ParameterValueDeviationImpl#getInternalStateInfluenceAnalysisAggregation
 * <em>Internal State Influence Analysis Aggregation</em>}</li>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.impl.ParameterValueDeviationImpl#getRequiredElementDeviation
 * <em>Required Element Deviation</em>}</li>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.impl.ParameterValueDeviationImpl#getParameterValue
 * <em>Parameter Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParameterValueDeviationImpl extends EObjectImpl implements ParameterValueDeviation {

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
     * The cached value of the '{@link #getParameterValue() <em>Parameter Value</em>}' containment
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getParameterValue()
     * @generated
     * @ordered
     */
    protected ParameterValue parameterValue;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ParameterValueDeviationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return QualityAnnotationPackage.Literals.PARAMETER_VALUE_DEVIATION;
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
                    QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_REFERENCE, oldParameterReference,
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
                        ParametersPackage.PARAMETER_REFERENCE__PARAMETER_VALUE_DEVIATION, ParameterReference.class,
                        msgs);
            }
            if (newParameterReference != null) {
                msgs = ((InternalEObject) newParameterReference).eInverseAdd(this,
                        ParametersPackage.PARAMETER_REFERENCE__PARAMETER_VALUE_DEVIATION, ParameterReference.class,
                        msgs);
            }
            msgs = this.basicSetParameterReference(newParameterReference, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_REFERENCE, newParameterReference,
                    newParameterReference));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public InternalStateInfluenceAnalysisAggregation getInternalStateInfluenceAnalysisAggregation() {
        if (this.eContainerFeatureID() != QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION) {
            return null;
        }
        return (InternalStateInfluenceAnalysisAggregation) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetInternalStateInfluenceAnalysisAggregation(
            final InternalStateInfluenceAnalysisAggregation newInternalStateInfluenceAnalysisAggregation,
            NotificationChain msgs) {
        msgs = this
                .eBasicSetContainer(
                        (InternalEObject) newInternalStateInfluenceAnalysisAggregation,
                        QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION,
                        msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setInternalStateInfluenceAnalysisAggregation(
            final InternalStateInfluenceAnalysisAggregation newInternalStateInfluenceAnalysisAggregation) {
        if (newInternalStateInfluenceAnalysisAggregation != this.eInternalContainer()
                || (this.eContainerFeatureID() != QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION && newInternalStateInfluenceAnalysisAggregation != null)) {
            if (EcoreUtil.isAncestor(this, newInternalStateInfluenceAnalysisAggregation)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newInternalStateInfluenceAnalysisAggregation != null) {
                msgs = ((InternalEObject) newInternalStateInfluenceAnalysisAggregation)
                        .eInverseAdd(
                                this,
                                QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__PARAMETER_VALUE_DEVIATIONS,
                                InternalStateInfluenceAnalysisAggregation.class, msgs);
            }
            msgs = this.basicSetInternalStateInfluenceAnalysisAggregation(newInternalStateInfluenceAnalysisAggregation,
                    msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION,
                    newInternalStateInfluenceAnalysisAggregation, newInternalStateInfluenceAnalysisAggregation));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public RequiredElementDeviation getRequiredElementDeviation() {
        if (this.eContainerFeatureID() != QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__REQUIRED_ELEMENT_DEVIATION) {
            return null;
        }
        return (RequiredElementDeviation) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetRequiredElementDeviation(
            final RequiredElementDeviation newRequiredElementDeviation, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newRequiredElementDeviation,
                QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__REQUIRED_ELEMENT_DEVIATION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setRequiredElementDeviation(final RequiredElementDeviation newRequiredElementDeviation) {
        if (newRequiredElementDeviation != this.eInternalContainer()
                || (this.eContainerFeatureID() != QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__REQUIRED_ELEMENT_DEVIATION && newRequiredElementDeviation != null)) {
            if (EcoreUtil.isAncestor(this, newRequiredElementDeviation)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newRequiredElementDeviation != null) {
                msgs = ((InternalEObject) newRequiredElementDeviation).eInverseAdd(this,
                        QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__MAXIMUM_DEVIATION_CALL_PARAMETER_VALUES,
                        RequiredElementDeviation.class, msgs);
            }
            msgs = this.basicSetRequiredElementDeviation(newRequiredElementDeviation, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__REQUIRED_ELEMENT_DEVIATION,
                    newRequiredElementDeviation, newRequiredElementDeviation));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ParameterValue getParameterValue() {
        return this.parameterValue;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetParameterValue(final ParameterValue newParameterValue, NotificationChain msgs) {
        final ParameterValue oldParameterValue = this.parameterValue;
        this.parameterValue = newParameterValue;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_VALUE, oldParameterValue,
                    newParameterValue);
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
    public void setParameterValue(final ParameterValue newParameterValue) {
        if (newParameterValue != this.parameterValue) {
            NotificationChain msgs = null;
            if (this.parameterValue != null) {
                msgs = ((InternalEObject) this.parameterValue).eInverseRemove(this,
                        ParametersPackage.PARAMETER_VALUE__PARAMETER_VALUE_DEVIATION, ParameterValue.class, msgs);
            }
            if (newParameterValue != null) {
                msgs = ((InternalEObject) newParameterValue).eInverseAdd(this,
                        ParametersPackage.PARAMETER_VALUE__PARAMETER_VALUE_DEVIATION, ParameterValue.class, msgs);
            }
            msgs = this.basicSetParameterValue(newParameterValue, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_VALUE, newParameterValue,
                    newParameterValue));
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
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_REFERENCE:
            if (this.parameterReference != null) {
                msgs = ((InternalEObject) this.parameterReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_REFERENCE, null, msgs);
            }
            return this.basicSetParameterReference((ParameterReference) otherEnd, msgs);
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetInternalStateInfluenceAnalysisAggregation(
                    (InternalStateInfluenceAnalysisAggregation) otherEnd, msgs);
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__REQUIRED_ELEMENT_DEVIATION:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetRequiredElementDeviation((RequiredElementDeviation) otherEnd, msgs);
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_VALUE:
            if (this.parameterValue != null) {
                msgs = ((InternalEObject) this.parameterValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_VALUE, null, msgs);
            }
            return this.basicSetParameterValue((ParameterValue) otherEnd, msgs);
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
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_REFERENCE:
            return this.basicSetParameterReference(null, msgs);
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
            return this.basicSetInternalStateInfluenceAnalysisAggregation(null, msgs);
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__REQUIRED_ELEMENT_DEVIATION:
            return this.basicSetRequiredElementDeviation(null, msgs);
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_VALUE:
            return this.basicSetParameterValue(null, msgs);
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
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
            return this.eInternalContainer().eInverseRemove(this,
                    QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__PARAMETER_VALUE_DEVIATIONS,
                    InternalStateInfluenceAnalysisAggregation.class, msgs);
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__REQUIRED_ELEMENT_DEVIATION:
            return this.eInternalContainer().eInverseRemove(this,
                    QualityAnnotationPackage.REQUIRED_ELEMENT_DEVIATION__MAXIMUM_DEVIATION_CALL_PARAMETER_VALUES,
                    RequiredElementDeviation.class, msgs);
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
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_REFERENCE:
            return this.getParameterReference();
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
            return this.getInternalStateInfluenceAnalysisAggregation();
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__REQUIRED_ELEMENT_DEVIATION:
            return this.getRequiredElementDeviation();
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_VALUE:
            return this.getParameterValue();
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
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_REFERENCE:
            this.setParameterReference((ParameterReference) newValue);
            return;
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
            this.setInternalStateInfluenceAnalysisAggregation((InternalStateInfluenceAnalysisAggregation) newValue);
            return;
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__REQUIRED_ELEMENT_DEVIATION:
            this.setRequiredElementDeviation((RequiredElementDeviation) newValue);
            return;
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_VALUE:
            this.setParameterValue((ParameterValue) newValue);
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
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_REFERENCE:
            this.setParameterReference((ParameterReference) null);
            return;
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
            this.setInternalStateInfluenceAnalysisAggregation((InternalStateInfluenceAnalysisAggregation) null);
            return;
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__REQUIRED_ELEMENT_DEVIATION:
            this.setRequiredElementDeviation((RequiredElementDeviation) null);
            return;
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_VALUE:
            this.setParameterValue((ParameterValue) null);
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
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_REFERENCE:
            return this.parameterReference != null;
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION:
            return this.getInternalStateInfluenceAnalysisAggregation() != null;
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__REQUIRED_ELEMENT_DEVIATION:
            return this.getRequiredElementDeviation() != null;
        case QualityAnnotationPackage.PARAMETER_VALUE_DEVIATION__PARAMETER_VALUE:
            return this.parameterValue != null;
        }
        return super.eIsSet(featureID);
    }

} // ParameterValueDeviationImpl
