/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl;

import de.uka.ipd.sdq.pcm.allocation.AllocationContext;

import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.AllocationContextResults;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Allocation Context Results</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl.AllocationContextResultsImpl#getAllocationcontext <em>Allocationcontext</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AllocationContextResultsImpl extends ComponentResultImpl implements AllocationContextResults {
	/**
	 * The cached value of the '{@link #getAllocationcontext() <em>Allocationcontext</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllocationcontext()
	 * @generated
	 * @ordered
	 */
	protected AllocationContext allocationcontext;

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
	public AllocationContext getAllocationcontext() {
		if (allocationcontext != null && allocationcontext.eIsProxy()) {
			InternalEObject oldAllocationcontext = (InternalEObject)allocationcontext;
			allocationcontext = (AllocationContext)eResolveProxy(oldAllocationcontext);
			if (allocationcontext != oldAllocationcontext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RepositorydecoratorPackage.ALLOCATION_CONTEXT_RESULTS__ALLOCATIONCONTEXT, oldAllocationcontext, allocationcontext));
			}
		}
		return allocationcontext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllocationContext basicGetAllocationcontext() {
		return allocationcontext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllocationcontext(AllocationContext newAllocationcontext) {
		AllocationContext oldAllocationcontext = allocationcontext;
		allocationcontext = newAllocationcontext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositorydecoratorPackage.ALLOCATION_CONTEXT_RESULTS__ALLOCATIONCONTEXT, oldAllocationcontext, allocationcontext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RepositorydecoratorPackage.ALLOCATION_CONTEXT_RESULTS__ALLOCATIONCONTEXT:
				if (resolve) return getAllocationcontext();
				return basicGetAllocationcontext();
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
			case RepositorydecoratorPackage.ALLOCATION_CONTEXT_RESULTS__ALLOCATIONCONTEXT:
				setAllocationcontext((AllocationContext)newValue);
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
			case RepositorydecoratorPackage.ALLOCATION_CONTEXT_RESULTS__ALLOCATIONCONTEXT:
				setAllocationcontext((AllocationContext)null);
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
			case RepositorydecoratorPackage.ALLOCATION_CONTEXT_RESULTS__ALLOCATIONCONTEXT:
				return allocationcontext != null;
		}
		return super.eIsSet(featureID);
	}

} //AllocationContextResultsImpl
