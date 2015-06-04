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
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.fzi.se.quality.qualityannotation.QualityAnnotation;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.fzi.se.quality.qualityannotation.ServiceSpecification;
import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Service Specification</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.fzi.se.quality.qualityannotation.impl.ServiceSpecificationImpl#getChecksum <em>
 * Checksum</em>}</li>
 * <li>{@link de.fzi.se.quality.qualityannotation.impl.ServiceSpecificationImpl#getChecksumAlg <em>
 * Checksum Alg</em>}</li>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.impl.ServiceSpecificationImpl#getQualityAnnotation
 * <em>Quality Annotation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ServiceSpecificationImpl extends IdentifierImpl implements ServiceSpecification {

    /**
     * The default value of the '{@link #getChecksum() <em>Checksum</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getChecksum()
     * @generated
     * @ordered
     */
    protected static final long CHECKSUM_EDEFAULT = 0L;

    /**
     * The cached value of the '{@link #getChecksum() <em>Checksum</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getChecksum()
     * @generated
     * @ordered
     */
    protected long checksum = CHECKSUM_EDEFAULT;

    /**
     * The default value of the '{@link #getChecksumAlg() <em>Checksum Alg</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getChecksumAlg()
     * @generated
     * @ordered
     */
    protected static final String CHECKSUM_ALG_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getChecksumAlg() <em>Checksum Alg</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getChecksumAlg()
     * @generated
     * @ordered
     */
    protected String checksumAlg = CHECKSUM_ALG_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ServiceSpecificationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return QualityAnnotationPackage.Literals.SERVICE_SPECIFICATION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public long getChecksum() {
        return this.checksum;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setChecksum(final long newChecksum) {
        final long oldChecksum = this.checksum;
        this.checksum = newChecksum;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    QualityAnnotationPackage.SERVICE_SPECIFICATION__CHECKSUM, oldChecksum, this.checksum));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getChecksumAlg() {
        return this.checksumAlg;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setChecksumAlg(final String newChecksumAlg) {
        final String oldChecksumAlg = this.checksumAlg;
        this.checksumAlg = newChecksumAlg;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    QualityAnnotationPackage.SERVICE_SPECIFICATION__CHECKSUM_ALG, oldChecksumAlg, this.checksumAlg));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public QualityAnnotation getQualityAnnotation() {
        if (this.eContainerFeatureID() != QualityAnnotationPackage.SERVICE_SPECIFICATION__QUALITY_ANNOTATION) {
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
                QualityAnnotationPackage.SERVICE_SPECIFICATION__QUALITY_ANNOTATION, msgs);
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
                || (this.eContainerFeatureID() != QualityAnnotationPackage.SERVICE_SPECIFICATION__QUALITY_ANNOTATION && newQualityAnnotation != null)) {
            if (EcoreUtil.isAncestor(this, newQualityAnnotation)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newQualityAnnotation != null) {
                msgs = ((InternalEObject) newQualityAnnotation).eInverseAdd(this,
                        QualityAnnotationPackage.QUALITY_ANNOTATION__FOR_SERVICE_SPECIFICATION,
                        QualityAnnotation.class, msgs);
            }
            msgs = this.basicSetQualityAnnotation(newQualityAnnotation, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    QualityAnnotationPackage.SERVICE_SPECIFICATION__QUALITY_ANNOTATION, newQualityAnnotation,
                    newQualityAnnotation));
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
        case QualityAnnotationPackage.SERVICE_SPECIFICATION__QUALITY_ANNOTATION:
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
        case QualityAnnotationPackage.SERVICE_SPECIFICATION__QUALITY_ANNOTATION:
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
        case QualityAnnotationPackage.SERVICE_SPECIFICATION__QUALITY_ANNOTATION:
            return this.eInternalContainer().eInverseRemove(this,
                    QualityAnnotationPackage.QUALITY_ANNOTATION__FOR_SERVICE_SPECIFICATION, QualityAnnotation.class,
                    msgs);
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
        case QualityAnnotationPackage.SERVICE_SPECIFICATION__CHECKSUM:
            return this.getChecksum();
        case QualityAnnotationPackage.SERVICE_SPECIFICATION__CHECKSUM_ALG:
            return this.getChecksumAlg();
        case QualityAnnotationPackage.SERVICE_SPECIFICATION__QUALITY_ANNOTATION:
            return this.getQualityAnnotation();
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
        case QualityAnnotationPackage.SERVICE_SPECIFICATION__CHECKSUM:
            this.setChecksum((Long) newValue);
            return;
        case QualityAnnotationPackage.SERVICE_SPECIFICATION__CHECKSUM_ALG:
            this.setChecksumAlg((String) newValue);
            return;
        case QualityAnnotationPackage.SERVICE_SPECIFICATION__QUALITY_ANNOTATION:
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
        case QualityAnnotationPackage.SERVICE_SPECIFICATION__CHECKSUM:
            this.setChecksum(CHECKSUM_EDEFAULT);
            return;
        case QualityAnnotationPackage.SERVICE_SPECIFICATION__CHECKSUM_ALG:
            this.setChecksumAlg(CHECKSUM_ALG_EDEFAULT);
            return;
        case QualityAnnotationPackage.SERVICE_SPECIFICATION__QUALITY_ANNOTATION:
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
        case QualityAnnotationPackage.SERVICE_SPECIFICATION__CHECKSUM:
            return this.checksum != CHECKSUM_EDEFAULT;
        case QualityAnnotationPackage.SERVICE_SPECIFICATION__CHECKSUM_ALG:
            return CHECKSUM_ALG_EDEFAULT == null ? this.checksumAlg != null : !CHECKSUM_ALG_EDEFAULT
                    .equals(this.checksumAlg);
        case QualityAnnotationPackage.SERVICE_SPECIFICATION__QUALITY_ANNOTATION:
            return this.getQualityAnnotation() != null;
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
        result.append(" (checksum: ");
        result.append(this.checksum);
        result.append(", checksumAlg: ");
        result.append(this.checksumAlg);
        result.append(')');
        return result.toString();
    }

} // ServiceSpecificationImpl
