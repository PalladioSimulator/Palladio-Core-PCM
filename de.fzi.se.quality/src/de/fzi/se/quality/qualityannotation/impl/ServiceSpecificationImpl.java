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
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.ServiceSpecificationImpl#getChecksum <em>Checksum</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.ServiceSpecificationImpl#getChecksumAlg <em>Checksum Alg</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.ServiceSpecificationImpl#getQualityAnnotation <em>Quality Annotation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ServiceSpecificationImpl extends IdentifierImpl implements ServiceSpecification {
	/**
     * The default value of the '{@link #getChecksum() <em>Checksum</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getChecksum()
     * @generated
     * @ordered
     */
	protected static final long CHECKSUM_EDEFAULT = 0L;

	/**
     * The cached value of the '{@link #getChecksum() <em>Checksum</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getChecksum()
     * @generated
     * @ordered
     */
	protected long checksum = CHECKSUM_EDEFAULT;

	/**
     * The default value of the '{@link #getChecksumAlg() <em>Checksum Alg</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getChecksumAlg()
     * @generated
     * @ordered
     */
	protected static final String CHECKSUM_ALG_EDEFAULT = null;

	/**
     * The cached value of the '{@link #getChecksumAlg() <em>Checksum Alg</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getChecksumAlg()
     * @generated
     * @ordered
     */
	protected String checksumAlg = CHECKSUM_ALG_EDEFAULT;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected ServiceSpecificationImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return QualityAnnotationPackage.Literals.SERVICE_SPECIFICATION;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public long getChecksum() {
        return checksum;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setChecksum(long newChecksum) {
        long oldChecksum = checksum;
        checksum = newChecksum;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.SERVICE_SPECIFICATION__CHECKSUM, oldChecksum, checksum));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String getChecksumAlg() {
        return checksumAlg;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setChecksumAlg(String newChecksumAlg) {
        String oldChecksumAlg = checksumAlg;
        checksumAlg = newChecksumAlg;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.SERVICE_SPECIFICATION__CHECKSUM_ALG, oldChecksumAlg, checksumAlg));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public QualityAnnotation getQualityAnnotation() {
        if (eContainerFeatureID() != QualityAnnotationPackage.SERVICE_SPECIFICATION__QUALITY_ANNOTATION) return null;
        return (QualityAnnotation)eInternalContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetQualityAnnotation(QualityAnnotation newQualityAnnotation, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newQualityAnnotation, QualityAnnotationPackage.SERVICE_SPECIFICATION__QUALITY_ANNOTATION, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setQualityAnnotation(QualityAnnotation newQualityAnnotation) {
        if (newQualityAnnotation != eInternalContainer() || (eContainerFeatureID() != QualityAnnotationPackage.SERVICE_SPECIFICATION__QUALITY_ANNOTATION && newQualityAnnotation != null)) {
            if (EcoreUtil.isAncestor(this, newQualityAnnotation))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newQualityAnnotation != null)
                msgs = ((InternalEObject)newQualityAnnotation).eInverseAdd(this, QualityAnnotationPackage.QUALITY_ANNOTATION__FOR_SERVICE_SPECIFICATION, QualityAnnotation.class, msgs);
            msgs = basicSetQualityAnnotation(newQualityAnnotation, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.SERVICE_SPECIFICATION__QUALITY_ANNOTATION, newQualityAnnotation, newQualityAnnotation));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case QualityAnnotationPackage.SERVICE_SPECIFICATION__QUALITY_ANNOTATION:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetQualityAnnotation((QualityAnnotation)otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case QualityAnnotationPackage.SERVICE_SPECIFICATION__QUALITY_ANNOTATION:
                return basicSetQualityAnnotation(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
            case QualityAnnotationPackage.SERVICE_SPECIFICATION__QUALITY_ANNOTATION:
                return eInternalContainer().eInverseRemove(this, QualityAnnotationPackage.QUALITY_ANNOTATION__FOR_SERVICE_SPECIFICATION, QualityAnnotation.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case QualityAnnotationPackage.SERVICE_SPECIFICATION__CHECKSUM:
                return getChecksum();
            case QualityAnnotationPackage.SERVICE_SPECIFICATION__CHECKSUM_ALG:
                return getChecksumAlg();
            case QualityAnnotationPackage.SERVICE_SPECIFICATION__QUALITY_ANNOTATION:
                return getQualityAnnotation();
        }
        return super.eGet(featureID, resolve, coreType);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case QualityAnnotationPackage.SERVICE_SPECIFICATION__CHECKSUM:
                setChecksum((Long)newValue);
                return;
            case QualityAnnotationPackage.SERVICE_SPECIFICATION__CHECKSUM_ALG:
                setChecksumAlg((String)newValue);
                return;
            case QualityAnnotationPackage.SERVICE_SPECIFICATION__QUALITY_ANNOTATION:
                setQualityAnnotation((QualityAnnotation)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public void eUnset(int featureID) {
        switch (featureID) {
            case QualityAnnotationPackage.SERVICE_SPECIFICATION__CHECKSUM:
                setChecksum(CHECKSUM_EDEFAULT);
                return;
            case QualityAnnotationPackage.SERVICE_SPECIFICATION__CHECKSUM_ALG:
                setChecksumAlg(CHECKSUM_ALG_EDEFAULT);
                return;
            case QualityAnnotationPackage.SERVICE_SPECIFICATION__QUALITY_ANNOTATION:
                setQualityAnnotation((QualityAnnotation)null);
                return;
        }
        super.eUnset(featureID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public boolean eIsSet(int featureID) {
        switch (featureID) {
            case QualityAnnotationPackage.SERVICE_SPECIFICATION__CHECKSUM:
                return checksum != CHECKSUM_EDEFAULT;
            case QualityAnnotationPackage.SERVICE_SPECIFICATION__CHECKSUM_ALG:
                return CHECKSUM_ALG_EDEFAULT == null ? checksumAlg != null : !CHECKSUM_ALG_EDEFAULT.equals(checksumAlg);
            case QualityAnnotationPackage.SERVICE_SPECIFICATION__QUALITY_ANNOTATION:
                return getQualityAnnotation() != null;
        }
        return super.eIsSet(featureID);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (checksum: ");
        result.append(checksum);
        result.append(", checksumAlg: ");
        result.append(checksumAlg);
        result.append(')');
        return result.toString();
    }

} //ServiceSpecificationImpl
