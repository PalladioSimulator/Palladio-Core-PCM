/**
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
import org.eclipse.emf.ecore.util.EcoreUtil;
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
     * The cached value of the '{@link #getPrecision() <em>Precision</em>}' containment reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getPrecision()
     * @generated
     * @ordered
     */
    protected Precision precision;

    /**
     * The cached value of the '{@link #getChildPEs() <em>Child PEs</em>}' containment reference
     * list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getChildPEs()
     * @generated
     * @ordered
     */
    protected EList<ProbabilisticElement> childPEs;

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
    public Precision getPrecision() {
        return this.precision;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetPrecision(final Precision newPrecision, NotificationChain msgs) {
        final Precision oldPrecision = this.precision;
        this.precision = newPrecision;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PRECISION, oldPrecision, newPrecision);
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
    public void setPrecision(final Precision newPrecision) {
        if (newPrecision != this.precision) {
            NotificationChain msgs = null;
            if (this.precision != null) {
                msgs = ((InternalEObject) this.precision).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PRECISION, null, msgs);
            }
            if (newPrecision != null) {
                msgs = ((InternalEObject) newPrecision).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
                        - QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PRECISION, null, msgs);
            }
            msgs = this.basicSetPrecision(newPrecision, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PRECISION, newPrecision, newPrecision));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<ProbabilisticElement> getChildPEs() {
        if (this.childPEs == null) {
            this.childPEs = new EObjectContainmentWithInverseEList<ProbabilisticElement>(ProbabilisticElement.class,
                    this, QualityAnnotationPackage.PROBABILISTIC_ELEMENT__CHILD_PES,
                    QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PARENT_PE);
        }
        return this.childPEs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ProbabilisticElement getParentPE() {
        if (this.eContainerFeatureID() != QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PARENT_PE) {
            return null;
        }
        return (ProbabilisticElement) this.eInternalContainer();
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
        if (newParentPE != this.eInternalContainer()
                || (this.eContainerFeatureID() != QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PARENT_PE && newParentPE != null)) {
            if (EcoreUtil.isAncestor(this, newParentPE)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newParentPE != null) {
                msgs = ((InternalEObject) newParentPE).eInverseAdd(this,
                        QualityAnnotationPackage.PROBABILISTIC_ELEMENT__CHILD_PES, ProbabilisticElement.class, msgs);
            }
            msgs = this.basicSetParentPE(newParentPE, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PARENT_PE, newParentPE, newParentPE));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public QualityAnnotation getQualityAnnotation() {
        if (this.eContainerFeatureID() != QualityAnnotationPackage.PROBABILISTIC_ELEMENT__QUALITY_ANNOTATION) {
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
        if (newQualityAnnotation != this.eInternalContainer()
                || (this.eContainerFeatureID() != QualityAnnotationPackage.PROBABILISTIC_ELEMENT__QUALITY_ANNOTATION && newQualityAnnotation != null)) {
            if (EcoreUtil.isAncestor(this, newQualityAnnotation)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newQualityAnnotation != null) {
                msgs = ((InternalEObject) newQualityAnnotation).eInverseAdd(this,
                        QualityAnnotationPackage.QUALITY_ANNOTATION__PROBABILISTIC_ELEMENTS, QualityAnnotation.class,
                        msgs);
            }
            msgs = this.basicSetQualityAnnotation(newQualityAnnotation, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    QualityAnnotationPackage.PROBABILISTIC_ELEMENT__QUALITY_ANNOTATION, newQualityAnnotation,
                    newQualityAnnotation));
        }
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
            return this.precision != null;
        case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__CHILD_PES:
            return this.childPEs != null && !this.childPEs.isEmpty();
        case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__PARENT_PE:
            return this.getParentPE() != null;
        case QualityAnnotationPackage.PROBABILISTIC_ELEMENT__QUALITY_ANNOTATION:
            return this.getQualityAnnotation() != null;
        }
        return super.eIsSet(featureID);
    }

} // ProbabilisticElementImpl
