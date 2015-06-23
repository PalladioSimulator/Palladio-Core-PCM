/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.AllocationServiceResult;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Allocation Service Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl.AllocationServiceResultImpl#getAllocationContext_AllocationServiceResult <em>Allocation Context Allocation Service Result</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AllocationServiceResultImpl extends ServiceResultImpl implements AllocationServiceResult {
	/**
	 * The cached value of the '{@link #getAllocationContext_AllocationServiceResult() <em>Allocation Context Allocation Service Result</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllocationContext_AllocationServiceResult()
	 * @generated
	 * @ordered
	 */
	protected AllocationContext allocationContext_AllocationServiceResult;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AllocationServiceResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RepositorydecoratorPackage.Literals.ALLOCATION_SERVICE_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllocationContext getAllocationContext_AllocationServiceResult() {
		if (allocationContext_AllocationServiceResult != null && allocationContext_AllocationServiceResult.eIsProxy()) {
			InternalEObject oldAllocationContext_AllocationServiceResult = (InternalEObject)allocationContext_AllocationServiceResult;
			allocationContext_AllocationServiceResult = (AllocationContext)eResolveProxy(oldAllocationContext_AllocationServiceResult);
			if (allocationContext_AllocationServiceResult != oldAllocationContext_AllocationServiceResult) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepositorydecoratorPackage.ALLOCATION_SERVICE_RESULT__ALLOCATION_CONTEXT_ALLOCATION_SERVICE_RESULT, oldAllocationContext_AllocationServiceResult, allocationContext_AllocationServiceResult));
			}
		}
		return allocationContext_AllocationServiceResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllocationContext basicGetAllocationContext_AllocationServiceResult() {
		return allocationContext_AllocationServiceResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllocationContext_AllocationServiceResult(AllocationContext newAllocationContext_AllocationServiceResult) {
		AllocationContext oldAllocationContext_AllocationServiceResult = allocationContext_AllocationServiceResult;
		allocationContext_AllocationServiceResult = newAllocationContext_AllocationServiceResult;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositorydecoratorPackage.ALLOCATION_SERVICE_RESULT__ALLOCATION_CONTEXT_ALLOCATION_SERVICE_RESULT, oldAllocationContext_AllocationServiceResult, allocationContext_AllocationServiceResult));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RepositorydecoratorPackage.ALLOCATION_SERVICE_RESULT__ALLOCATION_CONTEXT_ALLOCATION_SERVICE_RESULT:
				if (resolve) return getAllocationContext_AllocationServiceResult();
				return basicGetAllocationContext_AllocationServiceResult();
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
			case RepositorydecoratorPackage.ALLOCATION_SERVICE_RESULT__ALLOCATION_CONTEXT_ALLOCATION_SERVICE_RESULT:
				setAllocationContext_AllocationServiceResult((AllocationContext)newValue);
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
			case RepositorydecoratorPackage.ALLOCATION_SERVICE_RESULT__ALLOCATION_CONTEXT_ALLOCATION_SERVICE_RESULT:
				setAllocationContext_AllocationServiceResult((AllocationContext)null);
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
			case RepositorydecoratorPackage.ALLOCATION_SERVICE_RESULT__ALLOCATION_CONTEXT_ALLOCATION_SERVICE_RESULT:
				return allocationContext_AllocationServiceResult != null;
		}
		return super.eIsSet(featureID);
	}

} //AllocationServiceResultImpl
