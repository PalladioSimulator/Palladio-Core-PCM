/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.fzi.se.quality.impl.QualityStatementImpl;
import de.fzi.se.quality.parameters.ParameterPartition;
import de.fzi.se.quality.parameters.ParametersPackage;
import de.fzi.se.quality.qualityannotation.InternalStateInfluenceAnalysisAggregation;
import de.fzi.se.quality.qualityannotation.ProbabilisticElement;
import de.fzi.se.quality.qualityannotation.QualityAnnotation;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.fzi.se.quality.qualityannotation.RequiredElement;
import de.fzi.se.quality.qualityannotation.ServiceSpecification;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Quality Annotation</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.fzi.se.quality.qualityannotation.impl.QualityAnnotationImpl#isValid <em>Is Valid
 * </em>}</li>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.impl.QualityAnnotationImpl#getForServiceSpecification
 * <em>For Service Specification</em>}</li>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.impl.QualityAnnotationImpl#getStipulatedREPrecisions
 * <em>Stipulated RE Precisions</em>}</li>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.impl.QualityAnnotationImpl#getInternalStateInfluenceAnalysisResults
 * <em>Internal State Influence Analysis Results</em>}</li>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.impl.QualityAnnotationImpl#getProbabilisticElements
 * <em>Probabilistic Elements</em>}</li>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.impl.QualityAnnotationImpl#getValidForParameterPartitions
 * <em>Valid For Parameter Partitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QualityAnnotationImpl extends QualityStatementImpl implements QualityAnnotation {

    /**
     * The default value of the '{@link #isValid() <em>Is Valid</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #isValid()
     * @generated
     * @ordered
     */
    protected static final boolean IS_VALID_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isValid() <em>Is Valid</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #isValid()
     * @generated
     * @ordered
     */
    protected boolean isValid = IS_VALID_EDEFAULT;

    /**
     * The cached value of the '{@link #getForServiceSpecification()
     * <em>For Service Specification</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getForServiceSpecification()
     * @generated
     * @ordered
     */
    protected ServiceSpecification forServiceSpecification;

    /**
     * The cached value of the '{@link #getStipulatedREPrecisions()
     * <em>Stipulated RE Precisions</em>}' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getStipulatedREPrecisions()
     * @generated
     * @ordered
     */
    protected EList<RequiredElement> stipulatedREPrecisions;

    /**
     * The cached value of the '{@link #getInternalStateInfluenceAnalysisResults()
     * <em>Internal State Influence Analysis Results</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getInternalStateInfluenceAnalysisResults()
     * @generated
     * @ordered
     */
    protected EList<InternalStateInfluenceAnalysisAggregation> internalStateInfluenceAnalysisResults;

    /**
     * The cached value of the '{@link #getProbabilisticElements() <em>Probabilistic Elements</em>}'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getProbabilisticElements()
     * @generated
     * @ordered
     */
    protected EList<ProbabilisticElement> probabilisticElements;

    /**
     * The cached value of the '{@link #getValidForParameterPartitions()
     * <em>Valid For Parameter Partitions</em>}' containment reference list. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getValidForParameterPartitions()
     * @generated
     * @ordered
     */
    protected EList<ParameterPartition> validForParameterPartitions;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected QualityAnnotationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return QualityAnnotationPackage.Literals.QUALITY_ANNOTATION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean isValid() {
        return this.isValid;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setIsValid(final boolean newIsValid) {
        final boolean oldIsValid = this.isValid;
        this.isValid = newIsValid;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    QualityAnnotationPackage.QUALITY_ANNOTATION__IS_VALID, oldIsValid, this.isValid));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ServiceSpecification getForServiceSpecification() {
        return this.forServiceSpecification;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetForServiceSpecification(final ServiceSpecification newForServiceSpecification,
            NotificationChain msgs) {
        final ServiceSpecification oldForServiceSpecification = this.forServiceSpecification;
        this.forServiceSpecification = newForServiceSpecification;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    QualityAnnotationPackage.QUALITY_ANNOTATION__FOR_SERVICE_SPECIFICATION, oldForServiceSpecification,
                    newForServiceSpecification);
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
    public void setForServiceSpecification(final ServiceSpecification newForServiceSpecification) {
        if (newForServiceSpecification != this.forServiceSpecification) {
            NotificationChain msgs = null;
            if (this.forServiceSpecification != null) {
                msgs = ((InternalEObject) this.forServiceSpecification).eInverseRemove(this,
                        QualityAnnotationPackage.SERVICE_SPECIFICATION__QUALITY_ANNOTATION, ServiceSpecification.class,
                        msgs);
            }
            if (newForServiceSpecification != null) {
                msgs = ((InternalEObject) newForServiceSpecification).eInverseAdd(this,
                        QualityAnnotationPackage.SERVICE_SPECIFICATION__QUALITY_ANNOTATION, ServiceSpecification.class,
                        msgs);
            }
            msgs = this.basicSetForServiceSpecification(newForServiceSpecification, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    QualityAnnotationPackage.QUALITY_ANNOTATION__FOR_SERVICE_SPECIFICATION, newForServiceSpecification,
                    newForServiceSpecification));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<RequiredElement> getStipulatedREPrecisions() {
        if (this.stipulatedREPrecisions == null) {
            this.stipulatedREPrecisions = new EObjectContainmentWithInverseEList<RequiredElement>(
                    RequiredElement.class, this, QualityAnnotationPackage.QUALITY_ANNOTATION__STIPULATED_RE_PRECISIONS,
                    QualityAnnotationPackage.REQUIRED_ELEMENT__QUALITY_ANNOTATION);
        }
        return this.stipulatedREPrecisions;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<InternalStateInfluenceAnalysisAggregation> getInternalStateInfluenceAnalysisResults() {
        if (this.internalStateInfluenceAnalysisResults == null) {
            this.internalStateInfluenceAnalysisResults = new EObjectContainmentWithInverseEList<InternalStateInfluenceAnalysisAggregation>(
                    InternalStateInfluenceAnalysisAggregation.class, this,
                    QualityAnnotationPackage.QUALITY_ANNOTATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_RESULTS,
                    QualityAnnotationPackage.INTERNAL_STATE_INFLUENCE_ANALYSIS_AGGREGATION__QUALITY_ANNOTATION);
        }
        return this.internalStateInfluenceAnalysisResults;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<ProbabilisticElement> getProbabilisticElements() {
        if (this.probabilisticElements == null) {
            this.probabilisticElements = new EObjectContainmentWithInverseEList<ProbabilisticElement>(
                    ProbabilisticElement.class, this,
                    QualityAnnotationPackage.QUALITY_ANNOTATION__PROBABILISTIC_ELEMENTS,
                    QualityAnnotationPackage.PROBABILISTIC_ELEMENT__QUALITY_ANNOTATION);
        }
        return this.probabilisticElements;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EList<ParameterPartition> getValidForParameterPartitions() {
        if (this.validForParameterPartitions == null) {
            this.validForParameterPartitions = new EObjectContainmentWithInverseEList<ParameterPartition>(
                    ParameterPartition.class, this,
                    QualityAnnotationPackage.QUALITY_ANNOTATION__VALID_FOR_PARAMETER_PARTITIONS,
                    ParametersPackage.PARAMETER_PARTITION__QUALITY_ANNOTATION);
        }
        return this.validForParameterPartitions;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case QualityAnnotationPackage.QUALITY_ANNOTATION__FOR_SERVICE_SPECIFICATION:
            if (this.forServiceSpecification != null) {
                msgs = ((InternalEObject) this.forServiceSpecification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - QualityAnnotationPackage.QUALITY_ANNOTATION__FOR_SERVICE_SPECIFICATION, null, msgs);
            }
            return this.basicSetForServiceSpecification((ServiceSpecification) otherEnd, msgs);
        case QualityAnnotationPackage.QUALITY_ANNOTATION__STIPULATED_RE_PRECISIONS:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getStipulatedREPrecisions()).basicAdd(
                    otherEnd, msgs);
        case QualityAnnotationPackage.QUALITY_ANNOTATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_RESULTS:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getInternalStateInfluenceAnalysisResults())
                    .basicAdd(otherEnd, msgs);
        case QualityAnnotationPackage.QUALITY_ANNOTATION__PROBABILISTIC_ELEMENTS:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getProbabilisticElements()).basicAdd(
                    otherEnd, msgs);
        case QualityAnnotationPackage.QUALITY_ANNOTATION__VALID_FOR_PARAMETER_PARTITIONS:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getValidForParameterPartitions())
                    .basicAdd(otherEnd, msgs);
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
        case QualityAnnotationPackage.QUALITY_ANNOTATION__FOR_SERVICE_SPECIFICATION:
            return this.basicSetForServiceSpecification(null, msgs);
        case QualityAnnotationPackage.QUALITY_ANNOTATION__STIPULATED_RE_PRECISIONS:
            return ((InternalEList<?>) this.getStipulatedREPrecisions()).basicRemove(otherEnd, msgs);
        case QualityAnnotationPackage.QUALITY_ANNOTATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_RESULTS:
            return ((InternalEList<?>) this.getInternalStateInfluenceAnalysisResults()).basicRemove(otherEnd, msgs);
        case QualityAnnotationPackage.QUALITY_ANNOTATION__PROBABILISTIC_ELEMENTS:
            return ((InternalEList<?>) this.getProbabilisticElements()).basicRemove(otherEnd, msgs);
        case QualityAnnotationPackage.QUALITY_ANNOTATION__VALID_FOR_PARAMETER_PARTITIONS:
            return ((InternalEList<?>) this.getValidForParameterPartitions()).basicRemove(otherEnd, msgs);
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
        case QualityAnnotationPackage.QUALITY_ANNOTATION__IS_VALID:
            return this.isValid();
        case QualityAnnotationPackage.QUALITY_ANNOTATION__FOR_SERVICE_SPECIFICATION:
            return this.getForServiceSpecification();
        case QualityAnnotationPackage.QUALITY_ANNOTATION__STIPULATED_RE_PRECISIONS:
            return this.getStipulatedREPrecisions();
        case QualityAnnotationPackage.QUALITY_ANNOTATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_RESULTS:
            return this.getInternalStateInfluenceAnalysisResults();
        case QualityAnnotationPackage.QUALITY_ANNOTATION__PROBABILISTIC_ELEMENTS:
            return this.getProbabilisticElements();
        case QualityAnnotationPackage.QUALITY_ANNOTATION__VALID_FOR_PARAMETER_PARTITIONS:
            return this.getValidForParameterPartitions();
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
        case QualityAnnotationPackage.QUALITY_ANNOTATION__IS_VALID:
            this.setIsValid((Boolean) newValue);
            return;
        case QualityAnnotationPackage.QUALITY_ANNOTATION__FOR_SERVICE_SPECIFICATION:
            this.setForServiceSpecification((ServiceSpecification) newValue);
            return;
        case QualityAnnotationPackage.QUALITY_ANNOTATION__STIPULATED_RE_PRECISIONS:
            this.getStipulatedREPrecisions().clear();
            this.getStipulatedREPrecisions().addAll((Collection<? extends RequiredElement>) newValue);
            return;
        case QualityAnnotationPackage.QUALITY_ANNOTATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_RESULTS:
            this.getInternalStateInfluenceAnalysisResults().clear();
            this.getInternalStateInfluenceAnalysisResults().addAll(
                    (Collection<? extends InternalStateInfluenceAnalysisAggregation>) newValue);
            return;
        case QualityAnnotationPackage.QUALITY_ANNOTATION__PROBABILISTIC_ELEMENTS:
            this.getProbabilisticElements().clear();
            this.getProbabilisticElements().addAll((Collection<? extends ProbabilisticElement>) newValue);
            return;
        case QualityAnnotationPackage.QUALITY_ANNOTATION__VALID_FOR_PARAMETER_PARTITIONS:
            this.getValidForParameterPartitions().clear();
            this.getValidForParameterPartitions().addAll((Collection<? extends ParameterPartition>) newValue);
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
        case QualityAnnotationPackage.QUALITY_ANNOTATION__IS_VALID:
            this.setIsValid(IS_VALID_EDEFAULT);
            return;
        case QualityAnnotationPackage.QUALITY_ANNOTATION__FOR_SERVICE_SPECIFICATION:
            this.setForServiceSpecification((ServiceSpecification) null);
            return;
        case QualityAnnotationPackage.QUALITY_ANNOTATION__STIPULATED_RE_PRECISIONS:
            this.getStipulatedREPrecisions().clear();
            return;
        case QualityAnnotationPackage.QUALITY_ANNOTATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_RESULTS:
            this.getInternalStateInfluenceAnalysisResults().clear();
            return;
        case QualityAnnotationPackage.QUALITY_ANNOTATION__PROBABILISTIC_ELEMENTS:
            this.getProbabilisticElements().clear();
            return;
        case QualityAnnotationPackage.QUALITY_ANNOTATION__VALID_FOR_PARAMETER_PARTITIONS:
            this.getValidForParameterPartitions().clear();
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
        case QualityAnnotationPackage.QUALITY_ANNOTATION__IS_VALID:
            return this.isValid != IS_VALID_EDEFAULT;
        case QualityAnnotationPackage.QUALITY_ANNOTATION__FOR_SERVICE_SPECIFICATION:
            return this.forServiceSpecification != null;
        case QualityAnnotationPackage.QUALITY_ANNOTATION__STIPULATED_RE_PRECISIONS:
            return this.stipulatedREPrecisions != null && !this.stipulatedREPrecisions.isEmpty();
        case QualityAnnotationPackage.QUALITY_ANNOTATION__INTERNAL_STATE_INFLUENCE_ANALYSIS_RESULTS:
            return this.internalStateInfluenceAnalysisResults != null
                    && !this.internalStateInfluenceAnalysisResults.isEmpty();
        case QualityAnnotationPackage.QUALITY_ANNOTATION__PROBABILISTIC_ELEMENTS:
            return this.probabilisticElements != null && !this.probabilisticElements.isEmpty();
        case QualityAnnotationPackage.QUALITY_ANNOTATION__VALID_FOR_PARAMETER_PARTITIONS:
            return this.validForParameterPartitions != null && !this.validForParameterPartitions.isEmpty();
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
        result.append(" (isValid: ");
        result.append(this.isValid);
        result.append(')');
        return result.toString();
    }

} // QualityAnnotationImpl
