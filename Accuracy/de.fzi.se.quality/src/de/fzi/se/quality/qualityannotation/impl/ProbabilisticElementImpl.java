/**
 */
package de.fzi.se.quality.qualityannotation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import de.fzi.se.quality.qualityannotation.Precision;
import de.fzi.se.quality.qualityannotation.ProbabilisticElement;
import de.fzi.se.quality.qualityannotation.QualityAnnotation;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Probabilistic Element</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.fzi.se.quality.qualityannotation.impl.ProbabilisticElementImpl#getPrecision <em>
 * Precision</em>}</li>
 * <li>{@link de.fzi.se.quality.qualityannotation.impl.ProbabilisticElementImpl#getChildPEs <em>
 * Child PEs</em>}</li>
 * <li>{@link de.fzi.se.quality.qualityannotation.impl.ProbabilisticElementImpl#getParentPE <em>
 * Parent PE</em>}</li>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.impl.ProbabilisticElementImpl#getQualityAnnotation
 * <em>Quality Annotation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ProbabilisticElementImpl extends CDOObjectImpl implements ProbabilisticElement {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ProbabilisticElementImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return QualityAnnotationPackage.Literals.PROBABILISTIC_ELEMENT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected int eStaticFeatureCount() {
        return 0;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Precision getPrecision() {
        return (Precision) this.eDynamicGet(QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PRECISION,
                QualityAnnotationPackage.Literals.PROBABILISTIC_ELEMENT__PRECISION, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetPrecision(final Precision newPrecision, NotificationChain msgs) {
        msgs = this.eDynamicInverseAdd((InternalEObject) newPrecision,
                QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PRECISION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setPrecision(final Precision newPrecision) {
        this.eDynamicSet(QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PRECISION,
                QualityAnnotationPackage.Literals.PROBABILISTIC_ELEMENT__PRECISION, newPrecision);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<ProbabilisticElement> getChildPEs() {
        return (EList<ProbabilisticElement>) this.eDynamicGet(
                QualityAnnotationPackage.PROBABILISTIC_ELEMENT__CHILD_PES,
                QualityAnnotationPackage.Literals.PROBABILISTIC_ELEMENT__CHILD_PES, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ProbabilisticElement getParentPE() {
        return (ProbabilisticElement) this.eDynamicGet(QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PARENT_PE,
                QualityAnnotationPackage.Literals.PROBABILISTIC_ELEMENT__PARENT_PE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetParentPE(final ProbabilisticElement newParentPE, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newParentPE,
                QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PARENT_PE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setParentPE(final ProbabilisticElement newParentPE) {
        this.eDynamicSet(QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PARENT_PE,
                QualityAnnotationPackage.Literals.PROBABILISTIC_ELEMENT__PARENT_PE, newParentPE);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public QualityAnnotation getQualityAnnotation() {
        return (QualityAnnotation) this.eDynamicGet(QualityAnnotationPackage.PROBABILISTIC_ELEMENT__QUALITY_ANNOTATION,
                QualityAnnotationPackage.Literals.PROBABILISTIC_ELEMENT__QUALITY_ANNOTATION, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetQualityAnnotation(final QualityAnnotation newQualityAnnotation,
            NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newQualityAnnotation,
                QualityAnnotationPackage.PROBABILISTIC_ELEMENT__QUALITY_ANNOTATION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setQualityAnnotation(final QualityAnnotation newQualityAnnotation) {
        this.eDynamicSet(QualityAnnotationPackage.PROBABILISTIC_ELEMENT__QUALITY_ANNOTATION,
                QualityAnnotationPackage.Literals.PROBABILISTIC_ELEMENT__QUALITY_ANNOTATION, newQualityAnnotation);
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
        case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__CHILD_PES:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getChildPEs()).basicAdd(otherEnd, msgs);
        case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PARENT_PE:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetParentPE((ProbabilisticElement) otherEnd, msgs);
        case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__QUALITY_ANNOTATION:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetQualityAnnotation((QualityAnnotation) otherEnd, msgs);
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
        case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PRECISION:
            return this.basicSetPrecision(null, msgs);
        case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__CHILD_PES:
            return ((InternalEList<?>) this.getChildPEs()).basicRemove(otherEnd, msgs);
        case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PARENT_PE:
            return this.basicSetParentPE(null, msgs);
        case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__QUALITY_ANNOTATION:
            return this.basicSetQualityAnnotation(null, msgs);
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
        case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PARENT_PE:
            return this.eInternalContainer().eInverseRemove(this,
                    QualityAnnotationPackage.PROBABILISTIC_ELEMENT__CHILD_PES, ProbabilisticElement.class, msgs);
        case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__QUALITY_ANNOTATION:
            return this.eInternalContainer().eInverseRemove(this,
                    QualityAnnotationPackage.QUALITY_ANNOTATION__PROBABILISTIC_ELEMENTS, QualityAnnotation.class, msgs);
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
        case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PRECISION:
            return this.getPrecision();
        case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__CHILD_PES:
            return this.getChildPEs();
        case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PARENT_PE:
            return this.getParentPE();
        case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__QUALITY_ANNOTATION:
            return this.getQualityAnnotation();
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
        case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PRECISION:
            this.setPrecision((Precision) newValue);
            return;
        case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__CHILD_PES:
            this.getChildPEs().clear();
            this.getChildPEs().addAll((Collection<? extends ProbabilisticElement>) newValue);
            return;
        case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PARENT_PE:
            this.setParentPE((ProbabilisticElement) newValue);
            return;
        case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__QUALITY_ANNOTATION:
            this.setQualityAnnotation((QualityAnnotation) newValue);
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
        case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PRECISION:
            this.setPrecision((Precision) null);
            return;
        case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__CHILD_PES:
            this.getChildPEs().clear();
            return;
        case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PARENT_PE:
            this.setParentPE((ProbabilisticElement) null);
            return;
        case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__QUALITY_ANNOTATION:
            this.setQualityAnnotation((QualityAnnotation) null);
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
        case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PRECISION:
            return this.getPrecision() != null;
        case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__CHILD_PES:
            return !this.getChildPEs().isEmpty();
        case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PARENT_PE:
            return this.getParentPE() != null;
        case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__QUALITY_ANNOTATION:
            return this.getQualityAnnotation() != null;
        }
        return super.eIsSet(featureID);
    }

} // ProbabilisticElementImpl
