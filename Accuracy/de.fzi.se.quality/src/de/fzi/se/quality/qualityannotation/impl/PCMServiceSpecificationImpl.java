/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.fzi.se.quality.qualityannotation.PCMServiceSpecification;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>PCM Service Specification</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.fzi.se.quality.qualityannotation.impl.PCMServiceSpecificationImpl#getResourceDemandingSEFF
 * <em>Resource Demanding SEFF</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PCMServiceSpecificationImpl extends ServiceSpecificationImpl implements PCMServiceSpecification {

    /**
     * The cached value of the '{@link #getResourceDemandingSEFF() <em>Resource Demanding SEFF</em>}
     * ' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getResourceDemandingSEFF()
     * @generated
     * @ordered
     */
    protected ResourceDemandingSEFF resourceDemandingSEFF;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected PCMServiceSpecificationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return QualityAnnotationPackage.Literals.PCM_SERVICE_SPECIFICATION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceDemandingSEFF getResourceDemandingSEFF() {
        if (this.resourceDemandingSEFF != null && ((EObject) this.resourceDemandingSEFF).eIsProxy()) {
            final InternalEObject oldResourceDemandingSEFF = (InternalEObject) this.resourceDemandingSEFF;
            this.resourceDemandingSEFF = (ResourceDemandingSEFF) this.eResolveProxy(oldResourceDemandingSEFF);
            if (this.resourceDemandingSEFF != oldResourceDemandingSEFF) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            QualityAnnotationPackage.PCM_SERVICE_SPECIFICATION__RESOURCE_DEMANDING_SEFF,
                            oldResourceDemandingSEFF, this.resourceDemandingSEFF));
                }
            }
        }
        return this.resourceDemandingSEFF;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public ResourceDemandingSEFF basicGetResourceDemandingSEFF() {
        return this.resourceDemandingSEFF;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setResourceDemandingSEFF(final ResourceDemandingSEFF newResourceDemandingSEFF) {
        final ResourceDemandingSEFF oldResourceDemandingSEFF = this.resourceDemandingSEFF;
        this.resourceDemandingSEFF = newResourceDemandingSEFF;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    QualityAnnotationPackage.PCM_SERVICE_SPECIFICATION__RESOURCE_DEMANDING_SEFF,
                    oldResourceDemandingSEFF, this.resourceDemandingSEFF));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case QualityAnnotationPackage.PCM_SERVICE_SPECIFICATION__RESOURCE_DEMANDING_SEFF:
            if (resolve) {
                return this.getResourceDemandingSEFF();
            }
            return this.basicGetResourceDemandingSEFF();
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
        case QualityAnnotationPackage.PCM_SERVICE_SPECIFICATION__RESOURCE_DEMANDING_SEFF:
            this.setResourceDemandingSEFF((ResourceDemandingSEFF) newValue);
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
        case QualityAnnotationPackage.PCM_SERVICE_SPECIFICATION__RESOURCE_DEMANDING_SEFF:
            this.setResourceDemandingSEFF((ResourceDemandingSEFF) null);
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
        case QualityAnnotationPackage.PCM_SERVICE_SPECIFICATION__RESOURCE_DEMANDING_SEFF:
            return this.resourceDemandingSEFF != null;
        }
        return super.eIsSet(featureID);
    }

} // PCMServiceSpecificationImpl
