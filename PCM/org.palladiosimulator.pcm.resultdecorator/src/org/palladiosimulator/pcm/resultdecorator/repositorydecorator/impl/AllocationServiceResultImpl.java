/**
 */
package org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.AllocationServiceResult;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage;

import org.palladiosimulator.pcm.allocation.AllocationContext;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Allocation Service Result</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.AllocationServiceResultImpl#getAllocationContext_AllocationServiceResult
 * <em>Allocation Context Allocation Service Result</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AllocationServiceResultImpl extends ServiceResultImpl implements AllocationServiceResult {

    /**
     * The cached value of the '{@link #getAllocationContext_AllocationServiceResult()
     * <em>Allocation Context Allocation Service Result</em>}' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getAllocationContext_AllocationServiceResult()
     * @generated
     * @ordered
     */
    protected AllocationContext allocationContext_AllocationServiceResult;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected AllocationServiceResultImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RepositorydecoratorPackage.Literals.ALLOCATION_SERVICE_RESULT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public AllocationContext getAllocationContext_AllocationServiceResult() {
        if (this.allocationContext_AllocationServiceResult != null
                && ((EObject) this.allocationContext_AllocationServiceResult).eIsProxy()) {
            final InternalEObject oldAllocationContext_AllocationServiceResult = (InternalEObject) this.allocationContext_AllocationServiceResult;
            this.allocationContext_AllocationServiceResult = (AllocationContext) this
                    .eResolveProxy(oldAllocationContext_AllocationServiceResult);
            if (this.allocationContext_AllocationServiceResult != oldAllocationContext_AllocationServiceResult) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            RepositorydecoratorPackage.ALLOCATION_SERVICE_RESULT__ALLOCATION_CONTEXT_ALLOCATION_SERVICE_RESULT,
                            oldAllocationContext_AllocationServiceResult,
                            this.allocationContext_AllocationServiceResult));
                }
            }
        }
        return this.allocationContext_AllocationServiceResult;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public AllocationContext basicGetAllocationContext_AllocationServiceResult() {
        return this.allocationContext_AllocationServiceResult;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setAllocationContext_AllocationServiceResult(
            final AllocationContext newAllocationContext_AllocationServiceResult) {
        final AllocationContext oldAllocationContext_AllocationServiceResult = this.allocationContext_AllocationServiceResult;
        this.allocationContext_AllocationServiceResult = newAllocationContext_AllocationServiceResult;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    RepositorydecoratorPackage.ALLOCATION_SERVICE_RESULT__ALLOCATION_CONTEXT_ALLOCATION_SERVICE_RESULT,
                    oldAllocationContext_AllocationServiceResult, this.allocationContext_AllocationServiceResult));
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
        case RepositorydecoratorPackage.ALLOCATION_SERVICE_RESULT__ALLOCATION_CONTEXT_ALLOCATION_SERVICE_RESULT:
            if (resolve) {
                return this.getAllocationContext_AllocationServiceResult();
            }
            return this.basicGetAllocationContext_AllocationServiceResult();
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
        case RepositorydecoratorPackage.ALLOCATION_SERVICE_RESULT__ALLOCATION_CONTEXT_ALLOCATION_SERVICE_RESULT:
            this.setAllocationContext_AllocationServiceResult((AllocationContext) newValue);
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
        case RepositorydecoratorPackage.ALLOCATION_SERVICE_RESULT__ALLOCATION_CONTEXT_ALLOCATION_SERVICE_RESULT:
            this.setAllocationContext_AllocationServiceResult((AllocationContext) null);
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
        case RepositorydecoratorPackage.ALLOCATION_SERVICE_RESULT__ALLOCATION_CONTEXT_ALLOCATION_SERVICE_RESULT:
            return this.allocationContext_AllocationServiceResult != null;
        }
        return super.eIsSet(featureID);
    }

} // AllocationServiceResultImpl
