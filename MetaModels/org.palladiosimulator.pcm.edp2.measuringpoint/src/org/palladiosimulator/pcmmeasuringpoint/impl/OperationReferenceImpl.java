/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.palladiosimulator.pcmmeasuringpoint.OperationReference;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;

import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.Role;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Operation Reference</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.palladiosimulator.pcmmeasuringpoint.impl.OperationReferenceImpl#getRole <em>Role
 * </em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcmmeasuringpoint.impl.OperationReferenceImpl#getOperationSignature
 * <em>Operation Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class OperationReferenceImpl extends CDOObjectImpl implements OperationReference {

    /**
     * The cached value of the '{@link #getRole() <em>Role</em>}' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getRole()
     * @generated
     * @ordered
     */
    protected Role role;

    /**
     * The cached value of the '{@link #getOperationSignature() <em>Operation Signature</em>}'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getOperationSignature()
     * @generated
     * @ordered
     */
    protected OperationSignature operationSignature;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected OperationReferenceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PcmmeasuringpointPackage.Literals.OPERATION_REFERENCE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Role getRole() {
        if (this.role != null && ((EObject) this.role).eIsProxy()) {
            final InternalEObject oldRole = (InternalEObject) this.role;
            this.role = (Role) this.eResolveProxy(oldRole);
            if (this.role != oldRole) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            PcmmeasuringpointPackage.OPERATION_REFERENCE__ROLE, oldRole, this.role));
                }
            }
        }
        return this.role;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public Role basicGetRole() {
        return this.role;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setRole(final Role newRole) {
        final Role oldRole = this.role;
        this.role = newRole;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    PcmmeasuringpointPackage.OPERATION_REFERENCE__ROLE, oldRole, this.role));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public OperationSignature getOperationSignature() {
        if (this.operationSignature != null && ((EObject) this.operationSignature).eIsProxy()) {
            final InternalEObject oldOperationSignature = (InternalEObject) this.operationSignature;
            this.operationSignature = (OperationSignature) this.eResolveProxy(oldOperationSignature);
            if (this.operationSignature != oldOperationSignature) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            PcmmeasuringpointPackage.OPERATION_REFERENCE__OPERATION_SIGNATURE, oldOperationSignature,
                            this.operationSignature));
                }
            }
        }
        return this.operationSignature;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public OperationSignature basicGetOperationSignature() {
        return this.operationSignature;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setOperationSignature(final OperationSignature newOperationSignature) {
        final OperationSignature oldOperationSignature = this.operationSignature;
        this.operationSignature = newOperationSignature;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    PcmmeasuringpointPackage.OPERATION_REFERENCE__OPERATION_SIGNATURE, oldOperationSignature,
                    this.operationSignature));
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
        case PcmmeasuringpointPackage.OPERATION_REFERENCE__ROLE:
            if (resolve) {
                return this.getRole();
            }
            return this.basicGetRole();
        case PcmmeasuringpointPackage.OPERATION_REFERENCE__OPERATION_SIGNATURE:
            if (resolve) {
                return this.getOperationSignature();
            }
            return this.basicGetOperationSignature();
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
        case PcmmeasuringpointPackage.OPERATION_REFERENCE__ROLE:
            this.setRole((Role) newValue);
            return;
        case PcmmeasuringpointPackage.OPERATION_REFERENCE__OPERATION_SIGNATURE:
            this.setOperationSignature((OperationSignature) newValue);
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
        case PcmmeasuringpointPackage.OPERATION_REFERENCE__ROLE:
            this.setRole((Role) null);
            return;
        case PcmmeasuringpointPackage.OPERATION_REFERENCE__OPERATION_SIGNATURE:
            this.setOperationSignature((OperationSignature) null);
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
        case PcmmeasuringpointPackage.OPERATION_REFERENCE__ROLE:
            return this.role != null;
        case PcmmeasuringpointPackage.OPERATION_REFERENCE__OPERATION_SIGNATURE:
            return this.operationSignature != null;
        }
        return super.eIsSet(featureID);
    }

} // OperationReferenceImpl
