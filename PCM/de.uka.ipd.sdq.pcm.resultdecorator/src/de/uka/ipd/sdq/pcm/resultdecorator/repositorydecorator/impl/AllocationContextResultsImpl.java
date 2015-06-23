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
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.AllocationContextResults;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Allocation Context Results</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl.AllocationContextResultsImpl#getAllocationContext_AllocationContextResult <em>Allocation Context Allocation Context Result</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AllocationContextResultsImpl extends ComponentResultImpl implements AllocationContextResults {
	/**
	 * The cached value of the '{@link #getAllocationContext_AllocationContextResult() <em>Allocation Context Allocation Context Result</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllocationContext_AllocationContextResult()
	 * @generated
	 * @ordered
	 */
	protected AllocationContext allocationContext_AllocationContextResult;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AllocationContextResultsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RepositorydecoratorPackage.Literals.ALLOCATION_CONTEXT_RESULTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllocationContext getAllocationContext_AllocationContextResult() {
		if (allocationContext_AllocationContextResult != null && allocationContext_AllocationContextResult.eIsProxy()) {
			InternalEObject oldAllocationContext_AllocationContextResult = (InternalEObject)allocationContext_AllocationContextResult;
			allocationContext_AllocationContextResult = (AllocationContext)eResolveProxy(oldAllocationContext_AllocationContextResult);
			if (allocationContext_AllocationContextResult != oldAllocationContext_AllocationContextResult) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepositorydecoratorPackage.ALLOCATION_CONTEXT_RESULTS__ALLOCATION_CONTEXT_ALLOCATION_CONTEXT_RESULT, oldAllocationContext_AllocationContextResult, allocationContext_AllocationContextResult));
			}
		}
		return allocationContext_AllocationContextResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllocationContext basicGetAllocationContext_AllocationContextResult() {
		return allocationContext_AllocationContextResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllocationContext_AllocationContextResult(AllocationContext newAllocationContext_AllocationContextResult) {
		AllocationContext oldAllocationContext_AllocationContextResult = allocationContext_AllocationContextResult;
		allocationContext_AllocationContextResult = newAllocationContext_AllocationContextResult;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositorydecoratorPackage.ALLOCATION_CONTEXT_RESULTS__ALLOCATION_CONTEXT_ALLOCATION_CONTEXT_RESULT, oldAllocationContext_AllocationContextResult, allocationContext_AllocationContextResult));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RepositorydecoratorPackage.ALLOCATION_CONTEXT_RESULTS__ALLOCATION_CONTEXT_ALLOCATION_CONTEXT_RESULT:
				if (resolve) return getAllocationContext_AllocationContextResult();
				return basicGetAllocationContext_AllocationContextResult();
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
			case RepositorydecoratorPackage.ALLOCATION_CONTEXT_RESULTS__ALLOCATION_CONTEXT_ALLOCATION_CONTEXT_RESULT:
				setAllocationContext_AllocationContextResult((AllocationContext)newValue);
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
			case RepositorydecoratorPackage.ALLOCATION_CONTEXT_RESULTS__ALLOCATION_CONTEXT_ALLOCATION_CONTEXT_RESULT:
				setAllocationContext_AllocationContextResult((AllocationContext)null);
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
			case RepositorydecoratorPackage.ALLOCATION_CONTEXT_RESULTS__ALLOCATION_CONTEXT_ALLOCATION_CONTEXT_RESULT:
				return allocationContext_AllocationContextResult != null;
		}
		return super.eIsSet(featureID);
	}

} //AllocationContextResultsImpl
