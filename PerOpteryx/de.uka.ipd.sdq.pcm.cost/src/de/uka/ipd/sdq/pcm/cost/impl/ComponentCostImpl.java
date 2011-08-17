/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.cost.impl;

import de.uka.ipd.sdq.pcm.cost.ComponentCost;
import de.uka.ipd.sdq.pcm.cost.costPackage;

import de.uka.ipd.sdq.pcm.repository.RepositoryComponent;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Cost</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.impl.ComponentCostImpl#getComponentOperatingCost <em>Component Operating Cost</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.impl.ComponentCostImpl#getComponentInitialCost <em>Component Initial Cost</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.impl.ComponentCostImpl#getRepositoryComponent <em>Repository Component</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentCostImpl extends CostImpl implements ComponentCost {
	/**
	 * The default value of the '{@link #getComponentOperatingCost() <em>Component Operating Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentOperatingCost()
	 * @generated
	 * @ordered
	 */
	protected static final double COMPONENT_OPERATING_COST_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getComponentOperatingCost() <em>Component Operating Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentOperatingCost()
	 * @generated
	 * @ordered
	 */
	protected double componentOperatingCost = COMPONENT_OPERATING_COST_EDEFAULT;

	/**
	 * The default value of the '{@link #getComponentInitialCost() <em>Component Initial Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentInitialCost()
	 * @generated
	 * @ordered
	 */
	protected static final double COMPONENT_INITIAL_COST_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getComponentInitialCost() <em>Component Initial Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentInitialCost()
	 * @generated
	 * @ordered
	 */
	protected double componentInitialCost = COMPONENT_INITIAL_COST_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRepositoryComponent() <em>Repository Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryComponent()
	 * @generated
	 * @ordered
	 */
	protected RepositoryComponent repositoryComponent;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentCostImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return costPackage.Literals.COMPONENT_COST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getComponentOperatingCost() {
		return componentOperatingCost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentOperatingCost(double newComponentOperatingCost) {
		double oldComponentOperatingCost = componentOperatingCost;
		componentOperatingCost = newComponentOperatingCost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, costPackage.COMPONENT_COST__COMPONENT_OPERATING_COST, oldComponentOperatingCost, componentOperatingCost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getComponentInitialCost() {
		return componentInitialCost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentInitialCost(double newComponentInitialCost) {
		double oldComponentInitialCost = componentInitialCost;
		componentInitialCost = newComponentInitialCost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, costPackage.COMPONENT_COST__COMPONENT_INITIAL_COST, oldComponentInitialCost, componentInitialCost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepositoryComponent getRepositoryComponent() {
		if (repositoryComponent != null && repositoryComponent.eIsProxy()) {
			InternalEObject oldRepositoryComponent = (InternalEObject)repositoryComponent;
			repositoryComponent = (RepositoryComponent)eResolveProxy(oldRepositoryComponent);
			if (repositoryComponent != oldRepositoryComponent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, costPackage.COMPONENT_COST__REPOSITORY_COMPONENT, oldRepositoryComponent, repositoryComponent));
			}
		}
		return repositoryComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepositoryComponent basicGetRepositoryComponent() {
		return repositoryComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepositoryComponent(RepositoryComponent newRepositoryComponent) {
		RepositoryComponent oldRepositoryComponent = repositoryComponent;
		repositoryComponent = newRepositoryComponent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, costPackage.COMPONENT_COST__REPOSITORY_COMPONENT, oldRepositoryComponent, repositoryComponent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case costPackage.COMPONENT_COST__COMPONENT_OPERATING_COST:
				return getComponentOperatingCost();
			case costPackage.COMPONENT_COST__COMPONENT_INITIAL_COST:
				return getComponentInitialCost();
			case costPackage.COMPONENT_COST__REPOSITORY_COMPONENT:
				if (resolve) return getRepositoryComponent();
				return basicGetRepositoryComponent();
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
			case costPackage.COMPONENT_COST__COMPONENT_OPERATING_COST:
				setComponentOperatingCost((Double)newValue);
				return;
			case costPackage.COMPONENT_COST__COMPONENT_INITIAL_COST:
				setComponentInitialCost((Double)newValue);
				return;
			case costPackage.COMPONENT_COST__REPOSITORY_COMPONENT:
				setRepositoryComponent((RepositoryComponent)newValue);
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
			case costPackage.COMPONENT_COST__COMPONENT_OPERATING_COST:
				setComponentOperatingCost(COMPONENT_OPERATING_COST_EDEFAULT);
				return;
			case costPackage.COMPONENT_COST__COMPONENT_INITIAL_COST:
				setComponentInitialCost(COMPONENT_INITIAL_COST_EDEFAULT);
				return;
			case costPackage.COMPONENT_COST__REPOSITORY_COMPONENT:
				setRepositoryComponent((RepositoryComponent)null);
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
			case costPackage.COMPONENT_COST__COMPONENT_OPERATING_COST:
				return componentOperatingCost != COMPONENT_OPERATING_COST_EDEFAULT;
			case costPackage.COMPONENT_COST__COMPONENT_INITIAL_COST:
				return componentInitialCost != COMPONENT_INITIAL_COST_EDEFAULT;
			case costPackage.COMPONENT_COST__REPOSITORY_COMPONENT:
				return repositoryComponent != null;
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
		result.append(" (componentOperatingCost: ");
		result.append(componentOperatingCost);
		result.append(", componentInitialCost: ");
		result.append(componentInitialCost);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	@Override
	public double getOperatingCost() {
		return this.getComponentOperatingCost();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated not
	 */
	@Override
	public double getInitialCost() {
		return this.getComponentInitialCost();
	}
	
	/**
	 * @generated not
	 */
	@Override
	public EObject basicGetAnnotatedElement() {
		return this.getRepositoryComponent();
	}
	
} //ComponentCostImpl
