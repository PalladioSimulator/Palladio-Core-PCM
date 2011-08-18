/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.impl;

import de.uka.ipd.sdq.pcm.allocation.AllocationContext;

import de.uka.ipd.sdq.pcm.designdecision.ExchangeComponentRule;
import de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage;

import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Exchange Component Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.impl.ExchangeComponentRuleImpl#getRepositoryComponent <em>Repository Component</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.impl.ExchangeComponentRuleImpl#getAllocationContext <em>Allocation Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExchangeComponentRuleImpl extends EObjectImpl implements ExchangeComponentRule {
	/**
	 * The cached value of the '{@link #getRepositoryComponent() <em>Repository Component</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryComponent()
	 * @generated
	 * @ordered
	 */
	protected EList<RepositoryComponent> repositoryComponent;

	/**
	 * The cached value of the '{@link #getAllocationContext() <em>Allocation Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllocationContext()
	 * @generated
	 * @ordered
	 */
	protected AllocationContext allocationContext;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExchangeComponentRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return designdecisionPackage.Literals.EXCHANGE_COMPONENT_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RepositoryComponent> getRepositoryComponent() {
		if (repositoryComponent == null) {
			repositoryComponent = new EObjectResolvingEList<RepositoryComponent>(RepositoryComponent.class, this, designdecisionPackage.EXCHANGE_COMPONENT_RULE__REPOSITORY_COMPONENT);
		}
		return repositoryComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllocationContext getAllocationContext() {
		if (allocationContext != null && allocationContext.eIsProxy()) {
			InternalEObject oldAllocationContext = (InternalEObject)allocationContext;
			allocationContext = (AllocationContext)eResolveProxy(oldAllocationContext);
			if (allocationContext != oldAllocationContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, designdecisionPackage.EXCHANGE_COMPONENT_RULE__ALLOCATION_CONTEXT, oldAllocationContext, allocationContext));
			}
		}
		return allocationContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllocationContext basicGetAllocationContext() {
		return allocationContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllocationContext(AllocationContext newAllocationContext) {
		AllocationContext oldAllocationContext = allocationContext;
		allocationContext = newAllocationContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, designdecisionPackage.EXCHANGE_COMPONENT_RULE__ALLOCATION_CONTEXT, oldAllocationContext, allocationContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case designdecisionPackage.EXCHANGE_COMPONENT_RULE__REPOSITORY_COMPONENT:
				return getRepositoryComponent();
			case designdecisionPackage.EXCHANGE_COMPONENT_RULE__ALLOCATION_CONTEXT:
				if (resolve) return getAllocationContext();
				return basicGetAllocationContext();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case designdecisionPackage.EXCHANGE_COMPONENT_RULE__REPOSITORY_COMPONENT:
				getRepositoryComponent().clear();
				getRepositoryComponent().addAll((Collection<? extends RepositoryComponent>)newValue);
				return;
			case designdecisionPackage.EXCHANGE_COMPONENT_RULE__ALLOCATION_CONTEXT:
				setAllocationContext((AllocationContext)newValue);
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
			case designdecisionPackage.EXCHANGE_COMPONENT_RULE__REPOSITORY_COMPONENT:
				getRepositoryComponent().clear();
				return;
			case designdecisionPackage.EXCHANGE_COMPONENT_RULE__ALLOCATION_CONTEXT:
				setAllocationContext((AllocationContext)null);
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
			case designdecisionPackage.EXCHANGE_COMPONENT_RULE__REPOSITORY_COMPONENT:
				return repositoryComponent != null && !repositoryComponent.isEmpty();
			case designdecisionPackage.EXCHANGE_COMPONENT_RULE__ALLOCATION_CONTEXT:
				return allocationContext != null;
		}
		return super.eIsSet(featureID);
	}

} //ExchangeComponentRuleImpl
