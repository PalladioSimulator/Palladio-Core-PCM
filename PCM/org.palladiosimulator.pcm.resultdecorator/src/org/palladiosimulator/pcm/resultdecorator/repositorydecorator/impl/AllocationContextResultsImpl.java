/**
 */
package org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.AllocationContextResults;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage;

import org.palladiosimulator.pcm.allocation.AllocationContext;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Allocation Context Results</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.AllocationContextResultsImpl#getAllocationContext_AllocationContextResult
 * <em>Allocation Context Allocation Context Result</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AllocationContextResultsImpl extends ComponentResultImpl implements AllocationContextResults {

    /**
     * The cached value of the '{@link #getAllocationContext_AllocationContextResult()
     * <em>Allocation Context Allocation Context Result</em>}' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getAllocationContext_AllocationContextResult()
     * @generated
     * @ordered
     */
    protected AllocationContext allocationContext_AllocationContextResult;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected AllocationContextResultsImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RepositorydecoratorPackage.Literals.ALLOCATION_CONTEXT_RESULTS;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public AllocationContext getAllocationContext_AllocationContextResult() {
        if (this.allocationContext_AllocationContextResult != null
                && ((EObject) this.allocationContext_AllocationContextResult).eIsProxy()) {
            final InternalEObject oldAllocationContext_AllocationContextResult = (InternalEObject) this.allocationContext_AllocationContextResult;
            this.allocationContext_AllocationContextResult = (AllocationContext) this
                    .eResolveProxy(oldAllocationContext_AllocationContextResult);
            if (this.allocationContext_AllocationContextResult != oldAllocationContext_AllocationContextResult) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            RepositorydecoratorPackage.ALLOCATION_CONTEXT_RESULTS__ALLOCATION_CONTEXT_ALLOCATION_CONTEXT_RESULT,
                            oldAllocationContext_AllocationContextResult,
                            this.allocationContext_AllocationContextResult));
                }
            }
        }
        return this.allocationContext_AllocationContextResult;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public AllocationContext basicGetAllocationContext_AllocationContextResult() {
        return this.allocationContext_AllocationContextResult;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setAllocationContext_AllocationContextResult(
            final AllocationContext newAllocationContext_AllocationContextResult) {
        final AllocationContext oldAllocationContext_AllocationContextResult = this.allocationContext_AllocationContextResult;
        this.allocationContext_AllocationContextResult = newAllocationContext_AllocationContextResult;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    RepositorydecoratorPackage.ALLOCATION_CONTEXT_RESULTS__ALLOCATION_CONTEXT_ALLOCATION_CONTEXT_RESULT,
                    oldAllocationContext_AllocationContextResult, this.allocationContext_AllocationContextResult));
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
        case RepositorydecoratorPackage.ALLOCATION_CONTEXT_RESULTS__ALLOCATION_CONTEXT_ALLOCATION_CONTEXT_RESULT:
            if (resolve) {
                return this.getAllocationContext_AllocationContextResult();
            }
            return this.basicGetAllocationContext_AllocationContextResult();
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
        case RepositorydecoratorPackage.ALLOCATION_CONTEXT_RESULTS__ALLOCATION_CONTEXT_ALLOCATION_CONTEXT_RESULT:
            this.setAllocationContext_AllocationContextResult((AllocationContext) newValue);
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
        case RepositorydecoratorPackage.ALLOCATION_CONTEXT_RESULTS__ALLOCATION_CONTEXT_ALLOCATION_CONTEXT_RESULT:
            this.setAllocationContext_AllocationContextResult((AllocationContext) null);
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
        case RepositorydecoratorPackage.ALLOCATION_CONTEXT_RESULTS__ALLOCATION_CONTEXT_ALLOCATION_CONTEXT_RESULT:
            return this.allocationContext_AllocationContextResult != null;
        }
        return super.eIsSet(featureID);
    }

} // AllocationContextResultsImpl
